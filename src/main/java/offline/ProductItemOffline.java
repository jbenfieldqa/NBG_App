package offline;

import java.util.*;

import com.qac.nbg_app.entities.ProductItem;
import com.qac.nbg_app.util.InitialData;

import managers.ProdItemInterface;



public class ProductItemOffline implements ProdItemInterface {
	private InitialData initialData; 
	
	public void productItem(ProductItem a) {
		initialData.addProductItem(a); 
	}

	public void listProductItems(List<ProductItem> a) {
		initialData.getProductItems();
	}

	public ProductItem findByProductName(String name) {
		for(ProductItem i: initialData.getProductItems()){
			if(i.getProductName() == name) return i;
			else{System.out.println("Product Name Not Found");}
		}		
		return null;
	}
	

	public ProductItem findByProductID(int pgID) {
		for(ProductItem i: initialData.getProductItems()){
			if(i.getProductItemId() == pgID) return i;
			else{System.out.println("Product ID Not Found");}
		}		
		return null;
	}

	public ArrayList<ProductItem> getProductItems() {
		ArrayList<ProductItem> productItems = (ArrayList<ProductItem>) initialData.getProductItems();
		return productItems;
	}

	public void updateProductItem(ProductItem a) {
		List<ProductItem> pi = initialData.getProductItems();
		for(int i = 0; i <pi.size(); i++){
			if(pi.get(i).equals(a)) pi.set(i, a);
		}
		initialData.setProductItem(pi);
	} 

	public void removeProductItem(ProductItem a) {
		List<ProductItem> pi = initialData.getProductItems();
		for(int i = 0; i <pi.size(); i++){
			if(pi.get(i).equals(a)) pi.remove(a);
		}
		initialData.setProductItem(pi);
	} 

	public ProductItem getProductItem(ProductItem a){
		List<ProductItem> pi = initialData.getProductItems();
		for(int i=0;i<pi.size(); i++){
			if(pi.get(i).equals(a)) return a;
		}
		return null;
	}

}
