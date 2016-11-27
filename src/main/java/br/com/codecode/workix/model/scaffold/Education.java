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
 * Education JPA {@link Embeddable} 
 * @author felipe
 * @since 1.1
 * @version 1.1
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@Embeddable
abstract class Education implements Serializable {

	private static final long serialVersionUID = -1514012744160609145L;

	@Column
	private String schoolName;

	@Temporal(TemporalType.DATE)
	@Column	
	private Calendar startDate;

	@Temporal(TemporalType.DATE)
	@Column	
	private Calendar endDate;

	@Lob
	@Column
	private String qualification;

	@Lob
	@Column	
	private String description;

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
