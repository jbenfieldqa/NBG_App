package managers;

import java.util.*;
import project.Supplier;

public interface SupplierManager {
	public void persistSupplier (Supplier s);
	public List<Supplier> listSuppliers();
	
	public Supplier findByName (String name);
	public ArrayList<Supplier> getSuppliers();
	
	public void updateSupplier (Supplier s);
	
	public void removeSupplier (Supplier s);
}
