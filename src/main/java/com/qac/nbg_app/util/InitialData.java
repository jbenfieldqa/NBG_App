package com.qac.nbg_app.util;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;

import com.qac.nbg_app.entities.*;

import com.qac.nbg_app.enums.CustomerOrderStatus;


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
	
	private List<Product> products = new ArrayList<Product>();
	
	@PostConstruct
	public void setupData() {
		setupBasketData();
		setupCustomerdata();
		setupCustomerOrderData();
		setupInventoryManagerData();
		setupProductGroupData();
		setupProductItemData();
		setupPurchaseOrderData();
		setupStockData();
		setupSupplierData();
		setupWishlistData();
		
		setupProductData();
	}

	//------------------------------------ Basket Data -------------------------------------------------
	private void setupBasketData() {
		baskets.add(new Basket(1, new ArrayList<Integer>(1), "yesterday"));
		baskets.add(new Basket(2, new ArrayList<Integer>(2), "yesterday"));
		baskets.add(new Basket(3, new ArrayList<Integer>(3), "yesterday"));
	}
	
	public void addBasket(Basket b) {
		baskets.add(b);		
	}

	public List<Basket> getBaskets() {
		return baskets;
	}

	public void setBaskets(List<Basket> b) {
		this.baskets = b;
	}
	
	//------------------------------------ Customer Data -------------------------------------------------
	private void setupCustomerdata() {
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

	//------------------------------------ Customer Order Data -------------------------------------------------
	private void setupCustomerOrderData() {
		customerOrders.add(new CustomerOrder(1, new ArrayList<Integer>(1), "This is an address honest gov",
				"This is another address seriously honest gov", "John Smith", "JohnSmiths@Emial.com", 
				"01202558963", "1234567891234567", "20/10/16", "null", CustomerOrderStatus.processing));
	}
	
	public void addCustomerOrder(CustomerOrder co) {
		customerOrders.add(co);
		
	}

	public List<CustomerOrder> getCustomerOrders() {
		return customerOrders;
	}

	public void setCustomerOrders(List<CustomerOrder> co) {
		this.customerOrders = co;
	}

	//------------------------------------ Inventory Manager Data -------------------------------------------------
	private void setupInventoryManagerData() {
		inventoryManagers.add(new EmployeeInventoryManager("Big Boss Man", "John", "Smith",
				"JohnSmith", "johnsmithisdabest12345"));
		inventoryManagers.add(new EmployeeInventoryManager("Big Boss Woman", "Jane", "Smith",
				"JaneSmith", "janesmithisdabest12345"));
		inventoryManagers.add(new EmployeeInventoryManager("Small Boss Person", "Alex", "Smith",
				"ASmith", "alexsmithisdabest12345"));
	}
	
	public void addEmployeeInventoryManager(EmployeeInventoryManager im) {
		inventoryManagers.add(im);
		
	}

	public List<EmployeeInventoryManager> getInventoryManagers() {
		return inventoryManagers;
	}

	public void setInventoryManagers(
			List<EmployeeInventoryManager> inventoryManagers) {
		this.inventoryManagers = inventoryManagers;
	}
	
	//------------------------------------ Product Group Data -------------------------------------------------
	private void setupProductGroupData() {
		productGroups.add(new ProductGroup(1, "Red Gnome", 1, 13000, 25, 45, 5, 50));
		productGroups.add(new ProductGroup(2, "Blue Gnome", 2, 10000, 250, 55, 5, 50));
		productGroups.add(new ProductGroup(3, "Green Gnome", 3, 8000, 2500, 35, 5, 50));
	}
	
	public void addProductGroup(ProductGroup a) {
		productGroups.add(a);
	}
	
	public void removeProductGroup(ProductGroup a) {
		productGroups.remove(a);
	}

	public List<ProductGroup> getProductGroups() {
		return productGroups;
	}

	public void setProductGroups(List<ProductGroup> productGroups) {
		this.productGroups = productGroups;
	}
	
	//------------------------------------ Product Item Data -------------------------------------------------
	private void setupProductItemData() {
		// TODO Auto-generated method stub
		
	}
	
	public List<ProductItem> getProductItems() {
		return productItems;
	}

	public void setProductItem(List<ProductItem> productItems) {
		this.productItems = productItems;
	}
	public void addProductItem(ProductItem a) {
		productItems.add(a);
	}
	
	public void removeProductItem(ProductItem a) {
		productItems.remove(a);
	}

	//------------------------------------ Purchase Order Data -------------------------------------------------
	private void setupPurchaseOrderData() {
		purchaseOrders.add(new PurchaseOrder(0, 1, 20, 20, 1, 12, 14));
		purchaseOrders.add(new PurchaseOrder(1,2, 20, 20, 2, 13, 14));
		purchaseOrders.add(new PurchaseOrder(2,3, 20, 20, 3, 14, 16));
	}
	
	public void addPurchaseOrder(PurchaseOrder a)
	{
		purchaseOrders.add(a);
	}
	public void removePurchaseOrder(PurchaseOrder a)
	{
		purchaseOrders.remove(a);
	}
	public List<PurchaseOrder> getPurchaseOrders() {
		return purchaseOrders;
	}
	public void setPurchaseOrders(List<PurchaseOrder> purchaseOrders) {
		this.purchaseOrders = purchaseOrders;
	}
	
	//------------------------------------ Stock Data -------------------------------------------------
	private void setupStockData() {
		stockList.add(new Stock(1, 50));
		stockList.add(new Stock(2, 25));
		stockList.add(new Stock(3, 5));
	}
	
	public void addStock(Stock a)
	{
		stockList.add(a);
	}
	public void removeStock(Stock a)
	{
		stockList.remove(a);
	}
	public List<Stock> getStock()
	{
		return stockList;
	}
	public void setStock(List<Stock> stock)
	{
		this.stockList = stock;
	}
	
	//------------------------------------ Supplier Data -------------------------------------------------
	private void setupSupplierData() {
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

	//------------------------------------ Wishlist Data -------------------------------------------------
	private void setupWishlistData() {
		wishlists.add(new Wishlist(1,1));
		wishlists.add(new Wishlist(2,2));
		wishlists.add(new Wishlist(3,3));
	}
	
	public void addWishlist(Wishlist w){
		wishlists.add(w);
	}
	
	public List<Wishlist> getWishlists(){
		return wishlists;
	}
	
	public void setWishlists (List<Wishlist> ws){
		wishlists = ws;
	}

	//------------------------------------ Product Data -------------------------------------------------
	private void setupProductData() {
		products.add(new Product("Gnome1", "This is gnome 1, it's great"));	
		products.add(new Product("Gnome2", "This is gnome 2, it's great"));
		products.add(new Product("Gnome3", "This is gnome 3, it's great"));
		products.add(new Product("Gnome4", "This is gnome 4, it's great"));
		products.add(new Product("Gnome5", "This is gnome 5, it's great"));
		products.add(new Product("Gnome6", "This is gnome 6, it's great"));
		products.add(new Product("Gnome7", "This is gnome 7, it's great"));
		products.add(new Product("Gnome8", "This is gnome 8, it's great"));
		products.add(new Product("Gnome9", "This is gnome 9, it's great"));
		products.add(new Product("Gnome10", "This is gnome 10, it's great"));
		products.add(new Product("Gnome11", "This is gnome 11, it's great"));
		products.add(new Product("Gnome12", "This is gnome 12, it's naff"));
		products.add(new Product("Gnome1", "This is gnome 1, it's great"));	
		products.add(new Product("Gnome2", "This is gnome 2, it's great"));
		products.add(new Product("Gnome3", "This is gnome 3, it's great"));
		products.add(new Product("Gnome4", "This is gnome 4, it's great"));
		products.add(new Product("Gnome5", "This is gnome 5, it's great"));
		products.add(new Product("Gnome6", "This is gnome 6, it's great"));
		products.add(new Product("Gnome7", "This is gnome 7, it's great"));
		products.add(new Product("Gnome8", "This is gnome 8, it's great"));
		products.add(new Product("Gnome9", "This is gnome 9, it's great"));
		products.add(new Product("Gnome10", "This is gnome 10, it's great"));
		products.add(new Product("Gnome1", "This is gnome 1, it's great"));	
		products.add(new Product("Gnome2", "This is gnome 2, it's great"));
		products.add(new Product("Gnome3", "This is gnome 3, it's great"));
		products.add(new Product("Gnome4", "This is gnome 4, it's great"));
		products.add(new Product("Gnome5", "This is gnome 5, it's great"));
		products.add(new Product("Gnome6", "This is gnome 6, it's great"));
		products.add(new Product("Gnome7", "This is gnome 7, it's great"));
		products.add(new Product("Gnome8", "This is gnome 8, it's great"));
		products.add(new Product("Gnome9", "This is gnome 9, it's great"));
		products.add(new Product("Gnome10", "This is gnome 10, it's great"));
		products.add(new Product("Gnome1", "This is gnome 1, it's great"));	
		products.add(new Product("Gnome2", "This is gnome 2, it's great"));
		products.add(new Product("Gnome3", "This is gnome 3, it's great"));
		products.add(new Product("Gnome4", "This is gnome 4, it's great"));
		products.add(new Product("Gnome5", "This is gnome 5, it's great"));
		products.add(new Product("Gnome6", "This is gnome 6, it's great"));
		products.add(new Product("Gnome7", "This is gnome 7, it's great"));
		products.add(new Product("Gnome8", "This is gnome 8, it's great"));
		products.add(new Product("Gnome9", "This is gnome 9, it's great"));
		products.add(new Product("Gnome10", "This is gnome 10, it's great"));
	}
	
	public List<Product> getProducts() {
		return products;
	}
	
	
}
