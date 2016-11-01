package project;


import java.util.ArrayList;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table (name = "wishlist")

//Queries
@NamedQueries ({
	@NamedQuery (name= Wishlist.FIND_BY_WISHLIST_ID, query = "SELECT a FROM  Wishlist a WHERE a.wishlistId = :wishlistId"),
})

public class Wishlist {
	
	//Query Declarations
	public static final String FIND_BY_WISHLIST_ID = "Wishlist.findByWishlist";
	
	@Id
	@Column(name = "wishlistId")
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int wishlistId;
	
	@OneToOne
	@JoinColumn(name = "customerId", nullable = false)
	@NotNull
	private int customerId;
	
	@OneToMany
	@JoinColumn(name = "productGroupId", nullable = false)
	@NotNull
	private ArrayList<Integer> productGroupIds;
	
	public Wishlist(int customerId, int wishlistId) {
		// this.wishlistId = setWishlistId(); 
		this.wishlistId = wishlistId;
		this.customerId = customerId;
		//this.productGroupIds = ProductGroupIds;
	}
	
	//setWId needs to be implemented, currently returns 0
	// public int setWishlistId(){return 0;} 
	public void setWishlistId(int wishlistId){
		this.wishlistId = wishlistId;
	}

	public int getWishlistId(){
		return wishlistId;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setWId(int customerId) {
		this.wishlistId = customerId;
	}
	public ArrayList<Integer> getProductGroupIds() {
		return productGroupIds;
	}
	public void addPGId(int productGroupId){
		productGroupIds.add(productGroupId);
	}
	public void removePGId(int productGroupId){
		productGroupIds.remove(productGroupId);
	}
}
