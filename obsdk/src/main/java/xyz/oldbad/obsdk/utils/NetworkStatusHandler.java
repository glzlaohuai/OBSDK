package xyz.oldbad.obsdk.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * 网络状态处理
 * 
 * @author glzlaohuai
 * @date 2014-6-9
 */
public class NetworkStatusHandler {

	/**
	 * 判断是否有网络连接
	 * 
	 * @param context
	 * @return
	 */
	public static boolean isNetWorkAvaliable(Context context) {
		ConnectivityManager connectivityManager = (ConnectivityManager) context
				.getSystemService(Context.CONNECTIVITY_SERVICE);
		if (connectivityManager == null) {
			return false;
		} else {
			NetworkInfo[] info = connectivityManager.getAllNetworkInfo();
			if (info == null) {
				return false;
			} else {
				for (NetworkInfo nf : info) {
					if (nf.getState() == NetworkInfo.State.CONNECTED) {
						return true;
					}
				}
				return false;
			}
		}
	}

	/**
	 * 当前是否为wifi网络连接
	 * 
	 * @param context
	 * @return
	 */
	public static boolean isWIFIConnected(Context context) {
		ConnectivityManager connectivityManager = (ConnectivityManager) context
				.getSystemService(Context.CONNECTIVITY_SERVICE);
		NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
		String typeName = null;

		if (networkInfo != null) {
			typeName = networkInfo.getTypeName();
		} else {
			typeName = "null";
		}
		return typeName.trim().equalsIgnoreCase("wifi");
	}
	

}
