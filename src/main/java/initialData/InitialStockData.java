package main.java.initialData;

import java.util.ArrayList;
import java.util.List;

import main.java.project.Stock;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;

@Startup
@Singleton 
public class InitialStockData {
	private List<Stock> stockList =  new ArrayList<Stock>();
	
	@PostConstruct
	public void setupData(){
		stockList.add(new Stock(1, 50));
		stockList.add(new Stock(2, 25));
		stockList.add(new Stock(3, 5));
	}
	public void addStock(Stock a)
	{
		stockList.add(a);
	}
	public void removeStock(Stock a)
	{
		stockList.remove(a);
	}
	public List<Stock> getStock()
	{
		return stockList;
	}
	public void setStock(List<Stock> stock)
	{
		this.stockList = stock;
	}
}
