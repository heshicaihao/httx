package com.ht.model;


public class UserGoods extends PageParam {

	private int userKey;
	private int goodsId;
	private int active;
	private String userGoodsCode;
	private String INSTKEY;
	
	private Integer totalNo;
	
	public int getUserKey() {
		return userKey;
	}
	public void setUserKey(int userKey) {
		this.userKey = userKey;
	}
	public int getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(int goodsId) {
		this.goodsId = goodsId;
	}
	public int getActive() {
		return active;
	}
	public void setActive(int active) {
		this.active = active;
	}
	public String getUserGoodsCode() {
		return userGoodsCode;
	}
	public void setUserGoodsCode(String userGoodsCode) {
		this.userGoodsCode = userGoodsCode;
	}
	public Integer getTotalNo() {
		return totalNo;
	}
	public void setTotalNo(Integer totalNo) {
		this.totalNo = totalNo;
	}
	public String getINSTKEY() {
		return INSTKEY;
	}
	public void setINSTKEY(String iNSTKEY) {
		INSTKEY = iNSTKEY;
	}
	
}
