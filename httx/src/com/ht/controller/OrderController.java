package com.ht.controller;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
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
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.ht.mapper.CompanyMapper;
import com.ht.mapper.DictDataMapper;
import com.ht.mapper.GMUserMapper;
import com.ht.mapper.OrderGoodsMapper;
import com.ht.model.Account;
import com.ht.model.Company;
import com.ht.model.CompanyExample;
import com.ht.model.DictData;
import com.ht.model.Ewaybill;
import com.ht.model.GMUser;
import com.ht.model.Goods;
import com.ht.model.OrderGoods;
import com.ht.model.OrderGoodsDetail;
import com.ht.model.OrderInfo;
import com.ht.model.PageResult;
import com.ht.model.UIReturn;
import com.ht.model.UserGoods;
import com.ht.model.reportmodel.EBill;
import com.ht.model.reportmodel.EBillList;
import com.ht.model.reportmodel.EBillReport;
import com.ht.model.reportmodel.EOrder;
import com.ht.model.reportmodel.EOrderGood;
import com.ht.model.reportmodel.ImportCheckContent;
import com.ht.model.reportmodel.ImportCheckHead;
import com.ht.model.reportmodel.ImportCheckReport;
import com.ht.model.reportmodel.OrderHGReport;
import com.ht.model.reportmodel.PickGoodReport;
import com.ht.model.reportmodel.PickGoodTotalReport;
import com.ht.servie.EWaybillService;
import com.ht.servie.GMUserService;
import com.ht.servie.GoodsService;
import com.ht.servie.OrderGoodsService;
import com.ht.servie.OrderService;
import com.ht.util.Config;
import com.ht.util.Const;
import com.ht.util.DownLoadZipFiles;
import com.ht.util.ExpExcel;
import com.ht.util.FileUtil;
import com.ht.util.FreeMarkerUtils;
import com.ht.util.StringUtil;

@Controller
@RequestMapping("/order/*")
public class OrderController {

    @Autowired
    private EWaybillService eWaybillService;

    @Autowired
    private OrderGoodsMapper orderGoodsMapper;

    @Autowired
    private	DictDataMapper dictDataMapper;

    @Autowired
    private OrderService orderService;

    @Autowired
    private OrderGoodsService orderGoodsService;

    @Autowired
    private GoodsService goodsService;

    @Autowired
    private Config config;

    @Autowired
    private GMUserMapper userMapper;

    @Autowired
    private CompanyMapper companyMapper;

    @Autowired
    private DictDataMapper dictMapper;

    @Autowired
    private GMUserService gMUserService;

    private static final Logger log = LoggerFactory
            .getLogger(OrderController.class);

    @RequestMapping("list")
    public String list(Model model) {
        model.addAttribute("customerList", userMapper.getActiveUserList());

        return "order/orderlist";
    }

    @RequestMapping("add")
    public String add(HttpServletRequest req, Model model) {

        model.addAttribute("customerList", userMapper.getActiveUserList());
        model.addAttribute("companyList", companyMapper
                .selectByExample(new CompanyExample()));
//		model.addAttribute("currList", dictMapper.listAllCurrency());

        String orderid = req.getParameter("id");
        if (orderid != null) {
            OrderInfo order = orderService.getByKey(orderid);
            model.addAttribute("order", order);
        }

        return "order/add";
    }

    @RequestMapping(value = "save")
    @ResponseBody
    public UIReturn save(@RequestBody OrderInfo order, HttpSession session) {
        UIReturn rtn = new UIReturn();

        try {
            if (!StringUtil.isEmpty(order.getOrderid())) {
                return orderService.saveEdit(order);
            } else {
                order.setOrderstatus("S");
                order.setStatus("0");
                order.setOrderdate(new Date());
                Account user = (Account)session.getAttribute(Const.WEB_ACCOUNT);
                order.setCreateruserid(user.getId());
                order.setFirstcreatename(user.getLoginName());
                return orderService.save(order);
            }

        } catch (Exception ex) {
            rtn.setCode(99);
            rtn.setErrorMsg("保存订单失败！");
            ex.printStackTrace();
            log.error("保存订单失败！" + ex.getMessage());

        }
        return null;
    }

    @RequestMapping("saveDetails")
    @ResponseBody
    public UIReturn saveDetails(@RequestBody OrderGoods orderGoods) {
        UIReturn rtn = new UIReturn();
        try {

            // 计算总价
            orderGoods.setDecltotal(orderGoods.getDecprice().multiply(new BigDecimal(orderGoods.getGqty())));

            rtn = orderGoodsService.save(orderGoods);
        } catch (Exception ex) {
            log.error("订单商品失败!", ex);
            rtn.setCode(99);
            rtn.setErrorMsg(ex.getMessage());
            rtn.setSuccess(false);
        }
        return rtn;
    }

    @RequestMapping("listGoods")
    @ResponseBody
    public PageResult<OrderGoodsDetail> listGoods(
            @RequestParam("orderid") String orderid) {

        return orderGoodsService.listOrderGoodsDetailByOrderId(orderid);
    }

    @RequestMapping("importinit")
    public String importInit(Model model) {
        model.addAttribute("customerList",userMapper.getActiveUserList());
        model.addAttribute("companyList",companyMapper.selectByExample(new CompanyExample()));
        model.addAttribute("currList", dictMapper.listAllCurrency());
        return "order/import";
    }

    @RequestMapping("import")
    @ResponseBody
    public void importFile(@RequestParam(value="importFile", required=true) MultipartFile file, HttpServletRequest req,HttpServletResponse res){
        UIReturn rtn = new UIReturn();
        try {
            orderService.importFile(file, req);
            rtn.setCode(0);
            rtn.setSuccess(true);
        } catch (Exception ex) {
            log.error("导入入库单失败!",ex);
            rtn.setCode(99);
            rtn.setErrorMsg(ex.getMessage());
            rtn.setSuccess(false);
        }
        res.reset();
        res.setHeader("Content-Type", "application/json;charset=UTF-8");
        res.setContentType("text/html");
        try {
            res.getWriter().write(StringUtil.getJsonMapper().writeValueAsString(rtn));
        } catch (IOException e) {
            log.error("Write response string fail.",e);
        }
    }

    @RequestMapping("showdetail")
    public String showdetail(HttpServletRequest req, Model model) {

        model.addAttribute("customerList", userMapper.getActiveUserList());
        model.addAttribute("companyList", companyMapper
                .selectByExample(new CompanyExample()));
//		model.addAttribute("currList", dictMapper.listAllCurrency());

        String orderid = req.getParameter("orderid");
        if (orderid != null) {
            OrderInfo order = orderService.getByKey(orderid);
            model.addAttribute("order", order);
        }

        return "order/orderdetail";
    }

    @RequestMapping("downloadOrderTemplate")
    public void downloadOrderTemplate(HttpServletRequest req,
                                      HttpServletResponse response) {
        String templatePath = req.getSession().getServletContext().getRealPath(
                "/")
                + config.getTemplateFolder()
                + File.separator
                + "order_import_template.xls";
        FileUtil.download(templatePath, response);

    }

    @RequestMapping("listPage")
    @ResponseBody
    public PageResult<OrderInfo> listPage(OrderInfo order) {

        return orderService.listPage(order);
    }

    @RequestMapping("delete/{id}")
    @ResponseBody
    public UIReturn delete(@PathVariable String id) {
        return orderService.delete(id);
    }

    @RequestMapping("cancel/{id}")
    @ResponseBody
    public UIReturn cancel(@PathVariable String id) {
        return orderService.cancel(id);
    }

    @RequestMapping("exportOrderHG")
    @ResponseBody
    public void exportOrderHG(HttpServletRequest req,
                              HttpServletResponse response) {

        String ids = req.getParameter("ids");
        List<OrderInfo> list = orderService.selectByExample(ids);

        List<File> fileList = new ArrayList<File>();

        for (OrderInfo order : list) {
            String orderid = order.getOrderid();

            List<EOrderGood> listEorder = new ArrayList<EOrderGood>();

            Company company = companyMapper.selectByPrimaryKey(order
                    .getCompanyid());

            EOrder eOrder =new EOrder();



            eOrder.setOrderId(order.getEntrecordno());
            eOrder.setOrderStatus(order.getOrderstatus());
            eOrder.setEntRecordNo(company.getRegistno());
            eOrder.setEntRecordName(company.getName());
            eOrder.setOrderName(order.getOrdername());
            eOrder.setOrderDocId(order.getOrderdocid());
            eOrder.setOrderPhone(order.getOrderphone());



            eOrder.setTax(order.getTax().toString());
            eOrder.setFreight(order.getFreight().toString());
            eOrder.setNote(order.getNote());
            eOrder.setOrderDate(StringUtil.date2String(order.getOrderdate(), "yyyy-MM-dd"));

            BigDecimal orderGoodTotal = new BigDecimal(0);

            // 获取关联商品信息
            List<OrderGoods> listGoods = orderGoodsService
                    .selectByExample(orderid);


            // 获取商品详情
            for (OrderGoods orderGood : listGoods) {
                Goods good = goodsService.getByKey(orderGood.getGoodsid());

                EOrderGood eOrderGood = new EOrderGood();

                eOrderGood.setCopGNo(good.getCopgno());
                eOrderGood.setDeclTotal(orderGood.getDecprice().multiply(new BigDecimal(orderGood.getGqty())).toString());
                eOrderGood.setDecPrice(orderGood.getDecprice().toString());
                eOrderGood.setUnit(good.getUnit());
                eOrderGood.setgQty(orderGood.getGqty().toString());
                eOrderGood.setNotes(orderGood.getNote());
                eOrderGood.setCustomsListNO(good.getRegistno());
                eOrder.setFreightCurr("142");
                eOrder.setTaxCurr("142");
                listEorder.add(eOrderGood);

                orderGoodTotal =orderGoodTotal.add(orderGood.getDecprice().multiply(new BigDecimal(orderGood.getGqty())));
            }

            eOrder.setOrderGoodTotal(orderGoodTotal.toString());

            OrderHGReport tr = new OrderHGReport();

            Map<String, Object> data = new HashMap<String, Object>();

            tr.setOrder(eOrder);
            tr.setGoods(listEorder);
            data.put("tr", tr);

            String filename = config.getExportPath() + File.separator
                    + "EOrder" + File.separator + "880020"
                    + tr.getYyyyMMddHHmmSSS() + ".xml";

            FreeMarkerUtils.initFreeMarker(req.getSession().getServletContext()
                    .getRealPath("/")
                    + config.getTemplateFolder(), config.getExportPath());

            FreeMarkerUtils.createFile(data, config
                    .geteOrderHGTemplateFileName(), filename, true);

            fileList.add(new File(filename));

        }
        try {
            String outFileName = config.getExportPath() + File.separator+ "EOrder" + File.separator +"EOrder_"+StringUtil.getNowDateString()+".zip";
            DownLoadZipFiles.downLoadFiles(fileList, response,outFileName);
        } catch (Exception e) {
            log.error("导出电子订单压缩包出错");
            e.printStackTrace();

        }
    }

    @RequestMapping("exportPickGoods")
    @ResponseBody
    public void exportPickGoods(HttpServletRequest req,
                                HttpServletResponse response) {

        String ids = req.getParameter("ids");
        List<OrderInfo> list = orderService.selectByExample(ids);

        // 拣货单号
        String pickgoodsno = StringUtil.getCurrentTimestampStr();

        List<PickGoodReport> lstPickGood = new ArrayList<PickGoodReport>();


        Map<String,Integer> instKeyMap = new HashMap<String,Integer>();

        List<DictData> listDictData =	dictDataMapper.listAllUnits();

        Map<String,String> unitCodeMap = new HashMap<String,String>();
        for(DictData dictData:listDictData)
        {
            unitCodeMap.put(dictData.getCodeNo(), dictData.getCodeName());
        }


        for (OrderInfo order : list) {
            // 获取关联商品信息
            List<OrderGoods> listGoods = orderGoodsService
                    .selectByExample(order.getOrderid());

            GMUser gMUser = gMUserService.getByKey(order.getEntrecordname());
            // 获取商品详情
            for (OrderGoods orderGood : listGoods) {
                Goods good = goodsService.getByKey(orderGood.getGoodsid());

                Map<String,Integer> paramMap=new HashMap<String,Integer>();
                paramMap.put("custid", order.getEntrecordname());
                paramMap.put("goodsid", orderGood.getGoodsid());

                UserGoods userGoods = orderGoodsMapper.getUserGoodsDetails(paramMap);

                PickGoodReport pickGood = new PickGoodReport();

                String instkey =userGoods.getINSTKEY();
                pickGood.setInstKey(instkey);
                pickGood.setOrderId(order.getOrderid());
                pickGood.seteOrderId(order.getEntrecordno());
                pickGood.setEntRecordName(gMUser.getGmusername());
                pickGood.setOrdername(order.getOrdername());
                pickGood.setOrderdocid(order.getOrderdocid());
                pickGood.setOrderaddress(order.getOrderaddress());
                pickGood.setCopGNo(good.getCopgno());
                pickGood.setNotes(good.getGname());
                pickGood.setgQty(orderGood.getGqty().toString());
                pickGood.setUnit((String) unitCodeMap.get(good.getUnit()));
                pickGood.setEwayno(order.getEwaysnum());
                lstPickGood.add(pickGood);



                if(instKeyMap.containsKey(instkey))
                {
                    instKeyMap.put(instkey, instKeyMap.get(instkey)+orderGood.getGqty());
                }
                else
                {
                    instKeyMap.put(instkey, orderGood.getGqty());
                }
            }

        }

        List<PickGoodTotalReport> pickGoodTotalReportLst= new ArrayList<PickGoodTotalReport>();

        for (String key : instKeyMap.keySet()) {
            PickGoodTotalReport pickGoodTotalReport = new PickGoodTotalReport();

            pickGoodTotalReport.setInstKey(key);
            pickGoodTotalReport.setTotalQty(instKeyMap.get(key));

            List<PickGoodTotalReport> ls = orderGoodsMapper.getPickGoodTotalDetails(key);

            StringBuffer sb = new StringBuffer("");
            for(PickGoodTotalReport pickGoodTotaldetail:ls)
            {
                sb.append(pickGoodTotaldetail.getBatchno());
                sb.append("/");
            }
            pickGoodTotalReport.setBatchTotal(sb.toString());

            pickGoodTotalReportLst.add(pickGoodTotalReport);
        }

        orderService.updatePickupNoByExample(pickgoodsno,ids);

        ExpExcel.exportPickGoodsReport(pickgoodsno, "pickgoods_template.xls", response, req,
                lstPickGood,pickGoodTotalReportLst);
    }

    @RequestMapping("exportImportlistHG")
    @ResponseBody
    @SuppressWarnings("unused")
    public void exportImportlistHG(HttpServletRequest req,
                                   HttpServletResponse response) {

        String ids = req.getParameter("ids");
        List<OrderInfo> list = orderService.selectByExample(ids);

        List<File> fileList = new ArrayList<File>();
        for (OrderInfo order : list) {
            EBillReport tr = new EBillReport();

            Company company = companyMapper.selectByPrimaryKey(order
                    .getCompanyid());

            GMUser gMUser = gMUserService.getByKey(order.getEntrecordname());

            if(StringUtil.isEmpty(order.getEwaysnum()))
            {
                StringUtil.toUTF8(response, "请先填写运单信息！");
                return;
            }
            Ewaybill ewaybill = eWaybillService.getByKey(order.getEwaysnum());

            // 获取关联商品信息
            List<OrderGoods> listGoods = orderGoodsService
                    .selectByExample(order.getOrderid());

            EBill ebill = new EBill();
            ebill.setReceiveName(order.getOrdername());
            if(null != order.getArea())
            {
                ebill.setRecipientProvincesCode(order.getArea().toString());
            }else if(null != order.getCity()){
                ebill.setRecipientProvincesCode(order.getCity().toString());
            }else if(null != order.getProvince()){
                ebill.setRecipientProvincesCode(order.getProvince().toString());
            }
            ebill.setReceiveAddr(order.getProvincename()+order.getCityname()+order.getAreaname()+order.getOrderaddress());
            ebill.setReceiveNo(order.getOrderdocid());
            ebill.setOrderName(order.getOrdername());
            ebill.setOrderDocType(order.getOrderdoctype());
            ebill.setOrderDocId(order.getOrderdocid());
            ebill.seteWayBillId(order.getEwaysnum());
            ebill.setOrderId(order.getEntrecordno());
            if (null != ewaybill) {
                ebill.setFreight(ewaybill.getFreight().toString());
            }

            ebill.setFreightCurr(order.getOrdergoodtotalcurr());
            String dateStr = StringUtil.dateTime2String(new Date());
            ebill.setDrDate(dateStr);
            ebill.setInputDate(dateStr);

            ebill.setEntInsideNo(order.getOrderid());
            List<EBillList> eBillList = new ArrayList<EBillList>();

            // 获取商品详情
            for (OrderGoods orderGood : listGoods) {
                Goods good = goodsService.getByKey(orderGood.getGoodsid());
                EBillList eBilllst = new EBillList();

                eBilllst.setCustomsListNO(good.getRegistno());
                eBilllst.setQty(orderGood.getGqty().toString());
                eBilllst.setDecPrice(orderGood.getDecprice().toString());
                eBilllst.setDecTotal(orderGood.getDecprice().multiply(new BigDecimal(orderGood.getGqty())).toString());
                eBilllst.setCurr(order.getOrdergoodtotalcurr());
                eBilllst.setGrossWt(good.getGrosswt().multiply(new BigDecimal(orderGood.getGqty())).toString());
                eBilllst.setNetWt(good.getNetwt().multiply(new BigDecimal(orderGood.getGqty())).toString());
                eBillList.add(eBilllst);

            }

            Map<String, Object> data = new HashMap<String, Object>();
            tr.setSenderID(company.getRegistno());
            tr.setReceiverID(company.getRegistno());
            tr.setCurrentTime(StringUtil.dateTime2String(new Date()));

            tr.seteBill(ebill);
            tr.seteBillList(eBillList);

            data.put("tr", tr);

            String filename = config.getExportPath() + File.separator + "ImportlistHG"
                    + File.separator + "881104" + tr.getYyyyMMddHHmmSSS()
                    + ".xml";

            FreeMarkerUtils.initFreeMarker(req.getSession().getServletContext()
                    .getRealPath("/")
                    + config.getTemplateFolder(), config.getExportPath());

            FreeMarkerUtils.createFile(data, config
                    .getImportListHGTemplateFileName(), filename, true);

            fileList.add(new File(filename));

        }

        try {
            String outFileName = config.getExportPath() + File.separator+ "ImportlistHG" + File.separator +"ImportlistHG_"+StringUtil.getNowDateString()+".zip";
            DownLoadZipFiles.downLoadFiles(fileList, response,outFileName);
        } catch (Exception e) {
            log.error("导出海关进境电子清单压缩包出错");
            e.printStackTrace();

        }
    }

    @RequestMapping("exportImportlistCheck")
    @ResponseBody
    public void exportImportlistCheck(HttpServletRequest req,
                                      HttpServletResponse response) {

        String ids = req.getParameter("ids");
        List<OrderInfo> list = orderService.selectByExample(ids);
        List<File> fileList = new ArrayList<File>();
        for (OrderInfo order : list) {
            ImportCheckReport tr = new ImportCheckReport();

            ImportCheckHead importCheckHead = new ImportCheckHead();
            importCheckHead.setConsigneeName(order.getOrdername());
            importCheckHead.setConsigneeAddr(order.getProvincename()+order.getCityname()+order.getAreaname()+ order.getOrderaddress());
            importCheckHead.setConsigneeIdNo(order.getOrderdocid());
            importCheckHead.setInputDate(StringUtil.date2String(order
                    .getOrderdate(), "yyyyMMddhhmmss"));
            importCheckHead.setNotes(order.getNote());

            // 获取关联商品信息
            List<OrderGoods> listGoods = orderGoodsService
                    .selectByExample(order.getOrderid());

            List<ImportCheckContent> lstContent = new ArrayList<ImportCheckContent>();

            // 获取商品详情
            for (OrderGoods orderGood : listGoods) {
                Goods good = goodsService.getByKey(orderGood.getGoodsid());
                ImportCheckContent content = new ImportCheckContent();
                content.setGoodsBatchNo(good.getBatchid());
                content.setcIQGoodsNo(good.getCiqgoodsno());
                content.setGoodsName(good.getGname());
                content.setQty(orderGood.getGqty().toString());
                content.setDeclarePrice(orderGood.getDecprice().toString());

                // 计算总价
                content.setDeclareTotalAmount(orderGood.getDecprice().multiply(new BigDecimal(orderGood.getGqty())).toString());
                content.setGrossWeight(good.getGrosswt().toString());
                content.setNetWeight(good.getNetwt().toString());
                content.setNotes(good.getGdesc());

                lstContent.add(content);

            }

            Map<String, Object> data = new HashMap<String, Object>();
            tr.setImportCheckHead(importCheckHead);
            tr.setLstContent(lstContent);

            data.put("tr", tr);

            String filename = config.getExportPath() + File.separator
                    + "ImportListCheck" + File.separator + "DS"
                    + tr.getYyyyMMddHHmmSSS() + ".xml";

            FreeMarkerUtils.initFreeMarker(req.getSession().getServletContext()
                    .getRealPath("/")
                    + config.getTemplateFolder(), config.getExportPath());

            FreeMarkerUtils.createFile(data, config
                    .getImportListCheckTemplateFileName(), filename, true);

            fileList.add(new File(filename));

        }

        try {
            String outFileName = config.getExportPath() + File.separator+ "ImportListCheck" + File.separator +"ImportListCheck_"+StringUtil.getNowDateString()+".zip";
            DownLoadZipFiles.downLoadFiles(fileList, response,outFileName);
        } catch (Exception e) {
            log.error("导出商检进境电子清单压缩包出错");
            e.printStackTrace();

        }
    }

    @RequestMapping("updateOrderStatus")
    @ResponseBody
    @Transactional(rollbackFor={Throwable.class})
    public UIReturn updateOrderStatus(HttpServletRequest req) {

        String ids = req.getParameter("ids");
        List<OrderInfo> list = orderService.selectByExample(ids);

        for (OrderInfo order:list)
        {
            if(!"2".equals(order.getStatus()))
            {
                continue;
            }
            orderService.updateOrderStatus(order.getOrderid());
        }
        UIReturn rtn =	new UIReturn();
        rtn.setCode(Const.UI_SUCCESS);
        return rtn;
    }


    @RequestMapping("released")
    @ResponseBody
    @Transactional(rollbackFor={Throwable.class})
    public UIReturn released(HttpServletRequest req) {

        Account user = (Account)req.getSession().getAttribute(Const.WEB_ACCOUNT);

        String ids = req.getParameter("ids");
        try {
            orderService.releasedByTransactional(ids , user.getId());
        } catch (Exception e) {
            // 抛异常
            UIReturn rtn = new UIReturn();
            rtn.setCode(Const.UI_ERROR);
            rtn.setSuccess(false);
            rtn.setErrorMsg("订单出库失败！库存总量少于订单出库量");
            log.error("订单出库失败！库存总量少于订单出库量，orderids=" +ids );
            return rtn;
        }
        UIReturn rtn =	new UIReturn();
        rtn.setCode(Const.UI_SUCCESS);
        return rtn;
    }

    @RequestMapping("deleteDetails/{id}")
    @ResponseBody
    public UIReturn deleteDetails(@PathVariable int id) {
        return orderGoodsService.delete(id);
    }

    @RequestMapping("showSelectGoods")
    public String showSelectGoods(HttpServletRequest req, Model model) {
        model.addAttribute("userKey", req.getParameter("userKey"));
        return "order/addGoods";
    }
}
