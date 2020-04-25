package com.ht.servie.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.ht.excel.Excel2003Reader;
import com.ht.excel.OrderXlsRowReader;
import com.ht.mapper.CompanyMapper;
import com.ht.mapper.EwaybillMapper;
import com.ht.mapper.GoodsMapper;
import com.ht.mapper.OrderGoodsMapper;
import com.ht.mapper.OrderInfoMapper;
import com.ht.mapper.ProvinceCityAreaMapper;
import com.ht.model.Account;
import com.ht.model.Company;
import com.ht.model.Ewaybill;
import com.ht.model.Goods;
import com.ht.model.IntEntrepotDetail;
import com.ht.model.OrderFlowNumber;
import com.ht.model.OrderGoods;
import com.ht.model.OrderGoodsExample;
import com.ht.model.OrderInfo;
import com.ht.model.OrderInfoExample;
import com.ht.model.OrderInfoExample.Criteria;
import com.ht.model.PageResult;
import com.ht.model.ProvinceCityArea;
import com.ht.model.UIReturn;
import com.ht.model.UserGoods;
import com.ht.model.reportmodel.ImportOrderGoods;
import com.ht.servie.OrderService;
import com.ht.util.Config;
import com.ht.util.Const;
import com.ht.util.HTException;
import com.ht.util.StringUtil;

@Service
public class OrderServiceImpl implements OrderService {

	private static final Logger log = LoggerFactory
			.getLogger(OrderServiceImpl.class);

	@Autowired
	private OrderInfoMapper orderMapper;
	
	@Autowired
	private OrderGoodsMapper orderGoodsMapper;
	
	@Autowired
	private	EwaybillMapper ewaybillMapper;

	@Autowired
	private Config config;
	
	@Autowired
	private CompanyMapper companyMapper;
	
	@Autowired
	private GoodsMapper goodsMapper;
	
	@Autowired
	private ProvinceCityAreaMapper provinceCityAreaMapper;

	@Override
	public UIReturn save(OrderInfo orderEntity) {

		UIReturn rtn = new UIReturn();
		
		String oldOrderName = isOrderDocidused(orderEntity.getOrderdocid(),orderEntity.getOrdername());
		if(!StringUtil.isEmpty(oldOrderName))
		{
			rtn.setCode(Const.UI_ERROR);
			rtn.setErrorMsg("身份证号"+orderEntity.getOrderdocid()+"已被 '"+oldOrderName+"' 使用！" );
			rtn.setSuccess(false);
			return rtn;
		}
		
		BigDecimal initNumber = new BigDecimal(0);
		if (null == orderEntity.getOrdergoodtotal()) {
			orderEntity.setOrdergoodtotal(initNumber);
		}
		orderEntity.setFreight(initNumber);
		orderEntity.setTax(initNumber);
		
		Company company = companyMapper.selectByPrimaryKey(orderEntity.getCompanyid());
		if(StringUtil.isEmpty(orderEntity.getOrderid()))
		{
			String orderId = StringUtil.getOrderid(company.getCompanycode(),orderEntity.getEntrecordname(), getOrderflowNo(orderEntity.getEntrecordname()));
			orderEntity.setOrderid(orderId);
		}

		
		orderMapper.insert(orderEntity);


		rtn.setCode(Const.UI_SUCCESS);
		rtn.setRtnKey(orderEntity.getOrderid());
		rtn.setSuccess(true);
		return rtn;
	}

	@Override
	public UIReturn saveEdit(OrderInfo orderEntity) {
		UIReturn rtn = new UIReturn();
		
		String oldOrderName = isOrderDocidused(orderEntity.getOrderdocid(),orderEntity.getOrdername());
		if(!StringUtil.isEmpty(oldOrderName))
		{
			rtn.setCode(Const.UI_ERROR);
			rtn.setErrorMsg("身份证号"+orderEntity.getOrderdocid()+"已被 '"+oldOrderName+"' 使用！");
			rtn.setSuccess(false);
			return rtn;
		}

		orderMapper.updateByPrimaryKeySelective(orderEntity);

		rtn.setCode(Const.UI_SUCCESS);
		rtn.setRtnKey(orderEntity.getOrderid());
		rtn.setSuccess(true);
		return rtn;
	}

	@Override
	public OrderInfo getByKey(String orderid) {
		return orderMapper.selectByPrimaryKey(orderid);
	}

	@Override
	public PageResult<OrderInfo> listPage(OrderInfo order) {
		PageResult<OrderInfo> result = new PageResult<OrderInfo>();
		try {
			OrderInfoExample exp = new OrderInfoExample();
			Criteria cri = exp.createCriteria();
			if (!StringUtil.isEmpty(order.getStartDateStr())) {
				cri.andOrderdateGreaterThanOrEqualTo(StringUtil
						.string2DateTime(order.getStartDateStr()));
			}
			if (!StringUtil.isEmpty(order.getEndDateStr())) {
				cri.andOrderdateLessThanOrEqualTo(StringUtil
						.string2DateTime(order.getEndDateStr()));
			}
			
			if(!StringUtil.isEmpty(order.getPickgoodsno()))
			{
				cri.andPickGoodNolike(order.getPickgoodsno());
			}
			if("1".equals(order.getUnloading()))
			{
				cri.andPickGoodNoIsNull();
			}
			if("0".equals(order.getUnloading()))
			{
				cri.andPickGoodNoIsNotNull();
			}
			
			if(!StringUtil.isEmpty(order.getStatus()))
			{
				cri.andStatusEqualTo(order.getStatus());
			}

			if(!StringUtil.isEmpty(order.getOrderid()) )
			{
				cri.andOrderidLike(order.getOrderid());
			}
			
			if(!StringUtil.isEmpty(order.getEntrecordno()) )
			{
				cri.andEntrecordnoLike(order.getEntrecordno());
			}
			
			if(!StringUtil.isEmpty(order.getEwaysnum()) )
			{
				cri.andEwaysnumLike(order.getEwaysnum());
			}
			
			if(null != order.getEntrecordname() )
			{
				cri.andEntrecordnameEqualTo(order.getEntrecordname());
			}
			
			if(!StringUtil.isEmpty(order.getFirstcreatename()) )
			{
				cri.andFirstCreateNameLike(order.getFirstcreatename().trim());
			}
			exp.setOffset(order.getOffset());
			exp.setRows(order.getRows());
			result.setRows(orderMapper.selectByExample(exp));
			result.setTotal(orderMapper.countByExample(exp));
		} catch (Exception ex) {
			log.error("List Product page fail.", ex);
			result.setErrmsg(ex.getMessage());
		}
		return result;
	}

	@Override
	public UIReturn delete(String orderid) {
		UIReturn rtn = new UIReturn();
		try {
			orderMapper.deleteByPrimaryKey(orderid);
			rtn.setCode(Const.UI_SUCCESS);
		} catch (Exception ex) {
			rtn.setCode(Const.UI_ERROR);
			rtn.setSuccess(false);
			rtn.setErrorMsg(ex.getMessage());
			log.error("删除商品信息失败！id=" + orderid, ex);
		}
		return rtn;
	}

	@Override
	public UIReturn cancel(String orderid) {
		UIReturn rtn = new UIReturn();
		try {
			OrderInfo order = new OrderInfo();
			order.setOrderid(orderid);
			order.setOrderstatus("C");
			orderMapper.updateByPrimaryKeySelective(order);
			rtn.setCode(Const.UI_SUCCESS);
		} catch (Exception ex) {
			rtn.setCode(Const.UI_ERROR);
			rtn.setSuccess(false);
			rtn.setErrorMsg(ex.getMessage());
			log.error("取消订单信息失败！id=" + orderid, ex);
		}
		return rtn;
	}

	@Override
	public List<OrderInfo> selectByExample(String ids) {

		try {
			OrderInfoExample exp = new OrderInfoExample();
			OrderInfoExample.Criteria cri = exp.createCriteria();
			String id[] = ids.split(",");
			List<String> list = new ArrayList<String>();
			if (null != id && id.length > 0) {
				for (int i = 0; i < id.length; i++) {
					list.add(id[i]);
				}

			}
			cri.andOrderidIn(list);
			return orderMapper.selectByExample(exp);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

	@Override
	public UIReturn released(String orderid ,int userid) {

		UIReturn rtn = new UIReturn();
		try {
			OrderInfo order = new OrderInfo();
			order.setOrderid(orderid);
			order.setStatus("2");
			order.setCreateruserid(userid);
			order.setReleasedDate(Calendar.getInstance().getTime());
			orderMapper.updateByPrimaryKeySelective(order);
			rtn.setCode(Const.UI_SUCCESS);

		} catch (Exception ex) {
			rtn.setCode(Const.UI_ERROR);
			rtn.setSuccess(false);
			rtn.setErrorMsg(ex.getMessage());
			log.error("订单发货失败！orderid=" + orderid, ex);
		}
		return rtn;

	}
	
	@Override
	public UIReturn updateOrderStatus(String orderid) {

		UIReturn rtn = new UIReturn();
		try {
			OrderInfo order = new OrderInfo();
			order.setOrderid(orderid);
			order.setStatus("1");
			order.setReleasedDate(Calendar.getInstance().getTime());
			orderMapper.updateByPrimaryKeySelective(order);
			rtn.setCode(Const.UI_SUCCESS);

		} catch (Exception ex) {
			rtn.setCode(Const.UI_ERROR);
			rtn.setSuccess(false);
			rtn.setErrorMsg(ex.getMessage());
			log.error("订单放行失败！orderid=" + orderid, ex);
		}
		return rtn;

	}

	@Override
	@Transactional(rollbackFor={Throwable.class})
	public UIReturn importFile(MultipartFile file, HttpServletRequest req) throws Exception {
			String transInstKey = StringUtil.createId();
			Account user = (Account)req.getSession().getAttribute(Const.WEB_ACCOUNT);
			InputStream is = file.getInputStream();
			saveAsFile(is, transInstKey);
			is = getFileInputStream(transInstKey);
			Excel2003Reader excel03 = new Excel2003Reader();
			OrderXlsRowReader reader = new OrderXlsRowReader();/*
			reader.setAreaMap(provinceCityAreaMapper.listAreasByCityId(null));
			reader.setCityMap(provinceCityAreaMapper.listCitiesByProvinceId(null));
			reader.setProvinceMap(provinceCityAreaMapper.listAllProvinces());*/
			reader.setProMap(getProvinceCityAreaMap());
			excel03.setRowReader(reader);
			excel03.process(is);
			
			int userKey = Integer.parseInt(req.getParameter("importUser"));
			int companyid = Integer.parseInt(req.getParameter("importCompany"));
			String curr = req.getParameter("importcurr");
			
			List<ImportOrderGoods> datas = reader.getDatas();
			
			StringBuffer sb = new StringBuffer();
			Map<String, OrderInfo> orderMap = new HashMap<String,OrderInfo>();
			OrderInfo tmpOrder = null;
			for (ImportOrderGoods importOrderGoods:datas)
			{
				if(!importOrderGoods.getInstkey().startsWith(StringUtil.formatCode(3, userKey)))
				{
					sb.append(importOrderGoods.getInstkey());
					throw new HTException("商品编号不匹配，请修正后再导入! 不存在的商品编号：" + sb.toString());
				}
				
				UserGoods userGoods = orderMapper.selectUserGoodsByPrimaryKey(importOrderGoods.getInstkey());
				

				
				if(null == userGoods)
				{
					sb.append(importOrderGoods.getInstkey());
					throw new HTException("客户商品编码编码不存在! 不存在的商品编号：" + sb.toString());
				}
				
				Goods goods =goodsMapper.selectByPrimaryKey(userGoods.getGoodsId());
				
				if(null != goods && 2 == goods.getActive())
				{
					sb.append(userGoods.getINSTKEY());
					throw new HTException("商品编码：" + sb.toString()+" 已经失效！");
				}
				
				String oldOrderName = isOrderDocidused(importOrderGoods.getOrderdocid(),importOrderGoods.getOrdername());
				if(!StringUtil.isEmpty(oldOrderName))
				{
					sb.append(userGoods.getINSTKEY());
					throw new HTException("身份证号"+importOrderGoods.getOrderdocid()+"已被 '"+oldOrderName+"' 使用！" );
				}
				
				OrderInfo  orderInfo = new OrderInfo();
				orderInfo.setCompanyid(companyid);
				orderInfo.setEntrecordno(importOrderGoods.getEntrecordno());
				orderInfo.setEntrecordname(userKey);
				orderInfo.setOrderaddress(importOrderGoods.getOrderaddress());
				orderInfo.setOrderdocid(importOrderGoods.getOrderdocid());
				orderInfo.setOrderphone(importOrderGoods.getOrderphone());
				orderInfo.setOrdername(importOrderGoods.getOrdername());
				orderInfo.setFreight(importOrderGoods.getFreight());
				orderInfo.setTax(importOrderGoods.getTax());
				orderInfo.setOrdergoodtotalcurr(curr);
				orderInfo.setOrderstatus("S");
				orderInfo.setStatus("0");
				orderInfo.setOrderdate(new Date());
				
				orderInfo.setOrdergoodtotal(new BigDecimal(0));
				orderInfo.setProvince(importOrderGoods.getProvinceId());
				orderInfo.setCity(importOrderGoods.getCityId());
				orderInfo.setArea(importOrderGoods.getAreaId());
				orderInfo.setCreateruserid(user.getId());
				orderInfo.setFirstcreatename(user.getLoginName());
				orderInfo.setNote(importOrderGoods.getNote());
				OrderGoods orderGoods =new OrderGoods();
				orderGoods.setGqty(importOrderGoods.getGqty());

				if(null == importOrderGoods.getDecprice())
				{
					orderGoods.setDecprice(new BigDecimal(goods.getRmb()));
				}else
				{
					orderGoods.setDecprice(importOrderGoods.getDecprice());
				}

				orderGoods.setDecltotal(orderGoods.getDecprice().multiply(new BigDecimal(importOrderGoods.getGqty())));
				orderGoods.setGoodsid(userGoods.getGoodsId());
				//orderGoods.setNote(importOrderGoods.getNote());
				
				Ewaybill ewaybill =new Ewaybill();
				ewaybill.setWaybillno(importOrderGoods.getWaybillno());
				ewaybill.setNoticeno(importOrderGoods.getNoticeno());
				ewaybill.setDeclaretype("1");
				ewaybill.setLogisticsstatus("发货");
				ewaybill.setFreight(importOrderGoods.getFreight());
				ewaybill.setValuationfee(importOrderGoods.getValuationfee());
				ewaybill.setTax(importOrderGoods.getTax());
				
				
				//List<OrderInfo> lstOrderinfo = selectOrderinfoByEntRecordNo(importOrderGoods.getEntrecordno());
				tmpOrder = orderMap.get(importOrderGoods.getEntrecordno());
				if(null == tmpOrder){
					Company company = companyMapper.selectByPrimaryKey(companyid);
					String orderid = StringUtil.getOrderid(company.getCompanycode(),userKey, getOrderflowNo(userKey));
					orderInfo.setOrderid(orderid);
					orderInfo.setEwaysnum(ewaybill.getWaybillno());
					save(orderInfo);
					
					orderGoods.setOrderid(orderid);
					orderGoodsMapper.insert(orderGoods);
					
					ewaybill.setOrderid(orderid);
					ewaybillMapper.insert(ewaybill);
					orderMap.put(importOrderGoods.getEntrecordno(), orderInfo);
				}
				else{
					orderGoods.setOrderid(tmpOrder.getOrderid());
					orderGoodsMapper.insert(orderGoods);
				}
				
			}
		return null;
	}

	private void saveAsFile(InputStream is, String instKey) {
		byte[] buf = new byte[102400];
		File file = new File(config.getImportIntEntRepotFolder(), instKey
				+ ".xls");
		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(file);
			int len = 0;
			while ((len = is.read(buf)) != -1) {
				fos.write(buf, 0, len);
				fos.flush();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (null != fos) {
				try {
					fos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	private InputStream getFileInputStream(String instKey)
			throws FileNotFoundException {
		return new FileInputStream(new File(
				config.getImportIntEntRepotFolder(), instKey + ".xls"));
	}
	
	public List<OrderInfo> selectOrderinfoByEntRecordNo(String entRecordNo) {

		try {
			OrderInfoExample exp = new OrderInfoExample();
			OrderInfoExample.Criteria cri = exp.createCriteria();
			cri.andEntrecordnoEqualTo(entRecordNo);
			return orderMapper.selectByExample(exp);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

	@Override
	public int getOrderflowNo(int customerId) {
		
		OrderFlowNumber ort = orderMapper.selectFlownumberFromDB2(customerId);
		
		if(null != ort && null != ort.getFlownumber())
		{
			return ort.getFlownumber().intValue();
		}else
		{
			orderMapper.insertFlownumberFromDB2(customerId);
			ort = orderMapper.selectFlownumberFromDB2(customerId);
			return ort.getFlownumber();
		}
	}
	
	
	@Override
	public int updatePickupNoByExample(String pickgoodsno,String ids) {

		try {
			
			String id[] = ids.split(",");
			if (null != id && id.length > 0) {
				for (int i = 0; i < id.length; i++) {
					
					OrderInfo orderinfo = new OrderInfo();
					orderinfo.setOrderid(id[i]);
					orderinfo.setPickgoodsno(pickgoodsno);
					orderMapper.updateByPrimaryKeySelective(orderinfo);
				}

			}
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;

	}
	
	public Map<String,ProvinceCityArea> getProvinceCityAreaMap(){
		Map<String,ProvinceCityArea> pro = new HashMap<String,ProvinceCityArea>();
		List<ProvinceCityArea> all = provinceCityAreaMapper.listAll();
		ProvinceCityArea p =null;
		Map<String,ProvinceCityArea> cityMap = null;
		ProvinceCityArea c = null;
		Map<String,ProvinceCityArea> areaMap = null;
		ProvinceCityArea a = null;
		for(ProvinceCityArea item : all){
			p = pro.get(item.getProvinceName());
			if(null == p){
				p = item;
				pro.put(p.getProvinceName(), p);
			}
			cityMap = p.getChrildrenMap();
			if(null == cityMap){
				cityMap = new HashMap<String,ProvinceCityArea>();
				p.setChrildrenMap(cityMap);
			}
			c = cityMap.get(item.getCityName());
			if(null == c){
				c = item;
				cityMap.put(c.getCityName(), c);
			}
			areaMap = c.getChrildrenMap();
			if(null == areaMap){
				areaMap = new HashMap<String,ProvinceCityArea>();
				c.setChrildrenMap(areaMap);
			}
			a = areaMap.get(item.getAreaName());
			if(null == a){
				areaMap.put(item.getAreaName(), item);
			}
			
		}
		return pro;
	}
	
	@Override
	@Transactional(rollbackFor={Throwable.class})
	public UIReturn releasedByTransactional(String ids,int userid) throws Exception {


		List<OrderInfo> list = selectByExample(ids);
		
		for (OrderInfo order:list)
		{

			if(!"0".equals(order.getStatus()))
			{
				continue;
			}
			
		// 客户id
		int userkey = order.getEntrecordname();

		List<OrderGoods> orderGoodsLst = null;
		try {
			OrderGoodsExample exp = new OrderGoodsExample();
			OrderGoodsExample.Criteria cri = exp.createCriteria();
			cri.andOrderidEqualTo(order.getOrderid());
			orderGoodsLst= orderGoodsMapper.selectByExample(exp);
		} catch (Exception e) {
			e.printStackTrace();
		}

		for (OrderGoods orderGood : orderGoodsLst) {

			Map<String,Integer> param = new HashMap<String,Integer>();
			param.put("goodsid", orderGood.getGoodsid());
			param.put("custid", userkey);

			// 1.查询usergoods,比较总量是否大于订单中的数量，小于则报错
			UserGoods userGoods = orderGoodsMapper.getUserGoodsDetails(param);

			if (null == userGoods.getTotalNo() || userGoods.getTotalNo() < orderGood.getGqty()) {
				
				throw new Exception();
			} else {

				// 2.根据客户id查询所有入库单及入库单中的商品，按批次降序排列
				// 3.更新入库单详情表剩余数量、减去库存总量

				List<IntEntrepotDetail> intEntrepotDetaillst = orderGoodsMapper
						.getOrderEntrepotDetails(param);

				// 本单需要扣除的库存数量
				int outNum = orderGood.getGqty();

				for (IntEntrepotDetail intEntrepotDetail : intEntrepotDetaillst) {

					Map<String,Integer> entrepotDetailParam = new HashMap<String,Integer>();
					entrepotDetailParam.put("id", intEntrepotDetail.getId());

					// 当前批次库存大于本单出库量，则直接更新该批次剩余量
					if (intEntrepotDetail.getCurrentInventory() >= outNum) {
						
						entrepotDetailParam.put("currentInventory",
								intEntrepotDetail.getCurrentInventory()- outNum);
						
						orderGoodsMapper.updateIntEntrepotDetailById(entrepotDetailParam);
						break;
					} else {
						outNum = outNum
								- intEntrepotDetail.getCurrentInventory();
						entrepotDetailParam.put("currentInventory", 0);
						
						orderGoodsMapper.updateIntEntrepotDetailById(entrepotDetailParam);
					}

				}
				
				Map<String,Integer> userGoodsParam = new HashMap<String,Integer>();
				userGoodsParam.put("userkey",userGoods.getUserKey());
				userGoodsParam.put("goodsid",userGoods.getGoodsId());
				userGoodsParam.put("totalno",userGoods.getTotalNo() - orderGood.getGqty());
				
				orderGoodsMapper.updateUserGoodsByUserkeyGoodsid(userGoodsParam);

			}

		}
		  released(order.getOrderid(),userid);
		}
		UIReturn rtn =	new UIReturn();
		rtn.setCode(Const.UI_SUCCESS);
		return rtn;
	}
	
	
	//判断身份证号是否已经被别人使用
	public String isOrderDocidused(String orderdocid, String orderName)
	{
		OrderInfo orderInfo =orderMapper.selectOrderNameByOrderdocid(orderdocid);
		
		if(null == orderInfo)
		{
			return null;
		}
		else if( orderName.equals(orderInfo.getOrdername()))
		{
			return null;
		}else
		{
			return orderInfo.getOrdername();
		}
	}
	
	
}
