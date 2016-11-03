package com.wpl.hibernate.model;

import java.util.Date;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import com.wpl.hibernate.util.HibernateUtil;

/**
 * Simple JAVA class to create a session and persist sample data into the
 * respective tables
 * 
 * @author SrikarRao
 *
 */
public class HibernateTest {
	private static Session session;

	public static void main(String[] args) {
		try {
			// fetch Session factory object invoking getSessionFactoty method
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			session = sessionFactory.openSession(); // create a session
			session.beginTransaction(); // begin transaction

			// Creating persist objects for APPLICATION_DETAILS table
			ApplicationDetails appDetails1 = new ApplicationDetails();
			appDetails1.setAge(28);
			appDetails1.setSsn("111107819");
			appDetails1.setApplicationStatus("APPROVED");
			appDetails1.setCategory("GEN");
			appDetails1.setAppliedDate(new Date());
			appDetails1.setName("Kevin Petersen");
			appDetails1.setWorkExperience(6);
			session.save(appDetails1); // save session for appDetails1

			ApplicationDetails appDetails2 = new ApplicationDetails();
			appDetails2.setAge(32);
			appDetails2.setSsn("999008887");
			appDetails2.setApplicationStatus("APPROVED");
			appDetails2.setCategory("OPT");
			appDetails2.setAppliedDate(new Date());
			appDetails2.setName("MS Dhoni");
			appDetails2.setWorkExperience(8);
			session.save(appDetails2); // saves session for appDetails1

			// Creating persist objects for APPLICATION_IO_LOGGING table
			ApplicationIOLogging logging = new ApplicationIOLogging();
			logging.setDestination("SAMPLE");
			logging.setSource("SAMPLE");
			logging.setRequestData("SAMPLE-DATA-1");
			logging.setLogTransDate(new Date());
			session.save(logging); // saves session for logging
			session.getTransaction().commit(); // commits the transaction
		} catch (Exception e) {
			System.out.println("Exception occurred during testing hibernate "
					+ e);
		} finally {

			if (session != null) {
				session.close(); // closes session
			}
			HibernateUtil.shutdown(); // closes session factory
		}
	}
}