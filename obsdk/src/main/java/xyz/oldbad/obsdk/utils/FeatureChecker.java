package xyz.oldbad.obsdk.utils;

import android.content.Context;
import android.content.pm.PackageManager;

public class FeatureChecker {

	public static boolean isCameraSupport(Context context) {
		PackageManager packageManager = context.getPackageManager();
		if (packageManager.hasSystemFeature(PackageManager.FEATURE_CAMERA)) {
			return true;
		}
		return false;
	}
}
