package main.java.offline;

import java.util.ArrayList;
import java.util.List;

import main.java.initialData.InitialCustomerOrderData;
import main.java.managers.CustomerOrderManager;
import main.java.project.CustomerOrder;

import javax.inject.Inject;

public abstract class CustomerOrderOffline implements CustomerOrderManager{

	@Inject
	private InitialCustomerOrderData initialData;
	public void persistCustomerOrder(CustomerOrder o) {
		initialData.addCustomerOrder(o);
	}

	public CustomerOrder findbyName(String customerName) {
		return null;
	}

	public ArrayList<CustomerOrder> getCustomerName() {
		return initialData.getCustomers();
	}

	public void cancelOrder(CustomerOrder o) {
		List<CustomerOrder> cos = initialData.getCustomerOrders();
		for(int i=0; i<cos.size(); i++) {
			if(cos.get(i).equals(o))cos.remove(i);
		}
		initialData.setCustomerOrders(cos);
		
	}

	public void updateOrder(CustomerOrder o) {
		List<CustomerOrder> cos = initialData.getCustomerOrders();
		for(int i=0; i<cos.size(); i++) {
			if(cos.get(i).equals(o))cos.set(i, o);
		}
		initialData.setCustomerOrders(cos);
		
	}

}
