package xyz.oldbad.obsdk.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.provider.MediaStore;

import java.io.File;
import java.util.List;

/**
 * 启动常用的第三方的app，eg：浏览器、联系人、短信
 * 
 * @author glzlaohuai
 * @date 2014-6-9
 */
public class ThirdAppStarter {

	/**
	 * 是否有应用能处理这个intent
	 * 
	 * @param context
	 * @param intent
	 * @return
	 */
	public static boolean isSafeToHandleThisIntent(Context context, Intent intent) {
		PackageManager packageManager = context.getPackageManager();
		List<ResolveInfo> activities = packageManager.queryIntentActivities(intent, 0);
		return activities.size() > 0;
	}

	/**
	 * 启动浏览器
	 * 
	 * @param context
	 * @param url
	 */
	public static boolean startBrowser(Context context, String url) {
		Intent intent = new Intent();
		intent.setAction("android.intent.action.VIEW");
		Uri content_url = Uri.parse(url);
		intent.setData(content_url);
		intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		if (isSafeToHandleThisIntent(context, intent)) {
			context.startActivity(intent);
			return true;
		}
		return false;
	}

	/**
	 * 进入拨号盘应用
	 * 
	 * @param context
	 * @param phone
	 * @return
	 */
	public static boolean startDial(Context context, String phone) {
		Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + phone));
		intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		if (isSafeToHandleThisIntent(context, intent)) {
			context.startActivity(intent);
			return true;
		}
		return false;
	}

	/**
	 * 启动app安装应用
	 * 
	 * @param context
	 * @param phone
	 * @return
	 */
	public static boolean startAppInstall(Context context, String apkFilePath) {
		Uri uri = Uri.fromFile(new File(apkFilePath));
		Intent intent = new Intent(Intent.ACTION_VIEW);
		intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);// 启动新的activity
		intent.setDataAndType(uri, "application/vnd.android.package-archive");
		if (isSafeToHandleThisIntent(context, intent)) {
			context.startActivity(intent);
			return true;
		}
		return false;
	}

	public static void startApp(Context context, String packageName) {
		try {
			Intent intent = new Intent();
			PackageManager packageManager = context.getPackageManager();
			intent = packageManager.getLaunchIntentForPackage(packageName);
			intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
			context.startActivity(intent);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public static boolean startMapLocate(Context context, String lon, String lat) {
		Uri uri = Uri.parse(String.format("geo:%s,%s", lon, lat));
		Intent intent = new Intent(Intent.ACTION_VIEW, uri);

		if (isSafeToHandleThisIntent(context, intent)) {
			context.startActivity(intent);
			return true;
		}
		return false;
	}

	
	/**
	 * 启动相机拍照，不指定存储位置
	 * @param activity
	 * @param requestCode
	 * @return
	 */
	public static boolean startImgCapture(Activity activity, int requestCode) {
		Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
		if (takePictureIntent.resolveActivity(activity.getPackageManager()) != null) {
			activity.startActivityForResult(takePictureIntent, requestCode);
			return true;
		} else
			return false;

	}
	
	
	public static boolean startVideoCapture(Activity activity, int requestCode) {
		Intent takeVideoIntent = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
		if (takeVideoIntent.resolveActivity(activity.getPackageManager()) != null) {
			activity.startActivityForResult(takeVideoIntent, requestCode);
			return true;
		} else
			return false;

	}

}
