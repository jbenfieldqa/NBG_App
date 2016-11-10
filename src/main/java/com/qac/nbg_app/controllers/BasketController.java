//package com.qac.nbg_app.controllers;
//
//import javax.enterprise.context.SessionScoped;
//import javax.faces.model.DataModel;
//import javax.faces.model.ListDataModel;
//import javax.inject.Inject;
//import javax.inject.Named;
//
//import com.qac.nbg_app.entities.ProductGroup;
//import com.qac.nbg_app.services.BasketService;
//import com.qac.nbg_app.util.BasketHelper;
//
//@Named("basket")
//@SessionScoped
//public class BasketController {
//	@Inject
//	private BasketService basketService;
//	private BasketHelper basketHelper;
//	
////	public BasketHelper getPagination() {
////		if(basketHelper==null){
////			basketHelper = new BasketHelper() {
////				@Override
////				//public DataModel createDataModel() {
////					try {
////						//<return new ListDataModel<ProductGroup>(basketService.findAll());
////					} catch (Exception e) {
////						return new ListDataModel<ProductGroup>();
////					}
////				}
////				@Override
////				public int getItemsCount() {
////					return basketService.findAll().size();
////				}
////			};
////		}
////		return basketHelper;
////	}
//
//}
