package com.ht.servie;

import java.util.List;

import com.ht.model.Goods;
import com.ht.model.PageResult;
import com.ht.model.Report;

public interface ReportService {
	//订单出仓报表
    PageResult<Report> orderListByDate(Report report);
    List<Report> orderListByDate4Export(Report report);
    
    //仓储现有量盘点
    PageResult<Report> storagelistByDate(Report report);
    List<Report> storagelist4Export(Report report);
    
    //仓储交易记录
    PageResult<Report> transactionListByDate(Report report);
    List<Report> transactionListByDate4Report(Report report);
    
    //商品备案信息
    PageResult<Goods> goodslistByDate(Goods goods);
    List<Goods> goodslist4Export(Goods goods);
    
    //订单状态报表
    PageResult<Report> orderStatusListByDate(Report report);
    List<Report> orderStatusListByDate4Export(Report report);
    
}
