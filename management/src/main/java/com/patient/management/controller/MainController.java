package com.patient.management.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
	
	@GetMapping("/login")
	public String login(){
		return "login";
	}
	
	@GetMapping("/index")
	public String home() {
		return "index";
	}

}
