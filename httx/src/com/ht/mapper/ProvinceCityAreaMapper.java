package com.ht.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ht.model.ProvinceCityArea;

public interface ProvinceCityAreaMapper {
	List<ProvinceCityArea> listAllProvinces();
	List<ProvinceCityArea> listCitiesByProvinceId(@Param("parentId")Integer parentId);
	List<ProvinceCityArea> listAreasByCityId(@Param("parentId") Integer parentId);
	List<ProvinceCityArea> listAll();
}