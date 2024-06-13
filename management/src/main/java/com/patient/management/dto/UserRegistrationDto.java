package com.patient.management.dto;

public class UserRegistrationDto {

	private String firstName;
	
	private String lastName;
	
	private String email;
	
	private String password;
	
	private String careTakerName;
	
	private String careTakerPhoneNumber;
	
	private String gender;
	
	private Long phoneNumber;
	
	private String city;
	
	private String state;
	
	private Integer pincode;
	
	private String medicalConcern;

	public UserRegistrationDto(){
		
	}
	


	public UserRegistrationDto(String firstName, String lastName, String email, String password, String careTakerName,
			String careTakerPhoneNumber, String gender, Long phoneNumber, String city, String state, Integer pincode,
			String medicalConcern) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.careTakerName = careTakerName;
		this.careTakerPhoneNumber = careTakerPhoneNumber;
		this.gender = gender;
		this.phoneNumber = phoneNumber;
		this.city = city;
		this.state = state;
		this.pincode = pincode;
		this.medicalConcern = medicalConcern;
	}



	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}



	public String getCareTakerName() {
		return careTakerName;
	}



	public void setCareTakerName(String careTakerName) {
		this.careTakerName = careTakerName;
	}



	public String getCareTakerPhoneNumber() {
		return careTakerPhoneNumber;
	}



	public void setCareTakerPhoneNumber(String careTakerPhoneNumber) {
		this.careTakerPhoneNumber = careTakerPhoneNumber;
	}



	public String getGender() {
		return gender;
	}



	public void setGender(String gender) {
		this.gender = gender;
	}



	public Long getPhoneNumber() {
		return phoneNumber;
	}



	public void setPhoneNumber(Long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}



	public String getCity() {
		return city;
	}



	public void setCity(String city) {
		this.city = city;
	}



	public String getState() {
		return state;
	}



	public void setState(String state) {
		this.state = state;
	}



	public Integer getPincode() {
		return pincode;
	}



	public void setPincode(Integer pincode) {
		this.pincode = pincode;
	}



	public String getMedicalConcern() {
		return medicalConcern;
	}



	public void setMedicalConcern(String medicalConcern) {
		this.medicalConcern = medicalConcern;
	}
	
	
}
