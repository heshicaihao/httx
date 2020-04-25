package com.ht.servie;

import java.util.List;

import com.ht.model.Ewaybill;
import com.ht.model.LoadingGoods;
import com.ht.model.LoadingInfo;
import com.ht.model.LoadingOrder;
import com.ht.model.OrderInfo;
import com.ht.model.UIReturn;
import com.ht.util.HTException;

public interface LoadingService {
    
	LoadingInfo getByKey(String id);

    LoadingGoods getLoadingGoodsByKey(String id);
    
    
	List<OrderInfo> selectByExample(String ids );
	

	List<LoadingOrder> listPage(OrderInfo order); 

	UIReturn save(LoadingInfo loadingInfo);
	UIReturn saveLoadingGoods(LoadingGoods loadingGoods);
	UIReturn delete(String orderid);
	
	UIReturn cancel(String orderid);

	UIReturn saveEdit(OrderInfo orderEntity);
	
	
	 List<Ewaybill> selectEwayByExample(String ids);
	 List<OrderInfo> selectGoodsByExample(String orderIds);
	 List<LoadingGoods> selectLoadingGoodsByExample(String ids);
	 List<LoadingGoods> getDetails(List<String> orderIdlist);
	 List<LoadingGoods>  getLoadingIds(List<String> orderIdlist);
	 
	 void closeOrder(String orderId) throws HTException;
}
