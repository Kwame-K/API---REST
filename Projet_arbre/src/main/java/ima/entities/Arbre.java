package ima.entities;

import org.springframework.hateoas.RepresentationModel;

public class Arbre extends RepresentationModel<Arbre>{
	
	private String nom_p;
	private String famille;
	private int nbre;
	private double prix_unitaire;
	
	
	public Arbre(){}
	
	public String getNom_p() {
		return nom_p;
	}
	public void setNom_p(String nom_p) {
		this.nom_p = nom_p;
	}
	public String getFamille() {
		return famille;
	}
	public void setFamille(String famille) {
		this.famille = famille;
	}
	public double getPrix_unitaire() {
		return prix_unitaire;
	}
	public void setPrix_unitaire(double prix_unitaire) {
		this.prix_unitaire = prix_unitaire;
	}

	public int getNbre() {
		return nbre;
	}

	public void setNbre(int nbre) {
		this.nbre = nbre;
	}

	
	
}
