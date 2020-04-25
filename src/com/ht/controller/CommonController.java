package com.ht.controller;

import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;

import org.apache.avalon.framework.configuration.Configuration;
import org.apache.avalon.framework.configuration.DefaultConfiguration;
import org.krysalis.barcode4j.BarcodeGenerator;
import org.krysalis.barcode4j.BarcodeUtil;
import org.krysalis.barcode4j.output.bitmap.BitmapCanvasProvider;
import org.krysalis.barcode4j.output.eps.EPSCanvasProvider;
import org.krysalis.barcode4j.output.svg.SVGCanvasProvider;
import org.krysalis.barcode4j.tools.MimeTypes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ht.mapper.CompanyMapper;
import com.ht.mapper.GMUserMapper;
import com.ht.mapper.GoodsMapper;
import com.ht.mapper.ProvinceCityAreaMapper;
import com.ht.model.Account;
import com.ht.model.Company;
import com.ht.model.CompanyExample;
import com.ht.model.GMUser;
import com.ht.model.Goods;
import com.ht.model.GoodsExample;
import com.ht.model.ProvinceCityArea;
import com.ht.util.Const;

@Controller
@RequestMapping("/common/*")
public class CommonController {

	private static final Logger log = LoggerFactory.getLogger(CommonController.class);
	
	@Autowired
	private GoodsMapper goodsMapper;
	
	@Autowired
	private CompanyMapper companyMapper;
	
	@Autowired
	private GMUserMapper userMapper;
	
	@Autowired
	private ProvinceCityAreaMapper pcaMapper;
	
	@RequestMapping("listGoodsByUser")
	@ResponseBody
	public List<Goods> listGoodsByUser(HttpSession session){
		List<Goods> goods = new ArrayList<Goods>();
		try{
			Account user = (Account)session.getAttribute(Const.WEB_ACCOUNT);
			if(Const.USERTYPE_EMP == user.getAccountType()){
				goods = goodsMapper.getGoodsByUserId(user.getCustId());
			}else{
				GoodsExample exp = new GoodsExample();
				exp.createCriteria().andActiveEqualTo(1);
				goods = goodsMapper.selectByExample(exp);
			}
		}catch(Exception ex){
			log.error("查询客户商品失败",ex);
		}
		return goods;
	}
	
	@RequestMapping("listCompanies")
	@ResponseBody
	public List<Company> listCompanies(){
		List<Company> companies = new ArrayList<Company>();
		try{
			companies = companyMapper.selectByExample(new CompanyExample());
		}catch(Exception ex){
			log.error("读取公司信息失败!",ex);
		}
		return companies;
	}
	
	@RequestMapping("listCustomers")
	@ResponseBody
	public List<GMUser> listCustomer(){
		List<GMUser> companies = new ArrayList<GMUser>();
		try{
			companies = userMapper.getActiveUserList();
		}catch(Exception ex){
			log.error("读取公司信息失败!",ex);
		}
		return companies;
	}
	
	@RequestMapping("listProvince")
	@ResponseBody
	public List<ProvinceCityArea> listProvince(){
		List<ProvinceCityArea> result = new ArrayList<ProvinceCityArea>();
		try{
			result = pcaMapper.listAllProvinces();
		}catch(Exception ex){
			log.error("读取省信息失败!",ex);
		}
		return result;
	}
	
	@RequestMapping("listCity")
	@ResponseBody
	public List<ProvinceCityArea> listCityByProvinceId(@RequestParam("provinceId") int provinceId){
		List<ProvinceCityArea> result = new ArrayList<ProvinceCityArea>();
		try{
			result = pcaMapper.listCitiesByProvinceId(provinceId);
		}catch(Exception ex){
			log.error("读取城市信息失败!",ex);
		}
		return result;
	}
	
	@RequestMapping("listArea")
	@ResponseBody
	public List<ProvinceCityArea> listAreasByCityId(@RequestParam("cityId") int cityId){
		List<ProvinceCityArea> result = new ArrayList<ProvinceCityArea>();
		try{
			result = pcaMapper.listAreasByCityId(cityId);
		}catch(Exception ex){
			log.error("读取区县信息失败!",ex);
		}
		return result;
	}
	
	@RequestMapping("barCode")
	public void barCode(HttpServletRequest request, HttpServletResponse response, Model model) throws ServletException, IOException {
		String msg = request.getParameter(Const.BARCODE_MSG);
		File directory = new File(request.getSession().getServletContext().getRealPath("/")+ "static/barCode");// 设定为当前文件夹
		if(!directory.exists()){
			directory.mkdirs();
		}
		File file = new File(directory.getAbsolutePath(),msg+".jpg");
		if (!file.exists()) {
			file.createNewFile();
		}
		try {
			String format = determineFormat(request);
			int orientation = 0;

			Configuration cfg = buildCfg(request);

			if (msg == null)
				msg = "99000014A10";

			BarcodeUtil util = BarcodeUtil.getInstance();
			BarcodeGenerator gen = util.createBarcodeGenerator(cfg);

			ByteArrayOutputStream bout = new ByteArrayOutputStream(4096);
			try {
				if (format.equals(MimeTypes.MIME_SVG)) {
					// Create Barcode and render it to SVG
					SVGCanvasProvider svg = new SVGCanvasProvider(false,
							orientation);
					gen.generateBarcode(svg, msg);
					org.w3c.dom.DocumentFragment frag = svg.getDOMFragment();

					// Serialize SVG barcode
					TransformerFactory factory = TransformerFactory
							.newInstance();
					Transformer trans = factory.newTransformer();
					Source src = new javax.xml.transform.dom.DOMSource(frag);
					Result res = new javax.xml.transform.stream.StreamResult(
							bout);
					trans.transform(src, res);
				} else if (format.equals(MimeTypes.MIME_EPS)) {
					EPSCanvasProvider eps = new EPSCanvasProvider(bout,
							orientation);
					gen.generateBarcode(eps, msg);
					eps.finish();
				} else {
					String resText = request
							.getParameter(Const.BARCODE_IMAGE_RESOLUTION);
					int resolution = 300; // dpi
					if (resText != null) {
						resolution = Integer.parseInt(resText);
					}
					if (resolution > 2400) {
						throw new IllegalArgumentException(
								"Resolutions above 2400dpi are not allowed");
					}
					if (resolution < 10) {
						throw new IllegalArgumentException(
								"Minimum resolution must be 10dpi");
					}
					String gray = request.getParameter(Const.BARCODE_IMAGE_GRAYSCALE);
					BitmapCanvasProvider bitmap = ("true"
							.equalsIgnoreCase(gray) ? new BitmapCanvasProvider(
							bout, format, resolution,
							BufferedImage.TYPE_BYTE_GRAY, true, orientation)
							: new BitmapCanvasProvider(bout, format,
									resolution, BufferedImage.TYPE_BYTE_BINARY,
									false, orientation));
					gen.generateBarcode(bitmap, msg);
					bitmap.finish();
				}
			} finally {
				bout.close();
			}
			FileOutputStream fos = new FileOutputStream(file);
			fos.write(bout.toByteArray());
			fos.flush();
			fos.close();
			FileInputStream fis = new FileInputStream(file);
			response.reset();
			response.setContentType("application/x-msdownload");
	        response.setContentLength((int)file.length());
	        response.setHeader("Content-Disposition","attachment;filename="+file.getName());       
	        BufferedInputStream buff=new BufferedInputStream(fis);
	        byte [] b=new byte[1024];//相当于我们的缓存
	        long k=0;//该值用于计算当前实际下载了多少字节
	        //从response对象中得到输出流,准备下载
	        OutputStream myout=response.getOutputStream();
	        //开始循环下载
	        while(k<file.length()){
	            int j=buff.read(b,0,1024);
	            k+=j;
	            //将b中的数据写到客户端的内存
	            myout.write(b,0,j);
	        }
	        //将写入到客户端的内存的数据,刷新到磁盘
	        myout.flush();
	        buff.close();
		} catch (Exception e) {
			log.error("Error while generating barcode", e);
			throw new ServletException(e);
		} catch (Throwable t) {
			log.error("Error while generating barcode", t);
			throw new ServletException(t);
		}
	}
	
	/**
	 * Check the request for the desired output format.
	 * 
	 * @param request
	 *            the request to use
	 * @return MIME type of the desired output format.
	 */
	protected String determineFormat(HttpServletRequest request) {
		String format = request.getParameter(Const.BARCODE_FORMAT);
		format = MimeTypes.expandFormat(format);
		if (format == null)
			format = MimeTypes.MIME_JPEG;// MimeTypes.MIME_SVG;
		return format;
	}

	/**
	 * Build an Avalon Configuration object from the request.
	 * 
	 * @param request
	 *            the request to use
	 * @return the newly built COnfiguration object
	 * @todo Change to bean API
	 */
	protected Configuration buildCfg(HttpServletRequest request) {
		DefaultConfiguration cfg = new DefaultConfiguration("barcode");
		// Get type
		String type = request.getParameter(Const.BARCODE_TYPE);
		if (type == null)
			type = "code128";
		DefaultConfiguration child = new DefaultConfiguration(type);
		cfg.addChild(child);
		// Get additional attributes
		DefaultConfiguration attr;
		String height = request.getParameter(Const.BARCODE_HEIGHT);
		if (height != null) {
			attr = new DefaultConfiguration("height");
			attr.setValue(height);
			child.addChild(attr);
		}
		String moduleWidth = request.getParameter(Const.BARCODE_MODULE_WIDTH);
		if (moduleWidth != null) {
			attr = new DefaultConfiguration("module-width");
			attr.setValue(moduleWidth);
			child.addChild(attr);
		}
		String wideFactor = request.getParameter(Const.BARCODE_WIDE_FACTOR);
		if (wideFactor != null) {
			attr = new DefaultConfiguration("wide-factor");
			attr.setValue(wideFactor);
			child.addChild(attr);
		}
		String quietZone = request.getParameter(Const.BARCODE_QUIET_ZONE);
		if (quietZone != null) {
			attr = new DefaultConfiguration("quiet-zone");
			if (quietZone.startsWith("disable")) {
				attr.setAttribute("enabled", "false");
			} else {
				attr.setValue(quietZone);
			}
			child.addChild(attr);
		}

		// creating human readable configuration according to the new Barcode
		// Element Mappings
		// where the human-readable has children for font name, font size,
		// placement and
		// custom pattern.
		String humanReadablePosition = request
				.getParameter(Const.BARCODE_HUMAN_READABLE_POS);
		String pattern = request.getParameter(Const.BARCODE_HUMAN_READABLE_PATTERN);
		String humanReadableSize = request
				.getParameter(Const.BARCODE_HUMAN_READABLE_SIZE);
		String humanReadableFont = request
				.getParameter(Const.BARCODE_HUMAN_READABLE_FONT);

		if (!((humanReadablePosition == null) && (pattern == null)
				&& (humanReadableSize == null) && (humanReadableFont == null))) {
			attr = new DefaultConfiguration("human-readable");

			DefaultConfiguration subAttr;
			if (pattern != null) {
				subAttr = new DefaultConfiguration("pattern");
				subAttr.setValue(pattern);
				attr.addChild(subAttr);
			}
			if (humanReadableSize != null) {
				subAttr = new DefaultConfiguration("font-size");
				subAttr.setValue(humanReadableSize);
				attr.addChild(subAttr);
			}
			if (humanReadableFont != null) {
				subAttr = new DefaultConfiguration("font-name");
				subAttr.setValue(humanReadableFont);
				attr.addChild(subAttr);
			}
			if (humanReadablePosition != null) {
				subAttr = new DefaultConfiguration("placement");
				subAttr.setValue(humanReadablePosition);
				attr.addChild(subAttr);
			}

			child.addChild(attr);
		}

		return cfg;
	}

}
