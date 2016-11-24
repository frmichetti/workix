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
import br.com.codecode.workix.model.root.RootExperience;

/**
 * Experience JPA {@link Embeddable}
 * @author felipe
 * @since 1.0
 * @version 1.0
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
	 * Public Default Constructor for JPA Compatibility Only
	 */
	public Experience(){}			

	/**
	 * Public Constructor for {@link Builder} Compatibility
	 * @see Buildable
	 * @param builder Builder for Generate a New Experience
	 */
	public Experience(@NotNull Builder builder) {
		
		this.employerName = builder.getEmployerName();

		this.jobTitle = builder.getJobTitle();

		this.startDate = builder.getStartDate();
		
		this.endDate = builder.getEndDate();

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

	@Override
	public String toString() {
		return "Experience [employerName=" + employerName + ", jobTitle=" + jobTitle + ", description=" + description + "]";
	}
	
	/**
	 * Builder NestedClass for {@link Experience} 
	 * @author felipe
	 * @since 1.0
	 * @version 1.0
	 */
	public final static class Builder extends RootExperience implements Buildable<Experience> {
		
		/**
		 * Disabled Empty Constructor
		 */
		private Builder(){};		

		/**
		 * Constructor with Required Fields
		 * @param employerName Employer Name
		 * @param jobTitle Job Title
		 */
		public Builder(String employerName, String jobTitle) {
			this();
			this.employerName = employerName;
			this.jobTitle = jobTitle;
		}

		/**
		 * Constructor with All Fields
		 * @param employerName Employer Name
		 * @param jobTitle Job Title
		 * @param startDate Start Date
		 * @param endDate End Date
		 */
		public Builder(String employerName, String jobTitle, Calendar startDate, Calendar endDate) {
			this(employerName,jobTitle);
			this.startDate = startDate;
			this.endDate = endDate;
		}
		
		/**
		 * @return the employerName
		 */
		public final String getEmployerName() {
			return employerName;
		}

		/**
		 * @return the jobTitle
		 */
		public final String getJobTitle() {
			return jobTitle;
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
		 * @return the description
		 */
		public final String getDescription() {
			return description;
		}


		/**
		 * @param employerName the employerName to set
		 * @return Builder
		 */
		public Builder setEmployerName(String employerName) {
			this.employerName = employerName;
			return this;
		}


		/**
		 * @param jobTitle the jobTitle to set
		 * @return Builder
		 */
		public Builder setJobTitle(String jobTitle) {
			this.jobTitle = jobTitle;
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
		 * @param description the description to set
		 * @return Builder
		 */
		public Builder setDescription(String description) {
			this.description = description;
			return this;
		}

		/**
		 * @return Return a new Experience
		 */
		@Override
		public Experience build() {
			
			return new Experience(this);
		}
		
	}

}
