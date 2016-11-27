package br.com.codecode.workix.model.scaffold;

import java.math.BigDecimal;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import br.com.codecode.workix.model.enums.JobCategory;
import br.com.codecode.workix.model.enums.JobType;

/**
 * Job JPA {@link Entity}
 * @author felipe
 * @since 1.1
 * @version 1.1
 * @see MyEntity
 */
@Entity
abstract class Job extends MyEntity {

	private static final long serialVersionUID = 2246753300384053586L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(updatable = false, nullable = false)
	private long id;

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
	private Company employeer;

	/**
	 * @return the id
	 */
	public final long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public final void setId(long id) {
		this.id = id;
	}

	/**
	 * @return the title
	 */
	public final String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public final void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the minPayment
	 */
	public final BigDecimal getMinPayment() {
		return minPayment;
	}

	/**
	 * @param minPayment the minPayment to set
	 */
	public final void setMinPayment(BigDecimal minPayment) {
		this.minPayment = minPayment;
	}

	/**
	 * @return the maxPayment
	 */
	public final BigDecimal getMaxPayment() {
		return maxPayment;
	}

	/**
	 * @param maxPayment the maxPayment to set
	 */
	public final void setMaxPayment(BigDecimal maxPayment) {
		this.maxPayment = maxPayment;
	}

	/**
	 * @return the description
	 */
	public final String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public final void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the requirement
	 */
	public final String getRequirement() {
		return requirement;
	}

	/**
	 * @param requirement the requirement to set
	 */
	public final void setRequirement(String requirement) {
		this.requirement = requirement;
	}

	/**
	 * @return the benefits
	 */
	public final String getBenefits() {
		return benefits;
	}

	/**
	 * @param benefits the benefits to set
	 */
	public final void setBenefits(String benefits) {
		this.benefits = benefits;
	}

	/**
	 * @return the start
	 */
	public final Calendar getStart() {
		return start;
	}

	/**
	 * @param start the start to set
	 */
	public final void setStart(Calendar start) {
		this.start = start;
	}

	/**
	 * @return the expire
	 */
	public final Calendar getExpire() {
		return expire;
	}

	/**
	 * @param expire the expire to set
	 */
	public final void setExpire(Calendar expire) {
		this.expire = expire;
	}

	/**
	 * @return the type
	 */
	public final JobType getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public final void setType(JobType type) {
		this.type = type;
	}

	/**
	 * @return the category
	 */
	public final JobCategory getCategory() {
		return category;
	}

	/**
	 * @param category the category to set
	 */
	public final void setCategory(JobCategory category) {
		this.category = category;
	}

	/**
	 * @return the active
	 */
	public final boolean isActive() {
		return active;
	}

	/**
	 * @param active the active to set
	 */
	public final void setActive(boolean active) {
		this.active = active;
	}

	/**
	 * @return the employeer
	 */
	public final Company getEmployeer() {
		return employeer;
	}

	/**
	 * @param employeer the employeer to set
	 */
	public final void setEmployeer(Company employeer) {
		this.employeer = employeer;
	}	
	
	

}