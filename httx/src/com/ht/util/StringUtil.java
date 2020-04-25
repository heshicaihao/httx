/**
 * 
 */
package com.ht.util;

import java.io.IOException;
import java.io.Writer;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StringUtil {

	private static final Logger log = LoggerFactory.getLogger(StringUtil.class);

	private static ObjectMapper jsonMapper;

	public static ObjectMapper getJsonMapper() {
		if (null == jsonMapper) {
			jsonMapper = new ObjectMapper();
		}
		return jsonMapper;
	}

	private static final String[] RANDOM_STR = { "1", "2", "3", "4", "5", "6",
			"7", "8", "9", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j",
			"k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w",
			"x", "y", "z" };

	public static boolean isEmpty(String str) {
		return null == str ? true : str.trim().length() == 0;
	}

	public static boolean isEmpty(Map<?, ?> map) {
		return null == map ? true : map.size() == 0;
	}

	public static boolean isEmpty(Collection<?> collection) {
		return null == collection ? true : collection.size() == 0;
	}

	public static boolean isEquals(String str1, String str2) {
		if (isEmpty(str1) && isEmpty(str2)) {
			return true;
		}
		if (null != str1) {
			return str1.equals(str2);
		}
		if (null != str2) {
			return str2.equals(str1);
		}
		return false;
	}

	/**
	 * 生成数据库主键ID 采用日期(17位)加随机数(8位)的方式
	 */
	public static String createId() {
		DateFormat df = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		StringBuffer sb = new StringBuffer();
		sb.append(df.format(Calendar.getInstance().getTime()));
		for (int j = 0; j < 8; j++) {
			sb.append(RANDOM_STR[new Random().nextInt(35)]);
		}
		return (sb.toString());
	}

	/**
	 * Convert Date to String using format yyyy-MM-dd
	 * 
	 * @param date
	 * @return
	 */
	public static String date2String(Date date) {
		if (null != date) {
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			return df.format(date);
		}
		return "";
	}

	public static Date string2Date(String dateStr) {
		if (!StringUtil.isEmpty(dateStr)) {
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			try {
				return df.parse(dateStr);
			} catch (ParseException e) {
				log.error("日期转换失败！{}", dateStr, e);
			}
		}
		return null;
	}

	public static String getHeader(String str) {
		if (isEmpty(str)) {
			return str;
		}
		int index = str.lastIndexOf(".");
		if (index != -1) {
			return str.substring(0, index);
		}
		return str;
	}

	public static String dateTime2String(Date date) {
		if (null != date) {
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			return df.format(date);
		}
		return "";
	}

	public static Date string2DateTime(String dateStr) {
		if (!StringUtil.isEmpty(dateStr)) {
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			try {
				return df.parse(dateStr);
			} catch (ParseException e) {
				log.error("日期转换失败！{}", dateStr, e);
			}
		}
		return null;
	}

	public static String date2String(Date date, String format) {
		DateFormat df = new SimpleDateFormat(format);
		return df.format(date);
	}

	public static String getNowDateString() {
		Date date = new Date();
		DateFormat df = new SimpleDateFormat("yyyyMMddhhmmss");
		return df.format(date);
	}

	public static String formatCode(int num, int value) {
		return String.format("%0" + num + "d", value);
	}

	/**
	 * D+客户编码+四位日期+3位流水号(达到999 从 001开始)。
	 * 
	 * @return
	 */
	public static String getOrderid(String companyCode,Integer customerid,Integer flownum) {
		
		String dateStr =get4Date();

		String flownumStr = formatCode(4, flownum);
		String customeridStr = formatCode(3, customerid);
		return companyCode + customeridStr +dateStr + flownumStr ;
	}

	public static String getCurrentTimestampStr() {
		DateFormat df = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		return df.format(Calendar.getInstance().getTime());
	}

	public static void main(String[] args) {
		System.out.println(get4Date());
	}

	/**
	 *生成商品条码（3位数客户id+4位数流水号+4位数日期 如：14年10月30号 4A30 年第一位数 月份1-9 A:10 B:11 C:12 ）
	 */
	public static String createBarCode(int customerId, int seqNo) {
		String result = null;
		result = StringUtil.formatCode(3, customerId) + StringUtil.get4Date();
		return result;
	}
	
	public static String get4Date(){
		Calendar car = Calendar.getInstance();
		int year = car.get(Calendar.YEAR) % 10;
		int month = car.get(Calendar.MONTH) + 1;
		int day = car.get(Calendar.DATE);
		return year + Integer.toHexString(month).toUpperCase() + StringUtil.formatCode(2, day);
	}
	
	public static String incrementSeq(String str){
		String result = str;
		if(!StringUtil.isEmpty(str)){
			String userId = str.substring(0,4);
			String seqNo = str.substring(4);
			result = userId + StringUtil.formatCode(4, Integer.parseInt(seqNo)+1);
		}
		return result;
	}
	
	public static void toUTF8(HttpServletResponse response, String message)
	{
		try {

			response.setHeader("Content-Type", "application/json;charset=UTF-8");
			Writer writer = response.getWriter();
			writer.write(message);
			writer.flush();
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	 
	/** 获取几位随机数 
	 * */
	public static String getRandom(int k) {
		String tmpRandom = "";
		int iRan = (int) (Math.random() * (Math.pow(10, k)));
		tmpRandom = new Integer(iRan).toString();
		String tmpSpace = "";
		if (tmpRandom.length() < k) {
			int spaceLen = k - tmpRandom.length();
			for (int i = 0; i < spaceLen; i++) {
				tmpSpace += "0";
			}
			tmpRandom = tmpSpace + tmpRandom;
		}
		return tmpRandom;
	}
	
}
