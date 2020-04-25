package com.ht.servie.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ht.mapper.GMUserMapper;
import com.ht.model.GMUser;
import com.ht.model.PageResult;
import com.ht.model.UIReturn;
import com.ht.servie.GMUserService;
import com.ht.util.Const;
import com.ht.util.HTException;
import com.ht.util.StringUtil;

@Service
public class GMUserServiceImpl implements GMUserService {
	
	private static final Logger log = LoggerFactory.getLogger(GMUserServiceImpl.class);
	
	@Autowired
	private GMUserMapper userMapper;
	
	@Override
	public void add(GMUser gmUser) throws HTException {
		if(StringUtil.isEmpty(gmUser.getGmusername())){
			throw new HTException("用户名不能为空!");
		}
		GMUser oldUser = userMapper.getByName(gmUser.getGmusername().toUpperCase());
		if(null != oldUser){
			throw new HTException(String.format("用户 [%s] 已经存在，请修改用户名称!", gmUser.getGmusername()));
		}
		userMapper.insert(gmUser);
	}

	@Override
	public void update(GMUser gmUser) throws HTException {
		if(StringUtil.isEmpty(gmUser.getGmusername())){
			throw new HTException("用户名不能为空!");
		}
		GMUser oldUser = userMapper.getByName(gmUser.getGmusername().toUpperCase());
		if(null != oldUser && !oldUser.getInstkey().equals(gmUser.getInstkey())){
			throw new HTException(String.format("用户 [%s] 已经存在，请修改用户名称!", gmUser.getGmusername()));
		}
		userMapper.updateByPrimaryKeySelective(gmUser);
	}

	@Override
	public PageResult<GMUser> listPage(GMUser gmUser) {
		PageResult<GMUser> result = new PageResult<GMUser>();
		try{
			result.setRows(userMapper.listPage(gmUser));
			result.setTotal(userMapper.countPage(gmUser));
		}catch(Exception ex){
			log.error("List user by page fail.",ex);
			result.setErrmsg("查询用户列表失败! " + ex.getMessage());
		}		
		return result;
	}

	@Override
	public UIReturn delete(String instkey) {
		UIReturn rtn = new UIReturn();
		try{
			GMUser user = new GMUser();
			user.setUserstatus((short)0);
			user.setInstkey(Integer.parseInt(instkey));
			userMapper.updateByPrimaryKeySelective(user);
		}catch(Exception ex){
			rtn.setCode(Const.UI_ERROR);
			rtn.setSuccess(false);
			rtn.setErrorMsg(ex.getMessage());
			log.error("失效用户失败！instkey=" + instkey,ex);
		}
		return rtn;
	}

	@Override
	public GMUser getByKey(Integer instkey) {
		return userMapper.getByKey(instkey);
	}

}
