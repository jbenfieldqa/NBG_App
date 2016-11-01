package managers;
import java.util.*;
import project.Stock;

public interface StockManager {
	
	public void persistStock(Stock a);
	public void persistStock(List<Stock> a);
	
	public void findStockLevel();
	public void checkStockLevel();
	public void updateStockLevel(Stock a);
	
	public void removeStock(Stock a);
	
	
	
}
