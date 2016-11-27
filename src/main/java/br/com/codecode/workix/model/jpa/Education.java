package br.com.codecode.workix.model.jpa;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Lob;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import br.com.codecode.workix.interfaces.Buildable;
import br.com.codecode.workix.model.base.BaseEducation;
import br.com.codecode.workix.model.root.RootEducation;

/**
 * Education JPA with Inherited Fields and Methods
 * @author felipe
 * @since 1.0
 * @version 1.1
 * @see BaseEducation
 * @see Serializable
 */
public class Education implements BaseEducation, Serializable {

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
	 * Public Default Constructor for JPA Compatibility Only
	 */
	public Education(){}	

	/**
	 * Public Constructor for {@link Builder} Compatibility
	 * @see Buildable
	 * @param builder Builder for Generate a new Education
	 */
	public Education(@NotNull Builder builder) {
		this.schoolName = builder.getSchoolName();
		this.startDate = builder.getStartDate();
		this.endDate = builder.getEndDate();
		this.qualification = builder.getQualification();
		this.description = builder.getDescription();
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

	/**
	 * Builder NestedClass for {@link Education} 
	 * @author felipe
	 * @since 1.0
	 * @version 1.0
	 */
	public static class Builder extends RootEducation implements Buildable<Education> {	

		/**
		 * Disabled Empty Constructor
		 */
		private Builder(){}		

		/**
		 * Minimal Constructor with Required Fields
		 * @param schoolName School Name
		 * @param startDate Start Date
		 */
		public Builder(String schoolName,Calendar startDate) {
			this();			
			this.setSchoolName(schoolName);
			this.setStartDate(startDate);
		}		

		/**
		 * Constructor with All Fields
		 * @param schoolName School Name
		 * @param startDate Start Date
		 * @param endDate End Date
		 * @param qualification Qualification
		 * @param description Description
		 */
		public Builder(String schoolName, Calendar startDate, Calendar endDate, String qualification, String description) {			
			this(schoolName,startDate);			
			this.setEndDate(endDate);
			this.setQualification(qualification);
			this.setDescription(description);
		}			
		
		/**
		 * @param schoolName the schoolName to set
		 * @return Builder
		 */
		public Builder withSchoolName(String schoolName) {
			this.setSchoolName(schoolName);
			return this;
		}

		/**
		 * @param startDate the startDate to set
		 * @return Builder
		 */
		public Builder withStartDate(Calendar startDate) {
			this.setStartDate(startDate);
			return this;
		}

		/**
		 * @param endDate the endDate to set
		 * @return Builder
		 */
		public Builder withEndDate(Calendar endDate) {
			this.setEndDate(endDate);
			return this;
		}

		/**
		 * @param qualification the qualification to set
		 * @return Builder
		 */
		public Builder withQualification(String qualification) {
			this.setQualification(qualification);
			return this;
		}

		/**
		 * @param description the description to set
		 * @return Builder
		 */
		public Builder withDescription(String description) {
			this.setDescription(description);
			return this;
		}

		/**
		 * @return Return a new Education
		 */
		@Override
		public Education build()
		{
			return new Education(this);
		}

	}	


}
