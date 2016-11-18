package xyz.oldbad.obsdk.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import xyz.oldbad.obsdk.ob.OBLog;

/**
 * 从流中读取数据
 *
 * @author laohuai
 */
public class StreamParser {

   /**
    * 从流中读取数据构造成一个String返回
    *
    * @param is
    * @return
    */
   public static String parseStream(InputStream is) {
      String result = null;
      BufferedReader reader = new BufferedReader(new InputStreamReader(is));
      StringBuffer sb = new StringBuffer();
      try {
         for (String s = reader.readLine(); s != null; s = reader.readLine()) {
            sb.append(s);
            sb.append("\n");
         }
      } catch (IOException e) {
         e.printStackTrace();
      }
      result = sb.toString();
      OBLog.v("data", result);
      try {
         is.close();
      } catch (IOException e) {
         e.printStackTrace();
      }
      return result;
   }

}
