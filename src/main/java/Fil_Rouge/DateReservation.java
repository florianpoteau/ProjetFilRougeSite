package Fil_Rouge;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class DateReservation {
	
	private static EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory("sandwich");
	
	public static void dateAchat (final int id) {
		EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
		String query = "SELECT s FROM Sandwich s WHERE s.id = :id";
		TypedQuery<Sandwich> tq = em.createQuery(query, Sandwich.class);
		tq.setParameter("id", id);
		Sandwich util = null;
		try {
			util = tq.getSingleResult();
			
			System.out.println(util.getNom() + " " + util.getProduit1() + " " + util.getProduit2() + " " + util.getProduit3() + " " + util.getProduit4() + " " + util.getProduit5() + " " + util.getPrix());
			//utiliser le calendrier par défaut
	        Calendar calendar = Calendar.getInstance();
	 
	        //définir le format de la date
	        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	 
	        //Afficher la date du joru
	        System.out.println("Vous avez commandé le sandwich le: "+sdf.format(calendar.getTime()));
	        
	        SimpleDateFormat sdf1 = new SimpleDateFormat("HH");
	        calendar.add(Calendar.HOUR, 2);
	        System.out.println("Vous recevrez la commande vers " + sdf1.format(calendar.getTime()) + " Heures");
			
		} catch (NoResultException ex) {
			ex.printStackTrace();
		} finally {
			em.close();
		}
	}

}
