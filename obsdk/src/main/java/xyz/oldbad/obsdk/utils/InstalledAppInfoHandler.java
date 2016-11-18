package xyz.oldbad.obsdk.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.graphics.drawable.Drawable;

/**
 * 已经安装的软件信息获取
 * 
 * @author glzlaohuai
 * @date 2014-6-9
 */
public class InstalledAppInfoHandler {

	/**
	 * 获得已安装应用的图标
	 * 
	 * @param context
	 * @param pkg
	 * @return
	 */
	public static Drawable getAppIcon(Context context, String pkg) {
		PackageManager packageManager = context.getPackageManager();
		try {
			ApplicationInfo info = packageManager.getApplicationInfo(pkg, 0);
			return info.loadIcon(packageManager);
		} catch (NameNotFoundException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 获取在Manifest文件中指定的versionName
	 * <p>
	 * {@linkplain PackageInfo#versionName}
	 * 
	 * @param context
	 * @param pkg
	 * @return
	 */
	public static String getAppVersionName(Context context, String pkg) {
		PackageManager packageManager = context.getPackageManager();
		try {
			PackageInfo info = packageManager.getPackageInfo(pkg, 0);
			return info.versionName;
		} catch (NameNotFoundException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 获取在Manifest文件中指定的versionCode
	 * <p>
	 * {@linkplain PackageInfo#versionCode}
	 * 
	 * @param context
	 * @param pkg
	 * @return
	 */
	public static int getAppVersionCode(Context context, String pkg) {
		PackageManager packageManager = context.getPackageManager();
		try {
			PackageInfo info = packageManager.getPackageInfo(pkg, 0);
			return info.versionCode;
		} catch (NameNotFoundException e) {
			e.printStackTrace();
			return -1;
		}
	}

	/**
	 * 获取应用申请的所有权限列表
	 * <p>
	 * {@linkplain PackageInfo#requestedPermissions}
	 * 
	 * @param context
	 * @param pkg
	 * @return
	 */
	public static String[] getAppPermissions(Context context, String pkg) {
		PackageManager packageManager = context.getPackageManager();
		try {
			PackageInfo info = packageManager.getPackageInfo(pkg,
					PackageManager.GET_PERMISSIONS);
			return info.requestedPermissions;
		} catch (NameNotFoundException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 获取应用的安装时间，如果获取不到，返回0
	 * <p>
	 * {@linkplain PackageInfo#firstInstallTime}
	 * 
	 * @param context
	 * @param pkg
	 * @return
	 */
	@SuppressLint("NewApi")
	public static long getAppInstalledTime(Context context, String pkg) {
		if (PhoneInfoHandler.getAndroidVersionCode() >= android.os.Build.VERSION_CODES.GINGERBREAD) {
			try {
				PackageManager packageManager = context.getPackageManager();
				PackageInfo info = packageManager.getPackageInfo(pkg, 0);
				return info.firstInstallTime;
			} catch (NameNotFoundException e) {
				e.printStackTrace();
				return 0;
			}
		} else {
			return 0;
		}
	}

	/**
	 * 获取应用上次更新的时间，如果没有获取到返回0
	 * <p>
	 * {@linkplain PackageInfo#lastUpdateTime}
	 * 
	 * @param context
	 * @param pkg
	 * @return
	 */
	@SuppressLint("NewApi")
	public static long getAppLastUpdateTime(Context context, String pkg) {
		if (PhoneInfoHandler.getAndroidVersionCode() >= android.os.Build.VERSION_CODES.GINGERBREAD) {
			try {
				PackageManager packageManager = context.getPackageManager();
				PackageInfo info = packageManager.getPackageInfo(pkg, 0);
				return info.lastUpdateTime;
			} catch (NameNotFoundException e) {
				e.printStackTrace();
				return 0;
			}
		} else {
			return 0;
		}
	}
}
