package com.patient.management.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.patient.management.entity.Doctor;
import com.patient.management.repository.DoctorRepository;

@Service
public class DoctorServiceImpl {

	@Autowired
	private DoctorRepository doctorRepository;
	
	public List<Doctor> getListOfDoctors(){
		return doctorRepository.findAll();
	}
}
