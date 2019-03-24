package br.com.codecode.workix.jpa.models.jdk7;

import br.com.codecode.workix.interfaces.Buildable;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

/**
 * Education JPA Embeddable
 * No Anotation for Compatibility Only with Older Versions
 *
 * @author felipe
 * @version 1.1
 * @see Serializable
 * @since 1.0
 */
public class Education implements Serializable {

    private static final long serialVersionUID = -1514012744160609145L;

    private String description;

    private Calendar endDate;

    private String qualification;

    private String schoolName;

    private Calendar startDate;

    /**
     * Public Default Constructor for JPA Compatibility Only
     */
    Education() {
    }

    /**
     * Public Constructor for {@link Builder} Compatibility
     *
     * @param builder Builder for Generate a new Education
     * @see Buildable
     */
    Education(Builder builder) {
        this.schoolName = builder.getSchoolName();
        this.startDate = builder.getStartDate();
        this.endDate = builder.getEndDate();
        this.qualification = builder.getQualification();
        this.description = builder.getDescription();
    }

    /**
     * Creates builder to build {@link Experience}.
     *
     * @return created builder
     */
    public static Builder builder() {
        return new Builder();
    }

    String getDescription() {
        return description;
    }

    void setDescription(String description) {
        this.description = description;
    }

    Calendar getEndDate() {
        return endDate;
    }

    void setEndDate(Calendar endDate) {
        this.endDate = endDate;
    }

    String getQualification() {
        return qualification;
    }

    void setQualification(String qualification) {
        this.qualification = qualification;
    }

    String getSchoolName() {
        return schoolName;
    }

    void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    Calendar getStartDate() {
        return startDate;
    }

    void setStartDate(Calendar startDate) {
        this.startDate = startDate;
    }

    /**
     * Builder NestedClass for {@link Education}
     *
     * @author felipe
     * @version 1.0
     * @see Education
     * @see Buildable
     * @since 1.0
     */
    public static class Builder extends Education implements Buildable<Education> {

        private static final long serialVersionUID = 3075237483868037001L;

        /**
         * Disabled Empty Constructor
         */
        private Builder() {
        }

        /**
         * @return Return a new Education
         */
        @Override
        public Education build() {
            return new Education(this);
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

        public Builder withStartDate(Date date) {
            return null;
        }

        public Builder withEndDate(Date date) {
            return null;
        }
    }

}
