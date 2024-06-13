package com.patient.management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.patient.management.entity.Appointment;
import com.patient.management.entity.Doctor;
import com.patient.management.service.AppointmentServiceImpl;

@Controller
@RequestMapping("/schedule")
public class ScheduleController {
	
	@Autowired
	private AppointmentServiceImpl appointmentServiceImpl;
	
	@GetMapping("/user")
	public String getUserSchedule(Model model) {
		List<Appointment> schedules = appointmentServiceImpl.getUserSchedules();
		model.addAttribute("schedules", schedules);
		return "schedules";
	}

}
