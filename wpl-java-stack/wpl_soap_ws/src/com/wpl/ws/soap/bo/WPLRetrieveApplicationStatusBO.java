package com.wpl.ws.soap.bo;

import java.util.Date;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import com.wpl.dto.model.WPLApplicationDetails;
import com.wpl.vo.model.requests.WPLRetrieveApplicationStatusRequestVO;
import com.wpl.vo.model.responses.WPLRetrieveApplicationStatusResponseVO;
import com.wpl.ws.soap.mutators.WPLRetrieveApplicationStatusMutator;
import com.wpl.ws.util.WPLUtilities;
import static com.wpl.ws.util.WPLConstants.*;

public class WPLRetrieveApplicationStatusBO {
	private static Session session;
	private static SessionFactory sessionFactory = WPLUtilities
			.getSessionFactory();
	private WPLRetrieveApplicationStatusMutator applicationStatusMutator = null;

	public WPLRetrieveApplicationStatusResponseVO retrieveApplicationStatus(
			WPLRetrieveApplicationStatusRequestVO retrieveApplicationStatusRequest) {
		WPLRetrieveApplicationStatusResponseVO applicationStatus = null;
		if (retrieveApplicationStatusRequest != null
				&& retrieveApplicationStatusRequest.getAppId() != 0
				&& retrieveApplicationStatusRequest.getDate() != null) {
			applicationStatus = fetchApplicationStatus(
					retrieveApplicationStatusRequest.getAppId(),
					retrieveApplicationStatusRequest.getDate());
			if (applicationStatus == null) {
				applicationStatus = new WPLRetrieveApplicationStatusResponseVO();
			}
		}
		return applicationStatus;
	}

	@SuppressWarnings("unchecked")
	private WPLRetrieveApplicationStatusResponseVO fetchApplicationStatus(
			int appId, Date date) {

		WPLRetrieveApplicationStatusResponseVO fetchedAppStatus = null;
		try {
			session = sessionFactory.openSession(); // create a session
			session.beginTransaction(); // begin transaction
			Query query = null;

			date = SDF.parse(SDF.format(date));
			if (date != null && date.equals(TODAYS_DATE)) {
				query = session
						.createQuery("from WPLApplicationDetails where applicationId = :appId");
				query.setInteger("appId", appId);
				List<WPLApplicationDetails> list = query.list();
				if (list.size() > 0) {
					WPLApplicationDetails details = (WPLApplicationDetails) list
							.get(0);
					applicationStatusMutator = new WPLRetrieveApplicationStatusMutator();
					fetchedAppStatus = applicationStatusMutator
							.mutateReqToAppStatus(details);
				} else {
					fetchedAppStatus = new WPLRetrieveApplicationStatusResponseVO();
					fetchedAppStatus.setStatusMessage("Application not found");
				}
			} else {
				fetchedAppStatus = new WPLRetrieveApplicationStatusResponseVO();
				fetchedAppStatus
						.setStatusMessage("REST service under process!!");
			}
		} catch (Exception e) {
			System.out
					.println("Exception occurred during retrieval of application status "
							+ e);
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return fetchedAppStatus;
	}
}