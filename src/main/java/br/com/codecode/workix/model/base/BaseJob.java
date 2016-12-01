package br.com.codecode.workix.model.base;

import java.math.BigDecimal;

import br.com.codecode.workix.jpa.enums.JobCategory;
import br.com.codecode.workix.jpa.enums.JobType;

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
 * <li>{@link #company}</li>
 * </ul>
 * 
 * @author felipe
 * @since 1.0
 * @version 1.1
 * @see BaseEntity
 */
public abstract class BaseJob extends BaseEntity {

    /**
     * Title of Job Field
     */
    protected String title;

    /**
     * Minimal Payment Field
     */
    protected BigDecimal minPayment;

    /**
     * Maximum Payment Field
     */
    protected BigDecimal maxPayment;

    /**
     * Description Field
     */
    protected String description;

    /**
     * Requirement Field
     */
    protected String requirement;

    /**
     * Benefits Field
     */
    protected String benefits;

    /**
     * Job Type Field
     */
    protected JobType type;

    /**
     * Job Category Field
     */
    protected JobCategory category;

    /**
     * Active Field
     */
    protected boolean active;

    /**
     * Company or Employer Field
     */
    protected BaseCompany company;   

}
