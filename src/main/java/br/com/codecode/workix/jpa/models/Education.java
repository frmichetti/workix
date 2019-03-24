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
 * Education JPA Embeddable
 * No Anotation for Compatibility Only with Older Versions
 *
 * @author felipe
 * @version 1.1
 * @see Serializable
 * @since 1.0
 */
@Embeddable
@XmlRootElement
@XmlAccessorType(XmlAccessType.PUBLIC_MEMBER)
@Persist
public class Education implements Serializable {

    private static final long serialVersionUID = -1514012744160609145L;

    private String description;

    private Date endDate;

    private String qualification;

    private String schoolName;

    private Date startDate;

    /**
     * Public Default Constructor for JPA Compatibility Only
     */
    public Education() {
    }

    /**
     * Public Constructor for {@link Builder} Compatibility
     *
     * @param builder Builder for Generate a new Education
     * @see Buildable
     */
    public Education(Builder builder) {
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

    @Temporal(TemporalType.DATE)
    @Column
    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    @Lob
    @Column
    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    @Column
    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
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
        public Builder withEndDate(Date endDate) {
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
        public Builder withStartDate(Date startDate) {
            this.setStartDate(startDate);
            return this;
        }

    }

}
