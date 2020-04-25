package com.ht.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ht.model.Goods;
import com.ht.model.PageResult;
import com.ht.model.UIReturn;
import com.ht.servie.GoodsService;
import com.ht.util.StringUtil;

@Controller
@RequestMapping("/goods/*")
public class GoodsController {

	
	@Autowired
	private GoodsService goodsService;
	
	@RequestMapping("list")
	public String list(Model model){
		//List<GMDict> productTypeList = dictService.listProductType();
		//List<GMDict> productCpyRightList = dictService.listProductCpyRight();
		//model.addAttribute("productTypeList", productTypeList);
		//model.addAttribute("productCpyRightList", productCpyRightList);
		return "goods/list";
	}
	
	@RequestMapping("add")
	public String add(HttpServletRequest req, Model model){
		//List<GMDict> productTypeList = dictService.listProductType();
		//List<GMDict> productCpyRightList = dictService.listProductCpyRight();
		//model.addAttribute("productTypeList", productTypeList);
		//model.addAttribute("productCpyRightList", productCpyRightList);
		String instkey =req.getParameter("id");
		if(instkey!=null){
			Goods goods = goodsService.getByKey(Integer.parseInt(instkey));
			model.addAttribute("goods",goods);
		}
		return "goods/add";
	}
	
	@RequestMapping(value="save",method=RequestMethod.POST)
	@ResponseBody
	public UIReturn save(@RequestBody Goods goods){
		try{
		return goodsService.save(goods);
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return null;
	}
	
	@RequestMapping("listPage")
	@ResponseBody
	public PageResult<Goods> listPage(Goods goods){
		return goodsService.listPage(goods);
	}
	
	@RequestMapping("delete/{id}")
	@ResponseBody
	public UIReturn delete(@PathVariable int id){
		return goodsService.delete(id);
	}
	
}
