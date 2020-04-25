package com.ht.servie;

import java.util.List;

import com.ht.model.OrderGoods;
import com.ht.model.OrderGoodsDetail;
import com.ht.model.PageResult;
import com.ht.model.UIReturn;

public interface OrderGoodsService {

	OrderGoods getByKey(int id);

	UIReturn save(OrderGoods orderEntity);

	UIReturn delete(int id);

	UIReturn saveEdit(OrderGoods orderGoodsEntity);
	
	List<OrderGoods> selectByExample(String ids );
	
	PageResult<OrderGoodsDetail> listOrderGoodsDetailByOrderId(String orderid);
}
