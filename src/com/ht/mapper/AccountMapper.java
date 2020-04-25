package com.ht.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ht.model.Account;

public interface AccountMapper {

	void add(Account account);
	List<Account> listPage(Account account);
	int countPage(Account account);
	Account getById(@Param("id") int id);
	Account getByLoginName(@Param("loginName") String loginName);
	void update(Account account);
	Account checkPass(Account account);
}
