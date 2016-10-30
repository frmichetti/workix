package br.com.codecode.workix.model.scaffold;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Lob;

import com.google.gson.annotations.Expose;

@Embeddable
public class Education implements Serializable {

	private static final long serialVersionUID = -1514012744160609145L;

	@Expose
	@Column
	private String schoolName;
	
	@Expose
	@Column
	private Date startDate,endDate;
	
	@Expose
	@Column
	private String qualification;
	
	@Expose
	@Column
	@Lob
	private String description;
	
	public Education(){}	

	public Education(String schoolName, Date startDate, Date endDate, String qualification) {
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

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
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
