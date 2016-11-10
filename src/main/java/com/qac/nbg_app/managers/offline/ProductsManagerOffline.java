package com.qac.nbg_app.managers.offline;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.enterprise.inject.Default;
import javax.inject.Inject;

import com.qac.nbg_app.entities.Product;
import com.qac.nbg_app.entities.ProductGroup;
import com.qac.nbg_app.managers.ProductManager;
import com.qac.nbg_app.util.InitialData;

@Stateless
@Default
public class ProductsManagerOffline implements ProductManager{

	@Inject
	private InitialData initialData;
	
	@Override
	public List<Product> findAll() {
		return initialData.getProducts();
	}

	@Override
	public void persistProduct(Product p) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void persistProducts(ArrayList<Product> ps) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Product findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Product> getEntities() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateProduct(Product p) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeProduct(Product p) {
		// TODO Auto-generated method stub
		
	}
}