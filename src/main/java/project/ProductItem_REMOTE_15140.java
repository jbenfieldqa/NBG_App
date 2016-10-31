package main.java.project;

import main.java.enums.Status;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity 
@Table(name = "ProductItem")

@NamedQueries ({
	@NamedQuery (name="ProductItem.findAllProductItems",
	query = "SELECT a FROM ProductItem a"),
	@NamedQuery (name="ProductItem.find_by_productItemId",
	query = "SELECT b FROM ProductItem b WHERE b.productItemId = :name"),
	@NamedQuery (name="ProductItem.find_by_productName",
	query = "SELECT c FROM ProductItem c WHERE c.productName = :name"),
})

public class ProductItem_REMOTE_15140 {
	
	@Id 
	@Column(name="productItemId")
	@GeneratedValue (
		strategy = GenerationType.IDENTITY)
	private int productItemId;
	
	@ManyToOne	
	@JoinColumn(name="productGroupId", nullable=false)
	@NotNull
	private int productGroupId;
	
	@ManyToOne
	@JoinColumn (name="productName", nullable = false)
	@NotNull
	@Size (min =2, max=225)	
	private String productName;
	
	@Column (name="productStatus", nullable = false, length =225)
	@NotNull
	@Size (min =2, max=225)
	protected Status productStatus; 
	
	public ProductItem_REMOTE_15140(int productItemId, String productName){
		this.productItemId = productItemId;
		this.productName = productName;	
	}
	
	public int getProductItemId(){
		return productItemId;	
	}
	
	public void setProductItemId (int productItemId){
		this.productItemId = productItemId; 
	}
	
	public String getProductName(){
		return productName; 
	}
	
	public void setProductName(String productName){
		this.productName = productName;
	}


}
