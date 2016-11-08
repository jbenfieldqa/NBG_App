package com.qac.nbg_app.util;

import java.util.ArrayList;

import javax.faces.model.DataModel;

import com.qac.nbg_app.entities.ProductGroup;

public abstract class BasketHelper {
	private ArrayList<ProductGroup> basketItems;
	
	public BasketHelper(){}
	
	public ArrayList<ProductGroup> getBasketItems(){
		return basketItems;
	}
	
	public void createBasketItems(){
		
	}

	public int getItemsCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	abstract public DataModel createDataModel();

}
