package com.wpl.ws.rest.model.dto;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

public class WPLApplicationDetails implements Serializable {

	private static final long serialVersionUID = 9077778L;
	private int applicationId;
	private WPLPublisherDetails publisherDetails;
	private String status;
	@Temporal(TemporalType.DATE)
	private Date beginDate;
	private int yearsGranted;

	public int getApplicationId() {
		return applicationId;
	}

	public void setApplicationId(int applicationId) {
		this.applicationId = applicationId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getBeginDate() {
		return beginDate;
	}

	public void setBeginDate(Date beginDate) {
		this.beginDate = beginDate;
	}

	public int getYearsGranted() {
		return yearsGranted;
	}

	public void setYearsGranted(int yearsGranted) {
		this.yearsGranted = yearsGranted;
	}

	public WPLPublisherDetails getPublisherDetails() {
		return publisherDetails;
	}

	public void setPublisherDetails(WPLPublisherDetails publisherDetails) {
		this.publisherDetails = publisherDetails;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
