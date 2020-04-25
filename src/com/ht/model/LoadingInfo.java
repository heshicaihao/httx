package com.ht.model;

import java.math.BigDecimal;
import java.util.Date;

public class LoadingInfo {
    private Integer id;

    private String entinsideno;

    private String mastercustoms;

    private String vename;

    private Date loadingdate;

    private String note;

    private Date inputdate;

    private BigDecimal grosswt;
    private String orderids;
    private String  loading_no;
    public String getLoading_no() {
		return loading_no;
	}

	public void setLoading_no(String loading_no) {
		this.loading_no = loading_no;
	}

	public String getOrderids() {
		return orderids;
	}

	public void setOrderids(String orderids) {
		this.orderids = orderids;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEntinsideno() {
        return entinsideno;
    }

    public void setEntinsideno(String entinsideno) {
        this.entinsideno = entinsideno == null ? null : entinsideno.trim();
    }

    public String getMastercustoms() {
        return mastercustoms;
    }

    public void setMastercustoms(String mastercustoms) {
        this.mastercustoms = mastercustoms == null ? null : mastercustoms.trim();
    }

    public String getVename() {
        return vename;
    }

    public void setVename(String vename) {
        this.vename = vename == null ? null : vename.trim();
    }

    public Date getLoadingdate() {
        return loadingdate;
    }

    public void setLoadingdate(Date loadingdate) {
        this.loadingdate = loadingdate;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note == null ? null : note.trim();
    }

    public Date getInputdate() {
        return inputdate;
    }

    public void setInputdate(Date inputdate) {
        this.inputdate = inputdate;
    }

    public BigDecimal getGrosswt() {
        return grosswt;
    }

    public void setGrosswt(BigDecimal grosswt) {
        this.grosswt = grosswt;
    }
}