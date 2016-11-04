package com.qac.nbg_app.managers.offline;

import java.util.List;

import javax.ejb.Stateless;
import javax.enterprise.inject.Default;
import javax.inject.*;

import com.qac.nbg_app.entities.Wishlist;
import com.qac.nbg_app.managers.WishlistManager;
import com.qac.nbg_app.util.InitialData;

@Default
@Stateless
public class WishlistOffline implements WishlistManager {
	
	@Inject
	private InitialData initialData;

	public void persistWishlist(Wishlist w) {
		initialData.addWishlist(w);
		
	}

	public void persistWishlists(List<Wishlist> w) {
		initialData.getWishlists();
	}

	public Wishlist findWishlistById(int id) {
		List<Wishlist> ws = initialData.getWishlists();
		for(Wishlist i: ws) {
			if(i.getWishlistId() == id) return i;;
		}
		
		return null;
	}

	public void updateWishlist(Wishlist w) {
		List<Wishlist> ws = initialData.getWishlists();
		for(int i=0; i<ws.size(); i++) {
			if(ws.get(i).equals(w))ws.set(i, w);
		}
		initialData.setWishlists(ws);
		
	}
		

	public void removeWishlist(Wishlist w) {
		List<Wishlist> ws = initialData.getWishlists();
		for(int i=0; i<ws.size(); i++) {
			if(ws.get(i).equals(w))ws.remove(i);
		}
		initialData.setWishlists(ws);
		
	}

	public List<Wishlist> listWishList() {
		return initialData.getWishlists();
	}

}
