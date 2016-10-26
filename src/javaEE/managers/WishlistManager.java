package javaEE.managers;

import java.util.*;
import javaEE.project.Wishlist;

public interface WishlistManager {
	public void persistWishlist (Wishlist w);
	public void persistWishlists (List<Wishlist> w);
	
	public List<Wishlist> listWishList();
	public Wishlist findWishlistById (int id);
	
	public void updateWishlist (Wishlist w);
	
	public void removeWishlist (Wishlist w);
}
