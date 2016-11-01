package com.qac.nbg_app.entities;

import java.util.ArrayList;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "suppliers")

@NamedQueries({ 
	@NamedQuery (name= Supplier.FIND_BY_SUPPLIER_ID, query = "SELECT a FROM  Supplier a WHERE a.supplierId = :supplierId"),
	@NamedQuery (name= Supplier.FIND_BY_SUPPLIER_NAME, query = "SELECT a FROM  Supplier a WHERE a.supplierName = :supplierName")
	})

public class Supplier {
	
	public static final String FIND_BY_SUPPLIER_ID = "Supplier.findBySupplier";
	public static final String FIND_BY_SUPPLIER_NAME = "Supplier.findBySupplier";
	
	@Id
	@Column(name="supplierId")
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int supplierId;
	
	@Column(name = "supplierName", nullable = false)
	@NotNull
	private String supplierName;
	
	@OneToMany
	@JoinColumn(name = "productGroupIds", nullable = false)
	@NotNull
	private ArrayList<Integer> productGroupIds;
	
	public Supplier(String supplierName) {
		this.supplierName = supplierName;
		productGroupIds = new ArrayList<Integer>();
	}
	
	public int getSupplierId() {
		return supplierId;
	}
	public String getSupplierName() {
		return supplierName;
	}
	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}
	public ArrayList<Integer> getProductGroupIds() {
		return productGroupIds;
	}
	public void setpGIds(ArrayList<Integer> productGroupIds) {
		this.productGroupIds = productGroupIds;
	}
	public void addProductGroupId(int productGroupId){
		productGroupIds.add(productGroupId);
	}
	public void removeProductGroupId(int productGroupId){
		productGroupIds.remove(productGroupId);
	}
	
}
