package com.ht.model;

import java.util.ArrayList;
import java.util.List;

public class CompanyExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CompanyExample() {
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

        public Criteria andCompanycodeIsNull() {
            addCriterion("companyCode is null");
            return (Criteria) this;
        }

        public Criteria andCompanycodeIsNotNull() {
            addCriterion("companyCode is not null");
            return (Criteria) this;
        }

        public Criteria andCompanycodeEqualTo(String value) {
            addCriterion("companyCode =", value, "companycode");
            return (Criteria) this;
        }

        public Criteria andCompanycodeNotEqualTo(String value) {
            addCriterion("companyCode <>", value, "companycode");
            return (Criteria) this;
        }

        public Criteria andCompanycodeGreaterThan(String value) {
            addCriterion("companyCode >", value, "companycode");
            return (Criteria) this;
        }

        public Criteria andCompanycodeGreaterThanOrEqualTo(String value) {
            addCriterion("companyCode >=", value, "companycode");
            return (Criteria) this;
        }

        public Criteria andCompanycodeLessThan(String value) {
            addCriterion("companyCode <", value, "companycode");
            return (Criteria) this;
        }

        public Criteria andCompanycodeLessThanOrEqualTo(String value) {
            addCriterion("companyCode <=", value, "companycode");
            return (Criteria) this;
        }

        public Criteria andCompanycodeLike(String value) {
            addCriterion("companyCode like", value, "companycode");
            return (Criteria) this;
        }

        public Criteria andCompanycodeNotLike(String value) {
            addCriterion("companyCode not like", value, "companycode");
            return (Criteria) this;
        }

        public Criteria andCompanycodeIn(List<String> values) {
            addCriterion("companyCode in", values, "companycode");
            return (Criteria) this;
        }

        public Criteria andCompanycodeNotIn(List<String> values) {
            addCriterion("companyCode not in", values, "companycode");
            return (Criteria) this;
        }

        public Criteria andCompanycodeBetween(String value1, String value2) {
            addCriterion("companyCode between", value1, value2, "companycode");
            return (Criteria) this;
        }

        public Criteria andCompanycodeNotBetween(String value1, String value2) {
            addCriterion("companyCode not between", value1, value2, "companycode");
            return (Criteria) this;
        }

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andRegistnoIsNull() {
            addCriterion("registNo is null");
            return (Criteria) this;
        }

        public Criteria andRegistnoIsNotNull() {
            addCriterion("registNo is not null");
            return (Criteria) this;
        }

        public Criteria andRegistnoEqualTo(String value) {
            addCriterion("registNo =", value, "registno");
            return (Criteria) this;
        }

        public Criteria andRegistnoNotEqualTo(String value) {
            addCriterion("registNo <>", value, "registno");
            return (Criteria) this;
        }

        public Criteria andRegistnoGreaterThan(String value) {
            addCriterion("registNo >", value, "registno");
            return (Criteria) this;
        }

        public Criteria andRegistnoGreaterThanOrEqualTo(String value) {
            addCriterion("registNo >=", value, "registno");
            return (Criteria) this;
        }

        public Criteria andRegistnoLessThan(String value) {
            addCriterion("registNo <", value, "registno");
            return (Criteria) this;
        }

        public Criteria andRegistnoLessThanOrEqualTo(String value) {
            addCriterion("registNo <=", value, "registno");
            return (Criteria) this;
        }

        public Criteria andRegistnoLike(String value) {
            addCriterion("registNo like", value, "registno");
            return (Criteria) this;
        }

        public Criteria andRegistnoNotLike(String value) {
            addCriterion("registNo not like", value, "registno");
            return (Criteria) this;
        }

        public Criteria andRegistnoIn(List<String> values) {
            addCriterion("registNo in", values, "registno");
            return (Criteria) this;
        }

        public Criteria andRegistnoNotIn(List<String> values) {
            addCriterion("registNo not in", values, "registno");
            return (Criteria) this;
        }

        public Criteria andRegistnoBetween(String value1, String value2) {
            addCriterion("registNo between", value1, value2, "registno");
            return (Criteria) this;
        }

        public Criteria andRegistnoNotBetween(String value1, String value2) {
            addCriterion("registNo not between", value1, value2, "registno");
            return (Criteria) this;
        }

        public Criteria andInspectionregistnoIsNull() {
            addCriterion("inspectionRegistNo is null");
            return (Criteria) this;
        }

        public Criteria andInspectionregistnoIsNotNull() {
            addCriterion("inspectionRegistNo is not null");
            return (Criteria) this;
        }

        public Criteria andInspectionregistnoEqualTo(String value) {
            addCriterion("inspectionRegistNo =", value, "inspectionregistno");
            return (Criteria) this;
        }

        public Criteria andInspectionregistnoNotEqualTo(String value) {
            addCriterion("inspectionRegistNo <>", value, "inspectionregistno");
            return (Criteria) this;
        }

        public Criteria andInspectionregistnoGreaterThan(String value) {
            addCriterion("inspectionRegistNo >", value, "inspectionregistno");
            return (Criteria) this;
        }

        public Criteria andInspectionregistnoGreaterThanOrEqualTo(String value) {
            addCriterion("inspectionRegistNo >=", value, "inspectionregistno");
            return (Criteria) this;
        }

        public Criteria andInspectionregistnoLessThan(String value) {
            addCriterion("inspectionRegistNo <", value, "inspectionregistno");
            return (Criteria) this;
        }

        public Criteria andInspectionregistnoLessThanOrEqualTo(String value) {
            addCriterion("inspectionRegistNo <=", value, "inspectionregistno");
            return (Criteria) this;
        }

        public Criteria andInspectionregistnoLike(String value) {
            addCriterion("inspectionRegistNo like", value, "inspectionregistno");
            return (Criteria) this;
        }

        public Criteria andInspectionregistnoNotLike(String value) {
            addCriterion("inspectionRegistNo not like", value, "inspectionregistno");
            return (Criteria) this;
        }

        public Criteria andInspectionregistnoIn(List<String> values) {
            addCriterion("inspectionRegistNo in", values, "inspectionregistno");
            return (Criteria) this;
        }

        public Criteria andInspectionregistnoNotIn(List<String> values) {
            addCriterion("inspectionRegistNo not in", values, "inspectionregistno");
            return (Criteria) this;
        }

        public Criteria andInspectionregistnoBetween(String value1, String value2) {
            addCriterion("inspectionRegistNo between", value1, value2, "inspectionregistno");
            return (Criteria) this;
        }

        public Criteria andInspectionregistnoNotBetween(String value1, String value2) {
            addCriterion("inspectionRegistNo not between", value1, value2, "inspectionregistno");
            return (Criteria) this;
        }

        public Criteria andAddressIsNull() {
            addCriterion("address is null");
            return (Criteria) this;
        }

        public Criteria andAddressIsNotNull() {
            addCriterion("address is not null");
            return (Criteria) this;
        }

        public Criteria andAddressEqualTo(String value) {
            addCriterion("address =", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotEqualTo(String value) {
            addCriterion("address <>", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThan(String value) {
            addCriterion("address >", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThanOrEqualTo(String value) {
            addCriterion("address >=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThan(String value) {
            addCriterion("address <", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThanOrEqualTo(String value) {
            addCriterion("address <=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLike(String value) {
            addCriterion("address like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotLike(String value) {
            addCriterion("address not like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressIn(List<String> values) {
            addCriterion("address in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotIn(List<String> values) {
            addCriterion("address not in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressBetween(String value1, String value2) {
            addCriterion("address between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotBetween(String value1, String value2) {
            addCriterion("address not between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andBiztypeIsNull() {
            addCriterion("biztype is null");
            return (Criteria) this;
        }

        public Criteria andBiztypeIsNotNull() {
            addCriterion("biztype is not null");
            return (Criteria) this;
        }

        public Criteria andBiztypeEqualTo(Short value) {
            addCriterion("biztype =", value, "biztype");
            return (Criteria) this;
        }

        public Criteria andBiztypeNotEqualTo(Short value) {
            addCriterion("biztype <>", value, "biztype");
            return (Criteria) this;
        }

        public Criteria andBiztypeGreaterThan(Short value) {
            addCriterion("biztype >", value, "biztype");
            return (Criteria) this;
        }

        public Criteria andBiztypeGreaterThanOrEqualTo(Short value) {
            addCriterion("biztype >=", value, "biztype");
            return (Criteria) this;
        }

        public Criteria andBiztypeLessThan(Short value) {
            addCriterion("biztype <", value, "biztype");
            return (Criteria) this;
        }

        public Criteria andBiztypeLessThanOrEqualTo(Short value) {
            addCriterion("biztype <=", value, "biztype");
            return (Criteria) this;
        }

        public Criteria andBiztypeIn(List<Short> values) {
            addCriterion("biztype in", values, "biztype");
            return (Criteria) this;
        }

        public Criteria andBiztypeNotIn(List<Short> values) {
            addCriterion("biztype not in", values, "biztype");
            return (Criteria) this;
        }

        public Criteria andBiztypeBetween(Short value1, Short value2) {
            addCriterion("biztype between", value1, value2, "biztype");
            return (Criteria) this;
        }

        public Criteria andBiztypeNotBetween(Short value1, Short value2) {
            addCriterion("biztype not between", value1, value2, "biztype");
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