package com.patient.management.repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.patient.management.entity.Appointment;
import com.patient.management.entity.Medication;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

	@Query("select a from Appointment a where a.appointmentDate = ?1")
	List<Appointment> findByAppointmentDate(LocalDate date);
	
	public List<Appointment> findByUser_Id(Long id); 

}
