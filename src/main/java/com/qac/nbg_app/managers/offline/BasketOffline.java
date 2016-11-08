package com.qac.nbg_app.managers.offline;

import java.util.List;

import javax.ejb.Stateless;
import javax.enterprise.inject.Default;
import javax.inject.*;

import com.qac.nbg_app.entities.Basket;
import com.qac.nbg_app.managers.BasketManager;
import com.qac.nbg_app.util.InitialData;

@Stateless
@Default
public class BasketOffline implements BasketManager{
	@Inject
	private InitialData initialData;
	
	public void persistBasket(Basket a) {
		initialData.addBasket(a);
	}
	
	public void updateBasket(Basket b) {
		List<Basket> bs = initialData.getBaskets();
		for(int i=0; i<bs.size(); i++) {
			if(bs.get(i).equals(b))bs.set(i, b);
		}                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                             
		initialData.setBaskets(bs);
	}

	@Override
	public void removeItem(Basket b) {
		List<Basket> bs = initialData.getBaskets();
		for(int i=0; i<bs.size(); i++) {
			if(bs.get(i).equals(b))bs.remove(i);
		}
		initialData.setBaskets(bs);
	}

	@Override
	public List<Basket> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	
}
