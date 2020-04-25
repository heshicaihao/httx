package com.ht.servie.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ht.mapper.OrderGoodsMapper;
import com.ht.model.OrderGoods;
import com.ht.model.OrderGoodsDetail;
import com.ht.model.OrderGoodsExample;
import com.ht.model.PageResult;
import com.ht.model.UIReturn;
import com.ht.servie.OrderGoodsService;
import com.ht.util.Const;

@Service
public class OrderGoodsServiceImpl implements OrderGoodsService {

	private static final Logger log = LoggerFactory.getLogger(OrderGoodsServiceImpl.class);
	
	@Autowired
	private OrderGoodsMapper orderGoodsMapper;
	

	
	@Override
	public UIReturn save(OrderGoods orderGoodsEntity){

		UIReturn rtn = new UIReturn();

		orderGoodsMapper.insert(orderGoodsEntity);

		rtn.setCode(Const.UI_SUCCESS);
		rtn.setRtnKey(orderGoodsEntity.getOrderid());
		rtn.setSuccess(true);
		return rtn;
	}

	@Override
	public UIReturn saveEdit(OrderGoods orderEntity){
		UIReturn rtn = new UIReturn();
		
		orderGoodsMapper.updateByPrimaryKeySelective(orderEntity);

		rtn.setCode(Const.UI_SUCCESS);
		rtn.setSuccess(true);
		return rtn;
	}

	@Override
	public OrderGoods getByKey(int id) {
		// TODO Auto-generated method stub
		return orderGoodsMapper.selectByPrimaryKey(id);
	}



	@Override
	public UIReturn delete(int id) {
		UIReturn rtn = new UIReturn();
		try{
			orderGoodsMapper.deleteByPrimaryKey(id);
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
	public List<OrderGoods> selectByExample(String orderid) {

		try {
			OrderGoodsExample exp = new OrderGoodsExample();
			OrderGoodsExample.Criteria cri = exp.createCriteria();
			cri.andOrderidEqualTo(orderid);
			return orderGoodsMapper.selectByExample(exp);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	
	}

	@Override
	public PageResult<OrderGoodsDetail> listOrderGoodsDetailByOrderId(String orderid) {
		PageResult<OrderGoodsDetail> result = new PageResult<OrderGoodsDetail>();
		try {
			List<OrderGoodsDetail> rows = orderGoodsMapper.getDetails(orderid);
			result.setRows(rows);
			result.setTotal(rows.size());
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
		
	}	

}
