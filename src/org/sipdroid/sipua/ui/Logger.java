package org.sipdroid.sipua.ui;

import android.util.Log;

/**
 * This class defines the Logger
 */

public final class Logger {
	private static final String TAG = "SIPUA";
	private static final boolean LOG_ENABLE = true;
	private static final boolean DETAIL_ENABLE = true;

	private Logger() {
	}

	private static String buildMsg(String msg) {
		StringBuilder buffer = new StringBuilder();

		if (DETAIL_ENABLE) {
			final StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[4];
			
			buffer.append("[ ");
			buffer.append(Thread.currentThread().getName());
			buffer.append(": ");
			buffer.append(stackTraceElement.getFileName());
			buffer.append(": ");
			buffer.append(stackTraceElement.getLineNumber());
			buffer.append(": ");
			buffer.append(stackTraceElement.getMethodName());
		}

		buffer.append("() ] _____ ");

		buffer.append(msg);

		return buffer.toString();
	}

	public static void i(String msg) {
		if (LOG_ENABLE) {
			Log.i(TAG, buildMsg(msg));
		}
	}

	public static void e(String msg) {
		if (LOG_ENABLE) {
			Log.e(TAG, buildMsg(msg));
		}
	}

	public static void e(String msg, Exception e) {
		if (LOG_ENABLE) {
			Log.e(TAG, buildMsg(msg), e);
		}
	}

	public static void d(String msg) {
		if (LOG_ENABLE) {
			Log.d(TAG, buildMsg(msg));
		}
	}

	public static void v(String msg) {
		if (LOG_ENABLE) {
			Log.v(TAG, buildMsg(msg));
		}
	}

	public static void w(String msg) {
		if (LOG_ENABLE) {
			Log.w(TAG, msg);
		}
	}

	public static void w(String msg, Exception e) {
		if (LOG_ENABLE) {
			Log.w(TAG, msg, e);
		}
	}
}
