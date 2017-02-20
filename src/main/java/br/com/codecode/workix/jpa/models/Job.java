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
import javax.xml.bind.annotation.XmlTransient;

import br.com.codecode.workix.cdi.qualifiers.Persist;
import br.com.codecode.workix.core.enums.JobCategory;
import br.com.codecode.workix.core.enums.JobType;
import br.com.codecode.workix.interfaces.Buildable;

/**
 * Job JPA with Inherited Fields and Methods
 * 
 * @author felipe
 * @since 1.0
 * @version 1.1
 * @see MyEntity
 */
@Entity
@XmlRootElement
@XmlAccessorType(XmlAccessType.PUBLIC_MEMBER)
@Persist
public class Job extends MyEntity {

    /**
     * @serialField
     */
    private static final long serialVersionUID = 2246753300384053586L;

    private boolean active;

    /**
     * Many {@link Job} To One {@link Company}
     */
    private Company company;

    private long id;

    private JobCategory jobCategory;

    private JobType jobType;

    private BigDecimal minPayment, maxPayment;

    private String title, description, requirement, benefits;

    /**
     * Public Default Constructor for JPA Compatibility Only
     */
    public Job(){}

    private Job(Builder builder) {
	this.id = builder.getId();
	this.active = builder.isActive();
	this.title = builder.getTitle();
	this.description = builder.getDescription();
	this.requirement = builder.getRequirement();
	this.benefits = builder.getBenefits();
	this.minPayment = builder.getMinPayment();
	this.maxPayment = builder.getMaxPayment();
	this.jobType = builder.getJobType();
	this.jobCategory = builder.getJobCategory();
	this.company = builder.getCompany();
    }

    /**
     * Creates builder to build {@link Job}.
     * @return created builder
     */
    @XmlTransient
    public static Builder builder() {
	return new Builder();
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

    /**
     * Builder to build {@link Job}.
     */    
    public static final class Builder extends Job implements Buildable<Job> {

	/**
	 * @serialField 
	 */
	private static final long serialVersionUID = -2178589087775440695L;	

	private Builder(){}

	public Job build() {
	    return new Job(this);
	}

	public Builder withActive(boolean active) {
	    super.active = active;
	    return this;
	}

	public Builder withBenefits(String benefits) {
	    super.benefits = benefits;
	    return this;
	}

	public Builder withCompany(Company company) {
	    super.company = company;
	    return this;
	}

	public Builder withDescription(String description) {
	    super.description = description;
	    return this;
	}

	public Builder withId(long id) {
	    super.id = id;
	    return this;
	}

	public Builder withJobCategory(JobCategory jobCategory) {
	    super.jobCategory = jobCategory;
	    return this;
	}

	public Builder withJobType(JobType jobType) {
	    super.jobType = jobType;
	    return this;
	}

	public Builder withMaxPayment(BigDecimal maxPayment) {
	    super.maxPayment = maxPayment;
	    return this;
	}

	public Builder withMinPayment(BigDecimal minPayment) {
	    super.minPayment = minPayment;
	    return this;
	}

	public Builder withRequirement(String requirement) {
	    super.requirement = requirement;
	    return this;
	}

	public Builder withTitle(String title) {
	    super.title = title;
	    return this;
	}
    }

}