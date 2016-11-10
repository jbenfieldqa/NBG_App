package com.qac.nbg_app.managers.offline;

import java.util.List;

import javax.ejb.Stateless;
import javax.enterprise.inject.Default;
import javax.inject.*;

import com.qac.nbg_app.entities.Wishlist;
import com.qac.nbg_app.managers.WishlistManager;
import com.qac.nbg_app.util.InitialData;


@Stateless
@Default
public class WishlistOffline implements WishlistManager {
	
	@Inject
	private InitialData initialData;
	
	@Override
	public void persistWishlist(Wishlist w) {
		initialData.addWishlist(w);
	}
	
	@Override
	public void persistWishlists(List<Wishlist> w) {
		initialData.getWishlists();
	}

	@Override
	public void updateWishlist(Wishlist w) {
		List<Wishlist> ws = initialData.getWishlists();
		for(int i=0; i<ws.size(); i++) {
			if(ws.get(i).equals(w))ws.set(i, w);
		}
		initialData.setWishlists(ws);
	}
		
	@Override
	public void removeWishlist(Wishlist w) {
		List<Wishlist> ws = initialData.getWishlists();
		for(int i=0; i<ws.size(); i++) {
			if(ws.get(i).equals(w))ws.remove(i);
		}
		initialData.setWishlists(ws);
		
	}

	@Override
	public List<Wishlist> listWishList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Wishlist findWishlistByCustomerId(int id) {
		List<Wishlist> ws = initialData.getWishlists();
		for(Wishlist i: ws) {
			if(i.getCustomerId() == id){
				return i;
			}
		}
		return null;
	}

	@Override
	public Wishlist findWishlistByProductId(int id) {
		List<Wishlist> ws = initialData.getWishlists();
		for(Wishlist i: ws) {
			if(i.getProductId() == id){
				return i;
			}
		}
		return null;
	}

}
