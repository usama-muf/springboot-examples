package com.usama.oauth2authorizationdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller

public class HomeController {
	
	@GetMapping("/hello")
	public String hello() {
		return "Hello";
	}
	
	@GetMapping("/home")
	public String home() {
		return "home";
	}
	
	

}
