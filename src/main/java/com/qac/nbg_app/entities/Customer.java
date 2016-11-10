package com.qac.nbg_app.entities;

import java.util.ArrayList;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "customer")

//Queries
@NamedQueries ({
	@NamedQuery (name= Customer.FIND_BY_CUSTOMER_ID, query = "SELECT a FROM  Cutomer a WHERE a.customerId = :customerId"),
	@NamedQuery (name= Customer.FIND_BY_FIRST_NAME, query = "SELECT a FROM  Cutomer a WHERE a.firstName = :firstName"),
	@NamedQuery (name= Customer.FIND_BY_LAST_NAME, query = "SELECT a FROM  Cutomer a WHERE a.lastName = :lastName"),
	@NamedQuery (name= Customer.FIND_BY_EMAIL, query = "SELECT a FROM  Cutomer a WHERE a.email = :email"),
	@NamedQuery (name= Customer.FIND_BY_PHONE_NUMBER, query = "SELECT a FROM  Cutomer a WHERE a.phoneNum = :phoneNum"),
	@NamedQuery (name= Customer.FIND_BY_CARD_NUMBER, query = "SELECT a FROM  Cutomer a WHERE a.cardNum = :cardNum"),
		
})

public class Customer {
	
	//Query Declarations
		public static final String FIND_BY_CUSTOMER_ID = "Customer.findByCustomer";
		public static final String FIND_BY_FIRST_NAME = "Customer.findByCustomer";
		public static final String FIND_BY_LAST_NAME = "Customer.findByCustomer";
		public static final String FIND_BY_EMAIL = "Customer.findByCustomer";
		public static final String FIND_BY_PHONE_NUMBER = "Customer.findByCustomer";
		public static final String FIND_BY_CARD_NUMBER = "Customer.findByCustomer";
	
	@Id
	@Column(name="customerId")
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int customerId;
	
	@Column(name = "firstName", nullable = false, length = 225)
	@NotNull
	@Size (min = 2, max = 225)
	private String firstName;
	
	@Column(name = "lastName", nullable = false, length = 225)
	@NotNull
	@Size (min = 2, max = 225)
	private String lastName;
	
	@Column(name = "email", nullable = false, length = 225)
	@NotNull
	@Size (min = 2, max = 225)
	private String email;
	
	@Column(name="pasword", nullable = false, length = 225)
	@NotNull
	@Size (min = 9, max = 225)
	private String password;
	
	@Column(name = "phoneNum", nullable = false, length = 225)
	@NotNull
	@Size (min = 2, max = 225)
	private String phoneNum;
	
	@Column(name = "cardNum", nullable = false, length = 225)
	@NotNull
	@Size (min = 2, max = 225)
	private String cardNum;
	
	@OneToOne
	@JoinColumn(name = "wishlistId", nullable = false)
	@NotNull
	private int wishlistId;
	
	@OneToOne
	@JoinColumn(name = "basketId", nullable = false)
	@NotNull
	private int basketId;
	
	@OneToMany
	@JoinColumn(name = "previousOrdersIds", nullable = false)
	@NotNull
	private ArrayList<Integer> previousOrdersIds;
	
 	public Customer(String firstName, String lastName, String email, String password, String phoneNum, String cardNum) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.phoneNum = phoneNum;
		this.cardNum = cardNum;
		this.wishlistId = 0;
		this.basketId = 0;
		this.previousOrdersIds = new ArrayList<Integer>();
	}

	
 	public int getCustomerId() {
		return customerId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
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
	public int getWishlistId() {
		return wishlistId;
	}
	public void setWishlistId(int wishlistId) {
		this.wishlistId = wishlistId;
	}
	public int getBasketId() {
		return basketId;
	}
	public void setBasketId(int basketId) {
		this.basketId = basketId;
	}

	public ArrayList<Integer> getPreviousOrdersIds() {
		return previousOrdersIds;
	}
	public void addPreviousOrdersIds(int orderId){
		this.previousOrdersIds.add(orderId);
	}
	public void removePreviousOrderId(int orderId){
		this.previousOrdersIds.remove(orderId);
	}

	
}
