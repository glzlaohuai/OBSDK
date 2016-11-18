package xyz.oldbad.obsdk.ob;

import android.util.Log;

import xyz.oldbad.obsdk.utils.LogSaver;


/**
 * @author glzlaohuai
 */
public class OBLog {

   public static void v(String tag, String msg) {
      if (ConstantsHolder.isLogEnabled) {
         Log.v(tag, msg);
         LogSaver.saveLog(tag, msg, ConstantsHolder.LOG_DIR);
      }
   }

   public static void i(String tag, String msg) {
      if (ConstantsHolder.isLogEnabled) {
         Log.i(tag, msg);
         LogSaver.saveLog(tag, msg, ConstantsHolder.LOG_DIR);
      }
   }

   public static void d(String tag, String msg) {
      if (ConstantsHolder.isLogEnabled) {
         Log.d(tag, msg);
         LogSaver.saveLog(tag, msg, ConstantsHolder.LOG_DIR);
      }
   }

   public static void w(String tag, String msg) {
      if (ConstantsHolder.isLogEnabled) {
         Log.w(tag, msg);
         LogSaver.saveLog(tag, msg, ConstantsHolder.LOG_DIR);
      }
   }

   public static void e(String tag, String msg) {
      if (ConstantsHolder.isLogEnabled) {
         Log.e(tag, msg);
         LogSaver.saveLog(tag, msg, ConstantsHolder.LOG_DIR);
      }
   }

}
