package xyz.oldbad.obsdk.utils;

import android.util.Log;

public class TimeConsumeTracker {

	private long startTime;
	private long endTime;

	private String tag;

	public TimeConsumeTracker(String tag) {
		this.tag = tag;
	}

	public void trackStart() {
		startTime = System.currentTimeMillis();
	}

	public void trackEnd() {
		endTime = System.currentTimeMillis();
	}

	public void printTrack() {
		Log.v(tag, "usedTime:" + (endTime - startTime) + "ms");
	}

}
