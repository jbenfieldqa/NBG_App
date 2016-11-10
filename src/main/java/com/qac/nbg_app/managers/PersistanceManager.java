package com.qac.nbg_app.managers;

import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;

@Singleton
public class PersistanceManager {
	private EntityManagerFactory emf;
	
	public EntityManager CreateEntityManager(){
		try {
			emf = Persistence.createEntityManagerFactory("DatabasePU");
			EntityManager em = emf.createEntityManager();
			return em;
		} catch (PersistenceException pe){
			return null;
		} 
	}
	
	public void CloseEntityManager(EntityManager em){
		em.close();
		emf.close();
	} 
}
