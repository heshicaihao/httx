package com.ht.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
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

import com.ht.mapper.CompanyMapper;
import com.ht.mapper.GMUserMapper;
import com.ht.mapper.GoodsMapper;
import com.ht.model.Account;
import com.ht.model.CompanyExample;
import com.ht.model.IntEntrepot;
import com.ht.model.IntEntrepotDetail;
import com.ht.model.PageResult;
import com.ht.model.UIReturn;
import com.ht.model.reportmodel.IntEntRepotHGReport;
import com.ht.servie.IntEntrepotService;
import com.ht.util.Config;
import com.ht.util.Const;
import com.ht.util.ExpExcel;
import com.ht.util.FileUtil;
import com.ht.util.FreeMarkerUtils;
import com.ht.util.HTException;
import com.ht.util.StringUtil;

@Controller
@RequestMapping("/intentrepot/*")
public class intEntrepotController {

	private static final Logger log = LoggerFactory.getLogger(intEntrepotController.class);
	
	@Autowired
	private IntEntrepotService intEntrepotService;
	
	@Autowired
	private GoodsMapper goodsMapper;
	@Autowired
	private Config config;
	
	@Autowired
	private GMUserMapper userMapper;

	@Autowired
	private CompanyMapper companyMapper;

	@RequestMapping("list")
	public String list(Model model){
		return "intentrepot/list";
	}
	
	@RequestMapping("add")
	public String add(HttpServletRequest req, Model model,HttpSession session) throws JsonGenerationException, JsonMappingException, IOException{
		String instkey =req.getParameter("id");
		if(instkey!=null){
			IntEntrepot intEntrepot = intEntrepotService.getByKey(Integer.parseInt(instkey));
			model.addAttribute("intEntrepot",intEntrepot);
		}
		model.addAttribute("customerList",userMapper.getActiveUserList());
		model.addAttribute("companyList",companyMapper.selectByExample(new CompanyExample()));
		return "intentrepot/add";
	}
	@RequestMapping("addGoods")
	public String addGoods(){
		return "intentrepot/addGoods";
	}
	@RequestMapping(value="save",method=RequestMethod.POST)
	@ResponseBody
	public UIReturn save(@RequestBody IntEntrepot intEntrepot,HttpSession session){
		UIReturn rtn = null;
		try{
			Account user = (Account)session.getAttribute(Const.WEB_ACCOUNT);
			intEntrepot.setCreateuserid(user.getId());
			intEntrepot.setWritedate(new Date());
			intEntrepot.setBatchno(StringUtil.get4Date());
			rtn = intEntrepotService.save(intEntrepot);
		}catch(Exception ex){
			log.error("创建入库单失败!",ex);
			rtn.setCode(99);
			rtn.setSuccess(false);
			rtn.setErrorMsg("创建入库单失败!");
		}
		return rtn;
	}
	
	@RequestMapping("exportIntenrepotHG")
	@ResponseBody
	public void exportIntenrepotHG(HttpServletRequest req, HttpServletResponse response) {

		String id = req.getParameter("id");
		List<IntEntrepotDetail> list = intEntrepotService.get4ExportHGReport(Integer.parseInt(id));
		if(StringUtil.isEmpty(list)){
			PrintWriter writer = null;
			try{
				response.reset();
				response.setContentType("text/html; charset=UTF-8");
				writer = response.getWriter();
				writer.write("<script>alert('该入库单中没有商品信息!');</script>");
				writer.flush();
			}catch(Exception ex){
				log.error("return to front UI fail.",ex);
			}finally{
				if(null!=writer)
					writer.close();
				writer = null;
			}
			return;
		}
		IntEntRepotHGReport tr = new IntEntRepotHGReport();
		tr.setDetailsList(list);
		Map<String, Object> data = new HashMap<String, Object>();
		IntEntrepotDetail first = list.get(0);
		tr.setCompanyRegistNo(first.getCompanyregistNo());
		tr.setEntInsideNo(first.getNo());
		data.put("tr", tr);

		String filename = config.getExportPath() + File.separator + "881103" + tr.getYyyyMMdd() + first.getNo() + ".xml";

		FreeMarkerUtils.initFreeMarker(req.getSession().getServletContext().getRealPath("/") + config.getTemplateFolder(),config.getExportPath());

		FreeMarkerUtils.createFile(data, config.getIntEntRepotHGTemplate(), filename, true);

		FileUtil.download(filename, response);
	}
	
	@RequestMapping("exportIntenrepotCheck")
	@ResponseBody
	public void exportIntenrepotCheck(HttpServletRequest req, HttpServletResponse response) {

		String id = req.getParameter("id");
		List<IntEntrepotDetail> list = intEntrepotService.get4ExportHGReport(Integer.parseInt(id));
		if(StringUtil.isEmpty(list)){
			PrintWriter writer = null;
			try{
				response.reset();
				response.setContentType("text/html; charset=UTF-8");
				writer = response.getWriter();
				writer.write("<script>alert('该入库单中没有商品信息!');</script>");
				writer.flush();
			}catch(Exception ex){
				log.error("return to front UI fail.",ex);
			}finally{
				if(null!=writer)
					writer.close();
				writer = null;
			}
			return;
		}
		IntEntRepotHGReport tr = new IntEntRepotHGReport();
		tr.setDetailsList(list);
		Map<String, Object> data = new HashMap<String, Object>();
		IntEntrepotDetail first = list.get(0);
		tr.setCompanyRegistNo(first.getCompanyregistNo());
		tr.setInspectionRegistNo(first.getInspectionRegistNo());
		tr.setEntInsideNo(first.getNo());
		data.put("tr", tr);

		String filename = config.getExportPath() + File.separator + "881103" + tr.getYyyyMMdd() + first.getNo() + ".xml";

		FreeMarkerUtils.initFreeMarker(req.getSession().getServletContext().getRealPath("/") + config.getTemplateFolder(),config.getExportPath());

		FreeMarkerUtils.createFile(data, config.getIntEntRepotCheckTemplate(), filename, true);

		FileUtil.download(filename, response);
	}
	
	@RequestMapping("listGoods")
	@ResponseBody
	public PageResult<IntEntrepotDetail> listGoods(@RequestParam("id") int id){
		return intEntrepotService.listIntEntrepotDetailByIntEntrepotId(id);
	}
	
	@RequestMapping("listPage")
	@ResponseBody
	public PageResult<IntEntrepot> listPage(IntEntrepot intEntrepot){
		return intEntrepotService.listPage(intEntrepot);
	}
	
	@RequestMapping("delete/{id}")
	@ResponseBody
	public UIReturn delete(@PathVariable int id){
		return intEntrepotService.delete(id);
	}

	@RequestMapping("showSelectGoods")
	public String showSelectGoods(HttpServletRequest req, Model model){
		model.addAttribute("userKey", req.getParameter("userKey"));
		return "intentrepot/addGoods";
	}
	
	@RequestMapping("saveDetails")
	@ResponseBody
	public UIReturn saveDetails(@RequestBody IntEntrepotDetail intEntrepotDetail){
		UIReturn rtn = new UIReturn();
		try{
			intEntrepotService.saveDetails(intEntrepotDetail);
			rtn.setCode(0);
			rtn.setSuccess(true);
		}catch(Exception ex){
			log.error("商品入库失败!",ex);
			rtn.setCode(99);
			rtn.setErrorMsg(ex.getMessage());
			rtn.setSuccess(false);
		}
		return rtn;
	}
	
	@RequestMapping("deleteDetails/{id}")
	@ResponseBody
	public UIReturn deleteDetails(@PathVariable int id){
		return intEntrepotService.deleteDetails(id);
	}
	
	@RequestMapping("saveActNo")
	@ResponseBody
	public UIReturn saveActNo(@RequestBody Map<String,Object> paramMap, HttpSession session){
		UIReturn rtn = new UIReturn();
		try{
			Account user = (Account)session.getAttribute(Const.WEB_ACCOUNT);
			paramMap.put("incomeUserId",user.getId());
			intEntrepotService.saveActNo(paramMap);
			rtn.setCode(0);
			rtn.setSuccess(true);
		}catch(HTException ht){
			rtn.setCode(1);
			rtn.setErrorMsg(ht.getMessage());
			rtn.setSuccess(false);
		}
		catch(Exception ex){
			log.error("商品入库失败!",ex);
			rtn.setCode(99);
			rtn.setErrorMsg("商品入库失败，遇到未知错误!");
			rtn.setSuccess(false);
		}
		return rtn;
	}
	
	@RequestMapping("downloadTemplate")
	public void downloadOrderTemplate(HttpServletRequest req,
			HttpServletResponse response) {
		String templatePath = req.getSession().getServletContext().getRealPath(
				"/")
				+ config.getTemplateFolder()
				+ File.separator
				+ "intEntReport_import_template.xls";
		FileUtil.download(templatePath, response);

	}
	
	@RequestMapping("showImport")
	public String shwoImport(Model model){
		model.addAttribute("customerList",userMapper.getActiveUserList());
		model.addAttribute("companyList",companyMapper.selectByExample(new CompanyExample()));
		return "intentrepot/import";
	}
	
	@RequestMapping("import")
	@ResponseBody
	public void importFile(@RequestParam(value="importFile", required=true) MultipartFile file, HttpServletRequest req,HttpServletResponse res){
		UIReturn rtn = new UIReturn();
		try {
			intEntrepotService.importFile(file, req);
			rtn.setCode(0);
			rtn.setSuccess(true);
		} catch (Exception ex) {
			log.error("导入入库单失败!",ex);
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
	
	@RequestMapping("exportIncomOrder")
	public void exportIncomOrder(HttpServletRequest req,HttpServletResponse res){
		String incomIdStr = req.getParameter("id");
		if(!StringUtil.isEmpty(incomIdStr)){
			int id = Integer.parseInt(incomIdStr);
			IntEntrepot intEntrepot = intEntrepotService.getByKey(id);
			if(null != intEntrepot){
				List<IntEntrepotDetail> datas = intEntrepotService.listIntEntrepotDetailByIntEntrepotId(id).getRows();
				Map<String,Object> dataMap = new HashMap<String,Object>();
				dataMap.put("incomOrder", intEntrepot);
				dataMap.put("list", datas);
				String filename = intEntrepot.getNo() + ".xls";
				ExpExcel.exportReportByMap(filename, config.getRecIncomOrder(), res, req, dataMap);
			}
		}
	}
}
