package com.kris.demo.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="investir")
public class Investir {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	@Temporal(TemporalType.TIMESTAMP)
	private Date date_inv;
	@OneToOne
	private Investisseur inv;
	@OneToOne
	private Campagne camp;
	
	
	public Investir() {
	
	}


	public Investir(Date date_inv, Investisseur inv, Campagne camp) {
		this.date_inv = date_inv;
		this.inv = inv;
		this.camp = camp;
	}


	
	@Override
	public String toString() {
		return "Investir [id=" + id + ", date_inv=" + date_inv + ", inv=" + inv + ", camp=" + camp + "]";
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public Date getDate_inv() {
		return date_inv;
	}


	public void setDate_inv(Date date_inv) {
		this.date_inv = date_inv;
	}


	public Investisseur getInv() {
		return inv;
	}


	public void setInv(Investisseur inv) {
		this.inv = inv;
	}


	public Campagne getCamp() {
		return camp;
	}


	public void setCamp(Campagne camp) {
		this.camp = camp;
	}
	
	

}
