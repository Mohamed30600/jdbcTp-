package fr.diginamic.cge.jpa.model;

import java.util.HashSet;

import java.util.Set;

import javax.persistence.*;


@Entity
/**
 * 
 * @author Mohamed
 * Table associer avec Livre
 *
 */
@Table (name="LIVRE")
public class Livre {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	private int id ;
	@Column(name="TITRE",length = 255,unique=true)
	private String titre;
	@Column(name="AUTEUR",length = 255,unique=true)
	private String auteur;
	/**
	 * Association n a n
	 */
	@ManyToMany(mappedBy="empruntLivres")
	private Set<Emprunt> livreEmpruntes;
	
	public Livre(int id, String titre, String auteur) {

		this.id = id;
		this.titre = titre;
		this.auteur = auteur;
	}

	public Livre() {
		
		livreEmpruntes=new HashSet<>();
	
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getAuteur() {
		return auteur;
	}

	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}

	public Set<Emprunt> getLivreEmpruntes() {
		return livreEmpruntes;
	}

	public void setLivreEmpruntes(Set<Emprunt> livreEmpruntes) {
		this.livreEmpruntes = livreEmpruntes;
	}

	@Override
	public String toString() {
		return "Livre [titre=" + titre + ", auteur=" + auteur +  "]";
	}

	
	
	
	
	
}
