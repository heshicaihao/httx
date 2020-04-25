package com.ht.controller;

import java.io.File;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ht.mapper.CompanyMapper;
import com.ht.model.Company;
import com.ht.model.Ewaybill;
import com.ht.model.GMUser;
import com.ht.model.Goods;
import com.ht.model.OrderGoods;
import com.ht.model.OrderInfo;
import com.ht.model.UIReturn;
import com.ht.model.reportmodel.EWayBill;
import com.ht.model.reportmodel.TransportHGReport;
import com.ht.servie.EWaybillService;
import com.ht.servie.GMUserService;
import com.ht.servie.GoodsService;
import com.ht.servie.OrderGoodsService;
import com.ht.servie.OrderService;
import com.ht.util.Config;
import com.ht.util.DownLoadZipFiles;
import com.ht.util.FreeMarkerUtils;
import com.ht.util.StringUtil;

@Controller
@RequestMapping("/ewaybill/*")
public class EWaybillController {

	private static final Logger log = LoggerFactory
			.getLogger(EWaybillController.class);

	@Autowired
	private EWaybillService eWaybillService;

	@Autowired
	private OrderService orderService;

	@Autowired
	private GoodsService goodsService;

	@Autowired
	private OrderGoodsService orderGoodsService;

	@Autowired
	private CompanyMapper companyMapper;

	@Autowired
	private GMUserService gMUserService;

	@Autowired
	private Config config;

	@RequestMapping("add")
	public String add(HttpServletRequest req, Model model) {
		String orderid = req.getParameter("orderid");
		Ewaybill ewaybill = new Ewaybill();
		ewaybill.setOrderid(orderid);
		model.addAttribute("ewaybill", ewaybill);
		return "order/addewaybill";
	}

	@RequestMapping(value = "save", method = RequestMethod.POST)
	@ResponseBody
	public UIReturn save(@RequestBody Ewaybill ewaybill, HttpServletRequest req ,HttpServletResponse response) {
		UIReturn rtn = new UIReturn();
		try {
			OrderInfo orderInfo = new OrderInfo();
			orderInfo.setOrderid(ewaybill.getOrderid());
			orderInfo.setEwaysnum(ewaybill.getWaybillno());

			orderService.saveEdit(orderInfo);

			ewaybill.setDeclaretype("1");
			ewaybill.setLogisticsstatus("发货");
			
			if(ewaybill.getId() != null)
			{
				eWaybillService.deleteByPrimaryKey(ewaybill.getId());
			}
			
			rtn = eWaybillService.save(ewaybill);	


		} catch (Exception ex) {
			rtn.setCode(99);
			rtn.setErrorMsg("发生未知异常!");
			log.error("保存运单信息失败！", ex);
		}
		return rtn;
	}

	@RequestMapping(value = "showdetail")
	public String showDetail(HttpServletRequest req, Model model) {
		String waybillno = req.getParameter("waybillno");
		String status = req.getParameter("status");
		Ewaybill ewaybill = eWaybillService.getByKey(waybillno);
		model.addAttribute("ewaybill", ewaybill);
		
		if("0".equals(status) || "2".equals(status))
		{
			
			return "order/addewaybill";
		}
		else
		{
			return "order/ewaybilldetail";
		}

	}

	@RequestMapping("exportTransportHG")
	@ResponseBody
	public void exportTransportHG(HttpServletRequest req, HttpServletResponse response) {

		String ids = req.getParameter("ids");
		List<OrderInfo> list = orderService.selectByExample(ids);
		List<File> fileList = new ArrayList<File>(); 
		for (OrderInfo orderInfo : list) {
			
			if(StringUtil.isEmpty(orderInfo.getEwaysnum()))
			{
				StringUtil.toUTF8(response, "请先填写运单信息！");
				return;
			}
			
		Ewaybill ewaybill =eWaybillService.getByKey(orderInfo.getEwaysnum());

		Company company = companyMapper.selectByPrimaryKey(orderInfo
				.getCompanyid());

		GMUser gMUser = gMUserService.getByKey(orderInfo.getEntrecordname());

		String orderid = ewaybill.getOrderid();

		List<EWayBill> listEWayBillReport = new ArrayList<EWayBill>();

		// 获取关联商品信息
		List<OrderGoods> listGoods = orderGoodsService.selectByExample(orderid);


		EWayBill eWayBill = new EWayBill();
//		String subOrderId = orderInfo.getEntrecordno() + StringUtil.formatCode(2, 1);

		eWayBill.setOrderId(orderInfo.getEntrecordno());
		eWayBill.setEntRecordNo(company.getRegistno());
		eWayBill.setEntRecordName(company.getName());
		eWayBill.setWayBillNo(ewaybill.getWaybillno());
		eWayBill.setFreight(ewaybill.getFreight().toString());
		eWayBill.setFreightCurr(orderInfo.getOrdergoodtotalcurr());
		eWayBill.setValuationFee(ewaybill.getValuationfee().toString());
		eWayBill.setValuationFeeCurr(orderInfo.getOrdergoodtotalcurr());

		eWayBill.setRecipientName(orderInfo.getOrdername());
		if(null != orderInfo.getArea())
		{
			eWayBill.setRecipientProvincesCode(orderInfo.getArea().toString());
		}else if(null != orderInfo.getCity()){
			eWayBill.setRecipientProvincesCode(orderInfo.getCity().toString());
		}else if(null != orderInfo.getProvince()){
			eWayBill.setRecipientProvincesCode(orderInfo.getProvince().toString());
		}
		
		eWayBill.setRecipientDetailedAddress(orderInfo.getProvincename()+orderInfo.getCityname()+orderInfo.getAreaname()+orderInfo.getOrderaddress());
		eWayBill.setRecipientPhone(orderInfo.getOrderphone());
		eWayBill.setShipperName(gMUser.getGmusername());
		eWayBill.setNoticeNo(ewaybill.getWaybillno());
		
		BigDecimal totalNetwt =new BigDecimal(0);
		BigDecimal totalGrosswt =new BigDecimal(0);
		int totalNum = 0;
		String goodInfo = "";
		
		// 获取商品详情
		for (OrderGoods orderGood : listGoods) {
			Goods good = goodsService.getByKey(orderGood.getGoodsid());
			totalNetwt = totalNetwt.add(good.getNetwt().multiply(new BigDecimal(orderGood.getGqty())));
			totalGrosswt =totalGrosswt.add(good.getGrosswt().multiply(new BigDecimal(orderGood.getGqty())));
			goodInfo = goodInfo +good.getGname()+"/";
			totalNum =totalNum + orderGood.getGqty();
		}

		eWayBill.setNetWt(totalNetwt.toString());
		eWayBill.setGrossWt(totalGrosswt.toString());
		eWayBill.setNum(totalNum+"");
		eWayBill.setGoodInfo(goodInfo);
		
		listEWayBillReport.add(eWayBill);
		
		TransportHGReport tr = new TransportHGReport();
		tr.setSenderID(company.getRegistno());
		tr.seteWayBills(listEWayBillReport);

		Map<String, Object> data = new HashMap<String, Object>();

		data.put("tr", tr);

		System.out.println(new File("").getPath());

		String filename = config.getExportPath() + File.separator+ "EWayBill" + File.separator + "880022"
				+ tr.getYyyyMMddHHmmSSS() + ".xml";

		FreeMarkerUtils.initFreeMarker(req.getSession().getServletContext()
				.getRealPath("/")
				+ config.getTemplateFolder(), config.getExportPath());

		FreeMarkerUtils.createFile(data, config
				.geteTransportHGTemplateFileName(), filename, true);
		
		fileList.add(new File(filename));

		}
		try {
			String outFileName = config.getExportPath() + File.separator+ "EWayBill" + File.separator +"EWayBill_"+StringUtil.getNowDateString()+".zip";
			DownLoadZipFiles.downLoadFiles(fileList, response,outFileName);
		} catch (Exception e) {
			log.error("导出电子运单压缩包出错");
			e.printStackTrace();

		}
	}
}
