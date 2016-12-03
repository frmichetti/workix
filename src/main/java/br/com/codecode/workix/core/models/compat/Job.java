package br.com.codecode.workix.core.models.compat;

import java.math.BigDecimal;

import br.com.codecode.workix.core.enums.JobCategory;
import br.com.codecode.workix.core.enums.JobType;

/**
 * Job JPA with Inherited Fields and Methods
 * <br>Without Annotations
 * @author felipe
 * @since 1.1
 * @version 1.1
 * @see MyEntity
 */
public class Job extends MyEntity {

    private static final long serialVersionUID = 2246753300384053586L;

    private long id;

    private boolean active;

    private String title, description, requirement, benefits;

    private BigDecimal minPayment, maxPayment;

    private JobType jobType;

    private JobCategory jobCategory;

    /**
     * Many {@link Job} To One {@link Company}
     */
    private Company company;

    /**
     * Public Default Constructor for JPA Compatibility Only
     */
    public Job() {
    }

    public String getBenefits() {
	return benefits;
    }

    public Company getCompany() {
	return company;
    }

    public String getDescription() {
	return description;
    }

    public long getId() {
	return this.id;
    }

    public JobCategory getJobCategory() {
	return jobCategory;
    }

    public JobType getJobType() {
	return jobType;
    }

    public BigDecimal getMaxPayment() {
	return maxPayment;
    }

    public BigDecimal getMinPayment() {
	return minPayment;
    }

    public String getRequirement() {
	return requirement;
    }

    public String getTitle() {
	return title;
    }

    /**
     * Initialize Fields for CDI Injection
     */
    private void init() {
	minPayment = BigDecimal.ZERO;
	maxPayment = BigDecimal.ZERO;
	active = true;
    }

    public boolean isActive() {
	return active;
    }

    public void setActive(boolean active) {
	this.active = active;
    }

    public void setBenefits(String benefits) {
	this.benefits = benefits;
    }

    public void setCompany(Company employeer) {
	this.company = employeer;
    }

    public void setDescription(String resume) {
	this.description = resume;
    }

    public void setId(long id) {
	this.id = id;
    }

    public void setJobCategory(JobCategory category) {
	this.jobCategory = category;
    }

    public void setJobType(JobType type) {
	this.jobType = type;
    }

    public void setMaxPayment(BigDecimal maxPayment) {
	this.maxPayment = maxPayment;
    }

    public void setMinPayment(BigDecimal minPayment) {
	this.minPayment = minPayment;
    }

    public void setRequirement(String requirement) {
	this.requirement = requirement;
    }

    public void setTitle(String title) {
	this.title = title;
    }

}