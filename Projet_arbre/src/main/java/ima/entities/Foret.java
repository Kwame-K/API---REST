package ima.entities;

import org.springframework.hateoas.RepresentationModel;

public class Foret extends RepresentationModel<Foret>{
	
	private String nom_f;
	private String region;
	private String pays;
	
	
	public Foret() {}
	
	public String getNom_f() {
		return nom_f;
	}
	public void setNom_f(String nom_f) {
		this.nom_f = nom_f;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public String getPays() {
		return pays;
	}
	public void setPays(String pays) {
		this.pays = pays;
	}
	
	

}
