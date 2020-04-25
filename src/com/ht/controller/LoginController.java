package com.ht.controller;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ht.model.Account;
import com.ht.model.UIReturn;
import com.ht.servie.AccountService;
import com.ht.util.Const;

@Controller
@RequestMapping("/")
public class LoginController {
	@Autowired
	private AccountService accountService;

	@RequestMapping(value="login",method = RequestMethod.POST)
	@ResponseBody
	public UIReturn login(HttpServletRequest req){
		UIReturn rtn = new UIReturn();
		String username = req.getParameter("u");
		String pwd = req.getParameter("p");
		String verifyCode = req.getParameter("v");
		HttpSession session = req.getSession(false);
		String verify = (String)session.getAttribute("image");
		if(verify.equalsIgnoreCase(verifyCode)){
			Account u = new Account();
			u.setLoginName(username);
			u.setLoginPWD(pwd);
			u = accountService.checkPass(u);
			if(null != u){
				if(u.getStatus() == 1){
					session.setAttribute(Const.WEB_ACCOUNT, u);
					rtn.setCode(Const.LOGIN_PASS);
				}else{
					rtn.setCode(Const.LOGIN_INACTIVE);
				}
			}else{
				rtn.setCode(Const.LOGIN_UP);
			}
		}else{
			rtn.setCode(Const.LOGIN_VERIFY);
		}
		return rtn;
	}
	
	@RequestMapping("logout")
	public void logout(HttpServletRequest req,HttpServletResponse res){
		HttpSession session = req.getSession(false);
		session.removeAttribute(Const.WEB_USER);
		PrintWriter writer = null;
		try{
			writer = res.getWriter();
			writer.write(String.format("<script>window.parent.top.location.href='%s';</script>", req.getContextPath() + "/index"));
			writer.flush();
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			if(null!=writer)
				writer.close();
			writer = null;
		}
	}
}
