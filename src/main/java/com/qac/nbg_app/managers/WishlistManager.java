package com.qac.nbg_app.managers;

import java.util.*;

import com.qac.nbg_app.entities.Wishlist;


public interface WishlistManager {
	
	public void persistWishlist (Wishlist w);
	
	public void persistWishlists (List<Wishlist> w);
	
	public List<Wishlist> listWishList();
	
	public Wishlist findWishlistByCustomerId (int id);
	
	public Wishlist findWishlistByProductId (int id);
	
	public void updateWishlist (Wishlist w);
	
	public void removeWishlist (Wishlist w);
}
