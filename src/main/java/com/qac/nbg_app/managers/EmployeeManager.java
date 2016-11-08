package com.qac.nbg_app.managers;

import com.qac.nbg_app.entities.Employee;

public interface EmployeeManager {
	public void persistEmployee (Employee a);
	
	public void updateEmployee(Employee im);

	void updateInventoryManager(Employee im);

	public String getUserName(String lowerCase);

	Employee getUserByUserName(String userName);
	
	
	

}
