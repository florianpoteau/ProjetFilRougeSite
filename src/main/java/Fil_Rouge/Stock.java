package Fil_Rouge;

import java.util.Calendar;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class Stock implements InterfaceDao{

	private static EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory("sandwich");
		
	public void ajouterproduit (final int id, final int noproduit, final String nom, final String produit1, final String produit2, final String produit3, final String produit4, final String produit5, final float prix) {
		
		EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
		EntityTransaction et = null;
		
		try {
			et = em.getTransaction();
			et.begin();
			Sandwich sandwich = new Sandwich();
			sandwich.setId(id);
			sandwich.setNoproduit(noproduit);
			sandwich.setNom(nom);
			sandwich.setProduit1(produit1);
			sandwich.setProduit2(produit2);
			sandwich.setProduit3(produit3);
			sandwich.setProduit4(produit4);
			sandwich.setProduit5(produit5);
			sandwich.setPrix(prix);
			em.persist(sandwich);
			et.commit();
		}
		catch(Exception ex){
			if(et != null) {
				et.rollback();
			}
			ex.printStackTrace();
		}
			
			finally {
				em.close();
				ENTITY_MANAGER_FACTORY.close();
			}
		}
	
	public  void deletesandwich ( final int id) {
		
		EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
		EntityTransaction et = null;
		Sandwich sandwich = null;
		try {
			et = em.getTransaction();
			et.begin();
			sandwich = em.find(Sandwich.class, id);
			em.remove(sandwich);
			et.commit();
		}
		catch (Exception ex) {
			if(et != null) {
				et.rollback();
			}
			ex.printStackTrace();
		}
		finally {
			em.close();
			ENTITY_MANAGER_FACTORY.close();
		}
	}
	
	public  void getsandwich(final int id) {
		EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
		String query = "SELECT s FROM Sandwich s WHERE s.id = :id";

		TypedQuery<Sandwich> tq = em.createQuery(query, Sandwich.class);
		tq.setParameter("id", id);
		Sandwich util = null;
		try {
			util = tq.getSingleResult();
			System.out.println(util.getNom() + " " + util.getProduit1() + " " + util.getProduit2() + " " + util.getProduit3() + " " + util.getProduit4() + " " + util.getProduit5() + " " + util.getPrix());
		} catch (NoResultException ex) {
			ex.printStackTrace();
		} finally {
			em.close();
		}
	}
	
	public  void getsandwichs () {
		
		EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
		String strQuery = "SELECT s FROM Sandwich s WHERE s.id IS NOT NULL";
		
		TypedQuery<Sandwich> tq = em.createQuery(strQuery, Sandwich.class);
		List<Sandwich> utils;
		try {
			utils = tq.getResultList();
			utils.forEach(Sandwich->System.out.println( Sandwich.getNom() + " " + Sandwich.getProduit1() + " " + Sandwich.getProduit2() + " " + Sandwich.getProduit3() + " " + Sandwich.getProduit4() + " " + Sandwich.getProduit5() + " " + Sandwich.getPrix()));
		}
		
		catch ( NoResultException ex) {
			ex.printStackTrace();
		}
		
		finally {
			em.close();
			ENTITY_MANAGER_FACTORY.close();
		}
	}
	
public void dateAchat (final int id) {
	EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
	String query = "SELECT s FROM Sandwich s WHERE s.id = :id";
	TypedQuery<Sandwich> tq = em.createQuery(query, Sandwich.class);
	tq.setParameter("id", id);
	Sandwich util = null;
	try {
		util = tq.getSingleResult();
		
		System.out.println(util.getNom() + " " + util.getProduit1() + " " + util.getProduit2() + " " + util.getProduit3() + " " + util.getProduit4() + " " + util.getProduit5() + " " + util.getPrix());
		//utiliser le calendrier par d??faut
        Calendar calendar = Calendar.getInstance();
 
        //d??finir le format de la date
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
 
        //Afficher la date du joru
        System.out.println("Vous avez command?? le sandwich le: "+sdf.format(calendar.getTime()));
        
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
