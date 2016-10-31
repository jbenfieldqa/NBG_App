package javaEE.initialData;

import java.util.ArrayList;
import java.util.List;

import javaEE.project.Supplier;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;

@Startup
@Singleton
public class InitialSupplierData {
	private List<Supplier> suppliers =  new ArrayList<Supplier>();
	
	@PostConstruct
	private void setupData() {
		suppliers.add(new Supplier("Gnome Supplier Suppliers"));
		suppliers.add(new Supplier("The Gnmoely Way Is Essex"));
		suppliers.add(new Supplier("The One and Gnomely"));
	}
	
	public void addSupplier(Supplier s){
		suppliers.add(s);
	}
	
	public List<Supplier> getSuppliers(){
		return suppliers;
	}
	
	public void setSuppliers (List<Supplier> ss){
		suppliers = ss;
	}
}
