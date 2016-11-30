package br.com.codecode.workix.model.base;

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

    protected String employerName;

    protected String jobTitle;

    protected LocalDate startDate;

    protected LocalDate endDate;

    protected String description;

}
