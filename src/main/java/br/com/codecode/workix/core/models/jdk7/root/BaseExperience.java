package br.com.codecode.workix.core.models.jdk7.root;

import java.util.Calendar;

import br.com.codecode.workix.core.models.jdk7.actions.ExperienceActions;

/**
 * Root Abstract Class Experience<br>
 * Use for Field Mapping/Share Only
 * <ul>
 * <li>{@link #employerName}</li>
 * <li>{@link #jobTitle}</li>
 * <li>{@link #startDate}</li>
 * <li>{@link #endDate}</li>
 * <li>{@link #description}</li>
 * </ul>
 * 
 * @author felipe
 * @since 1.1
 * @version 1.0
 * @see ExperienceActions
 */
public abstract class BaseExperience implements ExperienceActions {

    /**
     * Employer Name Field
     */
    protected String employerName;

    /**
     * Job Title Field
     */
    protected String jobTitle;

    /**
     * Start Date Field
     */
    protected Calendar startDate;

    /**
     * End Date Field
     */
    protected Calendar endDate;

    /**
     * Description Field
     */
    protected String description;

}
