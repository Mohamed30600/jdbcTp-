package fr.diginamic.cge.jpa.service;

import javax.persistence.EntityManagerFactory;

public interface EmpruntService {
	
	public void EmpruntListeLivres(EntityManagerFactory efm);
	
	public void  clientEmprunts(EntityManagerFactory efm);

}
