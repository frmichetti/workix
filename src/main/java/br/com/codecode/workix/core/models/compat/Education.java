package br.com.codecode.workix.core.models.compat;

import java.io.Serializable;
import java.time.LocalDate;

import br.com.codecode.workix.interfaces.Buildable;

/**
 * Education JPA with Inherited Fields and Methods
 * <br>Without Annotations
 * @author felipe
 * @since 1.1
 * @version 1.1
 * @see Serializable
 */
public class Education implements Serializable {

    /**
     * Builder NestedClass for {@link Education}
     * 
     * @author felipe
     * @since 1.0
     * @version 1.0
     */
    public static class Builder extends Education implements Buildable<Education> {

	private static final long serialVersionUID = 3075237483868037001L;

	/**
	 * Disabled Empty Constructor
	 */
	private Builder() {
	}

	/**
	 * Minimal Constructor with Required Fields
	 * 
	 * @param schoolName
	 *            School Name
	 * @param startDate
	 *            Start Date
	 */
	public Builder(String schoolName, LocalDate startDate) {
	    this();
	    this.setSchoolName(schoolName);
	    this.setStartDate(startDate);
	}

	/**
	 * Constructor with All Fields
	 * 
	 * @param schoolName
	 *            School Name
	 * @param startDate
	 *            Start Date
	 * @param endDate
	 *            End Date
	 * @param qualification
	 *            Qualification
	 * @param description
	 *            Description
	 */
	public Builder(String schoolName, LocalDate startDate, LocalDate endDate, String qualification,
		String description) {
	    this(schoolName, startDate);
	    this.setEndDate(endDate);
	    this.setQualification(qualification);
	    this.setDescription(description);
	}

	/**
	 * @return Return a new Education
	 */
	@Override
	public Education build() {
	    return new Education(this);
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
	 * @param endDate
	 *            the endDate to set
	 * @return Builder
	 */
	public Builder withEndDate(LocalDate endDate) {
	    this.setEndDate(endDate);
	    return this;
	}

	/**
	 * @param qualification
	 *            the qualification to set
	 * @return Builder
	 */
	public Builder withQualification(String qualification) {
	    this.setQualification(qualification);
	    return this;
	}

	/**
	 * @param schoolName
	 *            the schoolName to set
	 * @return Builder
	 */
	public Builder withSchoolName(String schoolName) {
	    this.setSchoolName(schoolName);
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

    private static final long serialVersionUID = -1514012744160609145L;

    private String schoolName;

    private LocalDate startDate;

    private LocalDate endDate;

    private String qualification;

    private String description;

    /**
     * Public Default Constructor for JPA Compatibility Only
     */
    public Education() {
    }

    /**
     * Public Constructor for {@link Builder} Compatibility
     * 
     * @see Buildable
     * @param builder
     *            Builder for Generate a new Education
     */
    public Education(Builder builder) {
	this.schoolName = builder.getSchoolName();
	this.startDate = builder.getStartDate();
	this.endDate = builder.getEndDate();
	this.qualification = builder.getQualification();
	this.description = builder.getDescription();
    }

    public String getDescription() {
	return description;
    }

    public LocalDate getEndDate() {
	return endDate;
    }

    public String getQualification() {
	return qualification;
    }

    public String getSchoolName() {
	return schoolName;
    }

    public LocalDate getStartDate() {
	return startDate;
    }

    public void setDescription(String description) {
	this.description = description;
    }

    public void setEndDate(LocalDate endDate) {
	this.endDate = endDate;
    }

    public void setQualification(String qualification) {
	this.qualification = qualification;
    }

    public void setSchoolName(String schoolName) {
	this.schoolName = schoolName;
    }

    public void setStartDate(LocalDate startDate) {
	this.startDate = startDate;
    }

}
