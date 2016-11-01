package main.java.offline;

import java.util.List;

import main.java.initialData.InitialBasketData;
import main.java.managers.BasketManager;
import main.java.project.Basket;

import javax.inject.*;


public class BasketOffline implements BasketManager{
	@Inject
	private InitialBasketData initialData;
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

	public void removeItem(Basket b) {
		List<Basket> bs = initialData.getBaskets();
		for(int i=0; i<bs.size(); i++) {
			if(bs.get(i).equals(b))bs.remove(i);
		}
		initialData.setBaskets(bs);
	}

}
