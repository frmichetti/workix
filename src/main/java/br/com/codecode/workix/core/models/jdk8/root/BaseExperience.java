package br.com.codecode.workix.core.models.jdk8.root;

import java.time.LocalDate;

import br.com.codecode.workix.core.models.jdk8.actions.ExperienceActions;

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
 * @since 1.0
 * @version 1.1
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
    protected LocalDate startDate;

    /**
     * End Date Field
     */
    protected LocalDate endDate;

    /**
     * Description Field
     */
    protected String description;

}