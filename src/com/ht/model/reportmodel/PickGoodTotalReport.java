package com.ht.model.reportmodel;

public class PickGoodTotalReport {

	// 商品总量
	private int totalQty;

	// 商品所有批次
	private String batchTotal;

	// 商品编码
	private String instKey;
	
	//商品批次号
	private String batchno;

	public String getBatchno() {
		return batchno;
	}

	public void setBatchno(String batchno) {
		this.batchno = batchno;
	}

	public int getTotalQty() {
		return totalQty;
	}

	public void setTotalQty(int totalQty) {
		this.totalQty = totalQty;
	}

	public String getBatchTotal() {
		return batchTotal;
	}

	public void setBatchTotal(String batchTotal) {
		this.batchTotal = batchTotal;
	}

	public String getInstKey() {
		return instKey;
	}

	public void setInstKey(String instKey) {
		this.instKey = instKey;
	}

}
