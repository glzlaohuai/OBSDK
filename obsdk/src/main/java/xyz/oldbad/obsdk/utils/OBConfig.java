package xyz.oldbad.obsdk.utils;

import android.content.SharedPreferences;

import xyz.oldbad.obsdk.utils.others.APPConfig;


/**
 * 所有的配置都在此处控制
 * 
 * @author glzlaohuai
 * @version 2014-6-9
 */
public class OBConfig {

	/**
	 * 打开{@linkplain LogLevel}中任意一等级的log
	 * 
	 * @param level
	 *            log等级
	 */
	public static void enableLog(int level) {
		switch (level) {
		case LogLevel.V:
			APPConfig.setVVisible(true);
			break;
		case LogLevel.D:
			APPConfig.setDVisible(true);
			break;
		case LogLevel.I:
			APPConfig.setIVisible(true);
			break;
		case LogLevel.W:
			APPConfig.setWVisible(true);
			break;
		case LogLevel.E:
			APPConfig.setEVisible(true);
			break;
		}
	}

	/**
	 * 打开全部log
	 */
	public static void enableAllLog() {
		APPConfig.setVVisible(true);
		APPConfig.setDVisible(true);
		APPConfig.setIVisible(true);
		APPConfig.setWVisible(true);
		APPConfig.setEVisible(true);
	}

	/**
	 * 关闭某一个等级的log
	 * 
	 * @param level
	 */
	public static void disableLog(int level) {
		switch (level) {
		case LogLevel.V:
			APPConfig.setVVisible(false);
			break;
		case LogLevel.D:
			APPConfig.setDVisible(false);
			break;
		case LogLevel.I:
			APPConfig.setIVisible(false);
			break;
		case LogLevel.W:
			APPConfig.setWVisible(false);
			break;
		case LogLevel.E:
			APPConfig.setEVisible(false);
			break;
		}
	}

	/**
	 * 关闭全部的log
	 */
	public static void disableAllLog() {
		APPConfig.setVVisible(false);
		APPConfig.setDVisible(false);
		APPConfig.setIVisible(false);
		APPConfig.setWVisible(false);
		APPConfig.setEVisible(false);
	}

	/**
	 * 设置于服务器交互时候的编码格式
	 * 
	 * @param charsetName
	 */
	public static void setDefaultCharset(String charsetName) {
		APPConfig.setDefaultCharset(charsetName);
	}

	/**
	 * 设置日志保存目录：eg:[/e7studio/log/]
	 * <p>
	 * 按照示例，日志将保存在["sd卡根目录"/e7studio/log/"日志产生时间"/"TAG"]文件中
	 * 
	 * @param logDir
	 */
	public static void setLogDir(String logDir) {
		APPConfig.setLogDir(logDir);
	}

	/**
	 * 设置一个默认的标示为“失败”的json结构的String，在执行
	 * {@linkplain JSONBuilder#buildJSON(String)}
	 * 方法时，如果传递的buildJson方法传递的参数不是一个合法的json结构，那么将使用此处设置的值来构造一个json结构
	 * 
	 * <p>
	 * 
	 * 为什么有这样一个设置呢？json解析的操作大部分都是用来在跟服务器交互时候，用来解析服务器返回的数据的，所以，这里设置一个“默认失败类型”
	 * 的json串，是用来保证在“服务器端返回的数据不是约定好的json结构的时候”客户端有一个合适的处理
	 * 
	 * 比如，如果约定的json结构为{"data":{},"msg":{"code":"","text":""}}，
	 * 其中code来表示服务器端处理业务的状态
	 * ，text代表在不同code标示时候，需要展示给用户的信息，在这个示例下，就可以传递{"data":{},"msg"
	 * :{"code":"-1","text":"服务器端返回数据异常"}} 来处理这种情况
	 * 
	 * @param jsonString
	 */
	public static void setFailedJSONString(String jsonString) {
		APPConfig.setDefaultFailedJSON(jsonString);
	}

	/**
	 * 设置保存{@linkplain SharedPreferences}处理的数据的文件
	 * 
	 * @param spFileName
	 */
	public static void setSPFileName(String spFileName) {
		APPConfig.setDefaultSPFileName(spFileName);
	}

	/**
	 * 设置默认的网络请求方式：get/post
	 * 
	 * @param isByPost
	 */
	public static void setWebAccessByPost(boolean isByPost) {
		APPConfig.setWebAccessMethod(isByPost);
	}

	/**
	 * 默认是否展示laodingDialog
	 * 
	 * @param isLoadingTipsShowInDefaultState
	 */
	public static void setWebLoadingTipsDialogIsShow(
			boolean isLoadingTipsShowInDefaultState) {
		APPConfig
				.setLoadingTipsShouldShowOrNotInDefaultState(isLoadingTipsShowInDefaultState);
	}

	/**
	 * log等级
	 * 
	 * @author glzlaohuai
	 * @version 2014-6-9
	 */
	public class LogLevel {
		public final static int V = 0;
		public final static int D = 1;
		public final static int I = 2;
		public final static int W = 3;
		public final static int E = 4;
	}

}
