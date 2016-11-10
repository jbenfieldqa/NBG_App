package com.qac.nbg_app.entities;

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
	
	public Supplier(String supplierName) {
		this.supplierName = supplierName;
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
	
}
