package com.ht.util;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ReflectUtil {
	
	private static final Logger log = LoggerFactory.getLogger(ReflectUtil.class);

	public static Map<String,Method> getMethods(Class<?> type){
		if(null == type){
			return null;
		}
		Method[] meds = type.getDeclaredMethods();
		Map<String,Method> result = new HashMap<String,Method>();
		for(Method med : meds){
			result.put(med.getName().toLowerCase(), med);
		}
		return result;
	}
	
	public static void invoke(Object obj,Method med,Object... params){
		if(null == med){
			throw new IllegalArgumentException("Param med can't be null!");
		}
		try {
			med.invoke(obj, params);
		} catch (IllegalArgumentException e) {
			log.error("Mehtod invoke faild.{}",params,e);
			throw e;
		} catch (IllegalAccessException e) {
			log.error("Mehtod invoke faild.{}",med.getName());
		} catch (InvocationTargetException e) {
			log.error("Mehtod invoke faild.{},target:{}",med.getName(),obj);
		}
	}
}
