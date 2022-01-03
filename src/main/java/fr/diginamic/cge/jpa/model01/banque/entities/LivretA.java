package fr.diginamic.cge.jpa.model01.banque.entities;



import javax.persistence.Column;

import javax.persistence.Entity;
@Entity

public class LivretA extends Compte{
	
	@Column(name="taux",nullable=false)
	private double taux;



	public LivretA() {
		
	}
	
	

	public LivretA(double taux) {
		super();
		this.taux = taux;
	}



	public LivretA(String string, int i, double d) {
		// TODO Auto-generated constructor stub
	}



	public double getTaux() {
		return taux;
	}

	public void setTaux(double taux) {
		this.taux = taux;
	}

}
