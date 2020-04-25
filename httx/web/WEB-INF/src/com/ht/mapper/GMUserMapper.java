package com.ht.mapper;

import com.ht.model.GMUser;
import com.ht.model.GMUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GMUserMapper {
    int countByExample(GMUserExample example);
    
    GMUser checkPass(GMUser gmUser);

    int deleteByExample(GMUserExample example);

    int deleteByPrimaryKey(String instkey);

    int insert(GMUser record);

    int insertSelective(GMUser record);

    List<GMUser> selectByExample(GMUserExample example);

    GMUser selectByPrimaryKey(Integer instkey);
    
    GMUser selectByName(String name);

    int updateByExampleSelective(@Param("record") GMUser record, @Param("example") GMUserExample example);

    int updateByExample(@Param("record") GMUser record, @Param("example") GMUserExample example);

    int updateByPrimaryKeySelective(GMUser record);

    int updateByPrimaryKey(GMUser record);
}