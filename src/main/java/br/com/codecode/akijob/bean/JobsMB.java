package br.com.codecode.akijob.bean;

import java.util.Collection;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;

import br.com.codecode.akijob.model.scaffold.Job;
import br.com.codecode.cdi.dao.Crud;

@Model
public class JobsMB {
	
	@Inject
	private Crud<Job> dao;
	
	private Collection<Job> joblist;
	
	private String prefix,sufix;
	
	public JobsMB() {
		// TODO Auto-generated constructor stub
	}
	
	@PostConstruct
	private void init(){
		joblist = dao.listAll(0, Integer.MAX_VALUE);
		prefix = "/jobs";
		sufix = "&faces-redirect=true";
	}

	public Collection<Job> getJoblist() {
		return joblist;
	}
	
	public String goToJobDetail(Job job){
		
		System.out.println("Received Job " + job.toString());
		
		return prefix + "/job-details.xhtml?id=" + String.valueOf(job.getId()) + sufix ;
	}
	
	
	
	
	

}
