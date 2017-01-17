package br.com.codecode.workix.core.models.compat;

import java.io.Serializable;
import java.util.Calendar;
import javax.annotation.Generated;

// TODO: Auto-generated Javadoc
/**
 * Experience Class for Compatibility
 * <br>Without Annotations.
 *
 * @author felipe
 * @version 1.1
 * @see Serializable
 * @since 1.1
 */
public class Experience implements Serializable {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /** The description. */
    private String description;

    /** The employer name. */
    private String employerName;

    /** The end date. */
    private Calendar endDate;

    /** The job title. */
    private String jobTitle;

    /** The start date. */
    private Calendar startDate;

    @Generated("SparkTools")
    private Experience(Builder builder) {
	this.description = builder.description;
	this.employerName = builder.employerName;
	this.endDate = builder.endDate;
	this.jobTitle = builder.jobTitle;
	this.startDate = builder.startDate;
    }

    /**
     * Public Default Constructor.
     */
    public Experience(){}   

    /**
     * Gets the description.
     *
     * @return the description
     */
    public String getDescription() {
	return description;
    }

    /**
     * Gets the employer name.
     *
     * @return the employer name
     */
    public String getEmployerName() {
	return employerName;
    }

    /**
     * Gets the end date.
     *
     * @return the end date
     */
    public Calendar getEndDate() {
	return endDate;
    }

    /**
     * Gets the job title.
     *
     * @return the job title
     */
    public String getJobTitle() {
	return jobTitle;
    }

    /**
     * Gets the start date.
     *
     * @return the start date
     */
    public Calendar getStartDate() {
	return startDate;
    }

    /**
     * Sets the description.
     *
     * @param description the new description
     */
    public void setDescription(String description) {
	this.description = description;
    }

    /**
     * Sets the employer name.
     *
     * @param employerName the new employer name
     */
    public void setEmployerName(String employerName) {
	this.employerName = employerName;
    }

    /**
     * Sets the end date.
     *
     * @param endDate the new end date
     */
    public void setEndDate(Calendar endDate) {
	this.endDate = endDate;
    }

    /**
     * Sets the job title.
     *
     * @param jobTitle the new job title
     */
    public void setJobTitle(String jobTitle) {
	this.jobTitle = jobTitle;
    }

    /**
     * Sets the start date.
     *
     * @param startDate the new start date
     */
    public void setStartDate(Calendar startDate) {
	this.startDate = startDate;
    }

    /**
     * Creates builder to build {@link Experience}.
     * @return created builder
     */
    @Generated("SparkTools")
    public static Builder builder() {

	return new Builder();
    }

    /**
     * Builder to build {@link Experience}.
     */
    @Generated("SparkTools")
    public static final class Builder {

	private String description;

	private String employerName;

	private Calendar endDate;

	private String jobTitle;

	private Calendar startDate;

	private Builder() {
	}

	public Builder withDescription(String description) {

	    this.description = description;
	    return this;
	}

	public Builder withEmployerName(String employerName) {

	    this.employerName = employerName;
	    return this;
	}

	public Builder withEndDate(Calendar endDate) {

	    this.endDate = endDate;
	    return this;
	}

	public Builder withJobTitle(String jobTitle) {

	    this.jobTitle = jobTitle;
	    return this;
	}

	public Builder withStartDate(Calendar startDate) {

	    this.startDate = startDate;
	    return this;
	}

	public Experience build() {

	    return new Experience(this);
	}
    }    

}
