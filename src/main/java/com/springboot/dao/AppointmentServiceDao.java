package com.springboot.dao;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.springboot.model.Appointment;
import com.springboot.model.GeoLocation;

@Repository
public class AppointmentServiceDao {

	@Autowired
	JdbcTemplate jdbcTemplate;

	public void addCustomerGeoLocation(String custId, String rmId, Integer distance, String appointmentNeeded,
			String scheduled) {
		System.out.println("Adding Customer location start!!");

		jdbcTemplate.update(
				"INSERT INTO CUSTOMER_LOCATION (CUSTID, rmid, distance, APPOINTMENTNEEDED, SCHEDULED) VALUES (?, ?, ?, ?,?)",
				custId, rmId, distance, appointmentNeeded, scheduled);
		System.out.println("Customer location Added!!");

	}

	public void updateCustomerGeoLocation(String custId, String rmId, Integer distance, String appointmentNeeded,
			String scheduled) {
		System.out.println("update Customer location start!!");

		jdbcTemplate.update(
				"update CUSTOMER_LOCATION set rmid = ?  , distance = ?, APPOINTMENTNEEDED = ?, SCHEDULED = ? where custId = ?",
				rmId, distance, appointmentNeeded, scheduled, custId);
		System.out.println("update Customer location done!!");

	}

	public List getCustomerGeoLocation(String custId) {
		System.out.println("Get Customer location start!!");
		String sqlSelectQuery = "SELECT custid, rmid, distance, APPOINTMENTNEEDED , SCHEDULED  FROM CUSTOMER_LOCATION where custid = ?";

		List listContacts = jdbcTemplate.query(sqlSelectQuery, new Object[] { custId }, new RowMapper() {

			public GeoLocation mapRow(ResultSet result, int rowNum) throws SQLException {

				GeoLocation location = new GeoLocation();

				location.setCustId(result.getString("custid"));

				location.setRmId(result.getString("rmid"));

				location.setDistance(result.getInt("distance"));

				location.setIsAppointmentNeeded(result.getString("APPOINTMENTNEEDED"));

				location.setIsAppointmentNeeded(result.getString("SCHEDULED"));

				return location;

			}

		});
		System.out.println("Get Customer location done!!");
		return listContacts;
	}

	public void addAppointment(String custId, String rmId, Date startTime, Date endTime, String comments) {
		System.out.println("Adding new appointment start!!");
		java.util.Date currentDate = new java.util.Date();
		jdbcTemplate.update(
				"INSERT INTO APPOINTMENTS (custid, rmid, STARTTIME, ENDTIME , COMMENTS , LAST_UPDATE_DATE)  VALUES (?, ?, ?, ?, ?, ?)",
				custId, rmId, startTime, endTime, comments, currentDate);
		System.out.println("new appointment Added!!");

	}

	public void updateAppointment(String custId, String rmId, Date startTime, Date endTime, String comments) {
		System.out.println("update Appointment start!!");
		java.util.Date currentDate = new java.util.Date();
		jdbcTemplate.update(
				"update APPOINTMENTS set rmid = ?  , STARTTIME = ?, ENDTIME = ?, COMMENTS = ? , LAST_UPDATE_DATE = ? where custId = ?",
				rmId, startTime, endTime, comments, currentDate, custId);
		System.out.println("update Appointment done!!");

	}

	public List<Appointment> getScheduledAppointment(String custId) {
		System.out.println("Get Appointment start!!");
		String sqlSelectQuery = "SELECT custid, rmid, STARTTIME, ENDTIME , COMMENTS , LAST_UPDATE_DATE  FROM APPOINTMENTS where custid = ?";

		List<Appointment> appointmentList = jdbcTemplate.query(sqlSelectQuery, new Object[] { custId }, new RowMapper() {

			public Appointment mapRow(ResultSet result, int rowNum) throws SQLException {

				Appointment appointment = new Appointment();

				appointment.setCustId(result.getString("custid"));

				appointment.setRmId(result.getString("rmid"));

				appointment.setStartDateTime(result.getTimestamp("STARTTIME"));

				appointment.setEndDateTime(result.getTimestamp("ENDTIME"));

				appointment.setComments(result.getString("COMMENTS"));

				appointment.setLastUpdateDate(result.getTimestamp("LAST_UPDATE_DATE"));

				return appointment;

			}

		});
		System.out.println("Get Appointment Done!!");
		
		return appointmentList;
	}
}
