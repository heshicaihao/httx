package com.ht.servie.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ht.mapper.EwaybillMapper;
import com.ht.model.Ewaybill;
import com.ht.model.EwaybillExample;
import com.ht.model.UIReturn;
import com.ht.servie.EWaybillService;
import com.ht.util.Const;

@Service
public class EWaybillServiceImpl implements EWaybillService {
	@Autowired
	private EwaybillMapper ewaybillMapper;

	@Override
	public UIReturn save(Ewaybill ewaybillEntity) {

		UIReturn rtn = new UIReturn();

		ewaybillMapper.insert(ewaybillEntity);

		rtn.setCode(Const.UI_SUCCESS);
		rtn.setSuccess(true);
		return rtn;
	}

	@Override
	public Ewaybill getByKey(String waybillno) {
		// TODO Auto-generated method stub
		EwaybillExample exp = new EwaybillExample();
		EwaybillExample.Criteria cri = exp.createCriteria();
		cri.andWaybillnoEqualTo(waybillno);
		List<Ewaybill> lstEwaybill = ewaybillMapper.selectByExample(exp);

		if (null != lstEwaybill && lstEwaybill.size() > 0) {
			return lstEwaybill.get(0);
		}
		return null;
	}

	
	@Override
	public UIReturn updateByPrimaryKeySelective(Ewaybill ewaybillEntity)
	{
		UIReturn rtn = new UIReturn();

		ewaybillMapper.updateByPrimaryKeySelective(ewaybillEntity);

		rtn.setCode(Const.UI_SUCCESS);
		rtn.setSuccess(true);
		return rtn;
	}
	
	@Override
	public int deleteByPrimaryKey(Integer id)
	{
		return  ewaybillMapper.deleteByPrimaryKey(id);
	}
}
