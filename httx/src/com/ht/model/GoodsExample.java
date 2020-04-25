package com.ht.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GoodsExample {
    protected String orderByClause;

    protected boolean distinct;

	protected Integer offset;
	protected Integer rows;
    protected List<Criteria> oredCriteria;

    public GoodsExample() {
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
        
        public Criteria andActiveEqualTo(Integer value) {
            addCriterion("active =", value, "active");
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
        
        public Criteria andIdIn2(List<Integer> values) {
            addCriterion("g.id in", values, "id");
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

        public Criteria andCopgnoIsNull() {
            addCriterion("CopGNo is null");
            return (Criteria) this;
        }

        public Criteria andCopgnoIsNotNull() {
            addCriterion("CopGNo is not null");
            return (Criteria) this;
        }

        public Criteria andCopgnoEqualTo(String value) {
            addCriterion("CopGNo =", value, "copgno");
            return (Criteria) this;
        }

        public Criteria andCopgnoNotEqualTo(String value) {
            addCriterion("CopGNo <>", value, "copgno");
            return (Criteria) this;
        }

        public Criteria andCopgnoGreaterThan(String value) {
            addCriterion("CopGNo >", value, "copgno");
            return (Criteria) this;
        }

        public Criteria andCopgnoGreaterThanOrEqualTo(String value) {
            addCriterion("CopGNo >=", value, "copgno");
            return (Criteria) this;
        }

        public Criteria andCopgnoLessThan(String value) {
            addCriterion("CopGNo <", value, "copgno");
            return (Criteria) this;
        }

        public Criteria andCopgnoLessThanOrEqualTo(String value) {
            addCriterion("CopGNo <=", value, "copgno");
            return (Criteria) this;
        }

        public Criteria andCopgnoLike(String value) {
            addCriterion("CopGNo like", value, "copgno");
            return (Criteria) this;
        }

        public Criteria andCopgnoNotLike(String value) {
            addCriterion("CopGNo not like", value, "copgno");
            return (Criteria) this;
        }

        public Criteria andCopgnoIn(List<String> values) {
            addCriterion("CopGNo in", values, "copgno");
            return (Criteria) this;
        }

        public Criteria andCopgnoNotIn(List<String> values) {
            addCriterion("CopGNo not in", values, "copgno");
            return (Criteria) this;
        }

        public Criteria andCopgnoBetween(String value1, String value2) {
            addCriterion("CopGNo between", value1, value2, "copgno");
            return (Criteria) this;
        }

        public Criteria andCopgnoNotBetween(String value1, String value2) {
            addCriterion("CopGNo not between", value1, value2, "copgno");
            return (Criteria) this;
        }

        public Criteria andSellidIsNull() {
            addCriterion("SellID is null");
            return (Criteria) this;
        }

        public Criteria andSellidIsNotNull() {
            addCriterion("SellID is not null");
            return (Criteria) this;
        }

        public Criteria andSellidEqualTo(String value) {
            addCriterion("SellID =", value, "sellid");
            return (Criteria) this;
        }

        public Criteria andSellidNotEqualTo(String value) {
            addCriterion("SellID <>", value, "sellid");
            return (Criteria) this;
        }

        public Criteria andSellidGreaterThan(String value) {
            addCriterion("SellID >", value, "sellid");
            return (Criteria) this;
        }

        public Criteria andSellidGreaterThanOrEqualTo(String value) {
            addCriterion("SellID >=", value, "sellid");
            return (Criteria) this;
        }

        public Criteria andSellidLessThan(String value) {
            addCriterion("SellID <", value, "sellid");
            return (Criteria) this;
        }

        public Criteria andSellidLessThanOrEqualTo(String value) {
            addCriterion("SellID <=", value, "sellid");
            return (Criteria) this;
        }

        public Criteria andSellidLike(String value) {
            addCriterion("SellID like", value, "sellid");
            return (Criteria) this;
        }

        public Criteria andSellidNotLike(String value) {
            addCriterion("SellID not like", value, "sellid");
            return (Criteria) this;
        }

        public Criteria andSellidIn(List<String> values) {
            addCriterion("SellID in", values, "sellid");
            return (Criteria) this;
        }

        public Criteria andSellidNotIn(List<String> values) {
            addCriterion("SellID not in", values, "sellid");
            return (Criteria) this;
        }

        public Criteria andSellidBetween(String value1, String value2) {
            addCriterion("SellID between", value1, value2, "sellid");
            return (Criteria) this;
        }

        public Criteria andSellidNotBetween(String value1, String value2) {
            addCriterion("SellID not between", value1, value2, "sellid");
            return (Criteria) this;
        }

        public Criteria andGoodsennameIsNull() {
            addCriterion("goodsENName is null");
            return (Criteria) this;
        }

        public Criteria andGoodsennameIsNotNull() {
            addCriterion("goodsENName is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsennameEqualTo(String value) {
            addCriterion("goodsENName =", value, "goodsenname");
            return (Criteria) this;
        }

        public Criteria andGoodsennameNotEqualTo(String value) {
            addCriterion("goodsENName <>", value, "goodsenname");
            return (Criteria) this;
        }

        public Criteria andGoodsennameGreaterThan(String value) {
            addCriterion("goodsENName >", value, "goodsenname");
            return (Criteria) this;
        }

        public Criteria andGoodsennameGreaterThanOrEqualTo(String value) {
            addCriterion("goodsENName >=", value, "goodsenname");
            return (Criteria) this;
        }

        public Criteria andGoodsennameLessThan(String value) {
            addCriterion("goodsENName <", value, "goodsenname");
            return (Criteria) this;
        }

        public Criteria andGoodsennameLessThanOrEqualTo(String value) {
            addCriterion("goodsENName <=", value, "goodsenname");
            return (Criteria) this;
        }

        public Criteria andGoodsennameLike(String value) {
            addCriterion("goodsENName like", value, "goodsenname");
            return (Criteria) this;
        }

        public Criteria andGoodsennameNotLike(String value) {
            addCriterion("goodsENName not like", value, "goodsenname");
            return (Criteria) this;
        }

        public Criteria andGoodsennameIn(List<String> values) {
            addCriterion("goodsENName in", values, "goodsenname");
            return (Criteria) this;
        }

        public Criteria andGoodsennameNotIn(List<String> values) {
            addCriterion("goodsENName not in", values, "goodsenname");
            return (Criteria) this;
        }

        public Criteria andGoodsennameBetween(String value1, String value2) {
            addCriterion("goodsENName between", value1, value2, "goodsenname");
            return (Criteria) this;
        }

        public Criteria andGoodsennameNotBetween(String value1, String value2) {
            addCriterion("goodsENName not between", value1, value2, "goodsenname");
            return (Criteria) this;
        }

        public Criteria andGnameIsNull() {
            addCriterion("GName is null");
            return (Criteria) this;
        }

        public Criteria andGnameIsNotNull() {
            addCriterion("GName is not null");
            return (Criteria) this;
        }

        public Criteria andGnameEqualTo(String value) {
            addCriterion("GName =", value, "gname");
            return (Criteria) this;
        }

        public Criteria andGnameNotEqualTo(String value) {
            addCriterion("GName <>", value, "gname");
            return (Criteria) this;
        }

        public Criteria andGnameGreaterThan(String value) {
            addCriterion("GName >", value, "gname");
            return (Criteria) this;
        }

        public Criteria andGnameGreaterThanOrEqualTo(String value) {
            addCriterion("GName >=", value, "gname");
            return (Criteria) this;
        }

        public Criteria andGnameLessThan(String value) {
            addCriterion("GName <", value, "gname");
            return (Criteria) this;
        }

        public Criteria andGnameLessThanOrEqualTo(String value) {
            addCriterion("GName <=", value, "gname");
            return (Criteria) this;
        }

        public Criteria andGnameLike(String value) {
            addCriterion("GName like", value, "gname");
            return (Criteria) this;
        }

        public Criteria andGnameNotLike(String value) {
            addCriterion("GName not like", value, "gname");
            return (Criteria) this;
        }

        public Criteria andGnameIn(List<String> values) {
            addCriterion("GName in", values, "gname");
            return (Criteria) this;
        }

        public Criteria andGnameNotIn(List<String> values) {
            addCriterion("GName not in", values, "gname");
            return (Criteria) this;
        }

        public Criteria andGnameBetween(String value1, String value2) {
            addCriterion("GName between", value1, value2, "gname");
            return (Criteria) this;
        }

        public Criteria andGnameNotBetween(String value1, String value2) {
            addCriterion("GName not between", value1, value2, "gname");
            return (Criteria) this;
        }

        public Criteria andManufactoryIsNull() {
            addCriterion("Manufactory is null");
            return (Criteria) this;
        }

        public Criteria andManufactoryIsNotNull() {
            addCriterion("Manufactory is not null");
            return (Criteria) this;
        }

        public Criteria andManufactoryEqualTo(String value) {
            addCriterion("Manufactory =", value, "manufactory");
            return (Criteria) this;
        }

        public Criteria andManufactoryNotEqualTo(String value) {
            addCriterion("Manufactory <>", value, "manufactory");
            return (Criteria) this;
        }

        public Criteria andManufactoryGreaterThan(String value) {
            addCriterion("Manufactory >", value, "manufactory");
            return (Criteria) this;
        }

        public Criteria andManufactoryGreaterThanOrEqualTo(String value) {
            addCriterion("Manufactory >=", value, "manufactory");
            return (Criteria) this;
        }

        public Criteria andManufactoryLessThan(String value) {
            addCriterion("Manufactory <", value, "manufactory");
            return (Criteria) this;
        }

        public Criteria andManufactoryLessThanOrEqualTo(String value) {
            addCriterion("Manufactory <=", value, "manufactory");
            return (Criteria) this;
        }

        public Criteria andManufactoryLike(String value) {
            addCriterion("Manufactory like", value, "manufactory");
            return (Criteria) this;
        }

        public Criteria andManufactoryNotLike(String value) {
            addCriterion("Manufactory not like", value, "manufactory");
            return (Criteria) this;
        }

        public Criteria andManufactoryIn(List<String> values) {
            addCriterion("Manufactory in", values, "manufactory");
            return (Criteria) this;
        }

        public Criteria andManufactoryNotIn(List<String> values) {
            addCriterion("Manufactory not in", values, "manufactory");
            return (Criteria) this;
        }

        public Criteria andManufactoryBetween(String value1, String value2) {
            addCriterion("Manufactory between", value1, value2, "manufactory");
            return (Criteria) this;
        }

        public Criteria andManufactoryNotBetween(String value1, String value2) {
            addCriterion("Manufactory not between", value1, value2, "manufactory");
            return (Criteria) this;
        }

        public Criteria andCountryIsNull() {
            addCriterion("country is null");
            return (Criteria) this;
        }

        public Criteria andCountryIsNotNull() {
            addCriterion("country is not null");
            return (Criteria) this;
        }

        public Criteria andCountryEqualTo(String value) {
            addCriterion("country =", value, "country");
            return (Criteria) this;
        }

        public Criteria andCountryNotEqualTo(String value) {
            addCriterion("country <>", value, "country");
            return (Criteria) this;
        }

        public Criteria andCountryGreaterThan(String value) {
            addCriterion("country >", value, "country");
            return (Criteria) this;
        }

        public Criteria andCountryGreaterThanOrEqualTo(String value) {
            addCriterion("country >=", value, "country");
            return (Criteria) this;
        }

        public Criteria andCountryLessThan(String value) {
            addCriterion("country <", value, "country");
            return (Criteria) this;
        }

        public Criteria andCountryLessThanOrEqualTo(String value) {
            addCriterion("country <=", value, "country");
            return (Criteria) this;
        }

        public Criteria andCountryLike(String value) {
            addCriterion("country like", value, "country");
            return (Criteria) this;
        }

        public Criteria andCountryNotLike(String value) {
            addCriterion("country not like", value, "country");
            return (Criteria) this;
        }

        public Criteria andCountryIn(List<String> values) {
            addCriterion("country in", values, "country");
            return (Criteria) this;
        }

        public Criteria andCountryNotIn(List<String> values) {
            addCriterion("country not in", values, "country");
            return (Criteria) this;
        }

        public Criteria andCountryBetween(String value1, String value2) {
            addCriterion("country between", value1, value2, "country");
            return (Criteria) this;
        }

        public Criteria andCountryNotBetween(String value1, String value2) {
            addCriterion("country not between", value1, value2, "country");
            return (Criteria) this;
        }

        public Criteria andHscodeIsNull() {
            addCriterion("HSCode is null");
            return (Criteria) this;
        }

        public Criteria andHscodeIsNotNull() {
            addCriterion("HSCode is not null");
            return (Criteria) this;
        }

        public Criteria andHscodeEqualTo(String value) {
            addCriterion("HSCode =", value, "hscode");
            return (Criteria) this;
        }

        public Criteria andHscodeNotEqualTo(String value) {
            addCriterion("HSCode <>", value, "hscode");
            return (Criteria) this;
        }

        public Criteria andHscodeGreaterThan(String value) {
            addCriterion("HSCode >", value, "hscode");
            return (Criteria) this;
        }

        public Criteria andHscodeGreaterThanOrEqualTo(String value) {
            addCriterion("HSCode >=", value, "hscode");
            return (Criteria) this;
        }

        public Criteria andHscodeLessThan(String value) {
            addCriterion("HSCode <", value, "hscode");
            return (Criteria) this;
        }

        public Criteria andHscodeLessThanOrEqualTo(String value) {
            addCriterion("HSCode <=", value, "hscode");
            return (Criteria) this;
        }

        public Criteria andHscodeLike(String value) {
            addCriterion("HSCode like", value, "hscode");
            return (Criteria) this;
        }

        public Criteria andHscodeNotLike(String value) {
            addCriterion("HSCode not like", value, "hscode");
            return (Criteria) this;
        }

        public Criteria andHscodeIn(List<String> values) {
            addCriterion("HSCode in", values, "hscode");
            return (Criteria) this;
        }

        public Criteria andHscodeNotIn(List<String> values) {
            addCriterion("HSCode not in", values, "hscode");
            return (Criteria) this;
        }

        public Criteria andHscodeBetween(String value1, String value2) {
            addCriterion("HSCode between", value1, value2, "hscode");
            return (Criteria) this;
        }

        public Criteria andHscodeNotBetween(String value1, String value2) {
            addCriterion("HSCode not between", value1, value2, "hscode");
            return (Criteria) this;
        }

        public Criteria andCurrIsNull() {
            addCriterion("curr is null");
            return (Criteria) this;
        }

        public Criteria andCurrIsNotNull() {
            addCriterion("curr is not null");
            return (Criteria) this;
        }

        public Criteria andCurrEqualTo(String value) {
            addCriterion("curr =", value, "curr");
            return (Criteria) this;
        }

        public Criteria andCurrNotEqualTo(String value) {
            addCriterion("curr <>", value, "curr");
            return (Criteria) this;
        }

        public Criteria andCurrGreaterThan(String value) {
            addCriterion("curr >", value, "curr");
            return (Criteria) this;
        }

        public Criteria andCurrGreaterThanOrEqualTo(String value) {
            addCriterion("curr >=", value, "curr");
            return (Criteria) this;
        }

        public Criteria andCurrLessThan(String value) {
            addCriterion("curr <", value, "curr");
            return (Criteria) this;
        }

        public Criteria andCurrLessThanOrEqualTo(String value) {
            addCriterion("curr <=", value, "curr");
            return (Criteria) this;
        }

        public Criteria andCurrLike(String value) {
            addCriterion("curr like", value, "curr");
            return (Criteria) this;
        }

        public Criteria andCurrNotLike(String value) {
            addCriterion("curr not like", value, "curr");
            return (Criteria) this;
        }

        public Criteria andCurrIn(List<String> values) {
            addCriterion("curr in", values, "curr");
            return (Criteria) this;
        }

        public Criteria andCurrNotIn(List<String> values) {
            addCriterion("curr not in", values, "curr");
            return (Criteria) this;
        }

        public Criteria andCurrBetween(String value1, String value2) {
            addCriterion("curr between", value1, value2, "curr");
            return (Criteria) this;
        }

        public Criteria andCurrNotBetween(String value1, String value2) {
            addCriterion("curr not between", value1, value2, "curr");
            return (Criteria) this;
        }

        public Criteria andRmbIsNull() {
            addCriterion("RMB is null");
            return (Criteria) this;
        }

        public Criteria andRmbIsNotNull() {
            addCriterion("RMB is not null");
            return (Criteria) this;
        }

        public Criteria andRmbEqualTo(String value) {
            addCriterion("RMB =", value, "rmb");
            return (Criteria) this;
        }

        public Criteria andRmbNotEqualTo(String value) {
            addCriterion("RMB <>", value, "rmb");
            return (Criteria) this;
        }

        public Criteria andRmbGreaterThan(String value) {
            addCriterion("RMB >", value, "rmb");
            return (Criteria) this;
        }

        public Criteria andRmbGreaterThanOrEqualTo(String value) {
            addCriterion("RMB >=", value, "rmb");
            return (Criteria) this;
        }

        public Criteria andRmbLessThan(String value) {
            addCriterion("RMB <", value, "rmb");
            return (Criteria) this;
        }

        public Criteria andRmbLessThanOrEqualTo(String value) {
            addCriterion("RMB <=", value, "rmb");
            return (Criteria) this;
        }

        public Criteria andRmbLike(String value) {
            addCriterion("RMB like", value, "rmb");
            return (Criteria) this;
        }

        public Criteria andRmbNotLike(String value) {
            addCriterion("RMB not like", value, "rmb");
            return (Criteria) this;
        }

        public Criteria andRmbIn(List<String> values) {
            addCriterion("RMB in", values, "rmb");
            return (Criteria) this;
        }

        public Criteria andRmbNotIn(List<String> values) {
            addCriterion("RMB not in", values, "rmb");
            return (Criteria) this;
        }

        public Criteria andRmbBetween(String value1, String value2) {
            addCriterion("RMB between", value1, value2, "rmb");
            return (Criteria) this;
        }

        public Criteria andRmbNotBetween(String value1, String value2) {
            addCriterion("RMB not between", value1, value2, "rmb");
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

        public Criteria andNetwtIsNull() {
            addCriterion("NetWt is null");
            return (Criteria) this;
        }

        public Criteria andNetwtIsNotNull() {
            addCriterion("NetWt is not null");
            return (Criteria) this;
        }

        public Criteria andNetwtEqualTo(BigDecimal value) {
            addCriterion("NetWt =", value, "netwt");
            return (Criteria) this;
        }

        public Criteria andNetwtNotEqualTo(BigDecimal value) {
            addCriterion("NetWt <>", value, "netwt");
            return (Criteria) this;
        }

        public Criteria andNetwtGreaterThan(BigDecimal value) {
            addCriterion("NetWt >", value, "netwt");
            return (Criteria) this;
        }

        public Criteria andNetwtGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("NetWt >=", value, "netwt");
            return (Criteria) this;
        }

        public Criteria andNetwtLessThan(BigDecimal value) {
            addCriterion("NetWt <", value, "netwt");
            return (Criteria) this;
        }

        public Criteria andNetwtLessThanOrEqualTo(BigDecimal value) {
            addCriterion("NetWt <=", value, "netwt");
            return (Criteria) this;
        }

        public Criteria andNetwtIn(List<BigDecimal> values) {
            addCriterion("NetWt in", values, "netwt");
            return (Criteria) this;
        }

        public Criteria andNetwtNotIn(List<BigDecimal> values) {
            addCriterion("NetWt not in", values, "netwt");
            return (Criteria) this;
        }

        public Criteria andNetwtBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("NetWt between", value1, value2, "netwt");
            return (Criteria) this;
        }

        public Criteria andNetwtNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("NetWt not between", value1, value2, "netwt");
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

        public Criteria andPingmingIsNull() {
            addCriterion("pingming is null");
            return (Criteria) this;
        }

        public Criteria andPingmingIsNotNull() {
            addCriterion("pingming is not null");
            return (Criteria) this;
        }

        public Criteria andPingmingEqualTo(String value) {
            addCriterion("pingming =", value, "pingming");
            return (Criteria) this;
        }

        public Criteria andPingmingNotEqualTo(String value) {
            addCriterion("pingming <>", value, "pingming");
            return (Criteria) this;
        }

        public Criteria andPingmingGreaterThan(String value) {
            addCriterion("pingming >", value, "pingming");
            return (Criteria) this;
        }

        public Criteria andPingmingGreaterThanOrEqualTo(String value) {
            addCriterion("pingming >=", value, "pingming");
            return (Criteria) this;
        }

        public Criteria andPingmingLessThan(String value) {
            addCriterion("pingming <", value, "pingming");
            return (Criteria) this;
        }

        public Criteria andPingmingLessThanOrEqualTo(String value) {
            addCriterion("pingming <=", value, "pingming");
            return (Criteria) this;
        }

        public Criteria andPingmingLike(String value) {
            addCriterion("pingming like", value, "pingming");
            return (Criteria) this;
        }

        public Criteria andPingmingNotLike(String value) {
            addCriterion("pingming not like", value, "pingming");
            return (Criteria) this;
        }

        public Criteria andPingmingIn(List<String> values) {
            addCriterion("pingming in", values, "pingming");
            return (Criteria) this;
        }

        public Criteria andPingmingNotIn(List<String> values) {
            addCriterion("pingming not in", values, "pingming");
            return (Criteria) this;
        }

        public Criteria andPingmingBetween(String value1, String value2) {
            addCriterion("pingming between", value1, value2, "pingming");
            return (Criteria) this;
        }

        public Criteria andPingmingNotBetween(String value1, String value2) {
            addCriterion("pingming not between", value1, value2, "pingming");
            return (Criteria) this;
        }

        public Criteria andBrandIsNull() {
            addCriterion("Brand is null");
            return (Criteria) this;
        }

        public Criteria andBrandIsNotNull() {
            addCriterion("Brand is not null");
            return (Criteria) this;
        }

        public Criteria andBrandEqualTo(String value) {
            addCriterion("Brand =", value, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandNotEqualTo(String value) {
            addCriterion("Brand <>", value, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandGreaterThan(String value) {
            addCriterion("Brand >", value, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandGreaterThanOrEqualTo(String value) {
            addCriterion("Brand >=", value, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandLessThan(String value) {
            addCriterion("Brand <", value, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandLessThanOrEqualTo(String value) {
            addCriterion("Brand <=", value, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandLike(String value) {
            addCriterion("Brand like", value, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandNotLike(String value) {
            addCriterion("Brand not like", value, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandIn(List<String> values) {
            addCriterion("Brand in", values, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandNotIn(List<String> values) {
            addCriterion("Brand not in", values, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandBetween(String value1, String value2) {
            addCriterion("Brand between", value1, value2, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandNotBetween(String value1, String value2) {
            addCriterion("Brand not between", value1, value2, "brand");
            return (Criteria) this;
        }

        public Criteria andYongtuIsNull() {
            addCriterion("yongtu is null");
            return (Criteria) this;
        }

        public Criteria andYongtuIsNotNull() {
            addCriterion("yongtu is not null");
            return (Criteria) this;
        }

        public Criteria andYongtuEqualTo(String value) {
            addCriterion("yongtu =", value, "yongtu");
            return (Criteria) this;
        }

        public Criteria andYongtuNotEqualTo(String value) {
            addCriterion("yongtu <>", value, "yongtu");
            return (Criteria) this;
        }

        public Criteria andYongtuGreaterThan(String value) {
            addCriterion("yongtu >", value, "yongtu");
            return (Criteria) this;
        }

        public Criteria andYongtuGreaterThanOrEqualTo(String value) {
            addCriterion("yongtu >=", value, "yongtu");
            return (Criteria) this;
        }

        public Criteria andYongtuLessThan(String value) {
            addCriterion("yongtu <", value, "yongtu");
            return (Criteria) this;
        }

        public Criteria andYongtuLessThanOrEqualTo(String value) {
            addCriterion("yongtu <=", value, "yongtu");
            return (Criteria) this;
        }

        public Criteria andYongtuLike(String value) {
            addCriterion("yongtu like", value, "yongtu");
            return (Criteria) this;
        }

        public Criteria andYongtuNotLike(String value) {
            addCriterion("yongtu not like", value, "yongtu");
            return (Criteria) this;
        }

        public Criteria andYongtuIn(List<String> values) {
            addCriterion("yongtu in", values, "yongtu");
            return (Criteria) this;
        }

        public Criteria andYongtuNotIn(List<String> values) {
            addCriterion("yongtu not in", values, "yongtu");
            return (Criteria) this;
        }

        public Criteria andYongtuBetween(String value1, String value2) {
            addCriterion("yongtu between", value1, value2, "yongtu");
            return (Criteria) this;
        }

        public Criteria andYongtuNotBetween(String value1, String value2) {
            addCriterion("yongtu not between", value1, value2, "yongtu");
            return (Criteria) this;
        }

        public Criteria andGmodelIsNull() {
            addCriterion("GModel is null");
            return (Criteria) this;
        }

        public Criteria andGmodelIsNotNull() {
            addCriterion("GModel is not null");
            return (Criteria) this;
        }

        public Criteria andGmodelEqualTo(String value) {
            addCriterion("GModel =", value, "gmodel");
            return (Criteria) this;
        }

        public Criteria andGmodelNotEqualTo(String value) {
            addCriterion("GModel <>", value, "gmodel");
            return (Criteria) this;
        }

        public Criteria andGmodelGreaterThan(String value) {
            addCriterion("GModel >", value, "gmodel");
            return (Criteria) this;
        }

        public Criteria andGmodelGreaterThanOrEqualTo(String value) {
            addCriterion("GModel >=", value, "gmodel");
            return (Criteria) this;
        }

        public Criteria andGmodelLessThan(String value) {
            addCriterion("GModel <", value, "gmodel");
            return (Criteria) this;
        }

        public Criteria andGmodelLessThanOrEqualTo(String value) {
            addCriterion("GModel <=", value, "gmodel");
            return (Criteria) this;
        }

        public Criteria andGmodelLike(String value) {
            addCriterion("GModel like", value, "gmodel");
            return (Criteria) this;
        }

        public Criteria andGmodelNotLike(String value) {
            addCriterion("GModel not like", value, "gmodel");
            return (Criteria) this;
        }

        public Criteria andGmodelIn(List<String> values) {
            addCriterion("GModel in", values, "gmodel");
            return (Criteria) this;
        }

        public Criteria andGmodelNotIn(List<String> values) {
            addCriterion("GModel not in", values, "gmodel");
            return (Criteria) this;
        }

        public Criteria andGmodelBetween(String value1, String value2) {
            addCriterion("GModel between", value1, value2, "gmodel");
            return (Criteria) this;
        }

        public Criteria andGmodelNotBetween(String value1, String value2) {
            addCriterion("GModel not between", value1, value2, "gmodel");
            return (Criteria) this;
        }

        public Criteria andChengfenIsNull() {
            addCriterion("chengfen is null");
            return (Criteria) this;
        }

        public Criteria andChengfenIsNotNull() {
            addCriterion("chengfen is not null");
            return (Criteria) this;
        }

        public Criteria andChengfenEqualTo(String value) {
            addCriterion("chengfen =", value, "chengfen");
            return (Criteria) this;
        }

        public Criteria andChengfenNotEqualTo(String value) {
            addCriterion("chengfen <>", value, "chengfen");
            return (Criteria) this;
        }

        public Criteria andChengfenGreaterThan(String value) {
            addCriterion("chengfen >", value, "chengfen");
            return (Criteria) this;
        }

        public Criteria andChengfenGreaterThanOrEqualTo(String value) {
            addCriterion("chengfen >=", value, "chengfen");
            return (Criteria) this;
        }

        public Criteria andChengfenLessThan(String value) {
            addCriterion("chengfen <", value, "chengfen");
            return (Criteria) this;
        }

        public Criteria andChengfenLessThanOrEqualTo(String value) {
            addCriterion("chengfen <=", value, "chengfen");
            return (Criteria) this;
        }

        public Criteria andChengfenLike(String value) {
            addCriterion("chengfen like", value, "chengfen");
            return (Criteria) this;
        }

        public Criteria andChengfenNotLike(String value) {
            addCriterion("chengfen not like", value, "chengfen");
            return (Criteria) this;
        }

        public Criteria andChengfenIn(List<String> values) {
            addCriterion("chengfen in", values, "chengfen");
            return (Criteria) this;
        }

        public Criteria andChengfenNotIn(List<String> values) {
            addCriterion("chengfen not in", values, "chengfen");
            return (Criteria) this;
        }

        public Criteria andChengfenBetween(String value1, String value2) {
            addCriterion("chengfen between", value1, value2, "chengfen");
            return (Criteria) this;
        }

        public Criteria andChengfenNotBetween(String value1, String value2) {
            addCriterion("chengfen not between", value1, value2, "chengfen");
            return (Criteria) this;
        }

        public Criteria andNetworksellnameIsNull() {
            addCriterion("NetworkSellName is null");
            return (Criteria) this;
        }

        public Criteria andNetworksellnameIsNotNull() {
            addCriterion("NetworkSellName is not null");
            return (Criteria) this;
        }

        public Criteria andNetworksellnameEqualTo(String value) {
            addCriterion("NetworkSellName =", value, "networksellname");
            return (Criteria) this;
        }

        public Criteria andNetworksellnameNotEqualTo(String value) {
            addCriterion("NetworkSellName <>", value, "networksellname");
            return (Criteria) this;
        }

        public Criteria andNetworksellnameGreaterThan(String value) {
            addCriterion("NetworkSellName >", value, "networksellname");
            return (Criteria) this;
        }

        public Criteria andNetworksellnameGreaterThanOrEqualTo(String value) {
            addCriterion("NetworkSellName >=", value, "networksellname");
            return (Criteria) this;
        }

        public Criteria andNetworksellnameLessThan(String value) {
            addCriterion("NetworkSellName <", value, "networksellname");
            return (Criteria) this;
        }

        public Criteria andNetworksellnameLessThanOrEqualTo(String value) {
            addCriterion("NetworkSellName <=", value, "networksellname");
            return (Criteria) this;
        }

        public Criteria andNetworksellnameLike(String value) {
            addCriterion("NetworkSellName like", value, "networksellname");
            return (Criteria) this;
        }

        public Criteria andNetworksellnameNotLike(String value) {
            addCriterion("NetworkSellName not like", value, "networksellname");
            return (Criteria) this;
        }

        public Criteria andNetworksellnameIn(List<String> values) {
            addCriterion("NetworkSellName in", values, "networksellname");
            return (Criteria) this;
        }

        public Criteria andNetworksellnameNotIn(List<String> values) {
            addCriterion("NetworkSellName not in", values, "networksellname");
            return (Criteria) this;
        }

        public Criteria andNetworksellnameBetween(String value1, String value2) {
            addCriterion("NetworkSellName between", value1, value2, "networksellname");
            return (Criteria) this;
        }

        public Criteria andNetworksellnameNotBetween(String value1, String value2) {
            addCriterion("NetworkSellName not between", value1, value2, "networksellname");
            return (Criteria) this;
        }

        public Criteria andHyperlinkIsNull() {
            addCriterion("HyperLink is null");
            return (Criteria) this;
        }

        public Criteria andHyperlinkIsNotNull() {
            addCriterion("HyperLink is not null");
            return (Criteria) this;
        }

        public Criteria andHyperlinkEqualTo(String value) {
            addCriterion("HyperLink =", value, "hyperlink");
            return (Criteria) this;
        }

        public Criteria andHyperlinkNotEqualTo(String value) {
            addCriterion("HyperLink <>", value, "hyperlink");
            return (Criteria) this;
        }

        public Criteria andHyperlinkGreaterThan(String value) {
            addCriterion("HyperLink >", value, "hyperlink");
            return (Criteria) this;
        }

        public Criteria andHyperlinkGreaterThanOrEqualTo(String value) {
            addCriterion("HyperLink >=", value, "hyperlink");
            return (Criteria) this;
        }

        public Criteria andHyperlinkLessThan(String value) {
            addCriterion("HyperLink <", value, "hyperlink");
            return (Criteria) this;
        }

        public Criteria andHyperlinkLessThanOrEqualTo(String value) {
            addCriterion("HyperLink <=", value, "hyperlink");
            return (Criteria) this;
        }

        public Criteria andHyperlinkLike(String value) {
            addCriterion("HyperLink like", value, "hyperlink");
            return (Criteria) this;
        }

        public Criteria andHyperlinkNotLike(String value) {
            addCriterion("HyperLink not like", value, "hyperlink");
            return (Criteria) this;
        }

        public Criteria andHyperlinkIn(List<String> values) {
            addCriterion("HyperLink in", values, "hyperlink");
            return (Criteria) this;
        }

        public Criteria andHyperlinkNotIn(List<String> values) {
            addCriterion("HyperLink not in", values, "hyperlink");
            return (Criteria) this;
        }

        public Criteria andHyperlinkBetween(String value1, String value2) {
            addCriterion("HyperLink between", value1, value2, "hyperlink");
            return (Criteria) this;
        }

        public Criteria andHyperlinkNotBetween(String value1, String value2) {
            addCriterion("HyperLink not between", value1, value2, "hyperlink");
            return (Criteria) this;
        }

        public Criteria andBatchidIsNull() {
            addCriterion("batchId is null");
            return (Criteria) this;
        }

        public Criteria andBatchidIsNotNull() {
            addCriterion("batchId is not null");
            return (Criteria) this;
        }

        public Criteria andBatchidEqualTo(String value) {
            addCriterion("batchId =", value, "batchid");
            return (Criteria) this;
        }

        public Criteria andBatchidNotEqualTo(String value) {
            addCriterion("batchId <>", value, "batchid");
            return (Criteria) this;
        }

        public Criteria andBatchidGreaterThan(String value) {
            addCriterion("batchId >", value, "batchid");
            return (Criteria) this;
        }

        public Criteria andBatchidGreaterThanOrEqualTo(String value) {
            addCriterion("batchId >=", value, "batchid");
            return (Criteria) this;
        }

        public Criteria andBatchidLessThan(String value) {
            addCriterion("batchId <", value, "batchid");
            return (Criteria) this;
        }

        public Criteria andBatchidLessThanOrEqualTo(String value) {
            addCriterion("batchId <=", value, "batchid");
            return (Criteria) this;
        }

        public Criteria andBatchidLike(String value) {
            addCriterion("batchId like", value, "batchid");
            return (Criteria) this;
        }

        public Criteria andBatchidNotLike(String value) {
            addCriterion("batchId not like", value, "batchid");
            return (Criteria) this;
        }

        public Criteria andBatchidIn(List<String> values) {
            addCriterion("batchId in", values, "batchid");
            return (Criteria) this;
        }

        public Criteria andBatchidNotIn(List<String> values) {
            addCriterion("batchId not in", values, "batchid");
            return (Criteria) this;
        }

        public Criteria andBatchidBetween(String value1, String value2) {
            addCriterion("batchId between", value1, value2, "batchid");
            return (Criteria) this;
        }

        public Criteria andBatchidNotBetween(String value1, String value2) {
            addCriterion("batchId not between", value1, value2, "batchid");
            return (Criteria) this;
        }

        public Criteria andUnitIsNull() {
            addCriterion("unit is null");
            return (Criteria) this;
        }

        public Criteria andUnitIsNotNull() {
            addCriterion("unit is not null");
            return (Criteria) this;
        }

        public Criteria andUnitEqualTo(String value) {
            addCriterion("unit =", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitNotEqualTo(String value) {
            addCriterion("unit <>", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitGreaterThan(String value) {
            addCriterion("unit >", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitGreaterThanOrEqualTo(String value) {
            addCriterion("unit >=", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitLessThan(String value) {
            addCriterion("unit <", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitLessThanOrEqualTo(String value) {
            addCriterion("unit <=", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitLike(String value) {
            addCriterion("unit like", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitNotLike(String value) {
            addCriterion("unit not like", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitIn(List<String> values) {
            addCriterion("unit in", values, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitNotIn(List<String> values) {
            addCriterion("unit not in", values, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitBetween(String value1, String value2) {
            addCriterion("unit between", value1, value2, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitNotBetween(String value1, String value2) {
            addCriterion("unit not between", value1, value2, "unit");
            return (Criteria) this;
        }

        public Criteria andPosttariffcodeIsNull() {
            addCriterion("PostTariffCode is null");
            return (Criteria) this;
        }

        public Criteria andPosttariffcodeIsNotNull() {
            addCriterion("PostTariffCode is not null");
            return (Criteria) this;
        }

        public Criteria andPosttariffcodeEqualTo(String value) {
            addCriterion("PostTariffCode =", value, "posttariffcode");
            return (Criteria) this;
        }

        public Criteria andPosttariffcodeNotEqualTo(String value) {
            addCriterion("PostTariffCode <>", value, "posttariffcode");
            return (Criteria) this;
        }

        public Criteria andPosttariffcodeGreaterThan(String value) {
            addCriterion("PostTariffCode >", value, "posttariffcode");
            return (Criteria) this;
        }

        public Criteria andPosttariffcodeGreaterThanOrEqualTo(String value) {
            addCriterion("PostTariffCode >=", value, "posttariffcode");
            return (Criteria) this;
        }

        public Criteria andPosttariffcodeLessThan(String value) {
            addCriterion("PostTariffCode <", value, "posttariffcode");
            return (Criteria) this;
        }

        public Criteria andPosttariffcodeLessThanOrEqualTo(String value) {
            addCriterion("PostTariffCode <=", value, "posttariffcode");
            return (Criteria) this;
        }

        public Criteria andPosttariffcodeLike(String value) {
            addCriterion("PostTariffCode like", value, "posttariffcode");
            return (Criteria) this;
        }

        public Criteria andPosttariffcodeNotLike(String value) {
            addCriterion("PostTariffCode not like", value, "posttariffcode");
            return (Criteria) this;
        }

        public Criteria andPosttariffcodeIn(List<String> values) {
            addCriterion("PostTariffCode in", values, "posttariffcode");
            return (Criteria) this;
        }

        public Criteria andPosttariffcodeNotIn(List<String> values) {
            addCriterion("PostTariffCode not in", values, "posttariffcode");
            return (Criteria) this;
        }

        public Criteria andPosttariffcodeBetween(String value1, String value2) {
            addCriterion("PostTariffCode between", value1, value2, "posttariffcode");
            return (Criteria) this;
        }

        public Criteria andPosttariffcodeNotBetween(String value1, String value2) {
            addCriterion("PostTariffCode not between", value1, value2, "posttariffcode");
            return (Criteria) this;
        }

        public Criteria andPosttariffnameIsNull() {
            addCriterion("PostTariffName is null");
            return (Criteria) this;
        }

        public Criteria andPosttariffnameIsNotNull() {
            addCriterion("PostTariffName is not null");
            return (Criteria) this;
        }

        public Criteria andPosttariffnameEqualTo(String value) {
            addCriterion("PostTariffName =", value, "posttariffname");
            return (Criteria) this;
        }

        public Criteria andPosttariffnameNotEqualTo(String value) {
            addCriterion("PostTariffName <>", value, "posttariffname");
            return (Criteria) this;
        }

        public Criteria andPosttariffnameGreaterThan(String value) {
            addCriterion("PostTariffName >", value, "posttariffname");
            return (Criteria) this;
        }

        public Criteria andPosttariffnameGreaterThanOrEqualTo(String value) {
            addCriterion("PostTariffName >=", value, "posttariffname");
            return (Criteria) this;
        }

        public Criteria andPosttariffnameLessThan(String value) {
            addCriterion("PostTariffName <", value, "posttariffname");
            return (Criteria) this;
        }

        public Criteria andPosttariffnameLessThanOrEqualTo(String value) {
            addCriterion("PostTariffName <=", value, "posttariffname");
            return (Criteria) this;
        }

        public Criteria andPosttariffnameLike(String value) {
            addCriterion("PostTariffName like", value, "posttariffname");
            return (Criteria) this;
        }

        public Criteria andPosttariffnameNotLike(String value) {
            addCriterion("PostTariffName not like", value, "posttariffname");
            return (Criteria) this;
        }

        public Criteria andPosttariffnameIn(List<String> values) {
            addCriterion("PostTariffName in", values, "posttariffname");
            return (Criteria) this;
        }

        public Criteria andPosttariffnameNotIn(List<String> values) {
            addCriterion("PostTariffName not in", values, "posttariffname");
            return (Criteria) this;
        }

        public Criteria andPosttariffnameBetween(String value1, String value2) {
            addCriterion("PostTariffName between", value1, value2, "posttariffname");
            return (Criteria) this;
        }

        public Criteria andPosttariffnameNotBetween(String value1, String value2) {
            addCriterion("PostTariffName not between", value1, value2, "posttariffname");
            return (Criteria) this;
        }

        public Criteria andEportgoodsnoIsNull() {
            addCriterion("EportGoodsNo is null");
            return (Criteria) this;
        }

        public Criteria andEportgoodsnoIsNotNull() {
            addCriterion("EportGoodsNo is not null");
            return (Criteria) this;
        }

        public Criteria andEportgoodsnoEqualTo(String value) {
            addCriterion("EportGoodsNo =", value, "eportgoodsno");
            return (Criteria) this;
        }

        public Criteria andEportgoodsnoNotEqualTo(String value) {
            addCriterion("EportGoodsNo <>", value, "eportgoodsno");
            return (Criteria) this;
        }

        public Criteria andEportgoodsnoGreaterThan(String value) {
            addCriterion("EportGoodsNo >", value, "eportgoodsno");
            return (Criteria) this;
        }

        public Criteria andEportgoodsnoGreaterThanOrEqualTo(String value) {
            addCriterion("EportGoodsNo >=", value, "eportgoodsno");
            return (Criteria) this;
        }

        public Criteria andEportgoodsnoLessThan(String value) {
            addCriterion("EportGoodsNo <", value, "eportgoodsno");
            return (Criteria) this;
        }

        public Criteria andEportgoodsnoLessThanOrEqualTo(String value) {
            addCriterion("EportGoodsNo <=", value, "eportgoodsno");
            return (Criteria) this;
        }

        public Criteria andEportgoodsnoLike(String value) {
            addCriterion("EportGoodsNo like", value, "eportgoodsno");
            return (Criteria) this;
        }

        public Criteria andEportgoodsnoNotLike(String value) {
            addCriterion("EportGoodsNo not like", value, "eportgoodsno");
            return (Criteria) this;
        }

        public Criteria andEportgoodsnoIn(List<String> values) {
            addCriterion("EportGoodsNo in", values, "eportgoodsno");
            return (Criteria) this;
        }

        public Criteria andEportgoodsnoNotIn(List<String> values) {
            addCriterion("EportGoodsNo not in", values, "eportgoodsno");
            return (Criteria) this;
        }

        public Criteria andEportgoodsnoBetween(String value1, String value2) {
            addCriterion("EportGoodsNo between", value1, value2, "eportgoodsno");
            return (Criteria) this;
        }

        public Criteria andEportgoodsnoNotBetween(String value1, String value2) {
            addCriterion("EportGoodsNo not between", value1, value2, "eportgoodsno");
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

        public Criteria andAppdateIsNull() {
            addCriterion("appDate is null");
            return (Criteria) this;
        }

        public Criteria andAppdateIsNotNull() {
            addCriterion("appDate is not null");
            return (Criteria) this;
        }

        public Criteria andAppdateEqualTo(Date value) {
            addCriterion("appDate =", value, "appdate");
            return (Criteria) this;
        }

        public Criteria andAppdateNotEqualTo(Date value) {
            addCriterion("appDate <>", value, "appdate");
            return (Criteria) this;
        }

        public Criteria andAppdateGreaterThan(Date value) {
            addCriterion("appDate >", value, "appdate");
            return (Criteria) this;
        }

        public Criteria andAppdateGreaterThanOrEqualTo(Date value) {
            addCriterion("appDate >=", value, "appdate");
            return (Criteria) this;
        }

        public Criteria andAppdateLessThan(Date value) {
            addCriterion("appDate <", value, "appdate");
            return (Criteria) this;
        }

        public Criteria andAppdateLessThanOrEqualTo(Date value) {
            addCriterion("appDate <=", value, "appdate");
            return (Criteria) this;
        }

        public Criteria andAppdateIn(List<Date> values) {
            addCriterion("appDate in", values, "appdate");
            return (Criteria) this;
        }

        public Criteria andAppdateNotIn(List<Date> values) {
            addCriterion("appDate not in", values, "appdate");
            return (Criteria) this;
        }

        public Criteria andAppdateBetween2(Date value1, Date value2) {
            addCriterion("g.appDate between", value1, value2, "appdate");
            return (Criteria) this;
        }

        public Criteria andAppdateNotBetween(Date value1, Date value2) {
            addCriterion("appDate not between", value1, value2, "appdate");
            return (Criteria) this;
        }

        public Criteria andAppenddateIsNull() {
            addCriterion("appEndDate is null");
            return (Criteria) this;
        }

        public Criteria andAppenddateIsNotNull() {
            addCriterion("appEndDate is not null");
            return (Criteria) this;
        }

        public Criteria andAppenddateEqualTo(Date value) {
            addCriterion("appEndDate =", value, "appenddate");
            return (Criteria) this;
        }

        public Criteria andAppenddateNotEqualTo(Date value) {
            addCriterion("appEndDate <>", value, "appenddate");
            return (Criteria) this;
        }

        public Criteria andAppenddateGreaterThan(Date value) {
            addCriterion("appEndDate >", value, "appenddate");
            return (Criteria) this;
        }

        public Criteria andAppenddateGreaterThanOrEqualTo(Date value) {
            addCriterion("appEndDate >=", value, "appenddate");
            return (Criteria) this;
        }

        public Criteria andAppenddateLessThan(Date value) {
            addCriterion("appEndDate <", value, "appenddate");
            return (Criteria) this;
        }

        public Criteria andAppenddateLessThanOrEqualTo(Date value) {
            addCriterion("appEndDate <=", value, "appenddate");
            return (Criteria) this;
        }

        public Criteria andAppenddateIn(List<Date> values) {
            addCriterion("appEndDate in", values, "appenddate");
            return (Criteria) this;
        }

        public Criteria andAppenddateNotIn(List<Date> values) {
            addCriterion("appEndDate not in", values, "appenddate");
            return (Criteria) this;
        }

        public Criteria andAppenddateBetween(Date value1, Date value2) {
            addCriterion("appEndDate between", value1, value2, "appenddate");
            return (Criteria) this;
        }

        public Criteria andAppenddateNotBetween(Date value1, Date value2) {
            addCriterion("appEndDate not between", value1, value2, "appenddate");
            return (Criteria) this;
        }

        public Criteria andCreateuseridIsNull() {
            addCriterion("createUserId is null");
            return (Criteria) this;
        }

        public Criteria andCreateuseridIsNotNull() {
            addCriterion("createUserId is not null");
            return (Criteria) this;
        }

        public Criteria andCreateuseridEqualTo(Integer value) {
            addCriterion("createUserId =", value, "createuserid");
            return (Criteria) this;
        }

        public Criteria andCreateuseridNotEqualTo(Integer value) {
            addCriterion("createUserId <>", value, "createuserid");
            return (Criteria) this;
        }

        public Criteria andCreateuseridGreaterThan(Integer value) {
            addCriterion("createUserId >", value, "createuserid");
            return (Criteria) this;
        }

        public Criteria andCreateuseridGreaterThanOrEqualTo(Integer value) {
            addCriterion("createUserId >=", value, "createuserid");
            return (Criteria) this;
        }

        public Criteria andCreateuseridLessThan(Integer value) {
            addCriterion("createUserId <", value, "createuserid");
            return (Criteria) this;
        }

        public Criteria andCreateuseridLessThanOrEqualTo(Integer value) {
            addCriterion("createUserId <=", value, "createuserid");
            return (Criteria) this;
        }

        public Criteria andCreateuseridIn(List<Integer> values) {
            addCriterion("createUserId in", values, "createuserid");
            return (Criteria) this;
        }

        public Criteria andCreateuseridNotIn(List<Integer> values) {
            addCriterion("createUserId not in", values, "createuserid");
            return (Criteria) this;
        }

        public Criteria andCreateuseridBetween(Integer value1, Integer value2) {
            addCriterion("createUserId between", value1, value2, "createuserid");
            return (Criteria) this;
        }

        public Criteria andCreateuseridNotBetween(Integer value1, Integer value2) {
            addCriterion("createUserId not between", value1, value2, "createuserid");
            return (Criteria) this;
        }

        public Criteria andLastupdateuseridIsNull() {
            addCriterion("lastupdateuserid is null");
            return (Criteria) this;
        }

        public Criteria andLastupdateuseridIsNotNull() {
            addCriterion("lastupdateuserid is not null");
            return (Criteria) this;
        }

        public Criteria andLastupdateuseridEqualTo(Integer value) {
            addCriterion("lastupdateuserid =", value, "lastupdateuserid");
            return (Criteria) this;
        }

        public Criteria andLastupdateuseridNotEqualTo(Integer value) {
            addCriterion("lastupdateuserid <>", value, "lastupdateuserid");
            return (Criteria) this;
        }

        public Criteria andLastupdateuseridGreaterThan(Integer value) {
            addCriterion("lastupdateuserid >", value, "lastupdateuserid");
            return (Criteria) this;
        }

        public Criteria andLastupdateuseridGreaterThanOrEqualTo(Integer value) {
            addCriterion("lastupdateuserid >=", value, "lastupdateuserid");
            return (Criteria) this;
        }

        public Criteria andLastupdateuseridLessThan(Integer value) {
            addCriterion("lastupdateuserid <", value, "lastupdateuserid");
            return (Criteria) this;
        }

        public Criteria andLastupdateuseridLessThanOrEqualTo(Integer value) {
            addCriterion("lastupdateuserid <=", value, "lastupdateuserid");
            return (Criteria) this;
        }

        public Criteria andLastupdateuseridIn(List<Integer> values) {
            addCriterion("lastupdateuserid in", values, "lastupdateuserid");
            return (Criteria) this;
        }

        public Criteria andLastupdateuseridNotIn(List<Integer> values) {
            addCriterion("lastupdateuserid not in", values, "lastupdateuserid");
            return (Criteria) this;
        }

        public Criteria andLastupdateuseridBetween(Integer value1, Integer value2) {
            addCriterion("lastupdateuserid between", value1, value2, "lastupdateuserid");
            return (Criteria) this;
        }

        public Criteria andLastupdateuseridNotBetween(Integer value1, Integer value2) {
            addCriterion("lastupdateuserid not between", value1, value2, "lastupdateuserid");
            return (Criteria) this;
        }

        public Criteria andLastupdatetimeIsNull() {
            addCriterion("lastUpdateTime is null");
            return (Criteria) this;
        }

        public Criteria andLastupdatetimeIsNotNull() {
            addCriterion("lastUpdateTime is not null");
            return (Criteria) this;
        }

        public Criteria andLastupdatetimeEqualTo(Date value) {
            addCriterion("lastUpdateTime =", value, "lastupdatetime");
            return (Criteria) this;
        }

        public Criteria andLastupdatetimeNotEqualTo(Date value) {
            addCriterion("lastUpdateTime <>", value, "lastupdatetime");
            return (Criteria) this;
        }

        public Criteria andLastupdatetimeGreaterThan(Date value) {
            addCriterion("lastUpdateTime >", value, "lastupdatetime");
            return (Criteria) this;
        }

        public Criteria andLastupdatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("lastUpdateTime >=", value, "lastupdatetime");
            return (Criteria) this;
        }

        public Criteria andLastupdatetimeLessThan(Date value) {
            addCriterion("lastUpdateTime <", value, "lastupdatetime");
            return (Criteria) this;
        }

        public Criteria andLastupdatetimeLessThanOrEqualTo(Date value) {
            addCriterion("lastUpdateTime <=", value, "lastupdatetime");
            return (Criteria) this;
        }

        public Criteria andLastupdatetimeIn(List<Date> values) {
            addCriterion("lastUpdateTime in", values, "lastupdatetime");
            return (Criteria) this;
        }

        public Criteria andLastupdatetimeNotIn(List<Date> values) {
            addCriterion("lastUpdateTime not in", values, "lastupdatetime");
            return (Criteria) this;
        }

        public Criteria andLastupdatetimeBetween(Date value1, Date value2) {
            addCriterion("lastUpdateTime between", value1, value2, "lastupdatetime");
            return (Criteria) this;
        }

        public Criteria andLastupdatetimeNotBetween(Date value1, Date value2) {
            addCriterion("lastUpdateTime not between", value1, value2, "lastupdatetime");
            return (Criteria) this;
        }

        public Criteria andGdescIsNull() {
            addCriterion("gdesc is null");
            return (Criteria) this;
        }

        public Criteria andGdescIsNotNull() {
            addCriterion("gdesc is not null");
            return (Criteria) this;
        }

        public Criteria andGdescEqualTo(String value) {
            addCriterion("gdesc =", value, "gdesc");
            return (Criteria) this;
        }

        public Criteria andGdescNotEqualTo(String value) {
            addCriterion("gdesc <>", value, "gdesc");
            return (Criteria) this;
        }

        public Criteria andGdescGreaterThan(String value) {
            addCriterion("gdesc >", value, "gdesc");
            return (Criteria) this;
        }

        public Criteria andGdescGreaterThanOrEqualTo(String value) {
            addCriterion("gdesc >=", value, "gdesc");
            return (Criteria) this;
        }

        public Criteria andGdescLessThan(String value) {
            addCriterion("gdesc <", value, "gdesc");
            return (Criteria) this;
        }

        public Criteria andGdescLessThanOrEqualTo(String value) {
            addCriterion("gdesc <=", value, "gdesc");
            return (Criteria) this;
        }

        public Criteria andGdescLike(String value) {
            addCriterion("gdesc like", value, "gdesc");
            return (Criteria) this;
        }

        public Criteria andGdescNotLike(String value) {
            addCriterion("gdesc not like", value, "gdesc");
            return (Criteria) this;
        }

        public Criteria andGdescIn(List<String> values) {
            addCriterion("gdesc in", values, "gdesc");
            return (Criteria) this;
        }

        public Criteria andGdescNotIn(List<String> values) {
            addCriterion("gdesc not in", values, "gdesc");
            return (Criteria) this;
        }

        public Criteria andGdescBetween(String value1, String value2) {
            addCriterion("gdesc between", value1, value2, "gdesc");
            return (Criteria) this;
        }

        public Criteria andGdescNotBetween(String value1, String value2) {
            addCriterion("gdesc not between", value1, value2, "gdesc");
            return (Criteria) this;
        }

        public Criteria andSellrmbIsNull() {
            addCriterion("sellRmb is null");
            return (Criteria) this;
        }

        public Criteria andSellrmbIsNotNull() {
            addCriterion("sellRmb is not null");
            return (Criteria) this;
        }

        public Criteria andSellrmbEqualTo(BigDecimal value) {
            addCriterion("sellRmb =", value, "sellrmb");
            return (Criteria) this;
        }

        public Criteria andSellrmbNotEqualTo(BigDecimal value) {
            addCriterion("sellRmb <>", value, "sellrmb");
            return (Criteria) this;
        }

        public Criteria andSellrmbGreaterThan(BigDecimal value) {
            addCriterion("sellRmb >", value, "sellrmb");
            return (Criteria) this;
        }

        public Criteria andSellrmbGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("sellRmb >=", value, "sellrmb");
            return (Criteria) this;
        }

        public Criteria andSellrmbLessThan(BigDecimal value) {
            addCriterion("sellRmb <", value, "sellrmb");
            return (Criteria) this;
        }

        public Criteria andSellrmbLessThanOrEqualTo(BigDecimal value) {
            addCriterion("sellRmb <=", value, "sellrmb");
            return (Criteria) this;
        }

        public Criteria andSellrmbIn(List<BigDecimal> values) {
            addCriterion("sellRmb in", values, "sellrmb");
            return (Criteria) this;
        }

        public Criteria andSellrmbNotIn(List<BigDecimal> values) {
            addCriterion("sellRmb not in", values, "sellrmb");
            return (Criteria) this;
        }

        public Criteria andSellrmbBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("sellRmb between", value1, value2, "sellrmb");
            return (Criteria) this;
        }

        public Criteria andSellrmbNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("sellRmb not between", value1, value2, "sellrmb");
            return (Criteria) this;
        }

        public Criteria andCiqgoodsnoIsNull() {
            addCriterion("ciqgoodsno is null");
            return (Criteria) this;
        }

        public Criteria andCiqgoodsnoIsNotNull() {
            addCriterion("ciqgoodsno is not null");
            return (Criteria) this;
        }

        public Criteria andCiqgoodsnoEqualTo(String value) {
            addCriterion("ciqgoodsno =", value, "ciqgoodsno");
            return (Criteria) this;
        }

        public Criteria andCiqgoodsnoNotEqualTo(String value) {
            addCriterion("ciqgoodsno <>", value, "ciqgoodsno");
            return (Criteria) this;
        }

        public Criteria andCiqgoodsnoGreaterThan(String value) {
            addCriterion("ciqgoodsno >", value, "ciqgoodsno");
            return (Criteria) this;
        }

        public Criteria andCiqgoodsnoGreaterThanOrEqualTo(String value) {
            addCriterion("ciqgoodsno >=", value, "ciqgoodsno");
            return (Criteria) this;
        }

        public Criteria andCiqgoodsnoLessThan(String value) {
            addCriterion("ciqgoodsno <", value, "ciqgoodsno");
            return (Criteria) this;
        }

        public Criteria andCiqgoodsnoLessThanOrEqualTo(String value) {
            addCriterion("ciqgoodsno <=", value, "ciqgoodsno");
            return (Criteria) this;
        }

        public Criteria andCiqgoodsnoLike(String value) {
            addCriterion("ciqgoodsno like", value, "ciqgoodsno");
            return (Criteria) this;
        }

        public Criteria andCiqgoodsnoNotLike(String value) {
            addCriterion("ciqgoodsno not like", value, "ciqgoodsno");
            return (Criteria) this;
        }

        public Criteria andCiqgoodsnoIn(List<String> values) {
            addCriterion("ciqgoodsno in", values, "ciqgoodsno");
            return (Criteria) this;
        }

        public Criteria andCiqgoodsnoNotIn(List<String> values) {
            addCriterion("ciqgoodsno not in", values, "ciqgoodsno");
            return (Criteria) this;
        }

        public Criteria andCiqgoodsnoBetween(String value1, String value2) {
            addCriterion("ciqgoodsno between", value1, value2, "ciqgoodsno");
            return (Criteria) this;
        }

        public Criteria andCiqgoodsnoNotBetween(String value1, String value2) {
            addCriterion("ciqgoodsno not between", value1, value2, "ciqgoodsno");
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

	public Integer getRows() {
		return rows;
	}

	public void setRows(Integer rows) {
		this.rows = rows;
	}
}