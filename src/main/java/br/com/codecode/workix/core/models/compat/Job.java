package br.com.codecode.workix.core.models.compat;

import java.math.BigDecimal;

import br.com.codecode.workix.core.enums.JobCategory;
import br.com.codecode.workix.core.enums.JobType;
import javax.annotation.Generated;

// TODO: Auto-generated Javadoc
/**
 * Job Class for Compatibility<br>
 * Without Annotations.
 *
 * @author felipe
 * @version 1.1
 * @see MyEntity
 * @since 1.1
 */
public class Job extends MyEntity {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /** The active. */
    private boolean active;

    /** Many {@link Job} To One {@link Company}. */
    private Company company;

    /** The id. */
    private long id;

    /** The job category. */
    private JobCategory jobCategory;

    /** The job type. */
    private JobType jobType;

    /** The max payment. */
    private BigDecimal minPayment, maxPayment;

    /** The benefits. */
    private String title, description, requirement, benefits;

    @Generated("SparkTools")
    private Job(Builder builder) {
	this.active = builder.active;
	this.company = builder.company;
	this.id = builder.id;
	this.jobCategory = builder.jobCategory;
	this.jobType = builder.jobType;
	this.minPayment = builder.minPayment;
	this.maxPayment = builder.maxPayment;
	this.title = builder.title;
	this.description = builder.description;
	this.requirement = builder.requirement;
	this.benefits = builder.benefits;
    }

    /**
     * Public Default Constructor.
     */
    public Job(){}

    /**
     * Gets the benefits.
     *
     * @return the benefits
     */
    public String getBenefits() {
	return benefits;
    }

    /**
     * Gets the company.
     *
     * @return the company
     */
    public Company getCompany() {
	return company;
    }

    /**
     * Gets the description.
     *
     * @return the description
     */
    public String getDescription() {
	return description;
    }

    /**
     * Gets the id.
     *
     * @return the id
     */
    public long getId() {
	return this.id;
    }

    /**
     * Gets the job category.
     *
     * @return the job category
     */
    public JobCategory getJobCategory() {
	return jobCategory;
    }

    /**
     * Gets the job type.
     *
     * @return the job type
     */
    public JobType getJobType() {
	return jobType;
    }

    /**
     * Gets the max payment.
     *
     * @return the max payment
     */
    public BigDecimal getMaxPayment() {
	return maxPayment;
    }

    /**
     * Gets the min payment.
     *
     * @return the min payment
     */
    public BigDecimal getMinPayment() {
	return minPayment;
    }

    /**
     * Gets the requirement.
     *
     * @return the requirement
     */
    public String getRequirement() {
	return requirement;
    }

    /**
     * Gets the title.
     *
     * @return the title
     */
    public String getTitle() {
	return title;
    }

    /**
     * Initialize Fields.
     */
    protected void init() {
	minPayment = BigDecimal.ZERO;
	maxPayment = BigDecimal.ZERO;
	active = true;
    }

    /**
     * Checks if is active.
     *
     * @return true, if is active
     */
    public boolean isActive() {
	return active;
    }

    /**
     * Sets the active.
     *
     * @param active the new active
     */
    public void setActive(boolean active) {
	this.active = active;
    }

    /**
     * Sets the benefits.
     *
     * @param benefits the new benefits
     */
    public void setBenefits(String benefits) {
	this.benefits = benefits;
    }

    /**
     * Sets the company.
     *
     * @param employeer the new company
     */
    public void setCompany(Company employeer) {
	this.company = employeer;
    }

    /**
     * Sets the description.
     *
     * @param resume the new description
     */
    public void setDescription(String resume) {
	this.description = resume;
    }

    /**
     * Sets the id.
     *
     * @param id the new id
     */
    public void setId(long id) {
	this.id = id;
    }

    /**
     * Sets the job category.
     *
     * @param category the new job category
     */
    public void setJobCategory(JobCategory category) {
	this.jobCategory = category;
    }

    /**
     * Sets the job type.
     *
     * @param type the new job type
     */
    public void setJobType(JobType type) {
	this.jobType = type;
    }

    /**
     * Sets the max payment.
     *
     * @param maxPayment the new max payment
     */
    public void setMaxPayment(BigDecimal maxPayment) {
	this.maxPayment = maxPayment;
    }

    /**
     * Sets the min payment.
     *
     * @param minPayment the new min payment
     */
    public void setMinPayment(BigDecimal minPayment) {
	this.minPayment = minPayment;
    }

    /**
     * Sets the requirement.
     *
     * @param requirement the new requirement
     */
    public void setRequirement(String requirement) {
	this.requirement = requirement;
    }

    /**
     * Sets the title.
     *
     * @param title the new title
     */
    public void setTitle(String title) {
	this.title = title;
    }

    /**
     * Creates builder to build {@link Job}.
     * @return created builder
     */
    @Generated("SparkTools")
    public static Builder builder() {

	return new Builder();
    }

    /**
     * Builder to build {@link Job}.
     */
    @Generated("SparkTools")
    public static final class Builder {

	private boolean active;

	private Company company;

	private long id;

	private JobCategory jobCategory;

	private JobType jobType;

	private BigDecimal minPayment;

	private BigDecimal maxPayment;

	private String title;

	private String description;

	private String requirement;

	private String benefits;

	private Builder() {
	}

	public Builder withActive(boolean active) {

	    this.active = active;
	    return this;
	}

	public Builder withCompany(Company company) {

	    this.company = company;
	    return this;
	}

	public Builder withId(long id) {

	    this.id = id;
	    return this;
	}

	public Builder withJobCategory(JobCategory jobCategory) {

	    this.jobCategory = jobCategory;
	    return this;
	}

	public Builder withJobType(JobType jobType) {

	    this.jobType = jobType;
	    return this;
	}

	public Builder withMinPayment(BigDecimal minPayment) {

	    this.minPayment = minPayment;
	    return this;
	}

	public Builder withMaxPayment(BigDecimal maxPayment) {

	    this.maxPayment = maxPayment;
	    return this;
	}

	public Builder withTitle(String title) {

	    this.title = title;
	    return this;
	}

	public Builder withDescription(String description) {

	    this.description = description;
	    return this;
	}

	public Builder withRequirement(String requirement) {

	    this.requirement = requirement;
	    return this;
	}

	public Builder withBenefits(String benefits) {

	    this.benefits = benefits;
	    return this;
	}

	public Job build() {

	    return new Job(this);
	}
    }

}