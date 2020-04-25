package com.ht.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrderInfoExample {
	private static final long serialVersionUID = 1L;

	protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;
    
    protected Integer rows; 
	protected Integer offset;

    public Integer getRows() {
		return rows;
	}

	public void setRows(Integer rows) {
		this.rows = rows;
	}

	public Integer getOffset() {
		return offset;
	}

	public void setOffset(Integer offset) {
		this.offset = offset;
	}

	public OrderInfoExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andOrderidIsNull() {
            addCriterion("OrderId is null");
            return (Criteria) this;
        }

        public Criteria andOrderidIsNotNull() {
            addCriterion("OrderId is not null");
            return (Criteria) this;
        }

        public Criteria andOrderidEqualTo(String value) {
            addCriterion("OrderId =", value, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidNotEqualTo(String value) {
            addCriterion("OrderId <>", value, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidGreaterThan(String value) {
            addCriterion("OrderId >", value, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidGreaterThanOrEqualTo(String value) {
            addCriterion("OrderId >=", value, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidLessThan(String value) {
            addCriterion("OrderId <", value, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidLessThanOrEqualTo(String value) {
            addCriterion("OrderId <=", value, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidLike(String value) {
            addCriterion("OrderId like", "%"+value+"%", "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidNotLike(String value) {
            addCriterion("OrderId not like", value, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidIn(List<String> values) {
            addCriterion("OrderId in", values, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidNotIn(List<String> values) {
            addCriterion("OrderId not in", values, "orderid");
            return (Criteria) this;
        }
        
        public Criteria andPickGoodNolike(String values) {
            addCriterion("pickgoodsno like ", "%"+values+"%", "pickgoodsno");
            return (Criteria) this;
        }

        public Criteria andPickGoodNoIsNull() {
            addCriterion("pickgoodsno is null");
            return (Criteria) this;
        }

        public Criteria andPickGoodNoIsNotNull() {
            addCriterion("pickgoodsno is not null");
            return (Criteria) this;
        }
        
        public Criteria andOrderidBetween(String value1, String value2) {
            addCriterion("OrderId between", value1, value2, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidNotBetween(String value1, String value2) {
            addCriterion("OrderId not between", value1, value2, "orderid");
            return (Criteria) this;
        }

        public Criteria andCompanyidIsNull() {
            addCriterion("companyID is null");
            return (Criteria) this;
        }

        public Criteria andCompanyidIsNotNull() {
            addCriterion("companyID is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyidEqualTo(Integer value) {
            addCriterion("companyID =", value, "companyid");
            return (Criteria) this;
        }

        public Criteria andCompanyidNotEqualTo(Integer value) {
            addCriterion("companyID <>", value, "companyid");
            return (Criteria) this;
        }

        public Criteria andCompanyidGreaterThan(Integer value) {
            addCriterion("companyID >", value, "companyid");
            return (Criteria) this;
        }

        public Criteria andCompanyidGreaterThanOrEqualTo(Integer value) {
            addCriterion("companyID >=", value, "companyid");
            return (Criteria) this;
        }

        public Criteria andCompanyidLessThan(Integer value) {
            addCriterion("companyID <", value, "companyid");
            return (Criteria) this;
        }

        public Criteria andCompanyidLessThanOrEqualTo(Integer value) {
            addCriterion("companyID <=", value, "companyid");
            return (Criteria) this;
        }

        public Criteria andCompanyidIn(List<Integer> values) {
            addCriterion("companyID in", values, "companyid");
            return (Criteria) this;
        }

        public Criteria andCompanyidNotIn(List<Integer> values) {
            addCriterion("companyID not in", values, "companyid");
            return (Criteria) this;
        }

        public Criteria andCompanyidBetween(Integer value1, Integer value2) {
            addCriterion("companyID between", value1, value2, "companyid");
            return (Criteria) this;
        }

        public Criteria andCompanyidNotBetween(Integer value1, Integer value2) {
            addCriterion("companyID not between", value1, value2, "companyid");
            return (Criteria) this;
        }

        public Criteria andEntrecordnoIsNull() {
            addCriterion("EntRecordNo is null");
            return (Criteria) this;
        }

        public Criteria andEntrecordnoIsNotNull() {
            addCriterion("EntRecordNo is not null");
            return (Criteria) this;
        }

        public Criteria andEntrecordnoEqualTo(String value) {
            addCriterion("EntRecordNo =", value, "entrecordno");
            return (Criteria) this;
        }

        public Criteria andEntrecordnoNotEqualTo(String value) {
            addCriterion("EntRecordNo <>", value, "entrecordno");
            return (Criteria) this;
        }

        public Criteria andEntrecordnoGreaterThan(String value) {
            addCriterion("EntRecordNo >", value, "entrecordno");
            return (Criteria) this;
        }

        public Criteria andEntrecordnoGreaterThanOrEqualTo(String value) {
            addCriterion("EntRecordNo >=", value, "entrecordno");
            return (Criteria) this;
        }

        public Criteria andEntrecordnoLessThan(String value) {
            addCriterion("EntRecordNo <", value, "entrecordno");
            return (Criteria) this;
        }

        public Criteria andEntrecordnoLessThanOrEqualTo(String value) {
            addCriterion("EntRecordNo <=", value, "entrecordno");
            return (Criteria) this;
        }

        public Criteria andEntrecordnoLike(String value) {
            addCriterion("EntRecordNo like",  "%"+value+"%", "entrecordno");
            return (Criteria) this;
        }

        public Criteria andEntrecordnoNotLike(String value) {
            addCriterion("EntRecordNo not like", value, "entrecordno");
            return (Criteria) this;
        }

        public Criteria andFirstCreateNameLike(String value) {
            addCriterion("firstcreatename  like",   "%"+value+"%", "firstcreatename");
            return (Criteria) this;
        }
        
        public Criteria andEntrecordnoIn(List<String> values) {
            addCriterion("EntRecordNo in", values, "entrecordno");
            return (Criteria) this;
        }

        public Criteria andEntrecordnoNotIn(List<String> values) {
            addCriterion("EntRecordNo not in", values, "entrecordno");
            return (Criteria) this;
        }

        public Criteria andEntrecordnoBetween(String value1, String value2) {
            addCriterion("EntRecordNo between", value1, value2, "entrecordno");
            return (Criteria) this;
        }

        public Criteria andEntrecordnoNotBetween(String value1, String value2) {
            addCriterion("EntRecordNo not between", value1, value2, "entrecordno");
            return (Criteria) this;
        }

        public Criteria andEntrecordnameIsNull() {
            addCriterion("EntRecordName is null");
            return (Criteria) this;
        }

        public Criteria andEntrecordnameIsNotNull() {
            addCriterion("EntRecordName is not null");
            return (Criteria) this;
        }

        public Criteria andEntrecordnameEqualTo(Integer value) {
            addCriterion("EntRecordName =", value, "entrecordname");
            return (Criteria) this;
        }

        public Criteria andEntrecordnameNotEqualTo(Integer value) {
            addCriterion("EntRecordName <>", value, "entrecordname");
            return (Criteria) this;
        }

        public Criteria andEntrecordnameGreaterThan(Integer value) {
            addCriterion("EntRecordName >", value, "entrecordname");
            return (Criteria) this;
        }

        public Criteria andEntrecordnameGreaterThanOrEqualTo(Integer value) {
            addCriterion("EntRecordName >=", value, "entrecordname");
            return (Criteria) this;
        }

        public Criteria andEntrecordnameLessThan(Integer value) {
            addCriterion("EntRecordName <", value, "entrecordname");
            return (Criteria) this;
        }

        public Criteria andEntrecordnameLessThanOrEqualTo(Integer value) {
            addCriterion("EntRecordName <=", value, "entrecordname");
            return (Criteria) this;
        }

        public Criteria andEntrecordnameIn(List<Integer> values) {
            addCriterion("EntRecordName in", values, "entrecordname");
            return (Criteria) this;
        }

        public Criteria andEntrecordnameNotIn(List<Integer> values) {
            addCriterion("EntRecordName not in", values, "entrecordname");
            return (Criteria) this;
        }

        public Criteria andEntrecordnameBetween(Integer value1, Integer value2) {
            addCriterion("EntRecordName between", value1, value2, "entrecordname");
            return (Criteria) this;
        }

        public Criteria andEntrecordnameNotBetween(Integer value1, Integer value2) {
            addCriterion("EntRecordName not between", value1, value2, "entrecordname");
            return (Criteria) this;
        }

        public Criteria andOrdernameIsNull() {
            addCriterion("OrderName is null");
            return (Criteria) this;
        }

        public Criteria andOrdernameIsNotNull() {
            addCriterion("OrderName is not null");
            return (Criteria) this;
        }

        public Criteria andOrdernameEqualTo(String value) {
            addCriterion("OrderName =", value, "ordername");
            return (Criteria) this;
        }

        public Criteria andOrdernameNotEqualTo(String value) {
            addCriterion("OrderName <>", value, "ordername");
            return (Criteria) this;
        }

        public Criteria andOrdernameGreaterThan(String value) {
            addCriterion("OrderName >", value, "ordername");
            return (Criteria) this;
        }

        public Criteria andOrdernameGreaterThanOrEqualTo(String value) {
            addCriterion("OrderName >=", value, "ordername");
            return (Criteria) this;
        }

        public Criteria andOrdernameLessThan(String value) {
            addCriterion("OrderName <", value, "ordername");
            return (Criteria) this;
        }

        public Criteria andOrdernameLessThanOrEqualTo(String value) {
            addCriterion("OrderName <=", value, "ordername");
            return (Criteria) this;
        }

        public Criteria andOrdernameLike(String value) {
            addCriterion("OrderName like", value, "ordername");
            return (Criteria) this;
        }

        public Criteria andOrdernameNotLike(String value) {
            addCriterion("OrderName not like", value, "ordername");
            return (Criteria) this;
        }

        public Criteria andOrdernameIn(List<String> values) {
            addCriterion("OrderName in", values, "ordername");
            return (Criteria) this;
        }

        public Criteria andOrdernameNotIn(List<String> values) {
            addCriterion("OrderName not in", values, "ordername");
            return (Criteria) this;
        }

        public Criteria andOrdernameBetween(String value1, String value2) {
            addCriterion("OrderName between", value1, value2, "ordername");
            return (Criteria) this;
        }

        public Criteria andOrdernameNotBetween(String value1, String value2) {
            addCriterion("OrderName not between", value1, value2, "ordername");
            return (Criteria) this;
        }

        public Criteria andOrderdocidIsNull() {
            addCriterion("OrderDocId is null");
            return (Criteria) this;
        }

        public Criteria andOrderdocidIsNotNull() {
            addCriterion("OrderDocId is not null");
            return (Criteria) this;
        }

        public Criteria andOrderdocidEqualTo(String value) {
            addCriterion("OrderDocId =", value, "orderdocid");
            return (Criteria) this;
        }

        public Criteria andOrderdocidNotEqualTo(String value) {
            addCriterion("OrderDocId <>", value, "orderdocid");
            return (Criteria) this;
        }

        public Criteria andOrderdocidGreaterThan(String value) {
            addCriterion("OrderDocId >", value, "orderdocid");
            return (Criteria) this;
        }

        public Criteria andOrderdocidGreaterThanOrEqualTo(String value) {
            addCriterion("OrderDocId >=", value, "orderdocid");
            return (Criteria) this;
        }

        public Criteria andOrderdocidLessThan(String value) {
            addCriterion("OrderDocId <", value, "orderdocid");
            return (Criteria) this;
        }

        public Criteria andOrderdocidLessThanOrEqualTo(String value) {
            addCriterion("OrderDocId <=", value, "orderdocid");
            return (Criteria) this;
        }

        public Criteria andOrderdocidLike(String value) {
            addCriterion("OrderDocId like", value, "orderdocid");
            return (Criteria) this;
        }

        public Criteria andOrderdocidNotLike(String value) {
            addCriterion("OrderDocId not like", value, "orderdocid");
            return (Criteria) this;
        }

        public Criteria andOrderdocidIn(List<String> values) {
            addCriterion("OrderDocId in", values, "orderdocid");
            return (Criteria) this;
        }

        public Criteria andOrderdocidNotIn(List<String> values) {
            addCriterion("OrderDocId not in", values, "orderdocid");
            return (Criteria) this;
        }

        public Criteria andOrderdocidBetween(String value1, String value2) {
            addCriterion("OrderDocId between", value1, value2, "orderdocid");
            return (Criteria) this;
        }

        public Criteria andOrderdocidNotBetween(String value1, String value2) {
            addCriterion("OrderDocId not between", value1, value2, "orderdocid");
            return (Criteria) this;
        }

        public Criteria andOrderaddressIsNull() {
            addCriterion("OrderAddress is null");
            return (Criteria) this;
        }

        public Criteria andOrderaddressIsNotNull() {
            addCriterion("OrderAddress is not null");
            return (Criteria) this;
        }

        public Criteria andOrderaddressEqualTo(String value) {
            addCriterion("OrderAddress =", value, "orderaddress");
            return (Criteria) this;
        }

        public Criteria andOrderaddressNotEqualTo(String value) {
            addCriterion("OrderAddress <>", value, "orderaddress");
            return (Criteria) this;
        }

        public Criteria andOrderaddressGreaterThan(String value) {
            addCriterion("OrderAddress >", value, "orderaddress");
            return (Criteria) this;
        }

        public Criteria andOrderaddressGreaterThanOrEqualTo(String value) {
            addCriterion("OrderAddress >=", value, "orderaddress");
            return (Criteria) this;
        }

        public Criteria andOrderaddressLessThan(String value) {
            addCriterion("OrderAddress <", value, "orderaddress");
            return (Criteria) this;
        }

        public Criteria andOrderaddressLessThanOrEqualTo(String value) {
            addCriterion("OrderAddress <=", value, "orderaddress");
            return (Criteria) this;
        }

        public Criteria andOrderaddressLike(String value) {
            addCriterion("OrderAddress like", value, "orderaddress");
            return (Criteria) this;
        }

        public Criteria andOrderaddressNotLike(String value) {
            addCriterion("OrderAddress not like", value, "orderaddress");
            return (Criteria) this;
        }

        public Criteria andOrderaddressIn(List<String> values) {
            addCriterion("OrderAddress in", values, "orderaddress");
            return (Criteria) this;
        }

        public Criteria andOrderaddressNotIn(List<String> values) {
            addCriterion("OrderAddress not in", values, "orderaddress");
            return (Criteria) this;
        }

        public Criteria andOrderaddressBetween(String value1, String value2) {
            addCriterion("OrderAddress between", value1, value2, "orderaddress");
            return (Criteria) this;
        }

        public Criteria andOrderaddressNotBetween(String value1, String value2) {
            addCriterion("OrderAddress not between", value1, value2, "orderaddress");
            return (Criteria) this;
        }

        public Criteria andOrderphoneIsNull() {
            addCriterion("OrderPhone is null");
            return (Criteria) this;
        }

        public Criteria andOrderphoneIsNotNull() {
            addCriterion("OrderPhone is not null");
            return (Criteria) this;
        }

        public Criteria andOrderphoneEqualTo(String value) {
            addCriterion("OrderPhone =", value, "orderphone");
            return (Criteria) this;
        }

        public Criteria andOrderphoneNotEqualTo(String value) {
            addCriterion("OrderPhone <>", value, "orderphone");
            return (Criteria) this;
        }

        public Criteria andOrderphoneGreaterThan(String value) {
            addCriterion("OrderPhone >", value, "orderphone");
            return (Criteria) this;
        }

        public Criteria andOrderphoneGreaterThanOrEqualTo(String value) {
            addCriterion("OrderPhone >=", value, "orderphone");
            return (Criteria) this;
        }

        public Criteria andOrderphoneLessThan(String value) {
            addCriterion("OrderPhone <", value, "orderphone");
            return (Criteria) this;
        }

        public Criteria andOrderphoneLessThanOrEqualTo(String value) {
            addCriterion("OrderPhone <=", value, "orderphone");
            return (Criteria) this;
        }

        public Criteria andOrderphoneLike(String value) {
            addCriterion("OrderPhone like", value, "orderphone");
            return (Criteria) this;
        }

        public Criteria andOrderphoneNotLike(String value) {
            addCriterion("OrderPhone not like", value, "orderphone");
            return (Criteria) this;
        }

        public Criteria andOrderphoneIn(List<String> values) {
            addCriterion("OrderPhone in", values, "orderphone");
            return (Criteria) this;
        }

        public Criteria andOrderphoneNotIn(List<String> values) {
            addCriterion("OrderPhone not in", values, "orderphone");
            return (Criteria) this;
        }

        public Criteria andOrderphoneBetween(String value1, String value2) {
            addCriterion("OrderPhone between", value1, value2, "orderphone");
            return (Criteria) this;
        }

        public Criteria andOrderphoneNotBetween(String value1, String value2) {
            addCriterion("OrderPhone not between", value1, value2, "orderphone");
            return (Criteria) this;
        }

        public Criteria andOrderdateIsNull() {
            addCriterion("OrderDate is null");
            return (Criteria) this;
        }

        public Criteria andOrderdateIsNotNull() {
            addCriterion("OrderDate is not null");
            return (Criteria) this;
        }

        public Criteria andOrderdateEqualTo(Date value) {
            addCriterion("OrderDate =", value, "orderdate");
            return (Criteria) this;
        }

        public Criteria andOrderdateNotEqualTo(Date value) {
            addCriterion("OrderDate <>", value, "orderdate");
            return (Criteria) this;
        }

        public Criteria andOrderdateGreaterThan(Date value) {
            addCriterion("OrderDate >", value, "orderdate");
            return (Criteria) this;
        }

        public Criteria andOrderdateGreaterThanOrEqualTo(Date value) {
            addCriterion("OrderDate >=", value, "orderdate");
            return (Criteria) this;
        }

        public Criteria andOrderdateLessThan(Date value) {
            addCriterion("OrderDate <", value, "orderdate");
            return (Criteria) this;
        }

        public Criteria andOrderdateLessThanOrEqualTo(Date value) {
            addCriterion("OrderDate <=", value, "orderdate");
            return (Criteria) this;
        }

        public Criteria andOrderdateIn(List<Date> values) {
            addCriterion("OrderDate in", values, "orderdate");
            return (Criteria) this;
        }

        public Criteria andOrderdateNotIn(List<Date> values) {
            addCriterion("OrderDate not in", values, "orderdate");
            return (Criteria) this;
        }

        public Criteria andOrderdateBetween(Date value1, Date value2) {
            addCriterion("OrderDate between", value1, value2, "orderdate");
            return (Criteria) this;
        }

        public Criteria andOrderdateNotBetween(Date value1, Date value2) {
            addCriterion("OrderDate not between", value1, value2, "orderdate");
            return (Criteria) this;
        }

        public Criteria andOrderstatusIsNull() {
            addCriterion("OrderStatus is null");
            return (Criteria) this;
        }

        public Criteria andOrderstatusIsNotNull() {
            addCriterion("OrderStatus is not null");
            return (Criteria) this;
        }

        public Criteria andOrderstatusEqualTo(String value) {
            addCriterion("OrderStatus =", value, "orderstatus");
            return (Criteria) this;
        }

        public Criteria andOrderstatusNotEqualTo(String value) {
            addCriterion("OrderStatus <>", value, "orderstatus");
            return (Criteria) this;
        }

        public Criteria andOrderstatusGreaterThan(String value) {
            addCriterion("OrderStatus >", value, "orderstatus");
            return (Criteria) this;
        }

        public Criteria andOrderstatusGreaterThanOrEqualTo(String value) {
            addCriterion("OrderStatus >=", value, "orderstatus");
            return (Criteria) this;
        }

        public Criteria andOrderstatusLessThan(String value) {
            addCriterion("OrderStatus <", value, "orderstatus");
            return (Criteria) this;
        }

        public Criteria andOrderstatusLessThanOrEqualTo(String value) {
            addCriterion("OrderStatus <=", value, "orderstatus");
            return (Criteria) this;
        }

        public Criteria andOrderstatusLike(String value) {
            addCriterion("OrderStatus like", value, "orderstatus");
            return (Criteria) this;
        }

        public Criteria andOrderstatusNotLike(String value) {
            addCriterion("OrderStatus not like", value, "orderstatus");
            return (Criteria) this;
        }

        public Criteria andOrderstatusIn(List<String> values) {
            addCriterion("OrderStatus in", values, "orderstatus");
            return (Criteria) this;
        }

        public Criteria andOrderstatusNotIn(List<String> values) {
            addCriterion("OrderStatus not in", values, "orderstatus");
            return (Criteria) this;
        }

        public Criteria andOrderstatusBetween(String value1, String value2) {
            addCriterion("OrderStatus between", value1, value2, "orderstatus");
            return (Criteria) this;
        }

        public Criteria andOrderstatusNotBetween(String value1, String value2) {
            addCriterion("OrderStatus not between", value1, value2, "orderstatus");
            return (Criteria) this;
        }

        public Criteria andOrdergoodtotalIsNull() {
            addCriterion("OrderGoodTotal is null");
            return (Criteria) this;
        }

        public Criteria andOrdergoodtotalIsNotNull() {
            addCriterion("OrderGoodTotal is not null");
            return (Criteria) this;
        }

        public Criteria andOrdergoodtotalEqualTo(BigDecimal value) {
            addCriterion("OrderGoodTotal =", value, "ordergoodtotal");
            return (Criteria) this;
        }

        public Criteria andOrdergoodtotalNotEqualTo(BigDecimal value) {
            addCriterion("OrderGoodTotal <>", value, "ordergoodtotal");
            return (Criteria) this;
        }

        public Criteria andOrdergoodtotalGreaterThan(BigDecimal value) {
            addCriterion("OrderGoodTotal >", value, "ordergoodtotal");
            return (Criteria) this;
        }

        public Criteria andOrdergoodtotalGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("OrderGoodTotal >=", value, "ordergoodtotal");
            return (Criteria) this;
        }

        public Criteria andOrdergoodtotalLessThan(BigDecimal value) {
            addCriterion("OrderGoodTotal <", value, "ordergoodtotal");
            return (Criteria) this;
        }

        public Criteria andOrdergoodtotalLessThanOrEqualTo(BigDecimal value) {
            addCriterion("OrderGoodTotal <=", value, "ordergoodtotal");
            return (Criteria) this;
        }

        public Criteria andOrdergoodtotalIn(List<BigDecimal> values) {
            addCriterion("OrderGoodTotal in", values, "ordergoodtotal");
            return (Criteria) this;
        }

        public Criteria andOrdergoodtotalNotIn(List<BigDecimal> values) {
            addCriterion("OrderGoodTotal not in", values, "ordergoodtotal");
            return (Criteria) this;
        }

        public Criteria andOrdergoodtotalBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("OrderGoodTotal between", value1, value2, "ordergoodtotal");
            return (Criteria) this;
        }

        public Criteria andOrdergoodtotalNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("OrderGoodTotal not between", value1, value2, "ordergoodtotal");
            return (Criteria) this;
        }

        public Criteria andFreightIsNull() {
            addCriterion("Freight is null");
            return (Criteria) this;
        }

        public Criteria andFreightIsNotNull() {
            addCriterion("Freight is not null");
            return (Criteria) this;
        }

        public Criteria andFreightEqualTo(BigDecimal value) {
            addCriterion("Freight =", value, "freight");
            return (Criteria) this;
        }

        public Criteria andFreightNotEqualTo(BigDecimal value) {
            addCriterion("Freight <>", value, "freight");
            return (Criteria) this;
        }

        public Criteria andFreightGreaterThan(BigDecimal value) {
            addCriterion("Freight >", value, "freight");
            return (Criteria) this;
        }

        public Criteria andFreightGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("Freight >=", value, "freight");
            return (Criteria) this;
        }

        public Criteria andFreightLessThan(BigDecimal value) {
            addCriterion("Freight <", value, "freight");
            return (Criteria) this;
        }

        public Criteria andFreightLessThanOrEqualTo(BigDecimal value) {
            addCriterion("Freight <=", value, "freight");
            return (Criteria) this;
        }

        public Criteria andFreightIn(List<BigDecimal> values) {
            addCriterion("Freight in", values, "freight");
            return (Criteria) this;
        }

        public Criteria andFreightNotIn(List<BigDecimal> values) {
            addCriterion("Freight not in", values, "freight");
            return (Criteria) this;
        }

        public Criteria andFreightBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("Freight between", value1, value2, "freight");
            return (Criteria) this;
        }

        public Criteria andFreightNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("Freight not between", value1, value2, "freight");
            return (Criteria) this;
        }

        public Criteria andTaxIsNull() {
            addCriterion("Tax is null");
            return (Criteria) this;
        }

        public Criteria andTaxIsNotNull() {
            addCriterion("Tax is not null");
            return (Criteria) this;
        }

        public Criteria andTaxEqualTo(BigDecimal value) {
            addCriterion("Tax =", value, "tax");
            return (Criteria) this;
        }

        public Criteria andTaxNotEqualTo(BigDecimal value) {
            addCriterion("Tax <>", value, "tax");
            return (Criteria) this;
        }

        public Criteria andTaxGreaterThan(BigDecimal value) {
            addCriterion("Tax >", value, "tax");
            return (Criteria) this;
        }

        public Criteria andTaxGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("Tax >=", value, "tax");
            return (Criteria) this;
        }

        public Criteria andTaxLessThan(BigDecimal value) {
            addCriterion("Tax <", value, "tax");
            return (Criteria) this;
        }

        public Criteria andTaxLessThanOrEqualTo(BigDecimal value) {
            addCriterion("Tax <=", value, "tax");
            return (Criteria) this;
        }

        public Criteria andTaxIn(List<BigDecimal> values) {
            addCriterion("Tax in", values, "tax");
            return (Criteria) this;
        }

        public Criteria andTaxNotIn(List<BigDecimal> values) {
            addCriterion("Tax not in", values, "tax");
            return (Criteria) this;
        }

        public Criteria andTaxBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("Tax between", value1, value2, "tax");
            return (Criteria) this;
        }

        public Criteria andTaxNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("Tax not between", value1, value2, "tax");
            return (Criteria) this;
        }

        public Criteria andOrdergoodtotalcurrIsNull() {
            addCriterion("OrderGoodTotalCurr is null");
            return (Criteria) this;
        }

        public Criteria andOrdergoodtotalcurrIsNotNull() {
            addCriterion("OrderGoodTotalCurr is not null");
            return (Criteria) this;
        }

        public Criteria andOrdergoodtotalcurrEqualTo(String value) {
            addCriterion("OrderGoodTotalCurr =", value, "ordergoodtotalcurr");
            return (Criteria) this;
        }

        public Criteria andOrdergoodtotalcurrNotEqualTo(String value) {
            addCriterion("OrderGoodTotalCurr <>", value, "ordergoodtotalcurr");
            return (Criteria) this;
        }

        public Criteria andOrdergoodtotalcurrGreaterThan(String value) {
            addCriterion("OrderGoodTotalCurr >", value, "ordergoodtotalcurr");
            return (Criteria) this;
        }

        public Criteria andOrdergoodtotalcurrGreaterThanOrEqualTo(String value) {
            addCriterion("OrderGoodTotalCurr >=", value, "ordergoodtotalcurr");
            return (Criteria) this;
        }

        public Criteria andOrdergoodtotalcurrLessThan(String value) {
            addCriterion("OrderGoodTotalCurr <", value, "ordergoodtotalcurr");
            return (Criteria) this;
        }

        public Criteria andOrdergoodtotalcurrLessThanOrEqualTo(String value) {
            addCriterion("OrderGoodTotalCurr <=", value, "ordergoodtotalcurr");
            return (Criteria) this;
        }

        public Criteria andOrdergoodtotalcurrLike(String value) {
            addCriterion("OrderGoodTotalCurr like", value, "ordergoodtotalcurr");
            return (Criteria) this;
        }

        public Criteria andOrdergoodtotalcurrNotLike(String value) {
            addCriterion("OrderGoodTotalCurr not like", value, "ordergoodtotalcurr");
            return (Criteria) this;
        }

        public Criteria andOrdergoodtotalcurrIn(List<String> values) {
            addCriterion("OrderGoodTotalCurr in", values, "ordergoodtotalcurr");
            return (Criteria) this;
        }

        public Criteria andOrdergoodtotalcurrNotIn(List<String> values) {
            addCriterion("OrderGoodTotalCurr not in", values, "ordergoodtotalcurr");
            return (Criteria) this;
        }

        public Criteria andOrdergoodtotalcurrBetween(String value1, String value2) {
            addCriterion("OrderGoodTotalCurr between", value1, value2, "ordergoodtotalcurr");
            return (Criteria) this;
        }

        public Criteria andOrdergoodtotalcurrNotBetween(String value1, String value2) {
            addCriterion("OrderGoodTotalCurr not between", value1, value2, "ordergoodtotalcurr");
            return (Criteria) this;
        }

        public Criteria andNoteIsNull() {
            addCriterion("Note is null");
            return (Criteria) this;
        }

        public Criteria andNoteIsNotNull() {
            addCriterion("Note is not null");
            return (Criteria) this;
        }

        public Criteria andNoteEqualTo(String value) {
            addCriterion("Note =", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteNotEqualTo(String value) {
            addCriterion("Note <>", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteGreaterThan(String value) {
            addCriterion("Note >", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteGreaterThanOrEqualTo(String value) {
            addCriterion("Note >=", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteLessThan(String value) {
            addCriterion("Note <", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteLessThanOrEqualTo(String value) {
            addCriterion("Note <=", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteLike(String value) {
            addCriterion("Note like", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteNotLike(String value) {
            addCriterion("Note not like", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteIn(List<String> values) {
            addCriterion("Note in", values, "note");
            return (Criteria) this;
        }

        public Criteria andNoteNotIn(List<String> values) {
            addCriterion("Note not in", values, "note");
            return (Criteria) this;
        }

        public Criteria andNoteBetween(String value1, String value2) {
            addCriterion("Note between", value1, value2, "note");
            return (Criteria) this;
        }

        public Criteria andNoteNotBetween(String value1, String value2) {
            addCriterion("Note not between", value1, value2, "note");
            return (Criteria) this;
        }

        public Criteria andCreateruseridIsNull() {
            addCriterion("Createruserid is null");
            return (Criteria) this;
        }

        public Criteria andCreateruseridIsNotNull() {
            addCriterion("Createruserid is not null");
            return (Criteria) this;
        }

        public Criteria andCreateruseridEqualTo(Integer value) {
            addCriterion("Createruserid =", value, "createruserid");
            return (Criteria) this;
        }

        public Criteria andCreateruseridNotEqualTo(Integer value) {
            addCriterion("Createruserid <>", value, "createruserid");
            return (Criteria) this;
        }

        public Criteria andCreateruseridGreaterThan(Integer value) {
            addCriterion("Createruserid >", value, "createruserid");
            return (Criteria) this;
        }

        public Criteria andCreateruseridGreaterThanOrEqualTo(Integer value) {
            addCriterion("Createruserid >=", value, "createruserid");
            return (Criteria) this;
        }

        public Criteria andCreateruseridLessThan(Integer value) {
            addCriterion("Createruserid <", value, "createruserid");
            return (Criteria) this;
        }

        public Criteria andCreateruseridLessThanOrEqualTo(Integer value) {
            addCriterion("Createruserid <=", value, "createruserid");
            return (Criteria) this;
        }

        public Criteria andCreateruseridIn(List<Integer> values) {
            addCriterion("Createruserid in", values, "createruserid");
            return (Criteria) this;
        }

        public Criteria andCreateruseridNotIn(List<Integer> values) {
            addCriterion("Createruserid not in", values, "createruserid");
            return (Criteria) this;
        }

        public Criteria andCreateruseridBetween(Integer value1, Integer value2) {
            addCriterion("Createruserid between", value1, value2, "createruserid");
            return (Criteria) this;
        }

        public Criteria andCreateruseridNotBetween(Integer value1, Integer value2) {
            addCriterion("Createruserid not between", value1, value2, "createruserid");
            return (Criteria) this;
        }

        public Criteria andEwaysnumIsNull() {
            addCriterion("Ewaysnum is null");
            return (Criteria) this;
        }

        public Criteria andEwaysnumIsNotNull() {
            addCriterion("Ewaysnum is not null");
            return (Criteria) this;
        }

        public Criteria andEwaysnumEqualTo(String value) {
            addCriterion("Ewaysnum =", value, "ewaysnum");
            return (Criteria) this;
        }

        public Criteria andEwaysnumNotEqualTo(String value) {
            addCriterion("Ewaysnum <>", value, "ewaysnum");
            return (Criteria) this;
        }

        public Criteria andEwaysnumGreaterThan(String value) {
            addCriterion("Ewaysnum >", value, "ewaysnum");
            return (Criteria) this;
        }
       
        public Criteria andEwaysnumGreaterThanOrEqualTo(String value) {
            addCriterion("Ewaysnum >=", value, "ewaysnum");
            return (Criteria) this;
        }

        public Criteria andEwaysnumLessThan(String value) {
            addCriterion("Ewaysnum <", value, "ewaysnum");
            return (Criteria) this;
        }

        public Criteria andEwaysnumLessThanOrEqualTo(String value) {
            addCriterion("Ewaysnum <=", value, "ewaysnum");
            return (Criteria) this;
        }

        public Criteria andEwaysnumLike(String value) {
            addCriterion("Ewaysnum like",  "%"+value+"%", "ewaysnum");
            return (Criteria) this;
        }

        public Criteria andEwaysnumNotLike(String value) {
            addCriterion("Ewaysnum not like", value, "ewaysnum");
            return (Criteria) this;
        }

        public Criteria andEwaysnumIn(List<String> values) {
            addCriterion("Ewaysnum in", values, "ewaysnum");
            return (Criteria) this;
        }

        public Criteria andEwaysnumNotIn(List<String> values) {
            addCriterion("Ewaysnum not in", values, "ewaysnum");
            return (Criteria) this;
        }

        public Criteria andEwaysnumBetween(String value1, String value2) {
            addCriterion("Ewaysnum between", value1, value2, "ewaysnum");
            return (Criteria) this;
        }

        public Criteria andEwaysnumNotBetween(String value1, String value2) {
            addCriterion("Ewaysnum not between", value1, value2, "ewaysnum");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }
        public Criteria andLoadNoIsNotNull() {
            addCriterion("loading_no is not null");
            return (Criteria) this;
        }
        public Criteria andLoadNoGreaterThan(String value) {
            addCriterion("loading_no >", value, "loading_no");
            return (Criteria) this;
        }
        public Criteria andStatusEqualTo(String value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(String value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(String value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(String value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(String value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(String value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLike(String value) {
            addCriterion("status like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotLike(String value) {
            addCriterion("status not like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<String> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<String> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(String value1, String value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(String value1, String value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andOrderdoctypeIsNull() {
            addCriterion("OrderDocType is null");
            return (Criteria) this;
        }

        public Criteria andOrderdoctypeIsNotNull() {
            addCriterion("OrderDocType is not null");
            return (Criteria) this;
        }

        public Criteria andOrderdoctypeEqualTo(String value) {
            addCriterion("OrderDocType =", value, "orderdoctype");
            return (Criteria) this;
        }

        public Criteria andOrderdoctypeNotEqualTo(String value) {
            addCriterion("OrderDocType <>", value, "orderdoctype");
            return (Criteria) this;
        }

        public Criteria andOrderdoctypeGreaterThan(String value) {
            addCriterion("OrderDocType >", value, "orderdoctype");
            return (Criteria) this;
        }

        public Criteria andOrderdoctypeGreaterThanOrEqualTo(String value) {
            addCriterion("OrderDocType >=", value, "orderdoctype");
            return (Criteria) this;
        }

        public Criteria andOrderdoctypeLessThan(String value) {
            addCriterion("OrderDocType <", value, "orderdoctype");
            return (Criteria) this;
        }

        public Criteria andOrderdoctypeLessThanOrEqualTo(String value) {
            addCriterion("OrderDocType <=", value, "orderdoctype");
            return (Criteria) this;
        }

        public Criteria andOrderdoctypeLike(String value) {
            addCriterion("OrderDocType like", value, "orderdoctype");
            return (Criteria) this;
        }

        public Criteria andOrderdoctypeNotLike(String value) {
            addCriterion("OrderDocType not like", value, "orderdoctype");
            return (Criteria) this;
        }

        public Criteria andOrderdoctypeIn(List<String> values) {
            addCriterion("OrderDocType in", values, "orderdoctype");
            return (Criteria) this;
        }

        public Criteria andOrderdoctypeNotIn(List<String> values) {
            addCriterion("OrderDocType not in", values, "orderdoctype");
            return (Criteria) this;
        }

        public Criteria andOrderdoctypeBetween(String value1, String value2) {
            addCriterion("OrderDocType between", value1, value2, "orderdoctype");
            return (Criteria) this;
        }

        public Criteria andOrderdoctypeNotBetween(String value1, String value2) {
            addCriterion("OrderDocType not between", value1, value2, "orderdoctype");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}