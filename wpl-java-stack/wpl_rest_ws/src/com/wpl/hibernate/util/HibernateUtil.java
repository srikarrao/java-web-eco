package com.wpl.hibernate.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import static com.wpl.hibernate.util.HbmConstants.*;

/**
 * JAVA Class initializing all the hibernate required utilities
 * 
 * @author SrikarRao
 *
 */
public class HibernateUtil {

	// Session factory created by invoking buildSessionFactory method
	private static final SessionFactory sessionFactory = buildSessionFactory();

	/**
	 * creates Session Factory on class loading
	 * 
	 * @return SessionFactory
	 */
	private static SessionFactory buildSessionFactory() {
		try {
			// load the hibernate.config.xml file from different directory
			SessionFactory sessionFactory = new Configuration().configure(
					CONFIG_XML_LOC + HIBERNATE_CONFIG_XML)
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