package xyz.oldbad.obsdk.utils;

import android.util.Log;

import xyz.oldbad.obsdk.utils.others.APPConfig;


/**
 * log工具
 * 
 * @author glzlaohuai
 * @version 2014-6-9
 */

public class LogUtils {

	public static void v(String tag, String msg) {
		if (APPConfig.isVVisible()) {
			Log.v(tag, msg);
			LogSaver.saveLog(tag,
					TimeFormatter.toLocalFormat(System.currentTimeMillis())
							+ "/" + msg);
		}
	}

	public static void i(String tag, String msg) {
		if (APPConfig.isIVisible()) {
			Log.i(tag, msg);
			LogSaver.saveLog(tag, msg);
		}
	}

	public static void d(String tag, String msg) {
		if (APPConfig.isDVisible()) {
			Log.d(tag, msg);
			LogSaver.saveLog(tag, msg);
		}
	}

	public static void w(String tag, String msg) {
		if (APPConfig.isWVisible()) {
			Log.w(tag, msg);
			LogSaver.saveLog(tag, msg);
		}
	}

	public static void e(String tag, String msg) {
		if (APPConfig.isEVisible()) {
			Log.e(tag, msg);
			LogSaver.saveLog(tag, msg);
		}
	}
}
