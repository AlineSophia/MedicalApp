package com.patient.management.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.patient.management.dto.UserRegistrationDto;
import com.patient.management.entity.User;

public interface UserService extends UserDetailsService{
	
	User save(UserRegistrationDto registrationDto);

}
