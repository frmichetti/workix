package br.com.codecode.workix.model.base;

import java.time.LocalDate;

/**
 * Root Abstract Class Experience<br>
 * Use for Field Mapping/Share Only
 * <ul>
 * <li>{@link #employerName}</li>
 * <li>{@link #jobTitle}</li>
 * <li>{@link #startDate}</li>
 * <li>{@link #endDate}</li>
 * <li>{@link #description}</li>
 * </ul>
 * 
 * @author felipe
 * @since 1.0
 * @version 1.0
 */
public abstract class BaseExperience {

    private String employerName;

    private String jobTitle;

    private LocalDate startDate;

    private LocalDate endDate;

    private String description;

    /**
     * Empty Default Constructor
     */
    public BaseExperience() {
    }

    /**
     * @return the employerName
     */
    public String getEmployerName() {
	return employerName;
    }

    /**
     * @param employerName
     *            the employerName to set
     */
    public void setEmployerName(String employerName) {
	this.employerName = employerName;
    }

    /**
     * @return the jobTitle
     */
    public String getJobTitle() {
	return jobTitle;
    }

    /**
     * @param jobTitle
     *            the jobTitle to set
     */
    public void setJobTitle(String jobTitle) {
	this.jobTitle = jobTitle;
    }

    /**
     * @return the startDate
     */
    public LocalDate getStartDate() {
	return startDate;
    }

    /**
     * @param startDate
     *            the startDate to set
     */
    public void setStartDate(LocalDate startDate) {
	this.startDate = startDate;
    }

    /**
     * @return the endDate
     */
    public LocalDate getEndDate() {
	return endDate;
    }

    /**
     * @param endDate
     *            the endDate to set
     */
    public void setEndDate(LocalDate endDate) {
	this.endDate = endDate;
    }

    /**
     * @return the description
     */
    public String getDescription() {
	return description;
    }

    /**
     * @param description
     *            the description to set
     */
    public void setDescription(String description) {
	this.description = description;
    }

}
