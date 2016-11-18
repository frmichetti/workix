package br.com.codecode.workix.jsf.util;
/**
 * TODO Pagination for Pages
 * @author felipe
 *
 */
public class Pagination {		

	/**
	 * 
	 * @param limitRows
	 * @param maxRows
	 * @return
	 */
	public int discoverTotalPages(int limitRows, int maxRows){

		return (maxRows / limitRows);
	}

	/**
	 * 
	 * @param limitRows
	 * @param totalPages
	 * @return
	 */
	public int discoverMaxRows(int limitRows,int totalPages){

		return (totalPages * limitRows);
	}

	/**
	 * @param totalPages
	 * @param limitRows 
	 * @return
	 */
	public int discoverRange(int totalPages,int limitRows){	

		return (totalPages / limitRows);
	}

	/**
	 * 
	 * @param limitRows
	 * @param currentPage
	 * @return
	 */
	public int discoverStartRange(int limitRows,int currentPage,int totalPages){

		return (discoverRange(totalPages, limitRows) * currentPage) - limitRows;
	}

	/**
	 * 
	 * @param limitRows
	 * @param currentPage
	 * @return
	 */
	public int discoverEndRange(int limitRows,int currentPage,int totalPages){		

		return discoverRange(totalPages, limitRows) * currentPage;

	}



}
