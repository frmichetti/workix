package br.com.codecode.workix.jpa.models;

import br.com.codecode.workix.cdi.qualifiers.Persist;
import br.com.codecode.workix.core.enums.JobCategory;
import br.com.codecode.workix.core.enums.JobType;
import br.com.codecode.workix.interfaces.Buildable;
import br.com.codecode.workix.jpa.models.jdk7.MyEntity;

import javax.annotation.PostConstruct;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.math.BigDecimal;

/**
 * Job JPA with Inherited Fields and Methods
 * No Anotation for Compatibility Only with Older Versions
 *
 * @author felipe
 * @version 1.1
 * @see MyEntity
 * @since 1.0
 */
@Entity
@Table(name = "jobs")
@XmlRootElement
@XmlAccessorType(XmlAccessType.PUBLIC_MEMBER)
@Persist
public class Job extends MyEntity {

    private static final long serialVersionUID = 2246753300384053586L;

    private boolean active;

    /**
     * Many {@link Job} To One {@link Company}
     */
    private Company company;

    private long id;

    private JobCategory jobCategory;

    private JobType jobType;

    private BigDecimal minPayment, maxPayment;

    private String title, description, requirement, benefits;

    /**
     * Public Default Constructor for JPA Compatibility Only
     */
    public Job() {
    }

    /**
     * Public Constructor for {@link Builder} Compatibility
     *
     * @param builder Builder for Generate a New Job
     * @see Buildable
     */
    private Job(Builder builder) {
        this.active = builder.isActive();
        this.title = builder.getTitle();
        this.description = builder.getDescription();
        this.requirement = builder.getRequirement();
        this.benefits = builder.getBenefits();
        this.minPayment = builder.getMinPayment();
        this.maxPayment = builder.getMaxPayment();
        this.jobType = builder.getJobType();
        this.jobCategory = builder.getJobCategory();
        this.company = builder.getCompany();
    }

    /**
     * Creates builder to build {@link Job}.
     *
     * @return created builder
     */
    @XmlTransient
    public static Builder builder() {
        return new Builder();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (!(obj instanceof Job))
            return false;
        Job other = (Job) obj;
        if (id != other.id)
            return false;
        return true;
    }

    @Lob
    @Column(nullable = false)
    public String getBenefits() {
        return benefits;
    }

    public void setBenefits(String benefits) {
        this.benefits = benefits;
    }

    @ManyToOne(optional = false)
    public Company getCompany() {
        return company;
    }

    public void setCompany(Company employeer) {
        this.company = employeer;
    }

    @Lob
    @Column(nullable = false)
    public String getDescription() {
        return description;
    }

    public void setDescription(String resume) {
        this.description = resume;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(updatable = false, nullable = false)
    @Override
    public long getId() {
        return this.id;
    }

    @Override
    public void setId(long id) {
        this.id = id;
    }

    @Column
    @Enumerated(EnumType.STRING)
    public JobCategory getJobCategory() {
        return jobCategory;
    }

    public void setJobCategory(JobCategory category) {
        this.jobCategory = category;
    }

    @Column
    @Enumerated(EnumType.STRING)
    public JobType getJobType() {
        return jobType;
    }

    public void setJobType(JobType type) {
        this.jobType = type;
    }

    @Column
    public BigDecimal getMaxPayment() {
        return maxPayment;
    }

    public void setMaxPayment(BigDecimal maxPayment) {
        this.maxPayment = maxPayment;
    }

    @Column
    public BigDecimal getMinPayment() {
        return minPayment;
    }

    public void setMinPayment(BigDecimal minPayment) {
        this.minPayment = minPayment;
    }

    @Lob
    @Column(nullable = false)
    public String getRequirement() {
        return requirement;
    }

    public void setRequirement(String requirement) {
        this.requirement = requirement;
    }

    @Column(nullable = false)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (id ^ (id >>> 32));
        return result;
    }

    /**
     * Initialize Fields for CDI Injection
     */
    @PostConstruct
    private void init() {
        minPayment = BigDecimal.ZERO;
        maxPayment = BigDecimal.ZERO;
        active = true;
    }

    @Column

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    /**
     * Builder to build {@link Job}.
     */
    public static final class Builder extends Job implements Buildable<Job> {

        private static final long serialVersionUID = -2178589087775440695L;

        /**
         * Disabled Empty Constructor
         */
        private Builder() {
        }

        /**
         * @return Return a new Job
         */
        public Job build() {
            return new Job(this);
        }

        public Builder withActive(boolean active) {
            super.active = active;
            return this;
        }

        public Builder withBenefits(String benefits) {
            super.benefits = benefits;
            return this;
        }

        public Builder withCompany(Company company) {
            super.company = company;
            return this;
        }

        public Builder withDescription(String description) {
            super.description = description;
            return this;
        }

        public Builder withJobCategory(JobCategory jobCategory) {
            super.jobCategory = jobCategory;
            return this;
        }

        public Builder withJobType(JobType jobType) {
            super.jobType = jobType;
            return this;
        }

        public Builder withMaxPayment(BigDecimal maxPayment) {
            super.maxPayment = maxPayment;
            return this;
        }

        public Builder withMinPayment(BigDecimal minPayment) {
            super.minPayment = minPayment;
            return this;
        }

        public Builder withRequirement(String requirement) {
            super.requirement = requirement;
            return this;
        }

        public Builder withTitle(String title) {
            super.title = title;
            return this;
        }
    }

}