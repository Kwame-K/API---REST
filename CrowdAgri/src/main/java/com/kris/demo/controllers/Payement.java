package com.kris.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.kris.demo.service.AgriculteurService;
import com.kris.demo.service.CampagneService;
import com.kris.demo.service.InvestisseurService;

@RestController
public class Payement {

	

	@Autowired
	private AgriculteurService as;
	private InvestisseurService is;
	private CampagneService cs;
	
	public void payer() {}
	public void consulterPayement() {}
	public void payement() {}
	
}
