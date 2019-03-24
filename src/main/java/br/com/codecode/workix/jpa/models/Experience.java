package br.com.codecode.workix.jpa.models;

import br.com.codecode.workix.cdi.qualifiers.Persist;
import br.com.codecode.workix.interfaces.Buildable;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.io.Serializable;
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
@Embeddable
@XmlRootElement
@XmlAccessorType()
@Persist
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
    public Experience() {
    }

    /**
     * Public Constructor for {@link Builder} Compatibility
     *
     * @param builder Builder for Generate a New Experience
     * @see Buildable
     */
    public Experience(Builder builder) {
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
    @XmlTransient
    public static Builder builder() {
        return new Builder();
    }

    @Lob
    @Column
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column
    public String getEmployerName() {
        return employerName;
    }

    public void setEmployerName(String employerName) {
        this.employerName = employerName;
    }

    @Temporal(TemporalType.DATE)
    @Column
    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    @Column
    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    @Temporal(TemporalType.DATE)
    @Column
    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
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
        public Builder withEndDate(Date endDate) {
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
        public Builder withStartDate(Date startDate) {
            this.setStartDate(startDate);
            return this;
        }

    }

}
