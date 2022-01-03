package fr.diginamic.cge.jpa.model01.banque.entities;

import java.time.LocalDateTime;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;

import javax.persistence.ManyToOne;
@Entity
@Inheritance(strategy=InheritanceType.JOINED)

public abstract class  Operation {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column(name="date")
	private LocalDateTime date;
	@Column(name="montant",nullable = false)
	private double montant;
	@Column(name="motif",nullable = false)
	private String motif;
	
	
	
	@ManyToOne
	@JoinColumn(name="id_compte")
	private Compte compteOP;/*compte*/


	
	public Operation() {
		super();
	}


	public Operation(LocalDateTime date, double montant, String motif) {
		this.date = date;
		this.montant = montant;
		this.motif = motif;
	}
	
	
	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public LocalDateTime getDate() {
		return date;
	}



	public void setDate(LocalDateTime date) {
		this.date = date;
	}



	public double getMontant() {
		return montant;
	}



	public void setMontant(double montant) {
		this.montant = montant;
	}



	public String getMotif() {
		return motif;
	}



	public void setMotif(String motif) {
		this.motif = motif;
	}



	public Compte getCompteOP() {
		return compteOP;
	}



	public void setCompteOP(Compte compteOP) {
		this.compteOP = compteOP;
	}


	
	public String toString() {
		String msg = "Opération n°" + id;
		msg += " effectué le " + date.toString();
		msg += ". Montant : " + montant + "€";
		msg += " au motif : " + motif;
		return msg;
	}
	
	
}
