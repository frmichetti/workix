package br.com.codecode.workix.model.jpa;

import java.math.BigDecimal;
import java.util.Calendar;

import javax.annotation.PostConstruct;
import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import br.com.codecode.workix.model.base.BaseCompany;
import br.com.codecode.workix.model.base.BaseJob;
import br.com.codecode.workix.model.enums.JobCategory;
import br.com.codecode.workix.model.enums.JobType;

/**
 * Job JPA with Inherited Fields and Methods
 * @author felipe
 * @since 1.0
 * @version 1.1
 * @see MyEntity
 * @see BaseJob
 */
public class Job extends MyEntity implements BaseJob {

	private static final long serialVersionUID = 2246753300384053586L;

	@NotEmpty
	@Column(nullable = false)
	private String title;
		
	@Column
	private BigDecimal minPayment;

	@Column
	private BigDecimal maxPayment;

	@NotEmpty	
	@Lob
	@Column(nullable = false)
	private String description;

	@NotEmpty	
	@Lob
	@Column(nullable = false)	
	private String requirement;

	@NotEmpty	
	@Lob
	@Column(nullable = false)	
	private String benefits;

	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable = false, updatable = false)	
	private Calendar start;

	@NotNull
	@Future	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable = false)	
	private Calendar expire;

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
	@NotNull
	@ManyToOne(optional=false)
	private BaseCompany employeer;

	/**
	 * Public Default Constructor for JPA Compatibility Only
	 */
	public Job(){}

	/**
	 * Initialize Fields for CDI Injection
	 */
	@PostConstruct
	private void init(){
		minPayment = BigDecimal.ZERO;
		maxPayment = BigDecimal.ZERO; 
		active = true;
		start = Calendar.getInstance();		
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public BigDecimal getMinPayment() {
		return minPayment;
	}

	public void setMinPayment(BigDecimal minPayment) {
		this.minPayment = minPayment;
	}

	public BigDecimal getMaxPayment() {
		return maxPayment;
	}

	public void setMaxPayment(BigDecimal maxPayment) {
		this.maxPayment = maxPayment;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String resume) {
		this.description = resume;
	}

	public String getRequirement() {
		return requirement;
	}

	public void setRequirement(String requirement) {
		this.requirement = requirement;
	}	

	public String getBenefits() {
		return benefits;
	}

	public void setBenefits(String benefits) {
		this.benefits = benefits;
	}

	public Calendar getStart() {
		return start;
	}

	public void setStart(Calendar start) {
		this.start = start;
	}	

	public Calendar getExpire() {
		return expire;
	}

	public void setExpire(Calendar expire) {
		this.expire = expire;
	}

	public JobType getType() {
		return type;
	}

	public void setType(JobType type) {
		this.type = type;
	}

	public JobCategory getCategory() {
		return category;
	}

	public void setCategory(JobCategory category) {
		this.category = category;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public BaseCompany getEmployeer() {
		return employeer;
	}

	public void setEmployeer(BaseCompany employeer) {
		this.employeer = employeer;
	}	

}