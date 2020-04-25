package com.ht.model.reportmodel;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import com.ht.util.StringUtil;

public class EBillReport {

	private String yyyyMMddHHmmSSS;
	private String currentTime;
	private String senderID;
	private String  receiverID;
	private EBill eBill;
	private List<EBillList> eBillList;
	private static int num = 0;
	public String getYyyyMMddHHmmSSS() {
		if(StringUtil.isEmpty(yyyyMMddHHmmSSS)){
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmm");
			yyyyMMddHHmmSSS = sdf.format(Calendar.getInstance().getTime())+StringUtil.formatCode(3, getNum());
		}
		return yyyyMMddHHmmSSS;
	}
	public void setYyyyMMddHHmmSSS(String yyyyMMddHHmmSSS) {
		this.yyyyMMddHHmmSSS = yyyyMMddHHmmSSS;
	}

	public String getCurrentTime() {
		currentTime = StringUtil.dateTime2String(Calendar.getInstance().getTime());
		return currentTime;
	}
	public String getSenderID() {
		return senderID;
	}
	public void setSenderID(String senderID) {
		this.senderID = senderID;
	}
	public String getReceiverID() {
		return receiverID;
	}
	public void setReceiverID(String receiverID) {
		this.receiverID = receiverID;
	}
	public EBill geteBill() {
		return eBill;
	}
	public void seteBill(EBill eBill) {
		this.eBill = eBill;
	}
	public List<EBillList> geteBillList() {
		return eBillList;
	}
	public void seteBillList(List<EBillList> eBillList) {
		this.eBillList = eBillList;
	}
	public void setCurrentTime(String currentTime) {
		this.currentTime = currentTime;
	}
	public static int getNum() {
		num++;
		return num%1000;
	}
	public static void setNum(int num) {
		EBillReport.num = num;
	}
	
}
