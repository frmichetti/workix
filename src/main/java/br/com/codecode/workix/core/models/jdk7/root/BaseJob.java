package br.com.codecode.workix.core.models.jdk7.root;

import java.math.BigDecimal;

import br.com.codecode.workix.core.models.enums.JobCategory;
import br.com.codecode.workix.core.models.enums.JobType;
import br.com.codecode.workix.core.models.jdk7.actions.JobActions;

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
 * <li>{@link #type}</li>
 * <li>{@link #category}</li>
 * <li>{@link #active}</li>
 * <li>{@link #company}</li>
 * </ul>
 * 
 * @author felipe
 * @since 1.1
 * @version 1.0
 * @see BaseEntity
 * @see JobActions
 */
public abstract class BaseJob extends BaseEntity implements JobActions {

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
