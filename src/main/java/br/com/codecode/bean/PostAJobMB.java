package br.com.codecode.bean;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;

import br.com.codecode.dao.CompanyDao;
import br.com.codecode.dao.JobDao;
import br.com.codecode.enumeration.Estate;
import br.com.codecode.enumeration.JobCategory;
import br.com.codecode.enumeration.JobType;
import br.com.codecode.model.scaffold.Company;
import br.com.codecode.model.scaffold.Job;

@Model
public class PostAJobMB {

	@Inject
	private JobDao dao;
	
	@Inject
	private CompanyDao empDao;

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
		
		employeers = empDao.listAll(0, Integer.MAX_VALUE);

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
