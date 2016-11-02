package br.com.codecode.workix.test.bean;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import br.com.codecode.workix.jsf.util.Pagination;

/**
 * 
 * TDD Pagination Test
 * @author felipe
 *
 */
public class PaginationTest {	

	private Pagination pagination;

	private int totalRows,limitRows,currentPage;	


	private void input(){

		pagination = new Pagination();

		totalRows = 1500;

		limitRows = 30;			

		currentPage = 1;

	}


	@Test
	public void discoverTotalPages(){	

		input();

		int totPages = totalRows / limitRows;

		assertEquals(totPages,pagination.discoverTotalPages(limitRows, totalRows));	

	}

	@Test
	public void discoverMaxRows(){

		input();

		assertEquals(totalRows, pagination.discoverMaxRows(limitRows, pagination.discoverTotalPages(limitRows, totalRows)));		

	}

	@Test
	public void discoverRange(){


	}

	@Test
	public void discoverEndRange(){		


	}

	@Test
	public void discoverStartRange(){		

		input();		

		int totalPages = pagination.discoverTotalPages(limitRows, totalRows);

		assertEquals(1, pagination.discoverRange(totalPages, limitRows));

	}



}
