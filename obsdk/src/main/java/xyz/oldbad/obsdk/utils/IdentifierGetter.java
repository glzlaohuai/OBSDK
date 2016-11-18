package xyz.oldbad.obsdk.utils;

import android.content.Context;

public class IdentifierGetter {

	/**
	 * 获取资源在r文件中的标示
	 * 
	 * @param context
	 * @param resName
	 * @param resType
	 * @return
	 */
	public static int getIndentifier(Context context, String resName,
									 String resType) {
		return context.getResources().getIdentifier(resName, resType,
				context.getPackageName());
	}

	/**
	 * 对方法{{@link #getIndentifier(Context, String, String)}的wrap，指定资源类型为"string"
	 * 
	 * @param context
	 * @param resName
	 * @return
	 */
	public static int getStringIdentifier(Context context, String resName) {
		return context.getResources().getIdentifier(resName, "string",
				context.getPackageName());
	}

	/**
	 * 对方法{{@link #getIndentifier(Context, String, String)}的wrap，指定资源类型为"id"
	 * 
	 * @param context
	 * @param resName
	 * @return
	 */
	public static int getIDIdentifier(Context context, String resName) {
		return context.getResources().getIdentifier(resName, "id",
				context.getPackageName());
	}

	/**
	 * 对方法{{@link #getIndentifier(Context, String, String)}
	 * 的wrap，指定资源类型为"drawable"
	 * 
	 * @param context
	 * @param resName
	 * @return
	 */
	public static int getDrawableIdentifier(Context context, String resName) {
		return context.getResources().getIdentifier(resName, "drawable",
				context.getPackageName());
	}

	/**
	 * 对方法{{@link #getIndentifier(Context, String, String)}的wrap，指定资源类型为"style"
	 * 
	 * @param context
	 * @param resName
	 * @return
	 */
	public static int getStyleIdentifier(Context context, String resName) {
		return context.getResources().getIdentifier(resName, "style",
				context.getPackageName());
	}

	/**
	 * 对方法{{@link #getIndentifier(Context, String, String)}的wrap，指定资源类型为"layout"
	 * 
	 * @param context
	 * @param resName
	 * @return
	 */
	public static int getLayoutIdentifier(Context context, String resName) {
		return context.getResources().getIdentifier(resName, "layout",
				context.getPackageName());
	}

}
