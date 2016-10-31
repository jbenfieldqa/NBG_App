package javaEE.offline;

import java.util.ArrayList;
import java.util.List;

import javaEE.initialData.*;
import javaEE.managers.CustomerManager;
import javaEE.project.Customer;

import javax.inject.Inject;

public class CustomerOffline implements CustomerManager{
	@Inject
	private InitialCustomerData initialData;
	
	public void persistCustomer(Customer c) {
		initialData.addCustomer(c);
	}

	public List<Customer> listCustomers() {
		return initialData.getCustomers();
	}

	public Customer findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public ArrayList<Customer> getCustomers() {
		return (ArrayList<Customer>) initialData.getCustomers();
	}

	public void updateCustomer(Customer c) {
		List<Customer> cs = initialData.getCustomers();
		for(int i=0; i<cs.size(); i++) {
			if(cs.get(i).equals(c))cs.set(i, c);
		}
		initialData.setCustomers(cs);
		
	}

	public void removeCustomer(Customer c) {
		List<Customer> cs = initialData.getCustomers();
		for(int i=0; i<cs.size(); i++) {
			if(cs.get(i).equals(c))cs.remove(i);
		}
		initialData.setCustomers(cs);
		
	}

	public void persistCustomers(List<Customer> c) {
		// TODO Auto-generated method stub
		
	}

}
