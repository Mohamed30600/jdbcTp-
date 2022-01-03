package fr.diginamic.cge.jpa.model01.banque.entities;

import java.time.LocalDateTime;

import javax.persistence.Column;

import javax.persistence.Entity;

@Entity
//@DiscriminatorValue("VIR")

public class Virement extends Operation{
	@Column(name="BENEFICIAIRE",nullable = false)
	private String Beneficiare;

	public Virement() {
		
		
	}

	public Virement(LocalDateTime date, double montant, String modif, Compte compte) {
		
	}

	public String getBeneficiare() {
		return Beneficiare;
	}

	public void setBeneficiare(String beneficiare) {
		Beneficiare = beneficiare;
	}
	
	

}
