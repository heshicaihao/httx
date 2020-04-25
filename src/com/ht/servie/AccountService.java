package com.ht.servie;

import com.ht.model.Account;
import com.ht.model.PageResult;
import com.ht.model.UIReturn;

public interface AccountService {

	UIReturn save(Account account);
	PageResult<Account> listPage(Account account);
	Account getById(int id);
	
	Account checkPass(Account account);
	
	UIReturn modPWD(Account account);
}
