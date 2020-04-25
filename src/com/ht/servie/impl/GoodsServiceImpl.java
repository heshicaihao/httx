package com.ht.servie.impl;

import java.io.InputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.web.multipart.MultipartFile;

import com.ht.excel.Excel2003Reader;
import com.ht.excel.GoodsXlsRowReader;
import com.ht.mapper.DictDataMapper;
import com.ht.mapper.GoodsMapper;
import com.ht.model.Goods;
import com.ht.model.GoodsExample;
import com.ht.model.GoodsExample.Criteria;
import com.ht.model.PageResult;
import com.ht.model.UIGoodsImport;
import com.ht.model.UIReturn;
import com.ht.model.UserGoods;
import com.ht.servie.GoodsService;
import com.ht.util.Config;
import com.ht.util.Const;
import com.ht.util.FileUtil;
import com.ht.util.HTException;
import com.ht.util.StringUtil;

@Service
public class GoodsServiceImpl implements GoodsService {

	private static final Logger log = LoggerFactory.getLogger(GoodsServiceImpl.class);
	
	@Autowired
	private GoodsMapper goodsMapper;
	
	@Autowired
	private Config config;
	
	@Autowired
	private DictDataMapper dictMapper;
	
	@Autowired
	private PlatformTransactionManager transactionManager;

	@Autowired
	private SqlSessionFactory sqlSessionFactory;
	
	@Override
	@Transactional(rollbackFor={Throwable.class})
	public UIReturn save(Goods goodsEntity) {
		Integer instkey = goodsEntity.getId();
		UIReturn rtn = new UIReturn();
		GoodsExample exp = new GoodsExample();
		Criteria cri = exp.createCriteria(); 
		cri.andGnameEqualTo(goodsEntity.getGname());
		cri.andGmodelEqualTo(goodsEntity.getGmodel());
		cri.andCopgnoEqualTo(goodsEntity.getCopgno());
		cri.andCreateuseridEqualTo(goodsEntity.getCreateuserid());
		List<Goods> oldList = goodsMapper.selectByExample(exp);
		if(oldList.size() > 0){
			Goods old = oldList.get(0);
			if(!old.getId().equals(goodsEntity.getId())){
				rtn.setSuccess(false);
				rtn.setCode(Const.EXIST);
				rtn.setErrorMsg(String.format("商品名称 [%s, %s, %s] 已经存在!请不要重复添加!", old.getGname(),goodsEntity.getCopgno(),goodsEntity.getGmodel()));
				return rtn;
			}
		}
		if(instkey != null){
			goodsMapper.updateByPrimaryKeySelective(goodsEntity);
		}else{		
			instkey = goodsMapper.insert(goodsEntity);
			UserGoods ug = new UserGoods();
			ug.setGoodsId(goodsEntity.getId());
			ug.setUserKey(goodsEntity.getCreateuserid());
			UserGoods existing = goodsMapper.getUserGoods(ug);
			if(null == existing){
				int userGoodsCount = goodsMapper.getUserGoodsSeq(goodsEntity.getCreateuserid());
				ug.setUserGoodsCode(StringUtil.formatCode(3, ug.getUserKey()) + StringUtil.formatCode(4, userGoodsCount));
				goodsMapper.addUserGoods(ug);
			}
		}
		rtn.setCode(Const.UI_SUCCESS);
		rtn.setSuccess(true);
		return rtn;
	}
	
	@Override
	public Goods getByKey(Integer instkey) {
		// TODO Auto-generated method stub
		return goodsMapper.selectByPrimaryKey(instkey);
	}
	
	@Override
	public PageResult<Goods> listPage(Goods goods) {
		PageResult<Goods> result = new PageResult<Goods>();
		try{
			GoodsExample exp = new GoodsExample();
			Criteria cri = exp.createCriteria(); 
			
			if(!StringUtil.isEmpty(goods.getStartDate())){
				cri.andAppdateGreaterThanOrEqualTo(StringUtil.string2DateTime(goods.getStartDate()));
			}
			if(!StringUtil.isEmpty(goods.getEndDate())){
				cri.andAppdateLessThanOrEqualTo(StringUtil.string2DateTime(goods.getEndDate()));
			}
			
			if(null != goods.getCreateuserid()){
				cri.andCreateuseridEqualTo(goods.getCreateuserid());
			}
			exp.setOffset(goods.getOffset());
			exp.setRows(goods.getRows());
			result.setRows(goodsMapper.selectByExample2(exp));
			result.setTotal(goodsMapper.countByExample(exp));
		}catch(Exception ex){
			log.error("List Product page fail.",ex);
			result.setErrmsg(ex.getMessage());
		}
		return result;
	}


	@Override
	public UIReturn delete(int id) {
		UIReturn rtn = new UIReturn();
		try{
				goodsMapper.deleteByPrimaryKey(id);
				rtn.setCode(Const.UI_SUCCESS);
		}catch(Exception ex){
			rtn.setCode(Const.UI_ERROR);
			rtn.setSuccess(false);
			rtn.setErrorMsg(ex.getMessage());
			log.error("删除商品信息失败！id=" + id,ex);
		}
		return rtn;
	}



	@Override
	public List<Goods> listGoodsByUserKey(int userKey) {
		return goodsMapper.getGoodsByUserId(userKey);
	}	

	@Override
	public void importFile(MultipartFile file, HttpServletRequest req)
			throws Exception {
		int custId = Integer.parseInt(req.getParameter("importUser"));
		String transInstKey = StringUtil.createId();
		InputStream is = file.getInputStream();
		FileUtil.saveAsFile(is,transInstKey,config.getImportGoodsFolder());
		is = FileUtil.getFileInputStream(config.getImportGoodsFolder(),transInstKey);
		Excel2003Reader excel03 = new Excel2003Reader();
		GoodsXlsRowReader reader = new GoodsXlsRowReader();
		reader.setCountryMap(dictMapper.listAllCountries());
		reader.setCurrMap(dictMapper.listAllCurrency());
		reader.setUnitMap(dictMapper.listAllUnits());
		excel03.setRowReader(reader);
		excel03.process(is);
		List<Goods> datas = reader.getDatas();
		if(!StringUtil.isEmpty(datas)){
			TransactionDefinition definition = new DefaultTransactionDefinition(TransactionDefinition.PROPAGATION_REQUIRED);
			TransactionStatus status = transactionManager.getTransaction(definition);
			UIGoodsImport ui = null;
			try {
				SqlSession session = sqlSessionFactory.openSession(ExecutorType.BATCH,false);
				GoodsMapper uiMaper = session.getMapper(GoodsMapper.class);
				int count = datas.size();
				Goods tmp = null;
				for(int i = 0; i < count; i++){
					ui = new UIGoodsImport();
					tmp = datas.get(i);
					ui.setCopGNo(tmp.getCopgno());
					ui.setGmodel(tmp.getGmodel());
					ui.setGname(tmp.getGname());
					ui.setUserkey(custId);
					ui.setTransInstkey(transInstKey);
					uiMaper.addUIImport(ui);
					if((i+1) % 500 == 0){
						session.commit();
						session.clearCache();
					}
				}
				if((count+1)%500 > 0){
					session.commit();
					session.clearCache();
				}
				log.debug("Finish import Goods, import total:" + count);
				session.close();
				transactionManager.commit(status);
			} catch (Exception ex) {
				transactionManager.rollback(status);
				throw new IllegalStateException(ex);
			}
			List<UIGoodsImport> checkList = goodsMapper.checkExistence(transInstKey);
			if(!StringUtil.isEmpty(checkList)){
				StringBuffer sb = new StringBuffer();
				
				for(int i = 0, count = checkList.size(); i < count; i++){
					ui = checkList.get(i);
					sb.append(ui.getGname()).append(" ").append(ui.getCopGNo()).append(" ").append(ui.getGmodel());
					if(i != count - 1){
						sb.append("<br />");
					}
				}
				goodsMapper.cleanGoodsUI(transInstKey);
				throw new HTException("以下商品信息已经存在，请不要重复导入：" + sb.toString());
			}
			Goods goods = null;
			TransactionDefinition definition2 = new DefaultTransactionDefinition(TransactionDefinition.PROPAGATION_REQUIRED);
			TransactionStatus status2 = transactionManager.getTransaction(definition2);
			try{
				for(int i = 0, count = datas.size(); i < count; i++){
					goods = datas.get(i);
					goods.setCreateuserid(custId);
					goodsMapper.insert(goods);
					UserGoods ug = new UserGoods();
					ug.setGoodsId(goods.getId());
					ug.setUserKey(custId);
					UserGoods existing = goodsMapper.getUserGoods(ug);
					if(null == existing){
						int userGoodsCount = goodsMapper.getUserGoodsSeq(custId);
						ug.setUserGoodsCode(StringUtil.formatCode(3, ug.getUserKey()) + StringUtil.formatCode(4, userGoodsCount));
						goodsMapper.addUserGoods(ug);
					}
				}
				goodsMapper.cleanGoodsUI(transInstKey);
				transactionManager.commit(status2);
			} catch (Exception ex) {
				transactionManager.rollback(status2);
				throw new IllegalStateException(ex);
			}
		}
	}

	@Override
	public List<Goods> listGoodsByUserKeyNameLike(int userKey, String nameLike) {
		if(!StringUtil.isEmpty(nameLike)){
			return goodsMapper.getGoodsByUserIdNameLike(userKey, "%" + nameLike.trim().toUpperCase() + "%");
		}
		return goodsMapper.getGoodsByUserId(userKey);
	}

}
