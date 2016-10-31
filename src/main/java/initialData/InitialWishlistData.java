package javaEE.initialData;

import java.util.ArrayList;
import java.util.List;

import javaEE.project.Wishlist;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;

@Startup
@Singleton 
public class InitialWishlistData {
	private List<Wishlist> wishlists = new ArrayList<Wishlist>();
	
	@PostConstruct
	public void setupData() {
		wishlists.add(new Wishlist(1,1));
		wishlists.add(new Wishlist(2,2));
		wishlists.add(new Wishlist(3,3));
	}
	
	public void addWishlist(Wishlist w){
		wishlists.add(w);
	}
	
	public List<Wishlist> getWishlists(){
		return wishlists;
	}
	
	public void setWishlists (List<Wishlist> ws){
		wishlists = ws;
	}
}
