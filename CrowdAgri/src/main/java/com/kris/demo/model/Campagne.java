package com.kris.demo.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="Campagne")
public class Campagne {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	private String intitule;
	@Temporal(TemporalType.TIMESTAMP)
	private Date date_publication;
	private long somme_requise;
	private long somme_util_cinq_Ans;
	private String temps_production;
	private String photo_camp;
	@ManyToOne
	private Agriculteur agri;
	@ManyToMany
	private Set<Investisseur> investisseur;
	
	
public Campagne() {
		
	}
	public Campagne(String intitule, Date date_publication, long somme_requise,long somme_util_cinq_Ans ,String temps_production,
			String photo_camp, Agriculteur agri) {
		this.intitule = intitule;
		this.date_publication = date_publication;
		this.somme_requise = somme_requise;
		this.somme_util_cinq_Ans=somme_util_cinq_Ans;
		this.temps_production = temps_production;
		this.photo_camp = photo_camp;
		this.agri = agri;
		
	}

	
	
	

	
	public long getSomme_util_cinq_Ans() {
		return somme_util_cinq_Ans;
	}
	public void setSomme_util_cinq_Ans(long somme_util_cinq_Ans) {
		this.somme_util_cinq_Ans = somme_util_cinq_Ans;
	}
	@Override
	public String toString() {
		return "Campagne [id=" + id + ", intitule=" + intitule + ", date_publication=" + date_publication
				+ ", somme_requise=" + somme_requise + ", temps_production=" + temps_production + ", photo_camp="
				+ photo_camp + ", agri=" + agri + "]";
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getIntitule() {
		return intitule;
	}
	public void setIntitule(String intitule) {
		this.intitule = intitule;
	}
	public Date getDate_publication() {
		return date_publication;
	}
	public void setDate_publication(Date date_publication) {
		this.date_publication = date_publication;
	}
	public long getSomme_requise() {
		return somme_requise;
	}
	public void setSomme_requise(long somme_requise) {
		this.somme_requise = somme_requise;
	}
	public String getTemps_production() {
		return temps_production;
	}
	public void setTemps_production(String temps_production) {
		this.temps_production = temps_production;
	}
	public String getPhoto_camp() {
		return photo_camp;
	}
	public void setPhoto_camp(String photo_camp) {
		this.photo_camp = photo_camp;
	}
	public Agriculteur getAgri() {
		return agri;
	}
	public void setAgri(Agriculteur agri) {
		this.agri = agri;
	}
	public Set<Investisseur> getInvestisseur() {
		return investisseur;
	}
	public void setInvestisseur(Set<Investisseur> investisseur) {
		this.investisseur = investisseur;
	}
	
	
	
	
	
}

