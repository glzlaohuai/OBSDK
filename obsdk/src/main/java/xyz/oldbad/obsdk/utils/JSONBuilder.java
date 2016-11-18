package xyz.oldbad.obsdk.utils;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;
import java.util.Map;
import java.util.Set;

import xyz.oldbad.obsdk.ob.OBLog;
import xyz.oldbad.obsdk.utils.others.APPConfig;

/**
 * 构造一个{@linkplain JSONObject}
 * 
 * @author glzlaohuai
 * @date 2014-6-10
 */
public class JSONBuilder {

	private final static String TAG = "JSONBuilder";

	/**
	 * 使用map结构来构造一个json结构
	 * 
	 * @param jsonMap
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static JSONObject buildJSON(Map<String, Object> jsonMap) {
		Set<String> keySet = jsonMap.keySet();
		JSONObject jsonObject = new JSONObject();
		for (String key : keySet) {
			Object obj = jsonMap.get(key);
			if (!(obj instanceof List<?>) && !(obj instanceof Map)) {
				try {
					jsonObject.put(key, obj);
				} catch (JSONException e) {
					e.printStackTrace();
				}
			}
			if (obj instanceof List<?>) {
				try {
					jsonObject.put(key, buildJsonArray((List<?>) obj));
				} catch (JSONException e) {
					e.printStackTrace();
				}
			}
			if (obj instanceof Map) {
				try {
					jsonObject.put(key, buildJSON((Map<String, Object>) obj));
				} catch (JSONException e) {
					e.printStackTrace();
				}
			}
		}
		return jsonObject;
	}

	private static JSONArray buildJsonArray(List<?> list) {
		JSONArray jsonArray = new JSONArray();
		if (list.size() != 0) {
			Object oneOfTheList = list.get(0);

			if (oneOfTheList instanceof Map) {
				for (Object object : list) {
					jsonArray.put(buildJSON((Map<String, Object>) object));
				}
			}
			if (oneOfTheList instanceof List<?>) {
				for (Object object : list) {
					jsonArray.put(buildJsonArray((List<?>) object));
				}
			}

			if (!(oneOfTheList instanceof Map)
					&& !(oneOfTheList instanceof List<?>)) {
				for (Object object : list) {
					jsonArray.put(object);
				}
			}
		}
		return jsonArray;

	}

	/**
	 * 根据传递的json串构造一个{@linkplain JSONObject}，如果传递的json串不是一个合法的json结构，那么将使用通过方法
	 * {@linkplain OBConfig#setDefaultCharset(String)}
	 * 设置的默认标示“失败类型”的json结构字符串来构造一个json结构
	 * 
	 * @param jsonString
	 */
	public static JSONObject buildJSON(String jsonString) {
		JSONObject jsonObject = null;
		try {
			jsonObject = new JSONObject(jsonString);
		} catch (JSONException e) {
			e.printStackTrace();
			OBLog.v(TAG, "将字符串：" + jsonString
					+ "，构造为json结构失败，不是一个合法的json结构，使用默认失败类型的json串构造json...");
			try {
				jsonObject = new JSONObject(APPConfig.getDefaultFailedJSON());
			} catch (JSONException e1) {
				e1.printStackTrace();
				OBLog.v(TAG, "默认失败类型的json串不合法！构造失败");
			}
		}
		return jsonObject;
	}
}
