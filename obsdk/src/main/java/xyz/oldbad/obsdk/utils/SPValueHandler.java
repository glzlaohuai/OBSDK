package xyz.oldbad.obsdk.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

import xyz.oldbad.obsdk.utils.others.APPConfig;


/**
 * 读写保存在{@linkplain SharedPreferences}中的数据
 *
 * @author glzlaohuai
 * @date 2014-6-10
 */
public class SPValueHandler {


   /**
    * 将int值按键值对形式写入到文件{@link APPConfig#defaultSPFileName}，默认的写入文件名称使用方法：{@link OBConfig#setSPFileName(String)}设置
    *
    * @param context
    * @param key
    * @param value
    */
   public final static void putIntParams(Context context, String key, int value) {
      SharedPreferences preference = context.getSharedPreferences(
              APPConfig.getDefaultSPFileName(), Context.MODE_PRIVATE);
      Editor editor = preference.edit();
      editor.putInt(key, value);
      editor.commit();
   }


   /**
    * 将string值按键值对形式写入到文件{@link APPConfig#defaultSPFileName}，默认的写入文件名称使用方法：{@link OBConfig#setSPFileName(String)}设置
    *
    * @param context
    * @param key
    * @param value
    */
   public final static void putStringParam(Context context, String key,
                                           String value) {
      SharedPreferences preference = context.getSharedPreferences(
              APPConfig.getDefaultSPFileName(), Context.MODE_PRIVATE);
      Editor editor = preference.edit();
      editor.putString(key, value);
      editor.commit();
   }

   /**
    * 将long值按键值对形式写入到文件{@link APPConfig#defaultSPFileName}，默认的写入文件名称使用方法：{@link OBConfig#setSPFileName(String)}设置
    *
    * @param context
    * @param key
    * @param value
    */
   public final static void putLongParam(Context context, String key,
                                         Long value) {
      SharedPreferences preference = context.getSharedPreferences(
              APPConfig.getDefaultSPFileName(), Context.MODE_PRIVATE);
      Editor editor = preference.edit();
      editor.putLong(key, value);
      editor.commit();
   }

   /**
    * 将boolean值按键值对形式写入到文件{@link APPConfig#defaultSPFileName}，默认的写入文件名称使用方法：{@link OBConfig#setSPFileName(String)}设置
    *
    * @param context
    * @param key
    * @param value
    */
   public final static void putBooleanParam(Context context, String key,
                                            boolean value) {
      SharedPreferences preference = context.getSharedPreferences(
              APPConfig.getDefaultSPFileName(), Context.MODE_PRIVATE);
      Editor editor = preference.edit();
      editor.putBoolean(key, value);
      editor.commit();
   }

   /**
    * 从默认文件中获取 key 所表示的值
    *
    * @param context
    * @param key
    * @param defaultValue
    * @return
    */
   public final static int getIntParam(Context context, String key, int defaultValue) {
      SharedPreferences preferences = context.getSharedPreferences(
              APPConfig.getDefaultSPFileName(), Context.MODE_PRIVATE);
      return preferences.getInt(key, defaultValue);
   }

   /**
    *
    * @param context
    * @param key
    * @param defaultValue
    * @return
    */
   public final static String getStringParam(Context context, String key, String defaultValue) {
      SharedPreferences preferences = context.getSharedPreferences(
              APPConfig.getDefaultSPFileName(), Context.MODE_PRIVATE);
      return preferences.getString(key, defaultValue);
   }

   public final static long getLongParam(Context context, String key, long defaultValue) {
      SharedPreferences preferences = context.getSharedPreferences(
              APPConfig.getDefaultSPFileName(), Context.MODE_PRIVATE);
      return preferences.getLong(key, defaultValue);
   }

   public final static boolean getBooleanParam(Context context, String key, boolean defaultValue) {
      SharedPreferences preferences = context.getSharedPreferences(
              APPConfig.getDefaultSPFileName(), Context.MODE_PRIVATE);
      return preferences.getBoolean(key, defaultValue);
   }

   /**
    * 写入int数据
    *
    * @param context
    * @param fileName
    * @param key
    * @param value
    */
   public final static void putIntParams(Context context, String fileName,
                                         String key, int value) {
      SharedPreferences preference = context.getSharedPreferences(fileName,
              Context.MODE_PRIVATE);
      Editor editor = preference.edit();
      editor.putInt(key, value);
      editor.commit();
   }

   /**
    * 写入string数据
    *
    * @param context
    * @param fileName
    * @param key
    * @param value
    */
   public final static void putStringParam(Context context, String fileName,
                                           String key, String value) {
      SharedPreferences preference = context.getSharedPreferences(fileName,
              Context.MODE_PRIVATE);
      Editor editor = preference.edit();
      editor.putString(key, value);
      editor.commit();
   }

   /**
    * 写入long类型数据
    *
    * @param context
    * @param fileName
    * @param key
    * @param value
    */
   public final static void putLongParam(Context context, String fileName,
                                         String key, Long value) {
      SharedPreferences preference = context.getSharedPreferences(fileName,
              Context.MODE_PRIVATE);
      Editor editor = preference.edit();
      editor.putLong(key, value);
      editor.commit();
   }

   /**
    * 向配置文件中写入boolean类型数据
    *
    * @param context
    * @param fileName
    * @param key
    * @param value
    */
   public final static void putBooleanParam(Context context, String fileName,
                                            String key, boolean value) {
      SharedPreferences preference = context.getSharedPreferences(fileName,
              Context.MODE_PRIVATE);
      Editor editor = preference.edit();
      editor.putBoolean(key, value);
      editor.commit();
   }

   /**
    * 获取int类型数据，如果没有的话返回为-1
    *
    * @param context
    * @param fileName
    * @param key
    * @return
    */
   public final static int getIntParam(Context context, String fileName,
                                       String key, int defaultValue) {
      SharedPreferences preferences = context.getSharedPreferences(fileName,
              Context.MODE_PRIVATE);
      return preferences.getInt(key, defaultValue);
   }

   /**
    * 获取string类型数据,如果没有的话返回为null
    *
    * @param context
    * @param fileName
    * @param key
    * @return
    */
   public final static String getStringParam(Context context, String fileName,
                                             String key, String defaultValue) {
      SharedPreferences preferences = context.getSharedPreferences(fileName,
              Context.MODE_PRIVATE);
      return preferences.getString(key, defaultValue);
   }

   /**
    * 返回long类型数据，如果没有的话返回为-1
    *
    * @param context
    * @param fileName
    * @param key
    * @return
    */
   public final static long getLongParam(Context context, String fileName,
                                         String key, long defaultValue) {
      SharedPreferences preferences = context.getSharedPreferences(fileName,
              Context.MODE_PRIVATE);
      return preferences.getLong(key, defaultValue);
   }

   /**
    * 获取boolean类型的值
    *
    * @param context
    * @param fileName
    * @param key
    * @return
    */
   public final static boolean getBooleanParam(Context context,
                                               String fileName, String key, boolean defaultValue) {
      SharedPreferences preferences = context.getSharedPreferences(fileName,
              Context.MODE_PRIVATE);
      return preferences.getBoolean(key, defaultValue);
   }

}
