package com.ht.model;

import java.math.BigDecimal;

public class Ewaybill {
    private Integer id;

    private String orderid;

    private String entrecordname;

    private String entrecordno;

    private String waybillno;

    private String declaretype;

    private String logisticsstatus;

    private BigDecimal freight;

    private BigDecimal valuationfee;
    
    private BigDecimal tax;

    private String noticeno;

    private String note;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrderid() {
		return orderid;
	}

	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}

	public String getEntrecordname() {
        return entrecordname;
    }

    public void setEntrecordname(String entrecordname) {
        this.entrecordname = entrecordname == null ? null : entrecordname.trim();
    }

    public String getEntrecordno() {
        return entrecordno;
    }

    public void setEntrecordno(String entrecordno) {
        this.entrecordno = entrecordno == null ? null : entrecordno.trim();
    }

    public String getWaybillno() {
        return waybillno;
    }

    public void setWaybillno(String waybillno) {
        this.waybillno = waybillno == null ? null : waybillno.trim();
    }

    public String getDeclaretype() {
        return declaretype;
    }

    public void setDeclaretype(String declaretype) {
        this.declaretype = declaretype == null ? null : declaretype.trim();
    }

    public String getLogisticsstatus() {
        return logisticsstatus;
    }

    public void setLogisticsstatus(String logisticsstatus) {
        this.logisticsstatus = logisticsstatus == null ? null : logisticsstatus.trim();
    }

    public BigDecimal getFreight() {
        return freight;
    }

    public void setFreight(BigDecimal freight) {
        this.freight = freight;
    }

    public BigDecimal getValuationfee() {
        return valuationfee;
    }

    public void setValuationfee(BigDecimal valuationfee) {
        this.valuationfee = valuationfee;
    }

    public String getNoticeno() {
        return noticeno;
    }

    public void setNoticeno(String noticeno) {
        this.noticeno = noticeno == null ? null : noticeno.trim();
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note == null ? null : note.trim();
    }

	public BigDecimal getTax() {
		return tax;
	}

	public void setTax(BigDecimal tax) {
		this.tax = tax;
	}
    
}