package com.ht.model.reportmodel;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import com.ht.util.StringUtil;

public class ImportCheckReport {

	private String yyyyMMddHHmmSSS;
	private String currentTime;
	private String Sender;
	private String Receiver;
	private ImportCheckHead importCheckHead;
	
	private List<ImportCheckContent> lstContent;
	private static int num = 0;
	public String getYyyyMMddHHmmSSS() {
		if (StringUtil.isEmpty(yyyyMMddHHmmSSS)) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmm");
			yyyyMMddHHmmSSS = sdf.format(Calendar.getInstance().getTime())+StringUtil.formatCode(3, getNum());
		}
		return yyyyMMddHHmmSSS;
	}

	public void setYyyyMMddHHmmSSS(String yyyyMMddHHmmSSS) {
		this.yyyyMMddHHmmSSS = yyyyMMddHHmmSSS;
	}

	public String getCurrentTime() {
		currentTime = StringUtil.getNowDateString();
		return currentTime;
	}

	public void setCurrentTime(String currentTime) {
		this.currentTime = currentTime;
	}

	public String getSender() {
		return Sender;
	}

	public void setSender(String sender) {
		Sender = sender;
	}

	public String getReceiver() {
		return Receiver;
	}

	public void setReceiver(String receiver) {
		Receiver = receiver;
	}

	public ImportCheckHead getImportCheckHead() {
		return importCheckHead;
	}

	public void setImportCheckHead(ImportCheckHead importCheckHead) {
		this.importCheckHead = importCheckHead;
	}

	public List<ImportCheckContent> getLstContent() {
		return lstContent;
	}

	public void setLstContent(List<ImportCheckContent> lstContent) {
		this.lstContent = lstContent;
	}

	public static int getNum() {
		num++;
		return num%1000;
	}

	public static void setNum(int num) {
		ImportCheckReport.num = num;
	}

}
