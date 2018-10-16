package com.soecode.lyf.utils;



import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * 日期工具类
 * @author denwgen
 */
@SuppressWarnings("unused")
public class DateUtils {
	
	public static void main(String[] args) {
		
	}

	/** 年月日 */
	public static final String YMD = "yyyy-MM-dd";
	
	/** 年月日时分秒 */
	public static final String YMDHMS = "yyyy-MM-dd HH:mm:ss";

	/** 私有构造函数 */
	private DateUtils() {
	};
	
	/** 获取当前时间格式为(yyyy-MM-dd HH:mm:ss) */
	public static String getLocalDate(){
		return format("yyyy-MM-dd HH:mm:ss", new Date()) ;
	}
	
	/** 获取当前时间格式为(yyyy-MM-dd) */
	public static String getLocalYmdDate(){
		return format("yyyy-MM-dd", new Date()) ;
	}

	/** 格式化时间 */
	public static String format(String pattern, Date date) {
		SimpleDateFormat sf = new SimpleDateFormat(pattern);
		return sf.format(date);
	}

	/**
	 * 获取当前系统时间
	 * @author denwgen
	 * @param pattern 日期格式(yyyy-MM-dd HH:mm:ss:SSS)
	 */
	public static String getLocalDate(String pattern) {
		return format(pattern, new Date());
	}

	/**
	 * 字符串转换为日期格式
	 * @param pattern 日期格式(yyyy-MM-dd HH:mm:ss:SSS)
	 * @param date 日期
	 */
	public static Date toDate(String pattern, String date){
		SimpleDateFormat sf = new SimpleDateFormat(pattern);
		try {
			return sf.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 获取前年或者后年
	 * @param time -1或者1
	 * @param pattern 日期格式(yyyy-MM-dd HH:mm:ss:SSS)
	 */
	public static String getYear(String pattern,int time) {
		Calendar c = Calendar.getInstance();
		c.add(Calendar.YEAR, time);
		return format(pattern, c.getTime());
	}

	/**
	 * 获取前月或者后月
	 * @param time -1或者1
	 * @param pattern 日期格式(yyyy-MM-dd HH:mm:ss:SSS)
	 */
	public static String getMonth(String pattern,int time) {
		Calendar c = Calendar.getInstance();
		c.add(Calendar.MONTH, time);
		return format(pattern, c.getTime());
	}

	/**
	 * 获取前天或者后天
	 * @param time -1或者1
	 * @param pattern 日期格式(yyyy-MM-dd HH:mm:ss:SSS)
	 */
	public static String getDate(String pattern,int time) {
		Calendar c = Calendar.getInstance();
		c.add(Calendar.DATE, time);
		return format(pattern, c.getTime());
	}

	/**
	 * 获取前小时或者后小时
	 * @param time -1或者1
	 * @param pattern 日期格式(yyyy-MM-dd HH:mm:ss:SSS)
	 */
	public static String getHour(String pattern,int time) {
		Calendar c = Calendar.getInstance();
		c.add(Calendar.HOUR, time);
		return format(pattern, c.getTime());
	}
	
	/**
	 * 获取前分钟或者后分钟
	 * @param time -1或者1
	 * @param pattern 日期格式(yyyy-MM-dd HH:mm:ss:SSS)
	 */
	public static String getMinute(String pattern,int time) {
		Calendar c = Calendar.getInstance();
		c.add(Calendar.MINUTE, time);
		return format(pattern, c.getTime());
	}
	
	/**
	 * 获取当前月 没有+1
	 * @author dengwen
	 * 2018年1月17日
	 */
	public static int getCurrentMONTH() {
		Calendar c = Calendar.getInstance();
		return c.get(Calendar.MONTH) ;
	}

	/**
	 * 验证两个日期相差天数
	 * @author dengwen
	 * 2017-4-17下午5:49:45
	 */
	public static int daysBetween(Date beginDate, Date endDate) {
		long between_days = 0;
		try {
			Calendar cal = Calendar.getInstance();
			cal.setTime(beginDate);
			long time1 = cal.getTimeInMillis();
			cal.setTime(endDate);
			long time2 = cal.getTimeInMillis();
			between_days = (time2 - time1) / (1000 * 3600 * 24);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Integer.parseInt(String.valueOf(between_days));
	}
	

	
	/**
	 * 
	 * @param minDate 开始时间
	 * @param maxDate 结束时间
	 * @return
	 * @throws ParseException
	 */
	public static List<String> getMonthBetween(String minDate, String maxDate) {
	      ArrayList<String> result = new ArrayList<String>();
	      SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");//格式化为年月
	  
	      Calendar min = Calendar.getInstance();
	      Calendar max = Calendar.getInstance();
	  
	      try {
			min.setTime(sdf.parse(minDate));
			max.setTime(sdf.parse(maxDate));
			} catch (ParseException e) {
				e.printStackTrace();
			}
	      min.set(min.get(Calendar.YEAR), min.get(Calendar.MONTH), 1);
	      max.set(max.get(Calendar.YEAR), max.get(Calendar.MONTH), 2);
	  
	      Calendar curr = min;
	      while (curr.before(max)) {
	       result.add(sdf.format(curr.getTime()));
	       curr.add(Calendar.MONTH, 1);
	      }
	  
	      return result;
	    }
	
}
