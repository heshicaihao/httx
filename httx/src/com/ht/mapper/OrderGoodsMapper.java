package com.ht.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.ht.model.IntEntrepotDetail;
import com.ht.model.OrderGoods;
import com.ht.model.OrderGoodsDetail;
import com.ht.model.OrderGoodsExample;
import com.ht.model.UserGoods;
import com.ht.model.reportmodel.PickGoodTotalReport;

public interface OrderGoodsMapper {
	int countByExample(OrderGoodsExample example);

	int deleteByExample(OrderGoodsExample example);

	int deleteByPrimaryKey(Integer id);

	int insert(OrderGoods record);

	int insertSelective(OrderGoods record);

	List<OrderGoods> selectByExample(OrderGoodsExample example);

	OrderGoods selectByPrimaryKey(Integer id);

	int updateByExampleSelective(@Param("record") OrderGoods record,
			@Param("example") OrderGoodsExample example);

	int updateByExample(@Param("record") OrderGoods record,
			@Param("example") OrderGoodsExample example);

	int updateByPrimaryKeySelective(OrderGoods record);

	int updateByPrimaryKey(OrderGoods record);

	List<OrderGoodsDetail> getDetails(String id);

	List<IntEntrepotDetail> getOrderEntrepotDetails(Map<String,Integer> param);

	UserGoods getUserGoodsDetails(Map<String,Integer> param);

	int updateIntEntrepotDetailById(Map<String,Integer> param);

	int updateUserGoodsByUserkeyGoodsid(Map<String,Integer> param);

	List<PickGoodTotalReport> getPickGoodTotalDetails(String instkey);
}