package com.ht.excel;

import java.util.List;
import java.util.Map;

public interface RowReader {
	void processRow(int sheetIndex, int curRow, List<String> rowlist, String sheetName);
	int getTotalCount();
	Map<String, Integer> getSheetMap();
}
