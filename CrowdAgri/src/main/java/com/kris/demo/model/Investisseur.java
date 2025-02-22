package com.kris.demo.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Investisseur")
public class Investisseur {
@Id
@GeneratedValue(strategy =GenerationType.AUTO)
private Integer id;
private String nom;
private String prenom;
private String email;
@OneToOne
private User user_invest;
@ManyToMany(mappedBy="investisseur")
private Set<Campagne> campagne;




public Investisseur() {
	
}




public Investisseur(Integer id, String nom, String prenom, String email) {

	this.id = user_invest.getId();
	this.nom = nom;
	this.prenom = prenom;
	this.email = user_invest.getEmail();
}




@Override
public String toString() {
	return "Investisseur [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", email=" + email + ", user_invest="
			+ user_invest + ", campagne=" + campagne + "]";
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




public String getEmail() {
	return email;
}




public void setEmail(String email) {
	this.email = email;
}




public User getUser_invest() {
	return user_invest;
}




public void setUser_invest(User user_invest) {
	this.user_invest = user_invest;
}




public Set<Campagne> getCampagne() {
	return campagne;
}




public void setCampagne(Set<Campagne> campagne) {
	this.campagne = campagne;
}






	
	
	
	

}
