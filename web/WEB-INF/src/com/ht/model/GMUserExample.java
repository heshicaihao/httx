package com.ht.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GMUserExample {
    protected String orderByClause;

    protected boolean distinct;
    
    protected Integer offset;
    
    protected int rows;

    protected List<Criteria> oredCriteria;

    public GMUserExample() {
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

        public Criteria andInstkeyIsNull() {
            addCriterion("instKey is null");
            return (Criteria) this;
        }
        
        public Criteria andNameLike(String value) {
            addCriterion("ucase(gmusername) like ",value,"nameLike");
            return (Criteria) this;
        }
        
        public Criteria andCoNameLike(String value) {
            addCriterion("ucase(coname) like ",value,"conameLike");
            return (Criteria) this;
        }

        public Criteria andInstkeyIsNotNull() {
            addCriterion("instKey is not null");
            return (Criteria) this;
        }

        public Criteria andInstkeyEqualTo(String value) {
            addCriterion("instKey =", value, "instkey");
            return (Criteria) this;
        }

        public Criteria andInstkeyNotEqualTo(String value) {
            addCriterion("instKey <>", value, "instkey");
            return (Criteria) this;
        }

        public Criteria andInstkeyGreaterThan(String value) {
            addCriterion("instKey >", value, "instkey");
            return (Criteria) this;
        }

        public Criteria andInstkeyGreaterThanOrEqualTo(String value) {
            addCriterion("instKey >=", value, "instkey");
            return (Criteria) this;
        }

        public Criteria andInstkeyLessThan(String value) {
            addCriterion("instKey <", value, "instkey");
            return (Criteria) this;
        }

        public Criteria andInstkeyLessThanOrEqualTo(String value) {
            addCriterion("instKey <=", value, "instkey");
            return (Criteria) this;
        }

        public Criteria andInstkeyLike(String value) {
            addCriterion("instKey like", value, "instkey");
            return (Criteria) this;
        }

        public Criteria andInstkeyNotLike(String value) {
            addCriterion("instKey not like", value, "instkey");
            return (Criteria) this;
        }

        public Criteria andInstkeyIn(List<String> values) {
            addCriterion("instKey in", values, "instkey");
            return (Criteria) this;
        }

        public Criteria andInstkeyNotIn(List<String> values) {
            addCriterion("instKey not in", values, "instkey");
            return (Criteria) this;
        }

        public Criteria andInstkeyBetween(String value1, String value2) {
            addCriterion("instKey between", value1, value2, "instkey");
            return (Criteria) this;
        }

        public Criteria andInstkeyNotBetween(String value1, String value2) {
            addCriterion("instKey not between", value1, value2, "instkey");
            return (Criteria) this;
        }

        public Criteria andGmusernameIsNull() {
            addCriterion("gmUserName is null");
            return (Criteria) this;
        }

        public Criteria andGmusernameIsNotNull() {
            addCriterion("gmUserName is not null");
            return (Criteria) this;
        }

        public Criteria andGmusernameEqualTo(String value) {
            addCriterion("ucase(gmUserName) =", value, "gmusername");
            return (Criteria) this;
        }

        public Criteria andGmusernameNotEqualTo(String value) {
            addCriterion("gmUserName <>", value, "gmusername");
            return (Criteria) this;
        }

        public Criteria andGmusernameGreaterThan(String value) {
            addCriterion("gmUserName >", value, "gmusername");
            return (Criteria) this;
        }

        public Criteria andGmusernameGreaterThanOrEqualTo(String value) {
            addCriterion("gmUserName >=", value, "gmusername");
            return (Criteria) this;
        }

        public Criteria andGmusernameLessThan(String value) {
            addCriterion("gmUserName <", value, "gmusername");
            return (Criteria) this;
        }

        public Criteria andGmusernameLessThanOrEqualTo(String value) {
            addCriterion("gmUserName <=", value, "gmusername");
            return (Criteria) this;
        }

        public Criteria andGmusernameLike(String value) {
            addCriterion("gmUserName like", value, "gmusername");
            return (Criteria) this;
        }

        public Criteria andGmusernameNotLike(String value) {
            addCriterion("gmUserName not like", value, "gmusername");
            return (Criteria) this;
        }

        public Criteria andGmusernameIn(List<String> values) {
            addCriterion("gmUserName in", values, "gmusername");
            return (Criteria) this;
        }

        public Criteria andGmusernameNotIn(List<String> values) {
            addCriterion("gmUserName not in", values, "gmusername");
            return (Criteria) this;
        }

        public Criteria andGmusernameBetween(String value1, String value2) {
            addCriterion("gmUserName between", value1, value2, "gmusername");
            return (Criteria) this;
        }

        public Criteria andGmusernameNotBetween(String value1, String value2) {
            addCriterion("gmUserName not between", value1, value2, "gmusername");
            return (Criteria) this;
        }

        public Criteria andGmuserpwdIsNull() {
            addCriterion("gmUserPWD is null");
            return (Criteria) this;
        }

        public Criteria andGmuserpwdIsNotNull() {
            addCriterion("gmUserPWD is not null");
            return (Criteria) this;
        }

        public Criteria andGmuserpwdEqualTo(String value) {
            addCriterion("gmUserPWD =", value, "gmuserpwd");
            return (Criteria) this;
        }

        public Criteria andGmuserpwdNotEqualTo(String value) {
            addCriterion("gmUserPWD <>", value, "gmuserpwd");
            return (Criteria) this;
        }

        public Criteria andGmuserpwdGreaterThan(String value) {
            addCriterion("gmUserPWD >", value, "gmuserpwd");
            return (Criteria) this;
        }

        public Criteria andGmuserpwdGreaterThanOrEqualTo(String value) {
            addCriterion("gmUserPWD >=", value, "gmuserpwd");
            return (Criteria) this;
        }

        public Criteria andGmuserpwdLessThan(String value) {
            addCriterion("gmUserPWD <", value, "gmuserpwd");
            return (Criteria) this;
        }

        public Criteria andGmuserpwdLessThanOrEqualTo(String value) {
            addCriterion("gmUserPWD <=", value, "gmuserpwd");
            return (Criteria) this;
        }

        public Criteria andGmuserpwdLike(String value) {
            addCriterion("gmUserPWD like", value, "gmuserpwd");
            return (Criteria) this;
        }

        public Criteria andGmuserpwdNotLike(String value) {
            addCriterion("gmUserPWD not like", value, "gmuserpwd");
            return (Criteria) this;
        }

        public Criteria andGmuserpwdIn(List<String> values) {
            addCriterion("gmUserPWD in", values, "gmuserpwd");
            return (Criteria) this;
        }

        public Criteria andGmuserpwdNotIn(List<String> values) {
            addCriterion("gmUserPWD not in", values, "gmuserpwd");
            return (Criteria) this;
        }

        public Criteria andGmuserpwdBetween(String value1, String value2) {
            addCriterion("gmUserPWD between", value1, value2, "gmuserpwd");
            return (Criteria) this;
        }

        public Criteria andGmuserpwdNotBetween(String value1, String value2) {
            addCriterion("gmUserPWD not between", value1, value2, "gmuserpwd");
            return (Criteria) this;
        }

        public Criteria andConameIsNull() {
            addCriterion("coName is null");
            return (Criteria) this;
        }

        public Criteria andConameIsNotNull() {
            addCriterion("coName is not null");
            return (Criteria) this;
        }

        public Criteria andConameEqualTo(String value) {
            addCriterion("coName =", value, "coname");
            return (Criteria) this;
        }

        public Criteria andConameNotEqualTo(String value) {
            addCriterion("coName <>", value, "coname");
            return (Criteria) this;
        }

        public Criteria andConameGreaterThan(String value) {
            addCriterion("coName >", value, "coname");
            return (Criteria) this;
        }

        public Criteria andConameGreaterThanOrEqualTo(String value) {
            addCriterion("coName >=", value, "coname");
            return (Criteria) this;
        }

        public Criteria andConameLessThan(String value) {
            addCriterion("coName <", value, "coname");
            return (Criteria) this;
        }

        public Criteria andConameLessThanOrEqualTo(String value) {
            addCriterion("coName <=", value, "coname");
            return (Criteria) this;
        }

        public Criteria andConameLike(String value) {
            addCriterion("coName like", value, "coname");
            return (Criteria) this;
        }

        public Criteria andConameNotLike(String value) {
            addCriterion("coName not like", value, "coname");
            return (Criteria) this;
        }

        public Criteria andConameIn(List<String> values) {
            addCriterion("coName in", values, "coname");
            return (Criteria) this;
        }

        public Criteria andConameNotIn(List<String> values) {
            addCriterion("coName not in", values, "coname");
            return (Criteria) this;
        }

        public Criteria andConameBetween(String value1, String value2) {
            addCriterion("coName between", value1, value2, "coname");
            return (Criteria) this;
        }

        public Criteria andConameNotBetween(String value1, String value2) {
            addCriterion("coName not between", value1, value2, "coname");
            return (Criteria) this;
        }

        public Criteria andUsertypeIsNull() {
            addCriterion("userType is null");
            return (Criteria) this;
        }

        public Criteria andUsertypeIsNotNull() {
            addCriterion("userType is not null");
            return (Criteria) this;
        }

        public Criteria andUsertypeEqualTo(Short value) {
            addCriterion("userType =", value, "usertype");
            return (Criteria) this;
        }

        public Criteria andUsertypeNotEqualTo(Short value) {
            addCriterion("userType <>", value, "usertype");
            return (Criteria) this;
        }

        public Criteria andUsertypeGreaterThan(Short value) {
            addCriterion("userType >", value, "usertype");
            return (Criteria) this;
        }

        public Criteria andUsertypeGreaterThanOrEqualTo(Short value) {
            addCriterion("userType >=", value, "usertype");
            return (Criteria) this;
        }

        public Criteria andUsertypeLessThan(Short value) {
            addCriterion("userType <", value, "usertype");
            return (Criteria) this;
        }

        public Criteria andUsertypeLessThanOrEqualTo(Short value) {
            addCriterion("userType <=", value, "usertype");
            return (Criteria) this;
        }

        public Criteria andUsertypeIn(List<Short> values) {
            addCriterion("userType in", values, "usertype");
            return (Criteria) this;
        }

        public Criteria andUsertypeNotIn(List<Short> values) {
            addCriterion("userType not in", values, "usertype");
            return (Criteria) this;
        }

        public Criteria andUsertypeBetween(Short value1, Short value2) {
            addCriterion("userType between", value1, value2, "usertype");
            return (Criteria) this;
        }

        public Criteria andUsertypeNotBetween(Short value1, Short value2) {
            addCriterion("userType not between", value1, value2, "usertype");
            return (Criteria) this;
        }

        public Criteria andUserstatusIsNull() {
            addCriterion("userStatus is null");
            return (Criteria) this;
        }

        public Criteria andUserstatusIsNotNull() {
            addCriterion("userStatus is not null");
            return (Criteria) this;
        }

        public Criteria andUserstatusEqualTo(Short value) {
            addCriterion("userStatus =", value, "userstatus");
            return (Criteria) this;
        }

        public Criteria andUserstatusNotEqualTo(Short value) {
            addCriterion("userStatus <>", value, "userstatus");
            return (Criteria) this;
        }

        public Criteria andUserstatusGreaterThan(Short value) {
            addCriterion("userStatus >", value, "userstatus");
            return (Criteria) this;
        }

        public Criteria andUserstatusGreaterThanOrEqualTo(Short value) {
            addCriterion("userStatus >=", value, "userstatus");
            return (Criteria) this;
        }

        public Criteria andUserstatusLessThan(Short value) {
            addCriterion("userStatus <", value, "userstatus");
            return (Criteria) this;
        }

        public Criteria andUserstatusLessThanOrEqualTo(Short value) {
            addCriterion("userStatus <=", value, "userstatus");
            return (Criteria) this;
        }

        public Criteria andUserstatusIn(List<Short> values) {
            addCriterion("userStatus in", values, "userstatus");
            return (Criteria) this;
        }

        public Criteria andUserstatusNotIn(List<Short> values) {
            addCriterion("userStatus not in", values, "userstatus");
            return (Criteria) this;
        }

        public Criteria andUserstatusBetween(Short value1, Short value2) {
            addCriterion("userStatus between", value1, value2, "userstatus");
            return (Criteria) this;
        }

        public Criteria andUserstatusNotBetween(Short value1, Short value2) {
            addCriterion("userStatus not between", value1, value2, "userstatus");
            return (Criteria) this;
        }

        public Criteria andUserlastloginIsNull() {
            addCriterion("userLastLogin is null");
            return (Criteria) this;
        }

        public Criteria andUserlastloginIsNotNull() {
            addCriterion("userLastLogin is not null");
            return (Criteria) this;
        }

        public Criteria andUserlastloginEqualTo(Date value) {
            addCriterion("userLastLogin =", value, "userlastlogin");
            return (Criteria) this;
        }

        public Criteria andUserlastloginNotEqualTo(Date value) {
            addCriterion("userLastLogin <>", value, "userlastlogin");
            return (Criteria) this;
        }

        public Criteria andUserlastloginGreaterThan(Date value) {
            addCriterion("userLastLogin >", value, "userlastlogin");
            return (Criteria) this;
        }

        public Criteria andUserlastloginGreaterThanOrEqualTo(Date value) {
            addCriterion("userLastLogin >=", value, "userlastlogin");
            return (Criteria) this;
        }

        public Criteria andUserlastloginLessThan(Date value) {
            addCriterion("userLastLogin <", value, "userlastlogin");
            return (Criteria) this;
        }

        public Criteria andUserlastloginLessThanOrEqualTo(Date value) {
            addCriterion("userLastLogin <=", value, "userlastlogin");
            return (Criteria) this;
        }

        public Criteria andUserlastloginIn(List<Date> values) {
            addCriterion("userLastLogin in", values, "userlastlogin");
            return (Criteria) this;
        }

        public Criteria andUserlastloginNotIn(List<Date> values) {
            addCriterion("userLastLogin not in", values, "userlastlogin");
            return (Criteria) this;
        }

        public Criteria andUserlastloginBetween(Date value1, Date value2) {
            addCriterion("userLastLogin between", value1, value2, "userlastlogin");
            return (Criteria) this;
        }

        public Criteria andUserlastloginNotBetween(Date value1, Date value2) {
            addCriterion("userLastLogin not between", value1, value2, "userlastlogin");
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

	public Integer getOffset() {
		return offset;
	}

	public void setOffset(Integer offset) {
		this.offset = offset;
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}
}