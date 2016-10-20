package br.com.codecode.openjobs.bean;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;

import br.com.codecode.cdi.dao.Crud;
import br.com.codecode.openjobs.model.enumeration.Estate;
import br.com.codecode.openjobs.model.enumeration.JobCategory;
import br.com.codecode.openjobs.model.enumeration.JobType;
import br.com.codecode.openjobs.model.scaffold.Company;
import br.com.codecode.openjobs.model.scaffold.Job;

@Model
public class PostAJobMB {

	@Inject
	private Crud<Job> dao;
	
	@Inject
	private Crud<Company> companyDao;

	private Job currentJob;
	
	private List<Estate> estates;
	
	private List<JobType> jobTypes;
	
	private List<JobCategory> jobCategories;
	
	private List<Company> employeers;

	public PostAJobMB() {

	}

	@PostConstruct
	private void init(){

		currentJob = new Job();
		
		estates = Arrays.asList(Estate.values());
		
		jobTypes = Arrays.asList(JobType.values());
		
		jobCategories = Arrays.asList(JobCategory.values());
		
		employeers = companyDao.listAll(0, Integer.MAX_VALUE);

		debug();
	}

	private void debug() {
		if (currentJob != null){
			currentJob.setStart(new Date());
			currentJob.setExpire(new Date());
			currentJob.setUuid(UUID.randomUUID().toString());
		}

	}
	
	

	
	public List<Estate> getEstates() {
		return estates;
	}

	public List<JobType> getJobTypes() {
		return jobTypes;
	}

	public List<JobCategory> getJobCategories() {
		return jobCategories;
	}

	public Job getCurrentJob() {
		return currentJob;
	}

	public void setCurrentJob(Job currentJob) {
		this.currentJob = currentJob;
	}

	@Transactional
	public void commit(){		

		dao.create(currentJob);		

	}

	public List<Company> getEmployeers() {
		return employeers;
	}

	
}
