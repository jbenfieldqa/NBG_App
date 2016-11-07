package com.qac.nbg_app.managers.offline;

import java.util.List;

import javax.ejb.Stateless;
import javax.enterprise.inject.Default;
import javax.inject.Inject;

import com.qac.nbg_app.entities.Customer;
import com.qac.nbg_app.entities.CustomerOrder;
import com.qac.nbg_app.managers.CustomerOrderManager;
import com.qac.nbg_app.util.InitialData;



@Stateless
@Default
public abstract class CustomerOrderOffline implements CustomerOrderManager{

	@Inject
	private InitialData initialData;
	public void persistCustomerOrder(CustomerOrder o) {
		initialData.addCustomerOrder(o);
	}

	public CustomerOrder findbyName(String customerName) {
		return null;
	}

	public List<Customer> getCustomerName() {
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
