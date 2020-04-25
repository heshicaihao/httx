package com.ht.model.reportmodel;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import com.ht.util.StringUtil;

public class TransportHGReport {

	private String yyyyMMddHHmmSSS;
	private String currentTime;
	private String senderID;
	private List<EWayBill> eWayBills;
	private static int num = 0;
	public String getYyyyMMddHHmmSSS() {
		if (StringUtil.isEmpty(yyyyMMddHHmmSSS)) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmm");
			yyyyMMddHHmmSSS = sdf.format(Calendar.getInstance().getTime())+ StringUtil.formatCode(3, getNum());
		}
		return yyyyMMddHHmmSSS;
	}

	public void setYyyyMMddHHmmSSS(String yyyyMMddHHmmSSS) {
		this.yyyyMMddHHmmSSS = yyyyMMddHHmmSSS;
	}

	public String getCurrentTime() {
		currentTime = StringUtil.dateTime2String(Calendar.getInstance()
				.getTime());
		return currentTime;
	}

	public void setCurrentTime(String currentTime) {
		this.currentTime = currentTime;
	}

	public List<EWayBill> geteWayBills() {
		return eWayBills;
	}

	public void seteWayBills(List<EWayBill> eWayBills) {
		this.eWayBills = eWayBills;
	}

	public String getSenderID() {
		return senderID;
	}

	public void setSenderID(String senderID) {
		this.senderID = senderID;
	}

	public static int getNum() {
		num++;
		return num%1000;
	}

	public static void setNum(int num) {
		TransportHGReport.num = num;
	}
	
}
