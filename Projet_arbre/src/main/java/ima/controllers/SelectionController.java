package ima.controllers;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ima.dao.AdresseDAO;
import ima.dao.ArbreDAO;
import ima.dao.ClientDAO;
import ima.dao.ForetDAO;
import ima.dao.SelectionDAO;
import ima.entities.Adresse;
import ima.entities.Arbre;
import ima.entities.Client;
import ima.entities.Foret;
import ima.entities.Selection;

import ima.repository.SelectionRepositoryInterface;

@RestController
public class SelectionController {
	@Autowired
	private SelectionRepositoryInterface selectionRepositoryImpl;
	
	@GetMapping("/selections")
	public List<Selection> getSelections () {
		
		final Iterable<SelectionDAO> select = selectionRepositoryImpl.findAll();
		
		final List<Selection> ret = new ArrayList<Selection>();
		// Lambda Expression
		// Pour chaque élément (forEach) nommé "e", je l'ajoute à la liste
		select.forEach((e) -> ret.add(toSelect(e)));
		return ret;
	}
	
	@PostMapping("/createSelection") // Post => creation d'une ressource
	public HttpEntity<Selection> create(@RequestBody Selection select) {

		SelectionDAO sld = null;
		if (select == null) {
		// Conversion de l'objet Student en Etudiant
		sld = toSelectDAO(select);			
			
			// MAJ 
		selectionRepositoryImpl.save(sld);
			
			return new ResponseEntity<Selection>(toSelect(sld), HttpStatus.CREATED);

		} else 
		{
			return new ResponseEntity<Selection>(toSelect(sld), HttpStatus.BAD_REQUEST);
		}
	}	
	
	@GetMapping("/selection/{id}")
	public HttpEntity<Selection> getSelection(@PathVariable Long id) {
		
		SelectionDAO selectD;
		if(id!=null) {
		selectD = selectionRepositoryImpl.findByIdNumber(id);
		Selection select =toSelect(selectD);
			
			//Ajout des liens HATEOAS
		select.add(linkTo(methodOn(SelectionController.class).getSelection(id)).withRel("selection"));
		select.add(linkTo(methodOn(SelectionController.class).getSelection(id)).withSelfRel());
		select.add(linkTo(methodOn(SelectionController.class).getSelections()).withRel("selection"));		
			
			return new ResponseEntity<Selection>( HttpStatus.OK);
		} else {
			return new ResponseEntity<Selection>( HttpStatus.NOT_FOUND);
		}		
	}
	
	public Selection toSelect(SelectionDAO selectD) 
	{
		Selection select=new Selection();
		Arbre arbre=new Arbre();
		Client client=new Client();
		Adresse ad=new Adresse();
		Foret foret=new Foret();
		////////////
		arbre.setFamille(selectD.getArbre().getFamille());
		arbre.setNbre(selectD.getArbre().getNbre());
		arbre.setNom_p(selectD.getArbre().getNom_arbre());
		arbre.setPrix_unitaire(selectD.getArbre().getPrix());
		select.setArbre(arbre);
		///////////////
		client.setNom(selectD.getClient().getNom());
		client.setPrenom(selectD.getClient().getPrenom());
		ad.setCode_postal(selectD.getClient().getAdresse().getCode_postal());
		ad.setPays(selectD.getClient().getAdresse().getPays());
		ad.setVille(selectD.getClient().getAdresse().getVille());
		client.setAdresse(ad);
		select.setClient(client);
		///////////
		foret.setNom_f(selectD.getForet().getNom_f());
		foret.setPays(selectD.getForet().getPays());
		foret.setRegion(selectD.getForet().getRegion());
		select.setForet(foret);
		//////
		select.setNbre_selec(selectD.getNbre_selec());
		
		return select;
		
	}
	public SelectionDAO toSelectDAO(Selection select) 
	{
		SelectionDAO selectD= new SelectionDAO();
		ArbreDAO arbre=new ArbreDAO();
		ClientDAO client=new ClientDAO();
		AdresseDAO ad=new AdresseDAO();
		ForetDAO foret=new ForetDAO();
		////////////
		arbre.setFamille(select.getArbre().getFamille());
		arbre.setNbre(select.getArbre().getNbre());
		arbre.setNom_arbre(select.getArbre().getNom_p());
		arbre.setPrix(select.getArbre().getPrix_unitaire());
		selectD.setArbre(arbre);
		///////////////
		client.setNom(select.getClient().getNom());
		client.setPrenom(select.getClient().getPrenom());
		ad.setCode_postal(select.getClient().getAdresse().getCode_postal());
		ad.setPays(select.getClient().getAdresse().getPays());
		ad.setVille(select.getClient().getAdresse().getVille());
		client.setAdresse(ad);
		selectD.setClient(client);
		///////////
		foret.setNom_f(select.getForet().getNom_f());
		foret.setPays(select.getForet().getPays());
		foret.setRegion(select.getForet().getRegion());
		selectD.setForet(foret);
		select.setNbre_selec(select.getNbre_selec());
		
		
		
		
		
		return selectD;
		
	}


}
