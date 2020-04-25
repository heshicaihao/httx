package com.ht.model.reportmodel;

import java.math.BigDecimal;
import java.util.Date;

public class LoadingHg {
	// 企业内部编号 --
	private String entInsideNo;
	// 申报地海关 --
	private String masterCustoms;
	// 车牌号 --
	private String veName;
	// 装载日期 --
	private Date loadingDate;
	// 备注  --
	private String note;
	// 录入日期 --
	private Date inputDate;
	// 总毛重  --
	private BigDecimal grossWt;
	
	
	
	// 序号 --
	private String listGNo;
	// 清单企业内部编号  --
	private String listEntNo;
	// 收件人姓名 --
	private String receiveName;
	// 清单商品序号 --
	private String gNo;
	// 商品海关备案号 --
	private String customsListNO;
	// 商品名称 --
	private String gName;
	// 申报数量  --
	private int qty;
	
	
	
	
	
	
	
	public String getEntInsideNo() {
		return entInsideNo;
	}
	public void setEntInsideNo(String entInsideNo) {
		this.entInsideNo = entInsideNo;
	}
	public String getMasterCustoms() {
		return masterCustoms;
	}
	public void setMasterCustoms(String masterCustoms) {
		this.masterCustoms = masterCustoms;
	}
	public String getVeName() {
		return veName;
	}
	public void setVeName(String veName) {
		this.veName = veName;
	}
	public Date getLoadingDate() {
		return loadingDate;
	}
	public void setLoadingDate(Date loadingDate) {
		this.loadingDate = loadingDate;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public Date getInputDate() {
		return inputDate;
	}
	public void setInputDate(Date inputDate) {
		this.inputDate = inputDate;
	}
	public BigDecimal getGrossWt() {
		return grossWt;
	}
	public void setGrossWt(BigDecimal grossWt) {
		this.grossWt = grossWt;
	}
	public String getListGNo() {
		return listGNo;
	}
	public void setListGNo(String listGNo) {
		this.listGNo = listGNo;
	}
	public String getListEntNo() {
		return listEntNo;
	}
	public void setListEntNo(String listEntNo) {
		this.listEntNo = listEntNo;
	}
	public String getReceiveName() {
		return receiveName;
	}
	public void setReceiveName(String receiveName) {
		this.receiveName = receiveName;
	}
	public String getGNo() {
		return gNo;
	}
	public void setGNo(String no) {
		gNo = no;
	}
	public String getCustomsListNO() {
		return customsListNO;
	}
	public void setCustomsListNO(String customsListNO) {
		this.customsListNO = customsListNO;
	}
	public String getGName() {
		return gName;
	}
	public void setGName(String name) {
		gName = name;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
}
