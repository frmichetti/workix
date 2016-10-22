package br.com.codecode.openjobs.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import br.com.codecode.cdi.dao.Crud;
import br.com.codecode.openjobs.model.scaffold.Candidate;

@Model
public class CandidatesMB {

	@Inject
	private FacesContext facesContext;

	@Inject
	private Crud<Candidate> dao;

	private List<Candidate> list;

	private String prefix,sufix;
	
	private int start,end;

	public CandidatesMB() {
		// TODO Auto-generated constructor stub
	}

	@PostConstruct
	private void init(){
		
		if(this.end == 0){
			list = dao.listAll(0, 100);	
		}	
		
		list = dao.listAll(0, 100);

		prefix = "/" + facesContext.getExternalContext().getContextName();

		sufix = "&faces-redirect=true";
	}

	public List<Candidate> getList() {
		return list;
	}
	
	public String goToCandidateDetail(Candidate candidate){

		System.out.println("Received Candidate " + candidate.toString());

		return prefix + "/candidate-details.xhtml?id=" + String.valueOf(candidate.getId()) + sufix ;
	}
	
	
	

}
