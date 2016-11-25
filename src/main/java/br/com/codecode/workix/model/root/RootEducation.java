package br.com.codecode.workix.model.root;

import java.util.Calendar;

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
 * @author felipe
 * @since 1.0
 * @version 1.0
 */
public abstract class RootEducation {
	
	private String schoolName;

	private Calendar startDate;

	private Calendar endDate;

	private String qualification;

	private String description;
	
	/**
	 * Default Empty Constructor
	 */
	public RootEducation(){}

	/**
	 * @return the schoolName
	 */
	public final String getSchoolName() {
		return schoolName;
	}

	/**
	 * @param schoolName the schoolName to set
	 */
	public final void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}

	/**
	 * @return the startDate
	 */
	public final Calendar getStartDate() {
		return startDate;
	}

	/**
	 * @param startDate the startDate to set
	 */
	public final void setStartDate(Calendar startDate) {
		this.startDate = startDate;
	}

	/**
	 * @return the endDate
	 */
	public final Calendar getEndDate() {
		return endDate;
	}

	/**
	 * @param endDate the endDate to set
	 */
	public final void setEndDate(Calendar endDate) {
		this.endDate = endDate;
	}

	/**
	 * @return the qualification
	 */
	public final String getQualification() {
		return qualification;
	}

	/**
	 * @param qualification the qualification to set
	 */
	public final void setQualification(String qualification) {
		this.qualification = qualification;
	}

	/**
	 * @return the description
	 */
	public final String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public final void setDescription(String description) {
		this.description = description;
	}	
	
}
