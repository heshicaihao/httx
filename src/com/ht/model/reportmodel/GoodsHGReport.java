package com.ht.model.reportmodel;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import com.ht.model.Goods;
import com.ht.util.StringUtil;

public class GoodsHGReport {

	private String yyyyMMddHHmmSSS;
	private String currentTime;
	private List<Goods> goods;
	public String getYyyyMMddHHmmSSS() {
		if(StringUtil.isEmpty(yyyyMMddHHmmSSS)){
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmSSS");
			yyyyMMddHHmmSSS = sdf.format(Calendar.getInstance().getTime());
		}
		return yyyyMMddHHmmSSS;
	}
	public void setYyyyMMddHHmmSSS(String yyyyMMddHHmmSSS) {
		this.yyyyMMddHHmmSSS = yyyyMMddHHmmSSS;
	}
	public List<Goods> getGoods() {
		return goods;
	}
	public void setGoods(List<Goods> goods) {
		this.goods = goods;
	}
	public String getCurrentTime() {
		currentTime = StringUtil.dateTime2String(Calendar.getInstance().getTime());
		return currentTime;
	}
	public void setCurrentTime(String currentTime) {
		this.currentTime = currentTime;
	}
}
