package br.com.codecode.bean;

import java.util.Collection;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;

import br.com.codecode.dao.CandidateDao;
import br.com.codecode.dao.CompanyDao;
import br.com.codecode.dao.JobDao;
import br.com.codecode.model.scaffold.Job;

@Model
public class HomeMB {
	
	@Inject
	private JobDao jobDao;
	
	@Inject
	private CompanyDao empDao;
	
	@Inject
	private CandidateDao candDao;
	
	private Collection<Job> joblist;	
	
	private int counterJobs;
	
	private int counterCandidates;
	
	private int counterEmployeers;	
	
	private int counterResumes;
	
	public HomeMB() {
		// TODO Auto-generated constructor stub
	}
	
	@PostConstruct
	private void init(){
		
		joblist = jobDao.listAll(0, Integer.MAX_VALUE);
		
		counterJobs =  jobDao.listAll(0, Integer.MAX_VALUE).size();
		
		counterEmployeers =  empDao.listAll(0, Integer.MAX_VALUE).size();
		
		counterCandidates = candDao.listAll(0, Integer.MAX_VALUE).size();	
		
		
	}
	
	public int getCounterJobs() {
		return counterJobs;
	}

	public int getCounterCandidates() {
		return counterCandidates;
	}

	public int getCounterEmployeers() {
		return counterEmployeers;
	}

	public int getCounterResumes() {
		return counterResumes;
	}	

	public Collection<Job> getJoblist() {
		return joblist;
	}

	

	

}
