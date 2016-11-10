package com.qac.nbg_app.managers;

import java.util.ArrayList;
import java.util.List;

import com.qac.nbg_app.entities.Product;
import com.qac.nbg_app.entities.ProductGroup;

public interface ProductManager {
	public List<Product> findAll();

	void persistProduct(Product p);

	void persistProducts(ArrayList<Product> ps);

	Product findByName(String name);

	ArrayList<Product> getEntities();

	void updateProduct(Product p);

	void removeProduct(Product p);
}
