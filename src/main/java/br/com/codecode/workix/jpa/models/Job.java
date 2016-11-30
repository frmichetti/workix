package br.com.codecode.workix.jpa.models;

import java.math.BigDecimal;

import javax.annotation.PostConstruct;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import br.com.codecode.workix.cdi.qualifiers.Persist;
import br.com.codecode.workix.jpa.enums.JobCategory;
import br.com.codecode.workix.jpa.enums.JobType;

/**
 * Job JPA with Inherited Fields and Methods
 * 
 * @author felipe
 * @since 1.0
 * @version 1.1
 * @see MyEntity
 * @see Job
 */
@Entity
@XmlRootElement
@XmlAccessorType(XmlAccessType.PUBLIC_MEMBER)
@Persist
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

    @Lob
    @Column(nullable = false)
    public String getBenefits() {
	return benefits;
    }

    @ManyToOne(optional = false)
    public Company getCompany() {
	return company;
    }

    @Lob
    @Column(nullable = false)
    public String getDescription() {
	return description;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false)
    @Override
    public long getId() {
	return this.id;
    }

    @Column
    @Enumerated(EnumType.STRING)
    public JobCategory getJobCategory() {
	return jobCategory;
    }

    @Column
    @Enumerated(EnumType.STRING)
    public JobType getJobType() {
	return jobType;
    }

    @Column
    public BigDecimal getMaxPayment() {
	return maxPayment;
    }

    @Column
    public BigDecimal getMinPayment() {
	return minPayment;
    }

    @Lob
    @Column(nullable = false)
    public String getRequirement() {
	return requirement;
    }

    @Column(nullable = false)
    public String getTitle() {
	return title;
    }

    /**
     * Initialize Fields for CDI Injection
     */
    @PostConstruct
    private void init() {
	minPayment = BigDecimal.ZERO;
	maxPayment = BigDecimal.ZERO;
	active = true;
    }

    @Column
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

    @Override
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