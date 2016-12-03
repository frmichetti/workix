package br.com.codecode.workix.core.models.compat;

import java.io.Serializable;
import java.time.LocalDate;

import br.com.codecode.workix.core.models.jdk8.root.BaseExperience;
import br.com.codecode.workix.interfaces.Buildable;

/**
 * Experience JPA with Inherited Fields and Methods
 * <br>Without Annotations
 * @author felipe
 * @since 1.1
 * @version 1.1
 * @see Serializable
 */
public class Experience implements Serializable {

    /**
     * Builder NestedClass for {@link Experience}
     * 
     * @author felipe
     * @since 1.0
     * @version 1.0
     * @see Buildable
     * @see BaseExperience
     */
    public final static class Builder extends Experience implements Buildable<Experience> {

	private static final long serialVersionUID = -1322208401535756846L;

	/**
	 * Disabled Empty Constructor
	 */
	private Builder() {
	}

	/**
	 * Constructor with Required Fields
	 * 
	 * @param employerName
	 *            Employer Name
	 * @param jobTitle
	 *            Job Title
	 */
	public Builder(String employerName, String jobTitle) {
	    this();
	    this.setEmployerName(employerName);
	    this.setJobTitle(jobTitle);
	}

	/**
	 * Constructor with All Fields
	 * 
	 * @param employerName
	 *            Employer Name
	 * @param jobTitle
	 *            Job Title
	 * @param startDate
	 *            Start Date
	 * @param endDate
	 *            End Date
	 */
	public Builder(String employerName, String jobTitle, LocalDate startDate, LocalDate endDate) {
	    this(employerName, jobTitle);
	    this.setStartDate(startDate);
	    this.setEndDate(endDate);
	}

	/**
	 * @return Return a new Experience
	 */
	@Override
	public Experience build() {

	    return new Experience(this);
	}

	/**
	 * @param description
	 *            the description to set
	 * @return Builder
	 */
	public Builder withDescription(String description) {
	    this.setDescription(description);
	    return this;
	}

	/**
	 * @param employerName
	 *            the employerName to set
	 * @return Builder
	 */
	public Builder withEmployerName(String employerName) {
	    this.setEmployerName(employerName);
	    return this;
	}

	/**
	 * @param endDate
	 *            the endDate to set
	 * @return Builder
	 */
	public Builder withEndDate(LocalDate endDate) {
	    this.setEndDate(endDate);
	    return this;
	}

	/**
	 * @param jobTitle
	 *            the jobTitle to set
	 * @return Builder
	 */
	public Builder withJobTitle(String jobTitle) {
	    this.setJobTitle(jobTitle);
	    return this;
	}

	/**
	 * @param startDate
	 *            the startDate to set
	 * @return Builder
	 */
	public Builder withStartDate(LocalDate startDate) {
	    this.setStartDate(startDate);
	    return this;
	}

    }

    private static final long serialVersionUID = -6311235469498858665L;

    private String employerName;

    private String jobTitle;

    private LocalDate startDate;

    private LocalDate endDate;

    private String description;

    /**
     * Public Default Constructor for JPA Compatibility Only
     */
    public Experience() {
    }

    /**
     * Public Constructor for {@link Builder} Compatibility
     * 
     * @see Buildable
     * @param builder
     *            Builder for Generate a New Experience
     */
    public Experience(Builder builder) {

	this.employerName = builder.getEmployerName();

	this.jobTitle = builder.getJobTitle();

	this.startDate = builder.getStartDate();

	this.endDate = builder.getEndDate();

    }

    public String getDescription() {
	return description;
    }

    public String getEmployerName() {
	return employerName;
    }

    public LocalDate getEndDate() {
	return endDate;
    }

    public String getJobTitle() {
	return jobTitle;
    }

    public LocalDate getStartDate() {
	return startDate;
    }

    public void setDescription(String description) {
	this.description = description;
    }

    public void setEmployerName(String employerName) {
	this.employerName = employerName;
    }

    public void setEndDate(LocalDate endDate) {
	this.endDate = endDate;
    }

    public void setJobTitle(String jobTitle) {
	this.jobTitle = jobTitle;
    }

    public void setStartDate(LocalDate startDate) {
	this.startDate = startDate;
    }

}
