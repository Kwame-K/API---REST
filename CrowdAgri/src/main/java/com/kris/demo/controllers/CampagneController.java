package com.kris.demo.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.kris.demo.model.Agriculteur;
import com.kris.demo.model.Campagne;
import com.kris.demo.service.AgriculteurService;
import com.kris.demo.service.CampagneService;

@RestController
public class CampagneController {

	//Methode metier
	
	
	@Autowired
	private CampagneService service;
	
	
	@GetMapping("/campagne")
	public List<Campagne> findAllCamp(){
		return service.getCampagnes();
	}
	@GetMapping("/campagne/{id}")
	public Campagne findCampagneById(@PathVariable Integer id) {
		return service.getCampagnesById(id);
	}
	
	@PostMapping("/addCampagne")
	public Campagne adCampagne(@RequestBody Campagne camp) {
		return service.saveCampagne(camp);
	}
	
	
		public List DoCamp() {
			List <Campagne> list = new ArrayList<Campagne>();
			List<Agriculteur> prometteur= new ArrayList<Agriculteur>();
			list=service.getCampagnes();
			 long b = 0;
			 long d=0;
			for(Campagne cam : list) {
				
		   long a = cam.getSomme_util_cinq_Ans();
		   long c = cam.getSomme_requise();
				if(a < b || c>d) {    
	               prometteur.add(cam.getAgri());
				}
				b=a;
				d=c;
			
			}
			
			return prometteur;
			
		}
		
		@PutMapping("/updateCampagne")
		public Campagne updateUser(@RequestBody Campagne camp) {
			return service.updateCampagne(camp);
		}
		
		
		@DeleteMapping("/deleteCamp/{id}")
		public String deleteUser(@PathVariable Integer id) {
		return service.deleteCampagne(id);
		}
}

