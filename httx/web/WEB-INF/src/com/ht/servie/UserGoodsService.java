package com.ht.servie;

import com.ht.model.PageResult;
import com.ht.model.UIReturn;
import com.ht.model.UserGoods;
import com.ht.util.HTException;

public interface UserGoodsService {

	PageResult<UserGoods> listPage(UserGoods userGoods);
	
	void add(UserGoods userGoods);
	
	void update(UserGoods userGoods) throws HTException;
	
	UIReturn delete(String instkey);
	
	UserGoods getByKey(String instkey);
}
