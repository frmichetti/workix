package br.com.codecode.akijob.bean;

import java.util.Collection;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;

import br.com.codecode.akijob.model.scaffold.Candidate;
import br.com.codecode.akijob.model.scaffold.Company;
import br.com.codecode.akijob.model.scaffold.Job;
import br.com.codecode.cdi.dao.Crud;

@Model
public class StatsMB {
	
	@Inject
	private Crud<Job> jobDao;
	
	@Inject
	private Crud<Company> companyDao;
	
	@Inject
	private Crud<Candidate> candidateDao;
	
	private Collection<Job> joblist;	
	
	private int counterJobs;
	
	private int counterCandidates;
	
	private int counterEmployeers;	
	
	private int counterResumes;
	
	public StatsMB() {
		// TODO Auto-generated constructor stub
	}
	
	@PostConstruct
	private void init(){
		
		joblist = jobDao.listAll(0, Integer.MAX_VALUE);
		
		counterJobs =  jobDao.listAll(0, Integer.MAX_VALUE).size();
		
		counterEmployeers =  companyDao.listAll(0, Integer.MAX_VALUE).size();
		
		counterCandidates = candidateDao.listAll(0, Integer.MAX_VALUE).size();	
		
		
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
