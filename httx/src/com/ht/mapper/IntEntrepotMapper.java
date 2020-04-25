package com.ht.mapper;

import com.ht.model.IntEntrepot;
import com.ht.model.IntEntrepotExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface IntEntrepotMapper {
    int countByExample(IntEntrepotExample example);

    int deleteByExample(IntEntrepotExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(IntEntrepot record);

    int insertSelective(IntEntrepot record);

    List<IntEntrepot> selectByExample(IntEntrepotExample example);

    IntEntrepot selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") IntEntrepot record, @Param("example") IntEntrepotExample example);

    int updateByExample(@Param("record") IntEntrepot record, @Param("example") IntEntrepotExample example);

    int updateByPrimaryKeySelective(IntEntrepot record);

    int updateByPrimaryKey(IntEntrepot record);
    
    String getMaxUserSeq(int userKey);
    
    int getInventoryById(int id);
}