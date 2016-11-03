package com.wpl.ws.rest.model.vo.requests;

import java.util.List;
import com.wpl.ws.rest.model.vo.WPLApplicationDetailsVO;

public class WPLPersistPickedApplicationsRequestVO {
	private List<WPLApplicationDetailsVO> applicationDetails;

	public List<WPLApplicationDetailsVO> getApplicationDetails() {
		return applicationDetails;
	}

	public void setApplicationDetails(
			List<WPLApplicationDetailsVO> applicationDetails) {
		this.applicationDetails = applicationDetails;
	}

}