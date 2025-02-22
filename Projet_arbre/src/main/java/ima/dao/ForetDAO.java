package ima.dao;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity(name="foret")
public class ForetDAO {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id_foret;
	private String nom_f;
	private String region;
	private String pays;
	
	@OneToMany(mappedBy="foret",cascade = {CascadeType.ALL})
	private Set <SelectionDAO> selec;

	public Long getId_foret() {
		return id_foret;
	}

	public void setId_foret(Long id_foret) {
		this.id_foret = id_foret;
	}

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

	public Set<SelectionDAO> getSelec() {
		return selec;
	}

	public void setSelec(Set<SelectionDAO> selec) {
		this.selec = selec;
	}

	
	
	
}
