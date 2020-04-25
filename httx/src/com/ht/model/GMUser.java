package com.ht.model;

import com.ht.util.StringUtil;

public class GMUser extends PageParam {

	private static final long serialVersionUID = -3306459949501935538L;

	private Integer instkey;

	private String gmusername;

	/**
	 * 电商平台名称
	 */
	private String coname;
	
	private String contactor;
	
	private String phoneNo;

	private Short userstatus;

	private String desc;

	public Integer getInstkey() {
		return instkey;
	}

	public void setInstkey(Integer instkey) {
		this.instkey = instkey;
	}

	public String getGmusernameLike() {
		if (!StringUtil.isEmpty(gmusername)) {
			return "%" + gmusername.toUpperCase() + "%";
		}
		return gmusername;
	}

	public String getGmusername() {
		return gmusername;
	}

	public void setGmusername(String gmusername) {
		this.gmusername = gmusername == null ? null : gmusername.trim();
	}

	public String getConame() {
		return coname;
	}

	public String getConameLike() {
		if (!StringUtil.isEmpty(coname)) {
			return "%" + coname.toUpperCase() + "%";
		}
		return coname;
	}

	public void setConame(String coname) {
		this.coname = coname == null ? null : coname.trim();
	}

	public Short getUserstatus() {
		return userstatus;
	}

	public void setUserstatus(Short userstatus) {
		this.userstatus = userstatus;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getContactor() {
		return contactor;
	}

	public void setContactor(String contactor) {
		this.contactor = contactor;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
}