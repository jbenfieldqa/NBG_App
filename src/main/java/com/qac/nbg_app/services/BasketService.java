package com.qac.nbg_app.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.qac.nbg_app.entities.Basket;
import com.qac.nbg_app.managers.BasketManager;

@Stateless
public class BasketService {
	
	@Inject
	private BasketManager basketManager;
	
	public List<Basket> findAll(){
		return basketManager.findAll();
	}

}
