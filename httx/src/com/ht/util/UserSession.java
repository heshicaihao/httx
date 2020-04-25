package com.ht.util;

import javax.servlet.http.HttpServletRequest;

import com.ht.model.Account;

public class UserSession {

	public static Integer getUserKey(HttpServletRequest req){
	   return getAccountInfo(req).getId();
	}
	
	public static Account getAccountInfo(HttpServletRequest req){
		Account user  = (Account)req.getSession().getAttribute(Const.WEB_ACCOUNT);
		return user;
	}
}
