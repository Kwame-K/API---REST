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
import com.kris.demo.model.Investisseur;
import com.kris.demo.service.InvestisseurService;
@RestController
public class InvestisseurController {
	@Autowired
	private InvestisseurService service;
	
	
	@GetMapping("/investisseur")
	public List<Investisseur> findAllInvest(){
		return service.getInvestisseur();
	}
	@GetMapping("/investisseur/{id}")
	public Investisseur findInvestisseurById(@PathVariable Integer id) {
		return service.getInvestisseurById(id);
	}
	
	@PostMapping("/addInvestisseur")
	public Investisseur addInvestisseur(@RequestBody Investisseur invest) {
		return service.saveInvest(invest);
}
	@PutMapping("/updateInvestisseur")
	public Investisseur updateInvest(@RequestBody Investisseur invest) {
		return service.updateInvestisser(invest);
	}
	
	
	@DeleteMapping("/deleteInvest/{id}")
	public String deleteInvest(@PathVariable Integer id) {
	return service.deleteInvestisseur(id);
	}

}
