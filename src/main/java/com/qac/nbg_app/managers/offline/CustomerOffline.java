package com.qac.nbg_app.managers.offline;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;

import javax.enterprise.inject.Alternative;
import javax.enterprise.inject.Default;
import javax.faces.bean.SessionScoped;

import javax.inject.Inject;

import com.qac.nbg_app.entities.Customer;
import com.qac.nbg_app.managers.CustomerManager;
import com.qac.nbg_app.util.InitialData;


@Alternative
@Default
@Stateless
@SessionScoped
public class CustomerOffline implements CustomerManager {
	

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

	@Override
	public Customer getUserByEmail(String email) {
		List<Customer> us = initialData.getCustomers();
		for(int i=0; i<us.size(); i++){
			System.out.println(us.get(i).getEmail());
			if(us.get(i).getEmail().equals(email)){
				return us.get(i); 
			}
		}
		return null; 
	}

}
