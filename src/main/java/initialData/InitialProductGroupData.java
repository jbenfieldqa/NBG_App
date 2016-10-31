package javaEE.initialData;
import java.util.*;
import javaEE.project.ProductGroup;
import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;

@Startup
@Singleton 
public class InitialProductGroupData {
	private List<ProductGroup> productGroups =  new ArrayList<ProductGroup>();
	
	@PostConstruct
	public void setupData(){
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

}
