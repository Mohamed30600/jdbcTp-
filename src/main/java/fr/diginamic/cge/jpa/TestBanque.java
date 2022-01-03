package fr.diginamic.cge.jpa;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import fr.diginamic.cge.jpa.conexion.Connexion2;
import fr.diginamic.cge.jpa.model01.banque.entities.Adresse;
import fr.diginamic.cge.jpa.model01.banque.entities.AssuranceVie;
import fr.diginamic.cge.jpa.model01.banque.entities.Banque;
import fr.diginamic.cge.jpa.model01.banque.entities.ClientB;
import fr.diginamic.cge.jpa.model01.banque.entities.Compte;
import fr.diginamic.cge.jpa.model01.banque.entities.LivretA;
import fr.diginamic.cge.jpa.model01.banque.entities.Virement;

public class TestBanque {

	public static void main(String[] args) {

//				EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("banque");
//				EntityManager em = entityManagerFactory.createEntityManager();

		EntityManagerFactory efm = null;
		EntityManager em = null;

		efm = Connexion2.getConnection("banque");
		em = efm.createEntityManager();
		
		// creattion des client et leur adresse
		ClientB client1 = new ClientB();

		Adresse adresse1 = new Adresse();
		adresse1.setCodePostal(34000);
		adresse1.setNumero(6);
		adresse1.setRue("rue des ander");
		adresse1.setVille("montpellier");

		client1.setAdresse(adresse1);
		client1.setDateNaissance(LocalDate.of(1980, Month.APRIL, 25));
		client1.setNom("alfonse");
		client1.setPrenom("durois");

		ClientB client2 = new ClientB();

		Adresse adresse2 = new Adresse();
		adresse2.setCodePostal(30000);
		adresse2.setNumero(6);
		adresse2.setRue("rue des olivier");
		adresse2.setVille("nimes");

		client2.setAdresse(adresse2);
		client2.setDateNaissance(LocalDate.of(1974, Month.APRIL, 25));
		client2.setNom("mohamed");
		client2.setPrenom("hamadi");

		// creation de la banque
		Banque banque = new Banque();
		banque.setNom("oney banque");

		// association du client a leur banque
		client1.setCliBanque(banque);
		client2.setCliBanque(banque);
		// creation du livreA
		LivretA livretA = new LivretA();
		livretA.setNumero("1968");
		livretA.setSolde(90.0);
		livretA.setTaux(2.0);

		// creation de l assurance vie
		AssuranceVie assuranceVie = new AssuranceVie();
		assuranceVie.setNumero("1980");
		assuranceVie.setSolde(2500.0);
		assuranceVie.setTaux(4.5);
		assuranceVie.setDateFin(LocalDate.of(2030, Month.MARCH, 6));
//
//		Set<Client> clients = new HashSet<Client>();
//		clients.add(client);
//		livretA.setClients(clients);
//		assuranceVie.setClients(clients);

		// operation effectuer sur le compte et leur beneficiare
		Virement operation1 = new Virement();
		operation1.setCompteOP(livretA);
		operation1.setDate(LocalDateTime.now());
		operation1.setMontant(11.0);
		operation1.setMotif("Achat orinateur");
		operation1.setBeneficiare("carrefour");

		Virement operation2 = new Virement();
		operation2.setCompteOP(livretA);
		operation2.setDate(LocalDateTime.now());
		operation2.setMontant(11.5);
		operation2.setMotif("Nouriture");
		operation2.setBeneficiare("lidil");

		// afficher le livretA et assurance vie a compte
		Set<Compte> comptes = new HashSet<Compte>();
		comptes.add(livretA);
		comptes.add(assuranceVie);

		// ajout des client sur un compte
		client1.setComptes(comptes);
		client2.setComptes(comptes);

		EntityTransaction transaction1 = em.getTransaction();
		transaction1.begin();
		em.persist(client1);
		em.persist(client2);
		em.persist(operation1);
		em.persist(operation2);
		em.persist(livretA);
		em.persist(assuranceVie);
		em.persist(banque);

		transaction1.commit();
		/*
		 * EntityTransaction transaction2 = em.getTransaction(); transaction2.begin();
		 * em.persist(operation); transaction2.commit();
		 */
	}

}


