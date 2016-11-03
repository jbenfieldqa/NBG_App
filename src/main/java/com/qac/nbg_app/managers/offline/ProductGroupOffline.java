package  com.qac.nbg_app.managers.offline;

import java.util.*;

import javax.ejb.Stateless;
import javax.enterprise.inject.Default;

import com.qac.nbg_app.entities.ProductGroup;
import com.qac.nbg_app.managers.ProductGroupManager;
import com.qac.nbg_app.util.InitialData;

@Stateless
@Default
public abstract class ProductGroupOffline implements ProductGroupManager{
	
	private InitialData initialData;
	
	public void productGroup(ProductGroup a) {
		initialData.addProductGroup(a); 
	}
	
	public List<ProductGroup> listProductGroups(){
		return initialData.getProductGroups();
	}


	public ProductGroup findByPGName(String name) {
		for(ProductGroup i: initialData.getProductGroups()){
			if(i.getProductName() == name) return i;
			else{System.out.println("Product Name Not Found");}
		}		
		return null;
	}

	public ProductGroup findByPGID(int pgID) {
		for(ProductGroup i: initialData.getProductGroups()){
			if(i.getProductGroupId() == pgID) return i;
			else{
				System.out.println("Product Group ID Not Found");
			}
		}
		return null;	
	}

	public void updateProductGroup(ProductGroup a) {
		List<ProductGroup> pg = initialData.getProductGroups();
		for(int i = 0; i <pg.size(); i++){
			if(pg.get(i).equals(a)) pg.set(i, a);
		}
		initialData.setProductGroups(pg);
	} 
			
	public void removeProductGroup(ProductGroup a) {
		
		List<ProductGroup> pg = initialData.getProductGroups();
		for(int i = 0; i <pg.size(); i++){
			if(pg.get(i).equals(a)) pg.remove(a);
		}
		initialData.setProductGroups(pg);
	} 
	
	public ProductGroup getProductGroup(ProductGroup a) {
		return a;  	
	}
	

}

