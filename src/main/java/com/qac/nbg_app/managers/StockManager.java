package com.qac.nbg_app.managers;
import java.util.*;

import com.qac.nbg_app.entities.Stock;

public interface StockManager {
	
	public void persistStock(Stock a);
	public void persistStock(List<Stock> a);
	
	public void findStockLevel();
	public void checkStockLevel();
	public void updateStockLevel(Stock a);
	
	public void removeStock(Stock a);
	
	
	
}
