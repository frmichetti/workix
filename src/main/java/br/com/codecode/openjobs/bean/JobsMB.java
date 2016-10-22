package br.com.codecode.openjobs.bean;

import java.util.Collection;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import br.com.codecode.cdi.dao.Crud;
import br.com.codecode.openjobs.model.scaffold.Job;

@Model
public class JobsMB {

	@Inject
	private FacesContext facesContext;
	
	@Inject
	private Crud<Job> dao;

	private List<Job> list;

	private String prefix,sufix;
	
	private int start,end;


	public JobsMB() {
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

	public Collection<Job> getList() {
		return list;
	}

	public String goToJobDetail(Job job){

		System.out.println("Received Job " + job.toString());

		return prefix + "/job-details.xhtml?id=" + String.valueOf(job.getId()) + sufix ;
	}


	


}
