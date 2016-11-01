package com.qac.nbg_app.util;

import javax.faces.model.DataModel;

public abstract class Pagination {
	private int pageSize;
	private int page;
	
	public Pagination(int pageSize) {
		this.pageSize = pageSize;
	}

	abstract public DataModel createDataModel();
	abstract public int getItemsCount();
	
	protected int getPageFirstItem() {
		return page * pageSize;
	}
	
	protected int getPageSize() {
		return pageSize;
	}
	
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	
	public boolean isHasNextPage() {
		return (page+1) * pageSize + 1 <= getItemsCount();
	}
	
	public void nextPage() {
		if (isHasNextPage())
			page++;
	}
	
	public boolean isHasPreviousPage() {
		return page > 0;
	}
	
	public void previousPage() {
		if(isHasPreviousPage())
			page--;
	}

	public int getPageLastItem() {
		int i = getPageFirstItem() + pageSize - 1;
		int cont = getItemsCount() - 1;
		if(cont > i)
			i = cont;
		if (i < 0)
			i = 0;
		return i;
	}
}