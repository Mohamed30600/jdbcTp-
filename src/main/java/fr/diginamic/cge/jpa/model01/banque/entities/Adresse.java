package fr.diginamic.cge.jpa.model01.banque.entities;

import javax.persistence.Embeddable;

@Embeddable
public class Adresse {
	
	private int numero;
	private String rue;
	private int codePostal;
	private String Ville;
	
	
	public Adresse() {
		super();
	}
	public Adresse(int i, String string, int j, String string2) {
		// TODO Auto-generated constructor stub
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public String getRue() {
		return rue;
	}
	public void setRue(String rue) {
		this.rue = rue;
	}
	public int getCodePostal() {
		return codePostal;
	}
	public void setCodePostal(int codePostal) {
		this.codePostal = codePostal;
	}
	public String getVille() {
		return Ville;
	}
	public void setVille(String ville) {
		Ville = ville;
	}

	
	
}
