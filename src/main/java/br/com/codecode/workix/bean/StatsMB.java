package br.com.codecode.workix.bean;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;

import br.com.codecode.workix.cdi.dao.Crud;
import br.com.codecode.workix.cdi.qualifier.Mockup;
import br.com.codecode.workix.model.scaffold.Candidate;
import br.com.codecode.workix.model.scaffold.Company;
import br.com.codecode.workix.model.scaffold.Job;

@Model
public class StatsMB {
	
	@Inject @Mockup
	private Crud<Job> jobDao;
	
	@Inject @Mockup
	private Crud<Company> companyDao;
	
	@Inject @Mockup
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
