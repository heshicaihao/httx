package com.ht.mapper;

import java.util.List;

import com.ht.model.Goods;
import com.ht.model.Report;

public interface ReportMapper {
	List<Report> orderListByDate(Report report);
	int countOrderByDate(Report report);
	List<Report> orderListByDate4Export(Report report);
	
	List<Report> storagelistByDate(Report report);
	int countStorage(Report report);
	
	List<Report> sumStoragelistByDate(Report report);
	int sumCountStorage(Report report);
	
	List<Report> transactionListByDate(Report report);
	int countTransactionListByDate(Report report);
	List<Report> transactionListByDate4Report(Report report);
	
	List<Goods> goodsListByDate(Goods goods);
	int countGoodsListByDate(Goods goods);
	List<Goods> goodsListByDate4Report(Goods goods);
	
	List<Report> orderStatusListByDate(Report report);
	int countOrderStatusByDate(Report report);
	List<Report> orderStatusListByDate4Export(Report report);
	
}