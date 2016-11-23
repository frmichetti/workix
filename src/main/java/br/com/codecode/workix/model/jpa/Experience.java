package br.com.codecode.workix.model.jpa;

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
 * @category JPA
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@Embeddable
public class Experience implements Serializable {

	private static final long serialVersionUID = -6311235469498858665L;
	
	@Column
	private String employerName;

	@Column
	private String jobTitle;

	@Column
	@Temporal(TemporalType.DATE)
	private Calendar startDate;

	@Column
	@Temporal(TemporalType.DATE)
	private Calendar endDate;

	@Column
	@Lob
	private String description;

	/**
	 * Public Default Constructor for JPA Compatibility Only
	 */
	public Experience(){}	

	public Experience(String employerName, String jobTitle, Calendar startDate, Calendar endDate) {
		super();
		this.employerName = employerName;
		this.jobTitle = jobTitle;
		this.startDate = startDate;
		this.endDate = endDate;
	}	

	public String getEmployerName() {
		return employerName;
	}
	
	public void setEmployerName(String employerName) {
		this.employerName = employerName;
	}
	
	public String getJobTitle() {
		return jobTitle;
	}
	
	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}
	
	public Calendar getStartDate() {
		return startDate;
	}
	
	public void setStartDate(Calendar startDate) {
		this.startDate = startDate;
	}
	
	public Calendar getEndDate() {
		return endDate;
	}
	
	public void setEndDate(Calendar endDate) {
		this.endDate = endDate;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}

}
