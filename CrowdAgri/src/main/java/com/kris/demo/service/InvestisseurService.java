package com.kris.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kris.demo.model.Investisseur;
import com.kris.demo.repository.InvestRepository;

@Service
public class InvestisseurService {
	
	@Autowired
	private InvestRepository repository;
	
	
	public Investisseur saveInvest(Investisseur inv) {
		return repository.save(inv);
	}
	
	public List<Investisseur> getInvestisseur(){
		return repository.findAll();
	}
public Investisseur getInvestisseurById(Integer id){
	return repository.findById(id).orElse(null);
}
/*public Investisseur getInvestisseurByName(String name) {
	return repository.findByName(name);
}*/
public String deleteInvestisseur(Integer id) {
	repository.deleteById(id);
	return "Investisseur supprimé " +id;
}

public Investisseur updateInvestisser(Investisseur inv) {
	Investisseur existingInvestisseur=repository.findById(inv.getId()).orElse(null);
	existingInvestisseur.setEmail(inv.getEmail());
	existingInvestisseur.setNom(inv.getNom());
	existingInvestisseur.setPrenom(inv.getPrenom());
	return repository.save(existingInvestisseur);
	
}

}
