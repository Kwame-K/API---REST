package com.kris.demo.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Agriculteur")
public class Agriculteur {
	@Id
	@GeneratedValue(strategy =GenerationType.AUTO)
	private Integer id;
	private String nom;
	private String prenom;
	private String adresse;
	private String email;
	private Integer tel;
	@OneToOne
	private User user_agri;
	@OneToMany(mappedBy="agri")
	private List<Campagne> campagne;
	
	
	
	public Agriculteur() {
		
	}



	public Integer getTel() {
		return tel;
	}



	public void setTel(Integer tel) {
		this.tel = tel;
	}






	public User getUser_agri() {
		return user_agri;
	}



	public void setUser_agri(User user_agri) {
		this.user_agri = user_agri;
	}



	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
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



	public String getAdresse() {
		return adresse;
	}



	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}






	public Agriculteur(String nom, String prenom, String adresse, String email, Integer tel, User user_agri) {
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.email = user_agri.getEmail();;
		this.tel = tel;
		this.user_agri = user_agri;
	}



	@Override
	public String toString() {
		return "Agriculteur [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", adresse=" + adresse + ", email="
				+ email + ", tel=" + tel + ", user_agri=" + user_agri + ", campagne=" + campagne + "]";
	}



	






}
