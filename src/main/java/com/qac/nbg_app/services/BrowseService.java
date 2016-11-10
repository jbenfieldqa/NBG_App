package com.qac.nbg_app.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.qac.nbg_app.entities.Product;
import com.qac.nbg_app.entities.ProductGroup;
import com.qac.nbg_app.managers.ProductManager;

@Stateless
public class BrowseService {
	@Inject
	private ProductManager productManager;

	public List<Product> findAll() {
		return productManager.findAll();
	}
}