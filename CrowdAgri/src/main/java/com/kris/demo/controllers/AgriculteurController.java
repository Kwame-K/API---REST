package com.kris.demo.controllers;

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
import com.kris.demo.model.User;
import com.kris.demo.service.AgriculteurService;

@RestController
public class AgriculteurController {
	
	@Autowired
	private AgriculteurService service;

	@GetMapping("/agriculteur")
	public List<Agriculteur> findAllAgri(){
		return service.getAgriculteur();
	}
	@GetMapping("/agriculteur/{id}")
	public Agriculteur findAgriculteurById(@PathVariable Integer id) {
		return service.getAgriculteurById(id);
	}
	
	@PostMapping("/addAgriculteur")
	public Agriculteur addAgriculteur(@RequestBody Agriculteur agri) {
		return service.saveAgriculteur(agri);
}
	
	@PutMapping("/updateAgriculteur")
	public Agriculteur updateUser(@RequestBody Agriculteur agri) {
		return service.updateAgriculteur(agri);
	}
	
	
	@DeleteMapping("/deleteAgri/{id}")
	public String deleteUser(@PathVariable Integer id) {
	return service.deleteAgriculteur(id);
	}
	
}
