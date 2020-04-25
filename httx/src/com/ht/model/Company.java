package com.ht.model;

public class Company {
    private Integer id;

    private String companycode;

    private String name;

    private String registno;

    private String inspectionregistno;

    private String address;

    private Short biztype;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCompanycode() {
        return companycode;
    }

    public void setCompanycode(String companycode) {
        this.companycode = companycode == null ? null : companycode.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getRegistno() {
        return registno;
    }

    public void setRegistno(String registno) {
        this.registno = registno == null ? null : registno.trim();
    }

    public String getInspectionregistno() {
        return inspectionregistno;
    }

    public void setInspectionregistno(String inspectionregistno) {
        this.inspectionregistno = inspectionregistno == null ? null : inspectionregistno.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public Short getBiztype() {
        return biztype;
    }

    public void setBiztype(Short biztype) {
        this.biztype = biztype;
    }
}