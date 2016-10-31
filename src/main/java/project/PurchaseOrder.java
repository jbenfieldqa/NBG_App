package main.java.project;

import java.util.*;
import javax.persistence.*;
import javax.validation.constraints.*;


@Entity
@Table(name = "purchaseorder")

@NamedQueries({
	@NamedQuery(name = PurchaseOrder.FIND_BY_ORDER_ID, query = "SELECT a FROM purchaseOrder a WHERE a.purchaseOrderId = :purchaseOrderId"),
	@NamedQuery(name = PurchaseOrder.FIND_BY_SUPPLIER_ID, query = "SELECT a FROM purchaseOrder a WHERE a.supplierID = :supplierID"),
	@NamedQuery(name = PurchaseOrder.FIND_BY_DATE_ORDERED, query = "SELECT a FROM purchaseOrder a WHERE a.dateOrdered = :dateOrdered"),
	@NamedQuery(name = PurchaseOrder.FIND_BY_DATE_RECEIVED, query = "SELECT a FROM purchaseOrder a WHERE a.dateReceived = :dateReceived")
})

public class PurchaseOrder {
	
	//Query Declarations
	public static final String FIND_BY_ORDER_ID = "purchaseOrder.findbypurchaseOrder";
	public static final String FIND_BY_SUPPLIER_ID = "purchaseOrder.findbypurchaseOrder";
	public static final String FIND_BY_DATE_ORDERED = "purchaseOrder.findbypurchaseOrder";
	public static final String FIND_BY_DATE_RECEIVED = "purchaseOrder.findbypurchaseOrder";
	
	//Variable Declarations
	@Id
	@Column(name = "purchaseOrderId")
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int purchaseOrderId;
	
	@ManyToOne
	@JoinColumn(name = "productGoupId", nullable = false)
	@NotNull
	public int productGroupId;
	
	@Column(name = "amountOrdered", nullable = false)
	@NotNull
	public int amountOrdered;
	
	@Column(name = "amountReceived")
	public int amountReceived;
	
	@OneToMany
	@JoinColumn(name = "supplierId", nullable = false)
	@NotNull
	public int supplierId;
	
	@Column(name = "dateOrdered", nullable = false)
	@NotNull	
	private int dateOrdered;
	
	@Column(name = "dateReceived")
	private int dateRecieved;

	List<List<Integer>> productOrdered = new ArrayList<List<Integer>>();
	
	public PurchaseOrder(int purchaseOrderId, int productGroupId, int  amountOrdered, int amountReceived, int supplierId, int dateOrdered, int dateRecieved)
	{
		this.purchaseOrderId = purchaseOrderId;
		this.productGroupId = productGroupId;
		this.amountOrdered = amountOrdered;
		this.supplierId = supplierId;
		this.dateOrdered = dateOrdered;
		this.dateRecieved = dateRecieved;
	}

	
	void viewOrderHistory()
	{
		//Show order History
	}
	void viewCurrentOrder()
	{
		//Show Current Order
	}
	void viewPendingOrders()
	{
		//Show Pending Order
	}


	//Getter and Setters
	
	public int getPurchaseOrderId() {
	return purchaseOrderId;

	}
	public int setPurchaseOrderId() {
		return 0;
	}
	public int getSupplierId() {
		return supplierId;
	}
	public void setSupplierID(int supplierId) {
		this.supplierId = supplierId;
	}
	public int getDateOrdered() {
		return dateOrdered;
	}
	public void setDateOrdered(int dateOrdered) {
		this.dateOrdered = dateOrdered;
	}
	public int getDateRecieved() {
		return dateRecieved;
	}
	public void setDateRecieved(int dateRecieved) {
		this.dateRecieved = dateRecieved;
	}
	
	

	
}
