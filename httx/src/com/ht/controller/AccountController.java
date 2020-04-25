package com.ht.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ht.model.Account;
import com.ht.model.PageResult;
import com.ht.model.TreeMenu;
import com.ht.model.UIReturn;
import com.ht.servie.AccountService;
import com.ht.util.Const;
import com.ht.util.StringUtil;

@Controller
@RequestMapping("/account/*")
public class AccountController {
	
	@Autowired
	private AccountService accountService;
	
	@RequestMapping("addInit")
	public String addInit(){
		return "account/account";
	}
	
	@RequestMapping(value="save",method=RequestMethod.POST)
	@ResponseBody
	public UIReturn save(@RequestBody Account account){
		return accountService.save(account);
	}
	
	@RequestMapping("list")
	public String listInit(){
		return "account/list";
	}
	
	@RequestMapping("listPage")
	@ResponseBody
	public PageResult<Account> listPage(Account account){
		return accountService.listPage(account);
	}
	
	@RequestMapping("editInit")
	public String editInit(HttpServletRequest req,Model model){
		String idStr = req.getParameter("id");
		if(!StringUtil.isEmpty(idStr)){
			try{
			Account account = accountService.getById(Integer.parseInt(idStr));
			model.addAttribute("account", account);
			}catch(Exception ex){
				ex.printStackTrace();
			}
		}
		return "account/account";
	}
	
	@RequestMapping("editInit2")
	public String editIni2t(HttpServletRequest req,Model model){
		Account user = (Account)req.getSession().getAttribute(Const.WEB_ACCOUNT);
		Account account = accountService.getById(user.getId());
		model.addAttribute("account", account);
		return "account/edit2";
	}
	
	@RequestMapping("modpwdInit")
	public String modInit(HttpServletRequest req, Model model){
		Account user = accountService.getById(((Account)req.getSession().getAttribute(Const.WEB_ACCOUNT)).getId());
		model.addAttribute("account", user);
		return "account/mod";
	}
	
	@RequestMapping("menu")
	@ResponseBody
	public List<TreeMenu> getMenu(HttpServletRequest req){
		Account login = (Account)req.getSession().getAttribute(Const.WEB_ACCOUNT);
		int typeKey = login.getAccountType();
		List<TreeMenu> menuList = new ArrayList<TreeMenu>();
		TreeMenu m = null;
		String[] roots = {"用户管理","商品基本信息管理","报表管理"};
		String[][] chirld = {{"个人资料","修改密码"},{"商品基本信息列表"},{"订单出仓报表","库存报表","库房交易记录报表","商品备案报表","订单状态报表"}};
		String[][] chirldUrl = {{"/u/editInit2","/account/modpwdInit"},{"/goods/list"},{"/report/orderlist","/report/storagelist","/report/transactionlist","/report/goodslist","/report/orderstatuslist"}};
		if(typeKey == 1){
			roots = new String[]{"登陆用户管理","客户管理","商品基本信息管理","入库信息管理","订单管理","装载单管理","报表管理","身份证管理"};
			chirld = new String[][]{{"登陆用户信息","修改密码"},{"客户信息"},{"商品基本信息列表"},{"入库信息管理"},{"订单管理"},{"装载单管理"},{"订单出仓报表","库存报表","库房交易记录报表","商品备案报表","订单状态报表"},{"身份证管理"}};
			chirldUrl = new String[][]{{"/account/list","/account/modpwdInit"},{"/u/list"},{"/goods/list"},{"/intentrepot/list"},{"/order/list"},{"/loading/list"},{"/report/orderlist","/report/storagelist","/report/transactionlist","/report/goodslist","/report/orderstatuslist"},{"/idcard/list"}};
		}else if(typeKey==2){
			roots = new String[]{"用户管理","商品基本信息管理","入库信息管理","订单管理","装载管理","报表管理"};
			chirld = new String[][]{{"个人资料","修改密码"},{"商品基本信息列表"},{"入库基本信息列表"},{"订单信息列表"},{"装载单管理"},{"订单出仓报表","库存报表","库房交易记录报表","商品备案报表","订单状态报表"}};
			chirldUrl = new String[][]{{"/account/editInit2","/account/modpwdInit"},{"/goods/list"},{"/intentrepot/list"},{"/order/list"},{"/loading/list"},{"/report/orderlist","/report/storagelist","/report/transactionlist","/report/goodslist","/report/orderstatuslist"}};
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
	
	@RequestMapping("delete/{id}")
	@ResponseBody
	public UIReturn delete(@PathVariable int id){
		Account a = new Account();
		a.setId(id);
		a.setStatus(0);
		return accountService.save(a);
	}
	
	@RequestMapping(value="modSave",method=RequestMethod.POST)
	@ResponseBody
	public UIReturn modSave(@RequestBody Account account, HttpServletRequest req){
		Account u = (Account)req.getSession(false).getAttribute(Const.WEB_ACCOUNT);
		account.setLoginName(u.getLoginName());
		UIReturn rtn= accountService.modPWD(account);
		if(rtn.getCode() == 0){
			u.setLoginPWD(account.getLoginPWD());
		}
		return rtn;
	}
	
}
