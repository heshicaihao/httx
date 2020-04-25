package com.ht.model.reportmodel;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import com.ht.util.StringUtil;

public class OrderHGReport {

	private String yyyyMMddHHmmSSS;
	private String currentTime;
	private EOrder order;
	private List<EOrderGood> goods;
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

	public List<EOrderGood> getGoods() {
		return goods;
	}
	public void setGoods(List<EOrderGood> goods) {
		this.goods = goods;
	}
	public String getCurrentTime() {
		currentTime = StringUtil.dateTime2String(Calendar.getInstance().getTime());
		return currentTime;
	}
	public void setCurrentTime(String currentTime) {
		this.currentTime = currentTime;
	}
	public EOrder getOrder() {
		return order;
	}
	public void setOrder(EOrder order) {
		this.order = order;
	}
	public static int getNum() {
		num++;
		return num%1000;
	}
	public static void setNum(int num) {
		OrderHGReport.num = num;
	}
	
}
