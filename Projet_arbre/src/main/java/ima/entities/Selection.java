package ima.entities;

import org.springframework.hateoas.RepresentationModel;

public class Selection extends RepresentationModel<Selection>{
	
	private int nbre_selec;
	private Client client;
	private Foret foret;
	private Arbre arbre;
	
	
	public Selection() {}
	
	public int getNbre_selec() {
		return nbre_selec;
	}
	public void setNbre_selec(int nbre_selec) {
		this.nbre_selec = nbre_selec;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public Foret getForet() {
		return foret;
	}
	public void setForet(Foret foret) {
		this.foret = foret;
	}

	public Arbre getArbre() {
		return arbre;
	}

	public void setArbre(Arbre arbre) {
		this.arbre = arbre;
	}
	
	
	
	

}
