package com.qac.nbg_app.controllers;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

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
	private List<Product> products = new ArrayList<Product>();
	private List<Product> similairProducts = new ArrayList<Product>();
	
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
	
	public void showSimilair(int count){
		if (products.isEmpty()){
			getProducts();
		}
		for	(int i = 0; i < count; i++){
			similairProducts.add(products.get(i));
		}
	}
	
	private void getProducts(){
		products = browseService.findAll();
	}
	
}
