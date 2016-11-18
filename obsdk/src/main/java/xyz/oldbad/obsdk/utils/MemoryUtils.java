package xyz.oldbad.obsdk.utils;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.app.ActivityManager.MemoryInfo;
import android.content.Context;
import android.os.Build;
import android.util.Log;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

@TargetApi(Build.VERSION_CODES.JELLY_BEAN)
public class MemoryUtils {

	public static int getAvaliableMemory(Context context) {
		MemoryInfo memoryInfo = new MemoryInfo();

		ActivityManager manager = (ActivityManager) context
				.getSystemService(Context.ACTIVITY_SERVICE);
		manager.getMemoryInfo(memoryInfo);
		long avaliableMemoryBytes = memoryInfo.availMem;
		return (int) (avaliableMemoryBytes / (1024 * 1024));
	}

	public static int getTotalMemory(Context context) {
		if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
			MemoryInfo memoryInfo = new MemoryInfo();

			ActivityManager manager = (ActivityManager) context
					.getSystemService(Context.ACTIVITY_SERVICE);
			manager.getMemoryInfo(memoryInfo);
			long totalMem = memoryInfo.totalMem;

			return (int) (totalMem / (1024 * 1024));
		} else {
			String memInfoFilePath = "/proc/meminfo";// 系统内存信息文件
			String firtLineContent;
			String[] splits;
			long totalMemBytes = 0;
			try {
				FileReader fileReader = new FileReader(memInfoFilePath);
				BufferedReader bufferedReader = new BufferedReader(fileReader,
						8192);
				firtLineContent = bufferedReader.readLine();// 读取meminfo第一行，系统总内存大小
				splits = firtLineContent.split("\\s+");
				for (String num : splits) {
					Log.i(firtLineContent, num + "\t");
				}
				totalMemBytes = Integer.valueOf(splits[1]).intValue() * 1024;// 获得系统总内存，单位是KB，乘以1024转换为Byte
				bufferedReader.close();
			} catch (IOException e) {
			}
			return (int) (totalMemBytes / (1024 * 1024));
		}
	}

}
