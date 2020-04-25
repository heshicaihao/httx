package com.ht.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ht.model.LoadingGoods;
import com.ht.model.LoadingGoodsExample;

public interface LoadingGoodsMapper {
    int countByExample(LoadingGoodsExample example);

    int deleteByExample(LoadingGoodsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(LoadingGoods record);

    int insertSelective(LoadingGoods record);

    List<LoadingGoods> selectByExample(LoadingGoodsExample example);

    LoadingGoods selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") LoadingGoods record, @Param("example") LoadingGoodsExample example);

    int updateByExample(@Param("record") LoadingGoods record, @Param("example") LoadingGoodsExample example);

    int updateByPrimaryKeySelective(LoadingGoods record);

    int updateByPrimaryKey(LoadingGoods record);
    List<LoadingGoods> getGoodsDetails(List<String> orderIdlist);
    List<LoadingGoods>  getLoadingIds(List<String> orderIdList);
}