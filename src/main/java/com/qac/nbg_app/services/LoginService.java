package com.qac.nbg_app.services;

import javax.ejb.Stateless;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;

import com.qac.nbg_app.entities.Customer;
import com.qac.nbg_app.managers.CustomerManager;

@Stateless
@SessionScoped
public class LoginService {
	@Inject 
	CustomerManager custManager;
	
	public boolean validateDetails(String email, String password) {
		Customer customer = custManager.getUserByEmail(email);
		if(customer != null && customer.getPassword().equals(password))
			return true;
		return false;
	}
	
	public String getUserID(String user) {
		return custManager.getUserID(user.toLowerCase());
	}
	

}
