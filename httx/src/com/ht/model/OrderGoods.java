package com.ht.model;

import java.math.BigDecimal;

public class OrderGoods {
    private Integer id;

    private String orderid;

    private Integer goodsid;

    private BigDecimal decprice;

    private Integer gqty;

    private BigDecimal decltotal;

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
        this.orderid = orderid == null ? null : orderid.trim();
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
}