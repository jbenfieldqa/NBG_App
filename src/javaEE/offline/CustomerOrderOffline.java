package javaEE.offline;

import java.util.ArrayList;
import java.util.List;

import javaEE.initialData.InitialCustomerOrderData;
import javaEE.managers.CustomerOrderManager;
import javaEE.project.CustomerOrder;

import javax.inject.Inject;

public class CustomerOrderOffline implements CustomerOrderManager{

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
