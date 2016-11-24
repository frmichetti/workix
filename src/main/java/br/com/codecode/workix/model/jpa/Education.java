package br.com.codecode.workix.model.jpa;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Lob;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import br.com.codecode.workix.model.interfaces.Buildable;
import br.com.codecode.workix.model.root.RootEducation;

/**
 * Education JPA {@link Embeddable} 
 * @author felipe
 * @since 1.0
 * @version 1.0
 */
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

	@Override
	public String toString() {
		return "Education [schoolName=" + schoolName + ", startDate=" + startDate + ", endDate=" + endDate + "]";
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
			this.schoolName = schoolName;
			this.startDate = startDate;
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
			this.endDate = endDate;
			this.qualification = qualification;
			this.description = description;
		}		
		
		/**
		 * @return the schoolName
		 */
		public final String getSchoolName() {
			return schoolName;
		}
		
		/**
		 * @return the startDate
		 */
		public final Calendar getStartDate() {
			return startDate;
		}
		
		/**
		 * @return the endDate
		 */
		public final Calendar getEndDate() {
			return endDate;
		}
		
		/**
		 * @return the qualification
		 */
		public final String getQualification() {
			return qualification;
		}
		
		/**
		 * @return the description
		 */
		public final String getDescription() {
			return description;
		}


		/**
		 * @param schoolName the schoolName to set
		 * @return Builder
		 */
		public Builder setSchoolName(String schoolName) {
			this.schoolName = schoolName;
			return this;
		}

		/**
		 * @param startDate the startDate to set
		 * @return Builder
		 */
		public Builder setStartDate(Calendar startDate) {
			this.startDate = startDate;
			return this;
		}

		/**
		 * @param endDate the endDate to set
		 * @return Builder
		 */
		public Builder setEndDate(Calendar endDate) {
			this.endDate = endDate;
			return this;
		}

		/**
		 * @param qualification the qualification to set
		 * @return Builder
		 */
		public Builder setQualification(String qualification) {
			this.qualification = qualification;
			return this;
		}

		/**
		 * @param description the description to set
		 * @return Builder
		 */
		public Builder setDescription(String description) {
			this.description = description;
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
