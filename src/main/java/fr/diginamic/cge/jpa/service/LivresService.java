package fr.diginamic.cge.jpa.service;

import javax.persistence.EntityManagerFactory;

import fr.diginamic.cge.jpa.model.Livre;

public interface LivresService {
	/**
	 * Trouver un livre par son id
	 */
	public void findLivreByIdint (EntityManagerFactory efm,int id);
	

	/**
	 * Trouver un livre par son titre
	 */
	public void findLivreByTitle(EntityManagerFactory efm,Livre livre);

	/**
	 * ajouter un livre
	 */
	public void addLivre(EntityManagerFactory efm);

	/**
	 * Mise ajour des donne d un livre
	 */

	public void updateLivre(EntityManagerFactory efm);

	/**
	 * Supprimer un livre
	 */

	public void delLivre(EntityManagerFactory efm);
	
	public void listDesLivre(EntityManagerFactory efm);

}
