package managers;

import project.Basket;


public interface BasketManager {
	
	public void persistBasket (Basket b);
	
	public void updateBasket(Basket b);
	
	public void removeItem(Basket b);
	

}
