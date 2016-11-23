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

import br.com.codecode.workix.model.interfaces.Buildable;

/**
 * Education JPA {@link Embeddable} 
 * @author felipe
 * @category JPA
 *
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
	 * @param builder
	 * @category Builder
	 */
	public Education(Builder builder) {
		this.schoolName = builder.schoolName;
		this.startDate = builder.startDate;
		this.endDate = builder.endDate;
		this.qualification = builder.qualification;
		this.description = builder.description;
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
	 * Builder NestedClass for {@link Contact} 
	 * @category Builder
	 * @author felipe
	 *
	 */
	public static class Builder implements Buildable<Education> {	

		private String schoolName;

		private Calendar startDate;

		private Calendar endDate;

		private String qualification;

		private String description;

		private Builder(){}		

		public Builder(String schoolName,Calendar startDate) {
			this();			
			this.schoolName = schoolName;
			this.startDate = startDate;
		}		

		public Builder(String schoolName, Calendar startDate, Calendar endDate, String qualification, String description) {			
			this(schoolName,startDate);			
			this.endDate = endDate;
			this.qualification = qualification;
			this.description = description;
		}		

		public Builder setSchoolName(String schoolName) {
			this.schoolName = schoolName;
			return this;
		}

		public Builder setStartDate(Calendar startDate) {
			this.startDate = startDate;
			return this;
		}

		public Builder setEndDate(Calendar endDate) {
			this.endDate = endDate;
			return this;
		}

		public Builder setQualification(String qualification) {
			this.qualification = qualification;
			return this;
		}

		public Builder setDescription(String description) {
			this.description = description;
			return this;
		}

		@Override
		public Education build()
		{
			return new Education(this);
		}

	}	


}
