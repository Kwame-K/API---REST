package ima.dao;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity(name="arbre")
public class ArbreDAO {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id_arbre;
	private String nom_arbre;
	private String famille;
	private int nbre;
	private double prix;

	@OneToMany(mappedBy="arbre",cascade = {CascadeType.ALL})
	private Set<SelectionDAO> selec;

	

	public Long getId_arbre() {
		return id_arbre;
	}

	public void setId_arbre(Long id_arbre) {
		this.id_arbre = id_arbre;
	}

	public String getNom_arbre() {
		return nom_arbre;
	}

	public void setNom_arbre(String nom_arbre) {
		this.nom_arbre = nom_arbre;
	}

	public String getFamille() {
		return famille;
	}

	public void setFamille(String famille) {
		this.famille = famille;
	}

	public double getPrix() {
		return prix;
	}

	public int getNbre() {
		return nbre;
	}

	public void setNbre(int nbre) {
		this.nbre = nbre;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public Set<SelectionDAO> getSelec() {
		return selec;
	}

	public void setSelec(Set<SelectionDAO> selec) {
		this.selec = selec;
	}
	
	

}
