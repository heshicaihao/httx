package com.ht.model.reportmodel;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import com.ht.model.IntEntrepotDetail;
import com.ht.model.LoadingGoods;
import com.ht.util.StringUtil;

public class LoadingRepotHGReport {
	private String yyyyMMddHHmmSSS;
	private String currentTime;
	private List<LoadingGoods> detailsList;
	private String inputDate;
	private String grossWt;
	private String entInsideNo;
	private String veName;
	public String getVeName() {
		return veName;
	}
	public void setVeName(String veName) {
		this.veName = veName;
	}
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
	public String getCurrentTime() {
		currentTime = StringUtil.dateTime2String(Calendar.getInstance().getTime());
		return currentTime;
	}
	public void setCurrentTime(String currentTime) {
		this.currentTime = currentTime;
	}
	
	
	public List<LoadingGoods> getDetailsList() {
		return detailsList;
	}
	public void setDetailsList(List<LoadingGoods> detailsList) {
		this.detailsList = detailsList;
	}
	public String getInputDate() {
		return inputDate;
	}
	public void setInputDate(String inputDate) {
		this.inputDate = inputDate;
	}
	public String getGrossWt() {
		return grossWt;
	}
	public void setGrossWt(String grossWt) {
		this.grossWt = grossWt;
	}
	public String getEntInsideNo() {
		return entInsideNo;
	}
	public void setEntInsideNo(String entInsideNo) {
		this.entInsideNo = entInsideNo;
	}
}
