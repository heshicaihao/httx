package com.ht.model;

import java.math.BigDecimal;
import java.util.Date;

import com.ht.util.StringUtil;


public class Report extends PageParam{
	//ID
	private Integer id;
	//订单号
	private String orderno;
	//商品编码  产品编码
	private String hscode;
	//批次号
	private String batchno;
	//客户ID
	private Integer custid;
	private String custName;
	//客户商品编码
	private String usergoodscode;
	//数量
	private Integer gqty;
	//计量单位
	private String unit;
	//金额
	private String goodsmoney;
	//海关申报重量
	private String hgappweight;
	//国际运单号
	private String gjewaysno;
	//收件人名称
	private String recname;
	//收件人电话
	private String reccellno;
	//收件人地址
	private String recaddr;
	//事务处理类型
	private String type;
	//处理时间
	private String dealtime;
	//描述
	private String remark;
	//创建人
	private Integer userid;
	private String username;
	private String startDate;
	private String endDate;
	//批次入库时间
	private String entryDate;
	//单位
	private String custUnit;
	//产品型号
	private String goodsModel;
	//客户货号(商品货号）
	private String copGNo;
	//商品描述
	private String goodDesc;
	//批次号入库时间
	private String writeDate;
	//单据号
	private String billNo;
	
	private String orderDocId;
	
	//产品型号
	private String gmodel;
	
	//入库明细描述
	private String note;
		
	private Date startDateD;
	private Date endDateD;
	
	private String createDateStr;
	
	private String statusStr;
	
	private BigDecimal declTotal;
	
	/**客户电子订单编号*/
	private String entRecordNo;
	
	private BigDecimal totalWT;
	
	/**运单号*/
	private String ewaysnum;
	
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	private String noticeNo;
	
	private String province;
	private String city;
	
	//库存现有量
	private Integer currentInventory;
	
	private String actionType;
	
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getEntryDate() {
		return entryDate;
	}
	public void setEntryDate(String entryDate) {
		this.entryDate = entryDate;
	}
	public String getCustUnit() {
		return custUnit;
	}
	public void setCustUnit(String custUnit) {
		this.custUnit = custUnit;
	}
	public String getGoodsModel() {
		return goodsModel;
	}
	public void setGoodsModel(String goodsModel) {
		this.goodsModel = goodsModel;
	}
	public String getGoodDesc() {
		return goodDesc;
	}
	public void setGoodDesc(String goodDesc) {
		this.goodDesc = goodDesc;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getOrderno() {
		return orderno;
	}
	
	public String getOrdernoLike() {
		if(!StringUtil.isEmpty(orderno)){
			return "%" + orderno.trim().toUpperCase() + "%";
		}
		return orderno;
	}
	public void setOrderno(String orderno) {
		this.orderno = orderno;
	}
	public String getHscode() {
		return hscode;
	}
	public void setHscode(String hscode) {
		this.hscode = hscode;
	}
	public String getBatchno() {
		return batchno;
	}
	public void setBatchno(String batchno) {
		this.batchno = batchno;
	}
	public Integer getCustid() {
		return custid;
	}
	public void setCustid(Integer custid) {
		this.custid = custid;
	}
	public String getUsergoodscode() {
		return usergoodscode;
	}
	
	public String getUsergoodscodeLike() {
		if(!StringUtil.isEmpty(usergoodscode)){
			return "%" + usergoodscode.trim().toUpperCase() + "%";
		}
		return usergoodscode;
	}
	public void setUsergoodscode(String usergoodscode) {
		this.usergoodscode = usergoodscode;
	}
	public Integer getGqty() {
		return gqty;
	}
	public void setGqty(Integer gqty) {
		this.gqty = gqty;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public String getGoodsmoney() {
		return goodsmoney;
	}
	public void setGoodsmoney(String goodsmoney) {
		this.goodsmoney = goodsmoney;
	}
	public String getHgappweight() {
		return hgappweight;
	}
	public void setHgappweight(String hgappweight) {
		this.hgappweight = hgappweight;
	}
	public String getGjewaysno() {
		return gjewaysno;
	}
	public void setGjewaysno(String gjewaysno) {
		this.gjewaysno = gjewaysno;
	}
	public String getRecnameLike() {
		if(!StringUtil.isEmpty(recname)){
			return "%" + recname.trim().toUpperCase() + "%";
		}
		return recname;
	}
	public String getRecname() {
		return recname;
	}
	public void setRecname(String recname) {
		this.recname = recname;
	}
	public String getReccellno() {
		return reccellno;
	}
	public void setReccellno(String reccellno) {
		this.reccellno = reccellno;
	}
	public String getRecaddr() {
		return recaddr;
	}
	public void setRecaddr(String recaddr) {
		this.recaddr = recaddr;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getDealtime() {
		return dealtime;
	}
	public void setDealtime(String dealtime) {
		this.dealtime = dealtime;
	}
	public String getDesc() {
		return remark;
	}
	public void setDesc(String remark) {
		this.remark = remark;
	}
	public Integer getUserid() {
		return userid;
	}
	public void setUserid(Integer userid) {
		this.userid = userid;
	}
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
	public String getWriteDate() {
		return writeDate;
	}
	public void setWriteDate(String writeDate) {
		this.writeDate = writeDate;
	}
	public String getCopGNo() {
		return copGNo;
	}
	public void setCopGNo(String copGNo) {
		this.copGNo = copGNo;
	}
	public String getBillNo() {
		return billNo;
	}
	public void setBillNo(String billNo) {
		this.billNo = billNo;
	}
	public Date getStartDateD() {
		return startDateD;
	}
	public void setStartDateD(Date startDateD) {
		this.startDateD = startDateD;
	}
	public Date getEndDateD() {
		return endDateD;
	}
	public void setEndDateD(Date endDateD) {
		this.endDateD = endDateD;
	}
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public Integer getCurrentInventory() {
		return currentInventory;
	}
	public void setCurrentInventory(Integer currentInventory) {
		this.currentInventory = currentInventory;
	}
	public String getGmodel() {
		return gmodel;
	}
	public void setGmodel(String gmodel) {
		this.gmodel = gmodel;
	}
	public BigDecimal getDeclTotal() {
		return declTotal;
	}
	public void setDeclTotal(BigDecimal declTotal) {
		this.declTotal = declTotal;
	}
	public String getEntRecordNo() {
		return entRecordNo;
	}
	
	public String getEntRecordNoLike() {
		if(!StringUtil.isEmpty(entRecordNo)){
			return "%" + entRecordNo.trim().toUpperCase() + "%";
		}
		return entRecordNo;
	}
	public void setEntRecordNo(String entRecordNo) {
		this.entRecordNo = entRecordNo;
	}
	public BigDecimal getTotalWT() {
		return totalWT;
	}
	public void setTotalWT(BigDecimal totalWT) {
		this.totalWT = totalWT;
	}
	public String getEwaysnum() {
		return ewaysnum;
	}
	public void setEwaysnum(String ewaysnum) {
		this.ewaysnum = ewaysnum;
	}
	public String getActionType() {
		return actionType;
	}
	public void setActionType(String actionType) {
		this.actionType = actionType;
	}
	public String getOrderDocId() {
		return orderDocId;
	}
	public void setOrderDocId(String orderDocId) {
		this.orderDocId = orderDocId;
	}
	public String getStatusStr() {
		return statusStr;
	}
	public void setStatusStr(String statusStr) {
		this.statusStr = statusStr;
	}
	public String getNoticeNo() {
		return noticeNo;
	}
	public void setNoticeNo(String noticeNo) {
		this.noticeNo = noticeNo;
	}
	public String getCreateDateStr() {
		return createDateStr;
	}
	public void setCreateDateStr(String createDateStr) {
		this.createDateStr = createDateStr;
	}
	
}