package com.ht.servie.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ht.mapper.GoodsMapper;
import com.ht.model.Goods;
import com.ht.model.GoodsExample;
import com.ht.servie.GoodsExportService;

@Service
public class GoodsExportServiceImpl implements GoodsExportService {

	private static final Logger log = LoggerFactory
			.getLogger(GoodsExportServiceImpl.class);

	@Autowired
	private GoodsMapper GoodsMapper;

	@Override
	public List<Goods> selectByExample(String ids) {
		try {
			GoodsExample exp = new GoodsExample();
			GoodsExample.Criteria cri = exp.createCriteria();
			String id[] = ids.split(",");
			List<Integer> list = new ArrayList<Integer>();
			if (null != id && id.length > 0) {
				for (int i = 0; i < id.length; i++) {
					list.add(Integer.parseInt(id[i]));
				}
			}
			cri.andIdIn(list);
			return GoodsMapper.select4Export(exp);
		} catch (Exception e) {
			log.error("List Goods for export fail",e);
		}
		return null;
	}

}
