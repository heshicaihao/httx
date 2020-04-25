package com.ht.servie;

import com.ht.model.Ewaybill;
import com.ht.model.UIReturn;

public interface EWaybillService {

	Ewaybill getByKey(String id);

	UIReturn save(Ewaybill ewaybillEntity);
	
	UIReturn updateByPrimaryKeySelective(Ewaybill ewaybillEntity);
	
	int deleteByPrimaryKey(Integer id);
}
