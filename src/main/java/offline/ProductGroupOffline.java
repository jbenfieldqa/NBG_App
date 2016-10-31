package javaEE.offline;
import java.util.*;

import javax.inject.Inject;

import javaEE.initialData.InitialProductGroupData;
import javaEE.managers.PGInterface;
import javaEE.project.ProductGroup;

public class ProductGroupOffline implements PGInterface{
	@Inject
	private InitialProductGroupData initialData;
	
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
