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
import br.com.codecode.workix.model.scaffold.Candidate;

@Model
public class CandidatesMB {

	@Inject
	private FacesContext facesContext;

	@Inject @Generic
	private Crud<Candidate> dao;

	private DataModel<Candidate> list;

	private String prefix,sufix;	
	
	@Min(1)
	private int page;

	public CandidatesMB(){}

	@PostConstruct
	private void init(){
	
		list = new ListDataModel<Candidate>(dao.listAll(0, 100));

		prefix = "/" + facesContext.getExternalContext().getContextName();

		sufix = "&faces-redirect=true";
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
