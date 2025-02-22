package ima.controllers;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.ArrayList;
import java.util.List;

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
import ima.dao.ArbreDAO;
import ima.entities.Arbre;
import ima.repository.ArbreRepositoryInterface;

@RestController
public class ArbreController {
	@Autowired
	private ArbreRepositoryInterface arbreRepositoryImpl;
	
	//Acces à la ressource arbre
	@GetMapping("/arbres")
	public List<Arbre> getArbres () {
		
		final Iterable<ArbreDAO> arbres = arbreRepositoryImpl.findAll();
		
		final List<Arbre> ret = new ArrayList<Arbre>();
		// Lambda Expression
		// Pour chaque élément (forEach) nommé "e", je l'ajoute à la liste
		
		arbres.forEach((e) -> ret.add(toArbre(e)));

		return ret;
	}
	
	//Acces à la liste des arbres trie par essence(famille)
	@GetMapping("/listParEssence")
	public List<Arbre> list()
	{
		Iterable<ArbreDAO> ar = new ArrayList<ArbreDAO>();
		ar = arbreRepositoryImpl.findArbreByEssence();
		final List<Arbre> ret = new ArrayList<Arbre>();
		ar.forEach((e) -> ret.add(toArbre(e)));
		return ret;
	}
	
	//Acces à la liste des arbres trie par foret
	@GetMapping("/listParForet")
	public List<Arbre> listForet()
	{
		Iterable<ArbreDAO> ar = new ArrayList<ArbreDAO>();
		ar = arbreRepositoryImpl.findArbreByForet();
		final List<Arbre> ret = new ArrayList<Arbre>();
		ar.forEach((e) -> ret.add(toArbre(e)));
		return ret;
	}
	
	//creation d'une ressource arbre 
	@PostMapping("/createArbre")
	public HttpEntity<Arbre> create(@RequestBody Arbre arbre) {
		// Nous créeons l'objet
		ArbreDAO ard = null;
		if(arbre!=null) 
		{
		// Conversion de l'objet ArbreDAO en Arbre
		ard = toArbreDAO(arbre);			
			// MAJ 
		arbreRepositoryImpl.save(ard);
			
		return new ResponseEntity<Arbre>(toArbre(ard), HttpStatus.CREATED);
		
		} 
		
		else {
			return new ResponseEntity<Arbre>(toArbre(ard), HttpStatus.BAD_REQUEST);
		}
	}		
	//Suppression de ressource 
	@DeleteMapping("/deleteArbre/{name}")
	public HttpEntity<Arbre> delete(@PathVariable(name="name", required=true) String name) {
		
		ArbreDAO arb = new ArbreDAO();
		
		 arb = arbreRepositoryImpl.findArbreByName(name);
		
		if (arb != null){
			//arbreRepositoryImpl.delete(arb);
		}
		
		return new ResponseEntity<Arbre>(HttpStatus.NO_CONTENT);
	}		
	//Acceder a une instance de arbre
	@GetMapping("/arbre/{name}")
	public HttpEntity<Arbre> getArbre(@PathVariable String name) {
		
		ArbreDAO arbD=new ArbreDAO();

			if(name!=null) {
			arbD = arbreRepositoryImpl.findArbreByName(name);
			
			Arbre arbre = toArbre(arbD);
			
			//Ajout des liens HATEOAS
			arbre.add(linkTo(methodOn(ArbreController.class).getArbre(name)).withRel("arbre"));
			arbre.add(linkTo(methodOn(ArbreController.class).getArbre(name)).withSelfRel());
			arbre.add(linkTo(methodOn(ArbreController.class).getArbres()).withRel("arbre"));		
			
			return new ResponseEntity<Arbre>(HttpStatus.OK);
			//return arbre;
			} 
			else 
			{
			return new ResponseEntity<Arbre>(HttpStatus.NOT_FOUND);
			}		
	}
	
	//Conversion de l'objet ArbreDAO en Arbre
	public Arbre toArbre(ArbreDAO arbD) 
	{
		Arbre arb=new Arbre();
		arb.setNom_p(arbD.getNom_arbre());;
		arb.setFamille(arbD.getFamille());
		arb.setPrix_unitaire(arbD.getPrix());
		arb.setNbre(arbD.getNbre());
		return arb;
		
	}
	
	//Conversion de l'objet Arbre en ArbreDAO
	public ArbreDAO toArbreDAO(Arbre arb) 
	{
		ArbreDAO arbD= new ArbreDAO();
		arbD.setNom_arbre(arb.getNom_p());
		arbD.setFamille(arb.getFamille());
		arbD.setPrix(arb.getPrix_unitaire());
		arbD.setNbre(arb.getNbre());
		return arbD;
		
	}

}
