package com.wpl.ws.soap.mutators;

import com.wpl.dto.model.WPLApplicationDetails;
import com.wpl.vo.model.requests.WPLGenerateApplicationRequestVO;
import com.wpl.vo.model.responses.WPLGenerateApplicationResponseVO;

public class WPLGenerateApplicationMutator {

	private WPLApplicationDetails appDetails = null;

	public WPLApplicationDetails mutateReqToApplicationDetails(
			WPLGenerateApplicationRequestVO requestData) {

		if (requestData != null) {
			appDetails = new WPLApplicationDetails();

			if (null != requestData.getEmployeeId()) {
				appDetails.setEmployeeId(requestData.getEmployeeId());
			}
			if (null != requestData.getSsn()) {
				appDetails.setSsn(requestData.getSsn());
			}
			if (null != requestData.getName()) {
				appDetails.setName(requestData.getName());
			}
			if (requestData.getAge() > 0) {
				appDetails.setAge(requestData.getAge());
			}
			if (requestData.getWorkExperience() >= 0) {
				appDetails.setWorkExperience(requestData.getWorkExperience());
			}
			if (null != requestData.getStatus()) {
				appDetails.setApplicationStatus(requestData.getStatus());
			}
			if (null != requestData.getCategory()) {
				appDetails.setCategory(requestData.getCategory());
			}
			if (null != requestData.getDate()) {
				appDetails.setAppliedDate(requestData.getDate());
			}
		}
		return appDetails;
	}

	public WPLGenerateApplicationResponseVO mutateReqToApplicationStatus(
			WPLApplicationDetails appDetails) {
		WPLGenerateApplicationResponseVO applicationData = null;
		if (null != appDetails) {
			applicationData = new WPLGenerateApplicationResponseVO();
			applicationData.setAppId(appDetails.getApplicationId());
			applicationData.setDate(appDetails.getAppliedDate());
			applicationData
					.setResponseMessage("Use the date and application Id to check status");
		}
		return applicationData;
	}
}