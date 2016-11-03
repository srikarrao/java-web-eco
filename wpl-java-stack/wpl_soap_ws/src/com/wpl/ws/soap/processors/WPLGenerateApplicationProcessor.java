package com.wpl.ws.soap.processors;

import com.wpl.vo.model.requests.WPLGenerateApplicationRequestVO;
import com.wpl.vo.model.responses.WPLGenerateApplicationResponseVO;
import com.wpl.ws.soap.bo.WPLGenerateApplicationBO;

public class WPLGenerateApplicationProcessor extends WPLAbstractProcessor {

	public WPLGenerateApplicationProcessor(
			WPLGenerateApplicationRequestVO request) {
		super.request = request;
	}

	@Override
	public Object processRequest() {
		WPLGenerateApplicationRequestVO processRequest = (WPLGenerateApplicationRequestVO) super.request;
		super.response = generateApplication(processRequest);
		return super.response;
	}

	public WPLGenerateApplicationResponseVO generateApplication(
			WPLGenerateApplicationRequestVO generateApplicationRequestVO) {
		WPLGenerateApplicationResponseVO generateApplicationResponseVO = new WPLGenerateApplicationBO()
				.processGenerateApplicationData(generateApplicationRequestVO);
		return generateApplicationResponseVO;
	}
}
