package com.ht.model.reportmodel;

import java.math.BigDecimal;

public class ImportOrderGoods {

	private Integer customerId;
	
	private Integer companyId;

	private String entrecordno;
	
	private String entrecordname;

	private String ordername;

	private String orderdocid;

	private String orderaddress;
	
	private String orderphone;
	
	private BigDecimal freight;
	
	private BigDecimal valuationfee;
	
	private BigDecimal tax;

    private Integer gqty;

    private String instkey;
    
    private String waybillno ;
    
    private String noticeno;
    
    private BigDecimal decprice;
    
    private Integer provinceId;
    
    private Integer cityId;
    
    private Integer areaId;
    
    private String note;
    
	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public BigDecimal getDecprice() {
		return decprice;
	}

	public void setDecprice(BigDecimal decprice) {
		this.decprice = decprice;
	}

	public String getNoticeno() {
		return noticeno;
	}

	public void setNoticeno(String noticeno) {
		this.noticeno = noticeno;
	}

	public String getEntrecordno() {
		return entrecordno;
	}

	public String getOrderphone() {
		return orderphone;
	}

	public void setOrderphone(String orderphone) {
		this.orderphone = orderphone;
	}

	public void setEntrecordno(String entrecordno) {
		this.entrecordno = entrecordno;
	}

	public String getEntrecordname() {
		return entrecordname;
	}

	public void setEntrecordname(String entrecordname) {
		this.entrecordname = entrecordname;
	}

	public String getOrdername() {
		return ordername;
	}

	public void setOrdername(String ordername) {
		this.ordername = ordername;
	}

	public String getOrderdocid() {
		return orderdocid;
	}

	public void setOrderdocid(String orderdocid) {
		this.orderdocid = orderdocid;
	}

	public String getOrderaddress() {
		return orderaddress;
	}

	public void setOrderaddress(String orderaddress) {
		this.orderaddress = orderaddress;
	}

	public BigDecimal getFreight() {
		return freight;
	}

	public void setFreight(BigDecimal freight) {
		this.freight = freight;
	}

	public BigDecimal getTax() {
		return tax;
	}

	public void setTax(BigDecimal tax) {
		this.tax = tax;
	}


	public Integer getGqty() {
		return gqty;
	}

	public void setGqty(Integer gqty) {
		this.gqty = gqty;
	}

	public String getWaybillno() {
		return waybillno;
	}

	public void setWaybillno(String waybillno) {
		this.waybillno = waybillno;
	}

	public String getInstkey() {
		return instkey;
	}

	public void setInstkey(String instkey) {
		this.instkey = instkey;
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public Integer getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
	}

	
	public BigDecimal getValuationfee() {
		return valuationfee;
	}

	public void setValuationfee(BigDecimal valuationfee) {
		this.valuationfee = valuationfee;
	}

	public Integer getProvinceId() {
		return provinceId;
	}

	public void setProvinceId(Integer provinceId) {
		this.provinceId = provinceId;
	}

	public Integer getCityId() {
		return cityId;
	}

	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}

	public Integer getAreaId() {
		return areaId;
	}

	public void setAreaId(Integer areaId) {
		this.areaId = areaId;
	}

}