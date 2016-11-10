package com.qac.nbg_app.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table (name = "wishlist")

//Queries
@NamedQueries ({
	@NamedQuery (name= Wishlist.FIND_BY_CUSTOMER_ID, query = "SELECT a FROM  Wishlist a WHERE a.customerId = :customerId"),
	@NamedQuery (name= Wishlist.FIND_BY_PRODUCT_ID, query = "SELECT a FROM  Wishlist a WHERE a.productId = :productId"),
})

public class Wishlist {
	
	//Query Declarations
	public static final String FIND_BY_CUSTOMER_ID = "Wishlist.findByCustomer";
	public static final String FIND_BY_PRODUCT_ID = "Wishlist.findByProduct";
	
	@OneToMany
	@JoinColumn(name = "customerId", nullable = false)
	@NotNull
	private int customerId;
	
	@OneToMany
	@JoinColumn(name = "productId", nullable = false)
	@NotNull
	private int productId;
	
	public Wishlist(int customerId, int productId) {
		this.customerId = customerId;
		this.productId =productId;
	}
	
	public int getCustomerId() {
		return customerId;
	}
	
	public int getProductId(){
		return productId;
	}
}
