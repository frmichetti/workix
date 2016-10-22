package br.com.codecode.openjobs.bean;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;

import br.com.codecode.cdi.dao.Crud;
import br.com.codecode.openjobs.model.scaffold.Candidate;
import br.com.codecode.openjobs.model.scaffold.Company;
import br.com.codecode.openjobs.model.scaffold.Job;

@Model
public class StatsMB {
	
	@Inject
	private Crud<Job> jobDao;
	
	@Inject
	private Crud<Company> companyDao;
	
	@Inject
	private Crud<Candidate> candidateDao;

	
	private int counterJobs;
	
	private int counterCandidates;
	
	private int counterEmployeers;	
	
	private int counterResumes;
	
	public StatsMB() {
		// TODO Auto-generated constructor stub
	}
	
	@PostConstruct
	private void init(){
		
		jobDao.countRegisters();
		
		counterJobs =  jobDao.countRegisters().intValue();
		
		counterEmployeers =  companyDao.countRegisters().intValue();
		
		counterCandidates = candidateDao.countRegisters().intValue();
		
		//counterResumes = candidateDao.listAll(start, end)
		
		
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



}
