package com.ht.util;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.jxls.transformer.XLSTransformer;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class ExpExcel
{
	private static final Logger log = LoggerFactory
	.getLogger(ExpExcel.class);

	public static void exportReport(
			 String expExcellName,String sourceExcellName, HttpServletResponse res,
					HttpServletRequest req,List<? extends Object> resut) {
		OutputStream os = null;
		Config config = (Config)SpringUtil.getBean("config");
		try {
			String templatePath = config.getTemplateFolder()
					+ File.separator
					+ sourceExcellName;
			InputStream template = SpringUtil.getApplicationContext()
					.getResource(templatePath).getInputStream();

			HSSFWorkbook workbook = new HSSFWorkbook(template);
			Map<String, Object> beans = new HashMap<String, Object>();
			beans.put("list", resut);
			XLSTransformer transformer = new XLSTransformer();
			transformer.transformWorkbook(workbook, beans);

			res.reset();
			os = res.getOutputStream();
			
			res.addHeader("Content-Disposition", "attachment; filename=\""
					+ expExcellName + ".xls\"");
			res.setContentType("application/msexcel;charset=UTF-8");
			workbook.write(os);
			return;
		} catch (IOException e) {
			log.error("Export Report fail.", e);
		} finally {
			try {
				if (null != os) {
					os.close();
				}
			} catch (IOException e) {
			}
		}
	}
	
	public static void exportReportByMap(
			 String expExcellName,String sourceExcellName, HttpServletResponse res,
					HttpServletRequest req,Map<String,Object> dataMap) {
		OutputStream os = null;
		Config config = (Config)SpringUtil.getBean("config");
		try {
			String templatePath = config.getTemplateFolder()
					+ File.separator
					+ sourceExcellName;
			InputStream template = SpringUtil.getApplicationContext()
					.getResource(templatePath).getInputStream();

			HSSFWorkbook workbook = new HSSFWorkbook(template);
			XLSTransformer transformer = new XLSTransformer();
			transformer.transformWorkbook(workbook, dataMap);

			res.reset();
			os = res.getOutputStream();
			
			res.addHeader("Content-Disposition", "attachment; filename=\""
					+ expExcellName + ".xls\"");
			res.setContentType("application/msexcel;charset=UTF-8");
			workbook.write(os);
			return;
		} catch (IOException e) {
			log.error("Export Report fail.", e);
		} finally {
			try {
				if (null != os) {
					os.close();
				}
			} catch (IOException e) {
			}
		}
	}


	public static void exportPickGoodsReport(
			 String expExcellName,String sourceExcellName, HttpServletResponse res,
					HttpServletRequest req,List<? extends Object> resut, List<? extends Object> toltalResut) {
		OutputStream os = null;
		Config config = (Config)SpringUtil.getBean("config");
		try {
			String templatePath = config.getTemplateFolder()
					+ File.separator
					+ sourceExcellName;
			InputStream template = SpringUtil.getApplicationContext()
					.getResource(templatePath).getInputStream();

			HSSFWorkbook workbook = new HSSFWorkbook(template);
			Map<String, Object> beans = new HashMap<String, Object>();
			beans.put("list", resut);
			beans.put("toltalList", toltalResut);
			beans.put("pickgoodsno", expExcellName);
			XLSTransformer transformer = new XLSTransformer();
			transformer.transformWorkbook(workbook, beans);

			res.reset();
			os = res.getOutputStream();
			
			res.addHeader("Content-Disposition", "attachment; filename=\""
					+ expExcellName + ".xls\"");
			res.setContentType("application/msexcel;charset=UTF-8");
			workbook.write(os);
			return;
		} catch (IOException e) {
			log.error("Export Report fail.", e);
		} finally {
			try {
				if (null != os) {
					os.close();
				}
			} catch (IOException e) {
			}
		}
	}
	
}