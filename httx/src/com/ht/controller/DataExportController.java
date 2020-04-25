package com.ht.controller;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ht.model.Goods;
import com.ht.model.InternationalTrade;
import com.ht.model.reportmodel.GoodsHGReport;
import com.ht.servie.GoodsExportService;
import com.ht.util.Config;
import com.ht.util.FileUtil;
import com.ht.util.FreeMarkerUtils;
import com.ht.util.StringUtil;

@Controller
@RequestMapping("/export/*")
public class DataExportController {

	@Autowired
	private GoodsExportService goodsExportService;
	
	@Autowired
	private Config config;

	@RequestMapping("goodsCheck")
	@ResponseBody
	public void exportGoods(HttpServletRequest req, HttpServletResponse response) {

		String ids = req.getParameter("ids");
		List<Goods> list = goodsExportService.selectByExample(ids);

		InternationalTrade tr = new InternationalTrade();

		tr.setSysdate(StringUtil.getCurrentTimestampStr());
		Map<String, Object> data = new HashMap<String, Object>();

		tr.setGoods(list);

		data.put("tr", tr);

		String filename = config.getExportPath() + File.separator + "881101" + tr.getSysdate() + ".xml";

		FreeMarkerUtils.initFreeMarker(req.getSession().getServletContext().getRealPath("/") + config.getTemplateFolder(),config.getExportPath());

		FreeMarkerUtils.createFile(data, config.getGoodsCheckTemplateFileName(), filename, true);

		FileUtil.download(filename, response);
	}

	@RequestMapping("goodsHG")
	@ResponseBody
	public void exportGoodsHG(HttpServletRequest req, HttpServletResponse response) {

		String ids = req.getParameter("ids");
		List<Goods> list = goodsExportService.selectByExample(ids);

		GoodsHGReport tr = new GoodsHGReport();

		Map<String, Object> data = new HashMap<String, Object>();

		tr.setGoods(list);

		data.put("tr", tr);

		String filename = config.getExportPath() + File.separator + "881101" + tr.getYyyyMMddHHmmSSS() + ".xml";

		FreeMarkerUtils.initFreeMarker(req.getSession().getServletContext().getRealPath("/") + config.getTemplateFolder(),config.getExportPath());

		FreeMarkerUtils.createFile(data, config.getGoodsHGTemplateFileName(), filename, true);

		FileUtil.download(filename, response);
	}

}
