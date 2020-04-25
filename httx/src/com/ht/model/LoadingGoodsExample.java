package com.ht.model;

import java.util.ArrayList;
import java.util.List;

public class LoadingGoodsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public LoadingGoodsExample() {
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
            addCriterion("orderId is null");
            return (Criteria) this;
        }

        public Criteria andOrderidIsNotNull() {
            addCriterion("orderId is not null");
            return (Criteria) this;
        }

        public Criteria andOrderidEqualTo(String value) {
            addCriterion("orderId =", value, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidNotEqualTo(String value) {
            addCriterion("orderId <>", value, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidGreaterThan(String value) {
            addCriterion("orderId >", value, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidGreaterThanOrEqualTo(String value) {
            addCriterion("orderId >=", value, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidLessThan(String value) {
            addCriterion("orderId <", value, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidLessThanOrEqualTo(String value) {
            addCriterion("orderId <=", value, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidLike(String value) {
            addCriterion("orderId like", value, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidNotLike(String value) {
            addCriterion("orderId not like", value, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidIn(List<String> list) {
            addCriterion("orderId in", list, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidNotIn(List<String> values) {
            addCriterion("orderId not in", values, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidBetween(String value1, String value2) {
            addCriterion("orderId between", value1, value2, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidNotBetween(String value1, String value2) {
            addCriterion("orderId not between", value1, value2, "orderid");
            return (Criteria) this;
        }

        public Criteria andLoadingidIsNull() {
            addCriterion("loadingId is null");
            return (Criteria) this;
        }

        public Criteria andLoadingidIsNotNull() {
            addCriterion("loadingId is not null");
            return (Criteria) this;
        }

        public Criteria andLoadingidEqualTo(Integer value) {
            addCriterion("loadingId =", value, "loadingid");
            return (Criteria) this;
        }

        public Criteria andLoadingidNotEqualTo(Integer value) {
            addCriterion("loadingId <>", value, "loadingid");
            return (Criteria) this;
        }

        public Criteria andLoadingidGreaterThan(Integer value) {
            addCriterion("loadingId >", value, "loadingid");
            return (Criteria) this;
        }

        public Criteria andLoadingidGreaterThanOrEqualTo(Integer value) {
            addCriterion("loadingId >=", value, "loadingid");
            return (Criteria) this;
        }

        public Criteria andLoadingidLessThan(Integer value) {
            addCriterion("loadingId <", value, "loadingid");
            return (Criteria) this;
        }

        public Criteria andLoadingidLessThanOrEqualTo(Integer value) {
            addCriterion("loadingId <=", value, "loadingid");
            return (Criteria) this;
        }

        public Criteria andLoadingidIn(List<Integer> values) {
            addCriterion("loadingId in", values, "loadingid");
            return (Criteria) this;
        }

        public Criteria andLoadingidNotIn(List<Integer> values) {
            addCriterion("loadingId not in", values, "loadingid");
            return (Criteria) this;
        }

        public Criteria andLoadingidBetween(Integer value1, Integer value2) {
            addCriterion("loadingId between", value1, value2, "loadingid");
            return (Criteria) this;
        }

        public Criteria andLoadingidNotBetween(Integer value1, Integer value2) {
            addCriterion("loadingId not between", value1, value2, "loadingid");
            return (Criteria) this;
        }

        public Criteria andListentnoIsNull() {
            addCriterion("ListEntNo is null");
            return (Criteria) this;
        }

        public Criteria andListentnoIsNotNull() {
            addCriterion("ListEntNo is not null");
            return (Criteria) this;
        }

        public Criteria andListentnoEqualTo(String value) {
            addCriterion("ListEntNo =", value, "listentno");
            return (Criteria) this;
        }

        public Criteria andListentnoNotEqualTo(String value) {
            addCriterion("ListEntNo <>", value, "listentno");
            return (Criteria) this;
        }

        public Criteria andListentnoGreaterThan(String value) {
            addCriterion("ListEntNo >", value, "listentno");
            return (Criteria) this;
        }

        public Criteria andListentnoGreaterThanOrEqualTo(String value) {
            addCriterion("ListEntNo >=", value, "listentno");
            return (Criteria) this;
        }

        public Criteria andListentnoLessThan(String value) {
            addCriterion("ListEntNo <", value, "listentno");
            return (Criteria) this;
        }

        public Criteria andListentnoLessThanOrEqualTo(String value) {
            addCriterion("ListEntNo <=", value, "listentno");
            return (Criteria) this;
        }

        public Criteria andListentnoLike(String value) {
            addCriterion("ListEntNo like", value, "listentno");
            return (Criteria) this;
        }

        public Criteria andListentnoNotLike(String value) {
            addCriterion("ListEntNo not like", value, "listentno");
            return (Criteria) this;
        }

        public Criteria andListentnoIn(List<String> values) {
            addCriterion("ListEntNo in", values, "listentno");
            return (Criteria) this;
        }

        public Criteria andListentnoNotIn(List<String> values) {
            addCriterion("ListEntNo not in", values, "listentno");
            return (Criteria) this;
        }

        public Criteria andListentnoBetween(String value1, String value2) {
            addCriterion("ListEntNo between", value1, value2, "listentno");
            return (Criteria) this;
        }

        public Criteria andListentnoNotBetween(String value1, String value2) {
            addCriterion("ListEntNo not between", value1, value2, "listentno");
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