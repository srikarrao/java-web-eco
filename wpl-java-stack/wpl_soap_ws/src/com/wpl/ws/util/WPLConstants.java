package com.wpl.ws.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Java Immutable class to store constants
 * 
 * @author SrikarRao
 *
 */

public final class WPLConstants {
	// Hibernate Xml Configuration location
	public static final String CONFIG_XML_LOC = "/com/wpl/hibernate/xml/";
	public static Date TODAYS_DATE;
	public static SimpleDateFormat SDF = new SimpleDateFormat("yyyy-MM-dd");
	static {
		try {
			TODAYS_DATE = SDF.parse(SDF.format(new Date()));
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
}