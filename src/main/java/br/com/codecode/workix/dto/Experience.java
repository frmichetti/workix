package br.com.codecode.workix.dto;

import br.com.codecode.workix.interfaces.Buildable;

import java.io.Serializable;
import java.util.Date;

public class Experience implements Serializable {

	private static final long serialVersionUID = -6311235469498858665L;

	private String description;

	private String employerName;

	private Date endDate;

	private String jobTitle;

	private Date startDate;

	/**
	 * Public Default Constructor for JPA Compatibility Only
	 */
	public Experience(){}

	/**
	 * Public Constructor for {@link Builder} Compatibility
	 *
	 * @see Buildable
	 * @param builder
	 *            Builder for Generate a New Experience
	 */
	public Experience(Builder builder) {
		this.employerName = builder.getEmployerName();
		this.jobTitle = builder.getJobTitle();
		this.startDate = builder.getStartDate();
		this.endDate = builder.getEndDate();
	}

	/**
	 * Creates builder to build {@link Experience}.
	 * @return created builder
	 */
	public static Builder builder() {
		return new Builder();
	}

	public String getDescription() {
		return description;
	}

	public String getEmployerName() {
		return employerName;
	}

	public Date getEndDate() {
		return endDate;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setEmployerName(String employerName) {
		this.employerName = employerName;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	/**
	 * Builder NestedClass for {@link Experience}
	 *
	 * @author felipe
	 * @since 1.0
	 * @version 1.0
	 * @see Buildable
	 * @see Experience
	 */
	public final static class Builder extends Experience implements Buildable<Experience> {

		private static final long serialVersionUID = -1322208401535756846L;

		/**
		 * Disabled Empty Constructor
		 */
		private Builder(){}

		/**
		 * @return Return a new Experience
		 */
		@Override
		public Experience build() {

			return new Experience(this);
		}

		/**
		 * @param description
		 *            the description to set
		 * @return Builder
		 */
		public Builder withDescription(String description) {
			this.setDescription(description);
			return this;
		}

		/**
		 * @param employerName
		 *            the employerName to set
		 * @return Builder
		 */
		public Builder withEmployerName(String employerName) {
			this.setEmployerName(employerName);
			return this;
		}

		/**
		 * @param endDate
		 *            the endDate to set
		 * @return Builder
		 */
		public Builder withEndDate(Date endDate) {
			this.setEndDate(endDate);
			return this;
		}

		/**
		 * @param jobTitle
		 *            the jobTitle to set
		 * @return Builder
		 */
		public Builder withJobTitle(String jobTitle) {
			this.setJobTitle(jobTitle);
			return this;
		}

		/**
		 * @param startDate
		 *            the startDate to set
		 * @return Builder
		 */
		public Builder withStartDate(Date startDate) {
			this.setStartDate(startDate);
			return this;
		}

	}

}
