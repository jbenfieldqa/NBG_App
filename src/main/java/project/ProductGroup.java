package project;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity 
@Table(name = "ProductGroup")

@NamedQueries ({
@NamedQuery (name="ProductGroup.findAllProductGroups",
query = "SELECT a FROM ProductGroup a"),
@NamedQuery (name="ProductGroup.findByProductName",
query = "SELECT c FROM ProductGroup c WHERE c.productName = :name"),
@NamedQuery (name="ProductGroup.find_by_productGroupId",
query = "SELECT b FROM ProductGroup b WHERE b.productGroupId = :name"),

})

public class ProductGroup {
	@Id 
	@Column(name="productGroupId")
	@GeneratedValue (
		strategy = GenerationType.IDENTITY)
	private int productGroupId;

	@OneToMany
	@JoinColumn(name="productItemId", nullable=false)
	@NotNull
	private int productItemId; 
	
	@ManyToMany
	@JoinColumn(name="supplierOrderId", nullable=false)
	@NotNull
	private int supplierOrderId; 
	
	@Column (name="productName", nullable = false, length =225)
	@NotNull
	@Size (min =2, max=225)
	private String productName;
	
	@Column (name="productPrice", nullable = false, length =225)
	@NotNull
	@Size (min =2, max=225)
	private double productPrice;
	
	@Column (name="productCost", nullable = false, length =225)
	@NotNull
	@Size (min =2, max=225)
	private double productCost; 
	
	@Column (name="amountOfProduct", nullable = false, length =225)
	@NotNull
	@Size (min =2, max=225)
	private int amountOfProduct;
	
	@Column (name="minThreshold", nullable = false, length =225)
	@NotNull
	@Size (min =2, max=225)
	private int minThreshold;
	
	@Column (name="maxThreashold", nullable = false, length =225)
	@NotNull
	@Size (min =2, max=225)
	private int maxThreshold;

	public ProductGroup(int productGroupId, String productName, int supplierOrderId, int productPrice, int productCost, int amountOfProduct, int minThreshold, int maxThreashold){
		this.productGroupId = productGroupId;
		this.productName = productName;	
		this.supplierOrderId = supplierOrderId;
		this.productPrice = productPrice;
		this.productCost = productCost;
		this.amountOfProduct = amountOfProduct; 
		this.minThreshold = minThreshold; 
		this.maxThreshold = maxThreashold; 

	}

	public int getProductGroupId() {
		return productGroupId;
	}

	public void setProductGroupId(int productGroupId) {
		this.productGroupId = productGroupId;
	}

	public String getProductName() {
		return productName;
	}
	
	public void setProductName(String productName) {
		this.productName = productName;
	}

	public double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;

	}


	public double getProductCost() {
		return productCost;
	}



	public void setProductCost(double productCost) {
		this.productCost = productCost;
	}

	public int getAmountOfProduct() {
		return amountOfProduct;
	}


	public void setAmountOfProduct(int amountOfProduct) {
		this.amountOfProduct = amountOfProduct;
	}
}
