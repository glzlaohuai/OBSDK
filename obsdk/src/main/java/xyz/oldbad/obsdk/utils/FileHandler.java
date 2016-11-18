package xyz.oldbad.obsdk.utils;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.channels.FileChannel;

public class FileHandler {
	
	
	/**
	 * 
	 * @param fromFile
	 * @param toFile
	 */
	public static void copyFileTo(File fromFile, File toFile) {
		if (!toFile.exists()) {
			File parentFile = toFile.getParentFile();
			if (!parentFile.exists()) {
				parentFile.mkdirs();
			}
		}
		if (toFile.exists()) {
			toFile.delete();
		}

		if (fromFile.exists()) {
			try {
				FileInputStream fis = new FileInputStream(fromFile);
				FileOutputStream fos = new FileOutputStream(toFile);

				FileChannel inChannel = fis.getChannel();
				FileChannel outChannel = fos.getChannel();

				inChannel.transferTo(0, inChannel.size(), outChannel);

				fis.close();
				fos.close();
				inChannel.close();
				outChannel.close();
			} catch (Exception ex) {
				ex.printStackTrace();
			}

		}

	}

	public static String getFileExtensionName(String file) {
		int i = file.lastIndexOf('.');
		int leg = file.length();
		return (i > 0 ? (i + 1) == leg ? " " : file.substring(i + 1,
				file.length()) : " ");
	}

	// 合并两个文件
	public static void mergeTextFile(File srcFile, File desFile) {
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					new FileInputStream(srcFile), "utf-8"));
			BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(
					new FileOutputStream(desFile, true), "utf-8"));

			for (String line = reader.readLine(); line != null; line = reader
					.readLine()) {
				System.out.println(line);
				writer.write(line);
				writer.write("\t");
			}
			writer.flush();
			reader.close();
			writer.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}
}
