package com.wpl.ws.soap.mutators;

import com.wpl.dto.model.WPLApplicationDetails;
import com.wpl.vo.model.responses.WPLRetrieveApplicationStatusResponseVO;

public class WPLRetrieveApplicationStatusMutator {

	private WPLRetrieveApplicationStatusResponseVO fetchedAppStatus = null;

	public WPLRetrieveApplicationStatusResponseVO mutateReqToAppStatus(
			WPLApplicationDetails details) {
		if (details != null) {
			fetchedAppStatus = new WPLRetrieveApplicationStatusResponseVO();
			fetchedAppStatus.setStatus(details.getApplicationStatus());
			fetchedAppStatus
					.setStatusMessage("Takes 3 days to process and provide decision");

		}
		return fetchedAppStatus;
	}
}
