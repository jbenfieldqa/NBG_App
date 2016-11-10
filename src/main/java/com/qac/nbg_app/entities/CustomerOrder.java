package com.qac.nbg_app.entities;

//Imports
import java.util.*;


import javax.persistence.*;
import javax.validation.constraints.*;

import com.qac.nbg_app.enums.CustomerOrderStatus;

@Entity
@Table(name = "customerorder" )

//Queries
@NamedQueries ({
	@NamedQuery (name= CustomerOrder.FIND_BY_ORDER_ID, query = "SELECT a FROM  CutomerOrder a WHERE a.customerOrderId = :customerOrderId"),
	@NamedQuery (name= CustomerOrder.FIND_BY_DATE_PLACED, query = "SELECT a FROM  CutomerOrder a WHERE a.datePlaced = :datePlaced"),
	@NamedQuery (name= CustomerOrder.FIND_BY_DATE_DISPATCHED, query = "SELECT a FROM  CutomerOrder a WHERE a.dateShipped = :dateShipped"),
	@NamedQuery (name= CustomerOrder.FIND_BY_STATUS, query = "SELECT a FROM  CutomerOrder a WHERE a.status = :status"),	
})

public class CustomerOrder {
	
	//Query Declarations
	public static final String FIND_BY_ORDER_ID = "CustomerOrder.findByCustomerOrder";
	public static final String FIND_BY_STATUS = "CustomerOrder.findByCustomerOrder";	
	public static final String FIND_BY_CUSTOMER_NAME = "CustomerOrder.findByCustomerOrder";
	public static final String FIND_BY_DATE_PLACED = "CustomerOrder.findByCustomerOrder";
	public static final String FIND_BY_DATE_DISPATCHED = "CustomerOrder.findByCustomerOrder";
	
	//Variable Declarations
	@Id
	@Column(name = "customerOrderId")
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int customerOrderId;
	
	@Column(name = "orderStatus", nullable = false)
	@NotNull
	private CustomerOrderStatus orderStatus;
	
	@Column(name = "customerName", nullable = false, length = 225)
	@NotNull
	@Size (min = 2, max = 225)
	private String customerName;
	
	@Column(name = "datePlaced", nullable = false)
	@NotNull
	private String datePlaced;
	
	@Column(name = "dateShipped", nullable = false)
	@NotNull
	private String dateShipped;
	
	@ManyToOne
	@JoinColumn(name = "customerId_fk", nullable = false)
	@NotNull
	private int customerId;
	
	private int billingDetailsId;
	
	private int deliveryAddressId;
	
	
	//Constructor
	public CustomerOrder(int customerId, String customerName, String datePlaced, 
			String dateShipped, CustomerOrderStatus status){
		this.customerId = customerId;
		this.customerName = customerName;
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
	
	public String getCustomerName() {
		return customerName;
	}
	
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
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
