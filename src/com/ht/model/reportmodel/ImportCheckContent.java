package com.ht.model.reportmodel;

public class ImportCheckContent {

	// 监管仓名称
	private String dischargePlace;

	// 商品批次号
	private String goodsBatchNo;

	// 流水号
	private String seq;

	// 检验检疫商品备案编号
	private String cIQGoodsNo;

	// 商品名称
	private String goodsName;

	// 申报数量
	private String qty;

	// 申报单价
	private String declarePrice;

	// 申报总价
	private String declareTotalAmount;

	// 毛重
	private String grossWeight;

	// 净重
	private String netWeight;

	// 备注
	private String notes;

	public String getDischargePlace() {
		return dischargePlace;
	}

	public void setDischargePlace(String dischargePlace) {
		this.dischargePlace = dischargePlace;
	}

	public String getGoodsBatchNo() {
		return goodsBatchNo;
	}

	public void setGoodsBatchNo(String goodsBatchNo) {
		this.goodsBatchNo = goodsBatchNo;
	}

	public String getSeq() {
		return seq;
	}

	public void setSeq(String seq) {
		this.seq = seq;
	}

	public String getcIQGoodsNo() {
		return cIQGoodsNo;
	}

	public void setcIQGoodsNo(String cIQGoodsNo) {
		this.cIQGoodsNo = cIQGoodsNo;
	}

	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public String getQty() {
		return qty;
	}

	public void setQty(String qty) {
		this.qty = qty;
	}

	public String getDeclarePrice() {
		return declarePrice;
	}

	public void setDeclarePrice(String declarePrice) {
		this.declarePrice = declarePrice;
	}

	public String getDeclareTotalAmount() {
		return declareTotalAmount;
	}

	public void setDeclareTotalAmount(String declareTotalAmount) {
		this.declareTotalAmount = declareTotalAmount;
	}

	public String getGrossWeight() {
		return grossWeight;
	}

	public void setGrossWeight(String grossWeight) {
		this.grossWeight = grossWeight;
	}

	public String getNetWeight() {
		return netWeight;
	}

	public void setNetWeight(String netWeight) {
		this.netWeight = netWeight;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

}
