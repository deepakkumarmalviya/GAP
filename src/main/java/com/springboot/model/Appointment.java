package com.springboot.model;



import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Appointment {

	String custId;
	String rmId;
	
	@JsonFormat(pattern= "yyyy-MM-dd@HH:mm:ss" , timezone="IST")
	Date startDateTime;
	
	@JsonFormat(pattern= "yyyy-MM-dd@HH:mm:ss" , timezone="IST")
	Date endDateTime;
	
	String comments;
	
	@JsonFormat(pattern= "yyyy-MM-dd@HH:mm:ss" , timezone="IST")
	Date lastUpdateDate;
	
	public String getCustId() {
		return custId;
	}
	public void setCustId(String custId) {
		this.custId = custId;
	}
	public String getRmId() {
		return rmId;
	}
	public void setRmId(String rmId) {
		this.rmId = rmId;
	}
	public Date getStartDateTime() {
		return startDateTime;
	}
	public void setStartDateTime(Date startDateTime) {
		this.startDateTime = startDateTime;
	}
	public Date getEndDateTime() {
		return endDateTime;
	}
	public void setEndDateTime(Date endDateTime) {
		this.endDateTime = endDateTime;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public Date getLastUpdateDate() {
		return lastUpdateDate;
	}
	public void setLastUpdateDate(Date lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
	}
	
}
