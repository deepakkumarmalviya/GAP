package com.springboot.service;



import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.dao.AppointmentServiceDao;
import com.springboot.model.Appointment;



@Service
public class AppointmentService {
	
	@Autowired
    AppointmentServiceDao appointmentServiceDao;
	
	
	/**
	 * 
	 */
	public AppointmentService() {
	
	}

	
	
	
	public Map<String, Appointment> confirmAppointment(String custId, String rmId, Date startTime, Date endTime , String comments){
		List appointmentList  = appointmentServiceDao.getScheduledAppointment(custId);
		if(appointmentList != null && appointmentList.size() > 0 ){
		 appointmentServiceDao.updateAppointment(custId, rmId,startTime , endTime, comments);
		}else{
			appointmentServiceDao.addAppointment(custId, rmId, startTime, endTime, comments);
		}
		List<Appointment> updateAppointmentList  =  appointmentServiceDao.getScheduledAppointment(custId);
		Map<String, Appointment> scheduledAppointment = new HashMap<>(); 
		for (Appointment appointment : updateAppointmentList) {
			scheduledAppointment.put(appointment.getCustId(), appointment);
		}
		return scheduledAppointment;
	}

	public Map<String, Appointment> getAppointment(String custId, Integer distance, String needAppointment ) {
		List customerList  = appointmentServiceDao.getCustomerGeoLocation(custId);
		if(customerList != null && customerList.size() > 0 ){
		 appointmentServiceDao.updateCustomerGeoLocation(custId, "r2", distance, needAppointment, "N");
		}else{
			appointmentServiceDao.addCustomerGeoLocation(custId, "r1", distance, needAppointment, "Y");
		}
		
		List<Appointment> appointmentList  =  appointmentServiceDao.getScheduledAppointment(custId);
		Map<String, Appointment> scheduledAppointment = new HashMap<>(); 
		for (Appointment appointment : appointmentList) {
			scheduledAppointment.put(appointment.getCustId(), appointment);
		}
		return scheduledAppointment;
	}
	
}
