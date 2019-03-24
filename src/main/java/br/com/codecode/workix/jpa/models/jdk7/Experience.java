package br.com.codecode.workix.jpa.models.jdk7;

import br.com.codecode.workix.interfaces.Buildable;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

/**
 * Experience JPA Embeddable
 * No Anotation for Compatibility Only with Older Versions
 *
 * @author felipe
 * @version 1.1
 * @see Serializable
 * @since 1.0
 */
public class Experience implements Serializable {

    private static final long serialVersionUID = -6311235469498858665L;

    private String description;

    private String employerName;

    private Calendar endDate;

    private String jobTitle;

    private Calendar startDate;

    /**
     * Public Default Constructor for JPA Compatibility Only
     */
    Experience() {
    }

    /**
     * Public Constructor for {@link Builder} Compatibility
     *
     * @param builder Builder for Generate a New Experience
     * @see Buildable
     */
    Experience(Builder builder) {
        this.employerName = builder.getEmployerName();
        this.jobTitle = builder.getJobTitle();
        this.startDate = builder.getStartDate();
        this.endDate = builder.getEndDate();
    }

    /**
     * Creates builder to build {@link Experience}.
     *
     * @return created builder
     */
    public static Builder builder() {
        return new Builder();
    }

    public String getDescription() {
        return description;
    }

    void setDescription(String description) {
        this.description = description;
    }

    String getEmployerName() {
        return employerName;
    }

    void setEmployerName(String employerName) {
        this.employerName = employerName;
    }

    Calendar getEndDate() {
        return endDate;
    }

    void setEndDate(Calendar endDate) {
        this.endDate = endDate;
    }

    String getJobTitle() {
        return jobTitle;
    }

    void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    Calendar getStartDate() {
        return startDate;
    }

    void setStartDate(Calendar startDate) {
        this.startDate = startDate;
    }

    /**
     * Builder NestedClass for {@link Experience}
     *
     * @author felipe
     * @version 1.0
     * @see Buildable
     * @see Experience
     * @since 1.0
     */
    public final static class Builder extends Experience implements Buildable<Experience> {

        private static final long serialVersionUID = -1322208401535756846L;

        /**
         * Disabled Empty Constructor
         */
        private Builder() {
        }

        /**
         * @return Return a new Experience
         */
        @Override
        public Experience build() {

            return new Experience(this);
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
         * @param employerName the employerName to set
         * @return Builder
         */
        public Builder withEmployerName(String employerName) {
            this.setEmployerName(employerName);
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
         * @param jobTitle the jobTitle to set
         * @return Builder
         */
        public Builder withJobTitle(String jobTitle) {
            this.setJobTitle(jobTitle);
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

        public Builder withStartDate(Date date) {
            return null;
        }

        public Builder withEndDate(Date date) {
            return null;
        }
    }

}
