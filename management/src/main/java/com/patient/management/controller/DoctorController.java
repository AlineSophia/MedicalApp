package com.patient.management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.patient.management.entity.Doctor;
import com.patient.management.service.DoctorServiceImpl;

@Controller
@RequestMapping("/doctor")
public class DoctorController {
	
	@Autowired
	private DoctorServiceImpl doctorServiceImpl;
	
	@GetMapping("/details")
	public String getListOfDoctors(Model model) {
		List<Doctor> doctorList = doctorServiceImpl.getListOfDoctors();
		model.addAttribute("doctorList", doctorList);
		return "doctorDetails";
	}
	

	
	
}
