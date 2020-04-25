package com.ht.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.ht.model.LoadingOrder;
import com.ht.model.OrderFlowNumber;
import com.ht.model.OrderInfo;
import com.ht.model.OrderInfoExample;
import com.ht.model.UserGoods;

public interface OrderInfoMapper {
    int countByExample(OrderInfoExample example);

    int deleteByExample(OrderInfoExample example);

    int deleteByPrimaryKey(String orderid);

    int insert(OrderInfo record);

    int insertSelective(OrderInfo record);

    List<OrderInfo> selectByExample(OrderInfoExample example);

    OrderInfo selectByPrimaryKey(String orderid);

    int updateByExampleSelective(@Param("record") OrderInfo record, @Param("example") OrderInfoExample example);

    int updateByExample(@Param("record") OrderInfo record, @Param("example") OrderInfoExample example);

    int updateByPrimaryKeySelective(OrderInfo record);

    int updateByPrimaryKey(OrderInfo record);
    
    UserGoods selectUserGoodsByPrimaryKey(String instkey);
    
    OrderFlowNumber selectFlownumberFromDB(Integer customerId);
    
    int insertFlownumberFromDB(Integer customerId);
    
    int updateFlownumberFromDB(Integer customerId);
    
    OrderFlowNumber selectFlownumberFromDB2(Integer customerId);
    
    int insertFlownumberFromDB2(Integer customerId);
    
    List<LoadingOrder> listLoadingPage(Map<String,Object> dateMap);
    
    
    OrderInfo selectOrderNameByOrderdocid(String orderdocid);
}