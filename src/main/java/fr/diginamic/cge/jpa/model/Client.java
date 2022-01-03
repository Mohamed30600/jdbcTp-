package fr.diginamic.cge.jpa.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table (name="client")
public class Client {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column(name="NOM",length = 50, unique = true)
	private String nom;
	@Column (name="PRENOM", length = 50)
	private String prenom;
	
	@OneToMany(mappedBy = "clientEmprunt")
	private Set<Emprunt> emprunts;
	
	
	public Client(int id, String nom, String prenom) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
	}


	public Client() {
		/*pour notifier si un client na pas enmprunt*/
		emprunts=new HashSet<Emprunt>();
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
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


	public Set<Emprunt> getEmprunts() {
		return emprunts;
	}


	public void setEmprunts(Set<Emprunt> emprunts) {
		this.emprunts = emprunts;
	}


	@Override
	public String toString() {
		return "Client [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", emprunts=" + emprunts + "]";
	}
	
	
	
}
