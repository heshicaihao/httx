package com.ht.model;

import java.math.BigDecimal;
import java.util.Date;

public class Goods {
    private Integer id;

    private String copgno;

    private String sellid;

    private String goodsenname;

    private String gname;

    private String manufactory;

    private String country;

    private String hscode;

    private String curr;

    private String rmb;

    private BigDecimal decprice;

    private BigDecimal netwt;

    private BigDecimal grosswt;

    private String pingming;

    private String brand;

    private String yongtu;

    private String gmodel;

    private String chengfen;

    private String networksellname;

    private String hyperlink;

    private String batchid;

    private String unit;

    private String posttariffcode;

    private String posttariffname;

    private String eportgoodsno;

    private String registno;

    private Date appdate;

    private Date appenddate;

    private String createuserid;

    private String lastupdateuserid;

    private Date lastupdatetime;
    private String startDate;
    private String endDate;
    public String getStartDate() {
		return startDate;
	}



	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}



	public String getEndDate() {
		return endDate;
	}



	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}



	public Integer getId() {
        return id;
    }

 

    public void setId(Integer id) {
		this.id = id;
	}



	public String getCopgno() {
        return copgno;
    }

    public void setCopgno(String copgno) {
        this.copgno = copgno == null ? null : copgno.trim();
    }

    public String getSellid() {
        return sellid;
    }

    public void setSellid(String sellid) {
        this.sellid = sellid == null ? null : sellid.trim();
    }

    public String getGoodsenname() {
        return goodsenname;
    }

    public void setGoodsenname(String goodsenname) {
        this.goodsenname = goodsenname == null ? null : goodsenname.trim();
    }

    public String getGname() {
        return gname;
    }

    public void setGname(String gname) {
        this.gname = gname == null ? null : gname.trim();
    }

    public String getManufactory() {
        return manufactory;
    }

    public void setManufactory(String manufactory) {
        this.manufactory = manufactory == null ? null : manufactory.trim();
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country == null ? null : country.trim();
    }

    public String getHscode() {
        return hscode;
    }

    public void setHscode(String hscode) {
        this.hscode = hscode == null ? null : hscode.trim();
    }

    public String getCurr() {
        return curr;
    }

    public void setCurr(String curr) {
        this.curr = curr == null ? null : curr.trim();
    }

    public String getRmb() {
        return rmb;
    }

    public void setRmb(String rmb) {
        this.rmb = rmb == null ? null : rmb.trim();
    }

    public BigDecimal getDecprice() {
        return decprice;
    }

    public void setDecprice(BigDecimal decprice) {
        this.decprice = decprice;
    }

    public BigDecimal getNetwt() {
        return netwt;
    }

    public void setNetwt(BigDecimal netwt) {
        this.netwt = netwt;
    }

    public BigDecimal getGrosswt() {
        return grosswt;
    }

    public void setGrosswt(BigDecimal grosswt) {
        this.grosswt = grosswt;
    }

    public String getPingming() {
        return pingming;
    }

    public void setPingming(String pingming) {
        this.pingming = pingming == null ? null : pingming.trim();
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand == null ? null : brand.trim();
    }

    public String getYongtu() {
        return yongtu;
    }

    public void setYongtu(String yongtu) {
        this.yongtu = yongtu == null ? null : yongtu.trim();
    }

    public String getGmodel() {
        return gmodel;
    }

    public void setGmodel(String gmodel) {
        this.gmodel = gmodel == null ? null : gmodel.trim();
    }

    public String getChengfen() {
        return chengfen;
    }

    public void setChengfen(String chengfen) {
        this.chengfen = chengfen == null ? null : chengfen.trim();
    }

    public String getNetworksellname() {
        return networksellname;
    }

    public void setNetworksellname(String networksellname) {
        this.networksellname = networksellname == null ? null : networksellname.trim();
    }

    public String getHyperlink() {
        return hyperlink;
    }

    public void setHyperlink(String hyperlink) {
        this.hyperlink = hyperlink == null ? null : hyperlink.trim();
    }

    public String getBatchid() {
        return batchid;
    }

    public void setBatchid(String batchid) {
        this.batchid = batchid == null ? null : batchid.trim();
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit == null ? null : unit.trim();
    }

    public String getPosttariffcode() {
        return posttariffcode;
    }

    public void setPosttariffcode(String posttariffcode) {
        this.posttariffcode = posttariffcode == null ? null : posttariffcode.trim();
    }

    public String getPosttariffname() {
        return posttariffname;
    }

    public void setPosttariffname(String posttariffname) {
        this.posttariffname = posttariffname == null ? null : posttariffname.trim();
    }

    public String getEportgoodsno() {
        return eportgoodsno;
    }

    public void setEportgoodsno(String eportgoodsno) {
        this.eportgoodsno = eportgoodsno == null ? null : eportgoodsno.trim();
    }

    public String getRegistno() {
        return registno;
    }

    public void setRegistno(String registno) {
        this.registno = registno == null ? null : registno.trim();
    }

    public Date getAppdate() {
        return appdate;
    }

    public void setAppdate(Date appdate) {
        this.appdate = appdate;
    }

    public Date getAppenddate() {
        return appenddate;
    }

    public void setAppenddate(Date appenddate) {
        this.appenddate = appenddate;
    }

    public String getCreateuserid() {
        return createuserid;
    }

    public void setCreateuserid(String createuserid) {
        this.createuserid = createuserid == null ? null : createuserid.trim();
    }

    public String getLastupdateuserid() {
        return lastupdateuserid;
    }

    public void setLastupdateuserid(String lastupdateuserid) {
        this.lastupdateuserid = lastupdateuserid == null ? null : lastupdateuserid.trim();
    }

    public Date getLastupdatetime() {
        return lastupdatetime;
    }

    public void setLastupdatetime(Date lastupdatetime) {
        this.lastupdatetime = lastupdatetime;
    }
}