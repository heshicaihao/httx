package com.ht.model;

import java.util.List;

public class InternationalTrade {

	private String sysdate;
	private List<Goods> goods;
	private String companyRegistNo;
	private String inspectionRegistNo;
	public String getSysdate() {
		return sysdate;
	}
	public void setSysdate(String sysdate) {
		this.sysdate = sysdate;
	}
	public List<Goods> getGoods() {
		return goods;
	}
	public void setGoods(List<Goods> goods) {
		this.goods = goods;
	}
	public String getCompanyRegistNo() {
		return companyRegistNo;
	}
	public void setCompanyRegistNo(String companyRegistNo) {
		this.companyRegistNo = companyRegistNo;
	}
	public String getInspectionRegistNo() {
		return inspectionRegistNo;
	}
	public void setInspectionRegistNo(String inspectionRegistNo) {
		this.inspectionRegistNo = inspectionRegistNo;
	}
	
	
}
