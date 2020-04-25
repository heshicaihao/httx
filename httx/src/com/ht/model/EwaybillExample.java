package com.ht.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class EwaybillExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public EwaybillExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andOrderidIsNull() {
            addCriterion("orderid is null");
            return (Criteria) this;
        }

        public Criteria andOrderidIsNotNull() {
            addCriterion("orderid is not null");
            return (Criteria) this;
        }

        public Criteria andOrderidEqualTo(String value) {
            addCriterion("orderid =", value, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidNotEqualTo(String value) {
            addCriterion("orderid <>", value, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidGreaterThan(String value) {
            addCriterion("orderid >", value, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidGreaterThanOrEqualTo(String value) {
            addCriterion("orderid >=", value, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidLessThan(Integer value) {
            addCriterion("orderid <", value, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidLessThanOrEqualTo(String value) {
            addCriterion("orderid <=", value, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidIn(List<Integer> values) {
            addCriterion("orderid in", values, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidNotIn(List<String> values) {
            addCriterion("orderid not in", values, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidBetween(String value1, String value2) {
            addCriterion("orderid between", value1, value2, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidNotBetween(String value1, String value2) {
            addCriterion("orderid not between", value1, value2, "orderid");
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

        public Criteria andEntrecordnameEqualTo(String value) {
            addCriterion("EntRecordName =", value, "entrecordname");
            return (Criteria) this;
        }

        public Criteria andEntrecordnameNotEqualTo(String value) {
            addCriterion("EntRecordName <>", value, "entrecordname");
            return (Criteria) this;
        }

        public Criteria andEntrecordnameGreaterThan(String value) {
            addCriterion("EntRecordName >", value, "entrecordname");
            return (Criteria) this;
        }

        public Criteria andEntrecordnameGreaterThanOrEqualTo(String value) {
            addCriterion("EntRecordName >=", value, "entrecordname");
            return (Criteria) this;
        }

        public Criteria andEntrecordnameLessThan(String value) {
            addCriterion("EntRecordName <", value, "entrecordname");
            return (Criteria) this;
        }

        public Criteria andEntrecordnameLessThanOrEqualTo(String value) {
            addCriterion("EntRecordName <=", value, "entrecordname");
            return (Criteria) this;
        }

        public Criteria andEntrecordnameLike(String value) {
            addCriterion("EntRecordName like", value, "entrecordname");
            return (Criteria) this;
        }

        public Criteria andEntrecordnameNotLike(String value) {
            addCriterion("EntRecordName not like", value, "entrecordname");
            return (Criteria) this;
        }

        public Criteria andEntrecordnameIn(List<String> values) {
            addCriterion("EntRecordName in", values, "entrecordname");
            return (Criteria) this;
        }

        public Criteria andEntrecordnameNotIn(List<String> values) {
            addCriterion("EntRecordName not in", values, "entrecordname");
            return (Criteria) this;
        }

        public Criteria andEntrecordnameBetween(String value1, String value2) {
            addCriterion("EntRecordName between", value1, value2, "entrecordname");
            return (Criteria) this;
        }

        public Criteria andEntrecordnameNotBetween(String value1, String value2) {
            addCriterion("EntRecordName not between", value1, value2, "entrecordname");
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
            addCriterion("EntRecordNo like", value, "entrecordno");
            return (Criteria) this;
        }

        public Criteria andEntrecordnoNotLike(String value) {
            addCriterion("EntRecordNo not like", value, "entrecordno");
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

        public Criteria andWaybillnoIsNull() {
            addCriterion("WayBillNo is null");
            return (Criteria) this;
        }

        public Criteria andWaybillnoIsNotNull() {
            addCriterion("WayBillNo is not null");
            return (Criteria) this;
        }

        public Criteria andWaybillnoEqualTo(String value) {
            addCriterion("WayBillNo =", value, "waybillno");
            return (Criteria) this;
        }

        public Criteria andWaybillnoNotEqualTo(String value) {
            addCriterion("WayBillNo <>", value, "waybillno");
            return (Criteria) this;
        }

        public Criteria andWaybillnoGreaterThan(String value) {
            addCriterion("WayBillNo >", value, "waybillno");
            return (Criteria) this;
        }

        public Criteria andWaybillnoGreaterThanOrEqualTo(String value) {
            addCriterion("WayBillNo >=", value, "waybillno");
            return (Criteria) this;
        }

        public Criteria andWaybillnoLessThan(String value) {
            addCriterion("WayBillNo <", value, "waybillno");
            return (Criteria) this;
        }

        public Criteria andWaybillnoLessThanOrEqualTo(String value) {
            addCriterion("WayBillNo <=", value, "waybillno");
            return (Criteria) this;
        }

        public Criteria andWaybillnoLike(String value) {
            addCriterion("WayBillNo like", value, "waybillno");
            return (Criteria) this;
        }

        public Criteria andWaybillnoNotLike(String value) {
            addCriterion("WayBillNo not like", value, "waybillno");
            return (Criteria) this;
        }

        public Criteria andWaybillnoIn(List<String> values) {
            addCriterion("WayBillNo in", values, "waybillno");
            return (Criteria) this;
        }

        public Criteria andWaybillnoNotIn(List<String> values) {
            addCriterion("WayBillNo not in", values, "waybillno");
            return (Criteria) this;
        }

        public Criteria andWaybillnoBetween(String value1, String value2) {
            addCriterion("WayBillNo between", value1, value2, "waybillno");
            return (Criteria) this;
        }

        public Criteria andWaybillnoNotBetween(String value1, String value2) {
            addCriterion("WayBillNo not between", value1, value2, "waybillno");
            return (Criteria) this;
        }

        public Criteria andDeclaretypeIsNull() {
            addCriterion("DeclareType is null");
            return (Criteria) this;
        }

        public Criteria andDeclaretypeIsNotNull() {
            addCriterion("DeclareType is not null");
            return (Criteria) this;
        }

        public Criteria andDeclaretypeEqualTo(String value) {
            addCriterion("DeclareType =", value, "declaretype");
            return (Criteria) this;
        }

        public Criteria andDeclaretypeNotEqualTo(String value) {
            addCriterion("DeclareType <>", value, "declaretype");
            return (Criteria) this;
        }

        public Criteria andDeclaretypeGreaterThan(String value) {
            addCriterion("DeclareType >", value, "declaretype");
            return (Criteria) this;
        }

        public Criteria andDeclaretypeGreaterThanOrEqualTo(String value) {
            addCriterion("DeclareType >=", value, "declaretype");
            return (Criteria) this;
        }

        public Criteria andDeclaretypeLessThan(String value) {
            addCriterion("DeclareType <", value, "declaretype");
            return (Criteria) this;
        }

        public Criteria andDeclaretypeLessThanOrEqualTo(String value) {
            addCriterion("DeclareType <=", value, "declaretype");
            return (Criteria) this;
        }

        public Criteria andDeclaretypeLike(String value) {
            addCriterion("DeclareType like", value, "declaretype");
            return (Criteria) this;
        }

        public Criteria andDeclaretypeNotLike(String value) {
            addCriterion("DeclareType not like", value, "declaretype");
            return (Criteria) this;
        }

        public Criteria andDeclaretypeIn(List<String> values) {
            addCriterion("DeclareType in", values, "declaretype");
            return (Criteria) this;
        }

        public Criteria andDeclaretypeNotIn(List<String> values) {
            addCriterion("DeclareType not in", values, "declaretype");
            return (Criteria) this;
        }

        public Criteria andDeclaretypeBetween(String value1, String value2) {
            addCriterion("DeclareType between", value1, value2, "declaretype");
            return (Criteria) this;
        }

        public Criteria andDeclaretypeNotBetween(String value1, String value2) {
            addCriterion("DeclareType not between", value1, value2, "declaretype");
            return (Criteria) this;
        }

        public Criteria andLogisticsstatusIsNull() {
            addCriterion("LogisticsStatus is null");
            return (Criteria) this;
        }

        public Criteria andLogisticsstatusIsNotNull() {
            addCriterion("LogisticsStatus is not null");
            return (Criteria) this;
        }

        public Criteria andLogisticsstatusEqualTo(String value) {
            addCriterion("LogisticsStatus =", value, "logisticsstatus");
            return (Criteria) this;
        }

        public Criteria andLogisticsstatusNotEqualTo(String value) {
            addCriterion("LogisticsStatus <>", value, "logisticsstatus");
            return (Criteria) this;
        }

        public Criteria andLogisticsstatusGreaterThan(String value) {
            addCriterion("LogisticsStatus >", value, "logisticsstatus");
            return (Criteria) this;
        }

        public Criteria andLogisticsstatusGreaterThanOrEqualTo(String value) {
            addCriterion("LogisticsStatus >=", value, "logisticsstatus");
            return (Criteria) this;
        }

        public Criteria andLogisticsstatusLessThan(String value) {
            addCriterion("LogisticsStatus <", value, "logisticsstatus");
            return (Criteria) this;
        }

        public Criteria andLogisticsstatusLessThanOrEqualTo(String value) {
            addCriterion("LogisticsStatus <=", value, "logisticsstatus");
            return (Criteria) this;
        }

        public Criteria andLogisticsstatusLike(String value) {
            addCriterion("LogisticsStatus like", value, "logisticsstatus");
            return (Criteria) this;
        }

        public Criteria andLogisticsstatusNotLike(String value) {
            addCriterion("LogisticsStatus not like", value, "logisticsstatus");
            return (Criteria) this;
        }

        public Criteria andLogisticsstatusIn(List<String> values) {
            addCriterion("LogisticsStatus in", values, "logisticsstatus");
            return (Criteria) this;
        }

        public Criteria andLogisticsstatusNotIn(List<String> values) {
            addCriterion("LogisticsStatus not in", values, "logisticsstatus");
            return (Criteria) this;
        }

        public Criteria andLogisticsstatusBetween(String value1, String value2) {
            addCriterion("LogisticsStatus between", value1, value2, "logisticsstatus");
            return (Criteria) this;
        }

        public Criteria andLogisticsstatusNotBetween(String value1, String value2) {
            addCriterion("LogisticsStatus not between", value1, value2, "logisticsstatus");
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

        public Criteria andValuationfeeIsNull() {
            addCriterion("ValuationFee is null");
            return (Criteria) this;
        }

        public Criteria andValuationfeeIsNotNull() {
            addCriterion("ValuationFee is not null");
            return (Criteria) this;
        }

        public Criteria andValuationfeeEqualTo(BigDecimal value) {
            addCriterion("ValuationFee =", value, "valuationfee");
            return (Criteria) this;
        }

        public Criteria andValuationfeeNotEqualTo(BigDecimal value) {
            addCriterion("ValuationFee <>", value, "valuationfee");
            return (Criteria) this;
        }

        public Criteria andValuationfeeGreaterThan(BigDecimal value) {
            addCriterion("ValuationFee >", value, "valuationfee");
            return (Criteria) this;
        }

        public Criteria andValuationfeeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("ValuationFee >=", value, "valuationfee");
            return (Criteria) this;
        }

        public Criteria andValuationfeeLessThan(BigDecimal value) {
            addCriterion("ValuationFee <", value, "valuationfee");
            return (Criteria) this;
        }

        public Criteria andValuationfeeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("ValuationFee <=", value, "valuationfee");
            return (Criteria) this;
        }

        public Criteria andValuationfeeIn(List<BigDecimal> values) {
            addCriterion("ValuationFee in", values, "valuationfee");
            return (Criteria) this;
        }

        public Criteria andValuationfeeNotIn(List<BigDecimal> values) {
            addCriterion("ValuationFee not in", values, "valuationfee");
            return (Criteria) this;
        }

        public Criteria andValuationfeeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ValuationFee between", value1, value2, "valuationfee");
            return (Criteria) this;
        }

        public Criteria andValuationfeeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ValuationFee not between", value1, value2, "valuationfee");
            return (Criteria) this;
        }

        public Criteria andNoticenoIsNull() {
            addCriterion("NoticeNo is null");
            return (Criteria) this;
        }

        public Criteria andNoticenoIsNotNull() {
            addCriterion("NoticeNo is not null");
            return (Criteria) this;
        }

        public Criteria andNoticenoEqualTo(String value) {
            addCriterion("NoticeNo =", value, "noticeno");
            return (Criteria) this;
        }

        public Criteria andNoticenoNotEqualTo(String value) {
            addCriterion("NoticeNo <>", value, "noticeno");
            return (Criteria) this;
        }

        public Criteria andNoticenoGreaterThan(String value) {
            addCriterion("NoticeNo >", value, "noticeno");
            return (Criteria) this;
        }

        public Criteria andNoticenoGreaterThanOrEqualTo(String value) {
            addCriterion("NoticeNo >=", value, "noticeno");
            return (Criteria) this;
        }

        public Criteria andNoticenoLessThan(String value) {
            addCriterion("NoticeNo <", value, "noticeno");
            return (Criteria) this;
        }

        public Criteria andNoticenoLessThanOrEqualTo(String value) {
            addCriterion("NoticeNo <=", value, "noticeno");
            return (Criteria) this;
        }

        public Criteria andNoticenoLike(String value) {
            addCriterion("NoticeNo like", value, "noticeno");
            return (Criteria) this;
        }

        public Criteria andNoticenoNotLike(String value) {
            addCriterion("NoticeNo not like", value, "noticeno");
            return (Criteria) this;
        }

        public Criteria andNoticenoIn(List<String> values) {
            addCriterion("NoticeNo in", values, "noticeno");
            return (Criteria) this;
        }

        public Criteria andNoticenoNotIn(List<String> values) {
            addCriterion("NoticeNo not in", values, "noticeno");
            return (Criteria) this;
        }

        public Criteria andNoticenoBetween(String value1, String value2) {
            addCriterion("NoticeNo between", value1, value2, "noticeno");
            return (Criteria) this;
        }

        public Criteria andNoticenoNotBetween(String value1, String value2) {
            addCriterion("NoticeNo not between", value1, value2, "noticeno");
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