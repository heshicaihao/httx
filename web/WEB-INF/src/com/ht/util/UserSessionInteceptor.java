package com.ht.util;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class UserSessionInteceptor implements HandlerInterceptor {

	@Override
	public void afterCompletion(HttpServletRequest req,
			HttpServletResponse res, Object arg2, Exception arg3)
			throws Exception {
	}

	@Override
	public void postHandle(HttpServletRequest req, HttpServletResponse res,
			Object arg2, ModelAndView arg3) throws Exception {
	}

	@Override
	public boolean preHandle(HttpServletRequest req, HttpServletResponse res,
			Object arg2) throws Exception {
		if(UserSession.getUserGMUserInfo(req) != null ) {
			return true;
		}
		//res.sendRedirect(req.getContextPath() + "/index");
		PrintWriter writer = null;
		try{
			writer = res.getWriter();
			writer.write(String.format("<script>window.parent.top.location.href='%s';</script>", req.getContextPath() + "/index"));
			writer.flush();
		}catch(Exception ex){
			throw ex;
		}finally{
			if(null!=writer)
				writer.close();
			writer = null;
		}
		return false;
	}

}
