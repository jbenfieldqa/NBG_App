package managers;

import java.util.*;

import com.qac.nbg_app.entities.ProductGroup;


public interface PGInterface {
	public void productGroup(ProductGroup a);	
	public ProductGroup findByPGName(String name);
	public ProductGroup findByPGID(int pgID);
	
	public ProductGroup getProductGroup(ProductGroup a);
	public List<ProductGroup> listProductGroups();
	public void updateProductGroup(ProductGroup a);
	public void removeProductGroup(ProductGroup a);
	
}
