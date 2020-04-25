package com.ht.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ht.mapper.GMUserMapper;
import com.ht.model.Account;
import com.ht.model.Goods;
import com.ht.model.PageResult;
import com.ht.model.Report;
import com.ht.servie.ReportService;
import com.ht.util.Config;
import com.ht.util.Const;
import com.ht.util.ExpExcel;
import com.ht.util.StringUtil;

@Controller
@RequestMapping("/report/*")
public class ReportController {

	@Autowired
	private ReportService reportService;

	@Autowired
	private Config config;
	
	@Autowired
	private GMUserMapper userMapper;

	@RequestMapping("orderlist")
	public String list(Model model) {
		return "report/orderlist";
	}

	@RequestMapping("listOrderPage")
	@ResponseBody
	public PageResult<Report> listPage(Report report, HttpSession session) {
		Account user = (Account)session.getAttribute(Const.WEB_ACCOUNT);
		if(user.getAccountType() == 3){
			report.setCustid(user.getCustId());
		}
		return reportService.orderListByDate(report);
	}

	@RequestMapping("exportOrderlist")
	@ResponseBody
	public void exportOrderlist(HttpServletRequest req,
			HttpServletResponse res) {
		String startDateStr = req.getParameter("startDateStr");
		String endDateStr = req.getParameter("endDateStr");
		String custId = req.getParameter("userIdHidden");
		Report rpt = new Report();
		rpt.setStartDate(startDateStr);
		rpt.setEndDate(endDateStr);
		Account user = (Account)req.getSession().getAttribute(Const.WEB_ACCOUNT);
		String filename = null;
		if(user.getAccountType() == 3){
			rpt.setCustid(user.getCustId());
			filename = StringUtil.formatCode(3, user.getCustId());
		}else{
			if(!StringUtil.isEmpty(custId)){
				int userId = Integer.parseInt(custId);
				rpt.setCustid(userId);
				filename = StringUtil.formatCode(3, userId);
			}else{
				filename = "All";
			}
		}
		filename = filename + "_" + startDateStr + "_" + endDateStr;
		rpt.setUsergoodscode(req.getParameter("usergoodscode"));
		rpt.setOrderno(req.getParameter("orderno"));
		rpt.setEntRecordNo(req.getParameter("entRecordNo"));
		rpt.setRecname(req.getParameter("recname"));
		List<Report> reportList = reportService.orderListByDate4Export(rpt);
		ExpExcel.exportReport(filename, config.getOrderExportReportTemplate(), res, req, reportList);

	}


	@RequestMapping("storagelist")
	public String storagelist(Model model) {
		return "report/storagelist";
	}

	@RequestMapping("storagelistPage")
	@ResponseBody
	public PageResult<Report> storagelist(Report report, HttpSession session) {
		Account user = (Account)session.getAttribute(Const.WEB_ACCOUNT);
		if(user.getAccountType() == 3){
			report.setCustid(user.getCustId());
		}
		return reportService.storagelistByDate(report);
	}
	
	@RequestMapping("exportStorageExcel")
	public void exportStorageExcel(HttpServletRequest req, HttpServletResponse res){
		String startDateStr = req.getParameter("startDateStr");
		String endDateStr = req.getParameter("endDateStr");
		String custId = req.getParameter("userIdHidden");
		Report rpt = new Report();
		rpt.setStartDate(startDateStr);
		rpt.setEndDate(endDateStr);
		Account user = (Account)req.getSession().getAttribute(Const.WEB_ACCOUNT);
		String filename = null;
		if(user.getAccountType() == 3){
			rpt.setCustid(user.getCustId());
			filename = StringUtil.formatCode(3, user.getCustId());
		}else{
			if(!StringUtil.isEmpty(custId)){
				int userId = Integer.parseInt(custId);
				rpt.setCustid(userId);
				filename = StringUtil.formatCode(3, userId);
			}else{
				filename = "All";
			}
		}
		rpt.setUsergoodscode(req.getParameter("usergoodscode"));
		rpt.setType(req.getParameter("type"));
		filename = filename + "_" + startDateStr + "_" + endDateStr;
		List<Report> reportList = reportService.storagelist4Export(rpt);
		ExpExcel.exportReport(filename, config.getStorageExportTemplate(), res, req, reportList);
	}

	@RequestMapping("transactionlist")
	public String transactionlist(Model model) {
		return "report/transactionlist";
	}

	@RequestMapping("transactionlistPage")
	@ResponseBody
	public PageResult<Report> transactionlist(Report report, HttpSession session) {
		Account user = (Account)session.getAttribute(Const.WEB_ACCOUNT);
		if(user.getAccountType() == 3){
			report.setCustid(user.getCustId());
		}
		return reportService.transactionListByDate(report);
	}

	@RequestMapping("exportTransactionExcel")
	public void exportTransactionExcel(HttpServletRequest req, HttpServletResponse res){
		String startDateStr = req.getParameter("startDateStr");
		String endDateStr = req.getParameter("endDateStr");
		String custId = req.getParameter("userIdHidden");
		Report rpt = new Report();
		rpt.setStartDate(startDateStr);
		rpt.setEndDate(endDateStr);
		Account user = (Account)req.getSession().getAttribute(Const.WEB_ACCOUNT);
		String filename = null;
		if(user.getAccountType() == 3){
			rpt.setCustid(user.getCustId());
			filename = StringUtil.formatCode(3, user.getCustId());
		}else{
			if(!StringUtil.isEmpty(custId)){
				int userId = Integer.parseInt(custId);
				rpt.setCustid(userId);
				filename = StringUtil.formatCode(3, userId);
			}else{
				filename = "All";
			}
		}
		filename = filename + "_" + startDateStr + "_" + endDateStr;
		rpt.setUsergoodscode(req.getParameter("usergoodscode"));
		rpt.setOrderno(req.getParameter("orderno"));
		List<Report> reportList = reportService.transactionListByDate4Report(rpt);
		ExpExcel.exportReport(filename, config.getTransactionReportTemplate(), res, req, reportList);
	}
	
	@RequestMapping("goodslist")
	public String goodslist(Model model) {
		return "report/goodslist";
	}

	@RequestMapping("goodslistPage")
	@ResponseBody
	public PageResult<Goods> goodslistPage(Goods goods, HttpSession session) {
		Account user = (Account)session.getAttribute(Const.WEB_ACCOUNT);
		if(user.getAccountType() == 3){
			goods.setCreateuserid(user.getCustId());
		}
		return reportService.goodslistByDate(goods);
	}
	
	@RequestMapping("exportGoodsExcel")
	public void exportGoodsExcel(HttpServletRequest req, HttpServletResponse res){
		String startDateStr = req.getParameter("startDateStr");
		String endDateStr = req.getParameter("endDateStr");
		String custId = req.getParameter("userIdHidden");
		Goods rpt = new Goods();
		rpt.setStartDate(startDateStr);
		rpt.setEndDate(endDateStr);
		Account user = (Account)req.getSession().getAttribute(Const.WEB_ACCOUNT);
		String filename = null;
		if(user.getAccountType() == 3){
			rpt.setCreateuserid(user.getCustId());
			filename = StringUtil.formatCode(3, user.getCustId());
		}else{
			if(!StringUtil.isEmpty(custId)){
				int userId = Integer.parseInt(custId);
				rpt.setCreateuserid(userId);
				filename = StringUtil.formatCode(3, userId);
			}else{
				filename = "All";
			}
		}
		filename = filename + "_" + startDateStr + "_" + endDateStr;
		rpt.setCiqgoodsno(req.getParameter("ciqgoodsno"));
		rpt.setRegistno(req.getParameter("registno"));
		rpt.setCopgno(req.getParameter("copgno"));
		rpt.setUsergoodscode(req.getParameter("usergoodscode"));
		List<Goods> reportList = reportService.goodslist4Export(rpt);
		ExpExcel.exportReport(filename, config.getGoodsRegisterReport(), res, req, reportList);
	}
	
	@RequestMapping("orderstatuslist")
	public String orderstatuslist(Model model) {
		return "report/orderstatuslist";
	}

	@RequestMapping("listOrderStatusPage")
	@ResponseBody
	public PageResult<Report> listOrderStatusPage(Report report, HttpSession session) {
		Account user = (Account)session.getAttribute(Const.WEB_ACCOUNT);
		if(user.getAccountType() == 3){
			report.setCustid(user.getCustId());
		}
		return reportService.orderStatusListByDate(report);
	}

	@RequestMapping("exportOrderStatuslist")
	@ResponseBody
	public void exportOrderStatuslist(HttpServletRequest req,
			HttpServletResponse res) {
		String startDateStr = req.getParameter("startDateStr");
		String endDateStr = req.getParameter("endDateStr");
		String custId = req.getParameter("userIdHidden");
		Report rpt = new Report();
		rpt.setStartDate(startDateStr);
		rpt.setEndDate(endDateStr);
		Account user = (Account)req.getSession().getAttribute(Const.WEB_ACCOUNT);
		String filename = null;
		if(user.getAccountType() == 3){
			rpt.setCustid(user.getCustId());
			filename = StringUtil.formatCode(3, user.getCustId());
		}else{
			if(!StringUtil.isEmpty(custId)){
				int userId = Integer.parseInt(custId);
				rpt.setCustid(userId);
				filename = StringUtil.formatCode(3, userId);
			}else{
				filename = "All";
			}
		}
		filename = filename + "_" + startDateStr + "_" + endDateStr;
		rpt.setRecname(req.getParameter("recname"));
		rpt.setOrderno(req.getParameter("orderno"));
		rpt.setEntRecordNo(req.getParameter("entRecordNo"));
		rpt.setStatusStr(req.getParameter("statusStr"));
		List<Report> reportList = reportService.orderStatusListByDate4Export(rpt);
		ExpExcel.exportReport(filename, config.getOrderStatusExportReportTemplate(), res, req, reportList);
	}
}
