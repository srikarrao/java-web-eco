package com.wpl.ws.soap.processors;

import com.wpl.vo.model.requests.WPLRetrieveApplicationStatusRequestVO;
import com.wpl.vo.model.responses.WPLRetrieveApplicationStatusResponseVO;
import com.wpl.ws.soap.bo.WPLRetrieveApplicationStatusBO;

public class WPLRetrieveApplicationStatusProcessor extends WPLAbstractProcessor {

	public WPLRetrieveApplicationStatusProcessor(
			WPLRetrieveApplicationStatusRequestVO request) {
		super.request = request;
	}

	@Override
	public Object processRequest() {
		WPLRetrieveApplicationStatusRequestVO req = (WPLRetrieveApplicationStatusRequestVO) super.request;
		super.response = retrieveApplicationStatus(req);
		return super.response;
	}

	private WPLRetrieveApplicationStatusResponseVO retrieveApplicationStatus(
			WPLRetrieveApplicationStatusRequestVO request) {
		WPLRetrieveApplicationStatusResponseVO retrieveApplicationStatusResponseVO = new WPLRetrieveApplicationStatusBO()
				.retrieveApplicationStatus(request);
		return retrieveApplicationStatusResponseVO;
	}
}
