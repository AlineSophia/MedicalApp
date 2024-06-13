package com.patient.management.service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.patient.management.dto.UserMedicationDto;
import com.patient.management.entity.Medication;
import com.patient.management.entity.User;
import com.patient.management.repository.MedicationRepository;
import com.patient.management.repository.UserRepository;

import jakarta.transaction.Transactional;

@Service
public class MedicationServiceImpl {
	
	@Autowired
	private MedicationRepository medicationRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	public User getCurrentUser() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		return userRepository.findByEmail(auth.getName());
	}
	
	
	public List<Medication> getCurrentUserMedicationList(){
		List<Medication> medi = medicationRepository.findByUser_Id(getCurrentUser().getId());
		return medi;
	}
	
	public Medication save(UserMedicationDto userMedicationDto) {
		
		Medication medicine = new Medication(userMedicationDto.getMediName(), userMedicationDto.getMediType(),
				userMedicationDto.getDosage(), getCurrentUser());
		return medicationRepository.save(medicine);
	}

	//to get an employee data 
	public Optional<Medication> getMedicationById(Long id) {
		return medicationRepository.findById(id);
				
	}
	
	//to update an employee data
	@Transactional
	public void updateMedication(Medication medicine) {
		medicationRepository.updateMedication(medicine.getMediName(), medicine.getMediType(), medicine.getDosage(), medicine.getId());
	}
	
	public void deleteMedication(Long id) {
		medicationRepository.deleteById(id);
	}
}
