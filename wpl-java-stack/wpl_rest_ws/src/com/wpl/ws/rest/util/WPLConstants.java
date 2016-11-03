package com.wpl.ws.rest.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class WPLConstants {
	// sample application date
	public static Date APP_DATE;
	// log4j file name
	public static String WPL_CONFIG_LOG_FILE = "wpl_rest_log4j.properties";
	// error file name
	public static String WPL_ERROR_FILE = "wpl-rest-error";
	// perf file name
	public static String WPL_PERF_FILE = "wpl-rest-perf";
	// app file name
	public static String WPL_APP_FILE = "wpl-rest-app";
	// data file name
	public static String WPL_DATA_FILE = "wpl-rest-data-";
	static {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		try {
			APP_DATE = sdf.parse("21/12/2012");
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
}
