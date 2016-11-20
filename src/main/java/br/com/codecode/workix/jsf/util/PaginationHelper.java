package br.com.codecode.workix.jsf.util;

import javax.enterprise.context.RequestScoped;

/**
 * Pagination Helper
 * @author felipe
 * @version 1.0
 *
 */
@RequestScoped
public class PaginationHelper {		

	/**
	 * Discover Total Pages
	 * @param limitRows
	 * @param maxRows
	 * @return number of Pages between Limit and Max Rows
	 */
	public int discoverTotalPages(int limitRows, int maxRows){

		return (maxRows / limitRows);
	}

	/**
	 * Discover Max Rows between Limit and Total Pages
	 * @param limitRows
	 * @param totalPages
	 * @return number of Rows between Limit and Total Pages
	 */
	public int discoverMaxRows(int limitRows,int totalPages){

		return (totalPages * limitRows);
	}

	/**
	 * Discover Start Range between Total Pages and Limit
	 * @param limitRows
	 * @param currentPage
	 * @param totalPages
	 * @return start Point for Pagination
	 * @throws IllegalArgumentException
	 */
	public int discoverStartRange(int limitRows,int currentPage,int totalPages) throws IllegalArgumentException {

		if(currentPage < 1){
			throw new IllegalArgumentException("Current Page Minor than 1");
		}

		return (limitRows * currentPage) - limitRows + 1;

	}

	/**
	 * Discover End Range between Total Pages and Limit
	 * @param limitRows
	 * @param currentPage
	 * @param totalPages
	 * @return end Point for Pagination
	 */
	public int discoverEndRange(int limitRows,int currentPage,int totalPages){
		
		return discoverStartRange(limitRows, currentPage, totalPages) + limitRows - 1;
		
	}



}
