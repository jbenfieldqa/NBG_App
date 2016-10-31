package main.java.project;
import main.java.enums.Status;

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

public class ProductItem_LOCAL_15140 {
	@Id 
	@Column(name="productItemId")
	@GeneratedValue (
		strategy = GenerationType.IDENTITY)
	private int productItemId;
	@ManyToOne	
	@JoinColumn(name="productGroupId", nullable=false)
	@NotNull
	private int productGroupID;
	
	@Column (name="productName", nullable = false, length =225)
	@NotNull
	@Size (min =2, max=225)
	private String productName; 
	
	@Column (name="status", nullable = false, length =225)
	@NotNull
	@Size (min =2, max=225)
	protected Status status; 
	
	public ProductItem_LOCAL_15140(int productItemId, int productGroupId, String productName, Status status){
		this.productItemId = productItemId;
		this.productGroupID = productGroupId; 
		this.productName = productName;	
		this.status = status;
	}
	
	public int getProductID(){
		return productItemId;	
	}
	
	public void setProductID(int productItemId){
		this.productItemId = productItemId; 
	}
	
	public String getProductName(){
		return productName; 
	}
	
	public void setProductName(String productName){
		this.productName = productName;
	}

}
