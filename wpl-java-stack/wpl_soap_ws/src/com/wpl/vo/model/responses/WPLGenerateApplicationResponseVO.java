package com.wpl.vo.model.responses;

import java.util.Date;

public class WPLGenerateApplicationResponseVO {

	private String responseMessage;
	private int appId;
	private Date date;

	public String getResponseMessage() {
		return responseMessage;
	}

	public void setResponseMessage(String responseMessage) {
		this.responseMessage = responseMessage;
	}

	public int getAppId() {
		return appId;
	}

	public void setAppId(int appId) {
		this.appId = appId;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
}