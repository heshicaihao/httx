package com.ht.model;

import java.util.Map;

public class ProvinceCityArea {

	private int id;
	
	private String name;
	
	private int parentId;
	
	private int areaId;
	private String areaName;
	private int cityId;
	private String cityName;
	private int provinceId;
	private String provinceName;
	
	private Map<String,ProvinceCityArea> chrildrenMap;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getParentId() {
		return parentId;
	}

	public void setParentId(int parentId) {
		this.parentId = parentId;
	}

	public int getAreaId() {
		return areaId;
	}

	public void setAreaId(int areaId) {
		this.areaId = areaId;
	}

	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	public int getCityId() {
		return cityId;
	}

	public void setCityId(int cityId) {
		this.cityId = cityId;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public int getProvinceId() {
		return provinceId;
	}

	public void setProvinceId(int provinceId) {
		this.provinceId = provinceId;
	}

	public String getProvinceName() {
		return provinceName;
	}

	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}

	public Map<String, ProvinceCityArea> getChrildrenMap() {
		return chrildrenMap;
	}

	public void setChrildrenMap(Map<String, ProvinceCityArea> chrildrenMap) {
		this.chrildrenMap = chrildrenMap;
	}
}
