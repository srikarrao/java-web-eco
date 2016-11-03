package com.wpl.ws.soap.methods;

import com.wpl.vo.model.requests.WPLGenerateApplicationRequestVO;
import com.wpl.vo.model.requests.WPLPurgeApplicationRequestVO;
import com.wpl.vo.model.requests.WPLRetrieveApplicationStatusRequestVO;
import com.wpl.vo.model.responses.WPLGenerateApplicationResponseVO;
import com.wpl.vo.model.responses.WPLPurgeApplicationResponseVO;
import com.wpl.vo.model.responses.WPLRetrieveApplicationStatusResponseVO;
import com.wpl.ws.soap.processors.WPLGenerateApplicationProcessor;
import com.wpl.ws.soap.processors.WPLPurgeApplicationProcessor;
import com.wpl.ws.soap.processors.WPLRetrieveApplicationStatusProcessor;

@javax.jws.WebService(name = "WPLApplication", serviceName = "WPLApplicationService", portName = "WPLGenerateApplicationServicePort")
public class WPLApplicationServiceImpl {

	public WPLGenerateApplicationResponseVO generateApplication(
			WPLGenerateApplicationRequestVO generateApplicationRequestVO) {
		return (WPLGenerateApplicationResponseVO) new WPLGenerateApplicationProcessor(
				generateApplicationRequestVO).processRequest();
	}

	public WPLRetrieveApplicationStatusResponseVO retrieveApplicationStatus(
			WPLRetrieveApplicationStatusRequestVO applicationStatusRequestVO) {
		return (WPLRetrieveApplicationStatusResponseVO) new WPLRetrieveApplicationStatusProcessor(
				applicationStatusRequestVO).processRequest();
	}

	public WPLPurgeApplicationResponseVO removeApplication(
			WPLPurgeApplicationRequestVO purgeApplicationRequestVO) {

		return (WPLPurgeApplicationResponseVO) new WPLPurgeApplicationProcessor(
				purgeApplicationRequestVO).processRequest();
	}
}
