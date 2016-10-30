package br.com.codecode.workix.model.scaffold;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import com.google.gson.annotations.Expose;

@Embeddable
public class Experience implements Serializable {

	private static final long serialVersionUID = -6311235469498858665L;

	@Expose	
	@Column
	private String employerName;
	
	@Expose
	@Column
	private String jobTitle;
	
	@Expose
	@Column
	private Date startDate;
	
	@Expose
	@Column
	private Date endDate;
	
	public Experience(){}	

	public Experience(String employerName, String jobTitle, Date startDate, Date endDate) {
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
	
	
	
	
}
