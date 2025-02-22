package ima.controllers;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ima.dao.ForetDAO;

import ima.entities.Foret;

import ima.repository.ForetRepositoryInterface;

@RestController
public class ForetController {
	@Autowired
	private ForetRepositoryInterface foretRepositoryImpl;
	
	@GetMapping("/forets")
	public List<Foret> getForets () {
		
		final Iterable<ForetDAO> forets = foretRepositoryImpl.findAll();
		
		final List<Foret> ret = new ArrayList<Foret>();
		// Lambda Expression
		// Pour chaque élément (forEach) nommé "e", je l'ajoute à la liste
		forets.forEach((e) -> ret.add(toForet(e)));
		return ret;
	}
	
	
	//Post => creation d'une ressource
	@PostMapping("/createForet")
	public HttpEntity<Foret> create(@RequestBody Foret foret) {
		
		ForetDAO fd = null;
		
		if (foret != null) {
			// Conversion de l'objet Student en Etudiant
			fd = toForetDAO(foret);			
			// MAJ 
			foretRepositoryImpl.save(fd);
			
			return new ResponseEntity<Foret>(toForet(fd), HttpStatus.CREATED);
			} 
		else {
			return new ResponseEntity<Foret>(toForet(fd), HttpStatus.BAD_REQUEST);
		}
	}		
	
	
	@DeleteMapping("/deleteForet/{id}")
	public HttpEntity<Foret> delete(@PathVariable(name="id", required=true) Long id) {
		
		Optional<ForetDAO> ford = foretRepositoryImpl.findById(id);
		
		if (ford != null){
			foretRepositoryImpl.deleteById(ford.get().getId_foret());
		}
		return new ResponseEntity<Foret>(HttpStatus.NO_CONTENT);
	}		
	
	
	
	@GetMapping("/foret/{name}")
	public HttpEntity<Foret> getForet(@PathVariable String name) {

		ForetDAO ford = foretRepositoryImpl.findForetByName(name);
			if(name!=null) {
			Foret foret = toForet(ford);
			
			//Ajout des liens HATEOAS
			foret.add(linkTo(methodOn(ForetController.class).getForet(name)).withRel("foret"));
			foret.add(linkTo(methodOn(ForetController.class).getForet(name)).withSelfRel());
			foret.add(linkTo(methodOn(ForetController.class).getForets()).withRel("foret"));		
			
			return new ResponseEntity<Foret>( HttpStatus.OK);
		} 
			else {
			return new ResponseEntity<Foret>(HttpStatus.NOT_FOUND);
		}		
	}
	
	
	public Foret toForet(ForetDAO ford) 
	{
		Foret foret=new Foret();
		foret.setNom_f(ford.getNom_f());
		foret.setPays(ford.getPays());
		foret.setRegion(ford.getRegion());
		return foret;
		
	}
	public ForetDAO toForetDAO(Foret foret) 
	{
		ForetDAO ford= new ForetDAO();
		ford.setNom_f(foret.getNom_f());
		ford.setPays(foret.getPays());
		ford.setRegion(foret.getRegion());
		
		
		return ford;
		
	}

}
