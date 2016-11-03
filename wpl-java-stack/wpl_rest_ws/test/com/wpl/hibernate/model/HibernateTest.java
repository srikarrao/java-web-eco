package com.wpl.hibernate.model;

import java.util.Date;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.wpl.ws.rest.model.dto.WPLApplicationDetails;
import com.wpl.ws.rest.model.dto.WPLPublisherDetails;

/**
 * Simple JAVA class to create a session and persist sample data into the
 * respective tables
 * 
 * @author SrikarRao
 *
 */
public class HibernateTest {
	private static Session session;
	private static SessionFactory sessionFactory;

	public static void main(String[] args) {
		try {
			sessionFactory = new Configuration().configure("hibernate.cfg.xml")
					.buildSessionFactory();
			session = sessionFactory.openSession(); // create a session
			session.beginTransaction(); // begin transaction

			WPLApplicationDetails applicationDetails = new WPLApplicationDetails();
			applicationDetails.setApplicationId(1221);
			applicationDetails.setBeginDate(new Date());
			applicationDetails.setStatus("APPROVED");
			applicationDetails.setYearsGranted(3);
			
			WPLPublisherDetails publisher = new WPLPublisherDetails();
			publisher.setOfficeName("CALIF");
			publisher.setPublishedDate(new Date());
			//session.save(publisher);

			applicationDetails.setPublisherDetails(publisher);
			publisher.getApplicationDetails().add(applicationDetails);

			session.save(applicationDetails);
			session.save(publisher);
			session.getTransaction().commit(); // commits the transaction
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Exception occurred during testing hibernate "
					+ e);
		} finally {

			if (session != null) {
				session.close(); // closes session
			}
			if (sessionFactory != null) {
				sessionFactory.close();
			}
		}
	}
}