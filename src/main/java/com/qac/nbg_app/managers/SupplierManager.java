package com.qac.nbg_app.managers;

import java.util.*;

import com.qac.nbg_app.entities.Supplier;


public interface SupplierManager {
	public void persistSupplier (Supplier s);
	
	public Supplier findByName (String name);
	
	public ArrayList<Supplier> getSuppliers();
	
	public void updateSupplier (Supplier s);
	
	public void removeSupplier (Supplier s);
}
