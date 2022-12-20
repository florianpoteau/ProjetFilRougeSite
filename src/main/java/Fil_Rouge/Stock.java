package Fil_Rouge;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class Stock {

	private static EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory("sandwich");
		
	public static void ajouterproduit (int id, int noproduit, String nom, String produit1, String produit2, String produit3, String produit4, String produit5, float prix) {
		
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
	
	public static void deletesandwich ( int id) {
		
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
	
	public static void getsandwich(int id) {
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
	
	public static void getsandwichs () {
		
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
	
	}
