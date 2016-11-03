package com.wpl.hibernate.model;

import java.util.Date;
import javax.persistence.Lob;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
/**
 * JAVA Persistent class to persist objects in the APPLICATION_IO_LOGGING table
 * @author SrikarRao
 *
 */
public class ApplicationIOLogging {

	private int logTransId;
	
	@Temporal(TemporalType.DATE)
	private Date logTransDate;
	private String source;
	@Lob
	private String requestData;
	private String destination;
	@Lob
	private String responseData;

	public int getLogTransId() {
		return logTransId;
	}

	public void setLogTransId(int logTransId) {
		this.logTransId = logTransId;
	}

	public Date getLogTransDate() {
		return logTransDate;
	}

	public void setLogTransDate(Date logTransDate) {
		this.logTransDate = logTransDate;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getRequestData() {
		return requestData;
	}

	public void setRequestData(String requestData) {
		this.requestData = requestData;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getResponseData() {
		return responseData;
	}

	public void setResponseData(String responseData) {
		this.responseData = responseData;
	}
}