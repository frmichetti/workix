package br.com.codecode.workix.bean;

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.inject.Inject;

import br.com.codecode.workix.cdi.dao.Crud;
import br.com.codecode.workix.cdi.qualifier.Generic;
import br.com.codecode.workix.exception.NotImplementedYetException;
import br.com.codecode.workix.model.enums.Estate;
import br.com.codecode.workix.model.enums.JobCategory;
import br.com.codecode.workix.model.enums.JobType;
import br.com.codecode.workix.model.jpa.Company;
import br.com.codecode.workix.model.jpa.Job;

/**
 * This ManagedBean controls post-a-job.xhtml
 * @author felipe
 *
 */
@Model
public class PostAJobMB extends BaseMB {

	private static final long serialVersionUID = -196732177799463607L;

	@Inject @Generic
	private Crud<Job> dao;
	
	@Inject @Generic
	private Crud<Company> companyDao;

	@Inject
	private Job job;
	
	private DataModel<Estate> estates;
	
	private DataModel<JobType> jobTypes;
	
	private DataModel<JobCategory> jobCategories;
	
	private List<Company> employeers;	

	@PostConstruct
	private void init(){
			
		try {
			
			employeers = companyDao.listAll(0, 100);
			
		} catch (NotImplementedYetException e) {
			
			e.printStackTrace();
		}		
		
		estates = new ListDataModel<>(Arrays.asList(Estate.values()));
		
		jobTypes = new ListDataModel<>(Arrays.asList(JobType.values()));
		
		jobCategories = new ListDataModel<>(Arrays.asList(JobCategory.values()));

		debug();
	}

	private void debug() {
		if (job != null){
			job.setStart(Calendar.getInstance());
			job.setExpire(Calendar.getInstance());
			job.setActive(true);
			job.setCategory(JobCategory.OPERATOR);	
			job.setEmployeer(employeers.get(3));
			job.setDescription("WHATEVER TEXT ");			
		}

	}
	
	public DataModel<Estate> getEstates() {
		return estates;
	}

	public DataModel<JobType> getJobTypes() {
		return jobTypes;
	}

	public DataModel<JobCategory> getJobCategories() {
		return jobCategories;
	}

	public Job getJob() {
		return job;
	}

	public void setJob(Job currentJob) {
		this.job = currentJob;
	}
	
	public void commit(){		

		try {
			
			dao.save(job);
			
		} catch (NotImplementedYetException e) {

			e.printStackTrace();
		}		

	}

	public List<Company> getEmployeers() {
		return employeers;
	}

	
}
