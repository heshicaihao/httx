package com.ht.util;

import javax.servlet.http.HttpServletRequest;

import com.ht.model.GMUser;

public class UserSession {

	public static Integer getUserKey(HttpServletRequest req){
	   return getUserGMUserInfo(req).getInstkey();
	}
	
	public static GMUser getUserGMUserInfo(HttpServletRequest req){
		GMUser user  = (GMUser)req.getSession().getAttribute(Const.WEB_USER);
		return user;
	}
}
