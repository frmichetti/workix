package br.com.codecode.openjobs.bean;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.context.FacesContext;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.inject.Inject;
import javax.validation.constraints.Min;

import br.com.codecode.cdi.dao.Crud;
import br.com.codecode.cdi.qualifier.Mockup;
import br.com.codecode.openjobs.model.scaffold.Candidate;

@Model
public class CandidatesMB {

	@Inject
	private FacesContext facesContext;

	@Inject @Mockup
	private Crud<Candidate> dao;

	private DataModel<Candidate> list;

	private String prefix,sufix;	
	
	@Min(1)
	private int page;

	public CandidatesMB() {
		// TODO Auto-generated constructor stub
	}

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

		return prefix + "/candidate-details.xhtml?id=" + String.valueOf(candidate.getId()) + sufix ;
	}
	
	
	

}
