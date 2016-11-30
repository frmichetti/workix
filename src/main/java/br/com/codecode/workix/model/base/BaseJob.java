package br.com.codecode.workix.model.base;

import java.math.BigDecimal;
import java.util.Calendar;

import br.com.codecode.workix.jpa.enums.JobCategory;
import br.com.codecode.workix.jpa.enums.JobType;
import br.com.codecode.workix.model.actions.CompanyActions;

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
 * 
 * @author felipe
 * @since 1.0
 * @version 1.0
 * @see BaseEntity
 */
public abstract class BaseJob extends BaseEntity {

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

    private CompanyActions employeer;

    /**
     * Public Empty Default Constructor
     */
    public BaseJob() {
    }

    /**
     * @return the title
     */
    public String getTitle() {
	return title;
    }

    /**
     * @param title
     *            the title to set
     */
    public void setTitle(String title) {
	this.title = title;
    }

    /**
     * @return the minPayment
     */
    public BigDecimal getMinPayment() {
	return minPayment;
    }

    /**
     * @param minPayment
     *            the minPayment to set
     */
    public void setMinPayment(BigDecimal minPayment) {
	this.minPayment = minPayment;
    }

    /**
     * @return the maxPayment
     */
    public BigDecimal getMaxPayment() {
	return maxPayment;
    }

    /**
     * @param maxPayment
     *            the maxPayment to set
     */
    public void setMaxPayment(BigDecimal maxPayment) {
	this.maxPayment = maxPayment;
    }

    /**
     * @return the description
     */
    public String getDescription() {
	return description;
    }

    /**
     * @param description
     *            the description to set
     */
    public void setDescription(String description) {
	this.description = description;
    }

    /**
     * @return the requirement
     */
    public String getRequirement() {
	return requirement;
    }

    /**
     * @param requirement
     *            the requirement to set
     */
    public void setRequirement(String requirement) {
	this.requirement = requirement;
    }

    /**
     * @return the benefits
     */
    public String getBenefits() {
	return benefits;
    }

    /**
     * @param benefits
     *            the benefits to set
     */
    public void setBenefits(String benefits) {
	this.benefits = benefits;
    }

    /**
     * @return the start
     */
    public Calendar getStart() {
	return start;
    }

    /**
     * @param start
     *            the start to set
     */
    public void setStart(Calendar start) {
	this.start = start;
    }

    /**
     * @return the expire
     */
    public Calendar getExpire() {
	return expire;
    }

    /**
     * @param expire
     *            the expire to set
     */
    public void setExpire(Calendar expire) {
	this.expire = expire;
    }

    /**
     * @return the type
     */
    public JobType getType() {
	return type;
    }

    /**
     * @param type
     *            the type to set
     */
    public void setType(JobType type) {
	this.type = type;
    }

    /**
     * @return the category
     */
    public JobCategory getCategory() {
	return category;
    }

    /**
     * @param category
     *            the category to set
     */
    public void setCategory(JobCategory category) {
	this.category = category;
    }

    /**
     * @return the active
     */
    public boolean isActive() {
	return active;
    }

    /**
     * @param active
     *            the active to set
     */
    public void setActive(boolean active) {
	this.active = active;
    }

    /**
     * @return the employeer
     */
    public CompanyActions getEmployeer() {
	return employeer;
    }

    /**
     * @param employeer
     *            the employeer to set
     */
    public void setEmployeer(CompanyActions employeer) {
	this.employeer = employeer;
    }

}
