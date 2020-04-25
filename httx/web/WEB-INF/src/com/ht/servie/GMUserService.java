package com.ht.servie;

import com.ht.model.GMUser;
import com.ht.model.PageResult;
import com.ht.model.UIReturn;
import com.ht.util.HTException;

public interface GMUserService {

	void add(GMUser gmUser) throws HTException;
	
	void update(GMUser gmUser) throws HTException;
	
	PageResult<GMUser> listPage(GMUser gmUser);
	
	UIReturn delete(String instkey);
	
	GMUser checkPass(GMUser gmUser);
	
	GMUser getByKey(Integer instkey);
	
	UIReturn modPWD(GMUser gmUser);
}
