package br.com.codecode.workix.jpa.models;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Lob;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import br.com.codecode.workix.interfaces.Buildable;
import br.com.codecode.workix.model.actions.EducationActions;

/**
 * Education JPA with Inherited Fields and Methods
 * 
 * @author felipe
 * @since 1.0
 * @version 1.1
 * @see EducationActions
 * @see Serializable
 */
@Embeddable
@XmlRootElement
@XmlAccessorType(XmlAccessType.PUBLIC_MEMBER)
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

    @Column
    private String schoolName;

    @Column
    private LocalDate startDate;

    @Column
    private LocalDate endDate;

    @Lob
    @Column
    private String qualification;

    @Lob
    @Column
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
