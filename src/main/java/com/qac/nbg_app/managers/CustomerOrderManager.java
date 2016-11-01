package com.qac.nbg_app.managers;

import java.util.*;

import com.qac.nbg_app.entities.Customer;
import com.qac.nbg_app.entities.CustomerOrder;


public interface CustomerOrderManager {
	
	public void persistCustomerOrder (CustomerOrder o);
	
	public CustomerOrder findbyName (String customerName);
	public List<Customer> getCustomerName();
	
	public void cancelOrder(CustomerOrder o);
	public void updateOrder(CustomerOrder o);	

}
