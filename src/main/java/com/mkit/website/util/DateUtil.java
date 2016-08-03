package com.mkit.website.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {
	private static final String[] WEEKDAYS_CN = {"星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"};
	
	private static final String[] WEEKDAYS_EN = {"sunday", "monday", "tuesday", "wednesday", "thursday", "friday", "saturday"};
	
	public static String getENWeekDay() {
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());

        int w = cal.get(Calendar.DAY_OF_WEEK) - 1;
        if (w < 0)
            w = 0;

        return WEEKDAYS_EN[w];
	}
	
	public static String getCNWeekDay() {
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());

        int w = cal.get(Calendar.DAY_OF_WEEK) - 1;
        if (w < 0)
            w = 0;

        return WEEKDAYS_CN[w];
	}
	
	public static int getWeekDay(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);

        int w = cal.get(Calendar.DAY_OF_WEEK) - 1;
        if (w <= 0)
            w = 7;

        return w;
	}
	
	public static String getCurrentHour() {
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		
		return String.valueOf(cal.get(Calendar.HOUR_OF_DAY));
	}
	
	public static String getBeforeOneHour() {
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		
		return String.valueOf(cal.get(Calendar.HOUR_OF_DAY) == 0 
				? 23 : cal.get(Calendar.HOUR_OF_DAY) - 1);
	}
	public static final String YYYYMMDDHHMMSS = "yyyy-MM-dd HH:mm:ss";
	public static final String YYYYMMDD = "yyyy-MM-dd";
	public static final String YYYYMMDD2 = "yyyyMMdd";
	
	
	/**
	 * 日期转换成字符串 
	 * @param date  日期
	 * @param format 转换格式
	 * @return
	 */
	public static String format(Date date,String format){
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.format(date);
	}
	
	
	/**
	 * 获得格式化时间
	 * 
	 * @param date
	 *            日期
	 * @param pattern
	 *            格式
	 * @return String
	 * @throws ParseException
	 */
	public static Date stringToDate(String strDate, String pattern)
			throws ParseException {
		if ("".equals(strDate.trim()))
			return null;
		SimpleDateFormat df = new SimpleDateFormat(pattern);
		Date d = df.parse(strDate);
		return d;
	}
	
	
	public static void main(String[] args) throws Exception {
		String str = "2012-03-01";
		Date d = stringToDate(str,"yyyy-MM-dd");
		System.out.println(d);
	}
}
