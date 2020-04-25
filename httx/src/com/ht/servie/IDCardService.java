package com.ht.servie;

import com.ht.model.IDCard;
import com.ht.model.PageResult;
import com.ht.util.HTException;

public interface IDCardService {

	PageResult<IDCard> listPage(IDCard idCard);
	
	void delete(int id);
	
	void add(IDCard idCard) throws HTException;
	
	IDCard getByCardNo(String cardNo);
}
