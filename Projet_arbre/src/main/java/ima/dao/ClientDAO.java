package ima.dao;


import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;


@Entity(name="client")
public class ClientDAO {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id_client;
	private String nom;
	private String prenom;
	
	@OneToOne(cascade = {CascadeType.ALL})
	private AdresseDAO adresse;
	
	@OneToMany(mappedBy="client",cascade = {CascadeType.ALL})
	private Set<SelectionDAO> selec;
	
	
	
	public AdresseDAO getAdresse() {
		return adresse;
	}
	public void setAdresse(AdresseDAO adresse) {
		this.adresse = adresse;
	}
	
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
	public Long getId_client() {
		return id_client;
	}
	public void setId_client(Long id_client) {
		this.id_client = id_client;
	}
	public Set<SelectionDAO> getSelec() {
		return selec;
	}
	public void setSelec(Set<SelectionDAO> selec) {
		this.selec = selec;
	}
	
	
	

}
