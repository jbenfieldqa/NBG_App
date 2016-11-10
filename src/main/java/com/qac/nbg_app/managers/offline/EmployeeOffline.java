package com.qac.nbg_app.managers.offline;

import java.util.*;

import javax.ejb.Stateless;
import javax.enterprise.inject.Default;
import javax.inject.Inject;

import com.qac.nbg_app.entities.Employee;
import com.qac.nbg_app.managers.EmployeeManager;
import com.qac.nbg_app.util.InitialData;


@Stateless
@Default
public class EmployeeOffline implements EmployeeManager{

	@Inject
	private InitialData initialData;
	public void persistEmployeeInventoryManager(Employee im) {
			initialData.addEmployeeInventoryManager(im);
	}
	@Override
	public void updateInventoryManager(Employee im) {
		List<Employee> ims = initialData.getEmployees();
		for(int i=0; i<ims.size(); i++) {
			if(ims.get(i).equals(im))ims.set(i, im);
		}
		initialData.setInventoryManagers(ims);
	}

	@Override
	public void persistEmployee(Employee a) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateEmployee(Employee im) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Employee getUserByUserName(String userName) {
		List<Employee> us = initialData.getEmployees();
		for(int i=0; i<us.size(); i++){
			System.out.println(us.get(i).getUserName());
			if(us.get(i).getUserName().equals(userName)){
				return us.get(i); 
			}
		}
		return null; 
	}

	@Override
	public String getUserName(String lowerCase) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
