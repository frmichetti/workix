package br.com.codecode.workix.jpa.models;

import java.math.BigDecimal;

import javax.annotation.PostConstruct;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

import br.com.codecode.workix.jpa.enums.JobCategory;
import br.com.codecode.workix.jpa.enums.JobType;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Job JPA with Inherited Fields and Methods
 * 
 * @author felipe
 * @since 1.0
 * @version 1.1
 * @see MyEntity
 * @see Job
 */
@Entity
@XmlRootElement
@XmlAccessorType(XmlAccessType.PUBLIC_MEMBER)
public class Job extends MyEntity {

    private static final long serialVersionUID = 2246753300384053586L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false)
    private long id;

    @Column(nullable = false)
    private String title;

    @Column
    private BigDecimal minPayment;

    @Column
    private BigDecimal maxPayment;

    @Lob
    @Column(nullable = false)
    private String description;

    @Lob
    @Column(nullable = false)
    private String requirement;

    @Lob
    @Column(nullable = false)
    private String benefits;

    @Enumerated(EnumType.STRING)
    @Column
    private JobType type;

    @Enumerated(EnumType.STRING)
    @Column
    private JobCategory category;

    @Column
    private boolean active;

    /**
     * Many {@link Job} To One {@link Company}
     */
    @ManyToOne(optional = false)
    private Company employeer;

    /**
     * Public Default Constructor for JPA Compatibility Only
     */
    public Job() {
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

    public String getBenefits() {
	return benefits;
    }

    public JobCategory getCategory() {
	return category;
    }

    public String getDescription() {
	return description;
    }

    public Company getEmployeer() {
	return employeer;
    }

    @Override
    public long getId() {
	return this.id;
    }

    public BigDecimal getMaxPayment() {
	return maxPayment;
    }

    public BigDecimal getMinPayment() {
	return minPayment;
    }

    public String getRequirement() {
	return requirement;
    }

    public String getTitle() {
	return title;
    }

    public JobType getType() {
	return type;
    }

    public boolean isActive() {
	return active;
    }

    public void setActive(boolean active) {
	this.active = active;
    }

    public void setBenefits(String benefits) {
	this.benefits = benefits;
    }

    public void setCategory(JobCategory category) {
	this.category = category;
    }

    public void setDescription(String resume) {
	this.description = resume;
    }

    public void setEmployeer(Company employeer) {
	this.employeer = employeer;
    }

    @Override
    public void setId(long id) {
	this.id = id;
    }

    public void setMaxPayment(BigDecimal maxPayment) {
	this.maxPayment = maxPayment;
    }

    public void setMinPayment(BigDecimal minPayment) {
	this.minPayment = minPayment;
    }

    public void setRequirement(String requirement) {
	this.requirement = requirement;
    }

    public void setTitle(String title) {
	this.title = title;
    }

    public void setType(JobType type) {
	this.type = type;
    }

}