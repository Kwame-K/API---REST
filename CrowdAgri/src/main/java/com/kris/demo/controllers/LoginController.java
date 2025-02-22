package com.kris.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kris.demo.service.LoginService;

@RestController
public class LoginController {

	
	@Autowired
	private LoginService service;
	
	
	
	public String showLoginPage(ModelMap modelMap) {
		System.out.println("Login");
		return "login";
	}
	
	public String showWelcomePage(ModelMap model, @RequestParam String name, @RequestParam String password) {
		boolean isValidUser = service.validateUser(name, password);
		
		if (!isValidUser) {
			model.put("errorMessage", "Invalid Credentials");
			return "login";
		}
		System.out.println("User logged");
		
		model.put("name", name);
		model.put("password", password);
		
		return "welcome";
	}
	
}
