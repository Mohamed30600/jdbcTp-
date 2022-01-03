package fr.diginamic.cge.jpa.model01.banque.entities;


import java.util.Set;


import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
@Inheritance(strategy=InheritanceType.JOINED)

public abstract class Compte {
	
	@Id
	@GeneratedValue
	private int  id;
	@Column(name="numero",length=50,nullable=false)
	private String numero;
	@Column(name="solde",nullable=false)
	private Double solde;

	
	
	@ManyToMany
	@JoinTable(name="client_compte",
				joinColumns = @JoinColumn(name="id_compte",referencedColumnName = "id"),
				inverseJoinColumns = @JoinColumn(name="id_client",referencedColumnName = "id"))
	private Set<ClientB> clients;
	
	
	@OneToMany(mappedBy = "compteOP")/*compte*/
	private Set<Operation> OpCompte;/*operation*/

	public Compte() {
		
	}
	

	public Compte(String numero, Double solde) {
		
		this.numero = numero;
		this.solde = solde;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public Double getSolde() {
		return solde;
	}

	public void setSolde(Double solde) {
		this.solde = solde;
	}

	public Set<ClientB> getClients() {
		return clients;
	}

	public void setClients(Set<ClientB> clients) {
		this.clients = clients;
	}

	public Set<Operation> getOpCompte() {
		return OpCompte;
	}

	public void setOpCompte(Set<Operation> opCompte) {
		OpCompte = opCompte;
	}

	
	
}
