package com.qac.nbg_app.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.qac.nbg_app.entities.ProductGroup;
import com.qac.nbg_app.managers.ProductGroupManager;

@Stateless
public class ProductGroupServices {
	private ProductGroup productGroup;
	@Inject
	private ProductGroupManager productGroupManager;
	
	public List<ProductGroup> findAll(){
		return productGroupManager.findAll();
	}
}
