package br.com.codecode.workix.model.scaffold;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Lob;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Experience JPA {@link Embeddable}
 * @author felipe
 * @since 1.1
 * @version 1.1
 * @see Serializable
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@Embeddable
abstract class Experience implements Serializable {

	private static final long serialVersionUID = -6311235469498858665L;
	
	@Column
	private String employerName;

	@Column
	private String jobTitle;
	
	@Temporal(TemporalType.DATE)
	@Column	
	private Calendar startDate;

	@Temporal(TemporalType.DATE)
	@Column	
	private Calendar endDate;

	@Lob
	@Column	
	private String description;

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
