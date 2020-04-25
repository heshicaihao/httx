package com.ht.model;

import java.math.BigDecimal;

public class OrderGoodsDetail {
    private Integer id;

    private String orderid;

    private Integer goodsid;

    private BigDecimal decprice;

    private Integer gqty;

    private BigDecimal decltotal;

    private String note;
    
    private String batchNo;
    
    private String copgno;
    
    private String gname;
    
    private String unit_name;
    
    private String unit_code;
    
    private BigDecimal grosswt;
    
    private BigDecimal netwt;
    
    private String barCode;
    
    private int seqNo;
    
    private String registNo;
    
    private String companyregistNo;
    
    private String inspectionRegistNo;
    
    private String no;
    
    private String country;
    private String gmodel;
    private String manufactory;
    
    private String hscode;
    
    private String instkey;
    
    private String  totalNo;

    public String getTotalNo() {
		return totalNo;
	}

	public void setTotalNo(String totalNo) {
		this.totalNo = totalNo;
	}

	public String getInstkey() {
		return instkey;
	}

	public void setInstkey(String instkey) {
		this.instkey = instkey;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

   
    public Integer getGoodsid() {
        return goodsid;
    }

    public void setGoodsid(Integer goodsid) {
        this.goodsid = goodsid;
    }

    public BigDecimal getDecprice() {
        return decprice;
    }

    public void setDecprice(BigDecimal decprice) {
        this.decprice = decprice;
    }

    public Integer getGqty() {
        return gqty;
    }

    public void setGqty(Integer gqty) {
        this.gqty = gqty;
    }

    public BigDecimal getDecltotal() {
        return decltotal;
    }

    public void setDecltotal(BigDecimal decltotal) {
        this.decltotal = decltotal;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note == null ? null : note.trim();
    }

	public String getBatchNo() {
		return batchNo;
	}

	public void setBatchNo(String batchNo) {
		this.batchNo = batchNo;
	}

	public String getCopgno() {
		return copgno;
	}

	public void setCopgno(String gopgno) {
		this.copgno = gopgno;
	}

	public String getGname() {
		return gname;
	}

	public void setGname(String gname) {
		this.gname = gname;
	}

	public String getUnit_name() {
		return unit_name;
	}

	public void setUnit_name(String unit_name) {
		this.unit_name = unit_name;
	}

	public BigDecimal getGrosswt() {
		return grosswt;
	}

	public void setGrosswt(BigDecimal grosswt) {
		this.grosswt = grosswt;
	}

	public BigDecimal getNetwt() {
		return netwt;
	}

	public void setNetwt(BigDecimal netwt) {
		this.netwt = netwt;
	}

	public String getBarCode() {
		return barCode;
	}

	public void setBarCode(String barCode) {
		this.barCode = barCode;
	}

	public int getSeqNo() {
		return seqNo;
	}

	public void setSeqNo(int seqNo) {
		this.seqNo = seqNo;
	}

	public String getRegistNo() {
		return registNo;
	}

	public void setRegistNo(String registNo) {
		this.registNo = registNo;
	}

	public String getCompanyregistNo() {
		return companyregistNo;
	}

	public void setCompanyregistNo(String companyregistNo) {
		this.companyregistNo = companyregistNo;
	}

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public String getUnit_code() {
		return unit_code;
	}

	public void setUnit_code(String unit_code) {
		this.unit_code = unit_code;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getGmodel() {
		return gmodel;
	}

	public void setGmodel(String gmodel) {
		this.gmodel = gmodel;
	}

	public String getManufactory() {
		return manufactory;
	}

	public void setManufactory(String manufactory) {
		this.manufactory = manufactory;
	}

	public String getInspectionRegistNo() {
		return inspectionRegistNo;
	}

	public void setInspectionRegistNo(String inspectionRegistNo) {
		this.inspectionRegistNo = inspectionRegistNo;
	}

	public String getHscode() {
		return hscode;
	}

	public void setHscode(String hscode) {
		this.hscode = hscode;
	}

	public String getOrderid() {
		return orderid;
	}

	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}
	
}