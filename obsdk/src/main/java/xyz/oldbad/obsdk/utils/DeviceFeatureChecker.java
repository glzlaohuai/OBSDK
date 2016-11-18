package xyz.oldbad.obsdk.utils;

import android.content.Context;
import android.content.pm.PackageManager;

public class DeviceFeatureChecker {

	public static boolean hasCamera(Context context) {
		PackageManager pm = context.getPackageManager();
		return pm.hasSystemFeature(PackageManager.FEATURE_CAMERA);
	}

}
