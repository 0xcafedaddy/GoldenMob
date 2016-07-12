package com.mkit.website.util;

public class TransToString {
	
	
	/**
	 * 将Object对象转换为String
	 * @param obj
	 * @return
	 */
	public static String getString(Object obj){
		if(obj != null && obj instanceof String){			
			return obj.toString();
		}
		return null;
	}

}
