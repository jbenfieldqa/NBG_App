package com.qac.nbg_app.entities;

//Imports
import java.util.*;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table (name = "basket")

//Queries
@NamedQueries ({
	@NamedQuery (name= Basket.FIND_BY_BASKET_ID, query = "SELECT a FROM  Basket a WHERE a.basketId = :basketId"),
	@NamedQuery (name= Basket.FIND_BY_LAST_ACTIVE, query = "SELECT a FROM  Basket a WHERE a.lastActive = :lastActive"),
	
})

public class Basket {
	
	//Query Declarations
	public static final String FIND_BY_BASKET_ID = "Basket.findByBasket";
	public static final String FIND_BY_LAST_ACTIVE = "Basket.findByBasket";
	
	//Variable Declarations
	@Id
	@Column(name = "basketId")
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int basketId;
	
	@OneToOne
	@JoinColumn(name = "customerId", nullable = false)
	@NotNull
	private int customerId;
	
	@OneToMany
	@JoinColumn(name = "productItemIds", nullable = false)
	@NotNull
	private ArrayList<Integer> productItemIds;
	
	@Column(name = "lastActive", nullable = false, length = 225)
	@NotNull
	@Size (min = 2, max = 225)
	private String lastActive;
	
	//Constructor
	public Basket(int customerId, ArrayList<Integer> productItemIds, String lastActive) {
		this.customerId = customerId;
		this.productItemIds = productItemIds;
		this.lastActive = lastActive;
	}

	//Getters and Setters
	//Set bId to be implemented
	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public ArrayList<Integer> getProductItemIds() {
		return productItemIds;
	}

	public void setProductItemIds(ArrayList<Integer> productItemIds) {
		this.productItemIds = productItemIds;
	}

	public String getLastActive() {
		return lastActive;
	}

	public void setLastActive(String lastActive) {
		this.lastActive = lastActive;
	}
	

}
