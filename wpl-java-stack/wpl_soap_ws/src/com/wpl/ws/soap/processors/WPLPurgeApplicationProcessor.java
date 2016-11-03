package com.wpl.ws.soap.processors;

import com.wpl.vo.model.requests.WPLPurgeApplicationRequestVO;
import com.wpl.vo.model.responses.WPLPurgeApplicationResponseVO;
import com.wpl.ws.soap.bo.WPLPurgeApplicationBO;

public class WPLPurgeApplicationProcessor extends WPLAbstractProcessor {

	public WPLPurgeApplicationProcessor(WPLPurgeApplicationRequestVO request) {
		super.request = request;
	}

	@Override
	public Object processRequest() {
		WPLPurgeApplicationRequestVO purgeApplicationRequest = (WPLPurgeApplicationRequestVO) super.request;
		super.response = removeApplication(purgeApplicationRequest);
		return super.response;
	}

	public WPLPurgeApplicationResponseVO removeApplication(
			WPLPurgeApplicationRequestVO purgeApplicationRequest) {
		WPLPurgeApplicationResponseVO purgeApplicationResponse = new WPLPurgeApplicationBO()
				.purgeApplication(purgeApplicationRequest);
		return purgeApplicationResponse;
	}
}