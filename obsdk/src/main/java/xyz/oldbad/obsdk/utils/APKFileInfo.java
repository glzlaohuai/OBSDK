package xyz.oldbad.obsdk.utils;

import android.graphics.drawable.Drawable;

public class APKFileInfo {

	private Drawable appIcon;
	private String appName;
	private String pkgName;
	private int versionCode;
	private String versionName;

	public Drawable getAppIcon() {
		return appIcon;
	}

	public void setAppIcon(Drawable appIcon) {
		this.appIcon = appIcon;
	}

	public String getAppName() {
		return appName;
	}

	public void setAppName(String appName) {
		this.appName = appName;
	}

	public String getPkgName() {
		return pkgName;
	}

	public void setPkgName(String pkgName) {
		this.pkgName = pkgName;
	}

	public int getVersionCode() {
		return versionCode;
	}

	public void setVersionCode(int versionCode) {
		this.versionCode = versionCode;
	}

	public String getVersionName() {
		return versionName;
	}

	public void setVersionName(String versionName) {
		this.versionName = versionName;
	}

	@Override
	public String toString() {
		return "[appName:" + appName + ",pkgName:" + pkgName + ",versionCode:"
				+ versionCode + ",versionName:" + versionName + "]";
	}

}
