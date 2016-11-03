package com.wpl.ws.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * JAVA Class initializing all the hibernate required utilities
 * 
 * @author SrikarRao
 *
 */
public class WPLUtilities {

	// Session factory created by invoking buildSessionFactory method
	private static final SessionFactory sessionFactory = buildSessionFactory();
	private static final String HIBERNATE_CONFIG_XML = "wpl_hibernate.cfg.xml";

	/**
	 * creates Session Factory on class loading
	 * 
	 * @return SessionFactory
	 */
	private static SessionFactory buildSessionFactory() {
		try {
			// load the hibernate.config.xml file from different directory
			SessionFactory sessionFactory = new Configuration().configure(
					WPLConstants.CONFIG_XML_LOC + HIBERNATE_CONFIG_XML)
					.buildSessionFactory();
			return sessionFactory;
		} catch (Throwable ex) {
			System.err.println("Initial SessionFactory creation failed." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	/**
	 * method to get Session factory
	 * 
	 * @return sessionFactory
	 */
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	/**
	 * method to close the SessionFactory (also closes level 1 cache)
	 */
	public static void shutdown() {
		getSessionFactory().close();
	}

}