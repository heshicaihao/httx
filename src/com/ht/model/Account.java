package com.ht.model;

import java.sql.Timestamp;

import com.ht.util.StringUtil;

public class Account extends PageParam {

	private static final long serialVersionUID = -7876607653586785854L;
	private Integer id;
	private String loginName;
	private String loginPWD;
	private Integer status;
	private Timestamp createDate;
	private Timestamp lastLoginDate;
	private Integer custId;
	private String custName;
	private String accountDesc;
	private Integer accountType;
	private String oldPWD;
	public Integer getId() {
		return id;
	}
	public String getLoginName() {
		return loginName;
	}
	public String getLoginNameLike() {
		if(!StringUtil.isEmpty(loginName)){
			return "%" + loginName.toUpperCase() + "%";
		}
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public String getLoginPWD() {
		return loginPWD;
	}
	public void setLoginPWD(String loginPWD) {
		this.loginPWD = loginPWD;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Timestamp getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}
	public Timestamp getLastLoginDate() {
		return lastLoginDate;
	}
	public void setLastLoginDate(Timestamp lastLoginDate) {
		this.lastLoginDate = lastLoginDate;
	}
	public Integer getCustId() {
		return custId;
	}
	public void setCustId(Integer custId) {
		this.custId = custId;
	}
	public String getAccountDesc() {
		return accountDesc;
	}
	public void setAccountDesc(String accountDesc) {
		this.accountDesc = accountDesc;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	public Integer getAccountType() {
		return accountType;
	}
	public void setAccountType(Integer accountType) {
		this.accountType = accountType;
	}
	public String getOldPWD() {
		return oldPWD;
	}
	public void setOldPWD(String oldPWD) {
		this.oldPWD = oldPWD;
	}
}
