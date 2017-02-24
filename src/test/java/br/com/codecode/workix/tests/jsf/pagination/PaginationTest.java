package br.com.codecode.workix.tests.jsf.pagination;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import br.com.codecode.workix.jsf.util.helper.Pagination;

/**
 * TDD Pagination Test
 * 
 * @author felipe
 */
public class PaginationTest {

    private Pagination pagination;

    private int totalRows, limitRows, currentPage;

    private void input() {

	pagination = new Pagination();

	totalRows = 50;

	limitRows = 10;

	currentPage = 5;

    }

    @Test
    public void discoverTotalPages() {

	input();

	int totPages = totalRows / limitRows;

	assertEquals(totPages, pagination.discoverTotalPages(limitRows, totalRows));

    }

    @Test
    public void discoverMaxRows() {

	input();

	assertEquals(totalRows,
		pagination.discoverMaxRows(limitRows, pagination.discoverTotalPages(limitRows, totalRows)));

    }

    @Test
    public void discoverStartRange() {

	input();

	assertEquals((limitRows * currentPage) - limitRows + 1, pagination.discoverStartRange(limitRows, currentPage,
		pagination.discoverTotalPages(limitRows, totalRows)));

	System.out.println("Total Rows : " + totalRows);

	System.out.println("Limit Rows : " + limitRows);

	int totalPages = pagination.discoverTotalPages(limitRows, totalRows);

	System.out.println("Total Pages : " + totalPages);

	System.out.println("Current Page : " + currentPage);

	System.out.println("Start Range : " + pagination.discoverStartRange(limitRows, currentPage, totalPages));

	System.out.println("End Range : " + pagination.discoverEndRange(limitRows, currentPage, totalPages));

    }

    @Test
    public void discoverEndRange() {

	input();

	assertEquals(currentPage * limitRows, pagination.discoverEndRange(limitRows, currentPage,
		pagination.discoverTotalPages(limitRows, totalRows)));

    }

    @Test
    public void pagination() {

	input();

	while (currentPage <= pagination.discoverTotalPages(limitRows, totalRows)) {

	    System.out.println("Current Page " + currentPage);

	    currentPage++;
	}

    }

}
