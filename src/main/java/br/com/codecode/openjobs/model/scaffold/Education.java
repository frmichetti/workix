package br.com.codecode.openjobs.model.scaffold;

import java.util.Date;

public class Education {
	
	private String schoolName;
	
	private Date startDate,endDate;
	
	private String qualification;
	
	public Education() {
		// TODO Auto-generated constructor stub
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
	
	
	
	
	
}
