package com.ht.util;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.ht.model.Account;

public class LoginInterceptor implements HandlerInterceptor {
	
	private String urlMapping;
	
	private List<String> exclude;

	public List<String> getExclude() {
		return exclude;
	}

	public void setExclude(List<String> exclude) {
		this.exclude = exclude;
	}

	public String getUrlMapping() {
		return urlMapping;
	}

	public void setUrlMapping(String urlMapping) {
		this.urlMapping = urlMapping;
	}

	@Override
	public void afterCompletion(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse res,
			Object arg2, ModelAndView arg3) throws Exception {
	}

	@Override
	public boolean preHandle(HttpServletRequest req, HttpServletResponse res,
			Object arg2) throws Exception {
		String reqUrl = req.getRequestURI();
		if(reqUrl.matches(urlMapping)){
			for(String str : exclude){
				if(reqUrl.endsWith(str)){
					return true;
				}
			}
			Account login = (Account)req.getSession().getAttribute(Const.WEB_ACCOUNT);
			if(null == login){
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
		return true;
	}

	public static void main(String[] args){
		String str = "ssms2/mgr/page/index";
		System.out.println(str.matches(".*/mgr/.+/.*"));
	}
}
