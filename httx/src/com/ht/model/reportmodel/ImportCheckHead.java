package com.ht.model.reportmodel;

public class ImportCheckHead {

	// 申报企业备案编号 -->
	private String cIQEntRegNo;
	
	// 代理申报企业备案编号
	private String agentEntNo;
	
	// 检验检疫机构
	private String orgCode;
	
	// 收件人姓名
	private String consigneeName;
	
	// 收件人地址
	private String consigneeAddr;
	
	// 收件人证件号
	private String consigneeIdNo;
	
	// 录入日期
	private String inputDate;
	
	// 企业进境自编号
	private String entImportNo;
	
	// 平台进境受理编号
	private String ePortImportNo;
	
	// 检验检疫进境受理编号
	private String cIQImportNo;
	
	// 操作方式：A-新增；M-修改；D-取消备案；（默认为新增）
	private String opType;
	
	// 备注
	private String notes;

	public String getcIQEntRegNo() {
		return cIQEntRegNo;
	}

	public void setcIQEntRegNo(String cIQEntRegNo) {
		this.cIQEntRegNo = cIQEntRegNo;
	}

	public String getAgentEntNo() {
		return agentEntNo;
	}

	public void setAgentEntNo(String agentEntNo) {
		this.agentEntNo = agentEntNo;
	}

	public String getOrgCode() {
		return orgCode;
	}

	public void setOrgCode(String orgCode) {
		this.orgCode = orgCode;
	}

	public String getConsigneeName() {
		return consigneeName;
	}

	public void setConsigneeName(String consigneeName) {
		this.consigneeName = consigneeName;
	}

	public String getConsigneeAddr() {
		return consigneeAddr;
	}

	public void setConsigneeAddr(String consigneeAddr) {
		this.consigneeAddr = consigneeAddr;
	}

	public String getConsigneeIdNo() {
		return consigneeIdNo;
	}

	public void setConsigneeIdNo(String consigneeIdNo) {
		this.consigneeIdNo = consigneeIdNo;
	}

	public String getInputDate() {
		return inputDate;
	}

	public void setInputDate(String inputDate) {
		this.inputDate = inputDate;
	}

	public String getEntImportNo() {
		return entImportNo;
	}

	public void setEntImportNo(String entImportNo) {
		this.entImportNo = entImportNo;
	}

	public String getePortImportNo() {
		return ePortImportNo;
	}

	public void setePortImportNo(String ePortImportNo) {
		this.ePortImportNo = ePortImportNo;
	}

	public String getcIQImportNo() {
		return cIQImportNo;
	}

	public void setcIQImportNo(String cIQImportNo) {
		this.cIQImportNo = cIQImportNo;
	}

	public String getOpType() {
		return opType;
	}

	public void setOpType(String opType) {
		this.opType = opType;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

}
