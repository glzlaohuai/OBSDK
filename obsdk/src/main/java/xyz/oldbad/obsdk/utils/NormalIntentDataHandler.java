package xyz.oldbad.obsdk.utils;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;

/**
 * 这个类用来处理一些常见的携带有数据的intent，解析其中的常用到的数据，使用方便，省去了每次用到都要去search的烦恼，持续添中……
 * 
 * @author glzlaohuai
 *
 */
public class NormalIntentDataHandler {

	/**
	 * 获取使用{@linkplain MediaStore#ACTION_IMAGE_CAPTURE}进行拍照之后，返回的intent中的缩略图
	 * 
	 * @param intent
	 */
	public static Bitmap getThumbnailFromCameraCapturedImage(Intent intent) {
		Bundle extras = intent.getExtras();
		Bitmap bitmap = (Bitmap) extras.get("data");
		return bitmap;
	}

	/**
	 * 在使用{@linkplain MediaStore#ACTION_VIDEO_CAPTURE}
	 * 进行视频拍摄之后，返回intent中的拍摄视频文件的uri
	 * 
	 * @param intent
	 * @return
	 */
	public static Uri getVideoFileUriFromCaptureVideo(Intent intent) {
		return intent.getData();
	}

}
