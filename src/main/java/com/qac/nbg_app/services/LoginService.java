package com.qac.nbg_app.services;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.qac.nbg_app.entities.Customer;
import com.qac.nbg_app.managers.CustomerManager;

@Stateless
public class LoginService {
	@Inject 
	CustomerManager custManager;
	
	public boolean validateDetails(String email, String pass) {
		Customer customer = custManager.findByUserPass(email.toLowerCase(), pass);
		if(customer != null)
			return true;
		return false;
	}
	
	public String getUserID(String email) {
		return custManager.getUserID(email.toLowerCase());
	}
	

}
