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
	private List<Integer> lowerPages = new ArrayList<Integer>();
	private List<Integer> HigherPages = new ArrayList<Integer>();
	private List<Integer> options = new ArrayList<Integer>();
	private List<Integer> lowerOptions = new ArrayList<Integer>();
	private List<Integer> higheroptions = new ArrayList<Integer>();
	private int numPerPage = 12;
	private int pageNum = 1;
	
	public void setOptions(){
		options.add(12);
		options.add(24);
		options.add(36);
		options.add(48);
	}
	
	public List<Integer> getLowerOptions(){
		lowerOptions.clear();
		if (options.isEmpty()){
			setOptions();
		}
		for	(Integer i : options){
			if (i < numPerPage){
				lowerOptions.add(i);
			}
		}
		return lowerOptions;
	}
	
	public List<Integer> getHigherOptions(){
		higheroptions.clear();
		if (options.isEmpty()){
			setOptions();
		}
		for	(Integer i : options){
			if (i > numPerPage){
				higheroptions.add(i);
			}
		}
		return higheroptions;
	}
	
	public String next() {
		getPagination().nextPage();
		recreateModel();
		pages.clear();
		pageNum++;
		return "CatCatalogue";
	}
	
	public String previous() {
		getPagination().previousPage();
		recreateModel();
		pages.clear();
		pageNum--;
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
		pageNum = toPage + 1;
		pages.clear();
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
			lowerPages.clear();
			HigherPages.clear();
			int pageCount = (getPagination().getNumOfPages() + 1);
			for	(int i = 1; i < pageCount; i++){
				pages.add(i);
				if (i < pageNum){
					lowerPages.add(i);
				}else if (i > pageNum){
					HigherPages.add(i);
				}
			}
		}
		return pages;
	}
	
	public List<Integer> getLowerPages(){
		if (pages.isEmpty()){
			lowerPages.clear();
			HigherPages.clear();
			int pageCount = (getPagination().getNumOfPages() + 1);
			for	(int i = 1; i < pageCount; i++){
				pages.add(i);
				if (i < pageNum){
					lowerPages.add(i);
				}else if (i > pageNum){
					HigherPages.add(i);
				}
			}
		}
		return lowerPages;
	}
	
	public List<Integer> getHigherPages(){
		if (pages.isEmpty()){
			lowerPages.clear();
			HigherPages.clear();
			int pageCount = (getPagination().getNumOfPages() + 1);
			for	(int i = 1; i < pageCount; i++){
				pages.add(i);
				if (i < pageNum){
					lowerPages.add(i);
				}else if (i > pageNum){
					HigherPages.add(i);
				}
			}
		}
		return HigherPages;
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
	
	public int getNumPerPage(){
		return numPerPage;
	}
	
	public String setNumPerPage(int num){
		numPerPage = num;
		pageNum = 1;
		pagination = null;
		pages.clear();
		recreateModel();
		return "CatCatalogue";
	}
	
	public int getPageNum(){
		return pageNum;
	}
	
	public void toNumPage(){
		System.out.println(pageNum);
		pageNum = getPagination().getPageNum();
		System.out.println("- - - - - - -");
		System.out.println(pageNum);
	}
	
	public String getItemDescription(String str){
		String shorter = str;
		if (str.length() > 35){
			shorter = str.substring(0, 32);
			shorter += "...";
		}
		return shorter;
	}
	
	
}