package com.patient.management.controller;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.patient.management.dto.AppointmentDto;
import com.patient.management.dto.UserMedicationDto;
import com.patient.management.entity.Appointment;
import com.patient.management.entity.Doctor;
import com.patient.management.entity.Medication;
import com.patient.management.service.AppointmentServiceImpl;
import com.patient.management.service.DoctorServiceImpl;

@Controller
@RequestMapping("/appointment")
public class AppointmentController implements Serializable {
	
	 @DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date birthDate;
	 
	 @Autowired
	private DoctorServiceImpl doctorServiceImpl;
	 
	 @Autowired
	 private AppointmentServiceImpl appointmentServiceImpl;
		
	
	@GetMapping("/available")
	public String appointment(Model model){
		List<Doctor> doctorList = doctorServiceImpl.getListOfDoctors();
		model.addAttribute("doctorList", doctorList);
		model.addAttribute("localDate", LocalDate.now());
		return "appointment";
	}
	
	@GetMapping(value = "/availableTimeSlot/{date}")
	public String availableTimeSlot(@PathVariable String date, Model model){
		LocalDate appointmentDate = LocalDate.parse(date);
		List<Appointment> appointmentSlotList = appointmentServiceImpl.getAppointmentByDate(appointmentDate);
		if(appointmentSlotList.size() > 0) {
			model.addAttribute("appointmentSlotList", appointmentSlotList);
		} else {
			model.addAttribute("appointmentSlotList", null);
		}
		
		return "appointmentSlot";
	}
	
	@PostMapping("/bookAppointment")
	public String bookAppointment(@ModelAttribute AppointmentDto appointmentDto, Model model) {
		Appointment appointment = appointmentServiceImpl.save(appointmentDto);
		model.addAttribute("appointment", appointment);
		return "redirect:/schedule/user";
	}
	
	
	
	
	/*
	 * public static List<LocalDate> getDatesForNextFiveDays(LocalDate startDate) {
	 * 
	 * return IntStream.iterate(0, i -> i + 1) .limit(5) .mapToObj(i ->
	 * startDate.plusDays(i)) .collect(Collectors.toList()); }
	 */
	
	@ModelAttribute("appointment")
	public AppointmentDto appointmentDto() {
		return new AppointmentDto();
	}
	
	   

	
	

}
