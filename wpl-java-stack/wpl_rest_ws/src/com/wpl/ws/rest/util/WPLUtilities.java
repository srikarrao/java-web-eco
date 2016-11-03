package com.wpl.ws.rest.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import org.apache.log4j.PropertyConfigurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * JAVA Utilties class to load configure application level properties
 * 
 * @author SrikarRao
 *
 */
public class WPLUtilities {

	// Properties object instantiated
	private static Properties properties = new Properties();

	public static Logger errorLogger; // error logger
	public static Logger appLogger; // app logger
	public static Logger perfLogger; // perf logger
	public static Logger wplLogger; // wpl data logger

	public static boolean utilityLoader() {
		if (!loadProperties()) {
			return false;
		}
		setLogger();
		return true;
	}

	/**
	 * Method to load all the properties from properties files
	 * 
	 * @return
	 */
	private static boolean loadProperties() {
		InputStream is = null; // declaring Inputstream object
		try {
			// initializing input stream object with configuration file
			is = new FileInputStream(new File(System.getenv("CONFIG_LOCATION")
					+ WPLConstants.WPL_CONFIG_LOG_FILE));
			if (is != null) {
				properties.load(is); // load properties file

				/**
				 * get system properties a.k.a System variables
				 */
				System.setProperty("logfile-data", WPLConstants.WPL_DATA_FILE);
				System.setProperty("data-dir", System.getenv("DATADIR"));
				System.setProperty("logfile-err", System.getenv("LOGDIR")
						+ WPLConstants.WPL_ERROR_FILE);
				System.setProperty("logfile-perf", System.getenv("LOGDIR")
						+ WPLConstants.WPL_PERF_FILE);
				System.setProperty("logfile-app", System.getenv("LOGDIR")
						+ WPLConstants.WPL_APP_FILE);
				// Configure the properties
				PropertyConfigurator.configure(properties);
				is.close(); // close input stream
				return true;
			}
		} catch (IOException e) {
			System.err.println("Cannot load the properties " + e);
		} catch (Exception e) {
			System.err.println("Cannot load the properties " + e);
		}
		return false;
	}

	/**
	 * method to set loggers
	 */
	private static void setLogger() {
		errorLogger = LoggerFactory.getLogger("errorLogger");
		appLogger = LoggerFactory.getLogger("appLogger");
		perfLogger = LoggerFactory.getLogger("perfLogger");
		wplLogger = LoggerFactory.getLogger("wplLogger");
	}
}
