package main.java.initialData;
import java.util.ArrayList;
import java.util.List;

import main.java.project.Customer;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;

@Startup
@Singleton 
public class InitialCustomerData {
	private List<Customer> customers = new ArrayList<Customer>();
	
	@PostConstruct
	public void setupData() {
		customers.add(new Customer("John", "Smith", "IMissSelasi@Devastated.com",
				"07562942456", "4567188924056659"));
		customers.add(new Customer("Selasi", "Gbormittah", "SelasiIsAwesome@GBBIsAFix.com",
				"07182942456", "4567145894055421"));
		customers.add(new Customer("Rav", "Bansal", "RavishingRav99@TastyFlavours.co.uk",
				"07752942456", "4567178954050231"));
	}
	
	public void addCustomer(Customer c){
		customers.add(c);
	}
	
	public List<Customer> getCustomers(){
		return customers;
	}
	
	public void setCustomers (List<Customer> cs){
		customers = cs;
	}
}
