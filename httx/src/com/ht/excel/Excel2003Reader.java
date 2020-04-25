package com.ht.excel;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.eventusermodel.EventWorkbookBuilder.SheetRecordCollectingListener;
import org.apache.poi.hssf.eventusermodel.FormatTrackingHSSFListener;
import org.apache.poi.hssf.eventusermodel.HSSFEventFactory;
import org.apache.poi.hssf.eventusermodel.HSSFListener;
import org.apache.poi.hssf.eventusermodel.HSSFRequest;
import org.apache.poi.hssf.eventusermodel.MissingRecordAwareHSSFListener;
import org.apache.poi.hssf.eventusermodel.dummyrecord.LastCellOfRowDummyRecord;
import org.apache.poi.hssf.eventusermodel.dummyrecord.MissingCellDummyRecord;
import org.apache.poi.hssf.model.HSSFFormulaParser;
import org.apache.poi.hssf.record.BOFRecord;
import org.apache.poi.hssf.record.BlankRecord;
import org.apache.poi.hssf.record.BoolErrRecord;
import org.apache.poi.hssf.record.BoundSheetRecord;
import org.apache.poi.hssf.record.FormulaRecord;
import org.apache.poi.hssf.record.LabelRecord;
import org.apache.poi.hssf.record.LabelSSTRecord;
import org.apache.poi.hssf.record.NumberRecord;
import org.apache.poi.hssf.record.Record;
import org.apache.poi.hssf.record.SSTRecord;
import org.apache.poi.hssf.record.StringRecord;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

public class Excel2003Reader implements HSSFListener {

	private POIFSFileSystem fs;

	private int lastRowNumber;

	@SuppressWarnings("unused")
	private int lastColumnNumber;

	/** Should we output the formula, or the value it has? */
	private final boolean outputFormulaValues = true;

	/** For parsing Formulas */
	private SheetRecordCollectingListener workbookBuildingListener;
	//excel2003
	private HSSFWorkbook stubWorkbook;

	// Records we pick up as we process
	private SSTRecord sstRecord;
	private FormatTrackingHSSFListener formatListener;

	private int sheetIndex = -1;
	private BoundSheetRecord[] orderedBSRs;

	private final ArrayList<BoundSheetRecord> boundSheetRecords = new ArrayList<BoundSheetRecord>();

	// For handling formulas with string results
	private int nextRow;
	private int nextColumn;
	private boolean outputNextStringRecord;

	private int curRow = 0;
	//row values
	private final List<String> rowlist = new ArrayList<String>();;

	private String sheetName;

	private RowReader rowReader;


	public void setRowReader(RowReader rowReader){
		this.rowReader = rowReader;
	}

	/**
	 * Iterate all sheets
	 * @throws IOException
	 */
	public void process(InputStream is) throws IOException {
		this.fs = new POIFSFileSystem(is);
		MissingRecordAwareHSSFListener listener = new MissingRecordAwareHSSFListener(
				this);
		formatListener = new FormatTrackingHSSFListener(listener);
		HSSFEventFactory factory = new HSSFEventFactory();
		HSSFRequest request = new HSSFRequest();
		if (outputFormulaValues) {
			request.addListenerForAllRecords(formatListener);
		} else {
			workbookBuildingListener = new SheetRecordCollectingListener(
					formatListener);
			request.addListenerForAllRecords(workbookBuildingListener);
		}
		factory.processWorkbookEvents(request, fs);
	}

	/**
	 * HSSFListener Record
	 */
	@Override
	public void processRecord(Record record) {
		int thisRow = -1;
		int thisColumn = -1;
		String thisStr = null;
		String value = null;
		switch (record.getSid()) {
			case BoundSheetRecord.sid:
				//BoundSheetRecord bsr = (BoundSheetRecord)record;
				//if(bsr.getSheetname().indexOf("Report") != -1){
					boundSheetRecords.add((BoundSheetRecord)record);
				//}
				break;
			case BOFRecord.sid:
				BOFRecord br = (BOFRecord) record;
				if (br.getType() == BOFRecord.TYPE_WORKSHEET) {
					// for sub work book
					if (workbookBuildingListener != null && stubWorkbook == null) {
						stubWorkbook = workbookBuildingListener.getStubHSSFWorkbook();
					}

					sheetIndex++;
					if (orderedBSRs == null) {
						orderedBSRs = BoundSheetRecord.orderByBofPosition(boundSheetRecords);
					}
					sheetName = orderedBSRs[sheetIndex].getSheetname();
				}
				break;

			case SSTRecord.sid:
				sstRecord = (SSTRecord) record;
				break;

			case BlankRecord.sid:
				BlankRecord brec = (BlankRecord) record;
				thisRow = brec.getRow();
				thisColumn = brec.getColumn();
				thisStr = "";
				rowlist.add(thisColumn, thisStr);
				break;
			case BoolErrRecord.sid: //boolean cell
				BoolErrRecord berec = (BoolErrRecord) record;
				thisRow = berec.getRow();
				thisColumn = berec.getColumn();
				thisStr = berec.getBooleanValue()+"";
				rowlist.add(thisColumn, thisStr);
				break;

			case FormulaRecord.sid: //for formula cell
				FormulaRecord frec = (FormulaRecord) record;
				thisRow = frec.getRow();
				thisColumn = frec.getColumn();
				if (outputFormulaValues) {
					if (Double.isNaN(frec.getValue())) {
						// Formula result is a string
						// This is stored in the next record
						outputNextStringRecord = true;
						nextRow = frec.getRow();
						nextColumn = frec.getColumn();
					} else {
						thisStr = formatListener.formatNumberDateCell(frec);
					}
				} else {
					thisStr = '"' + HSSFFormulaParser.toFormulaString(stubWorkbook,
							frec.getParsedExpression()) + '"';
				}
				rowlist.add(thisColumn,thisStr);
				break;
			case StringRecord.sid://formula string
				if (outputNextStringRecord) {
					// String for formula
					StringRecord srec = (StringRecord) record;
					thisStr = srec.getString();
					thisRow = nextRow;
					thisColumn = nextColumn;
					outputNextStringRecord = false;
				}
				break;
			case LabelRecord.sid:
				LabelRecord lrec = (LabelRecord) record;
				curRow = thisRow = lrec.getRow();
				thisColumn = lrec.getColumn();
				value = lrec.getValue().trim();
				this.rowlist.add(thisColumn, value);
				break;
			case LabelSSTRecord.sid:  //string cell
				LabelSSTRecord lsrec = (LabelSSTRecord) record;
				curRow = thisRow = lsrec.getRow();
				thisColumn = lsrec.getColumn();
				if (sstRecord == null) {
					rowlist.add(thisColumn, "");
				} else {
					value =  sstRecord.getString(lsrec.getSSTIndex()).toString().trim();
					rowlist.add(thisColumn,value);
				}
				break;
			case NumberRecord.sid:  //number cell
				NumberRecord numrec = (NumberRecord) record;
				curRow = thisRow = numrec.getRow();
				thisColumn = numrec.getColumn();
				value = formatListener.formatNumberDateCell(numrec).trim();
				rowlist.add(thisColumn, value);
				break;
			default:
				break;
		}

		// new row start
		if (thisRow != -1 && thisRow != lastRowNumber) {
			lastColumnNumber = -1;
		}

		// null cell
		if (record instanceof MissingCellDummyRecord) {
			MissingCellDummyRecord mc = (MissingCellDummyRecord) record;
			curRow = thisRow = mc.getRow();
			thisColumn = mc.getColumn();
			rowlist.add(thisColumn,"");
		}

		// update row and column
		if (thisRow > -1)
			lastRowNumber = thisRow;
		if (thisColumn > -1)
			lastColumnNumber = thisColumn;

		// last column
		if (record instanceof LastCellOfRowDummyRecord) {
			lastColumnNumber = -1;
			rowReader.processRow(sheetIndex,curRow, rowlist,sheetName);
			rowlist.clear();
		}
	}
}
