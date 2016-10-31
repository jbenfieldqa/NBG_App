package javaEE.initialData;

import java.util.ArrayList;
import java.util.List;
import javaEE.project.EmployeeInventoryManager;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;

@Startup
@Singleton 
public class InitialEmployeeInventoryManagerData {
	private List<EmployeeInventoryManager> inventoryManagers =  new ArrayList<EmployeeInventoryManager>();
	
	@PostConstruct
	public void setupData() {
		inventoryManagers.add(new EmployeeInventoryManager("Big Boss Man", "John", "Smith",
				"JohnSmith", "johnsmithisdabest12345"));
		inventoryManagers.add(new EmployeeInventoryManager("Big Boss Woman", "Jane", "Smith",
				"JaneSmith", "janesmithisdabest12345"));
		inventoryManagers.add(new EmployeeInventoryManager("Small Boss Person", "Alex", "Smith",
				"ASmith", "alexsmithisdabest12345"));
	}

	public void addEmployeeInventoryManager(EmployeeInventoryManager im) {
		inventoryManagers.add(im);
		
	}

	public List<EmployeeInventoryManager> getInventoryManagers() {
		return inventoryManagers;
	}

	public void setInventoryManagers(
			List<EmployeeInventoryManager> inventoryManagers) {
		this.inventoryManagers = inventoryManagers;
	}
	
}
