package com.ht.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ht.model.Account;
import com.ht.model.GMUser;
import com.ht.model.PageResult;
import com.ht.model.UIReturn;
import com.ht.servie.GMUserService;
import com.ht.util.Const;
import com.ht.util.HTException;
import com.ht.util.StringUtil;

@Controller
@RequestMapping("/u/*")
public class GMUserController {
	
	private static final Logger log = LoggerFactory.getLogger(GMUserController.class);
	
	@Autowired
	private GMUserService userService;
	
	@RequestMapping(value="add",method=RequestMethod.POST)
	@ResponseBody
	public UIReturn add(@RequestBody GMUser gmUser){
		UIReturn rtn = new UIReturn();
		try {
			userService.add(gmUser);
			rtn.setCode(0);
			rtn.setSuccess(true);
		} catch (HTException e) {
			log.error("新增客户失败",e);
			rtn.setErrorMsg(e.getMessage());
			rtn.setSuccess(false);
		} catch(Exception ex){
			log.error("新增客户失败",ex);
			rtn.setSuccess(false);
			rtn.setErrorMsg(ex.getMessage());
		}
		return rtn;
	}
	
	@RequestMapping("list")
	public String listInit(){
		return "u/list";
	}
	
	@RequestMapping("listPage")
	@ResponseBody
	public PageResult<GMUser> listPage(GMUser gmUser){
		return userService.listPage(gmUser);
	}
	
	@RequestMapping("editInit")
	public String editInit(HttpServletRequest req,Model model){
		String instkey = req.getParameter("instkey");
		if(!StringUtil.isEmpty(instkey)){
			GMUser user = userService.getByKey(Integer.parseInt(instkey));
			model.addAttribute("gmUser", user);
		}
		return "u/edit";
	}
	
	@RequestMapping("editInit2")
	public String editInit2(HttpServletRequest req,Model model){
		GMUser user = userService.getByKey(((Account)req.getSession().getAttribute(Const.WEB_ACCOUNT)).getCustId());
		model.addAttribute("gmUser", user);
		return "u/edit2";
	}
	
	@RequestMapping(value="editSave",method=RequestMethod.POST)
	@ResponseBody
	public UIReturn editSave(@RequestBody GMUser gmUser){
		UIReturn rtn = new UIReturn();
		try {
			userService.update(gmUser);
			rtn.setCode(0);
			rtn.setSuccess(true);
		} catch (HTException e) {
			log.error("修改用户失败",e);
			rtn.setErrorMsg(e.getMessage());
			rtn.setSuccess(false);
		} catch(Exception ex){
			log.error("修改用户失败",ex);
			rtn.setSuccess(false);
			rtn.setErrorMsg(ex.getMessage());
		}
		return rtn;
	}
	
	@RequestMapping("modInit")
	public String modInit(HttpServletRequest req, Model model){
		GMUser u = (GMUser)req.getSession(false).getAttribute(Const.WEB_USER);
		GMUser user = userService.getByKey(u.getInstkey());
		model.addAttribute("gmUser", user);
		return "u/mod";
	}
	
	@RequestMapping("delete/{instkey}")
	@ResponseBody
	public UIReturn delete(@PathVariable String instkey){
		return userService.delete(instkey);
	}
	
}
