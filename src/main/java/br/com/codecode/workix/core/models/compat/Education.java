package br.com.codecode.workix.core.models.compat;

import java.io.Serializable;
import java.util.Calendar;
import javax.annotation.Generated;

// TODO: Auto-generated Javadoc
/**
 * Education Class for Compatibility
 * <br>Without Annotations .
 *
 * @author felipe
 * @version 1.1
 * @see Serializable
 * @since 1.1
 */
public class Education implements Serializable {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /** The description. */
    private String description;

    /** The end date. */
    private Calendar endDate;

    /** The qualification. */
    private String qualification;

    /** The school name. */
    private String schoolName;

    /** The start date. */
    private Calendar startDate;

    @Generated("SparkTools")
    private Education(Builder builder) {
	this.description = builder.description;
	this.endDate = builder.endDate;
	this.qualification = builder.qualification;
	this.schoolName = builder.schoolName;
	this.startDate = builder.startDate;
    }

    /**
     * Public Default Constructor.
     */
    public Education(){}
    
    /**
     * Gets the description.
     *
     * @return the description
     */
    public String getDescription() {
	return description;
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
     * Gets the qualification.
     *
     * @return the qualification
     */
    public String getQualification() {
	return qualification;
    }

    /**
     * Gets the school name.
     *
     * @return the school name
     */
    public String getSchoolName() {
	return schoolName;
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
     * Sets the end date.
     *
     * @param endDate the new end date
     */
    public void setEndDate(Calendar endDate) {
	this.endDate = endDate;
    }

    /**
     * Sets the qualification.
     *
     * @param qualification the new qualification
     */
    public void setQualification(String qualification) {
	this.qualification = qualification;
    }

    /**
     * Sets the school name.
     *
     * @param schoolName the new school name
     */
    public void setSchoolName(String schoolName) {
	this.schoolName = schoolName;
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
     * Creates builder to build {@link Education}.
     * @return created builder
     */
    @Generated("SparkTools")
    public static Builder builder() {

	return new Builder();
    }

    /**
     * Builder to build {@link Education}.
     */
    @Generated("SparkTools")
    public static final class Builder {

	private String description;

	private Calendar endDate;

	private String qualification;

	private String schoolName;

	private Calendar startDate;

	private Builder() {
	}

	public Builder withDescription(String description) {

	    this.description = description;
	    return this;
	}

	public Builder withEndDate(Calendar endDate) {

	    this.endDate = endDate;
	    return this;
	}

	public Builder withQualification(String qualification) {

	    this.qualification = qualification;
	    return this;
	}

	public Builder withSchoolName(String schoolName) {

	    this.schoolName = schoolName;
	    return this;
	}

	public Builder withStartDate(Calendar startDate) {

	    this.startDate = startDate;
	    return this;
	}

	public Education build() {

	    return new Education(this);
	}
    }    
}
