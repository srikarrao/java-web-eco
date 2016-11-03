package com.wpl.vo.model.requests;

import java.util.Date;

public class WPLPurgeApplicationRequestVO {

	private int appId;
	private Date date;

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
