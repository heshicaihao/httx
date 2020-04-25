package com.ht.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.ht.mapper.DictDataMapper;
import com.ht.mapper.GMUserMapper;
import com.ht.model.Account;
import com.ht.model.Goods;
import com.ht.model.PageResult;
import com.ht.model.UIReturn;
import com.ht.servie.GoodsService;
import com.ht.util.Config;
import com.ht.util.Const;
import com.ht.util.FileUtil;
import com.ht.util.StringUtil;

@Controller
@RequestMapping("/goods/*")
public class GoodsController {

	private static final Logger log = LoggerFactory.getLogger(GoodsController.class);
	
	@Autowired
	private GoodsService goodsService;
	
	@Autowired
	private DictDataMapper dictDataMapper;
	
	@Autowired
	private GMUserMapper userMapper;
	
	@Autowired
	private Config config;
	
	@RequestMapping("list")
	public String list(Model model){
		return "goods/list";
	}
	
	@RequestMapping("add")
	public String add(HttpServletRequest req, Model model){
		String instkey =req.getParameter("id");
		if(instkey!=null){
			Goods goods = goodsService.getByKey(Integer.parseInt(instkey));
			model.addAttribute("goods",goods);
		}
		initDictData(model);
		return "goods/add";
	}
	
	@RequestMapping(value="save",method=RequestMethod.POST)
	@ResponseBody
	public UIReturn save(@RequestBody Goods goods,HttpSession session){
		UIReturn rtn = new UIReturn();
		try{
			Account user = (Account)session.getAttribute(Const.WEB_ACCOUNT);
			if(user.getAccountType() != 3){
				if(null == goods.getCreateuserid()){
					rtn.setCode(Const.UI_ERROR);
					rtn.setErrorMsg("请为该商品添加相关的客户!");
				}else{
					goods.setLastupdateuserid(user.getId());
				}
			}else{
				goods.setCreateuserid(user.getCustId());
			}
			rtn = goodsService.save(goods);
		}catch(Exception ex){
			rtn.setCode(99);
			rtn.setErrorMsg("发生未知异常!");
			log.error("保存商品信息失败！",ex);
		}
		return rtn;
	}
	
	@RequestMapping("listPage")
	@ResponseBody
	public PageResult<Goods> listPage(Goods goods, HttpSession session){
		Account user = (Account)session.getAttribute(Const.WEB_ACCOUNT);
		if(Const.USERTYPE_CUSTOMER == user.getAccountType()){
			goods.setCreateuserid(user.getCustId());
		}
		return goodsService.listPage(goods);
	}
	
	@RequestMapping("delete/{id}")
	@ResponseBody
	public UIReturn delete(@PathVariable int id){
		return goodsService.delete(id);
	}
	
	private void initDictData(Model model){
		try {
			model.addAttribute("unitList",StringUtil.getJsonMapper().writeValueAsString(dictDataMapper.listAllUnits()));
			model.addAttribute("currList",StringUtil.getJsonMapper().writeValueAsString(dictDataMapper.listAllCurrency()));
			model.addAttribute("countryList",StringUtil.getJsonMapper().writeValueAsString(dictDataMapper.listAllCountries()));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@RequestMapping("listGoodsByUserKey")
	@ResponseBody
	public List<Goods> listGoodsByUserKey(HttpServletRequest req){
		List<Goods> goodsList = new ArrayList<Goods>();
		String userKeyStr = req.getParameter("userKey");
		String gname = req.getParameter("gname");
		try{
			if(!StringUtil.isEmpty(userKeyStr)){
				goodsList = goodsService.listGoodsByUserKeyNameLike(Integer.parseInt(userKeyStr),gname);
			}else{
				log.debug("User key is null");
			}
		}catch(Exception ex){
			log.error("查询客户商品失败!",ex);
		}
		return goodsList;
	}
	
	@RequestMapping("showImport")
	public String shwoImport(Model model){
		model.addAttribute("customerList",userMapper.getActiveUserList());
		return "goods/import";
	}
	
	@RequestMapping("import")
	@ResponseBody
	public void importFile(@RequestParam(value="importFile", required=true) MultipartFile file, HttpServletRequest req,HttpServletResponse res){
		UIReturn rtn = new UIReturn();
		try {
			goodsService.importFile(file, req);
			rtn.setCode(0);
			rtn.setSuccess(true);
		} catch (Exception ex) {
			log.error("导入商品信息失败!",ex);
			rtn.setCode(99);
			rtn.setErrorMsg(ex.getMessage());
			rtn.setSuccess(false);
		}
		res.reset();
		res.setContentType("text/html; charset=UTF-8");
		try {
			res.getWriter().write(StringUtil.getJsonMapper().writeValueAsString(rtn));
		} catch (IOException e) {
			log.error("Write response string fail.",e);
		}
	}
	
	@RequestMapping("downloadTemplate")
	public void downloadOrderTemplate(HttpServletRequest req,
			HttpServletResponse response) {
		String templatePath = req.getSession().getServletContext().getRealPath(
				"/")
				+ config.getTemplateFolder()
				+ File.separator
				+ config.getGoodsImportTemplate();
		FileUtil.download(templatePath, response);

	}
	
}
