package com.ht.excel;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ht.model.DictData;
import com.ht.model.Goods;
import com.ht.util.StringUtil;

public class GoodsXlsRowReader implements RowReader {

	private int total;

	private final Map<String,Integer> sheetMap = new HashMap<String,Integer>();

	private final List<Goods> datas = new ArrayList<Goods>();
	
	private Map<String,String> countryMap;
	private Map<String,String> currMap;
	private Map<String,String> unitMap;

	@Override
	public void processRow(int sheetIndex, int curRow, List<String> rowlist, String sheetName) {

		if(null == sheetName || "".equals(sheetName) || sheetIndex > 0){
			return;
		}
		if(curRow == 0 && rowlist.size() != 25){
			throw new IllegalArgumentException("格式与模板不匹配，请使用模板！");
		}
		int startIndex = 1;
		Goods g = null;
		if(curRow >= startIndex ){
			if(rowlist.size() != 25){
				for(int j = rowlist.size(); j<25; j++){
					rowlist.add("");
				}
			}
			if(rowlist.size() < 19){
				throw new IllegalArgumentException(String.format("在第%d行中,商品链接不能为空",curRow+1));
			}
			g = new Goods();
			if(StringUtil.isEmpty(rowlist.get(0))){
				throw new IllegalArgumentException(String.format("在第%d行中，货号不能为空!",curRow+1));
			}
			g.setCopgno(rowlist.get(0));
			g.setSellid(rowlist.get(1));
			g.setGoodsenname(rowlist.get(2));
			g.setGname(rowlist.get(3));
			if(null == countryMap.get(rowlist.get(4))){
				throw new IllegalArgumentException(String.format("在第%d行中，无法找国家[%s]对应的国家代码",curRow+1,rowlist.get(4)));
			}
			g.setCountry(countryMap.get(rowlist.get(4)));
			if(null == currMap.get(rowlist.get(5))){
				throw new IllegalArgumentException(String.format("在第%d行中，无法找币制[%s]对应的代码",curRow+1,rowlist.get(5)));
			}
			g.setCurr(currMap.get(rowlist.get(5)));
			g.setDecprice(BigDecimal.valueOf(Double.parseDouble(rowlist.get(6))));
			if(null == unitMap.get(rowlist.get(7))){
				throw new IllegalArgumentException(String.format("在第%d行中，无法找计量单位[%s]对应的代码",curRow+1,rowlist.get(7)));
			}
			g.setUnit(unitMap.get(rowlist.get(7)));
			g.setRmb(rowlist.get(8));
			g.setNetwt(BigDecimal.valueOf(Double.parseDouble(rowlist.get(9))));
			g.setGrosswt(BigDecimal.valueOf(Double.parseDouble(rowlist.get(10))));
			g.setPingming(rowlist.get(11));
			g.setYongtu(rowlist.get(12));
			g.setGmodel(rowlist.get(13));
			g.setBrand(rowlist.get(14));
			g.setChengfen(rowlist.get(15));
			g.setManufactory(rowlist.get(16));
			g.setNetworksellname(rowlist.get(17));
			g.setHyperlink(rowlist.get(18));
			/*HS编码	行邮税号	行邮税名称	海关备案号	商检备案号	批次号*/
			g.setHscode(rowlist.get(19));
			g.setPosttariffcode(rowlist.get(20));
			g.setPosttariffname(rowlist.get(21));
			g.setRegistno(rowlist.get(22));
			g.setCiqgoodsno(rowlist.get(23));
			g.setBatchid(rowlist.get(24));
			datas.add(g);
		}
		total += 1;
	}

	@Override
	public int getTotalCount() {
		// TODO Auto-generated method stub
		return total;
	}

	/**
	 * @return the sheetMap
	 */
	@Override
	public Map<String, Integer> getSheetMap() {
		return sheetMap;
	}

	public List<Goods> getDatas() {
		return datas;
	}

	public Map<String, String> getCountryMap() {
		return countryMap;
	}

	public void setCountryMap(List<DictData> countryList) {
		if(!StringUtil.isEmpty(countryList)){
			this.countryMap = new HashMap<String,String>();
			for(DictData data : countryList){
				this.countryMap.put(data.getCodeName(), data.getCodeNo());
			}
		}
	}

	public Map<String, String> getCurrMap() {
		return currMap;
	}

	public void setCurrMap(List<DictData> currList) {
		if(!StringUtil.isEmpty(currList)){
			this.currMap = new HashMap<String,String>();
			for(DictData data : currList){
				this.currMap.put(data.getCodeName(), data.getCodeNo());
			}
		}
	}

	public Map<String, String> getUnitMap() {
		return unitMap;
	}

	public void setUnitMap(List<DictData> unitList) {
		if(!StringUtil.isEmpty(unitList)){
			this.unitMap = new HashMap<String,String>();
			for(DictData data : unitList){
				this.unitMap.put(data.getCodeName(), data.getCodeNo());
			}
		}
	}
	
}
