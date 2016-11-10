package com.qac.nbg_app.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table (name = "Product")

@NamedQueries ({
	@NamedQuery (name="Product.FIND_ALL_PRODUCTS", query = "SELECT a FROM Product a"),
	@NamedQuery (name="Product.FIND_BY_ID", query = "SELECT b FROM Product b WHERE b.productId = :name"),
	@NamedQuery (name="Product.FIND_BY_NAME", query = "SELECT c FROM Product c WHERE c.productName = :name"),
})

public class Product {
	
	//Query Declarations
	public static final String FIND_BY_ID = "Product.FIND_BY_ID";
	public static final String FIND_BY_NAME = "Product.FIND_BY_NAME";
	public static final String FIND_ALL_PRODUCTS = "Product.FIND_ALL_PRODUCTS";

	
	@Id //ID is for PK
	@Column (name = "idProduct", nullable=false, unique=true)  
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@NotNull
	private long id;
	
	@Column (name = "name", nullable = false, length = 255)
	@NotNull
	@Size(max=225)
	private String name;
	
	@Column (name = "description", nullable = false, length = 1000)
	@NotNull
	@Size(max = 1000)
	private String description;
	
	@Column (name = "image", nullable = true, length = 1000)
	@Size(max = 1000)
	private String image;
	
	@Column (name = "price", nullable = false, length = 1000)
	@NotNull
	@Size(max = 1000)
	private double price;
	
	@Column (name = "catgeory", nullable = true, length = 1000)
	@Size(max = 1000)
	private String catgeory;
	
	@Column (name = "stockLevel", nullable = false, length = 1000)
	@NotNull
	@Size(max = 1000)
	private int stockLevel;
	
	//Constructor
	public Product(){};

	public Product(String name, String description, double price, int stockLevel){
		this.name = name;
		this.description = description;
		image = null;
		this.price = price;
		catgeory = null;
		this.stockLevel = stockLevel;
	}
	
	public Product(String name, String description, String image, double price, String category, int stockLevel){
		this.name = name;
		this.description = description;
		this.image = image;
		this.price = price;
		this.catgeory = category;
		this.stockLevel = stockLevel;
	}
	
	@Override
	public String toString(){
		String out = name + "\n" + description + "\n" + id;
		return out;
	}

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}