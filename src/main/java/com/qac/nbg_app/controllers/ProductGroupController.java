package com.qac.nbg_app.controllers;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.inject.Inject;
import javax.inject.Named;

import com.qac.nbg_app.entities.ProductGroup;
import com.qac.nbg_app.services.ProductGroupServices;

@Named("ProductGroup")
@SessionScoped
public class ProductGroupController implements Serializable{
	@Inject
	private ProductGroupServices ProductGroupService;
	private DataModel<ProductGroup> productGroupList = null;
	
	public DataModel<ProductGroup> createDataModel(){
		System.out.println("Called");
		return new ListDataModel<ProductGroup>(ProductGroupService.findAll().subList(0, 2));
	}
	public DataModel<ProductGroup> getProductGroups()
	{
		System.out.println("Called");

		if (productGroupList == null) 
			
			
			productGroupList = createDataModel();
		
		System.out.println(productGroupList);
		return productGroupList;
	}
}
