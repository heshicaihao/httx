package com.ht.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class IntEntrepotDetailExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public IntEntrepotDetailExample() {
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

        public Criteria andEntrepotidIsNull() {
            addCriterion("entrepotid is null");
            return (Criteria) this;
        }

        public Criteria andEntrepotidIsNotNull() {
            addCriterion("entrepotid is not null");
            return (Criteria) this;
        }

        public Criteria andEntrepotidEqualTo(Integer value) {
            addCriterion("entrepotid =", value, "entrepotid");
            return (Criteria) this;
        }

        public Criteria andEntrepotidNotEqualTo(Integer value) {
            addCriterion("entrepotid <>", value, "entrepotid");
            return (Criteria) this;
        }

        public Criteria andEntrepotidGreaterThan(Integer value) {
            addCriterion("entrepotid >", value, "entrepotid");
            return (Criteria) this;
        }

        public Criteria andEntrepotidGreaterThanOrEqualTo(Integer value) {
            addCriterion("entrepotid >=", value, "entrepotid");
            return (Criteria) this;
        }

        public Criteria andEntrepotidLessThan(Integer value) {
            addCriterion("entrepotid <", value, "entrepotid");
            return (Criteria) this;
        }

        public Criteria andEntrepotidLessThanOrEqualTo(Integer value) {
            addCriterion("entrepotid <=", value, "entrepotid");
            return (Criteria) this;
        }

        public Criteria andEntrepotidIn(List<Integer> values) {
            addCriterion("entrepotid in", values, "entrepotid");
            return (Criteria) this;
        }

        public Criteria andEntrepotidNotIn(List<Integer> values) {
            addCriterion("entrepotid not in", values, "entrepotid");
            return (Criteria) this;
        }

        public Criteria andEntrepotidBetween(Integer value1, Integer value2) {
            addCriterion("entrepotid between", value1, value2, "entrepotid");
            return (Criteria) this;
        }

        public Criteria andEntrepotidNotBetween(Integer value1, Integer value2) {
            addCriterion("entrepotid not between", value1, value2, "entrepotid");
            return (Criteria) this;
        }

        public Criteria andGoodsidIsNull() {
            addCriterion("goodsid is null");
            return (Criteria) this;
        }

        public Criteria andGoodsidIsNotNull() {
            addCriterion("goodsid is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsidEqualTo(Integer value) {
            addCriterion("goodsid =", value, "goodsid");
            return (Criteria) this;
        }

        public Criteria andGoodsidNotEqualTo(Integer value) {
            addCriterion("goodsid <>", value, "goodsid");
            return (Criteria) this;
        }

        public Criteria andGoodsidGreaterThan(Integer value) {
            addCriterion("goodsid >", value, "goodsid");
            return (Criteria) this;
        }

        public Criteria andGoodsidGreaterThanOrEqualTo(Integer value) {
            addCriterion("goodsid >=", value, "goodsid");
            return (Criteria) this;
        }

        public Criteria andGoodsidLessThan(Integer value) {
            addCriterion("goodsid <", value, "goodsid");
            return (Criteria) this;
        }

        public Criteria andGoodsidLessThanOrEqualTo(Integer value) {
            addCriterion("goodsid <=", value, "goodsid");
            return (Criteria) this;
        }

        public Criteria andGoodsidIn(List<Integer> values) {
            addCriterion("goodsid in", values, "goodsid");
            return (Criteria) this;
        }

        public Criteria andGoodsidNotIn(List<Integer> values) {
            addCriterion("goodsid not in", values, "goodsid");
            return (Criteria) this;
        }

        public Criteria andGoodsidBetween(Integer value1, Integer value2) {
            addCriterion("goodsid between", value1, value2, "goodsid");
            return (Criteria) this;
        }

        public Criteria andGoodsidNotBetween(Integer value1, Integer value2) {
            addCriterion("goodsid not between", value1, value2, "goodsid");
            return (Criteria) this;
        }

        public Criteria andDecpriceIsNull() {
            addCriterion("DecPrice is null");
            return (Criteria) this;
        }

        public Criteria andDecpriceIsNotNull() {
            addCriterion("DecPrice is not null");
            return (Criteria) this;
        }

        public Criteria andDecpriceEqualTo(BigDecimal value) {
            addCriterion("DecPrice =", value, "decprice");
            return (Criteria) this;
        }

        public Criteria andDecpriceNotEqualTo(BigDecimal value) {
            addCriterion("DecPrice <>", value, "decprice");
            return (Criteria) this;
        }

        public Criteria andDecpriceGreaterThan(BigDecimal value) {
            addCriterion("DecPrice >", value, "decprice");
            return (Criteria) this;
        }

        public Criteria andDecpriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("DecPrice >=", value, "decprice");
            return (Criteria) this;
        }

        public Criteria andDecpriceLessThan(BigDecimal value) {
            addCriterion("DecPrice <", value, "decprice");
            return (Criteria) this;
        }

        public Criteria andDecpriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("DecPrice <=", value, "decprice");
            return (Criteria) this;
        }

        public Criteria andDecpriceIn(List<BigDecimal> values) {
            addCriterion("DecPrice in", values, "decprice");
            return (Criteria) this;
        }

        public Criteria andDecpriceNotIn(List<BigDecimal> values) {
            addCriterion("DecPrice not in", values, "decprice");
            return (Criteria) this;
        }

        public Criteria andDecpriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("DecPrice between", value1, value2, "decprice");
            return (Criteria) this;
        }

        public Criteria andDecpriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("DecPrice not between", value1, value2, "decprice");
            return (Criteria) this;
        }

        public Criteria andGqtyIsNull() {
            addCriterion("GQty is null");
            return (Criteria) this;
        }

        public Criteria andGqtyIsNotNull() {
            addCriterion("GQty is not null");
            return (Criteria) this;
        }

        public Criteria andGqtyEqualTo(Integer value) {
            addCriterion("GQty =", value, "gqty");
            return (Criteria) this;
        }

        public Criteria andGqtyNotEqualTo(Integer value) {
            addCriterion("GQty <>", value, "gqty");
            return (Criteria) this;
        }

        public Criteria andGqtyGreaterThan(Integer value) {
            addCriterion("GQty >", value, "gqty");
            return (Criteria) this;
        }

        public Criteria andGqtyGreaterThanOrEqualTo(Integer value) {
            addCriterion("GQty >=", value, "gqty");
            return (Criteria) this;
        }

        public Criteria andGqtyLessThan(Integer value) {
            addCriterion("GQty <", value, "gqty");
            return (Criteria) this;
        }

        public Criteria andGqtyLessThanOrEqualTo(Integer value) {
            addCriterion("GQty <=", value, "gqty");
            return (Criteria) this;
        }

        public Criteria andGqtyIn(List<Integer> values) {
            addCriterion("GQty in", values, "gqty");
            return (Criteria) this;
        }

        public Criteria andGqtyNotIn(List<Integer> values) {
            addCriterion("GQty not in", values, "gqty");
            return (Criteria) this;
        }

        public Criteria andGqtyBetween(Integer value1, Integer value2) {
            addCriterion("GQty between", value1, value2, "gqty");
            return (Criteria) this;
        }

        public Criteria andGqtyNotBetween(Integer value1, Integer value2) {
            addCriterion("GQty not between", value1, value2, "gqty");
            return (Criteria) this;
        }

        public Criteria andDecltotalIsNull() {
            addCriterion("DeclTotal is null");
            return (Criteria) this;
        }

        public Criteria andDecltotalIsNotNull() {
            addCriterion("DeclTotal is not null");
            return (Criteria) this;
        }

        public Criteria andDecltotalEqualTo(BigDecimal value) {
            addCriterion("DeclTotal =", value, "decltotal");
            return (Criteria) this;
        }

        public Criteria andDecltotalNotEqualTo(BigDecimal value) {
            addCriterion("DeclTotal <>", value, "decltotal");
            return (Criteria) this;
        }

        public Criteria andDecltotalGreaterThan(BigDecimal value) {
            addCriterion("DeclTotal >", value, "decltotal");
            return (Criteria) this;
        }

        public Criteria andDecltotalGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("DeclTotal >=", value, "decltotal");
            return (Criteria) this;
        }

        public Criteria andDecltotalLessThan(BigDecimal value) {
            addCriterion("DeclTotal <", value, "decltotal");
            return (Criteria) this;
        }

        public Criteria andDecltotalLessThanOrEqualTo(BigDecimal value) {
            addCriterion("DeclTotal <=", value, "decltotal");
            return (Criteria) this;
        }

        public Criteria andDecltotalIn(List<BigDecimal> values) {
            addCriterion("DeclTotal in", values, "decltotal");
            return (Criteria) this;
        }

        public Criteria andDecltotalNotIn(List<BigDecimal> values) {
            addCriterion("DeclTotal not in", values, "decltotal");
            return (Criteria) this;
        }

        public Criteria andDecltotalBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("DeclTotal between", value1, value2, "decltotal");
            return (Criteria) this;
        }

        public Criteria andDecltotalNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("DeclTotal not between", value1, value2, "decltotal");
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