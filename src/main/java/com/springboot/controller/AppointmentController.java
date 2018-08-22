package com.springboot.controller;

import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.model.Appointment;
import com.springboot.service.AppointmentService;

@RestController
@RequestMapping("/gap")
public class AppointmentController {

	@Autowired
	AppointmentService as;

	@RequestMapping("/confirmAppointment/{custId}/{rmId}/{startDate}/{endDate}/{comments}")
	public Map<String, Appointment> confirmAppointment(@PathVariable("custId") String custId,
			@PathVariable("rmId") String rmId, @PathVariable("startTime") Date startTime,
			@PathVariable("endTime") Date endTime, @PathVariable("comments") String comments) {
		System.out.println(custId + rmId  + startTime + endTime +  comments );

		as.confirmAppointment(custId, rmId, startTime, endTime, comments);

		return null;
	}
	
	
	@RequestMapping("/confirmAppointmentd/{custId}/{rmId}/{comments}")
	public Map<String, Appointment> confirmAppointmentD(@PathVariable("custId") String custId,
			@PathVariable("rmId") String rmId,  @PathVariable("comments") String comments) {
		System.out.println(" Inside confirmAppointmentD " + custId + rmId  +  comments );

		as.confirmAppointment(custId, rmId, new Date(), new Date(), comments);

		return null;
	}

	@RequestMapping("/bookappointment/{custId}/{distance}/{needAppointment}")
	public Map<String, Appointment> bookAppointment(@PathVariable("custId") String custId,
			@PathVariable("distance") Integer distance, @PathVariable("needAppointment") String needAppointment) {
		System.out.println(custId + distance + needAppointment);

		return as.getAppointment(custId, distance, needAppointment);

	}

}
