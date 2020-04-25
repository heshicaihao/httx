package com.ht.util;

public class Config {

	private String exportPath;
	
	private String templateFolder;
	
	private String goodsHGTemplateFileName;
	
	private String goodsCheckTemplateFileName;
	
	//电子订单报文 只发送给海关
	private String eOrderHGTemplateFileName;
	
	//电子运单报文 只发送海关
	private String eTransportHGTemplateFileName;
	
	//拣货单
	private  String pickGoodsTemplateFileName;
	
	//海关进境电子清单报文
	private String importListHGTemplateFileName;
	
	//商检进境电子清单报文
	private String importListCheckTemplateFileName;
	
	// 生成海关进仓报文 只发送给海关
	private String intEntrepotHGTemplateFileName;
	// 生成订单出仓报表
	private String intOrderRepotTemplateFileName;
	
	private String intEntRepotCheckTemplate;
	
	private String intEntRepotHGTemplate;
	
	private String importIntEntRepotFolder;
	// 生成装载单报文 只发送给海关
	private String loadingHGTemplate;
	private String loadingCheckTemplate;
	
	private String storageExportTemplate;
	
	private String goodsImportTemplate;
	
	private String importGoodsFolder;
	
	private String orderExportReportTemplate;
	
	private String transactionReportTemplate;
	
	private String goodsRegisterReport;
	
	private String orderStatusExportReportTemplate;
	
	private String recIncomOrder;
	
	private String idCardImgFolder;
	
	public String getLoadingCheckTemplate() {
		return loadingCheckTemplate;
	}

	public void setLoadingCheckTemplate(String loadingCheckTemplate) {
		this.loadingCheckTemplate = loadingCheckTemplate;
	}

	public String getLoadingHGTemplate() {
		return loadingHGTemplate;
	}

	public void setLoadingHGTemplate(String loadingHGTemplate) {
		this.loadingHGTemplate = loadingHGTemplate;
	}

	public String getExportPath() {
		return exportPath;
	}

	public void setExportPath(String exportPath) {
		this.exportPath = exportPath;
	}

	public String getTemplateFolder() {
		return templateFolder;
	}

	public void setTemplateFolder(String templateFolder) {
		this.templateFolder = templateFolder;
	}

	public String getGoodsHGTemplateFileName() {
		return goodsHGTemplateFileName;
	}

	public void setGoodsHGTemplateFileName(String goodsHGTemplateFileName) {
		this.goodsHGTemplateFileName = goodsHGTemplateFileName;
	}

	public String getGoodsCheckTemplateFileName() {
		return goodsCheckTemplateFileName;
	}

	public void setGoodsCheckTemplateFileName(String goodsCheckTemplateFileName) {
		this.goodsCheckTemplateFileName = goodsCheckTemplateFileName;
	}

	public String geteOrderHGTemplateFileName() {
		return eOrderHGTemplateFileName;
	}

	public void seteOrderHGTemplateFileName(String eOrderHGTemplateFileName) {
		this.eOrderHGTemplateFileName = eOrderHGTemplateFileName;
	}

	public String geteTransportHGTemplateFileName() {
		return eTransportHGTemplateFileName;
	}

	public void seteTransportHGTemplateFileName(String eTransportHGTemplateFileName) {
		this.eTransportHGTemplateFileName = eTransportHGTemplateFileName;
	}

	public String getPickGoodsTemplateFileName() {
		return pickGoodsTemplateFileName;
	}

	public void setPickGoodsTemplateFileName(String pickGoodsTemplateFileName) {
		this.pickGoodsTemplateFileName = pickGoodsTemplateFileName;
	}

	public String getImportListHGTemplateFileName() {
		return importListHGTemplateFileName;
	}

	public void setImportListHGTemplateFileName(String importListHGTemplateFileName) {
		this.importListHGTemplateFileName = importListHGTemplateFileName;
	}

	public String getImportListCheckTemplateFileName() {
		return importListCheckTemplateFileName;
	}

	public void setImportListCheckTemplateFileName(
			String importListCheckTemplateFileName) {
		this.importListCheckTemplateFileName = importListCheckTemplateFileName;
	}

	public String getIntEntrepotHGTemplateFileName() {
		return intEntrepotHGTemplateFileName;
	}

	public void setIntEntrepotHGTemplateFileName(
			String intEntrepotHGTemplateFileName) {
		this.intEntrepotHGTemplateFileName = intEntrepotHGTemplateFileName;
	}

	public String getIntOrderRepotTemplateFileName() {
		return intOrderRepotTemplateFileName;
	}

	public void setIntOrderRepotTemplateFileName(
			String intOrderRepotTemplateFileName) {
		this.intOrderRepotTemplateFileName = intOrderRepotTemplateFileName;
	}

	public String getIntEntRepotCheckTemplate() {
		return intEntRepotCheckTemplate;
	}

	public void setIntEntRepotCheckTemplate(String intEntRepotCheckTemplate) {
		this.intEntRepotCheckTemplate = intEntRepotCheckTemplate;
	}

	public String getIntEntRepotHGTemplate() {
		return intEntRepotHGTemplate;
	}

	public void setIntEntRepotHGTemplate(String intEntRepotHGTemplate) {
		this.intEntRepotHGTemplate = intEntRepotHGTemplate;
	}

	public String getImportIntEntRepotFolder() {
		return importIntEntRepotFolder;
	}

	public void setImportIntEntRepotFolder(String importIntEntRepotFolder) {
		this.importIntEntRepotFolder = importIntEntRepotFolder;
	}

	public String getStorageExportTemplate() {
		return storageExportTemplate;
	}

	public void setStorageExportTemplate(String storageExportTemplate) {
		this.storageExportTemplate = storageExportTemplate;
	}

	public String getGoodsImportTemplate() {
		return goodsImportTemplate;
	}

	public void setGoodsImportTemplate(String goodsImportTemplate) {
		this.goodsImportTemplate = goodsImportTemplate;
	}

	public String getImportGoodsFolder() {
		return importGoodsFolder;
	}

	public void setImportGoodsFolder(String importGoodsFolder) {
		this.importGoodsFolder = importGoodsFolder;
	}

	public String getOrderExportReportTemplate() {
		return orderExportReportTemplate;
	}

	public void setOrderExportReportTemplate(String orderExportReportTemplate) {
		this.orderExportReportTemplate = orderExportReportTemplate;
	}

	public String getTransactionReportTemplate() {
		return transactionReportTemplate;
	}

	public void setTransactionReportTemplate(String transactionReportTemplate) {
		this.transactionReportTemplate = transactionReportTemplate;
	}

	public String getGoodsRegisterReport() {
		return goodsRegisterReport;
	}

	public void setGoodsRegisterReport(String goodsRegisterReport) {
		this.goodsRegisterReport = goodsRegisterReport;
	}

	public String getOrderStatusExportReportTemplate() {
		return orderStatusExportReportTemplate;
	}

	public void setOrderStatusExportReportTemplate(
			String orderStatusExportReportTemplate) {
		this.orderStatusExportReportTemplate = orderStatusExportReportTemplate;
	}

	public String getRecIncomOrder() {
		return recIncomOrder;
	}

	public void setRecIncomOrder(String recIncomOrder) {
		this.recIncomOrder = recIncomOrder;
	}

	public String getIdCardImgFolder() {
		return idCardImgFolder;
	}

	public void setIdCardImgFolder(String idCardImgFolder) {
		this.idCardImgFolder = idCardImgFolder;
	}
}
