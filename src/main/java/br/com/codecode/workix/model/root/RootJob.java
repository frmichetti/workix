package br.com.codecode.workix.model.root;

import java.math.BigDecimal;
import java.util.Calendar;

import br.com.codecode.workix.model.base.BaseCompany;
import br.com.codecode.workix.model.enums.JobCategory;
import br.com.codecode.workix.model.enums.JobType;

/**
 * Root Abstract Class Job<br>
 * Use for Field Mapping/Share Only
 * <ul>
 * <li>{@link #title}</li>
 * <li>{@link #minPayment}</li>
 * <li>{@link #maxPayment}</li>
 * <li>{@link #description}</li>
 * <li>{@link #requirement}</li>
 * <li>{@link #benefits}</li>
 * <li>{@link #start}</li>
 * <li>{@link #expire}</li>
 * <li>{@link #type}</li>
 * <li>{@link #category}</li>
 * <li>{@link #active}</li>
 * <li>{@link #employeer}</li>
 * </ul>
 * @author felipe
 * @since 1.0
 * @version 1.0
 * @see RootEntity
 */
public abstract class RootJob extends RootEntity {
	
	private String title;
		
	private BigDecimal minPayment;

	private BigDecimal maxPayment;

	private String description;

	private String requirement;

	private String benefits;

	private Calendar start;

	private Calendar expire;

	private JobType type;

	private JobCategory category;	

	private boolean active;

	private BaseCompany employeer;
	
	/**
	 * Public Empty Default Constructor
	 */
	public RootJob() {}

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
	public final BaseCompany getEmployeer() {
		return employeer;
	}

	/**
	 * @param employeer the employeer to set
	 */
	public final void setEmployeer(BaseCompany employeer) {
		this.employeer = employeer;
	}
	
	

}
