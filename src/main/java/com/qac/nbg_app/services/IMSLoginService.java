package com.qac.nbg_app.services;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.qac.nbg_app.entities.Employee;
import com.qac.nbg_app.managers.EmployeeManager;

@Stateless
public class IMSLoginService {
	@Inject 
	EmployeeManager empManager;
	
	public boolean validateDetails(String userName, String password) {
		Employee employee = empManager.getUserByUserName(userName);
		if(employee != null && employee.getPassword().equals(password))
			return true;
		return false;
	}
	
	public String getUserID(String user) {
		return empManager.getUserName(user.toLowerCase());
	}
	

}