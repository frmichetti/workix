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

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@Embeddable
public class Education implements Serializable {

	private static final long serialVersionUID = -1514012744160609145L;

	@Column
	private String schoolName;

	@Temporal(TemporalType.DATE)
	@Column	
	private Calendar startDate;

	@Temporal(TemporalType.DATE)
	@Column	
	private Calendar endDate;

	@Column
	private String qualification;

	@Lob
	@Column	
	private String description;

	public Education(){}	

	public Education(String schoolName, Calendar startDate, Calendar endDate, String qualification) {
		super();
		this.schoolName = schoolName;
		this.startDate = startDate;
		this.endDate = endDate;
		this.qualification = qualification;
	}	

	public String getSchoolName() {
		return schoolName;
	}

	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
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

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}


}
