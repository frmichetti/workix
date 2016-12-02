package br.com.codecode.workix.core.models.jdk7.root;

import java.util.Calendar;

import br.com.codecode.workix.core.models.jdk7.actions.EducationActions;

/**
 * Root Abstract Class Education<br>
 * Use for Field Mapping/Share Only
 * <ul>
 * <li>{@link #schoolName}</li>
 * <li>{@link #startDate}</li>
 * <li>{@link #endDate}</li>
 * <li>{@link #qualification}</li>
 * <li>{@link #description}</li>
 * </ul>
 * 
 * @author felipe
 * @since 1.1
 * @version 1.0
 * @see EducationActions
 */
public abstract class BaseEducation implements EducationActions {

    /**
     * School Name Field
     */
    protected String schoolName;

    /**
     * Start Date Field
     */
    protected Calendar startDate;

    /**
     * End Date Field
     */
    protected Calendar endDate;

    /**
     * Qualification Field
     */
    protected String qualification;

    /**
     * Description Field
     */
    protected String description;

}
