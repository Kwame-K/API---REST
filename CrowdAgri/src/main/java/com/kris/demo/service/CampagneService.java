package com.kris.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kris.demo.model.Campagne;
import com.kris.demo.repository.CampagneRepository;

@Service
public class CampagneService {
	
	@Autowired
	private CampagneRepository repository;
	
	
public Campagne saveCampagne(Campagne campagne)
{
	return repository.save(campagne);
	}

public List<Campagne> saveCampagnes(List<Campagne> campagnes)
{
	return repository.saveAll(campagnes);
	}

public List<Campagne> getCampagnes()
{
	return repository.findAll();
	}

public Campagne getCampagnesById(Integer id)
{
	return repository.findById(id).orElse(null);
	}
/*public Campagne getCampagnesByTime(String time)
{
	return repository.findByTime(time);
	}
*/
public String deleteCampagne(Integer id) {
	repository.deleteById(id);
	return "Campagne supprimée"+id;
}

public Campagne updateCampagne(Campagne campagne) {
	Campagne existingCampagne=repository.findById(campagne.getId()).orElse(null);
	existingCampagne.setIntitule(campagne.getIntitule());
	existingCampagne.setSomme_requise(campagne.getSomme_requise());
	existingCampagne.setSomme_util_cinq_Ans(campagne.getSomme_util_cinq_Ans());
	existingCampagne.setPhoto_camp(campagne.getPhoto_camp());
	existingCampagne.setTemps_production(campagne.getTemps_production());
	return repository.save(existingCampagne);
	
}
}
