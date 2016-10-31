package javaEE.initialData;

import java.util.ArrayList;
import java.util.List;

import javaEE.enums.CustomerOrderStatus;
import javaEE.project.CustomerOrder;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;



@Startup
@Singleton 
public class InitialCustomerOrderData {
	private List<CustomerOrder> customerOrders =  new ArrayList<CustomerOrder>();
	
	@PostConstruct
	public void setupData() {
		customerOrders.add(new CustomerOrder(1, new ArrayList<Integer>(1), "This is an address honest gov",
				"This is another address seriously honest gov", "John Smith", "JohnSmiths@Emial.com", 
				"01202558963", "1234567891234567", "20/10/16", "null", CustomerOrderStatus.processing));
	}

	public void addCustomerOrder(CustomerOrder co) {
		customerOrders.add(co);
		
	}

	public List<CustomerOrder> getCustomerOrders() {
		return customerOrders;
	}

	public void setCustomerOrders(List<CustomerOrder> co) {
		this.customerOrders = co;
	}

	public ArrayList<CustomerOrder> getCustomers() {
		// TODO Auto-generated method stub
		return null;
	}

	

	

}

