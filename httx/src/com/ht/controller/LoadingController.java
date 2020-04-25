package com.ht.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ht.model.LoadingGoods;
import com.ht.model.LoadingInfo;
import com.ht.model.LoadingOrder;
import com.ht.model.OrderInfo;
import com.ht.model.UIReturn;
import com.ht.model.reportmodel.LoadingRepotHGReport;
import com.ht.servie.LoadingService;
import com.ht.servie.OrderService;
import com.ht.util.Config;
import com.ht.util.FileUtil;
import com.ht.util.FreeMarkerUtils;
import com.ht.util.HTException;
import com.ht.util.StringUtil;

@Controller
@RequestMapping("/loading/*")
public class LoadingController {
	private static final Logger log = LoggerFactory
			.getLogger(LoadingController.class);
	@Autowired
	private OrderService orderService;
	@Autowired
	private LoadingService loadingService;
	@Autowired
	private Config config;

	@RequestMapping("list")
	public String list(Model model) {
		return "loading/loadinglist";
	}

	@RequestMapping("add")
	public String add(HttpServletRequest req, Model model) {

		LoadingInfo loadingInfo = new LoadingInfo();
		String orderids = req.getParameter("ids");
		loadingInfo.setOrderids(orderids);
		model.addAttribute("loadingInfo", loadingInfo);

		return "loading/addloading";
	}

	@RequestMapping(value = "save", method = RequestMethod.POST)
	@ResponseBody
	public UIReturn save(@RequestBody
	LoadingInfo loadingInfo, HttpSession session) {
		UIReturn rtn = new UIReturn();
		try {
			rtn = loadingService.save(loadingInfo);
		} catch (Exception ex) {
			rtn.setCode(99);
			rtn.setErrorMsg("发生未知异常!");
			log.error("保存装载信息失败！", ex);
		}
		return rtn;
	}

	@RequestMapping("exportLoadinghg")
	@ResponseBody
	public void exportLoadingHg(HttpServletRequest req,
			HttpServletResponse response) throws IOException {
		String orderids = req.getParameter("ids");
		List<String> orderIdList = new ArrayList<String>();
		List<OrderInfo> orderList2 = orderService.selectByExample(orderids);
		for (OrderInfo order : orderList2) {
			orderIdList.add(order.getOrderid());
		}
		List<LoadingGoods> loadingGoods = loadingService
				.getLoadingIds(orderIdList);
		PrintWriter writer = null;
		if (loadingGoods.get(0).getLoadingid() > 1) {
			try {
				response.reset();
				response.setContentType("text/html; charset=UTF-8");
				writer = response.getWriter();
				writer.write("<script>alert('请选择相同的装载单号才能生成报文!');</script>");
				writer.flush();
			} catch (Exception ex) {
				// log.error("return to front UI fail.",ex);
			} finally {
				if (null != writer)
					writer.close();
				writer = null;

			}
			return;
		}
		
		// 获取商品明细
		List<LoadingGoods> hgGoodsList = loadingService.getDetails(orderIdList);
		if (StringUtil.isEmpty(hgGoodsList)) {
			try {
				response.reset();
				response.setContentType("text/html; charset=UTF-8");
				writer = response.getWriter();
				writer.write("<script>alert('请检查是否有新增装载单!');</script>");
				writer.flush();
			} catch (Exception ex) {
				// log.error("return to front UI fail.",ex);
			} finally {
				if (null != writer)
					writer.close();
				writer = null;

			}
			return;
		}
		// 获取装载单商品数据
		List<LoadingGoods> loadingGoodsList = loadingService
				.selectLoadingGoodsByExample(orderids);
		LoadingGoods first2 = loadingGoodsList.get(0);
		LoadingInfo loadingInfo = loadingService.getByKey(first2.getLoadingid()
				.toString());
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		String strDate = sdf.format(date);
		BigDecimal grossWtTotal = new BigDecimal(0);
		for (LoadingGoods loadingGoodsHg : hgGoodsList) {
			grossWtTotal = grossWtTotal.add(loadingGoodsHg.getGrossWt());

		}

		LoadingRepotHGReport tr = new LoadingRepotHGReport();
		tr.setDetailsList(hgGoodsList);
		Map<String, Object> data = new HashMap<String, Object>();
		tr.setInputDate(strDate);
		tr.setGrossWt(grossWtTotal.toString());
		tr.setVeName(loadingInfo.getVename());
		data.put("tr", tr);

		String filename = config.getExportPath() + File.separator + "881105"
				+ tr.getYyyyMMddHHmmSSS() + ".xml";

		FreeMarkerUtils.initFreeMarker(req.getSession().getServletContext()
				.getRealPath("/")
				+ config.getTemplateFolder(), config.getExportPath());

		FreeMarkerUtils.createFile(data, config.getLoadingHGTemplate(),
				filename, true);

		FileUtil.download(filename, response);
	}

	@RequestMapping("exportLoadingCheck")
	@ResponseBody
	public void exportLoadingCheck(HttpServletRequest req,
			HttpServletResponse response) {
		String orderids = req.getParameter("ids");
		List<String> orderIdList = new ArrayList<String>();
		List<OrderInfo> orderList2 = orderService.selectByExample(orderids);
		for (OrderInfo order : orderList2) {
			orderIdList.add(order.getOrderid());
		}
		List<LoadingGoods> loadingGoods = loadingService
				.getLoadingIds(orderIdList);
		PrintWriter writer = null;
		if (loadingGoods.get(0).getLoadingid() > 1) {
			try {
				response.reset();
				response.setContentType("text/html; charset=UTF-8");
				writer = response.getWriter();
				writer.write("<script>alert('请选择相同的装载单号才能生成报文!');</script>");
				writer.flush();
			} catch (Exception ex) {
				// log.error("return to front UI fail.",ex);
			} finally {
				if (null != writer)
					writer.close();
				writer = null;

			}
			return;
		}
		// 获取商品明细
		List<LoadingGoods> hgGoodsList = loadingService.getDetails(orderIdList);
		if (StringUtil.isEmpty(hgGoodsList)) {
			try {
				response.reset();
				response.setContentType("text/html; charset=UTF-8");
				writer = response.getWriter();
				writer.write("<script>alert('请检查是否有新增装载单!');</script>");
				writer.flush();
			} catch (Exception ex) {
				// log.error("return to front UI fail.",ex);
			} finally {
				if (null != writer)
					writer.close();
				writer = null;

			}
			return;
		}
		// 获取装载单商品数据
		List<LoadingGoods> loadingGoodsList = loadingService
				.selectLoadingGoodsByExample(orderids);
		LoadingGoods first2 = loadingGoodsList.get(0);
		LoadingInfo loadingInfo = loadingService.getByKey(first2.getLoadingid()
				.toString());
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmSSS");
		String strDate = sdf.format(date);
		
		BigDecimal grossWtTotal = new BigDecimal(0);
		for (LoadingGoods loadingGoodsHg : hgGoodsList) {
			grossWtTotal = grossWtTotal.add(loadingGoodsHg.getGrossWt());
		}

		
		LoadingRepotHGReport tr = new LoadingRepotHGReport();
		tr.setDetailsList(hgGoodsList);
		Map<String, Object> data = new HashMap<String, Object>();
		tr.setInputDate(strDate);
		tr.setGrossWt(grossWtTotal.toString());
		tr.setVeName(loadingInfo.getVename());
		data.put("tr", tr);

		String filename = config.getExportPath() + File.separator + "DS"
				+ tr.getYyyyMMddHHmmSSS() + ".xml";

		FreeMarkerUtils.initFreeMarker(req.getSession().getServletContext()
				.getRealPath("/")
				+ config.getTemplateFolder(), config.getExportPath());

		FreeMarkerUtils.createFile(data, config.getLoadingCheckTemplate(),
				filename, true);

		FileUtil.download(filename, response);
	}

	@RequestMapping("released")
	@ResponseBody
	public UIReturn released(HttpServletRequest req) {
		String orderid = req.getParameter("ids");
		UIReturn rtn = new UIReturn();
		try{
			loadingService.closeOrder(orderid);
			rtn.setCode(0);
			rtn.setSuccess(true);
		}catch(HTException e){
			rtn.setCode(1);
			rtn.setSuccess(false);
			rtn.setErrorMsg(e.getMessage());
		}catch(Exception ex){
			log.error("Close Order fail, orderId=" + null==orderid?"":orderid,ex);
			rtn.setCode(99);
			rtn.setSuccess(false);
			rtn.setErrorMsg("关闭订单失败，遇到未知错误!");
		}
		return rtn;
	}

	@RequestMapping("listPage")
	@ResponseBody
	public List<LoadingOrder> listPage(OrderInfo order) {

		return loadingService.listPage(order); 
	}
}
