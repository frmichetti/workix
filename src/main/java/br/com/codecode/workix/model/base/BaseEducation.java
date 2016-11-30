package br.com.codecode.workix.model.base;

import java.time.LocalDate;

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
 * @since 1.0
 * @version 1.1
 */
public abstract class BaseEducation {

    protected String schoolName;

    protected LocalDate startDate;

    protected LocalDate endDate;

    protected String qualification;

    protected String description;

}
