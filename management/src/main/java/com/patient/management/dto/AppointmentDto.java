package com.patient.management.dto;

import java.time.LocalDate;
import java.util.Date;

import com.patient.management.entity.Doctor;

public class AppointmentDto {

	private String appointmentDate;
	
	private String time_slots;
	
	private Long doctorId;
	
	private String comments;

	public String getAppointmentDate() {
		return appointmentDate;
	}

	public void setAppointmentDate(String appointmentDate) {
		this.appointmentDate = appointmentDate;
	}

	public String getTime_slots() {
		return time_slots;
	}

	public void setTime_slots(String time_slots) {
		this.time_slots = time_slots;
	}

	public Long getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(Long doctorId) {
		this.doctorId = doctorId;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}
	
	
	
	
}
