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
	
	public JobsMB() {
		// TODO Auto-generated constructor stub
	}
	
	@PostConstruct
	private void init(){
		joblist = dao.listAll(0, 100);
	}

	public Collection<Job> getJoblist() {
		return joblist;
	}
	
	

}
