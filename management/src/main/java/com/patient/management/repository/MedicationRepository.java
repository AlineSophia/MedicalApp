package com.patient.management.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.patient.management.entity.Medication;

@Repository
public interface MedicationRepository extends JpaRepository<Medication, Long>{
	
	public List<Medication> findByUser_Id(Long id); 
	
	@Modifying
	@Query("update Medication e set e.mediName = ?1, e.mediType = ?2, e.dosage = ?3 where e.id = ?4")	
	void updateMedication(String mediName, String mediType, String dosage, Long id);

}
