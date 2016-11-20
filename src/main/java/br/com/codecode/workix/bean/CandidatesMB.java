package br.com.codecode.workix.bean;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.context.FacesContext;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.inject.Inject;
import javax.validation.constraints.Min;

import br.com.codecode.workix.cdi.dao.Crud;
import br.com.codecode.workix.cdi.qualifier.Generic;
import br.com.codecode.workix.jsf.util.Pagination;
import br.com.codecode.workix.model.scaffold.Candidate;
import br.com.codecode.workix.model.scaffold.Job;

@Model
public class CandidatesMB {

	@Inject
	private FacesContext facesContext;
	
	@Inject
	private Pagination pagination;

	@Inject @Generic
	private Crud<Candidate> dao;

	private DataModel<Candidate> list;

	private String prefix,sufix;	
	
	/**
	 * Max Results By Page
	 */
	private final int limitRows = 10;

	private int start,end,totalRows,totalPages;
	
	@Min(1)
	private int page;

	public CandidatesMB(){}

	/**
	 * Must be Called by f:viewAction After f:viewParam {@link page} 
	 */
	public void init(){		

		totalRows = dao.countRegisters().intValue();

		totalPages = pagination.discoverTotalPages(limitRows, totalRows);

		start = pagination.discoverStartRange(limitRows, page, totalPages);

		end = pagination.discoverEndRange(limitRows, page, totalPages);

		list = new ListDataModel<Candidate>(dao.listAll(start,end));		

		prefix = "/" + facesContext.getExternalContext().getContextName();

		sufix = "&faces-redirect=true";
		
		debug:{
			System.out.println("Current Page : " + page);		

			System.out.println("Current totalRows : " + totalRows);

			System.out.println("Current totalPages : " + totalPages);

			System.out.println("Start " + start);

			System.out.println("End " + end);
		}
	}
	
	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public DataModel<Candidate> getList() {
		return list;
	}
	
	public String goToCandidateDetail(Candidate candidate){

		System.out.println("Received Candidate " + candidate.toString());

		return prefix + "/resume.xhtml?id=" + String.valueOf(candidate.getId()) + sufix ;
	}
	
	
	

}
