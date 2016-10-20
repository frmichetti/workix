package br.com.codecode.bean;

import java.util.Collection;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;

import br.com.codecode.dao.JobDao;
import br.com.codecode.model.scaffold.Job;

@Model
public class JobsMB {
	
	@Inject
	private JobDao dao;
	
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
