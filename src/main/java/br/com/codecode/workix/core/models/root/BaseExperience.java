package br.com.codecode.workix.core.models.root;

import java.time.LocalDate;

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
 */
public abstract class BaseExperience {

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
