package javaEE.managers;

import java.util.*;
import javaEE.project.Supplier;

public interface SupplierManager {
	public void persistSupplier (Supplier s);
	public List<Supplier> listSuppliers();
	
	public Supplier findByName (String name);
	public ArrayList<Supplier> getSuppliers();
	
	public void updateSupplier (Supplier s);
	
	public void removeSupplier (Supplier s);
}
