package com.qac.nbg_app.managers.offline;

import java.util.List;

import javax.ejb.Stateless;
import javax.enterprise.inject.Default;
import javax.inject.Inject;

import com.qac.nbg_app.entities.Stock;
import com.qac.nbg_app.managers.StockManager;
import com.qac.nbg_app.util.InitialData;


@Stateless
@Default
public abstract class StockOffline implements StockManager{

	@Inject
	private InitialData initialData;
	
	public void persistStock(Stock a) {
		// TODO Auto-generated method stub
		//initailData.addStock(a)
	}

	public void persistStock(List<Stock> a) {
		// TODO Auto-generated method stub
		
	}
	public Stock findStockID(int StockID) {
		// TODO Auto-generated method stub
		for (Stock i: initialData.getStock())
		{
			if (i.getStockId() == StockID) return i;
			else System.out.println("Stock ID not found");
		}
		return null;
	}
	public int checkTotalAmountOfStock()
	{
		int totalStock = 0;
		for (Stock as: initialData.getStock())
		{
			totalStock += as.getStockLevel();
		}
		return totalStock;
	}

	public void checkStockLevel(int stockID) {
		// TODO Auto-generated method stub
		for (Stock as: initialData.getStock())
		{
			if (as.getStockId() == stockID) 
				System.out.println("Stock Level of StockID: "+ stockID +" is " + as.getStockLevel());
			else System.out.println("StockID not found"); 
		}
	}

	public void updateStockLevel(Stock a) {
		// TODO Auto-generated method stub
		List<Stock> as = initialData.getStock();
		for(int i= 0; i< as.size(); i++)
		{
			if(as.get(i).equals(a))
			{
				as.set(i, a);
			}
		} initialData.setStock(as);
	}

	public void removeStock(Stock a) {
		List<Stock> as = initialData.getStock();
		for(int i= 0; i< as.size(); i++)
		{
			if(as.get(i).equals(a))
			{
				as.remove(i);
			}
		} initialData.setStock(as);
	}

	public void findStockLevel() {
		
	}
}
