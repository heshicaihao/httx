package com.ht.servie;

import com.ht.model.Goods;
import com.ht.model.PageResult;
import com.ht.model.UIReturn;

public interface GoodsService {


	
	 Goods getByKey(Integer instkey);
	
    PageResult<Goods> listPage(Goods goods);
	UIReturn save(Goods goodsEntity);
    UIReturn delete(int id);
}
