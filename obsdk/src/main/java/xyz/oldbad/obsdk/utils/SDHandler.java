package xyz.oldbad.obsdk.utils;

import android.os.Environment;

/**
 * 
 * 对sd卡的操作
 * 
 * @author laohuai
 * 
 */

public class SDHandler {
	/**
	 * sd卡是否可用
	 * 
	 * @param context
	 * @return
	 */
	public final static boolean isSDAvaliable() {
		return Environment.getExternalStorageState().equals(
				Environment.MEDIA_MOUNTED);
	}

	/**
	 * 获取sd卡的根目录
	 * 
	 * @return
	 */
	public final static String getSDRootDIR() {
		return Environment.getExternalStorageDirectory().getAbsolutePath();
	}

}
