package javaEE.project;
import javaEE.enums.Status;
import javaEE.project.*;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity 
@Table(name = "ProductItem")

@NamedQueries ({
@NamedQuery (name="ProductItem.findAllProductItems",
query = "SELECT a FROM ProductItem a"),
@NamedQuery (name="ProductItem.find_by_productID",
query = "SELECT b FROM ProductItem b WHERE b.productID = :name"),
@NamedQuery (name="ProductItem.find_by_pgName",
query = "SELECT c FROM ProductItem c WHERE c.productName = :name"),
})

public class ProductItem_BASE_15140 {
	@Id 
	@Column(name="productID")
	@GeneratedValue (
		strategy = GenerationType.IDENTITY)
	private int productID;
	@ManyToOne	
	@JoinColumn(name="pgID", nullable=false)
	@NotNull
	private int pgID;
	
	@ManyToMany
	@JoinColumn(name="employeeID", nullable=false)
	@NotNull
	private int employeeID; 

	@ManyToOne
	@JoinColumn(name="customerID", nullable=false)
	@NotNull
	private int customerID;
	@Column (name="productName", nullable = false, length =225)
	@NotNull
	@Size (min =2, max=225)
	private String productName; 
	@Column (name="status", nullable = false, length =225)
	@NotNull
	@Size (min =2, max=225)
	protected Status status; 
	
	public ProductItem_BASE_15140(int productID, String productName){
		this.productID = productID;
		this.productName = productName;	
	}
	
	public int getProductID(){
		return productID;	
	}
	
	public void setProductID(int productID){
		this.productID = productID; 
	}
	
	public String getProductName(){
		return productName; 
	}
	
	public void setProductName(String productName){
		this.productName = productName;
	}


}
