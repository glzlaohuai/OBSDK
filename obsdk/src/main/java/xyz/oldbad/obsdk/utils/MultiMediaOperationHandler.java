package xyz.oldbad.obsdk.utils;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;

import java.io.File;

public class MultiMediaOperationHandler {

	/**
	 * 将图片添加到系统相册中显示
	 * 
	 * @param context
	 * @param path
	 */
	public static void addPicToGallery(Context context, String path) {
		Intent intent = new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE);
		File file = new File(path);
		Uri uri = Uri.fromFile(file);
		intent.setData(uri);
		context.sendBroadcast(intent);
	}

}
