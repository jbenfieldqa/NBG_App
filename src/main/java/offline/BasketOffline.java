package offline;

import java.util.List;


import managers.BasketManager;

import javax.inject.*;

import com.qac.nbg_app.util.InitialData;


public class BasketOffline implements BasketManager{
	@Inject
	private InitialData initialData;
	
	public void persistBasket(com.qac.nbg_app.entities.Basket a) {
		initialData.addBasket(a);
	}
	
	public void updateBasket(com.qac.nbg_app.entities.Basket b) {
		List<com.qac.nbg_app.entities.Basket> bs = initialData.getBaskets();
		for(int i=0; i<bs.size(); i++) {
			if(bs.get(i).equals(b))bs.set(i, b);
		}                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                             
		initialData.setBaskets(bs);
	}

	@Override
	public void removeItem(com.qac.nbg_app.entities.Basket b) {
		List<com.qac.nbg_app.entities.Basket> bs = initialData.getBaskets();
		for(int i=0; i<bs.size(); i++) {
			if(bs.get(i).equals(b))bs.remove(i);
		}
		initialData.setBaskets(bs);
	}

	
}
