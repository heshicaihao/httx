package com.ht.servie.impl;

import java.sql.Timestamp;
import java.util.Calendar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ht.mapper.AccountMapper;
import com.ht.model.Account;
import com.ht.model.PageResult;
import com.ht.model.UIReturn;
import com.ht.servie.AccountService;
import com.ht.util.StringUtil;
@Service
public class AccountServiceImpl implements AccountService {
	
	private static final Logger log = LoggerFactory.getLogger(AccountServiceImpl.class);

	@Autowired
	private AccountMapper accountMapper;
	
	@Override
	public UIReturn save(Account account) {
		UIReturn rtn = null;
		Integer id = account.getId();
		if(!StringUtil.isEmpty(account.getLoginName())){
			Account exists = null;
			try{
			exists = accountMapper.getByLoginName(account.getLoginName().toUpperCase());
			}catch(Exception ex){
				log.error("getByLoginName fail.",ex);
			}
			if(null != exists){
				if(!exists.getId().equals(account.getId())){
					rtn = new UIReturn();
					rtn.setErrorMsg(String.format("登陆用户名[%s]已经存在！", exists.getLoginName()));
					rtn.setCode(2);
					rtn.setSuccess(false);
				}
			}
		}

		if(null == rtn){
			try{
				if(null == id){
					accountMapper.add(account);
				}else{
					accountMapper.update(account);
				}
				rtn = new UIReturn();
				rtn.setCode(0);
				rtn.setSuccess(true);
			}catch(Exception ex){
				log.error("Save fail.",ex);
				rtn = new UIReturn(ex.getMessage());
			}
		}
		return rtn;
	}

	@Override
	public PageResult<Account> listPage(Account account) {
		PageResult<Account> result = new PageResult<Account>();
		try{
			result.setRows(accountMapper.listPage(account));
			result.setTotal(accountMapper.countPage(account));
		}catch(Exception ex){
			log.error("listPage fail.",ex);
			String errorMsg = ex.getMessage();
			if(!StringUtil.isEmpty(errorMsg) && errorMsg.length() > 100){
				errorMsg = errorMsg.substring(0,100) + "...";
			}
			result.setErrmsg(errorMsg);
			result.setSuccess(false);
		}
		return result;
	}

	@Override
	public Account getById(int id) {
		return accountMapper.getById(id);
	}

	@Override
	public Account checkPass(Account account) {
		if(!StringUtil.isEmpty(account.getLoginName()) && !StringUtil.isEmpty(account.getLoginPWD())){
			try{
				account.setLoginName(account.getLoginName().toUpperCase());
				Account passUser = accountMapper.checkPass(account);
				if(null != passUser){
					Account updateLastLogin = new Account();
					updateLastLogin.setLastLoginDate(new Timestamp(Calendar.getInstance().getTimeInMillis()));
					updateLastLogin.setId(passUser.getId());
					accountMapper.update(updateLastLogin);
				}
				return passUser;
			}catch(Exception ex){
				log.error("Check Login fail.",ex);
			}
		}
		return null;
	}
	
	@Override
	public UIReturn modPWD(Account account){
		UIReturn rtn = new UIReturn();
		Account checkU = new Account();
		checkU.setLoginName(account.getLoginName());
		checkU.setLoginPWD(account.getOldPWD());
		Account passUser = accountMapper.checkPass(checkU);
		if(null == passUser){
			rtn.setCode(2);
			rtn.setErrorMsg("输入密码错误!");
		}else{
			Account u = new Account();
			u.setId(passUser.getId());
			u.setLoginPWD(account.getLoginPWD());
			accountMapper.update(u);
			rtn.setCode(0);
		}
		return rtn;
	}

}
