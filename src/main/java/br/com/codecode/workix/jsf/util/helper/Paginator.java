package br.com.codecode.workix.jsf.util.helper;

/**
 * Paginator Helper for Pagination
 * @author felipe
 * @since 1.1
 * @version 1.0
 */
public class Paginator {
    
    private int limitRows, currentPage,totalPages, maxRows;
    
    private Pagination pagination = new Pagination();
    
    /**
     * Stub Constructor
     */
    private Paginator(){}
    
    /**
     * 
     * @param limitRows Limit Rows
     * @param currentPage Current Page
     * @param maxRows Max Rows Limitator
     */
    public Paginator(int limitRows, int currentPage,int maxRows){
	this();
	this.limitRows = limitRows;
	this.currentPage = currentPage;
	this.maxRows = maxRows;
	this.totalPages = pagination.discoverTotalPages(limitRows, maxRows);
    }

    
    /**
     * @return the limitRows
     */
    public int getLimitRows() {
        return limitRows;
    }

    
    /**
     * @return the currentPage
     */
    public int getCurrentPage() {
        return currentPage;
    }

    
    /**
     * @return the totalPages
     */
    public int getTotalPages() {
        return totalPages;
    }

    
    /**
     * @return the maxRows
     */
    public int getMaxRows() {
        return maxRows;
    }    
  
    /**
     * @return the Start Range
     */
    public int getStart(){
	return pagination.discoverStartRange(limitRows, currentPage, totalPages);
    }
    
    /**
     * @return the End Range
     */
    public int getEnd(){
	return pagination.discoverEndRange(limitRows, currentPage, totalPages);
    }
    
    

}
