package com.ht.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class LoadingInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public LoadingInfoExample() {
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
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

        public Criteria andEntinsidenoIsNull() {
            addCriterion("EntInsideNo is null");
            return (Criteria) this;
        }

        public Criteria andEntinsidenoIsNotNull() {
            addCriterion("EntInsideNo is not null");
            return (Criteria) this;
        }

        public Criteria andEntinsidenoEqualTo(String value) {
            addCriterion("EntInsideNo =", value, "entinsideno");
            return (Criteria) this;
        }

        public Criteria andEntinsidenoNotEqualTo(String value) {
            addCriterion("EntInsideNo <>", value, "entinsideno");
            return (Criteria) this;
        }

        public Criteria andEntinsidenoGreaterThan(String value) {
            addCriterion("EntInsideNo >", value, "entinsideno");
            return (Criteria) this;
        }

        public Criteria andEntinsidenoGreaterThanOrEqualTo(String value) {
            addCriterion("EntInsideNo >=", value, "entinsideno");
            return (Criteria) this;
        }

        public Criteria andEntinsidenoLessThan(String value) {
            addCriterion("EntInsideNo <", value, "entinsideno");
            return (Criteria) this;
        }

        public Criteria andEntinsidenoLessThanOrEqualTo(String value) {
            addCriterion("EntInsideNo <=", value, "entinsideno");
            return (Criteria) this;
        }

        public Criteria andEntinsidenoLike(String value) {
            addCriterion("EntInsideNo like", value, "entinsideno");
            return (Criteria) this;
        }

        public Criteria andEntinsidenoNotLike(String value) {
            addCriterion("EntInsideNo not like", value, "entinsideno");
            return (Criteria) this;
        }

        public Criteria andEntinsidenoIn(List<String> values) {
            addCriterion("EntInsideNo in", values, "entinsideno");
            return (Criteria) this;
        }

        public Criteria andEntinsidenoNotIn(List<String> values) {
            addCriterion("EntInsideNo not in", values, "entinsideno");
            return (Criteria) this;
        }

        public Criteria andEntinsidenoBetween(String value1, String value2) {
            addCriterion("EntInsideNo between", value1, value2, "entinsideno");
            return (Criteria) this;
        }

        public Criteria andEntinsidenoNotBetween(String value1, String value2) {
            addCriterion("EntInsideNo not between", value1, value2, "entinsideno");
            return (Criteria) this;
        }

        public Criteria andMastercustomsIsNull() {
            addCriterion("MasterCustoms is null");
            return (Criteria) this;
        }

        public Criteria andMastercustomsIsNotNull() {
            addCriterion("MasterCustoms is not null");
            return (Criteria) this;
        }

        public Criteria andMastercustomsEqualTo(String value) {
            addCriterion("MasterCustoms =", value, "mastercustoms");
            return (Criteria) this;
        }

        public Criteria andMastercustomsNotEqualTo(String value) {
            addCriterion("MasterCustoms <>", value, "mastercustoms");
            return (Criteria) this;
        }

        public Criteria andMastercustomsGreaterThan(String value) {
            addCriterion("MasterCustoms >", value, "mastercustoms");
            return (Criteria) this;
        }

        public Criteria andMastercustomsGreaterThanOrEqualTo(String value) {
            addCriterion("MasterCustoms >=", value, "mastercustoms");
            return (Criteria) this;
        }

        public Criteria andMastercustomsLessThan(String value) {
            addCriterion("MasterCustoms <", value, "mastercustoms");
            return (Criteria) this;
        }

        public Criteria andMastercustomsLessThanOrEqualTo(String value) {
            addCriterion("MasterCustoms <=", value, "mastercustoms");
            return (Criteria) this;
        }

        public Criteria andMastercustomsLike(String value) {
            addCriterion("MasterCustoms like", value, "mastercustoms");
            return (Criteria) this;
        }

        public Criteria andMastercustomsNotLike(String value) {
            addCriterion("MasterCustoms not like", value, "mastercustoms");
            return (Criteria) this;
        }

        public Criteria andMastercustomsIn(List<String> values) {
            addCriterion("MasterCustoms in", values, "mastercustoms");
            return (Criteria) this;
        }

        public Criteria andMastercustomsNotIn(List<String> values) {
            addCriterion("MasterCustoms not in", values, "mastercustoms");
            return (Criteria) this;
        }

        public Criteria andMastercustomsBetween(String value1, String value2) {
            addCriterion("MasterCustoms between", value1, value2, "mastercustoms");
            return (Criteria) this;
        }

        public Criteria andMastercustomsNotBetween(String value1, String value2) {
            addCriterion("MasterCustoms not between", value1, value2, "mastercustoms");
            return (Criteria) this;
        }

        public Criteria andVenameIsNull() {
            addCriterion("VeName is null");
            return (Criteria) this;
        }

        public Criteria andVenameIsNotNull() {
            addCriterion("VeName is not null");
            return (Criteria) this;
        }

        public Criteria andVenameEqualTo(String value) {
            addCriterion("VeName =", value, "vename");
            return (Criteria) this;
        }

        public Criteria andVenameNotEqualTo(String value) {
            addCriterion("VeName <>", value, "vename");
            return (Criteria) this;
        }

        public Criteria andVenameGreaterThan(String value) {
            addCriterion("VeName >", value, "vename");
            return (Criteria) this;
        }

        public Criteria andVenameGreaterThanOrEqualTo(String value) {
            addCriterion("VeName >=", value, "vename");
            return (Criteria) this;
        }

        public Criteria andVenameLessThan(String value) {
            addCriterion("VeName <", value, "vename");
            return (Criteria) this;
        }

        public Criteria andVenameLessThanOrEqualTo(String value) {
            addCriterion("VeName <=", value, "vename");
            return (Criteria) this;
        }

        public Criteria andVenameLike(String value) {
            addCriterion("VeName like", value, "vename");
            return (Criteria) this;
        }

        public Criteria andVenameNotLike(String value) {
            addCriterion("VeName not like", value, "vename");
            return (Criteria) this;
        }

        public Criteria andVenameIn(List<String> values) {
            addCriterion("VeName in", values, "vename");
            return (Criteria) this;
        }

        public Criteria andVenameNotIn(List<String> values) {
            addCriterion("VeName not in", values, "vename");
            return (Criteria) this;
        }

        public Criteria andVenameBetween(String value1, String value2) {
            addCriterion("VeName between", value1, value2, "vename");
            return (Criteria) this;
        }

        public Criteria andVenameNotBetween(String value1, String value2) {
            addCriterion("VeName not between", value1, value2, "vename");
            return (Criteria) this;
        }

        public Criteria andLoadingdateIsNull() {
            addCriterion("LoadingDate is null");
            return (Criteria) this;
        }

        public Criteria andLoadingdateIsNotNull() {
            addCriterion("LoadingDate is not null");
            return (Criteria) this;
        }

        public Criteria andLoadingdateEqualTo(Date value) {
            addCriterionForJDBCDate("LoadingDate =", value, "loadingdate");
            return (Criteria) this;
        }

        public Criteria andLoadingdateNotEqualTo(Date value) {
            addCriterionForJDBCDate("LoadingDate <>", value, "loadingdate");
            return (Criteria) this;
        }

        public Criteria andLoadingdateGreaterThan(Date value) {
            addCriterionForJDBCDate("LoadingDate >", value, "loadingdate");
            return (Criteria) this;
        }

        public Criteria andLoadingdateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("LoadingDate >=", value, "loadingdate");
            return (Criteria) this;
        }

        public Criteria andLoadingdateLessThan(Date value) {
            addCriterionForJDBCDate("LoadingDate <", value, "loadingdate");
            return (Criteria) this;
        }

        public Criteria andLoadingdateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("LoadingDate <=", value, "loadingdate");
            return (Criteria) this;
        }

        public Criteria andLoadingdateIn(List<Date> values) {
            addCriterionForJDBCDate("LoadingDate in", values, "loadingdate");
            return (Criteria) this;
        }

        public Criteria andLoadingdateNotIn(List<Date> values) {
            addCriterionForJDBCDate("LoadingDate not in", values, "loadingdate");
            return (Criteria) this;
        }

        public Criteria andLoadingdateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("LoadingDate between", value1, value2, "loadingdate");
            return (Criteria) this;
        }

        public Criteria andLoadingdateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("LoadingDate not between", value1, value2, "loadingdate");
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

        public Criteria andInputdateIsNull() {
            addCriterion("InputDate is null");
            return (Criteria) this;
        }

        public Criteria andInputdateIsNotNull() {
            addCriterion("InputDate is not null");
            return (Criteria) this;
        }

        public Criteria andInputdateEqualTo(Date value) {
            addCriterionForJDBCDate("InputDate =", value, "inputdate");
            return (Criteria) this;
        }

        public Criteria andInputdateNotEqualTo(Date value) {
            addCriterionForJDBCDate("InputDate <>", value, "inputdate");
            return (Criteria) this;
        }

        public Criteria andInputdateGreaterThan(Date value) {
            addCriterionForJDBCDate("InputDate >", value, "inputdate");
            return (Criteria) this;
        }

        public Criteria andInputdateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("InputDate >=", value, "inputdate");
            return (Criteria) this;
        }

        public Criteria andInputdateLessThan(Date value) {
            addCriterionForJDBCDate("InputDate <", value, "inputdate");
            return (Criteria) this;
        }

        public Criteria andInputdateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("InputDate <=", value, "inputdate");
            return (Criteria) this;
        }

        public Criteria andInputdateIn(List<Date> values) {
            addCriterionForJDBCDate("InputDate in", values, "inputdate");
            return (Criteria) this;
        }

        public Criteria andInputdateNotIn(List<Date> values) {
            addCriterionForJDBCDate("InputDate not in", values, "inputdate");
            return (Criteria) this;
        }

        public Criteria andInputdateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("InputDate between", value1, value2, "inputdate");
            return (Criteria) this;
        }

        public Criteria andInputdateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("InputDate not between", value1, value2, "inputdate");
            return (Criteria) this;
        }

        public Criteria andGrosswtIsNull() {
            addCriterion("GrossWt is null");
            return (Criteria) this;
        }

        public Criteria andGrosswtIsNotNull() {
            addCriterion("GrossWt is not null");
            return (Criteria) this;
        }

        public Criteria andGrosswtEqualTo(BigDecimal value) {
            addCriterion("GrossWt =", value, "grosswt");
            return (Criteria) this;
        }

        public Criteria andGrosswtNotEqualTo(BigDecimal value) {
            addCriterion("GrossWt <>", value, "grosswt");
            return (Criteria) this;
        }

        public Criteria andGrosswtGreaterThan(BigDecimal value) {
            addCriterion("GrossWt >", value, "grosswt");
            return (Criteria) this;
        }

        public Criteria andGrosswtGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("GrossWt >=", value, "grosswt");
            return (Criteria) this;
        }

        public Criteria andGrosswtLessThan(BigDecimal value) {
            addCriterion("GrossWt <", value, "grosswt");
            return (Criteria) this;
        }

        public Criteria andGrosswtLessThanOrEqualTo(BigDecimal value) {
            addCriterion("GrossWt <=", value, "grosswt");
            return (Criteria) this;
        }

        public Criteria andGrosswtIn(List<BigDecimal> values) {
            addCriterion("GrossWt in", values, "grosswt");
            return (Criteria) this;
        }

        public Criteria andGrosswtNotIn(List<BigDecimal> values) {
            addCriterion("GrossWt not in", values, "grosswt");
            return (Criteria) this;
        }

        public Criteria andGrosswtBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("GrossWt between", value1, value2, "grosswt");
            return (Criteria) this;
        }

        public Criteria andGrosswtNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("GrossWt not between", value1, value2, "grosswt");
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