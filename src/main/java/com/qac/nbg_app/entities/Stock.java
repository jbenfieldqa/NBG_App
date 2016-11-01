package com.qac.nbg_app.entities;

import javax.persistence.*;
import javax.validation.constraints.*;


@Entity
@Table(name = "stock")

@NamedQueries({
	@NamedQuery(name = Stock.FIND_BY_STOCK_ID, query = "SELECT a FROM stock a WHERE a.stockId = :stockId"),
	@NamedQuery(name = Stock.FIND_BY_STOCK_LEVEL, query = "SELECT a FROM stock WHERE a.stockLevel = :stockLevel"),
	@NamedQuery(name = Stock.FIND_BY_SALES, query = "SELECT a FROM stock WHERE a.sales = :sales")
})

public class Stock {
	
	public static final String FIND_BY_STOCK_ID = "stock.findbystock";
	public static final String FIND_BY_STOCK_LEVEL = "stock.findbystock";
	public static final String FIND_BY_SALES = "stock.findbystock";
	
	
	@Id
	@Column(name = "stockId")
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int stockId;
	
	@Column(name = "stockLevel", nullable = false)
	@NotNull
	private int stockLevel;
	
	@Column(name = "sales", nullable = false)
	@NotNull
	private int[][] sales;
	
	void reorderStock()
	{
		//send message to supplier when stockLevel is less then minimum amount	
	}
	
	public Stock(int stockId, int stockLevel)
	{
		this.stockId = stockId;
		this.stockLevel = stockLevel;
	}
	
	public int getStockId() {
		return stockId;
	}
	
	public int getStockLevel() {
		return stockLevel;
	}

	public void setStockLevel(int stockLevel) {
		this.stockLevel = stockLevel;
	}
	public int[][] getSales() {
		return sales;
	}
	public void setSales(int[][] sales) {
		this.sales = sales;
	}
		
}
