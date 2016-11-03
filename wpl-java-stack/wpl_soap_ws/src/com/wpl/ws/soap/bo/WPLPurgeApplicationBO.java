package com.wpl.ws.soap.bo;

import java.text.ParseException;
import java.util.Date;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import com.wpl.vo.model.requests.WPLPurgeApplicationRequestVO;
import com.wpl.vo.model.responses.WPLPurgeApplicationResponseVO;
import com.wpl.ws.util.WPLUtilities;
import static com.wpl.ws.util.WPLConstants.*;

public class WPLPurgeApplicationBO {
	private static Session session;
	private static SessionFactory sessionFactory = WPLUtilities
			.getSessionFactory();

	public WPLPurgeApplicationResponseVO purgeApplication(
			WPLPurgeApplicationRequestVO purgeRequest) {
		WPLPurgeApplicationResponseVO purgeResponse = null;

		if (purgeRequest != null && purgeRequest.getAppId() > 0) {
			purgeResponse = deleteApplication(purgeRequest.getAppId(),
					purgeRequest.getDate());
		} else {
			purgeResponse = new WPLPurgeApplicationResponseVO();
			purgeResponse.setAcknowledgement("Invalid appId");
		}
		return purgeResponse;
	}

	private WPLPurgeApplicationResponseVO deleteApplication(int appId, Date date) {
		WPLPurgeApplicationResponseVO acknowledgment = null;

		try {
			session = sessionFactory.openSession();
			session.beginTransaction();
			date = SDF.parse(SDF.format(date));
			acknowledgment = new WPLPurgeApplicationResponseVO();
			if (date != null && date.equals(TODAYS_DATE)) {
				Query query = null;
				query = session
						.createQuery("delete WPLApplicationDetails where applicationId = :appId");
				query.setInteger("appId", appId);
				int result = query.executeUpdate();
				if (result > 0) {
					acknowledgment
							.setAcknowledgement("Application removed successfully");
				} else {
					acknowledgment.setAcknowledgement("Application not found");
				}
				session.getTransaction().commit();
			} else {
				acknowledgment
						.setAcknowledgement("Application cannot be removed, it's in processing. Check status.");
			}
		} catch (ParseException e) {
			System.err
					.println("Failed to parse date in purge application " + e);
		} catch (Exception e) {
			System.err.println("Failed to purge application " + e);
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return acknowledgment;
	}
}