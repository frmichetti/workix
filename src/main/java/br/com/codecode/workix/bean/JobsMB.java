package br.com.codecode.workix.bean;

import java.io.IOException;

import javax.enterprise.inject.Model;
import javax.faces.context.FacesContext;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.inject.Inject;
import javax.validation.constraints.Min;

import br.com.codecode.workix.cdi.dao.Crud;
import br.com.codecode.workix.cdi.qualifier.Generic;
import br.com.codecode.workix.jsf.util.PaginationHelper;
import br.com.codecode.workix.model.scaffold.Job;

@Model
public class JobsMB {

	@Inject
	private FacesContext facesContext;	

	@Inject
	private PaginationHelper pagination;

	@Inject @Generic
	private Crud<Job> dao;

	private DataModel<Job> list;

	private String prefix,sufix;

	/**
	 * Max Results By Page
	 */
	private final int limitRows = 10;

	private int start,end,totalRows,totalPages;

	@Min(1)
	private int page;

	public JobsMB(){}

	/**
	 * Must be Called by f:viewAction After f:viewParam {@link page} 
	 */
	public void init(){

		totalRows = dao.countRegisters().intValue();

		totalPages = pagination.discoverTotalPages(limitRows, totalRows);

		start = pagination.discoverStartRange(limitRows, page, totalPages);

		end = pagination.discoverEndRange(limitRows, page, totalPages);

		list = new ListDataModel<Job>(dao.listAll(start-1,end));

		prefix = "/" + facesContext.getExternalContext().getContextName();

		sufix = "&faces-redirect=true";

		{
			System.out.println("Current Page : " + page);		

			System.out.println("Total Rows : " + totalRows);

			System.out.println("Total Pages : " + totalPages);

			System.out.println("Start " + start);

			System.out.println("End " + end);
		}

	}	

	public DataModel<Job> getList() {
		return list;
	}


	public String goToJobDetail(Job job){

		System.out.println("Received Job " + job.toString());

		return prefix + "/job-details.xhtml?id=" + String.valueOf(job.getId()) + sufix ;
	}

	public String goToLastPage(){
		return prefix + "/jobs2.xhtml?page=" + String.valueOf(totalPages) + sufix;
	}

	public String goToFirstPage(){
		return prefix + "/jobs2.xhtml?page=" + String.valueOf(1) + sufix;
	}

	public void goToNextPage(){

		if(page < totalPages)

			page++;

		try {
			facesContext.getExternalContext().redirect(prefix + "/jobs2.xhtml?page=" + String.valueOf(page) + sufix);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void goToPreviousPage(){

		if(page > 1)

			page--;

		try {
			facesContext.getExternalContext().redirect(prefix + "/jobs2.xhtml?page=" + String.valueOf(page) + sufix);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}

	public String goToPage(int page){
		return prefix + "/jobs2.xhtml?page=" + String.valueOf(page) + sufix;
	}

	public int getPage() {
		return page;
	}


	public void setPage(int page) {
		this.page = page;
	}

	public int getTotalPages() {
		return totalPages;
	}


}
