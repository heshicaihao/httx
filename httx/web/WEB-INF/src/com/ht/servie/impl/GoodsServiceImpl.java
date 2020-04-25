package com.ht.servie.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ht.mapper.GoodsMapper;
import com.ht.model.Goods;
import com.ht.model.GoodsExample;
import com.ht.model.PageResult;
import com.ht.model.UIReturn;
import com.ht.model.GoodsExample.Criteria;
import com.ht.servie.GoodsService;
import com.ht.util.Const;

@Service
public class GoodsServiceImpl implements GoodsService {

	private static final Logger log = LoggerFactory.getLogger(GoodsServiceImpl.class);
	
	@Autowired
	private GoodsMapper goodsMapper;
	

	
	@Override
	public UIReturn save(Goods goodsEntity) {
		Integer instkey = goodsEntity.getId();
		String gName = goodsEntity.getGname();
		UIReturn rtn = new UIReturn();
		GoodsExample exp = new GoodsExample();
		Criteria cri = exp.createCriteria(); 
		cri.andGmodelEqualTo(gName);
		List<Goods> oldList = goodsMapper.selectByExample(exp);
		if(oldList.size() > 0){
			Goods old = oldList.get(0);
				if(!old.getGname().equals(gName)){
				rtn.setSuccess(false);
				rtn.setCode(Const.EXIST);
				rtn.setErrorMsg(String.format("商品名称 [%s] 已经存在!请不要重复添加!", old.getId()));
				return rtn;
			}
		}
		if(instkey != null){
			goodsMapper.updateByPrimaryKeySelective(goodsEntity);
		}else{		
			goodsMapper.insert(goodsEntity);
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
			if(goods.getStartDate()!=null &&goods.getEndDate()!=null){
				cri.andAppdateBetween(goods.getStartDate(), goods.getEndDate());
			}else{
				goods.setAppdate(null);
			}
			
			
			result.setRows(goodsMapper.selectByExample(exp));
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

	

}
