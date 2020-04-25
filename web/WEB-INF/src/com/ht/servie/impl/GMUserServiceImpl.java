package com.ht.servie.impl;

import java.util.Calendar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ht.mapper.GMUserMapper;
import com.ht.model.GMUser;
import com.ht.model.GMUserExample;
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
		GMUserExample exp = new GMUserExample();
		GMUserExample.Criteria cri = exp.createCriteria();
		cri.andGmusernameEqualTo(gmUser.getGmusername().toUpperCase());
		GMUser oldUser = userMapper.selectByName(gmUser.getGmusername());
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
		GMUserExample exp = new GMUserExample();
		GMUserExample.Criteria cri = exp.createCriteria();
		cri.andGmusernameEqualTo(gmUser.getGmusername().toUpperCase());
		GMUser oldUser = userMapper.selectByName(gmUser.getGmusername());
		if(null != oldUser && !oldUser.getInstkey().equals(gmUser.getInstkey())){
			throw new HTException(String.format("用户 [%s] 已经存在，请修改用户名称!", gmUser.getGmusername()));
		}
		userMapper.updateByPrimaryKeySelective(gmUser);
	}

	@Override
	public PageResult<GMUser> listPage(GMUser gmUser) {
		PageResult<GMUser> result = new PageResult<GMUser>();
		try{
			GMUserExample exp = new GMUserExample();
			GMUserExample.Criteria cri = exp.createCriteria();
			exp.setOffset(gmUser.getOffset());
			exp.setRows(gmUser.getRows());
			if(!StringUtil.isEmpty(gmUser.getGmusername())){
				cri.andGmusernameLike(gmUser.getGmusername().toUpperCase());
			}
			if(!StringUtil.isEmpty(gmUser.getConame())){
				cri.andConameLike(gmUser.getConame().toUpperCase());
			}
			if(null != gmUser.getUserstatus() && gmUser.getUserstatus().shortValue() > -1){
				cri.andUserstatusEqualTo(gmUser.getUserstatus());
			}
			if(null != gmUser.getUsertype() && gmUser.getUsertype().shortValue() > -1){
				cri.andUserstatusEqualTo(gmUser.getUsertype());
			}
			exp.setOrderByClause(" gmusername asc");
			result.setRows(userMapper.selectByExample(exp));
			result.setTotal(userMapper.countByExample(exp));
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
				userMapper.deleteByPrimaryKey(instkey);
		}catch(Exception ex){
			rtn.setCode(Const.UI_ERROR);
			rtn.setSuccess(false);
			rtn.setErrorMsg(ex.getMessage());
			log.error("删除用户失败！instkey=" + instkey,ex);
		}
		return rtn;
	}

	@Override
	public GMUser checkPass(GMUser gmUser) {
		if(!StringUtil.isEmpty(gmUser.getGmusername()) && !StringUtil.isEmpty(gmUser.getGmuserpwd())){
			try{
				GMUser passUser = userMapper.checkPass(gmUser);
				if(null != passUser){
					GMUser updateLastLogin = new GMUser();
					updateLastLogin.setUserlastlogin(Calendar.getInstance().getTime());
					updateLastLogin.setInstkey(passUser.getInstkey());
				}
				return passUser;
			}catch(Exception ex){
				log.error("Check Login fail.",ex);
			}
		}
		return null;
	}

	@Override
	public GMUser getByKey(Integer instkey) {
		return userMapper.selectByPrimaryKey(instkey);
	}

	@Override
	public UIReturn modPWD(GMUser gmUser){
		UIReturn rtn = new UIReturn();
		GMUser checkU = new GMUser();
		checkU.setGmusername(gmUser.getGmusername());
		checkU.setGmuserpwd(gmUser.getOldPWD());
		GMUser passUser = userMapper.checkPass(checkU);
		if(null == passUser){
			rtn.setCode(2);
			rtn.setErrorMsg("输入密码错误!");
		}else{
			GMUser u = new GMUser();
			u.setInstkey(passUser.getInstkey());
			u.setGmuserpwd(gmUser.getGmuserpwd());
			userMapper.updateByPrimaryKeySelective(u);
			rtn.setCode(0);
		}
		return rtn;
	}

}
