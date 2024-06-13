package com.patient.management.entity;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Date;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "appointment")
public class Appointment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private LocalDate appointmentDate;
	
	/*
	 * @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	 * 
	 * @JoinTable( name = "appointment_slots", joinColumns = @JoinColumn(name =
	 * "appointment_id", referencedColumnName = "id"), inverseJoinColumns
	 * = @JoinColumn(name = "slot_id", referencedColumnName = "id") )
	 */
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.DETACH)
	private TimeSlots slot;
	
	@ManyToOne
	private Doctor doctor;
	
	@ManyToOne
	private User user;
	
	private String comments;
	
	public Appointment() {
		
	}

	public Appointment(LocalDate appointmentDate, TimeSlots slot, Doctor doctor, User user, String comments) {
		super();
		this.appointmentDate = appointmentDate;
		this.slot = slot;
		this.doctor = doctor;
		this.user = user;
		this.comments = comments;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getAppointmentDate() {
		return appointmentDate;
	}

	public void setAppointmentDate(LocalDate appointmentDate) {
		this.appointmentDate = appointmentDate;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public TimeSlots getSlot() {
		return slot;
	}

	public void setSlot(TimeSlots slot) {
		this.slot = slot;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}
	
	
	
	

}
