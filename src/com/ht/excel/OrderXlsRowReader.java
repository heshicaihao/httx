package com.ht.excel;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ht.model.ProvinceCityArea;
import com.ht.model.reportmodel.ImportOrderGoods;
import com.ht.util.StringUtil;

public class OrderXlsRowReader implements RowReader {

	private int total;

	private final Map<String,Integer> sheetMap = new HashMap<String,Integer>();

	private final List<ImportOrderGoods> datas = new ArrayList<ImportOrderGoods>();
	
	private Map<String,Integer> provinceMap = null;
	
	private Map<String,Integer> cityMap = null;
	
	private Map<String,Integer> areaMap = null;
	private Map<String,ProvinceCityArea> proMap;
	@Override
	public void processRow(int sheetIndex, int curRow, List<String> rowlist, String sheetName) {

		if(null == sheetName || "".equals(sheetName)){
			return;
		}
		if(rowlist.size() > 17){
			throw new IllegalArgumentException("格式与模板不匹配，请使用模板！");
		}
		int startIndex = 1;
		ImportOrderGoods d = null;
		ProvinceCityArea province = null;
		ProvinceCityArea city = null;
		ProvinceCityArea area = null;
		if(curRow >= startIndex ){
			if(rowlist.size() != 17){
				for(int j = rowlist.size(); j<17; j++){
					rowlist.add("");
				}
			}
			d = new ImportOrderGoods();
			d.setEntrecordno(rowlist.get(0));
			d.setOrdername(rowlist.get(1));
			if(!StringUtil.isEmpty(rowlist.get(2)))
			{
				d.setOrderdocid(rowlist.get(2).toUpperCase());
			}
			province = proMap.get(rowlist.get(3));
			
			if(null == province){
				throw new IllegalArgumentException(String.format("没有找到第%d行中匹配的省份[%s]对应的编码!", curRow+1,rowlist.get(3)));
			}
			d.setProvinceId(province.getProvinceId());
			String provinceName =rowlist.get(3);
			if("台湾省".equals(provinceName) || "香港特别行政区".equals(provinceName)|| "澳门特别行政区".equals(provinceName))
			{
				
			}else
			{
				String cityName =rowlist.get(4);
				city = province.getChrildrenMap().get(cityName);
				if(null == city){
					throw new IllegalArgumentException(String.format("没有找到匹配%s的城市[%s]对应的编码!", rowlist.get(3),rowlist.get(4)));
				}
				d.setCityId(city.getCityId());
				
				/*area = city.getChrildrenMap().get(rowlist.get(5));
				if(null == area){
					throw new IllegalArgumentException(String.format("没有找到匹配[%s]的城市[%s]的[%s]对应的编码!", rowlist.get(3),rowlist.get(4),rowlist.get(5)));
				}
				d.setAreaId(area.getAreaId());*/
				area = city.getChrildrenMap().get(rowlist.get(5));
				if(null != area){
					d.setAreaId(area.getAreaId());
				}
			}
						
			d.setOrderaddress(rowlist.get(6));
			d.setOrderphone(rowlist.get(7));
			d.setWaybillno(rowlist.get(8));
			d.setNoticeno(rowlist.get(9));
			try{
				if(!StringUtil.isEmpty(rowlist.get(10))){
					d.setFreight(new BigDecimal(rowlist.get(10)));
				}
				if(!StringUtil.isEmpty(rowlist.get(11))){
					d.setValuationfee(new BigDecimal(rowlist.get(11)));
				}
				if(!StringUtil.isEmpty(rowlist.get(12))){
					d.setTax(new BigDecimal(rowlist.get(12)));
				}
				if(!StringUtil.isEmpty(rowlist.get(14))){
					d.setGqty(Integer.parseInt(rowlist.get(14)));
				}
				if(!StringUtil.isEmpty(rowlist.get(15))){
					d.setDecprice(new BigDecimal(rowlist.get(15)));
				}
			}catch(NumberFormatException ex){
				throw new IllegalArgumentException(String.format("第%d行数值单元格中，只能输入有效的数值！",curRow+1));
			}
			d.setInstkey(rowlist.get(13));
			d.setNote(rowlist.get(16));
			datas.add(d);
		}
		total += 1;
	}

	@Override
	public int getTotalCount() {
		// TODO Auto-generated method stub
		return total;
	}
	
	public void initProvinceCityArea(List<ProvinceCityArea> provinceList,List<ProvinceCityArea> cityList,List<ProvinceCityArea> areaList){
		Map<String,ProvinceCityArea> provinceMap = new HashMap<String,ProvinceCityArea>();
		ProvinceCityArea pro = null;
		for(int i = 0, count = provinceList.size(); i < count; i++){
			pro = provinceList.get(i);
			provinceMap.put(pro.getName(), pro);
		}
		
		Map<Integer,ProvinceCityArea> areaMap = new HashMap<Integer,ProvinceCityArea>();
		for(ProvinceCityArea area:areaList){
			areaMap.put(area.getId(), area);
		}
	}

	/**
	 * @return the sheetMap
	 */
	@Override
	public Map<String, Integer> getSheetMap() {
		return sheetMap;
	}

	public List<ImportOrderGoods> getDatas() {
		return datas;
	}

	public Map<String, Integer> getProvinceMap() {
		return provinceMap;
	}

	public void setProvinceMap(List<ProvinceCityArea> provinceList) {
		if(!StringUtil.isEmpty(provinceList)){
			this.provinceMap = new HashMap<String,Integer>();
			for(ProvinceCityArea data : provinceList){
				this.provinceMap.put(data.getName(), data.getId());
			}
		}
	}

	public Map<String, Integer> getCityMap() {
		return cityMap;
	}

	public void setCityMap(List<ProvinceCityArea> cityList) {
		if(!StringUtil.isEmpty(cityList)){
			this.cityMap = new HashMap<String,Integer>();
			for(ProvinceCityArea data : cityList){
				this.cityMap.put(data.getName(), data.getId());
			}
		}
	}

	public Map<String, Integer> getAreaMap() {
		return areaMap;
	}

	public void setAreaMap(List<ProvinceCityArea> areaList) {
		if(!StringUtil.isEmpty(areaList)){
			this.areaMap = new HashMap<String,Integer>();
			for(ProvinceCityArea data : areaList){
				this.areaMap.put(data.getName(), data.getId());
			}
		}
	}

	public Map<String, ProvinceCityArea> getProMap() {
		return proMap;
	}

	public void setProMap(Map<String, ProvinceCityArea> proMap) {
		this.proMap = proMap;
	}
}
