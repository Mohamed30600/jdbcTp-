package fr.diginamic.cge.jpa.model;




import java.util.Date;
import java.util.HashSet;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;



@Entity
@Table(name="EMPRUNT")
public class Emprunt {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Temporal(TemporalType.DATE)
	@Column(name="DATE_DEBUT")
	private Date  date_debut;
	@Column(name="DELAI")
	private int delai;
	@Column(name="DATE_FIN")
	@Temporal(TemporalType.DATE)
	private Date date_fin;

	@ManyToOne
	@JoinColumn(name="id_client")
	private Client clientEmprunt; 
	
	@ManyToMany
	@JoinTable (name="compo",
		joinColumns=@JoinColumn(name="ID_EMP",referencedColumnName = "ID"),
		inverseJoinColumns = @JoinColumn(name="ID_LIV",referencedColumnName="ID"))
	
	private Set<Livre> empruntLivres;
	
	
	public Emprunt() {
		
		empruntLivres= new HashSet<>();
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public Date getDate_debut() {
		return date_debut;
	}


	public void setDate_debut(Date date_debut) {
		this.date_debut = date_debut;
	}


	public int getDelai() {
		return delai;
	}


	public void setDelai(int delai) {
		this.delai = delai;
	}


	public Date getDate_fin() {
		return date_fin;
	}


	public void setDate_fin(Date date_fin) {
		this.date_fin = date_fin;
	}


	public Client getClientEmprunt() {
		return clientEmprunt;
	}


	public void setClientEmprunt(Client clientEmprunt) {
		this.clientEmprunt = clientEmprunt;
	}


	public Set<Livre> getEmpruntLivres() {
		return empruntLivres;
	}


	public void setEmpruntLivres(Set<Livre> empruntLivres) {
		this.empruntLivres = empruntLivres;
	}



	
	

}
