package xyz.oldbad.obsdk.utils;

import android.content.Context;
import android.view.inputmethod.InputMethodManager;

public class InputUtils {

	/**
	 * 弹出输入法的软键盘
	 * 
	 * @param context
	 */
	public static void showInputKeyboard(Context context) {

		InputMethodManager manager = (InputMethodManager) context
				.getSystemService(Context.INPUT_METHOD_SERVICE);
		manager.toggleSoftInput(0, InputMethodManager.HIDE_NOT_ALWAYS);

	}

}
