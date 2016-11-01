package managers;

import java.util.*;
import project.CustomerOrder;

public interface CustomerOrderManager {
	
	public void persistCustomerOrder (CustomerOrder o);
	
	public CustomerOrder findbyName (String customerName);
	public ArrayList<CustomerOrder> getCustomerName();
	
	public void cancelOrder(CustomerOrder o);
	public void updateOrder(CustomerOrder o);	

}
