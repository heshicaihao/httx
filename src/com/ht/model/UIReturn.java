package com.ht.model;

import com.ht.util.StringUtil;

public class UIReturn {

	private boolean success = false;
	private String errorMsg;
	private int code;
	private String rtnKey;
	
	public UIReturn(){}
	
	public UIReturn(String errMsg){
		setCode(99);
		setSuccess(false);
		String errorMsg = errMsg;
		if(!StringUtil.isEmpty(errorMsg) && errorMsg.length() > 100){
			errorMsg = errorMsg.substring(0,100) + "...";
		}
		setErrorMsg(errorMsg);
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	public String getRtnKey() {
		return rtnKey;
	}

	public void setRtnKey(String rtnKey) {
		this.rtnKey = rtnKey;
	}
}
