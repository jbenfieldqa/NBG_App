package managers;
import java.util.*;
import project.PurchaseOrder;

public interface PurchaseOrderManager {
	
	public void persistPurchaseOrder(PurchaseOrder a);
	public void persistPurchaseOrder(List<PurchaseOrder> a);
	
	public PurchaseOrder findbyName(String name);
	public ArrayList<PurchaseOrder> getPurchaseOrder();
	
	public void updatePurchaseOrder (PurchaseOrder a);
	
	public void cancelPurchaseOrder (PurchaseOrder a);
}
