package com.ht.servie.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ht.mapper.ReportMapper;
import com.ht.model.Goods;
import com.ht.model.PageResult;
import com.ht.model.Report;
import com.ht.servie.ReportService;
import com.ht.util.StringUtil;

@Service
public class ReportServiceImpl implements ReportService {

	private static final Logger log = LoggerFactory
			.getLogger(ReportServiceImpl.class);

	@Autowired
	private ReportMapper reportMapper;

	@Override
	public PageResult<Report> orderListByDate(Report report) {
		// TODO Auto-generated method stub
		PageResult<Report> result =new PageResult<Report>();
		try{
			if(!StringUtil.isEmpty(report.getStartDate())){
				report.setStartDateD(StringUtil.string2DateTime(report.getStartDate()));
			}
			if(!StringUtil.isEmpty(report.getEndDate())){
				report.setEndDateD(StringUtil.string2DateTime(report.getEndDate()));
			}
			 result.setRows(reportMapper.orderListByDate(report));
			 result.setTotal(reportMapper.countOrderByDate(report));
		}catch(Exception e){
			result.setErrmsg(e.getMessage());
			result.setSuccess(false);
			log.error("orderList by Date fail.",e);
		}
		
		return result;
	}

	@Override
	public PageResult<Report> storagelistByDate(Report report) {
		// TODO Auto-generated method stub
		PageResult<Report> result =new PageResult<Report>();
		try{
			if(!StringUtil.isEmpty(report.getStartDate())){
				report.setStartDateD(StringUtil.string2DateTime(report.getStartDate()));
			}
			if(!StringUtil.isEmpty(report.getEndDate())){
				report.setEndDateD(StringUtil.string2DateTime(report.getEndDate()));
			}
			if("1".equals(report.getType())){
				result.setRows(reportMapper.storagelistByDate(report));
				result.setTotal(reportMapper.countStorage(report));
			}else if("2".equals(report.getType())){
				result.setRows(reportMapper.sumStoragelistByDate(report));
				result.setTotal(reportMapper.sumCountStorage(report));
			}
		}catch(Exception e){
			log.error("storagelistByDate fail.",e);
			result.setSuccess(false);
			result.setErrmsg(e.getMessage());
		}
		
		return result;
	}
	
	@Override
	public PageResult<Report> transactionListByDate(Report report) {
		PageResult<Report> result =new PageResult<Report>();
		try{
			if(!StringUtil.isEmpty(report.getStartDate())){
				report.setStartDateD(StringUtil.string2DateTime(report.getStartDate()));
			}
			if(!StringUtil.isEmpty(report.getEndDate())){
				report.setEndDateD(StringUtil.string2DateTime(report.getEndDate()));
			}
			result.setRows(reportMapper.transactionListByDate(report));
			result.setTotal(reportMapper.countTransactionListByDate(report));
		}catch(Exception e){
			log.error("transactionListByDate fail.",e);
			result.setSuccess(false);
			result.setErrmsg(e.getMessage());
		}
		
		return result;
	}

	@Override
	public List<Report> storagelist4Export(Report report) {
		List<Report> result = new ArrayList<Report>();
		try{
			if(!StringUtil.isEmpty(report.getStartDate())){
				report.setStartDateD(StringUtil.string2DateTime(report.getStartDate()));
			}
			if(!StringUtil.isEmpty(report.getEndDate())){
				report.setEndDateD(StringUtil.string2DateTime(report.getEndDate()));
			}
			report.setOffset(null);
			report.setPage(null);
			if("1".equals(report.getType())){
				result = reportMapper.storagelistByDate(report);
			}else if("2".equals(report.getType())){
				result = reportMapper.sumStoragelistByDate(report);
			}
		}catch(Exception ex){
			log.error("Export Excel file.",ex);
		}
		return result;
	}

	@Override
	public List<Report> orderListByDate4Export(Report report) {
		List<Report> result = new ArrayList<Report>();
		try{
			if(!StringUtil.isEmpty(report.getStartDate())){
				report.setStartDateD(StringUtil.string2DateTime(report.getStartDate()));
			}
			if(!StringUtil.isEmpty(report.getEndDate())){
				report.setEndDateD(StringUtil.string2DateTime(report.getEndDate()));
			}
			report.setOffset(null);
			report.setPage(null);
			result = reportMapper.orderListByDate4Export(report);
		}catch(Exception ex){
			log.error("Export Excel file.",ex);
		}
		return result;
	}

	@Override
	public List<Report> transactionListByDate4Report(Report report) {
		List<Report> result = new ArrayList<Report>();
		try{
			if(!StringUtil.isEmpty(report.getStartDate())){
				report.setStartDateD(StringUtil.string2DateTime(report.getStartDate()));
			}
			if(!StringUtil.isEmpty(report.getEndDate())){
				report.setEndDateD(StringUtil.string2DateTime(report.getEndDate()));
			}
			report.setOffset(null);
			report.setPage(null);
			result = reportMapper.transactionListByDate4Report(report);
		}catch(Exception ex){
			log.error("Export Excel file.",ex);
		}
		return result;
	}

	@Override
	public PageResult<Goods> goodslistByDate(Goods goods) {
		PageResult<Goods> result =new PageResult<Goods>();
		try{
			if(!StringUtil.isEmpty(goods.getStartDate())){
				goods.setStartDateD(StringUtil.string2DateTime(goods.getStartDate()));
			}
			if(!StringUtil.isEmpty(goods.getEndDate())){
				goods.setEndDateD(StringUtil.string2DateTime(goods.getEndDate()));
			}
			result.setRows(reportMapper.goodsListByDate(goods));
			result.setTotal(reportMapper.countGoodsListByDate(goods));
		}catch(Exception e){
			log.error("transactionListByDate fail.",e);
			result.setSuccess(false);
			result.setErrmsg(e.getMessage());
		}
		return result;
	}

	@Override
	public List<Goods> goodslist4Export(Goods goods) {
		List<Goods> result = new ArrayList<Goods>();
		try{
			if(!StringUtil.isEmpty(goods.getStartDate())){
				goods.setStartDateD(StringUtil.string2DateTime(goods.getStartDate()));
			}
			if(!StringUtil.isEmpty(goods.getEndDate())){
				goods.setEndDateD(StringUtil.string2DateTime(goods.getEndDate()));
			}
			goods.setOffset(null);
			goods.setPage(null);
			result = reportMapper.goodsListByDate4Report(goods);
		}catch(Exception ex){
			log.error("Export Excel file.",ex);
		}
		return result;
	}

	@Override
	public PageResult<Report> orderStatusListByDate(Report report) {
		PageResult<Report> result =new PageResult<Report>();
		try{
			if(!StringUtil.isEmpty(report.getStartDate())){
				report.setStartDateD(StringUtil.string2DateTime(report.getStartDate()));
			}
			if(!StringUtil.isEmpty(report.getEndDate())){
				report.setEndDateD(StringUtil.string2DateTime(report.getEndDate()));
			}
			 result.setRows(reportMapper.orderStatusListByDate(report));
			 result.setTotal(reportMapper.countOrderStatusByDate(report));
		}catch(Exception e){
			result.setErrmsg(e.getMessage());
			result.setSuccess(false);
			log.error("orderList by Date fail.",e);
		}
		
		return result;
	}

	@Override
	public List<Report> orderStatusListByDate4Export(Report report) {
		List<Report> result = new ArrayList<Report>();
		try{
			if(!StringUtil.isEmpty(report.getStartDate())){
				report.setStartDateD(StringUtil.string2DateTime(report.getStartDate()));
			}
			if(!StringUtil.isEmpty(report.getEndDate())){
				report.setEndDateD(StringUtil.string2DateTime(report.getEndDate()));
			}
			report.setOffset(null);
			report.setPage(null);
			result = reportMapper.orderStatusListByDate4Export(report);
		}catch(Exception ex){
			log.error("Export Excel file.",ex);
		}
		return result;
	}
}
