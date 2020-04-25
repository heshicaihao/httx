package com.ht.model;

import java.math.BigDecimal;
import java.util.Date;

import com.ht.util.StringUtil;

public class OrderInfo extends PageParam {

	private static final long serialVersionUID = 157845734735634L;

	private String orderid;

	private Integer companyid;

	private String entrecordno;

	private Integer entrecordname;

	private String ordername;

	private String orderdocid;

	private String orderaddress;

	private String orderphone;

	private Date orderdate;

	private String orderstatus;

	private BigDecimal ordergoodtotal;

	private BigDecimal freight;

	private BigDecimal tax;

	private String ordergoodtotalcurr;

	private String note;

	private Integer createruserid;

	private String ewaysnum;

	private String status;

	private String orderdoctype;

	private String orderdatestr;

	private String companyName;

	private String customerName;

	private Integer province;

	private Integer city;

	private Integer area;

	private String loading_no;

	private Date releasedDate;

	private String provincename;

	private String cityname;

	private String areaname;
	
	private String pickgoodsno;
	
	private String unloading;
	
	private String firstcreatename;
	
	public String getPickgoodsno() {
		return pickgoodsno;
	}

	public void setPickgoodsno(String pickgoodsno) {
		this.pickgoodsno = pickgoodsno;
	}

	public String getOrderdatestr() {
		orderdatestr = StringUtil.date2String(orderdate);
		return orderdatestr;
	}

	public void setOrderdatestr(String orderdatestr) {
		this.orderdatestr = orderdatestr;
	}

	public String getOrderid() {
		return orderid;
	}

	public void setOrderid(String orderid) {
		this.orderid = orderid == null ? null : orderid.trim();
	}

	public Integer getCompanyid() {
		return companyid;
	}

	public void setCompanyid(Integer companyid) {
		this.companyid = companyid;
	}

	public String getEntrecordno() {
		return entrecordno;
	}

	public void setEntrecordno(String entrecordno) {
		this.entrecordno = entrecordno == null ? null : entrecordno.trim();
	}

	public Integer getEntrecordname() {
		return entrecordname;
	}

	public void setEntrecordname(Integer entrecordname) {
		this.entrecordname = entrecordname;
	}

	public String getOrdername() {
		return ordername;
	}

	public void setOrdername(String ordername) {
		this.ordername = ordername == null ? null : ordername.trim();
	}

	public String getOrderdocid() {
		return orderdocid;
	}

	public void setOrderdocid(String orderdocid) {
		this.orderdocid = orderdocid == null ? null : orderdocid.trim();
	}

	public String getOrderaddress() {
		return orderaddress;
	}

	public void setOrderaddress(String orderaddress) {
		this.orderaddress = orderaddress == null ? null : orderaddress.trim();
	}

	public String getOrderphone() {
		return orderphone;
	}

	public void setOrderphone(String orderphone) {
		this.orderphone = orderphone == null ? null : orderphone.trim();
	}

	public Date getOrderdate() {
		return orderdate;
	}

	public void setOrderdate(Date orderdate) {
		this.orderdate = orderdate;
	}

	public String getOrderstatus() {
		return orderstatus;
	}

	public void setOrderstatus(String orderstatus) {
		this.orderstatus = orderstatus == null ? null : orderstatus.trim();
	}

	public BigDecimal getOrdergoodtotal() {
		return ordergoodtotal;
	}

	public void setOrdergoodtotal(BigDecimal ordergoodtotal) {
		this.ordergoodtotal = ordergoodtotal;
	}

	public BigDecimal getFreight() {
		return freight;
	}

	public void setFreight(BigDecimal freight) {
		this.freight = freight;
	}

	public BigDecimal getTax() {
		return tax;
	}

	public void setTax(BigDecimal tax) {
		this.tax = tax;
	}

	public String getOrdergoodtotalcurr() {
		return ordergoodtotalcurr;
	}

	public void setOrdergoodtotalcurr(String ordergoodtotalcurr) {
		this.ordergoodtotalcurr = ordergoodtotalcurr == null ? null
				: ordergoodtotalcurr.trim();
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note == null ? null : note.trim();
	}

	public Integer getCreateruserid() {
		return createruserid;
	}

	public void setCreateruserid(Integer createruserid) {
		this.createruserid = createruserid;
	}

	public String getEwaysnum() {
		return ewaysnum;
	}

	public void setEwaysnum(String ewaysnum) {
		this.ewaysnum = ewaysnum == null ? null : ewaysnum.trim();
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status == null ? null : status.trim();
	}

	public String getOrderdoctype() {
		return orderdoctype;
	}

	public void setOrderdoctype(String orderdoctype) {
		this.orderdoctype = orderdoctype == null ? null : orderdoctype.trim();
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	private String startDateStr;
	private String endDateStr;

	public String getStartDateStr() {
		return startDateStr;
	}

	public void setStartDateStr(String startDateStr) {
		this.startDateStr = startDateStr;
	}

	public String getEndDateStr() {
		return endDateStr;
	}

	public void setEndDateStr(String endDateStr) {
		this.endDateStr = endDateStr;
	}

	public Integer getProvince() {
		return province;
	}

	public void setProvince(Integer province) {
		this.province = province;
	}

	public Integer getCity() {
		return city;
	}

	public void setCity(Integer city) {
		this.city = city;
	}

	public Integer getArea() {
		return area;
	}

	public void setArea(Integer area) {
		this.area = area;
	}

	public String getLoading_no() {
		return loading_no;
	}

	public void setLoading_no(String loadingNo) {
		loading_no = loadingNo;
	}

	public Date getReleasedDate() {
		return releasedDate;
	}

	public void setReleasedDate(Date releasedDate) {
		this.releasedDate = releasedDate;
	}

	public String getProvincename() {
		if(StringUtil.isEmpty(provincename))
		{
			return "";
		}
		return provincename;
	}

	public void setProvincename(String provincename) {
		this.provincename = provincename;
	}

	public String getCityname() {
		if(StringUtil.isEmpty(cityname))
		{
			return "";
		}
		return cityname;
	}

	public void setCityname(String cityname) {
		this.cityname = cityname;
	}

	public String getAreaname() {
		if(StringUtil.isEmpty(areaname))
		{
			return "";
		}
		return areaname;
	}

	public void setAreaname(String areaname) {
		this.areaname = areaname;
	}

	public String getUnloading() {
		return unloading;
	}

	public void setUnloading(String unloading) {
		this.unloading = unloading;
	}

	public String getFirstcreatename() {
		return firstcreatename;
	}

	public void setFirstcreatename(String firstcreatename) {
		this.firstcreatename = firstcreatename;
	}
}