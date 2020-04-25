package com.ht.servie.impl;

import java.io.InputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

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
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.web.multipart.MultipartFile;

import com.ht.excel.Excel2003Reader;
import com.ht.excel.XlsRowReader;
import com.ht.mapper.GoodsMapper;
import com.ht.mapper.IntEntrepotDetailMapper;
import com.ht.mapper.IntEntrepotMapper;
import com.ht.model.Account;
import com.ht.model.Goods;
import com.ht.model.IntEntrepot;
import com.ht.model.IntEntrepotDetail;
import com.ht.model.IntEntrepotExample;
import com.ht.model.IntEntrepotExample.Criteria;
import com.ht.model.PageResult;
import com.ht.model.UIReturn;
import com.ht.servie.IntEntrepotService;
import com.ht.util.Config;
import com.ht.util.Const;
import com.ht.util.FileUtil;
import com.ht.util.HTException;
import com.ht.util.StringUtil;

@Service
public class IntEntrepotServiceImpl implements IntEntrepotService {

	private static final Logger log = LoggerFactory.getLogger(IntEntrepotServiceImpl.class);
	
	@Autowired
	private IntEntrepotMapper intEntrepotMapper;
	@Autowired
    private IntEntrepotDetailMapper intEntrepotDetailMapper;
	
	@Autowired
	private Config config;
	
	@Autowired
	private GoodsMapper goodsMapper;
	
	@Autowired
	private PlatformTransactionManager transactionManager;

	@Autowired
	private SqlSessionFactory sqlSessionFactory;

	
	@Override
	public UIReturn save(IntEntrepot intEntrepotEntity) {
		Integer instkey = intEntrepotEntity.getId();
		UIReturn rtn = new UIReturn();
		if(instkey != null){
			intEntrepotMapper.updateByPrimaryKeySelective(intEntrepotEntity);
		}else{
			String maxSeq = intEntrepotMapper.getMaxUserSeq(intEntrepotEntity.getCustid());
			if(!StringUtil.isEmpty(maxSeq)){
				maxSeq = StringUtil.incrementSeq(maxSeq);
			}else{
				maxSeq = "R" + StringUtil.formatCode(3, intEntrepotEntity.getCustid()) + "0001";
			}
			intEntrepotEntity.setNo(maxSeq);
			intEntrepotMapper.insert(intEntrepotEntity);
		}
		rtn.setCode(Const.UI_SUCCESS);
		rtn.setSuccess(true);
		rtn.setRtnKey(intEntrepotEntity.getId().toString());
		return rtn;
	}
	@Override
	public IntEntrepot getByKey(Integer instkey) {
		// TODO Auto-generated method stub
		return intEntrepotMapper.selectByPrimaryKey(instkey);
	}

	@Override
	public PageResult<IntEntrepot> listPage(IntEntrepot intEntrepot) {
		PageResult<IntEntrepot> result = new PageResult<IntEntrepot>();
		try{
			IntEntrepotExample exp = new IntEntrepotExample();
			Criteria cri = exp.createCriteria();
			if(!StringUtil.isEmpty(intEntrepot.getStartDateStr())){
				cri.andWritedateGreaterThanOrEqualTo(StringUtil.string2DateTime(intEntrepot.getStartDateStr()));
			}
			if(!StringUtil.isEmpty(intEntrepot.getEndDateStr())){
				cri.andWritedateLessThanOrEqualTo(StringUtil.string2DateTime(intEntrepot.getEndDateStr()));
			}
			if(!StringUtil.isEmpty(intEntrepot.getNo())){
				cri.andNoLike(intEntrepot.getNoLike());
			}
			exp.setOffset(intEntrepot.getOffset());
			exp.setRows(intEntrepot.getRows());
			result.setRows(intEntrepotMapper.selectByExample(exp));
			result.setTotal(intEntrepotMapper.countByExample(exp));
		}catch(Exception ex){
			log.error("List Product page fail.",ex);
			result.setErrmsg(ex.getMessage());
		}
		return result;
	}
	@Override
	public PageResult<IntEntrepotDetail> listIntEntrepotDetailByIntEntrepotId(Integer id) {
		PageResult<IntEntrepotDetail> result = new PageResult<IntEntrepotDetail>();
		try{
			List<IntEntrepotDetail> rows = intEntrepotDetailMapper.getDetails(id);
			result.setRows(rows);
			result.setTotal(rows.size());
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
			Integer inventory = 0;
			try{
				inventory = intEntrepotMapper.getInventoryById(id);
			}catch(Exception ex){
				intEntrepotMapper.deleteByPrimaryKey(id);
				rtn.setCode(Const.UI_SUCCESS);
			}
			if(null != inventory && inventory.intValue() > 0){
				throw new IllegalStateException("该入库单中的商品已经入库，不能删除入库单!");
			}
			intEntrepotMapper.deleteByPrimaryKey(id);
			rtn.setCode(Const.UI_SUCCESS);
		}catch(Exception ex){
			rtn.setCode(Const.UI_ERROR);
			rtn.setSuccess(false);
			rtn.setErrorMsg(ex.getMessage());
			log.error("删除入库单失败！id=" + id,ex);
		}
		return rtn;
	}	
	
	@Override
	public UIReturn deleteDetails(int id) {
		UIReturn rtn = new UIReturn();
		try{
			IntEntrepotDetail exists = intEntrepotDetailMapper.selectByPrimaryKey(id);
			if(null != exists.getActNo() && exists.getActNo() > 0){
				throw new IllegalArgumentException("该商品已经入库，无法删除!");
			}
			intEntrepotDetailMapper.deleteByPrimaryKey(id);
			rtn.setCode(Const.UI_SUCCESS);
		}catch(Exception ex){
			rtn.setCode(Const.UI_ERROR);
			rtn.setSuccess(false);
			rtn.setErrorMsg(ex.getMessage());
			log.error("删除入库商品信息失败！id=" + id,ex);
		}
		return rtn;
	}

	@Override
	public List<IntEntrepotDetail> get4ExportHGReport(int id) {
		try {
			return intEntrepotDetailMapper.getDetails(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void saveDetails(IntEntrepotDetail intEntrepotDetail){
		Integer intId = intEntrepotDetail.getEntrepotid();
		if(null == intId || intId.intValue() == 0){
			throw new IllegalArgumentException("入库单信息缺失，请重新入库!");
		}
		
		IntEntrepot intEntRepot = intEntrepotMapper.selectByPrimaryKey(intId);
		if(null == intEntRepot){
			throw new IllegalArgumentException("入库单不存在，请重新入库!");
		}
		Integer goodsId = intEntrepotDetail.getGoodsid();
		if(null == goodsId || goodsId.intValue() == 0){
			throw new IllegalArgumentException("入库商品单信息缺失，请重新入库!");
		}
		Goods goods = goodsMapper.selectByPrimaryKey(goodsId);
		if(null == goods){
			throw new IllegalArgumentException("入库商品不存在，请重新选择商品入库!");
		}
		if(null != goods && null!=goods.getActive() && goods.getActive() == 2){
			throw new IllegalArgumentException("入库商品不存在，请重新选择商品入库!");
		}
		BigDecimal unitPriceRmb = BigDecimal.valueOf(Double.parseDouble(goods.getRmb()));
		intEntrepotDetail.setDecprice(unitPriceRmb);
		intEntrepotDetail.setDecltotal(unitPriceRmb.multiply(BigDecimal.valueOf(intEntrepotDetail.getGqty())));
		/*Integer userSeqNo = intEntrepotDetailMapper.getSeqNo(intEntRepot.getCustid());
		if(null == userSeqNo){
			userSeqNo = Integer.valueOf(1);
		}
		intEntrepotDetail.setSeqNo(userSeqNo);*/
		//intEntrepotDetail.setBarCode(StringUtil.createBarCode(intEntRepot.getCustid(), userSeqNo));
		intEntrepotDetailMapper.insert(intEntrepotDetail);
	}

	@Override
	public void saveActNo(Map<String,Object> params) throws HTException {
		
		String idsArrStr = (String)params.get("idsArr");
		List<Integer> idList = new ArrayList<Integer>();
		String[] idsStrArr = idsArrStr.split(",");
		for(String idStr : idsStrArr){
			idList.add(Integer.parseInt(idStr));
		}
		List<IntEntrepotDetail> actNoList = intEntrepotDetailMapper.selectForUpdate((Integer)params.get("hiddenid"),idList);
		if(!StringUtil.isEmpty(actNoList)){
			StringBuffer sb = new StringBuffer();
			sb.append(actNoList.get(0).getUsergoodscode());
			for(int i = 1; i < actNoList.size(); i++){
				sb.append(", ").append(actNoList.get(i).getUsergoodscode());
			}
			throw new HTException("以下商品已经入过库，不允许再次入库!<br />" +sb.toString());
		}
		TransactionDefinition definition = new DefaultTransactionDefinition(TransactionDefinition.PROPAGATION_REQUIRED);
		TransactionStatus status = transactionManager.getTransaction(definition);
		try {
			SqlSession session = sqlSessionFactory.openSession(ExecutorType.BATCH,false);
			IntEntrepotDetailMapper uiMaper = session.getMapper(IntEntrepotDetailMapper.class);
			String userGoodsCodeArrStr = (String)params.get("usergoodsArr");
			String[] userGoodsCodeArr = userGoodsCodeArrStr.split(",");
			String actNoArrStr = (String)params.get("actNoArr");
			String[] actNoStrArr = actNoArrStr.split(",");
			Integer incomeUserId = (Integer)params.get("incomeUserId");
			int count = userGoodsCodeArr.length;
			IntEntrepotDetail d = null;
			int actNo = 0;
			for(int i = 0; i < count; i++){
				actNo = Integer.parseInt(actNoStrArr[i]);
				uiMaper.updateTotalNum(userGoodsCodeArr[i], actNo);
				d = new IntEntrepotDetail();
				d.setIncomeUserId(incomeUserId);
				d.setActNo(actNo);
				d.setBarCode(userGoodsCodeArr[i] + " " + StringUtil.get4Date());
				d.setBatchNo(StringUtil.get4Date());
				d.setId(idList.get(i));
				uiMaper.updateActNo(d);
				if((i+1) % 500 == 0){
					session.commit();
					session.clearCache();
				}
			}
			if((count+1)%500 > 0){
				session.commit();
				session.clearCache();
			}
			session.close();
			transactionManager.commit(status);
		} catch (Exception ex) {
			transactionManager.rollback(status);
			throw new IllegalStateException(ex);
		}
	}

	@Override
	public void importFile(MultipartFile file, HttpServletRequest req)
			throws Exception {
		Account user = (Account)req.getSession().getAttribute(Const.WEB_ACCOUNT);
		String transInstKey = StringUtil.createId();
		InputStream is = file.getInputStream();
		FileUtil.saveAsFile(is,transInstKey,config.getImportIntEntRepotFolder());
		is = FileUtil.getFileInputStream(config.getImportIntEntRepotFolder(),transInstKey);
		Excel2003Reader excel03 = new Excel2003Reader();
		XlsRowReader reader = new XlsRowReader();
		excel03.setRowReader(reader);
		excel03.process(is);
		List<IntEntrepotDetail> datas = reader.getDatas();
		TransactionDefinition definition = new DefaultTransactionDefinition(TransactionDefinition.PROPAGATION_REQUIRED);
		TransactionStatus status = transactionManager.getTransaction(definition);
		try {
			SqlSession session = sqlSessionFactory.openSession(ExecutorType.BATCH,false);
			IntEntrepotDetailMapper uiMaper = session.getMapper(IntEntrepotDetailMapper.class);
			int count = datas.size();
			for(int i = 0; i < count; i++){
				datas.get(i).setTransInstKey(transInstKey);
				uiMaper.addUI(datas.get(i));
				if((i+1) % 500 == 0){
					session.commit();
					session.clearCache();
				}
			}
			if((count+1)%500 > 0){
				session.commit();
				session.clearCache();
			}
			log.debug("Finish import volume, import total:" + count);
			session.close();
			transactionManager.commit(status);
		} catch (Exception ex) {
			transactionManager.rollback(status);
			throw new IllegalStateException(ex);
		}
		int userKey = Integer.parseInt(req.getParameter("importUser"));
		List<String> checkList = intEntrepotDetailMapper.checkUserGoods(userKey,transInstKey);
		if(!StringUtil.isEmpty(checkList)){
			StringBuffer sb = new StringBuffer();
			for(String ugCode : checkList){
				sb.append(ugCode).append(",");
			}
			sb.setLength(sb.length() - 1);
			intEntrepotDetailMapper.cleanUI(transInstKey);
			throw new HTException("商品编号不匹配，请修正后再导入! 不存在的商品编号：" + sb.toString());
		}
		List<String> inactiveList = intEntrepotDetailMapper.checkInactiveGoods(userKey,transInstKey);
		if(!StringUtil.isEmpty(inactiveList)){
			StringBuffer sb = new StringBuffer();
			for(String ugCode : inactiveList){
				sb.append(ugCode).append(",");
			}
			sb.setLength(sb.length() - 1);
			intEntrepotDetailMapper.cleanUI(transInstKey);
			throw new HTException("商品编号已失效，请修正后再导入! 失效的商品编号：" + sb.toString());
		}
		List<IntEntrepotDetail> detailsList = intEntrepotDetailMapper.getDetailsListFromUI(transInstKey);
		if(!StringUtil.isEmpty(detailsList)){
			//create income order
			IntEntrepot inOrder = new IntEntrepot();
			inOrder.setCompanyid(Integer.parseInt(req.getParameter("importCompany")));
			inOrder.setCustid(userKey);
			inOrder.setCreateuserid(user.getId());
			inOrder.setWritedate(Calendar.getInstance().getTime());
			String maxSeq = intEntrepotMapper.getMaxUserSeq(inOrder.getCustid());
			if(!StringUtil.isEmpty(maxSeq)){
				maxSeq = StringUtil.incrementSeq(maxSeq);
			}else{
				maxSeq = "R" + StringUtil.formatCode(3, inOrder.getCustid()) + "0001";
			}
			inOrder.setNo(maxSeq);
			TransactionDefinition definition2 = new DefaultTransactionDefinition(TransactionDefinition.PROPAGATION_REQUIRED);
			TransactionStatus status2 = transactionManager.getTransaction(definition2);
			intEntrepotMapper.insert(inOrder);
			IntEntrepotDetail details = null;
			try{
				for(int i = 0, count = detailsList.size(); i < count; i++){
					details = detailsList.get(i);
					details.setEntrepotid(inOrder.getId());
					BigDecimal unitPriceRmb = BigDecimal.valueOf(Double.parseDouble(details.getRmb()));
					details.setDecprice(unitPriceRmb);
					details.setDecltotal(unitPriceRmb.multiply(BigDecimal.valueOf(details.getGqty())));
					intEntrepotDetailMapper.insert(details);
				}
				transactionManager.commit(status2);
			} catch (Exception ex) {
				transactionManager.rollback(status2);
				throw new IllegalStateException(ex);
			}
		}
		intEntrepotDetailMapper.cleanUI(transInstKey);
	}
	
	
}
