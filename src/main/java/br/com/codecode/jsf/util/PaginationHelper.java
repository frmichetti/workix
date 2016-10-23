package br.com.codecode.jsf.util;

import java.util.Collection;

import javax.faces.model.DataModel;

public abstract class PaginationHelper {

	private int limitRows;	

	private int currentPage;

	private Collection<?> collection;

	private DataModel<?> dataModel; 	

	public PaginationHelper(Collection<?> collection,int limitRows) {
		this.collection = collection;
		this.limitRows = limitRows;
	}

	public int getItemsCount(){
		return collection.size();
	};

	public abstract DataModel<?> createPageDataModel();
	

	public int getPageFirstItem() {
		return currentPage * limitRows;
	}	

	public boolean isHasNextPage() {
		return ((currentPage + 1) * (limitRows + 1) <= getItemsCount());
	}
	
	public boolean isHasPreviousPage() {
		return currentPage > 0;
	}


	public void nextPage() {
		if (isHasNextPage()) {
			currentPage++;
		}
	}
	
	public void previousPage() {
		if (isHasPreviousPage()) {
			currentPage--;
		}
	}	
	

	public int getLimitRows() {
		return limitRows;
	}

	public DataModel<?> getdataModel() {

		if (dataModel == null) {
			dataModel = createPageDataModel();
		}

		return dataModel;
	}






}

