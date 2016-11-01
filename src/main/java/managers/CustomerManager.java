package managers;

import java.util.*;

import com.qac.nbg_app.entities.Customer;


public interface CustomerManager {
	public void persistCustomer (Customer c);
	public void persistCustomers (List<Customer> c);
	
	public Customer findByName (String name);
	public ArrayList<Customer> getCustomers();
	
	public void updateCustomer (Customer c);
	
	public void removeCustomer (Customer c);

}