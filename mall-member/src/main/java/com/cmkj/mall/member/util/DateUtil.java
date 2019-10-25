package com.cmkj.mall.member.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.time.DateUtils;

public class DateUtil {
	private final static SimpleDateFormat sdfYear = new SimpleDateFormat("yyyy");
	
	private final static SimpleDateFormat sdfYearMonth = new SimpleDateFormat("yyyyMM");

	private final static SimpleDateFormat sdfDay = new SimpleDateFormat("yyyy-MM-dd");
	
	private final static SimpleDateFormat sdfYearMonthDay = new SimpleDateFormat("yyyy/MM/dd");

	private final static SimpleDateFormat sdfday = new SimpleDateFormat("dd");
	
	private final static SimpleDateFormat sdfDays = new SimpleDateFormat("yyyyMMdd");

	private final static SimpleDateFormat sdfTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	private final static SimpleDateFormat sdfTimes = new SimpleDateFormat("yyyyMMddHHmmss");
	
	private final static SimpleDateFormat sdfMonth = new SimpleDateFormat("MM");

	/**
	 * 获取YYYY格式
	 * 
	 * @return
	 */
	public static String getYear() {
		return sdfYear.format(new Date());
	}

	/**
	 * 获取dd格式
	 * 
	 * @return
	 */
	public static String getday() {
		return sdfday.format(new Date());
	}
	
	/**
	 * 获取YYYY-MM-DD格式
	 * 
	 * @return
	 */
	public static String getDay() {
		return sdfDay.format(new Date());
	}

	/**
	 * 获取YYYYMMDD格式
	 * 
	 * @return
	 */
	public static String getDays() {
		return sdfDays.format(new Date());
	}

	/**
	 * 获取YYYY-MM-DD格式
	 * 
	 * @return
	 */
	public static String getDay(Date d) {
		return sdfDay.format(d);
	}
	
	/**
	 * 获取YYYY-MM-DD格式
	 * 
	 * @return
	 */
	public static String getYMDay(Date d) {
		return sdfYearMonthDay.format(d);
	}
	
	/**
	 * 获取YYYYMM格式
	 * @param d
	 * @return
	 */
	public static String getYearMonth(Date d){
		return sdfYearMonth.format(d);
	}
	
	/**
	 * 获取MM格式
	 * @param d
	 * @return
	 */
	public static String getMonth(Date d){
		return sdfMonth.format(d);
	}

	/**
	 * 获取YYYY-MM-DD HH:mm:ss格式
	 * 
	 * @return
	 */
	public static String getTime() {
		return sdfTime.format(new Date());
	}
	
	/**
	 * 获取YYYYMMDDHHmmss格式
	 * 
	 * @return
	 */
	public static String getTimes() {
		return sdfTimes.format(new Date());
	}
	
	public static String getTime(Date date) {
		return sdfTime.format(date);
	}
	public static Date getTime(String date){
		try {
			return sdfTime.parse(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			return null;
		}
	}

	/**
	 * yyyy-MM-dd HH:mm:ss格式 转换 yyyy-MM-dd
	 */
	public static String subTimeSting(String date) {
		Date fomatDate = fomatDate(date);
		return sdfDay.format(fomatDate);
	}
	
	public static Date getDate(String date){
		Date fomatDate = fomatDate(date);
		return fomatDate;
	}

	/**
	 * @Title: compareDate
	 * @Description: TODO(日期比较，如果s>=e 返回true 否则返回false)
	 * @param s
	 * @param e
	 * @return boolean
	 * @throws
	 * @author luguosui
	 */
	public static boolean compareDate(String s, String e) {
		if (fomatDate(s) == null || fomatDate(e) == null) {
			return false;
		}
		return fomatDate(s).getTime() >= fomatDate(e).getTime();
	}

	public static boolean compareDate(Date s, Date e) {
		return s.getTime() >= e.getTime();
	}

	public static Date fomatDateWithSecond(String date) {
		DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			return fmt.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 格式化日期
	 * 
	 * @return
	 */
	public static Date fomatDate(String date) {
		DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
		try {
			return fmt.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 校验日期是否合法
	 * 
	 * @return
	 */
	public static boolean isValidDate(String s) {
		DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
		try {
			fmt.parse(s);
			return true;
		} catch (Exception e) {
			// 如果throw java.text.ParseException或者NullPointerException，就说明格式不对
			return false;
		}
	}

	public static int getDiffYear(String startTime, String endTime) {
		DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
		try {
			long aa = 0;
			int years = (int) (((fmt.parse(endTime).getTime() - fmt.parse(startTime).getTime()) / (1000 * 60 * 60 * 24)) / 365);
			return years;
		} catch (Exception e) {
			// 如果throw java.text.ParseException或者NullPointerException，就说明格式不对
			return 0;
		}
	}

	/**
	 * <li>功能描述：时间相减得到天数
	 * 
	 * @param beginDateStr
	 * @param endDateStr
	 * @return long
	 * @author Administrator
	 */
	public static long getDaySub(String beginDateStr, String endDateStr) {
		long day = 0;
		java.text.SimpleDateFormat format = new java.text.SimpleDateFormat("yyyy-MM-dd");
		java.util.Date beginDate = null;
		java.util.Date endDate = null;

		try {
			beginDate = format.parse(beginDateStr);
			endDate = format.parse(endDateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		day = (endDate.getTime() - beginDate.getTime()) / (24 * 60 * 60 * 1000);
		// System.out.println("相隔的天数="+day);

		return day;
	}

	/**
	 * 获取相隔的时间段
	* @Title: getDaytoDay 
	* @Description: TODO 
	* @param @param beginDate
	* @param @param endDate
	* @param @return    
	* @return List<Date>    
	* @throws
	 */
	public static List<Date> getDaytoDay(Date beginDate, Date endDate) {

		List<Date> list = new ArrayList<Date>();
		long daySub = getDaySub(beginDate, endDate);
		for (int i = 0; i < daySub; i++) {
			Date n = DateUtils.addDays(beginDate, i);
			list.add(n);
		}
		list.add(endDate);
		return list;
	}

	/**
	 * 获取相隔的时间段
	* @Title: getDaytoDay 
	* @Description: TODO 
	* @param @param beginDate
	* @param @param endDate
	* @param @return    
	* @return List<Date>    
	* @throws
	 */
	public static List<Date> getDaytoDay(String beginDateStr, String endDateStr) {

		Date beginDate = fomatDate(beginDateStr);
		Date endDate = fomatDate(endDateStr);
		List<Date> list = new ArrayList<Date>();
		long daySub = getDaySub(beginDate, endDate);
		for (int i = 0; i < daySub; i++) {
			Date n = DateUtils.addDays(beginDate, i);
			list.add(n);
		}
		list.add(endDate);
		return list;
	}

	public static long getDaySub(Date beginDateStr, Date endDateStr) {
		long day = (endDateStr.getTime() - beginDateStr.getTime()) / (24 * 60 * 60 * 1000);
		// System.out.println("相隔的天数="+day);
		return day;
	}

	/**
	 * 得到n天之后的日期
	 * 
	 * @param days
	 * @return
	 */
	public static String getAfterDayDate(Integer days) {
		Calendar canlendar = Calendar.getInstance(); // java.util包
		canlendar.add(Calendar.DATE, days); // 日期减 如果不够减会将月变动
		Date date = canlendar.getTime();

		SimpleDateFormat sdfd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateStr = sdfd.format(date);

		return dateStr;
	}
	/**
	 * 得到n天之后的日期
	 * 
	 * @param days
	 * @return
	 */
	public static String getAfterDayDate(String d,String days) {
		int daysInt = Integer.parseInt(days);

		Calendar canlendar = Calendar.getInstance(); // java.util包
		canlendar.setTime(getDate(d));
		canlendar.add(Calendar.DATE, daysInt); // 日期减 如果不够减会将月变动
		Date date = canlendar.getTime();

		SimpleDateFormat sdfd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateStr = sdfd.format(date);

		return dateStr;
	}
	
	
	/**
	 * 得到n月之后的日期
	 * 
	 * @param months
	 * @return
	 */
	public static String getAfterMonthDate(int monthsInt) {
		
		Calendar canlendar = Calendar.getInstance();
		canlendar.add(Calendar.MONTH, monthsInt);
		canlendar.add(Calendar.DATE, -1);
		
		Date date = canlendar.getTime();

		SimpleDateFormat sdfd = new SimpleDateFormat("yyyy-MM-dd");
		String dateStr = sdfd.format(date);

		return dateStr;
	}
	/**
	 * 得到n天之后是周几
	 * 
	 * @param days
	 * @return
	 */
	public static String getAfterDayWeek(String days) {
		int daysInt = Integer.parseInt(days);

		Calendar canlendar = Calendar.getInstance(); // java.util包
		canlendar.add(Calendar.DATE, daysInt); // 日期减 如果不够减会将月变动
		Date date = canlendar.getTime();

		SimpleDateFormat sdf = new SimpleDateFormat("E");
		String dateStr = sdf.format(date);

		return dateStr;
	}

	/**
	 * 指定时间n天后的时间搓
	 * @param time//指定时间字符串
	 * @param n//指定天数
	 */
	public static long getAfterDate(String time,Integer n) throws ParseException{
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = df.parse(time);
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		long timestamp = cal.getTimeInMillis(); //单位为毫秒
		return timestamp + (n*86400000);
	}
	
	
	public static void main(String[] args) {
		System.out.println(getDay());
		System.out.println(getAfterMonthDate(3));
	}

}
