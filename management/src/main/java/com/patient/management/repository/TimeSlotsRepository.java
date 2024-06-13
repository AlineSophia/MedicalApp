package com.patient.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.patient.management.entity.TimeSlots;

@Repository
public interface TimeSlotsRepository extends JpaRepository<TimeSlots, Long>{

	@Query("select s from TimeSlots s where s.name = ?1")
	TimeSlots findByName(String time_slots);

}
