package offline;

import java.util.*;

import initialData.InitialEmployeeInventoryManagerData;
import managers.EmployeeInventoryManagerManager;
import project.EmployeeInventoryManager;

import javax.inject.Inject;

public abstract class EmployeeInventoryManagerOffline implements EmployeeInventoryManagerManager{

	@Inject
	private InitialEmployeeInventoryManagerData initialData;
	public void persistEmployeeInventoryManager(EmployeeInventoryManager im) {
			initialData.addEmployeeInventoryManager(im);
	}
	
	public void updateInventoryManager(EmployeeInventoryManager im) {
		List<EmployeeInventoryManager> ims = initialData.getInventoryManagers();
		for(int i=0; i<ims.size(); i++) {
			if(ims.get(i).equals(im))ims.set(i, im);
		}
		initialData.setInventoryManagers(ims);
	}

	

}
