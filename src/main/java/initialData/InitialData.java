package main.java.initialData;

import java.util.*;


import main.java.enums.CustomerOrderStatus;
import main.java.enums.Status;
import main.java.project.*;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;


@Startup
@Singleton 
public class InitialData {
	private List<Basket> baskets =  new ArrayList<Basket>();
	private List<Customer> customers = new ArrayList<Customer>();
	private List<CustomerOrder> customerOrders =  new ArrayList<CustomerOrder>();
	private List<EmployeeInventoryManager> inventoryManagers =  new ArrayList<EmployeeInventoryManager>();
	private List<ProductGroup> productGroups =  new ArrayList<ProductGroup>();
	private List<ProductItem> productItems =  new ArrayList<ProductItem>();
	private List<PurchaseOrder> purchaseOrders = new ArrayList<PurchaseOrder>();
	private List<Stock> stockList =  new ArrayList<Stock>();
	private List<Wishlist> wishlists =  new ArrayList<Wishlist>();
	private List<Supplier> suppliers =  new ArrayList<Supplier>();
	
	@PostConstruct
	public void setupData() {
		setupBasketData();
		setupCustomerdata();
		setupCustomerOrderData();
		setupInventoryManagerData();
		setupProductGroupData();
		setupProductGroupData();
		setupPurchaseOrderData();
		setupStockData();
		setupSupplierData();
		setupWishlistData();
	}

	private void setupBasketData() {
		baskets.add(new Basket(1, new ArrayList<Integer>(1), "yesterday"));
		baskets.add(new Basket(2, new ArrayList<Integer>(2), "yesterday"));
		baskets.add(new Basket(3, new ArrayList<Integer>(3), "yesterday"));
	}
	
	private void setupCustomerdata() {
		customers.add(new Customer("John", "Smith", "IMissSelasi@Devastated.com",
				"07562942456", "4567188924056659"));
		customers.add(new Customer("Selasi", "Gbormittah", "SelasiIsAwesome@GBBIsAFix.com",
				"07182942456", "4567145894055421"));
		customers.add(new Customer("Rav", "Bansal", "RavishingRav99@TastyFlavours.co.uk",
				"07752942456", "4567178954050231"));
	}

	private void setupCustomerOrderData() {
		customerOrders.add(new CustomerOrder(1, new ArrayList<Integer>(1), "This is an address honest gov",
				"This is another address seriously honest gov", "John Smith", "JohnSmiths@Emial.com", 
				"01202558963", "1234567891234567", "20/10/16", "null", CustomerOrderStatus.processing));
	}

	private void setupInventoryManagerData() {
		inventoryManagers.add(new EmployeeInventoryManager("Big Boss Man", "John", "Smith",
				"JohnSmith", "johnsmithisdabest12345"));
		inventoryManagers.add(new EmployeeInventoryManager("Big Boss Woman", "Jane", "Smith",
				"JaneSmith", "janesmithisdabest12345"));
		inventoryManagers.add(new EmployeeInventoryManager("Small Boss Person", "Alex", "Smith",
				"ASmith", "alexsmithisdabest12345"));
	}
	
	private void setupProductGroupData() {
		productGroups.add(new ProductGroup(1, "Red Gnome", 1, 13000, 25, 45, 5, 50));
		productGroups.add(new ProductGroup(2, "Blue Gnome", 2, 10000, 250, 55, 5, 50));
		productGroups.add(new ProductGroup(3, "Green Gnome", 3, 8000, 2500, 35, 5, 50));
	}

	private void setupPurchaseOrderData() {
		purchaseOrders.add(new PurchaseOrder(0, 1, 20, 20, 1, 12, 14));
		purchaseOrders.add(new PurchaseOrder(1,2, 20, 20, 2, 13, 14));
		purchaseOrders.add(new PurchaseOrder(2,3, 20, 20, 3, 14, 16));
	}
	
	private void setupStockData() {
		stockList.add(new Stock(1, 50));
		stockList.add(new Stock(2, 25));
		stockList.add(new Stock(3, 5));
	}
	
	private void setupSupplierData() {
		suppliers.add(new Supplier("Gnome Supplier Suppliers"));
		suppliers.add(new Supplier("The Gnmoely Way Is Essex"));
		suppliers.add(new Supplier("The One and Gnomely"));
	}

	private void setupWishlistData() {
		wishlists.add(new Wishlist(1,1));
		wishlists.add(new Wishlist(2,2));
		wishlists.add(new Wishlist(3,3));
	}
}
