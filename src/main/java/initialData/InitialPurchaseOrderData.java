package main.java.initialData;

import java.util.ArrayList;
import java.util.List;

import main.java.project.PurchaseOrder;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;

@Startup
@Singleton 
public class InitialPurchaseOrderData {
	private List<PurchaseOrder> purchaseOrders = new ArrayList<PurchaseOrder>();
	
	@PostConstruct
	public void setupData(){
		purchaseOrders.add(new PurchaseOrder(0,1, 20, 20, 1, 12, 14));
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
}
