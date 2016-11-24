package br.com.codecode.workix.model.root;

import java.util.Calendar;

/**
 * Root Abstract Class Skill<br>
 * Use for Field Mapping/Share Only
 * <ul>
 * <li>{@link #employerName}</li>
 * <li>{@link #jobTitle}</li>
 * <li>{@link #startDate}</li>
 * <li>{@link #endDate}</li>
 * <li>{@link #description}</li>
 * </ul>
 * @author felipe
 * @since 1.0
 * @version 1.0
 */
public abstract class RootExperience {
	
	private String employerName;

	private String jobTitle;
	
	private Calendar startDate;

	private Calendar endDate;

	private String description;
	
	/**
	 * Empty Default Constructor
	 */
	public RootExperience(){}

	/**
	 * @return the employerName
	 */
	public final String getEmployerName() {
		return employerName;
	}

	/**
	 * @param employerName the employerName to set
	 */
	public final void setEmployerName(String employerName) {
		this.employerName = employerName;
	}

	/**
	 * @return the jobTitle
	 */
	public final String getJobTitle() {
		return jobTitle;
	}

	/**
	 * @param jobTitle the jobTitle to set
	 */
	public final void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
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
