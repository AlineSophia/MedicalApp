package com.patient.management.controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.patient.management.dto.UserMedicationDto;
import com.patient.management.entity.Medication;
import com.patient.management.service.MedicationServiceImpl;

@Controller
@RequestMapping("/medication")
public class MedicationController {
	
	@Autowired
	private MedicationServiceImpl medicationServiceImpl;
	
	@GetMapping("/list")
	public String getListOfMedications(Model model) {
		List<Medication> medicine = medicationServiceImpl.getCurrentUserMedicationList();
		if(medicine.isEmpty()) {
			return "medicationDetails";
		} else {
			model.addAttribute("medicine", medicine);
			return "medicationDetails";
		}
	}
	
	@GetMapping("/addMedication")
	public String addUser() {
		return "addMedication";
	}
	
	@PostMapping("/submitMedication")
	public String addUser(@ModelAttribute UserMedicationDto userMedicationDto, Model model) {
		Medication medicine = medicationServiceImpl.save(userMedicationDto);
		model.addAttribute("medicine", medicine);
		return "redirect:/medication/list";
	}
	
	@GetMapping("/viewMedicine/{id}")
	public String viewUser(@PathVariable Long id, Model model) {
		Optional<Medication> medication = medicationServiceImpl.getMedicationById(id);
		model.addAttribute("medication", medication.get());
		return "viewMedicine";
	}
	
	@GetMapping("/updateMedicine/{id}")
	public String updateUser(@PathVariable Long id, Model model) {
		Optional<Medication> medication = medicationServiceImpl.getMedicationById(id);
		model.addAttribute("medication", medication.get());
		return "updateMedicine";
	}
	
	@PostMapping("/updateMedicine")
	public String updateUser(@ModelAttribute Medication medication, Model model) {
		medicationServiceImpl.updateMedication(medication);
		return "redirect:/medication/list?updatesuccess";
	}
	
	@GetMapping("/deleteMedicine/{id}")
	public String deleteUser(@PathVariable Long id) {
		medicationServiceImpl.deleteMedication(id);
		return "redirect:/medication/list?deletesuccess";
	}

}
