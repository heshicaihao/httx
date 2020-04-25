package com.ht.servie;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

import com.ht.model.OrderInfo;
import com.ht.model.PageResult;
import com.ht.model.UIReturn;

public interface OrderService {

	OrderInfo getByKey(String orderid);

	PageResult<OrderInfo> listPage(OrderInfo order);

	UIReturn save(OrderInfo orderEntity);

	UIReturn delete(String orderid);
	
	UIReturn cancel(String orderid);

	UIReturn saveEdit(OrderInfo orderEntity);
	
	List<OrderInfo> selectByExample(String ids );
	
	UIReturn released(String orderid,int userid);
	
	UIReturn updateOrderStatus(String orderid);
	
	UIReturn importFile(MultipartFile file, HttpServletRequest req) throws Exception;
	
	int getOrderflowNo(int customerId);
	
	int updatePickupNoByExample(String pickgoodsno,String ids);
	
	public UIReturn releasedByTransactional(String ids,int userid) throws Exception ;
}
