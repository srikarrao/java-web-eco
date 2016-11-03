package com.wpl.ws.soap.bo;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.wpl.dto.model.WPLApplicationDetails;
import com.wpl.vo.model.requests.WPLGenerateApplicationRequestVO;
import com.wpl.vo.model.responses.WPLGenerateApplicationResponseVO;
import com.wpl.ws.soap.mutators.WPLGenerateApplicationMutator;
import com.wpl.ws.util.WPLUtilities;

/**
 * 
 * @author SrikarRao
 *
 */
public class WPLGenerateApplicationBO {

	private static Session session;
	private static SessionFactory sessionFactory = WPLUtilities
			.getSessionFactory();
	private WPLGenerateApplicationMutator generateMutator = null;

	public WPLGenerateApplicationResponseVO processGenerateApplicationData(
			WPLGenerateApplicationRequestVO requestData) {
		persistApplicationData(requestData);
		WPLGenerateApplicationResponseVO applicationInfo = fetchApplicationData(
				requestData.getSsn(), requestData.getEmployeeId());
		return applicationInfo;
	}

	@SuppressWarnings("unchecked")
	private void persistApplicationData(
			WPLGenerateApplicationRequestVO generateApplicationRequest) {
		try {
			// fetch Session factory object invoking getSessionFactoty method
			session = sessionFactory.openSession(); // create a session
			session.beginTransaction(); // begin transaction

			generateMutator = new WPLGenerateApplicationMutator();
			// Creating persist objects for APPLICATION_DETAILS table
			WPLApplicationDetails appDetails = generateMutator
					.mutateReqToApplicationDetails(generateApplicationRequest);
			if (null != appDetails) {
				Query query = session
						.createQuery("from WPLApplicationDetails where ssn = :ssn and employeeId = :employeeId");
				query.setParameter("ssn", appDetails.getSsn());
				query.setParameter("employeeId", appDetails.getEmployeeId());
				List<WPLApplicationDetails> list = query.list();

				if (list.size() == 0) {
					session.save(appDetails);
				}
				session.getTransaction().commit(); // commits the transaction
			}
		} catch (Exception e) {
			System.out.println("Exception occurred during testing hibernate "
					+ e);
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	@SuppressWarnings("unchecked")
	private WPLGenerateApplicationResponseVO fetchApplicationData(String ssn,
			String employeeId) {
		WPLGenerateApplicationResponseVO applicationData = null;
		try {
			session = sessionFactory.openSession(); // create a session
			session.beginTransaction(); // begin transaction
			Query query = session
					.createQuery("from WPLApplicationDetails where ssn = :ssn and employeeId = :employeeId");
			query.setParameter("ssn", ssn);
			query.setParameter("employeeId", employeeId);
			List<WPLApplicationDetails> list = query.list();

			if (list.size() > 0) {
				WPLApplicationDetails details = (WPLApplicationDetails) list
						.get(0);
				generateMutator = new WPLGenerateApplicationMutator();
				applicationData = generateMutator
						.mutateReqToApplicationStatus(details);
			}
		} catch (Exception e) {
			System.out.println("Exception occurred during testing hibernate "
					+ e);
		} finally {
			if (session != null) {
				session.close(); // closes session
			}
		}
		return applicationData;
	}
}