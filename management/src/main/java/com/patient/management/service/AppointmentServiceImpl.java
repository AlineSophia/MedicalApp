package com.patient.management.service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.patient.management.dto.AppointmentDto;
import com.patient.management.entity.Appointment;
import com.patient.management.entity.Doctor;
import com.patient.management.entity.TimeSlots;
import com.patient.management.entity.User;
import com.patient.management.repository.AppointmentRepository;
import com.patient.management.repository.DoctorRepository;
import com.patient.management.repository.TimeSlotsRepository;
import com.patient.management.repository.UserRepository;

@Service
public class AppointmentServiceImpl {
	
	@Autowired
	private AppointmentRepository appointmentRepository;
	
	@Autowired 
	private TimeSlotsRepository timeSlotsRepository;
	
	@Autowired
	private DoctorRepository doctorRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	public User getCurrentUser() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		return userRepository.findByEmail(auth.getName());
	}
	
	public List<Appointment> getAppointmentByDate(LocalDate date) {
		List<Appointment> appointmentTimeSlot = appointmentRepository.findByAppointmentDate(date);
		return appointmentTimeSlot;
	}
	
	public Appointment save(AppointmentDto appointmentDto) {
		TimeSlots slot = timeSlotsRepository.getById(Long.valueOf(appointmentDto.getTime_slots()));
		Doctor doctor = doctorRepository.getById(appointmentDto.getDoctorId());
		LocalDate appointmentDate = LocalDate.parse(appointmentDto.getAppointmentDate());
		Appointment appointment = new Appointment(appointmentDate, slot, doctor, getCurrentUser(), appointmentDto.getComments());
		return appointmentRepository.save(appointment);
	}
	
	public List<Appointment> getUserSchedules(){
		List<Appointment> appointments = appointmentRepository.findByUser_Id(getCurrentUser().getId());
		return appointments;
	}

}
