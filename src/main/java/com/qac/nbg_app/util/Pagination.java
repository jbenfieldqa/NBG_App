package com.qac.nbg_app.util;

import javax.faces.model.DataModel;

public abstract class Pagination {
	private int pageSize;
	private int page;
	private int pageNum;
	
	public Pagination(int pageSize) {
		this.pageSize = pageSize;
		this.pageNum = 1;
	}

	abstract public DataModel createDataModel();
	abstract public int getItemsCount();
	abstract public int getNumOfPages();
	
	public int getPageFirstItem() {
		return page * pageSize;
	}
	
	public int getPageSize() {
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
		if(cont < i){
			return cont;
		}else return i;
	}

	public int getPageNum() {
		return page;
	}
	
	
}