package com.wpl.ws.soap.handlers;

import java.util.Date;

import com.wpl.dto.model.WPLApplicationDetails;
import com.wpl.dto.model.WPLApplicationIOLogging;

public class WPLApplicationHandler {

	private WPLApplicationIOLogging logging = null;

	public WPLApplicationIOLogging logGenerateApplicationService(
			WPLApplicationDetails appDetails) {

		if (appDetails != null) {
			logging = new WPLApplicationIOLogging();
			logging.setDestination("WPl-SOAP-DB");
			logging.setSource("WPL_SOAP");
			logging.setRequestData(appDetails.getSsn() + "||"
					+ appDetails.getEmployeeId() + "||" + appDetails.getName()
					+ "||" + appDetails.getAge() + "||"
					+ appDetails.getWorkExperience() + "||"
					+ appDetails.getCategory() + "||"
					+ appDetails.getApplicationStatus() + "||"
					+ appDetails.getAppliedDate());
			logging.setLogTransDate(new Date());
		}
		return logging;
	}
}