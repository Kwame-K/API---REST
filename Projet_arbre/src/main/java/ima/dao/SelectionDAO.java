package ima.dao;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity(name="selection")
public class SelectionDAO {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private int nbre_selec;

	@ManyToOne(cascade = {CascadeType.ALL})
	private ClientDAO client;
	
	@ManyToOne(cascade = {CascadeType.ALL})
	private ForetDAO foret;
	
	@ManyToOne(cascade = {CascadeType.ALL})
	private ArbreDAO arbre;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getNbre_selec() {
		return nbre_selec;
	}

	public void setNbre_selec(int nbre_selec) {
		this.nbre_selec = nbre_selec;
	}

	public ClientDAO getClient() {
		return client;
	}

	public void setClient(ClientDAO client) {
		this.client = client;
	}

	public ForetDAO getForet() {
		return foret;
	}

	public void setForet(ForetDAO foret) {
		this.foret = foret;
	}

	public ArbreDAO getArbre() {
		return arbre;
	}

	public void setArbre(ArbreDAO arbre) {
		this.arbre = arbre;
	}
	
	
}
