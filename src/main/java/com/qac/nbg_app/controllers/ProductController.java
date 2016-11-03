package com.qac.nbg_app.controllers;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;

import javax.inject.Inject;
import javax.inject.Named;

import com.qac.nbg_app.entities.Product;
import com.qac.nbg_app.services.BrowseService;


@Named("product")
@SessionScoped
public class ProductController implements Serializable{
	@Inject
	private BrowseService browseService;
	private Product testProduct;
	
	public String itemClick(Product p){
		testProduct = p;
		return "CatItem";
	}
	
	public String toString(){
		return testProduct.toString();
	}
	
	public String name(){
		return testProduct.getName();
	}
	
	public String description(){
		return testProduct.getDescription();
	}
	
}
