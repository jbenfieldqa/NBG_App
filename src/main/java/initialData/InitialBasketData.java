package main.java.initialData;

import java.util.ArrayList;
import java.util.List;

import main.java.project.*;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;


@Startup
@Singleton 
public class InitialBasketData {
	private List<Basket> baskets =  new ArrayList<Basket>();
	
	@PostConstruct
	public void setupData(){
		baskets.add(new Basket(1, new ArrayList<Integer>(1), "yesterday"));
		baskets.add(new Basket(2, new ArrayList<Integer>(2), "yesterday"));
		baskets.add(new Basket(3, new ArrayList<Integer>(3), "yesterday"));
	}
	
	public void addBasket(Basket b) {
		baskets.add(b);		
	}

	public List<Basket> getBaskets() {
		return baskets;
	}

	public void setBaskets(List<Basket> b) {
		this.baskets = b;
	}
	
}
