package fr.diginamic.cge.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import javax.persistence.Query;

import fr.diginamic.cge.jpa.conexion.Connexion2;
import fr.diginamic.cge.jpa.model.Client;
import fr.diginamic.cge.jpa.model.Emprunt;
import fr.diginamic.cge.jpa.model.Livre;



public class TestBibliotheque {

	public static void main(String[] args) {
		
		
		
//		LivresService livreService = new LIvreServiceImpl();
//		
//		EmpruntService empruntService = new  EmpruntServiceIImpl();
//				
				
				
				
//		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("pu_essai");
//		EntityManager em = entityManagerFactory.createEntityManager();
		
		EntityManagerFactory efm =null;
		EntityManager em =  null;
		
		efm=Connexion2.getConnection();
		em = efm.createEntityManager();
		/**
		 * creation dun livre auteur titre
		 */
		System.out.println("*****************************************");
		System.out.println("**Tp2/creation dun livre**");
		System.out.println("*****************************************");
		  
        em.getTransaction().begin();
        Livre b1 = new Livre();
        b1.setTitre("vlivre delice");
        b1.setAuteur("mohamede");
        em.persist(b1);
        em.getTransaction().commit();
		
		/**
		 * trouver un livre et afficher son auteur et son titre
		 * 
		 */
		System.out.println("*****************************************");
		System.out.println("**Tp2/AFFICHAGE LIVRE PAR AUTEUR ET TITRE**");
		System.out.println("*****************************************");
		Livre livre = em.find(Livre.class, 2);
		if (livre != null){
			System.out.println(livre.getTitre());
			System.out.println(livre.getAuteur());
		}
		
		/**
		 * a traver un requete sql afficher id titre auteur le livre qui a pour auteur Vingt mille lieues sous les mers
		 */
		System.out.println("***********************************************************");
		System.out.println("**Tp2/CHERCHER LE LIVTRE AUTEUR VING MILLE LIEUS SOUS LES MER**");
		System.out.println("***********************************************************");
		Query query1 = em.createQuery("SELECT l FROM Livre l WHERE l.titre = 'Vingt mille lieues sous les mers'");
		livre = (Livre) query1.getSingleResult();
		if (livre != null){
			System.out.println(livre.getId());
			System.out.println(livre.getTitre());
			System.out.println(livre.getAuteur());
		}
		
		//recherche par l id
		System.out.println("*****************************************");
		System.out.println("*******RECUPERE UN LIVRE PAR SON ID******");
		System.out.println("*****************************************");
		Query query2 = em.createQuery("SELECT e FROM Emprunt e WHERE e.id = 4");
		Emprunt emprunt = (Emprunt) query2.getSingleResult();
		if (emprunt != null){
			for(Livre l:emprunt.getEmpruntLivres()){
				System.out.println(l.getId());
				System.out.println(l.getTitre());
				System.out.println(l.getAuteur());
			}
		}
		
		/**
		 * supression d' livre par son id
		 */
//        try {
//        	   em.getTransaction().begin();
//             Livre  emsup= em.find(Livre.class, 6);
//             if(emsup !=null) {
//          	   em.remove(emsup);
//          	   em.getTransaction().commit();
//       	        em.close();
//             }
//       		
//		} catch (Exception e) {
//			e.printStackTrace();
		/**
		 * modification titre d un livre par son id
		 */
		
//        em.getTransaction().begin();
//        Livre b3 = em.find(Livre.class,5);
//        b3.setTitre("les plaisir de la nature");
//        em.persist(b3);
//        em.getTransaction().commit();
		
		/**
		 * affichage de tous les emprunt d un client donne id=1
		 */
		System.out.println("*********************************************************************");
		System.out.println("*******Tp3/REQUETE PERMET EXTRAIRE TOUS LES EMPRUN D UN CLIENT id=1**");
		System.out.println("*********************************************************************");
		Query query3 = em.createQuery("SELECT c FROM Client c WHERE c.id = 1");
		Client client = (Client) query3.getSingleResult();
		System.out.println("Monsieur/madame " + client.getNom() + " a fait les emprunts suivants :");
		if (client != null){
			for(Emprunt e:client.getEmprunts()){
				System.out.println(e.getDate_debut());
				System.out.println(e.getDate_fin());
				System.out.println(e.getDelai());
				for(Livre l:e.getEmpruntLivres()){
					System.out.println(l.getTitre());
					System.out.println(l.getAuteur());
				}
			}
		}
		
		/**
		 * affichage d un emprunt associer a ses livre
		 */
		
		System.out.println("*********************************************************************");
		System.out.println("*******Tp3/REQUETE PERMET EXTRAIRE un emprunt a tous ses livre id=1**");
		System.out.println("*********************************************************************");
		try {
			em = efm.createEntityManager();
			Emprunt empr = em.find(Emprunt.class, 1);
			if (empr != null) {
				empr.getEmpruntLivres().stream().forEach(l -> System.out.println(l));
			} else
				System.err.println("Emprunt non trouvé !");

		} finally {
			if (em != null) {
				em.close();
			}
		}
		

	}
	 
		
	}


