package com.qac.nbg_app.controllers;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.inject.Inject;
import javax.inject.Named;

import com.qac.nbg_app.entities.Product;
import com.qac.nbg_app.services.BrowseService;
import com.qac.nbg_app.util.Pagination;

@Named("browse")
@SessionScoped
public class BrowseController implements Serializable{
	@Inject
	private BrowseService browseService;
	private DataModel<Product> products = null;
	private Pagination pagination;
	private List<Integer> pages = new ArrayList<Integer>();
	private int numPerPage = 12;
	private int pageNum = 1;
	
	public String next() {
		getPagination().nextPage();
		recreateModel();
		return "CatCatalogue";
	}
	
	public String previous() {
		getPagination().previousPage();
		recreateModel();
		return "CatCatalogue";	
	}
	
	public String toPage(int toPage){
		toPage--;
		pageNum = getPagination().getPageNum();
		if (toPage > pageNum){
			for (int i = pageNum; i < toPage; i++){
				getPagination().nextPage();
				recreateModel();
			}
		}
		else {
			for (int i = pageNum; i > toPage; i--){
				getPagination().previousPage();
				recreateModel();
			}
		}
		return "CatCatalogue";
	}
	
	private void recreateModel() {
		products = null;
	}

	public DataModel<Product> getProducts() {
		if(products == null)
			products = getPagination().createDataModel();
		
		return products;
	}
	
	public List<Integer> getPages(){
		if (pages.isEmpty()){
			for	(int i = 0; i < getPagination().getNumOfPages(); i++){
				pages.add(i + 1);
			}
		}
		return pages;
	}

	public Pagination getPagination() {
		if(pagination==null)
			pagination = new Pagination(numPerPage) {
				
				@Override
				public DataModel createDataModel() {
					try {
						return new ListDataModel<Product>(browseService.findAll().subList(getPageFirstItem(), getPageFirstItem() + getPageSize()));
					} catch (Exception e) {
						return new ListDataModel<Product>(browseService.findAll().subList(getPageFirstItem(), getItemsCount()));
					}
				}

				@Override
				public int getItemsCount() {
					return browseService.findAll().size();
				}
				
				@Override
				public int getNumOfPages(){
					int numOfPages = 1;
					int i = pagination.getPageSize();
					int cont = getItemsCount() - 1;
					while (cont > i){
						i += pagination.getPageSize();
						numOfPages++;
					}
					return numOfPages;
					
				}
			};
		return pagination;
	}	
	
	public String setNumPerPage(int num){
		numPerPage = num;
		pagination = null;
		recreateModel();
		return "CatCatalogue";
	}
	
	public void toNumPage(){
		System.out.println(pageNum);
		pageNum = getPagination().getPageNum();
		System.out.println("- - - - - - -");
		System.out.println(pageNum);
	}
}