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
	@NamedQuery (name="Product.findAllProducts",
	query = "SELECT a FROM Product a"),
	@NamedQuery (name="Product.find_by_productId",
	query = "SELECT b FROM Product b WHERE b.productId = :name"),
	@NamedQuery (name="Product.find_by_productName",
	query = "SELECT c FROM Product c WHERE c.productName = :name"),
})

public class Product {
	
	@Id //ID is for PK
	@Column (name = "Product_ID", nullable=false, unique=true)  
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@NotNull
	private long id;
	
	@Column (name = "Name", nullable = false, length = 255)
	@NotNull
	@Size(max=225)
	private String name;
	
	@Column (name = "Description", nullable = false, length = 1000)
	@NotNull
	@Size(max = 1000)
	private String description;
	
	//Constructor
	public Product(){};

	public Product(String name, String description){
		this.name = name;
		this.description = description;
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