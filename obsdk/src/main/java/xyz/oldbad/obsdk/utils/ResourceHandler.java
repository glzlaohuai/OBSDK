package xyz.oldbad.obsdk.utils;

import android.content.Context;

public class ResourceHandler {

	public static String getString(Context context, int resID) {
		if (resID == 0) {
			return null;
		}
		return context.getResources().getString(resID);
	}

	public static int getColor(Context context, int resID) {
		if (resID == 0) {
			return 0;
		}
		return context.getResources().getColor(resID);
	}
}
