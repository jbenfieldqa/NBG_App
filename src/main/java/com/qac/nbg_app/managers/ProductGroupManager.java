package com.qac.nbg_app.managers;

import java.util.*;

import com.qac.nbg_app.entities.Product;
import com.qac.nbg_app.entities.ProductGroup;


public interface ProductGroupManager {
	public void productGroup(ProductGroup a);	
	public ProductGroup findByPGName(String name);
	public ProductGroup findByPGID(int pgID);
	
	public ProductGroup getProductGroup(ProductGroup a);
	public List<ProductGroup> listProductGroups();
	public void updateProductGroup(ProductGroup a);
	public void removeProductGroup(ProductGroup a);
	public List<ProductGroup> findAll();
	
}
