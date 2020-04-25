package com.ht.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ht.model.LoadingInfo;
import com.ht.model.LoadingInfoExample;
import com.ht.model.UIOrder;

public interface LoadingInfoMapper {
    int countByExample(LoadingInfoExample example);

    int deleteByExample(LoadingInfoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(LoadingInfo record);

    int insertSelective(LoadingInfo record);

    List<LoadingInfo> selectByExample(LoadingInfoExample example);

    LoadingInfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") LoadingInfo record, @Param("example") LoadingInfoExample example);

    int updateByExample(@Param("record") LoadingInfo record, @Param("example") LoadingInfoExample example);

    int updateByPrimaryKeySelective(LoadingInfo record);

    int updateByPrimaryKey(LoadingInfo record);
    
    void addUIOrderId(UIOrder uiOrder);
    
    void cleanUI(@Param("transInstKey") String transInstKey);
    
    List<String> checkUnloading(@Param("transInstKey") String transInstKey);
    
    void closeOrderBatch(@Param("transInstKey") String transInstKey);
}