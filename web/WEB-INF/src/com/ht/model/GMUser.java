package com.ht.model;

import java.util.Date;

import com.ht.util.StringUtil;

public class GMUser extends PageParam {

	private static final long serialVersionUID = -3306459949501935538L;

	private Integer instkey;

	private String gmusername;

	private String gmuserpwd;

	private String coname;

	private Short usertype;

	private Short userstatus;

	private String desc;

	private Date userlastlogin;
	
	private String oldPWD;

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

	public String getGmuserpwd() {
		return gmuserpwd;
	}

	public void setGmuserpwd(String gmuserpwd) {
		this.gmuserpwd = gmuserpwd == null ? null : gmuserpwd.trim();
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

	public Short getUsertype() {
		return usertype;
	}

	public void setUsertype(Short usertype) {
		this.usertype = usertype;
	}

	public Short getUserstatus() {
		return userstatus;
	}

	public void setUserstatus(Short userstatus) {
		this.userstatus = userstatus;
	}

	public Date getUserlastlogin() {
		return userlastlogin;
	}

	public String getUserlastloginStr() {
		if (null != userlastlogin) {
			return StringUtil.dateTime2String(userlastlogin);
		}
		return "";
	}

	public void setUserlastlogin(Date userlastlogin) {
		this.userlastlogin = userlastlogin;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getOldPWD() {
		return oldPWD;
	}

	public void setOldPWD(String oldPWD) {
		this.oldPWD = oldPWD;
	}
}