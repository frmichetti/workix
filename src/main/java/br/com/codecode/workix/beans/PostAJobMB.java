package br.com.codecode.workix.beans;

import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.inject.Inject;

import br.com.codecode.workix.cdi.dao.Crud;
import br.com.codecode.workix.cdi.qualifiers.Generic;
import br.com.codecode.workix.cdi.qualifiers.Persist;
import br.com.codecode.workix.core.exceptions.NotImplementedYetException;
import br.com.codecode.workix.core.models.enums.Estate;
import br.com.codecode.workix.core.models.enums.JobCategory;
import br.com.codecode.workix.core.models.enums.JobType;
import br.com.codecode.workix.jpa.models.Company;
import br.com.codecode.workix.jpa.models.Job;

/**
 * This ManagedBean controls post-a-job.xhtml
 * 
 * @author felipe
 * @since 1.0
 * @version 1.1
 * @see BaseMB
 */
@Model
public class PostAJobMB extends BaseMB {

    @Inject
    @Generic
    private Crud<Job> dao;

    @Inject
    @Generic
    private Crud<Company> companyDao;

    @Inject @Persist
    private Job job;

    private DataModel<Estate> estates;

    private DataModel<JobType> jobTypes;

    private DataModel<JobCategory> jobCategories;

    private List<Company> employeers;

    @PostConstruct
    @Override
    protected void init() {

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
	if (job != null) {
	    job.setActive(true);
	    job.setJobCategory(JobCategory.OPERATOR);
	    job.setCompany(employeers.get(3));
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

    public void commit() {

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
