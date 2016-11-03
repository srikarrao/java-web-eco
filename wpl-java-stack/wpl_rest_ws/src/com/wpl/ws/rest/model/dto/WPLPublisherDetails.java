package com.wpl.ws.rest.model.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

public class WPLPublisherDetails implements Serializable {

	private static final long serialVersionUID = 19558554L;
	private int publisherId;
	private Set<WPLApplicationDetails> applicationDetails = new HashSet<WPLApplicationDetails>(
			0);
	private String officeName;
	@Temporal(TemporalType.DATE)
	private Date publishedDate;

	public int getPublisherId() {
		return publisherId;
	}

	public void setPublisherId(int publisherId) {
		this.publisherId = publisherId;
	}

	public Set<WPLApplicationDetails> getApplicationDetails() {
		return applicationDetails;
	}

	public void setApplicationDetails(
			Set<WPLApplicationDetails> applicationDetails) {
		this.applicationDetails = applicationDetails;
	}

	public String getOfficeName() {
		return officeName;
	}

	public void setOfficeName(String officeName) {
		this.officeName = officeName;
	}

	public Date getPublishedDate() {
		return publishedDate;
	}

	public void setPublishedDate(Date publishedDate) {
		this.publishedDate = publishedDate;
	}
}