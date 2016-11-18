package xyz.oldbad.obsdk.utils;

import android.annotation.SuppressLint;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 时间格式转换
 * 
 * @author laohuai
 * 
 */
public class TimeFormatter {

	@SuppressWarnings("deprecation")
	public static boolean isSameDay(long time1, long time2) {

		Date date1 = new Date(time1);
		Date date2 = new Date(time2);

		int year1 = date1.getYear();
		int month1 = date1.getMonth();
		int day1 = date1.getDay();

		int year2 = date2.getYear();
		int month2 = date2.getMonth();
		int day2 = date2.getDay();

		if (year1 == year2 && month1 == month2 && day1 == day2) {
			return true;
		}
		return false;
	}

	/**
	 * 将unix时间戳转换为当地的时间格式 e.g.中国时间格式：2012-8-12 上午10:20:33
	 * 
	 * @param time
	 * @return
	 */
	@SuppressWarnings("deprecation")
	public static String toLocalFormat(long time) {
		Date date = new Date(time);
		return date.toLocaleString();
	}

	/**
	 * 将java时间戳转换为yyyymmddhhmmss的形式
	 * 
	 * @param time
	 * @return
	 */
	@SuppressLint("SimpleDateFormat")
	public static String yyyyMMddHHmmssFormat(long time) {
		Date date = new Date(time);
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
		return formatter.format(date);
	}

	/**
	 * 将时间装换为yyyy-MM-dd格式
	 * 
	 * @param time
	 * @return
	 */
	@SuppressLint("SimpleDateFormat")
	public static String yyyyMMddFormat(long time) {
		Date date = new Date(time);
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		return formatter.format(date);
	}

}
