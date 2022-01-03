package fr.diginamic.cge.jpa.model01.banque.entities;

import java.time.LocalDate;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
@Entity
public class ClientB {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	
	private long id;
	@Column(name="nom",length = 50,nullable = false)
	private String nom;
	@Column(name="prenom",length = 50,nullable = false)
	private String prenom;
	@Column(name="dateNaissance")
	private LocalDate dateNaissance;
	
	@ManyToMany
	@JoinTable(name="CLIENT_COMPTE",/*clients*/
				joinColumns = @JoinColumn(name="id_client",referencedColumnName = "id"),
				inverseJoinColumns = @JoinColumn(name="id_compte",referencedColumnName = "id"))
		
	private Set<Compte> comptes;
	
	@ManyToOne
	@JoinColumn(name="id_banque")
	private Banque cliBanque; /*banque*/
	
	@Embedded
	private Adresse adresse;
	


	public ClientB() {
		
	}
	

	public ClientB(String nom, String prenom, LocalDate dateNaissance, Adresse adresse) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = dateNaissance;
		this.adresse = adresse;
	}


	public long getId() {
		return id;
	}

	public void setId(long id) {
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

	public LocalDate getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(LocalDate dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public Set<Compte> getComptes() {
		return comptes;
	}

	public void setComptes(Set<Compte> comptes) {
		this.comptes = comptes;
	}

	public Banque getCliBanque() {
		return cliBanque;
	}

	public void setCliBanque(Banque cliBanque) {
		this.cliBanque = cliBanque;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	
	

}
