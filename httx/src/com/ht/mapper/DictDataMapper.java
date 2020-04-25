package com.ht.mapper;

import java.util.List;

import com.ht.model.DictData;

public interface DictDataMapper {
	List<DictData> listAllCountries();
	List<DictData> listAllUnits();
	List<DictData> listAllCurrency();
}