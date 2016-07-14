package io.github.yuweiguocn.databindingdemo.util;

import android.util.Log;

import io.github.yuweiguocn.databindingdemo.BuildConfig;

public class L {
	public static boolean isDebug = BuildConfig.DEBUG;// 是否需要打印bug，可以在application的onCreate函数里面初始化
	private static final String TAG = "debug";

	// 下面四个是默认tag的函数
	public static void i(String msg) {
		if (isDebug && msg != null)
			Log.i(TAG, msg);
	}

	public static void d(String msg) {
		if (isDebug && msg != null)
			Log.d(TAG, msg);
	}

	public static void e(String msg) {
		if (isDebug && msg != null)
			Log.e(TAG, msg);
	}

	public static void v(String msg) {
		if (isDebug && msg != null)
			Log.v(TAG, msg);
	}

	/** 打印TAG为json结果
	 * @param msg
	 */
	public static void j(String msg) {
		if (isDebug && msg != null)
			Log.i("json", msg);
	}
	
	// 下面是传入自定义tag的函数
	public static void i(String tag, String msg) {
		if (isDebug && msg != null)
			Log.i(tag, msg);
	}

	public static void d(String tag, String msg) {
		if (isDebug && msg != null)
			Log.i(tag, msg);
	}

	public static void e(String tag, String msg) {
		if (isDebug && msg != null)
			Log.i(tag, msg);
	}

	public static void v(String tag, String msg) {
		if (isDebug && msg != null)
			Log.i(tag, msg);
	}
}
