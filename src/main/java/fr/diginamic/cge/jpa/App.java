package fr.diginamic.cge.jpa;

import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import fr.diginamic.cge.jpa.model.Livre;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	
        System.out.println( "Hello World!" );
        EntityManagerFactory efm =null;
        
        try 
    	{
    
	        efm = Persistence.createEntityManagerFactory("biblio");
	        EntityManager em = efm.createEntityManager();
	        
	        /*creation*/
//	        em.getTransaction().begin();
//	        EFournisseur efo = new EFournisseur();
//	        efo.setNom("AUCHAN");
//	        em.persist(efo);
//	        em.getTransaction().commit();
//	        System.out.println(efo.getId());
//	        
//	        
//	        /*modif*/
//	        
//	        int id= efo.getId() ;
//	        em.getTransaction().begin();
//	        EFournisseur efond = em.find(EFournisseur.class,id);
//	        efond.setNom("carrefour");
//	        em.merge(efond);
//	        em.getTransaction().commit();
//	       
//	        /*delette*/
//	        em.getTransaction().begin();
//	        EFournisseur emsupression= em.find(EFournisseur.class,9);
//	        em.remove(emsupression);
//	        
//	        em.getTransaction().commit();
//	        
//	        em.close();
//	        /*creation livre*/
//	        em.getTransaction().begin();
//	        Livre b1 = new Livre();
//	        b1.setTitre("vlivre delice");
//	        b1.setAuteur("mohamede");
//	        em.persist(b1);
//	        em.getTransaction().commit();
	        
	        /*extraction find*/
//	              
//	        em.getTransaction().begin();
//	        Livre bfin = em.find(Livre.class,4);
//	        System.out.println(bfin);
//	        em.getTransaction().commit();
//	        
	        /*modification*/
	       
//	        em.getTransaction().begin();
//	        Livre b3 = em.find(Livre.class,5);
//	        b3.setTitre("les plaisir de la nature");
//	        em.persist(b3);
//	        em.getTransaction().commit();
//	        
//	       TypedQuery <Livre> query1 = em.createQuery("SELECT l FROM Livre l WHERE l.titre='Germinal'",Livre.class);  
//	        Livre l1 = query1.getSingleResult();
//           System.out.println(l1);
	        
	        
//	        TypedQuery <Livre> query1 = em.createQuery("SELECT a FROM Livre a WHERE a.auteur='Emile Zola'",Livre.class);  
//	        Livre l1 = query1.getSingleResult();
//           System.out.println(l1);
	        
	        
           /*delette*/
	        
//           em.getTransaction().begin();
//           Livre  emsup= em.find(Livre.class, 9);
//           if(emsup !=null) {
//        	   em.remove(emsup);
//        	   em.getTransaction().commit();
//   	        em.close();
//         }
//	        /*liste de tous les livre*/
	        
//	        
//	        TypedQuery <Livre> query2 = em.createQuery("SELECT a FROM Livre a ",Livre.class);
//	      
//	        List<Livre> li=query2.getResultList();
//	        
//	        li.stream().forEach(l-> System.out.println(l));
//	        
//	        
//        
//	        
//	        
//    	}
//    	catch(Exception e) {e.printStackTrace();}
//    	finally {
//    		if(efm != null) efm.close();
//    	}
        
        
    	}finally{
    		if(efm != null) efm.close();
    	}
    }
}

    
    
    
    
    

