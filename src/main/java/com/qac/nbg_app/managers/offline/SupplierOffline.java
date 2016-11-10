package com.qac.nbg_app.managers.offline;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.enterprise.inject.Default;
import javax.inject.Inject;

import com.qac.nbg_app.entities.Supplier;
import com.qac.nbg_app.managers.SupplierManager;
import com.qac.nbg_app.util.InitialData;


@Stateless
@Default
public class SupplierOffline implements SupplierManager {

	@Inject
	private InitialData initialData;
	public void persistSupplier(Supplier s) {
		initialData.addSupplier(s);
	}

	public Supplier findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<Supplier> getSuppliers() {
		return initialData.getSuppliers();
	}

	public void updateSupplier(Supplier s) {
		ArrayList<Supplier> ss = initialData.getSuppliers();
		for(int i=0; i<ss.size(); i++) {
			if(ss.get(i).equals(s))ss.set(i, s);
		}
		initialData.setSuppliers(ss);
		
	}

	public void removeSupplier(Supplier s) {
		ArrayList<Supplier> ss = initialData.getSuppliers();
		for(int i=0; i<ss.size(); i++) {
			if(ss.get(i).equals(s))ss.remove(i);
		}
		initialData.setSuppliers(ss);
		
	}

}
