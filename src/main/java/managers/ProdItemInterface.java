package managers;
import java.util.*;
import project.ProductItem;


public interface ProdItemInterface {

	public void productItem(ProductItem a);
	public void listProductItems(List<ProductItem>a);
	
	public ProductItem findByProductName(String name);
	public ProductItem findByProductID(int pgID);
	
	public ArrayList<ProductItem> getProductItems(); 
	public ProductItem getProductItem(ProductItem i); 
	public void updateProductItem (ProductItem a);
	public void removeProductItem (ProductItem a);
	
}