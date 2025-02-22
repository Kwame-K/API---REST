package com.kris.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="User")
public class User {
	@Id
	@GeneratedValue(strategy =GenerationType.AUTO)
	private Integer id;
	private String email;
	private String password;
	@OneToOne(mappedBy="user_agri")

	private Agriculteur agri;
	@OneToOne(mappedBy="user_invest")

	private Investisseur invest;
	
	
	
	public User() {
	}
	
	
	public User(String email, String password) {
		
		this.email = email;
		this.password = password;
	}
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}


	@Override
	public String toString() {
		return "User [id=" + id + ", email=" + email + ", password=" + password + ", agri=" + agri + ", invest="
				+ invest + "]";
	}


	
	

}
