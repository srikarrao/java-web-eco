package com.wpl.hibernate.model;

import java.util.Date;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * JAVA Persistent class to persist objects in the APPLICATION_DETAILS table
 * 
 * @author SrikarRao
 *
 */
public class ApplicationDetails {

	private int applicationId;
	private String ssn;
	private String category;
	private String name;
	private int age;
	private int workExperience;
	private String applicationStatus;
	@Temporal(TemporalType.DATE)
	private Date appliedDate;

	public int getApplicationId() {
		return applicationId;
	}

	public void setApplicationId(int applicationId) {
		this.applicationId = applicationId;
	}

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getWorkExperience() {
		return workExperience;
	}

	public void setWorkExperience(int workExperience) {
		this.workExperience = workExperience;
	}

	public String getApplicationStatus() {
		return applicationStatus;
	}

	public void setApplicationStatus(String applicationStatus) {
		this.applicationStatus = applicationStatus;
	}

	public Date getAppliedDate() {
		return appliedDate;
	}

	public void setAppliedDate(Date appliedDate) {
		this.appliedDate = appliedDate;
	}
}