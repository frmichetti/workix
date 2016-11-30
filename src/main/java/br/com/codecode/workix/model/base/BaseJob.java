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
 * @version 1.1
 * @see BaseEntity
 */
public abstract class BaseJob extends BaseEntity {

    protected String title;

    protected BigDecimal minPayment;

    protected BigDecimal maxPayment;

    protected String description;

    protected String requirement;

    protected String benefits;

    protected Calendar start;

    protected Calendar expire;

    protected JobType type;

    protected JobCategory category;

    protected boolean active;

    protected CompanyActions employeer;   

}
