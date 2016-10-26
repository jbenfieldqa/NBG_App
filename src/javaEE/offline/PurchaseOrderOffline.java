package javaEE.offline;


import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import javaEE.initialData.InitialPurchaseOrderData;
import javaEE.managers.PurchaseOrderManager;
import javaEE.project.PurchaseOrder;
public class PurchaseOrderOffline implements PurchaseOrderManager{
	
	@Inject
	private InitialPurchaseOrderData initialData;

	public void addPurchaseOrder(PurchaseOrder a)
	{
		initialData.addPurchaseOrder(a);
	}
	public void updatePurchaseOrder(PurchaseOrder a)
	{
		List<PurchaseOrder> as = initialData.getPurchaseOrders();
		for(int i= 0; i< as.size(); i++)
		{
			if(as.get(i).equals(a))
			{
				as.set(i, a);
			}
		} initialData.setPurchaseOrders(as);
	}
	public void removePurchaseOrder(PurchaseOrder a)
	{
		List<PurchaseOrder> as = initialData.getPurchaseOrders();
		for(int i = 0; i< as.size(); i++)
		{
			if (as.get(i).equals(a))
			{
				as.remove(i);
			}
		} initialData.setPurchaseOrders(as);;
	}	
	
	///FindBy Methods
	public PurchaseOrder findbyPurchaseOrderID( int ID) {
		// TODO Auto-generated method stub
		for (PurchaseOrder i: initialData.getPurchaseOrders()){
			if(i.getPurchaseOrderId() == ID) return i;
			else{
					System.out.println("PurchaseOrder ID not found");
				}
		}
		return null;
	}
	public PurchaseOrder findbySupplierID(int supplierID)
	{
		for(PurchaseOrder i: initialData.getPurchaseOrders())
		{
			if(i.getSupplierId() == supplierID) return i;
			else System.out.println("Supplier ID not found");
		}
		return null;
	}
	public PurchaseOrder findByDateOrder(int dateOrdered)
	{
		for (PurchaseOrder i: initialData.getPurchaseOrders())
		{
			if(i.getDateOrdered() == dateOrdered) return i;
			else System.out.println("No orders where made on the Day");
		}
		return null;
	}
	public void persistPurchaseOrder(PurchaseOrder a) {
		// TODO Auto-generated method stub
		
	}

	public void persistPurchaseOrder(List<PurchaseOrder> a) {
		// TODO Auto-generated method stub
		//return initialData.getPurchaseOrder();
	}



	public ArrayList<PurchaseOrder> getPurchaseOrder() {
		// TODO Auto-generated method stub
		return null;
	}

	public void cancelPurchaseOrder(PurchaseOrder a) {
		// TODO Auto-generated method stub
	}
	public PurchaseOrder findbyName(String name) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
