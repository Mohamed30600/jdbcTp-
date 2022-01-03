package fr.diginamic.cge.jpa.conexion;


import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Connexion2 {

	public static EntityManagerFactory getConnection() {
		return Connexion2.getConnection("biblio");

	}

	public static EntityManagerFactory getConnection(String UnitePersistance) {

		return Persistence.createEntityManagerFactory(UnitePersistance);

	}
}

