package com.ht.servie.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ht.mapper.IDCardMapper;
import com.ht.model.IDCard;
import com.ht.model.PageResult;
import com.ht.servie.IDCardService;
import com.ht.util.HTException;
import com.ht.util.StringUtil;
@Service
public class IDCardServiceImpl implements IDCardService {

	private static final Logger log = LoggerFactory.getLogger(IDCardServiceImpl.class);
	
	@Autowired
	private IDCardMapper idCardMapper;
	
	@Override
	public PageResult<IDCard> listPage(IDCard idCard) {
		PageResult<IDCard> result = new PageResult<IDCard>();
		try{
			if(!StringUtil.isEmpty(idCard.getStartDateStr())){
				idCard.setStartDate(StringUtil.string2DateTime(idCard.getStartDateStr()));
			}
			if(!StringUtil.isEmpty(idCard.getEndDateStr())){
				idCard.setEndDate(StringUtil.string2DateTime(idCard.getEndDateStr()));
			}
			result.setRows(idCardMapper.listPage(idCard));
			result.setTotal(idCardMapper.count(idCard));
		}catch(Exception ex){
			log.error("List Page error.",ex);
			result.setErrmsg("List Page fail, exception happened:" + ex.getMessage());
			result.setSuccess(false);
		}
		return result;
	}

	@Override
	public void delete(int id) {
		idCardMapper.del(id);
	}

	@Override
	public void add(IDCard idCard) throws HTException {
		IDCard old = idCardMapper.getByName(idCard.getName());
		if(null != old){
			throw new HTException("用户名[" + idCard.getName()+"]已经上传过身份证");
		}
		IDCard oldCard = idCardMapper.getByCardNo(idCard.getCardNo());
		if(null != oldCard){
			throw new HTException(String.format("身份证号[%s]已经存在，请匆重复添加!", oldCard.getCardNo()));
		}
		idCardMapper.add(idCard);
	}

	@Override
	public IDCard getByCardNo(String cardNo) {
		return idCardMapper.getByCardNo(cardNo);
	}

}
