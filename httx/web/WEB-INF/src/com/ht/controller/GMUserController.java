package com.ht.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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

import com.ht.model.GMUser;
import com.ht.model.PageResult;
import com.ht.model.TreeMenu;
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
	
	@RequestMapping("addInit")
	public String addInit(){
		return "u/add";
	}
	
	@RequestMapping(value="add",method=RequestMethod.POST)
	@ResponseBody
	public UIReturn add(@RequestBody GMUser gmUser){
		UIReturn rtn = new UIReturn();
		try {
			userService.add(gmUser);
			rtn.setCode(0);
			rtn.setSuccess(true);
		} catch (HTException e) {
			log.error("新增用户失败",e);
			rtn.setErrorMsg(e.getMessage());
			rtn.setSuccess(false);
		} catch(Exception ex){
			log.error("新增用户失败",ex);
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
	public String editInit(Model model,HttpServletRequest req){
		GMUser user = userService.getByKey(((GMUser)req.getSession().getAttribute(Const.WEB_USER)).getInstkey());
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
	
	@RequestMapping(value="modSave",method=RequestMethod.POST)
	@ResponseBody
	public UIReturn modSave(@RequestBody GMUser gmUser, HttpServletRequest req){
		GMUser u = (GMUser)req.getSession(false).getAttribute(Const.WEB_USER);
		gmUser.setGmusername(u.getGmusername());
		UIReturn rtn= userService.modPWD(gmUser);
		if(rtn.getCode() == 0){
			u.setGmuserpwd(gmUser.getGmuserpwd());
		}
		return rtn;
	}
	
	@RequestMapping("menu")
	@ResponseBody
	public List<TreeMenu> getMenu(HttpServletRequest req){
		HttpSession session = req.getSession(false);
		GMUser user = (GMUser)session.getAttribute(Const.WEB_USER);
		int typeKey = user.getUsertype();
		List<TreeMenu> menuList = new ArrayList<TreeMenu>();
		TreeMenu m = null;
		String[] roots = {"用户管理","商品基本信息管理"};
		String[][] chirld = {{"个人资料","修改密码"},{"商品基本信息列表"}};
		String[][] chirldUrl = {{"/u/editInit2","/u/modInit"},{"/p/list"}};
		if(typeKey == 1){
			roots = new String[]{"用户管理","商品基本信息管理","客户商品编码管理","用户信息管理"};
			chirld = new String[][]{{"用户信息","个人资料","修改密码"},{"商品基本信息列表"},{"客户商品编码列表"},{"基本信息","修改密码"}};
			chirldUrl = new String[][]{{"/u/list","/u/editInit2","/u/modInit"},{"/p/list"},{"/j/list"},{"/d/list","/u/modInit"}};
		}
		for(int i = 0; i < roots.length; i++){
		 	m = new TreeMenu();
			m.setId((i+1));
			m.setState("open");
			m.setText(roots[i]);
			List<TreeMenu> children = new ArrayList<TreeMenu>();
			m.setChildren(children);
			menuList.add(m);
			for(int j = 0; j < chirld[i].length; j++){
				m = new TreeMenu();
				m.setId((i+1) * 10 + (j+1));
				m.setText(chirld[i][j]);
				m.setIconCls("tree-children");
				m.addAttr("url", chirldUrl[i][j]);
				children.add(m);
			}
		}
		return menuList;
	}
	
	@RequestMapping("delete/{instkey}")
	@ResponseBody
	public UIReturn delete(@PathVariable String instkey){
		return userService.delete(instkey);
	}
	
}
