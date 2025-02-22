package com.kris.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kris.demo.model.Agriculteur;
import com.kris.demo.repository.AgriRepository;

@Service
public class AgriculteurService {
	
	@Autowired
	private AgriRepository repository;
	
	public Agriculteur saveAgriculteur(Agriculteur agri) {
		return repository.save(agri);
	}

	public List<Agriculteur> getAgriculteur(){
		return repository.findAll();
	}
	
	public Agriculteur getAgriculteurById(Integer id) {
		return repository.findById(id).orElse(null);
	}
	
	public String deleteAgriculteur(Integer id) {
		repository.deleteById(id);
		return "Agriculteur supprimé "+id;
	}
	
	public Agriculteur updateAgriculteur(Agriculteur agri) {
		Agriculteur existingagri = repository.findById(agri.getId()).orElse(null);
		existingagri.setNom(agri.getNom());
		existingagri.setPrenom(agri.getPrenom());
		existingagri.setAdresse(agri.getAdresse());
		existingagri.setEmail(agri.getEmail());
		existingagri.setTel(agri.getTel());
		return repository.save(agri);
		
	}
	
}
