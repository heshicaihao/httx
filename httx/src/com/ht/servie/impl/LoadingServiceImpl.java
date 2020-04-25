package com.ht.servie.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import com.ht.mapper.EwaybillMapper;
import com.ht.mapper.LoadingGoodsMapper;
import com.ht.mapper.LoadingInfoMapper;
import com.ht.mapper.OrderInfoMapper;
import com.ht.model.Ewaybill;
import com.ht.model.EwaybillExample;
import com.ht.model.LoadingGoods;
import com.ht.model.LoadingGoodsExample;
import com.ht.model.LoadingInfo;
import com.ht.model.LoadingOrder;
import com.ht.model.OrderInfo;
import com.ht.model.OrderInfoExample;
import com.ht.model.UIOrder;
import com.ht.model.UIReturn;
import com.ht.servie.LoadingService;
import com.ht.util.Const;
import com.ht.util.HTException;
import com.ht.util.StringUtil;

@Service
public class LoadingServiceImpl implements LoadingService {

	private static final Logger log = LoggerFactory.getLogger(LoadingServiceImpl.class);
	
	@Autowired 
	private LoadingInfoMapper loadinginfoMapper;
	@Autowired 
	private LoadingGoodsMapper loadingGoodsMapper;
	@Autowired
	private EwaybillMapper ewaybillMapper;
	@Autowired
	private OrderInfoMapper orderMapper;

	@Autowired
	private PlatformTransactionManager transactionManager;

	@Autowired
	private SqlSessionFactory sqlSessionFactory;
	
	@Override
	@Transactional(rollbackFor={Throwable.class})
	public UIReturn save(LoadingInfo loadingInfo){

		UIReturn rtn = new UIReturn();
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");// 用来格式化时间
		String orderids = loadingInfo.getOrderids();
		List<OrderInfo> orderList = selectGoodsByExample(orderids);
		if (!StringUtil.isEmpty(orderList)) {
			String orderNO = "";
			for (OrderInfo oderInfo : orderList) {
				try {
					if (!StringUtil.isEmpty(oderInfo.getOrderid())) {
						orderNO += oderInfo.getOrderid() + ",";
					}
				} catch (Exception ex) {
					// log.error("return to front UI fail.",ex);
				}
				rtn.setErrorMsg("该订单号"
						+ orderNO.substring(0, orderNO.length() - 1)
						+ "已被装载了，请勿重复装载");
			}
		} else {
			Date date = new Date();
			String radom = StringUtil.getRandom(4);// 4位随机数
			String loadNo = df.format(date) + radom;
			loadingInfo.setVename(loadingInfo.getVename());

			loadingInfo.setInputdate(date);
			loadingInfo.setLoadingdate(date);
			loadingInfo.setLoading_no(loadNo);
			loadinginfoMapper.insert(loadingInfo);
			int loadingId = loadingInfo.getId();

			OrderInfoExample exp = new OrderInfoExample();
			OrderInfoExample.Criteria cri = exp.createCriteria();
			String id[] = orderids.split(",");
			List<String> list = new ArrayList<String>();
			if (null != id && id.length > 0) {
				for (int i = 0; i < id.length; i++) {
					list.add(id[i]);
				}

			}
			cri.andOrderidIn(list);
			List<OrderInfo> orderList2 = orderMapper.selectByExample(exp);
			for (OrderInfo order : orderList2) {
				LoadingGoods loadingGoods = new LoadingGoods();
				loadingGoods.setLoadingid(loadingId);
				loadingGoods.setOrderid(order.getOrderid());
				saveLoadingGoods(loadingGoods);
				OrderInfo obj = orderMapper.selectByPrimaryKey(order.getOrderid());
				obj.setLoading_no(loadNo);
				orderMapper.updateByPrimaryKeySelective(obj);
			}
		}
		rtn.setCode(Const.UI_SUCCESS);
		rtn.setSuccess(true);
		return rtn;
	}
	@Override
	public UIReturn saveLoadingGoods(LoadingGoods loadingGoods){

		UIReturn rtn = new UIReturn();

		loadingGoodsMapper.insert(loadingGoods);

		rtn.setCode(Const.UI_SUCCESS);
		rtn.setSuccess(true);
		return rtn;
	}
	@Override
	public UIReturn saveEdit(OrderInfo orderEntity){
		UIReturn rtn = new UIReturn();
		
//		orderMapper.updateByPrimaryKeySelective(orderEntity);

		rtn.setCode(Const.UI_SUCCESS);
		rtn.setSuccess(true);
		return rtn;
	}
	@Override
	public List<LoadingGoods> getDetails(List<String> orderIdlist) {
		try {
			return loadingGoodsMapper.getGoodsDetails(orderIdlist);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public List<LoadingGoods>  getLoadingIds(List<String> orderIdlist) {
		try {
			return loadingGoodsMapper.getLoadingIds(orderIdlist);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public LoadingInfo getByKey(String id) {
		// TODO Auto-generated method stub
		return loadinginfoMapper.selectByPrimaryKey(Integer.parseInt(id));
	}

	@Override
	public LoadingGoods getLoadingGoodsByKey(String id) {
		// TODO Auto-generated method tub
		return loadingGoodsMapper.selectByPrimaryKey(Integer.parseInt(id));
	}

	

	@Override
	public List<LoadingOrder> listPage(OrderInfo order) {
		List<LoadingOrder> result = new ArrayList<LoadingOrder>();
		try {
			Map<String,Object> dataMap = new HashMap<String,Object>();
			if (!StringUtil.isEmpty(order.getStartDateStr())) {
				dataMap.put("startDate",StringUtil
						.string2DateTime(order.getStartDateStr()));
			}
			if (!StringUtil.isEmpty(order.getEndDateStr())) {
				dataMap.put("endDate",StringUtil
						.string2DateTime(order.getEndDateStr()));
			}
			if(StringUtil.isEmpty(order.getUnloading())){
				dataMap.put("unloading", null);
			}else{
				dataMap.put("unloading",order.getUnloading());
			}
			if(!StringUtil.isEmpty(order.getOrderid())){
				dataMap.put("orderIdLike", "%" + order.getOrderid().toUpperCase() + "%");
			}
			if(!StringUtil.isEmpty(order.getLoading_no())){
				dataMap.put("loadingNoLike", "%" + order.getLoading_no().toUpperCase() + "%");
			}
			return orderMapper.listLoadingPage(dataMap);
		} catch (Exception ex) {
			log.error("List Product page fail.", ex);
		}
		return result;
	}

	@Override
	public UIReturn delete(String orderid) {
		UIReturn rtn = new UIReturn();
		try{
//				orderMapper.deleteByPrimaryKey(orderid);
				rtn.setCode(Const.UI_SUCCESS);
		}catch(Exception ex){
			rtn.setCode(Const.UI_ERROR);
			rtn.setSuccess(false);
			rtn.setErrorMsg(ex.getMessage());
			log.error("删除商品信息失败！id=" + orderid,ex);
		}
		return rtn;
	}

	   @Override
	    public UIReturn cancel(String orderid) {
	        UIReturn rtn = new UIReturn();
	        try{
	        	OrderInfo order =new OrderInfo();
	            order.setOrderid(orderid);
	            order.setOrderstatus("C");
//	            orderMapper.updateByPrimaryKeySelective(order);
	                rtn.setCode(Const.UI_SUCCESS);
	        }catch(Exception ex){
	            rtn.setCode(Const.UI_ERROR);
	            rtn.setSuccess(false);
	            rtn.setErrorMsg(ex.getMessage());
	            log.error("取消订单信息失败！id=" + orderid,ex);
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
	public List<OrderInfo> selectGoodsByExample(String orderIds) {

		try {
			OrderInfoExample exp = new OrderInfoExample();
			OrderInfoExample.Criteria cri = exp.createCriteria();
			String id[] = orderIds.split(",");
			List<String> list = new ArrayList<String>();
			if (null != id && id.length > 0) {
				for (int i = 0; i < id.length; i++) {
					list.add(id[i]);
				}

			}
			cri.andOrderidIn(list);
			//cri.andLoadNoIsNotNull();
			cri.andLoadNoGreaterThan("");
			return orderMapper.selectByExample(exp);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}
	@Override
	public List<Ewaybill> selectEwayByExample(String ids) {

		try {
			EwaybillExample exp = new EwaybillExample();
			EwaybillExample.Criteria cri = exp.createCriteria();
			String id[] = ids.split(",");
			List<Integer> list = new ArrayList<Integer>();
			if (null != id && id.length > 0) {
				for (int i = 0; i < id.length; i++) {
					list.add(Integer.parseInt(id[i]));
				}

			}
			cri.andOrderidIn(list);
			return ewaybillMapper.selectByExample(exp);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}
	
	@Override
	public List<LoadingGoods> selectLoadingGoodsByExample(String ids) {

		try {
			LoadingGoodsExample exp = new LoadingGoodsExample();
			LoadingGoodsExample.Criteria cri = exp.createCriteria();
			String id[] = ids.split(",");
			List<String> list = new ArrayList<String>();
			if (null != id && id.length > 0) {
				for (int i = 0; i < id.length; i++) {
					list.add(id[i].toString());
				}

			}
			cri.andOrderidIn(list);
			return loadingGoodsMapper.selectByExample(exp);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}
	@Override
	public void closeOrder(String ids) throws HTException {
		UIReturn rtn = new UIReturn();
		if(!StringUtil.isEmpty(ids)){
			String[] idArr = ids.split(",");
			TransactionDefinition definition = new DefaultTransactionDefinition(TransactionDefinition.PROPAGATION_REQUIRED);
			TransactionStatus status = transactionManager.getTransaction(definition);
			UIOrder ui = null;
			String transInstKey = StringUtil.createId();
			try {
				SqlSession session = sqlSessionFactory.openSession(ExecutorType.BATCH,false);
				LoadingInfoMapper uiMaper = session.getMapper(LoadingInfoMapper.class);
				for(int i = 0; i < idArr.length; i++){
					ui = new UIOrder();
					ui.setOrderId(idArr[i]);
					ui.setTransInstKey(transInstKey);
					uiMaper.addUIOrderId(ui);
					if((i+1) % 500 == 0){
						session.commit();
						session.clearCache();
					}
				}
				if((idArr.length+1)%500 > 0){
					session.commit();
					session.clearCache();
				}
				log.debug("Finish insert close order UI, total:" + idArr.length);
				session.close();
				transactionManager.commit(status);
			} catch (Exception ex) {
				transactionManager.rollback(status);
				throw new IllegalStateException(ex);
			}
			List<String> checkList = loadinginfoMapper.checkUnloading(transInstKey);
			if(!StringUtil.isEmpty(checkList)){
				StringBuffer sb = new StringBuffer();
				for(int i = 0, count = checkList.size(); i < count; i++){
					if(i == 0){
						sb.append(checkList.get(i));
					}else{
						sb.append(", ");
						if((i+1)%3==0){
							sb.append("<br />");
						}
						sb.append(checkList.get(i));
					}
					
				}
				loadinginfoMapper.cleanUI(transInstKey);
				throw new HTException("以下订单未生成装载单，不能关闭订单：" + sb.toString());
			}
			
			TransactionDefinition definition2 = new DefaultTransactionDefinition(TransactionDefinition.PROPAGATION_REQUIRED);
			TransactionStatus status2 = transactionManager.getTransaction(definition2);
			try{
				loadinginfoMapper.closeOrderBatch(transInstKey);
				rtn.setCode(0);
				rtn.setSuccess(true);
				loadinginfoMapper.cleanUI(transInstKey);
				transactionManager.commit(status2);
			} catch (Exception ex) {
				transactionManager.rollback(status2);
				throw new IllegalStateException(ex);
			}
		}
	}
}
