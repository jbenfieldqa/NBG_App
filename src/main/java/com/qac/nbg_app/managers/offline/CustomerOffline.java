package com.qac.nbg_app.managers.offline;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.enterprise.inject.Default;
import javax.inject.Inject;

import com.qac.nbg_app.entities.Customer;
import com.qac.nbg_app.managers.CustomerManager;
import com.qac.nbg_app.util.InitialData;
import javax.enterprise.inject.Alternative;

@Alternative
@Default
@Stateless
public abstract class CustomerOffline implements CustomerManager{
	
	@Inject
	private InitialData initialData;
	
	@Override
	public void persistCustomer(Customer c) {
		initialData.addCustomer(c);
	}
	
	@Override
	public List<Customer> listCustomers() {
		return initialData.getCustomers();
	}

	@Override
	public Customer findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public ArrayList<Customer> getCustomers() {
		return (ArrayList<Customer>) initialData.getCustomers();
	}

	@Override
	public void updateCustomer(Customer c) {
		List<Customer> cs = initialData.getCustomers();
		for(int i=0; i<cs.size(); i++) {
			if(cs.get(i).equals(c))cs.set(i, c);
		}
		initialData.setCustomers(cs);		
	}

	@Override
	public void removeCustomer(Customer c) {
		List<Customer> cs = initialData.getCustomers();
		for(int i=0; i<cs.size(); i++) {
			if(cs.get(i).equals(c))cs.remove(i);
		}
		initialData.setCustomers(cs);
		
	}

	@Override
	public void persistCustomers(List<Customer> c) {
		// TODO Auto-generated method stub		
	}
	
	@Override
	public Customer findByUserPass(String lowerCase, String pass) {
		return null;
	}
	
	@Override
	public String getUserID(String lowerCase) {
		return null;
	}

}
