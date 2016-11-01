package com.qac.nbg_app.managers.offline;

import java.util.List;

import javax.ejb.Stateless;
import javax.enterprise.inject.Default;
import javax.inject.Inject;

import com.qac.nbg_app.entities.Product;
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
}