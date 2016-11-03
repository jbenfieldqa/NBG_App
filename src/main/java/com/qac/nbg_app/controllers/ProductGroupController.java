package com.qac.nbg_app.controllers;

import java.io.Serializable;

import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.inject.Inject;
import javax.inject.Named;

import com.qac.nbg_app.entities.ProductGroup;
import com.qac.nbg_app.services.ProductGroupServices;

import com.qac.nbg_app.util.InitialData;

@Named("ProductGroup")

public class ProductGroupController implements Serializable{
	@Inject
	private ProductGroupServices ProductGroupService;
	private DataModel<ProductGroup> productGroupList = null;
	
	public DataModel createDataModel()
	{
		return new ListDataModel<ProductGroup>(ProductGroupService.findAll().subList(0, 2));
	}
	public DataModel<ProductGroup> getProductGroups()
	{
		if (productGroupList == null) productGroupList = createDataModel();
		return productGroupList;
	}
}
