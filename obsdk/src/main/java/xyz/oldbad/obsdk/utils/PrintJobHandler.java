package xyz.oldbad.obsdk.utils;

import android.app.Activity;
import android.graphics.Bitmap;
import android.support.v4.print.PrintHelper;

public class PrintJobHandler {

	/**
	 * 打印图片
	 * 
	 * @param activity
	 * @param bitmap
	 * @param scaleMode
	 *            {@linkplain PrintHelper#SCALE_MODE_FILL} or
	 *            {@linkplain PrintHelper#SCALE_MODE_FIT}
	 */
	public static void printImage(Activity activity, Bitmap bitmap, int scaleMode, String jobName) {
		PrintHelper printHelper = new PrintHelper(activity);
		printHelper.setScaleMode(scaleMode);
		printHelper.printBitmap(jobName, bitmap);
	}
	
	
	
	public static void printHTML(Activity activity, Bitmap bitmap, int scaleMode, String jobName) {
		PrintHelper printHelper = new PrintHelper(activity);
		printHelper.setScaleMode(scaleMode);
		printHelper.printBitmap(jobName, bitmap);
	}
	
	
	
	
	
	
}
