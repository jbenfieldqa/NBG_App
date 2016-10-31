package main.java.project;

//Imports
import java.util.*;
import main.java.enums.CustomerOrderStatus;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table(name = "customerorder" )

//Queries
@NamedQueries ({
	@NamedQuery (name= CustomerOrder.FIND_BY_ORDER_ID, query = "SELECT a FROM  CutomerOrder a WHERE a.customerOrderId = :customerOrderId"),
	@NamedQuery (name= CustomerOrder.FIND_BY_SHIPPING_ADDRESS, query = "SELECT a FROM  CutomerOrder a WHERE a.shippingAddress = :shippingAddress"),
	@NamedQuery (name= CustomerOrder.FIND_BY_BILLING_ADDRESS, query = "SELECT a FROM  CutomerOrder a WHERE a.billingAddress = :billingAddress"),
	@NamedQuery (name= CustomerOrder.FIND_BY_CUSTOMER_NAME, query = "SELECT a FROM  CutomerOrder a WHERE a.customerName = :customerName"),
	@NamedQuery (name= CustomerOrder.FIND_BY_DATE_PLACED, query = "SELECT a FROM  CutomerOrder a WHERE a.datePlaced = :datePlaced"),
	@NamedQuery (name= CustomerOrder.FIND_BY_DATE_SHIPPED, query = "SELECT a FROM  CutomerOrder a WHERE a.dateShipped = :dateShipped"),
	@NamedQuery (name= CustomerOrder.FIND_BY_STATUS, query = "SELECT a FROM  CutomerOrder a WHERE a.status = :status"),	
})

public class CustomerOrder {
	
	//Query Declarations
	public static final String FIND_BY_ORDER_ID = "CustomerOrder.findByCustomerOrder";
	public static final String FIND_BY_SHIPPING_ADDRESS = "CustomerOrder.findByCustomerOrder";
	public static final String FIND_BY_BILLING_ADDRESS = "CustomerOrder.findByCustomerOrder";
	public static final String FIND_BY_CUSTOMER_NAME = "CustomerOrder.findByCustomerOrder";
	public static final String FIND_BY_DATE_PLACED = "CustomerOrder.findByCustomerOrder";
	public static final String FIND_BY_DATE_SHIPPED = "CustomerOrder.findByCustomerOrder";
	public static final String FIND_BY_STATUS = "CustomerOrder.findByCustomerOrder";	
	
	//Variable Declarations
	@Id
	@Column(name = "customerOrderId")
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int customerOrderId;
	
	@ManyToOne
	@JoinColumn(name = "customerId_fk", nullable = false)
	@NotNull
	private int customerId;
	
	@OneToMany
	@JoinColumn(name = "productItemIds", nullable = false)
	@NotNull
	private ArrayList<Integer> productItemIds;
	
	@Column(name = "shippingAddress", nullable = false, length = 225)
	@NotNull
	@Size (min = 2, max = 225)
	private String shippingAddress;
	
	@Column(name = "billingAddress", nullable = false, length = 225)
	@NotNull
	@Size (min = 2, max = 225)
	private String billingAddress;
	
	@Column(name = "customerName", nullable = false, length = 225)
	@NotNull
	@Size (min = 2, max = 225)
	private String customerName;
	
	@Column(name = "email", nullable = false, length = 225)
	@NotNull
	@Size (min = 2, max = 225)
	private String email;
	
	@Column(name = "phoneNum", nullable = false, length = 225)
	@NotNull
	@Size (min = 2, max = 225)
	private String phoneNum;
	
	@Column(name = "cardNum", nullable = false)
	@NotNull
	private String cardNum;
	
	@Column(name = "datePlaced", nullable = false)
	@NotNull
	private String datePlaced;
	
	@Column(name = "dateShipped", nullable = false)
	@NotNull
	private String dateShipped;
	
	@Column(name = "orderStatus", nullable = false)
	@NotNull
	private CustomerOrderStatus orderStatus;
	
	//Constructor
	public CustomerOrder(int customerId, ArrayList<Integer> productItemIds, String shippingAddress,
			String billingAddress, String customerName, String email,
			String phoneNum, String cardNum, String datePlaced, String dateShipped,
			CustomerOrderStatus status) {
		this.customerId = customerId;
		this.productItemIds = productItemIds;
		this.shippingAddress = shippingAddress;
		this.billingAddress = billingAddress;
		this.customerName = customerName;
		this.email = email;
		this.phoneNum = phoneNum;
		this.cardNum = cardNum;
		this.datePlaced = datePlaced;
		this.dateShipped = dateShipped;
		this.orderStatus = status;
	}
	
	//Getters and Setters
	//set cOId to be implemented
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int cId) {
		this.customerId = cId;
	}
	public ArrayList<Integer> getProductItemIds() {
		return productItemIds;
	}
	public void setpIIds(ArrayList<Integer> productItemIds) {
		this.productItemIds = productItemIds;
	}
	public String getShippingAddress() {
		return shippingAddress;
	}
	public void setShippingAdress(String shippingAddress) {
		this.shippingAddress = shippingAddress;
	}
	public String getBillingAddress() {
		return billingAddress;
	}
	public void setBillingAddress(String billingAddress) {
		this.billingAddress = billingAddress;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneNum() {
		return phoneNum;
	}
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
	public String getCardNum() {
		return cardNum;
	}
	public void setCardNum(String cardNum) {
		this.cardNum = cardNum;
	}
	public String getDatePlaced() {
		return datePlaced;
	}
	public void setDatePlaced(String datePlaced) {
		this.datePlaced = datePlaced;
	}
	public String getDateShipped() {
		return dateShipped;
	}
	public void setDateShipped(String dateShipped) {
		this.dateShipped = dateShipped;
	}

	public CustomerOrderStatus getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(CustomerOrderStatus orderStatus) {
		this.orderStatus = orderStatus;
	}
	
	
	
	
}
