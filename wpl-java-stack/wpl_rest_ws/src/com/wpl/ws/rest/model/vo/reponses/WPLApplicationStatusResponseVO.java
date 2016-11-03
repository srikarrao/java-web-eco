package com.wpl.ws.rest.model.vo.reponses;

import java.util.Date;

public class WPLApplicationStatusResponseVO {

	private int appId;
	private String status;
	private String statusMessage;
	private int years;
	private Date startDate;

	public int getAppId() {
		return appId;
	}

	public void setAppId(int appId) {
		this.appId = appId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getStatusMessage() {
		return statusMessage;
	}

	public void setStatusMessage(String statusMessage) {
		this.statusMessage = statusMessage;
	}

	public int getYears() {
		return years;
	}

	public void setYears(int years) {
		this.years = years;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	@Override
	public String toString() {
		return "Application Status [appId=" + appId + ", status=" + status
				+ ", status Message=" + statusMessage + ", start date= "
				+ startDate + ", valid for" + years + "years" + " ]";
	}
}