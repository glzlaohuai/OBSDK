package xyz.oldbad.obsdk.utils;

import java.util.HashMap;
import java.util.Map;

public class MapBuilder {

	/**
	 * 
	 * @param keys
	 * @param values
	 * @return
	 */
	public static Map<String, String> buildMap(String[] keys, String[] values) {
		Map<String, String> result = new HashMap<String, String>();
		for (int i = 0; i < keys.length; i++) {
			result.put(keys[i], values[i]);
		}
		return result;
	}

	public static Map<String, Object> buildMap(String[] keys, Object[] values) {
		Map<String, Object> result = new HashMap<String, Object>();
		for (int i = 0; i < keys.length; i++) {
			result.put(keys[i], values[i]);
		}
		return result;
	}

}
