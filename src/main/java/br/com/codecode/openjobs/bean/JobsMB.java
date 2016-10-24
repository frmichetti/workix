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
import br.com.codecode.openjobs.model.scaffold.Job;

@Model
public class JobsMB {

	@Inject
	private FacesContext facesContext;

	@Inject @Mockup
	private Crud<Job> dao;

	private DataModel<Job> list;

	private String prefix,sufix;

	@Min(1)
	private int page;

	public JobsMB(){}

	@PostConstruct
	public void init(){		

		list = new ListDataModel<Job>(dao.listAll(0,100));		

		prefix = "/" + facesContext.getExternalContext().getContextName();

		sufix = "&faces-redirect=true";		

	}	

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public DataModel<Job> getList() {
		return list;
	}

	
	public String goToJobDetail(Job job){

		System.out.println("Received Job " + job.toString());

		return prefix + "/job-details.xhtml?id=" + String.valueOf(job.getId()) + sufix ;
	}






}
