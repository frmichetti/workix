package br.com.codecode.workix.bean;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;

import br.com.codecode.workix.cdi.dao.Crud;
import br.com.codecode.workix.cdi.qualifier.Generic;
import br.com.codecode.workix.exception.NotImplementedYetException;
import br.com.codecode.workix.model.jpa.Candidate;
import br.com.codecode.workix.model.jpa.Company;
import br.com.codecode.workix.model.jpa.Job;
import br.com.codecode.workix.model.jpa.Resume;

@Model
public class StatsMB {

	@Inject @Generic
	private Crud<Job> jobDao;

	@Inject @Generic
	private Crud<Company> companyDao;

	@Inject @Generic
	private Crud<Candidate> candidateDao;
	
	@Inject @Generic
	private Crud<Resume> resumeDao;

	private int counterJobs;

	private int counterCandidates;

	private int counterEmployeers;	

	private int counterResumes;

	public StatsMB(){}

	@PostConstruct
	private void init(){

		try {

			jobDao.countRegisters();

			counterJobs =  jobDao.countRegisters().intValue();

			counterEmployeers =  companyDao.countRegisters().intValue();

			counterCandidates = candidateDao.countRegisters().intValue();

			counterResumes = resumeDao.countRegisters().intValue();

		} catch (NotImplementedYetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

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
