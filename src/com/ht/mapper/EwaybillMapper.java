package com.ht.mapper;

import com.ht.model.Ewaybill;
import com.ht.model.EwaybillExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EwaybillMapper {
    int countByExample(EwaybillExample example);

    int deleteByExample(EwaybillExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Ewaybill record);

    int insertSelective(Ewaybill record);

    List<Ewaybill> selectByExample(EwaybillExample example);

    Ewaybill selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Ewaybill record, @Param("example") EwaybillExample example);

    int updateByExample(@Param("record") Ewaybill record, @Param("example") EwaybillExample example);

    int updateByPrimaryKeySelective(Ewaybill record);

    int updateByPrimaryKey(Ewaybill record);
}