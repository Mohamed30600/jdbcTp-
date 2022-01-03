package fr.diginamic.cge.jpa.model01.banque.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;


@Entity
public class Banque {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) 
	private int Id;
	@Column(name="nom",nullable = false)
	private String nom;
	
	@OneToMany (mappedBy = "cliBanque")/*banque*/
	private Set<ClientB> banquecli;/*clients*/
	
	

	public Banque() {
		banquecli = new HashSet<ClientB>();
	}
	



	public Banque(String nom) {
		super();
		this.nom = nom;
	}




	public int getId() {
		return Id;
	}



	public void setId(int id) {
		Id = id;
	}



	public String getNom() {
		return nom;
	}



	public void setNom(String nom) {
		this.nom = nom;
	}



	public Set<ClientB> getBanquecli() {
		return banquecli;
	}



	public void setBanquecli(Set<ClientB> banquecli) {
		this.banquecli = banquecli;
	}
	
	

}
