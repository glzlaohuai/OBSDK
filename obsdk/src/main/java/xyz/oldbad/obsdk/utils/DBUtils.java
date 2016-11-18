package xyz.oldbad.obsdk.utils;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 封装了对sqlite的操作
 * 
 * @author laohuai
 * 
 */

public class DBUtils {

	private final static byte[] lock = new byte[] { 1 };

	/**
	 * 关闭cursor
	 * 
	 * @param cursor
	 */
	private static void closeCursor(Cursor cursor) {
		if (cursor != null) {
			cursor.close();
		}
	}

	/**
	 * 构造contentValues,在执行insert时候会使用到该方法
	 * 
	 * @param keys
	 * @param values
	 * @return
	 */
	public static ContentValues buildContentValues(String[] keys,
												   String[] values) {
		ContentValues contentValues = new ContentValues();
		for (int i = 0; i < keys.length; i++) {
			contentValues.put(keys[i], values[i]);
		}
		return contentValues;
	}

	/**
	 * 
	 * @param context
	 * @param sqliteOpenHelper
	 * @param tableName
	 * @return
	 */
	public static Cursor doQuery(Context context,
								 SQLiteOpenHelper sqliteOpenHelper, String tableName) {
		Cursor cursor = sqliteOpenHelper.getReadableDatabase().query(tableName,
				null, null, null, null, null, null);
		return cursor;
	}

	/**
	 * 待条件的查询
	 * 
	 * @param context
	 * @param sqliteOpenHelper
	 * @param tableName
	 * @param keys
	 * @param values
	 * @return
	 */
	public static Cursor doQueryWithWhere(Context context,
										  SQLiteOpenHelper sqliteOpenHelper, String tableName, String[] keys,
										  String[] values) {
		Cursor cursor = sqliteOpenHelper.getReadableDatabase().query(tableName,
				null, buildClause(keys), values, null, null, null);
		return cursor;
	}

	/**
	 * 查询表，并将结果以list的形式返回 例如表中的数据如下 <font
	 * color="red">name:laohuai|age:100|gender:male|avatar:1.png</font>
	 * 那么执行query以后返回的数据为<b><font
	 * color="blue">{[name:laohuai,age:100,gender:male,avatar:1.png]}</font></b>
	 * 
	 * @param context
	 * @return
	 */
	public static List<Map<String, String>> queryTable(Context context,
													   SQLiteOpenHelper sqliteOpenHelper, String tableName) {
		synchronized (lock) {
			Cursor cursor = doQuery(context, sqliteOpenHelper, tableName);
			List<Map<String, String>> result = new ArrayList<Map<String, String>>();
			int count = cursor.getCount();
			// 列名
			String[] columnNames = cursor.getColumnNames();

			for (int i = 0; i < count; i++) {
				cursor.moveToPosition(i);
				Map<String, String> item = new HashMap<String, String>();
				for (int j = 0; j < columnNames.length; j++) {
					item.put(columnNames[j], cursor.getString(j));
				}
				result.add(item);
			}
			closeCursor(cursor);
			return result;
		}
	}

	/**
	 * 查询表，并将结果以list的形式返回 例如表中的数据如下 <font
	 * color="red">name:laohuai|age:100|gender:male|avatar:1.png</font>
	 * 那么执行query以后返回的数据为<b><font
	 * color="blue">{[name:laohuai,age:100,gender:male,avatar:1.png]}</font></b>
	 * 
	 * @param context
	 * @return
	 */
	public static List<Map<String, String>> queryTableWithWhere(
			Context context, SQLiteOpenHelper sqliteOpenHelper,
			String tableName, String[] keys, String[] values) {
		synchronized (lock) {
			Cursor cursor = doQueryWithWhere(context, sqliteOpenHelper,
					tableName, keys, values);
			List<Map<String, String>> result = new ArrayList<Map<String, String>>();
			int count = cursor.getCount();
			// 列名
			String[] columnNames = cursor.getColumnNames();

			for (int i = 0; i < count; i++) {
				cursor.moveToPosition(i);
				Map<String, String> item = new HashMap<String, String>();
				for (int j = 0; j < columnNames.length; j++) {
					item.put(columnNames[j], cursor.getString(j));
				}
				result.add(item);
			}
			closeCursor(cursor);
			return result;
		}
	}

	/**
	 * 向表中插入一条数据
	 * 
	 * @param context
	 * @param tableName
	 * @param contentValues
	 */
	public static void doInsert(Context context,
								SQLiteOpenHelper sqliteOpenHelper, String tableName,
								ContentValues contentValues) {
		synchronized (lock) {
			sqliteOpenHelper.getWritableDatabase().insert(tableName, null,
					contentValues);
		}
	}

	/**
	 * 更新操作
	 * 
	 * @param context
	 * @param tableName
	 *            表名
	 * @param updateKeys
	 *            需要更新的字段
	 * @param updateValues
	 *            更新以后相应字段的值
	 * @param whereKeys
	 *            where条件语句使用的字段
	 * @param whereValues
	 *            where条件语句字段的值
	 */
	public static void update(Context context,
							  SQLiteOpenHelper sqliteOpenHelper, String tableName,
							  String[] updateKeys, String[] updateValues, String[] whereKeys,
							  String[] whereValues) {
		synchronized (lock) {
			SQLiteDatabase db = sqliteOpenHelper.getWritableDatabase();
			db.update(tableName, buildContentValues(updateKeys, updateValues),
					buildClause(whereKeys), whereValues);
		}
	}

	/**
	 * 执行“删除一条表项”的操作</p> e.g.表结构为<font
	 * color="red">[name,age,gender]</font>，其中的一条记录为<font
	 * color="#cc6600">[laohuai,10,male]</font>，如果要删除这条记录,且name为主键的话
	 * 那么tableName就是该表名, <font
	 * color="#66cc00">keys={name},values={laohuai}</font>
	 * 
	 * @param context
	 * @param tableName
	 * @param keys
	 * @param values
	 */
	public static void del(Context context, SQLiteOpenHelper sqliteOpenHelper,
						   String tableName, String[] keys, String[] values) {
		synchronized (lock) {
			SQLiteDatabase db = sqliteOpenHelper.getWritableDatabase();
			db.delete(tableName, buildClause(keys), values);
		}
	}

	/**
	 * 构造查询或者更新条件
	 * 
	 * @param columnNames
	 * @return
	 */
	public static String buildClause(String[] columnNames) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < columnNames.length; i++) {
			sb.append(columnNames[i] + "=? and ");
		}
		sb.delete(sb.length() - 4, sb.length());
		return sb.toString();
	}

}