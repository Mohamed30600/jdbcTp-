package fr.diginamic.cge.jpa.model01.banque.entities;

import java.time.LocalDate;


import javax.persistence.Column;

import javax.persistence.Entity;
@Entity


public class AssuranceVie  extends Compte{
	
	@Column(name="dateFin",nullable=false)
	private LocalDate dateFin;
	@Column (name="taux",nullable=false)
	private double taux;
	
	
	
	
	
	public AssuranceVie() {
		
	}


	 LocalDate getDateFin() {
		return dateFin;
	}
	public void setDateFin(LocalDate dateFin) {
		this.dateFin = dateFin;
	}
	public double getTaux() {
		return taux;
	}
	public void setTaux(double taux) {
		this.taux = taux;
	}
	
	
	

}
