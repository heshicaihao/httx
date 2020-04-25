package com.ht.model.reportmodel;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import com.ht.model.IntEntrepotDetail;
import com.ht.util.StringUtil;

public class IntEntRepotHGReport {
	private String yyyyMMdd;
	private String currentTime;
	private List<IntEntrepotDetail> detailsList;
	private String companyRegistNo;
	private String inspectionRegistNo;
	private String entInsideNo;
	public String getYyyyMMdd() {
		if(StringUtil.isEmpty(yyyyMMdd)){
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
			yyyyMMdd = sdf.format(Calendar.getInstance().getTime());
		}
		return yyyyMMdd;
	}
	public void setYyyyMMdd(String yyyyMMdd) {
		this.yyyyMMdd = yyyyMMdd;
	}
	public String getCurrentTime() {
		currentTime = StringUtil.dateTime2String(Calendar.getInstance().getTime());
		return currentTime;
	}
	public void setCurrentTime(String currentTime) {
		this.currentTime = currentTime;
	}
	
	public List<IntEntrepotDetail> getDetailsList() {
		return detailsList;
	}
	public void setDetailsList(List<IntEntrepotDetail> detailsList) {
		this.detailsList = detailsList;
	}
	public String getCompanyRegistNo() {
		return companyRegistNo;
	}
	public void setCompanyRegistNo(String companyRegistNo) {
		this.companyRegistNo = companyRegistNo;
	}
	public String getInspectionRegistNo() {
		return inspectionRegistNo;
	}
	public void setInspectionRegistNo(String inspectionRegistNo) {
		this.inspectionRegistNo = inspectionRegistNo;
	}
	public String getEntInsideNo() {
		return entInsideNo;
	}
	public void setEntInsideNo(String entInsideNo) {
		this.entInsideNo = entInsideNo;
	}
}
