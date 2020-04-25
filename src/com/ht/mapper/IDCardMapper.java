package com.ht.mapper;

import java.util.List;

import com.ht.model.IDCard;

public interface IDCardMapper {

	List<IDCard> listPage(IDCard idCard);
	int count(IDCard idCard);
	void add(IDCard idCard);
	void del(int id);
	IDCard getByName(String name);
	IDCard getByCardNo(String cardNo);
}
