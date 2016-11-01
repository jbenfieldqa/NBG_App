package managers;

import java.util.*;

import com.qac.nbg_app.entities.EmployeeWarehouseWorker;


public interface EmployeeWarehouseWorkerManager {
	public void persistWarehouseWorker (EmployeeWarehouseWorker e);
	public void persistWarehouseWorkers (List<EmployeeWarehouseWorker> e);
	
	public EmployeeWarehouseWorker findByName(String name);
	public ArrayList<EmployeeWarehouseWorker> getWarehouseWorkers();
	
	public void updateWarehouseWorker (EmployeeWarehouseWorker e);
	
	public void removeWarehouseWorker (EmployeeWarehouseWorker e);
}
