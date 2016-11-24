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

/**
 * Experience JPA {@link Embeddable}
 * @author felipe
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
		
		this.employerName = builder.employerName;

		this.jobTitle = builder.jobTitle;

		this.startDate = builder.startDate;
		
		this.endDate = builder.endDate;

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
	 */
	public static class Builder implements Buildable<Experience> {
		
		private String employerName;

		private String jobTitle;
		
		private Calendar startDate;
		
		private Calendar endDate;
		
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

		public Builder setEmployerName(String employerName) {
			this.employerName = employerName;
			return this;
		}

		public Builder setJobTitle(String jobTitle) {
			this.jobTitle = jobTitle;
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

		@Override
		public Experience build() {
			
			return new Experience(this);
		}
		
	}

}
