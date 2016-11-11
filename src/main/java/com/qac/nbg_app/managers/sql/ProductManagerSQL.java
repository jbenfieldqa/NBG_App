package com.qac.nbg_app.managers.sql;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.enterprise.inject.Alternative;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import javax.validation.ValidationException;

import com.qac.nbg_app.entities.Product;
import com.qac.nbg_app.entities.ProductGroup;
import com.qac.nbg_app.managers.PersistanceManager;
import com.qac.nbg_app.managers.ProductManager;

@Stateless
@Alternative
public class ProductManagerSQL implements ProductManager {
	@Inject
	private PersistanceManager pm;

	@Override
	public List<Product> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void persistProduct(Product p) {
		EntityManager em = pm.CreateEntityManager();
		em.getTransaction().begin();
		em.persist(p);
		em.getTransaction().commit();
		pm.CloseEntityManager(em);
	}

	@Override
	public void persistProducts(ArrayList<Product> ps) {
		EntityManager em = pm.CreateEntityManager();
		em.getTransaction().begin();
		for	(Product p : ps){
			em.persist(p);
		}
		em.getTransaction().commit();
		pm.CloseEntityManager(em);
	}

	@Override
	public Product findByName(String name) {
		EntityManager em = pm.CreateEntityManager();
		TypedQuery<Product> tq = em.createNamedQuery(Product.FIND_BY_NAME, Product.class);
		pm.CloseEntityManager(em);
		tq.setParameter("name", name);
		try{
			return tq.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	@Override
	public ArrayList<Product> getEntities() {
		EntityManager em = pm.CreateEntityManager();
		ArrayList<Product> product = (ArrayList<Product>) em.createQuery("select a from products a", Product.class).getResultList();
		pm.CloseEntityManager(em);
		return product;
	}

	@Override
	public void updateProduct(Product p) {
		if (p == null) {
			throw new ValidationException("null");
		}
		EntityManager em = pm.CreateEntityManager();
		em.merge(p);
		pm.CloseEntityManager(em);
	}

	@Override
	public void removeProduct(Product p) {
		if (p == null) {
			throw new ValidationException("null");
		}
		EntityManager em = pm.CreateEntityManager();
		em.remove(p);
		pm.CloseEntityManager(em);

	}

}
