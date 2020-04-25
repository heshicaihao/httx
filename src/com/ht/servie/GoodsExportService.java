package com.ht.servie;

import java.util.List;

import com.ht.model.Goods;

public interface GoodsExportService {

	List<Goods> selectByExample(String ids );

}
