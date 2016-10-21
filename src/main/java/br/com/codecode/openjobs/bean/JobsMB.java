package br.com.codecode.openjobs.bean;

import java.util.Collection;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.inject.Inject;

import br.com.codecode.cdi.dao.Crud;
import br.com.codecode.jsf.util.PaginationHelper;
import br.com.codecode.openjobs.model.scaffold.Job;

@Model
public class JobsMB {

	@Inject
	private Crud<Job> dao;

	private List<Job> joblist;

	private String prefix,sufix;
	
	private PaginationHelper paginationHelper;

	public JobsMB() {
		// TODO Auto-generated constructor stub
	}

	@PostConstruct
	private void init(){
		
		joblist = dao.listAll(0, Integer.MAX_VALUE);
		
		prefix = "/jobs";
		
		sufix = "&faces-redirect=true";
		
		paginationHelper = new PaginationHelper(joblist,15) {
			
			@Override
			public DataModel<?> createPageDataModel() {
		
				return new ListDataModel<Job>(joblist);
			}
		};
		
		
	}

	public Collection<Job> getJoblist() {
		return joblist;
	}

	public String goToJobDetail(Job job){

		System.out.println("Received Job " + job.toString());

		return prefix + "/job-details.xhtml?id=" + String.valueOf(job.getId()) + sufix ;
	}


	


}
