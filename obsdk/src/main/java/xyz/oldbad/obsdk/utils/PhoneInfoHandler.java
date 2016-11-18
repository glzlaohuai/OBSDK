package xyz.oldbad.obsdk.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.BatteryManager;
import android.os.Build.VERSION;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;

import java.util.Locale;

/**
 * 顾名思义，获取设备信息，包括：系统版本号、设备型号、imei、mac、imsi等
 * 
 * @author glzlaohuai
 * @date 2014-6-9
 */
public class PhoneInfoHandler {

	/**
	 * 获取手机的生产厂商
	 *
	 * @return
	 */
	public static String getManufacture() {
		return android.os.Build.MANUFACTURER;
	}

	/**
	 * 获取手机型号
	 * 
	 * @return
	 */
	public static String getModel() {
		return android.os.Build.MODEL;
	}

	/**
	 * 获取系统版本号
	 * <p>
	 * {@linkplain VERSION#RELEASE}
	 * 
	 * @return
	 */
	public static String getAndroidVersionName() {
		return android.os.Build.VERSION.RELEASE;
	}

	/**
	 * 获取系统版本
	 * <p>
	 * {@linkplain VERSION#SDK_INT}
	 *
	 * @return
	 */
	public static int getAndroidVersionCode() {
		return android.os.Build.VERSION.SDK_INT;
	}

	/**
	 * 获取imei信息，如果没有取到（被安全软件阻止），那么返回""
	 *
	 * @param context
	 * @return
	 */
	public static String getDeviceID(Context context) {
		TelephonyManager telephonyManager = (TelephonyManager) context
				.getSystemService(Context.TELEPHONY_SERVICE);
		String imei = telephonyManager.getDeviceId();
		imei = imei == null ? "" : imei;
		return imei;
	}

	/**
	 * 获取androidID
	 *
	 * @param context
	 * @return
	 */
	public static String getAndroidID(Context context) {
		String androidID = Settings.Secure.getString(
				context.getContentResolver(), Settings.Secure.ANDROID_ID);
		return androidID;
	}

	/**
	 * 获取imsi信息，如果没有获取到，那么返回""
	 *
	 * @param context
	 * @return
	 */
	public static String getIMSI(Context context) {
		TelephonyManager telephonyManager = (TelephonyManager) context
				.getSystemService(Context.TELEPHONY_SERVICE);
		String imsi = telephonyManager.getSubscriberId();
		if (imsi == null) {
			imsi = "";
		}
		return imsi;
	}

	/**
	 * 获取设备屏幕分辨密度，对方法{@linkplain Display#getMetrics(DisplayMetrics)}
	 * 方法的wrap，返回取得的 {@linkplain DisplayMetrics#density}变量的值
	 *
	 * @param activity
	 * @return
	 */
	public static float getDisplayDensity(Activity activity) {
		DisplayMetrics dm = new DisplayMetrics();
		activity.getWindowManager().getDefaultDisplay().getMetrics(dm);
		return dm.density;
	}

	/**
	 * 获取语言设置
	 *
	 * @return
	 */
	public static String getLanguage() {
		return Locale.getDefault().toString();
	}

	/**
	 * 获取国家设置，如果没有获取到返回""
	 * <p>
	 * <b>因为是根据sim卡来获取的国家信息，所以，必须要有插入sim卡&sim已经注册</b>
	 *
	 * @param context
	 * @return
	 */
	public static String getCountry(Context context) {
		TelephonyManager telephonyManager = (TelephonyManager) context
				.getSystemService(Context.TELEPHONY_SERVICE);
		String zone = telephonyManager.getSimCountryIso();
		if (zone == null) {
			zone = "";
		}
		return zone;
	}

	/**
	 * 获取mac地址，如果没有获取到返回""
	 *
	 * @param context
	 * @return
	 */
	public static String getMAC(Context context) {
		WifiManager wifiManager = (WifiManager) context
				.getSystemService(Context.WIFI_SERVICE);
		WifiInfo info = wifiManager.getConnectionInfo();
		if (info != null) {
			String mac = info.getMacAddress();
			if (mac == null) {
				mac = "";
			}
			return mac;
		} else {
			return "";
		}
	}

	/**
	 * 获取plmn
	 * <p>
	 * {@link TelephonyManager#getSimOperator()}
	 * <p>
	 * plmn=<a
	 * href="http://zh.wikipedia.org/wiki/Mobile_Network_Code">mnc</a>+<a href=
	 * "http://zh.wikipedia.org/wiki/%E8%A1%8C%E5%8B%95%E8%A3%9D%E7%BD%AE%E5%9C%8B%E5%AE%B6%E4%BB%A3%E7%A2%BC"
	 * >mcc</a>
	 *
	 * @param context
	 * @return
	 */
	public static String getPLMN(Context context) {
		TelephonyManager telephonyManager = (TelephonyManager) context
				.getSystemService(Context.TELEPHONY_SERVICE);
		String plmn = telephonyManager.getSimOperator();
		if (plmn == null) {
			plmn = "";
		}
		return plmn;
	}

	/**
	 * 判断手机是否有SIM卡
	 *
	 */
	public static boolean isSIMAvaliable(Context context) {
		boolean isAlive = false;
		android.telephony.TelephonyManager tm = (TelephonyManager) context
				.getSystemService(Context.TELEPHONY_SERVICE);
		if (tm.getSimState() == TelephonyManager.SIM_STATE_READY) {
			isAlive = true;
		} else {
			isAlive = false;
		}
		return isAlive;
	}

	/**
	 * 判断电池是否在充电中
	 * 
	 * @param context
	 * @return
	 */
	public static boolean isBatteryInCharge(Context context) {
		IntentFilter filter = new IntentFilter(Intent.ACTION_BATTERY_CHANGED);
		Intent batteryState = context.registerReceiver(null, filter);
		if (batteryState != null) {
			int chargeStatus = batteryState.getIntExtra(
					BatteryManager.EXTRA_STATUS, -1);
			return chargeStatus == BatteryManager.BATTERY_STATUS_CHARGING
					|| chargeStatus == BatteryManager.BATTERY_STATUS_FULL;

		} else {
			return false;
		}
	}

	/**
	 * 获取电池剩余电量
	 * 
	 * @param context
	 * @return
	 */
	public static int getBatteryPercent(Context context) {
		IntentFilter filter = new IntentFilter(Intent.ACTION_BATTERY_CHANGED);
		Intent batteryState = context.registerReceiver(null, filter);
		if (batteryState != null) {
			int level = batteryState
					.getIntExtra(BatteryManager.EXTRA_LEVEL, -1);
			int scale = batteryState
					.getIntExtra(BatteryManager.EXTRA_SCALE, -1);
			int percent = (int) (level * 100 * 1.0 / scale);
			return percent;
		} else {
			return 0;
		}
	}

	public static int getMobileNetType(Context context) {
		if (isSIMAvaliable(context)) {
			TelephonyManager manager = (TelephonyManager) context
					.getSystemService(Context.TELEPHONY_SERVICE);
			int type = manager.getNetworkType();
			System.err.println(type);
			switch (type) {
			case TelephonyManager.NETWORK_TYPE_GPRS:
			case TelephonyManager.NETWORK_TYPE_CDMA:
			case TelephonyManager.NETWORK_TYPE_EDGE:
			case TelephonyManager.NETWORK_TYPE_1xRTT:
			case TelephonyManager.NETWORK_TYPE_IDEN:
				return 2;
			case TelephonyManager.NETWORK_TYPE_EVDO_A:
			case TelephonyManager.NETWORK_TYPE_UMTS:
			case TelephonyManager.NETWORK_TYPE_EVDO_0:
			case TelephonyManager.NETWORK_TYPE_HSDPA:
			case TelephonyManager.NETWORK_TYPE_HSUPA:
			case TelephonyManager.NETWORK_TYPE_HSPA:
			case TelephonyManager.NETWORK_TYPE_EVDO_B:
			case TelephonyManager.NETWORK_TYPE_EHRPD:
			case TelephonyManager.NETWORK_TYPE_HSPAP:
				return 3;
			case TelephonyManager.NETWORK_TYPE_LTE:
				return 4;
			default:
				return 0;
			}
		}
		return 0;
	}

	public static double getDeviceInch(int width, int height, float dengity) {
		double inch = Math.sqrt(Math.pow(width, 2) + Math.pow(height, 2))
				/ (160 * dengity);
		return inch;
	}

	public static boolean isPhoneInLandscape(Context context) {
		return context.getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE;
	}

	public static boolean isFullScreen(Activity activity) {
		return ((activity.getWindow().getAttributes().flags & WindowManager.LayoutParams.FLAG_FULLSCREEN) != 0);
	}
}
