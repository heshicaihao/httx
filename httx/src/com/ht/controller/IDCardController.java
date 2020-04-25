package com.ht.controller;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.ht.model.IDCard;
import com.ht.model.PageResult;
import com.ht.model.UIReturn;
import com.ht.servie.IDCardService;
import com.ht.util.Config;
import com.ht.util.DownLoadZipFiles;
import com.ht.util.FileUtil;
import com.ht.util.HTException;
import com.ht.util.ImageUtils;
import com.ht.util.StringUtil;

@Controller
@RequestMapping("/idcard/*")
public class IDCardController {
	
	private static final Logger log = LoggerFactory.getLogger(IDCardController.class);

	@Autowired
	private IDCardService idCardService;

	@Autowired
	private Config config;
	
	@RequestMapping("list")
	public String list(Model model) {
		return "idcard/idcardlist";
	}

	@RequestMapping("listPage")
	@ResponseBody
	public PageResult<IDCard> listPage(IDCard idCard, HttpSession session) {
		return idCardService.listPage(idCard);
	}
	
	@RequestMapping("add")
	public String addInit(){
		return "idcard/add";
	}
	
	@RequestMapping("save")
	public void save(@RequestParam(value="a", required=true) MultipartFile filea, 
			@RequestParam(value="b", required=true) MultipartFile fileb,
			HttpServletRequest req,HttpServletResponse res){
		IDCard idCard = new IDCard();
		idCard.setName(req.getParameter("name"));
		idCard.setCardNo(req.getParameter("cardNo"));
		InputStream is;
		UIReturn rtn = new UIReturn();
		try {
			is = filea.getInputStream();
			FileUtil.saveAsJPG(is,idCard.getCardNo() + "_" + idCard.getName() + "_a",config.getIdCardImgFolder());
			ImageUtils.pressText(config.getIdCardImgFolder() + File.separator + idCard.getCardNo() + "_" + idCard.getName() + "_a.jpg");
			is = fileb.getInputStream();
			FileUtil.saveAsJPG(is,idCard.getCardNo() + "_" + idCard.getName() + "_b",config.getIdCardImgFolder());
			ImageUtils.pressText(config.getIdCardImgFolder() + File.separator + idCard.getCardNo() + "_" + idCard.getName() + "_b.jpg");
			idCardService.add(idCard);
			rtn.setSuccess(true);
			rtn.setCode(0);
		} catch (IOException e) {
			rtn.setCode(99);
			rtn.setSuccess(false);
			rtn.setErrorMsg("上传文件失败!");
			log.error("上传文件失败!",e);
		} catch (HTException e) {
			rtn.setCode(98);
			rtn.setSuccess(false);
			rtn.setErrorMsg(e.getMessage());
			log.error("保存身份证失败!",e);
		}catch (Exception e) {
			rtn.setCode(99);
			rtn.setSuccess(false);
			log.error("保存身份证失败!",e);
			String errMsg = e.getMessage();
			if(errMsg.length() > 100){
				errMsg = errMsg.substring(0,100) + "...";
			}
			rtn.setErrorMsg(errMsg);
		}
		PrintWriter writer = null;
		try{
			res.reset();
			res.setContentType("text/html; charset=UTF-8");
			writer = res.getWriter();
			writer.write(StringUtil.getJsonMapper().writeValueAsString(rtn));
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
	
	@RequestMapping("del")
	@ResponseBody
	public UIReturn del(IDCard idCard){
		UIReturn rtn = new UIReturn();
		try {
			idCardService.delete(idCard.getId());
			rtn.setSuccess(true);
			rtn.setCode(0);
		}catch (Exception e) {
			rtn.setCode(99);
			rtn.setSuccess(false);
			log.error("删除身份证失败!",e);
			String errMsg = e.getMessage();
			if(errMsg.length() > 100){
				errMsg = errMsg.substring(0,100) + "...";
			}
			rtn.setErrorMsg(errMsg);
		}
		return rtn;
	}
	
	@RequestMapping("download/{cardNo}")
	public void download(@PathVariable String cardNo,HttpServletResponse res){
		File folder = new File(config.getIdCardImgFolder());
		IDCard idcard = idCardService.getByCardNo(cardNo);
		File[] files = null;
		if(null != idcard){
			final String idCardNoName = cardNo + "_" + idcard.getName();
			files = folder.listFiles(new FileFilter(){
			@Override
			public boolean accept(File pathname) {
				if(pathname.getName().startsWith(idCardNoName)){
					return true;
				}
				return false;
			}});
		}
		if(null == files || files.length == 0){
			PrintWriter writer = null;
			try{
				res.reset();
				res.setContentType("text/html; charset=UTF-8");
				writer = res.getWriter();
				writer.write("<script>alert('没有找到文件!');</script>");
				writer.flush();
			}catch(Exception ex){
				log.error("return to front UI fail.",ex);
			}finally{
				if(null!=writer)
					writer.close();
				writer = null;
			}
		}else{
			try {
				List<File> fileList = new ArrayList<File>();
				for(File f : files){
					fileList.add(f);
				}
				String outFileName = config.getIdCardImgFolder() + File.separator+ cardNo + "_" + idcard.getName()+".zip";
				outFileName = new String(outFileName.getBytes("GB2312"),"ISO-8859-1");
				DownLoadZipFiles.downLoadFiles(fileList, res,outFileName);
			} catch (Exception e) {
				log.error("导出身份证信息出错");
				e.printStackTrace();
			}
		}
	}
}
