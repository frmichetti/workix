package br.com.codecode.workix.bean;

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;

import br.com.codecode.workix.cdi.dao.Crud;
import br.com.codecode.workix.cdi.qualifier.Generic;
import br.com.codecode.workix.exception.NotImplementedYetException;
import br.com.codecode.workix.model.enums.Estate;
import br.com.codecode.workix.model.enums.JobCategory;
import br.com.codecode.workix.model.enums.JobType;
import br.com.codecode.workix.model.scaffold.Company;
import br.com.codecode.workix.model.scaffold.Job;

@Model
public class PostAJobMB {

	@Inject @Generic
	private Crud<Job> dao;
	
	@Inject @Generic
	private Crud<Company> companyDao;

	private Job currentJob;
	
	private List<Estate> estates;
	
	private List<JobType> jobTypes;
	
	private List<JobCategory> jobCategories;
	
	private List<Company> employeers;

	public PostAJobMB(){}

	@PostConstruct
	private void init(){

		currentJob = new Job();
		
		estates = Arrays.asList(Estate.values());
		
		jobTypes = Arrays.asList(JobType.values());
		
		jobCategories = Arrays.asList(JobCategory.values());
		
		try {
			employeers = companyDao.listAll(0, 100);
		} catch (NotImplementedYetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		debug();
	}

	private void debug() {
		if (currentJob != null){
			currentJob.setStart(Calendar.getInstance());
			currentJob.setExpire(Calendar.getInstance());
			currentJob.setActive(true);
			currentJob.setCategory(JobCategory.OPERATOR);	
			currentJob.setEmployeer(employeers.get(3));
			currentJob.setDescription("WHATEVER TEXT ");			
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
	
	public void commit(){		

		try {
			
			dao.save(currentJob);
			
		} catch (NotImplementedYetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		

	}

	public List<Company> getEmployeers() {
		return employeers;
	}

	
}
