package javaEE.initialData;
import java.util.*;

import javaEE.enums.Status;
import javaEE.project.ProductItem;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;

@Startup
@Singleton 
public class InitialProductItemData {
	private List<ProductItem> productItems =  new ArrayList<ProductItem>();
	
	@PostConstruct
	public void setupData() {
		productItems.add(new ProductItem(1, 1, "Red Gnome", Status.isAvailable));
		productItems.add(new ProductItem(2, 2, "Blue Gnome", Status.isAvailable));
		productItems.add(new ProductItem(3, 3, "Green Gnome", Status.isAvailable));
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
}
