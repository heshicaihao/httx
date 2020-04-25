package com.ht.model;

import java.sql.Timestamp;

public class LoadingOrder {

	private String orderid;
	private String companyName;
	private String customerName;
	private String ordername;
	private Timestamp orderdate;
	private int status;
	private String loading_no;
	public String getOrderid() {
		return orderid;
	}
	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getOrdername() {
		return ordername;
	}
	public void setOrdername(String ordername) {
		this.ordername = ordername;
	}
	public Timestamp getOrderdate() {
		return orderdate;
	}
	public void setOrderdate(Timestamp orderdate) {
		this.orderdate = orderdate;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getLoading_no() {
		return loading_no;
	}
	public void setLoading_no(String loading_no) {
		this.loading_no = loading_no;
	}
}
