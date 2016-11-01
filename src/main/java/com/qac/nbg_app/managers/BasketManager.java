package com.qac.nbg_app.managers;

import com.qac.nbg_app.entities.Basket;

public interface BasketManager {
	
	public void persistBasket (Basket b);
	
	public void updateBasket(Basket b);
	
	public void removeItem(Basket b);

}
