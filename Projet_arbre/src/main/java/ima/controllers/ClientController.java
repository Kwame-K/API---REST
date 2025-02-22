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

import ima.dao.AdresseDAO;
import ima.dao.ClientDAO;
import ima.entities.Adresse;
import ima.entities.Client;
import ima.repository.ClientRepositoryInterface;

@RestController
public class ClientController {
	
	@Autowired
	private ClientRepositoryInterface clientRepositoryImpl;
	
	
	//Acces à la ressource client
	@GetMapping("/clients")
	public List<Client> getClients () {
		final Iterable<ClientDAO> clients = clientRepositoryImpl.findAll();
		final List<Client> ret = new ArrayList<Client>();
		// Lambda Expression
		// Pour chaque élément (forEach) nommé "e", je l'ajoute à la liste
		clients.forEach((e) -> ret.add(toClient(e)));
		return ret;
	}
	
	
	//Creation d'une ressource client
	@PostMapping("/createClient") // Post => creation d'une ressource
	public HttpEntity<Client> create(@RequestBody Client client) {
		

		ClientDAO cd = null;
			if (client != null) {
			// Conversion de l'objet Client en ClientDAO
			cd = toClientDAO(client);			
			// MAJ 
			clientRepositoryImpl.save(cd);
			return new ResponseEntity<Client>(toClient(cd), HttpStatus.CREATED);
			
		} else 
		{
			return new ResponseEntity<Client>(toClient(cd), HttpStatus.BAD_REQUEST);
		}
	}		
	
	//Suppression d'une ressource
	@DeleteMapping("/delete/{id}")
	public HttpEntity<Client> delete(@PathVariable(name="id", required=true) Long id) {
		
		Optional<ClientDAO> cli = clientRepositoryImpl.findById(id);

		if (cli != null){
			clientRepositoryImpl.deleteById(cli.get().getId_client());
		}
		
		return new ResponseEntity<Client>(HttpStatus.NO_CONTENT);
	}		
	
	
	//Acceder a une instance de arbre
	@GetMapping("/client/{id}")
	public HttpEntity<Client> getClient(@PathVariable Long id) {
		
		ClientDAO clid=new ClientDAO();
		
		if(id!=null) {
		Optional<ClientDAO> cli = clientRepositoryImpl.findById(id);
			
			Client client = toClient(cli.get());
			
			//Ajout des liens HATEOAS
			client.add(linkTo(methodOn(ClientController.class).getClient(id)).withRel("client"));
			client.add(linkTo(methodOn(ClientController.class).getClient(id)).withSelfRel());
			client.add(linkTo(methodOn(ClientController.class).getClients()).withRel("client"));		
			
			return new ResponseEntity<Client>( HttpStatus.OK);
		} else {
			return new ResponseEntity<Client>( HttpStatus.NOT_FOUND);
		}		
	}
	
	
	//Conversion ClientDAO en Client
	public Client toClient(ClientDAO cli) 
	{
		Client client=new Client();
		Adresse ad=new Adresse();
		client.setNom(cli.getNom());
		client.setPrenom(cli.getPrenom());
		
		ad.setCode_postal(cli.getAdresse().getCode_postal());
		ad.setPays(cli.getAdresse().getPays());
		ad.setVille(cli.getAdresse().getVille());
		
		client.setAdresse(ad);
		
		return client;
		
	}
	
	//Conversion Client en ClientDAO
	public ClientDAO toClientDAO(Client cli) 
	{
		ClientDAO client= new ClientDAO();
		client.setNom(cli.getNom());
		client.setPrenom(cli.getPrenom());
		AdresseDAO ad=new AdresseDAO();
		ad.setCode_postal(cli.getAdresse().getCode_postal());
		ad.setPays(cli.getAdresse().getPays());
		ad.setVille(cli.getAdresse().getVille());
		ad.setCode_postal(cli.getAdresse().getCode_postal());
		client.setAdresse(ad);
		
		
		return client;
		
	}

}
