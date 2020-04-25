package com.ht.mapper;

import java.util.List;

import com.ht.model.GMUser;

public interface GMUserMapper {
    int countPage(GMUser user);

    int insert(GMUser record);

    List<GMUser> listPage(GMUser user);
    
    List<GMUser> getActiveUserList();

    GMUser getByKey(Integer instkey);
    
    GMUser getByName(String name);

    int updateByPrimaryKeySelective(GMUser record);
}