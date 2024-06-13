package com.patient.management.dto;


public class UserMedicationDto {

	private Long id;
	
	private String mediName;
	
	private String mediType;
	
	private String dosage;
	
	public UserMedicationDto() {
	}

	public UserMedicationDto(String mediName, String mediType, String dosage) {
		super();
		this.mediName = mediName;
		this.mediType = mediType;
		this.dosage = dosage;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMediName() {
		return mediName;
	}

	public void setMediName(String mediName) {
		this.mediName = mediName;
	}

	public String getMediType() {
		return mediType;
	}

	public void setMediType(String mediType) {
		this.mediType = mediType;
	}

	public String getDosage() {
		return dosage;
	}

	public void setDosage(String dosage) {
		this.dosage = dosage;
	}
	
	
}
