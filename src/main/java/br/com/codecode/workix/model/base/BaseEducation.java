package br.com.codecode.workix.model.base;

import java.time.LocalDate;

/**
 * Root Abstract Class Education<br>
 * Use for Field Mapping/Share Only
 * <ul>
 * <li>{@link #schoolName}</li>
 * <li>{@link #startDate}</li>
 * <li>{@link #endDate}</li>
 * <li>{@link #qualification}</li>
 * <li>{@link #description}</li>
 * </ul>
 * 
 * @author felipe
 * @since 1.0
 * @version 1.0
 */
public abstract class BaseEducation {

    private String schoolName;

    private LocalDate startDate;

    private LocalDate endDate;

    private String qualification;

    private String description;

    /**
     * Default Empty Constructor
     */
    public BaseEducation() {
    }

    /**
     * @return the schoolName
     */
    public String getSchoolName() {
	return schoolName;
    }

    /**
     * @param schoolName
     *            the schoolName to set
     */
    public void setSchoolName(String schoolName) {
	this.schoolName = schoolName;
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
     * @return the qualification
     */
    public String getQualification() {
	return qualification;
    }

    /**
     * @param qualification
     *            the qualification to set
     */
    public void setQualification(String qualification) {
	this.qualification = qualification;
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
