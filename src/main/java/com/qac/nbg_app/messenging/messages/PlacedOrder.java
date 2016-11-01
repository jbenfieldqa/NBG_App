package com.qac.nbg_app.messenging.messages;

import java.io.Serializable;
import java.util.List;

public class PlacedOrder implements Serializable {
	private long orderID;
	private Customer customer;
	private Address deliveryAddress;
	private List<OrderLine> orderLines;

	public PlacedOrder(long orderID, Customer customer, Address deliveryAddress, List<OrderLine> orderLines) {
		this.orderID = orderID;
		this.customer = customer;
		this.deliveryAddress = deliveryAddress;
		this.orderLines = orderLines;
	}

	public long getOrderID() {
		return orderID;
	}

	public Customer getCustomer() {
		return customer;
	}

	public Address getDeliveryAddress() {
		return deliveryAddress;
	}

	public List<OrderLine> getOrderLines() {
		return orderLines;
	}

	public void setOrderID(long orderID) {
		this.orderID = orderID;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public void setDeliveryAddress(Address deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}

	public void setOrderLines(List<OrderLine> orderLines) {
		this.orderLines = orderLines;
	}
}