package com.qac.nbg_app.managers.offline;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import com.qac.nbg_app.entities.Supplier;
import com.qac.nbg_app.managers.SupplierManager;
import com.qac.nbg_app.util.InitialData;

public class SupplierOffline implements SupplierManager {

	@Inject
	private InitialData initialData;
	public void persistSupplier(Supplier s) {
		initialData.addSupplier(s);
	}

	public  List<Supplier>  listSuppliers() {
		return initialData.getSuppliers();
		
	}

	public Supplier findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<Supplier> getSuppliers() {
		// TODO Auto-generated method stub
		return null;
	}

	public void updateSupplier(Supplier s) {
		List<Supplier> ss = initialData.getSuppliers();
		for(int i=0; i<ss.size(); i++) {
			if(ss.get(i).equals(s))ss.set(i, s);
		}
		initialData.setSuppliers(ss);
		
	}

	public void removeSupplier(Supplier s) {
		List<Supplier> ss = initialData.getSuppliers();
		for(int i=0; i<ss.size(); i++) {
			if(ss.get(i).equals(s))ss.remove(i);
		}
		initialData.setSuppliers(ss);
		
	}

}
