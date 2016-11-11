package com.qac.nbg_app.entities;


public class OrderLine {
	
	private int customerOrderID;

	private int productId;
	
	private int quantity;
	
	private double salePrice;
	
	public OrderLine(int customerOrderId, int productId, int quantity, double salesPrice){
		this.customerOrderID = customerOrderId;
		this.productId = productId;
		this.quantity = quantity;
		this.salePrice = salesPrice;
	}
	
	public int getCustomerOrderID() {
		return customerOrderID;
	}

	public int getProductId() {
		return productId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getSalePrice() {
		return salePrice;
	}

	public void setSalePrice(double salePrice) {
		this.salePrice = salePrice;
	}
	
}
