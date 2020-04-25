package com.ht.model.reportmodel;

public class EOrder {
	
	// 订单编号
	private String orderId;
	
	// 进出口标识
	private String iEFlag;
	
	// 订单状态 S-订单新增，C-订单取消
	private String orderStatus;
	
	// 电商平台企业备案号（代码）
	private String entRecordNo;
	
	// 电商平台企业名称
	private String entRecordName;
	
	// 订单人姓名
	private String orderName;
	
	// 订单人证件类型
	private String orderDocType;
	
	// 订单人证件号
	private String orderDocId;
	
	// 订单人电话
	private String orderPhone;
	
	// 订单商品总额
	private String orderGoodTotal;
	
	// 订单商品总额币制
	private String orderGoodTotalCurr;
	
	// 运费
	private String freight;
	
	// 运费币制
	private String freightCurr;
	
	// 税款
	private String tax;
	
	// 税款币制
	private String taxCurr;
	
	// 备注
	private String note;
	
	// 订单日期，精确到秒
	private String orderDate;

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getiEFlag() {
		return iEFlag;
	}

	public void setiEFlag(String iEFlag) {
		this.iEFlag = iEFlag;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public String getEntRecordNo() {
		return entRecordNo;
	}

	public void setEntRecordNo(String entRecordNo) {
		this.entRecordNo = entRecordNo;
	}

	public String getEntRecordName() {
		return entRecordName;
	}

	public void setEntRecordName(String entRecordName) {
		this.entRecordName = entRecordName;
	}

	public String getOrderName() {
		return orderName;
	}

	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}

	public String getOrderDocType() {
		return orderDocType;
	}

	public void setOrderDocType(String orderDocType) {
		this.orderDocType = orderDocType;
	}

	public String getOrderDocId() {
		return orderDocId;
	}

	public void setOrderDocId(String orderDocId) {
		this.orderDocId = orderDocId;
	}

	public String getOrderPhone() {
		return orderPhone;
	}

	public void setOrderPhone(String orderPhone) {
		this.orderPhone = orderPhone;
	}

	public String getOrderGoodTotal() {
		return orderGoodTotal;
	}

	public void setOrderGoodTotal(String orderGoodTotal) {
		this.orderGoodTotal = orderGoodTotal;
	}

	public String getOrderGoodTotalCurr() {
		return orderGoodTotalCurr;
	}

	public void setOrderGoodTotalCurr(String orderGoodTotalCurr) {
		this.orderGoodTotalCurr = orderGoodTotalCurr;
	}

	public String getFreight() {
		return freight;
	}

	public void setFreight(String freight) {
		this.freight = freight;
	}

	public String getFreightCurr() {
		return freightCurr;
	}

	public void setFreightCurr(String freightCurr) {
		this.freightCurr = freightCurr;
	}

	public String getTax() {
		return tax;
	}

	public void setTax(String tax) {
		this.tax = tax;
	}

	public String getTaxCurr() {
		return taxCurr;
	}

	public void setTaxCurr(String taxCurr) {
		this.taxCurr = taxCurr;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}
	
	
}
