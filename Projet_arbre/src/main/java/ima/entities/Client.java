package ima.entities;

import org.springframework.hateoas.RepresentationModel;

public class Client extends RepresentationModel<Client> {
	private String nom;
	private String prenom;
	private Adresse adresse;
	
	public Client(){}

	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public Adresse getAdresse() {
		return adresse;
	}
	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}
	
	

}
