package xyz.oldbad.obsdk.utils;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

import xyz.oldbad.obsdk.utils.others.APPConfig;

public class LogSaver {

	/**
	 * 将log信息保存到sd卡中
	 * 
	 * @param tag
	 * @param msg
	 */
	public static void saveLog(String tag, String msg) {
		if (SDHandler.isSDAvaliable()) {
			try {
				// 当前时间作为log下的二级目录
				String subDir = TimeFormatter.yyyyMMddFormat(System
						.currentTimeMillis());
				File parentFile = new File(SDHandler.getSDRootDIR()
						+ APPConfig.getLogDir() + subDir + "/");
				if (!parentFile.exists()) {
					parentFile.mkdirs();
				}

				File logFile = new File(parentFile, tag);

				if (!logFile.exists()) {
					try {
						logFile.createNewFile();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}

				BufferedWriter writer = null;
				try {
					writer = new BufferedWriter(new OutputStreamWriter(
							new FileOutputStream(logFile, true)));
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}

				try {
					writer.write(msg);
				} catch (IOException e) {
					e.printStackTrace();
				}
				try {
					writer.write("\n");
				} catch (IOException e) {
					e.printStackTrace();
				}
				try {
					writer.flush();
				} catch (IOException e) {
					e.printStackTrace();
				}
				try {
					writer.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}

	/**
	 * 指定log保存目录
	 * 
	 * @param tag
	 * @param msg
	 */
	public static void saveLog(String tag, String msg, String logDir) {
		if (SDHandler.isSDAvaliable()) {
			try {
				// 当前时间作为log下的二级目录
				String subDir = TimeFormatter.yyyyMMddFormat(System
						.currentTimeMillis());
				File parentFile = new File(SDHandler.getSDRootDIR() + logDir
						+ subDir + "/");
				if (!parentFile.exists()) {
					parentFile.mkdirs();
				}

				File logFile = new File(parentFile, tag);

				if (!logFile.exists()) {
					try {
						logFile.createNewFile();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}

				BufferedWriter writer = null;
				try {
					writer = new BufferedWriter(new OutputStreamWriter(
							new FileOutputStream(logFile, true)));
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}

				try {
					writer.write(msg);
				} catch (IOException e) {
					e.printStackTrace();
				}
				try {
					writer.write("\n");
				} catch (IOException e) {
					e.printStackTrace();
				}
				try {
					writer.flush();
				} catch (IOException e) {
					e.printStackTrace();
				}
				try {
					writer.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}
}
