package xyz.oldbad.obsdk.utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;

public class ImageHandler {

	/**
	 * 如果图片尺寸是1024*768，而设置的view尺寸是100*100，那么显然，压缩一下显示会占用更小的内存而且不会影响显示效果，
	 * 这个方法就是做这个用的。
	 * 
	 * @param filePath
	 * @param targetW
	 * @param targetH
	 * @param smallerSize
	 *            如果设置为true，那么将使用（图片尺寸[宽高]/期望尺寸）中更大的值来进行压缩
	 * @return
	 */
	public static Bitmap scaleImageToFitSize(String filePath, int targetW, int targetH, boolean smallerSize) {

		Options options = new Options();
		options.inJustDecodeBounds = true;
		BitmapFactory.decodeFile(filePath, options);

		int photoW = options.outWidth;
		int photoH = options.outHeight;

		int sample = 0;
		if (smallerSize)
			sample = Math.max(photoW / targetW, photoH / targetH);
		else
			sample = Math.min(photoW / targetW, photoH / targetH);

		options.inJustDecodeBounds = false;
		options.inSampleSize = sample;
		options.inPurgeable = true;

		Bitmap bitmap = BitmapFactory.decodeFile(filePath, options);
		return bitmap;
	}

}
