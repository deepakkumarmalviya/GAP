package com.springboot.model;

public class GeoLocation {

	String custId;
	String rmId;
	Integer distance;
	String isScheduled;
	String isAppointmentNeeded;
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
	public Integer getDistance() {
		return distance;
	}
	public void setDistance(Integer distance) {
		this.distance = distance;
	}
	public String getIsScheduled() {
		return isScheduled;
	}
	public void setIsScheduled(String isScheduled) {
		this.isScheduled = isScheduled;
	}
	public String getIsAppointmentNeeded() {
		return isAppointmentNeeded;
	}
	public void setIsAppointmentNeeded(String isAppointmentNeeded) {
		this.isAppointmentNeeded = isAppointmentNeeded;
	}
	

}
