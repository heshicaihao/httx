package com.ht.excel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ht.model.IntEntrepotDetail;

public class XlsRowReader implements RowReader {

	private int total;

	private final Map<String,Integer> sheetMap = new HashMap<String,Integer>();

	private final List<IntEntrepotDetail> datas = new ArrayList<IntEntrepotDetail>();

	@Override
	public void processRow(int sheetIndex, int curRow, List<String> rowlist, String sheetName) {

		if(null == sheetName || "".equals(sheetName)){
			return;
		}
		if(rowlist.size() > 3){
			throw new IllegalArgumentException("格式与模板不匹配，请使用模板！");
		}
		int startIndex = 1;
		IntEntrepotDetail d = null;
		if(curRow >= startIndex ){
			d = new IntEntrepotDetail();
			d.setUsergoodscode(rowlist.get(0));
			d.setGqty(Integer.parseInt(rowlist.get(1)));
			if(rowlist.size() == 3){
				d.setNote(rowlist.get(2));
			}
			datas.add(d);
			total += 1;
		}
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

	public List<IntEntrepotDetail> getDatas() {
		return datas;
	}
}
