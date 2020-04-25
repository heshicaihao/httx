package com.ht.model;

import java.sql.Timestamp;
import java.util.Date;

import com.ht.util.StringUtil;

public class IDCard extends PageParam {
	private static final long serialVersionUID = 4566868122109109358L;
	private Integer id;
	private String name;
	private String cardNo;
	private Timestamp createDate;
	
	private Date startDate;
	private Date endDate;
	
	private String startDateStr;
	private String endDateStr;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	
	public String getNameLike() {
		if(!StringUtil.isEmpty(name)){
			return "%" + name.trim().toUpperCase() + "%";
		}
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getCardNo() {
		return cardNo;
	}
	public String getCardNoLike() {
		if(!StringUtil.isEmpty(cardNo)){
			return "%" + cardNo.trim().toUpperCase() + "%";
		}
		return cardNo;
	}
	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}
	public Timestamp getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public String getStartDateStr() {
		return startDateStr;
	}
	public void setStartDateStr(String startDateStr) {
		this.startDateStr = startDateStr;
	}
	public String getEndDateStr() {
		return endDateStr;
	}
	public void setEndDateStr(String endDateStr) {
		this.endDateStr = endDateStr;
	}
}
