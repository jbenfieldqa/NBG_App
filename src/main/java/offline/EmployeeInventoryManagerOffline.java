package offline;

import java.util.*;


import managers.EmployeeInventoryManagerManager;


import javax.inject.Inject;

import com.qac.nbg_app.entities.EmployeeInventoryManager;
import com.qac.nbg_app.util.InitialData;

public abstract class EmployeeInventoryManagerOffline implements EmployeeInventoryManagerManager{

	@Inject
	private InitialData initialData;
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
