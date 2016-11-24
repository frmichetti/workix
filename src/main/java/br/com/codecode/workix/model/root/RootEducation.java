package br.com.codecode.workix.model.root;

import java.util.Calendar;

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
 * @author felipe
 * @since 1.0
 * @version 1.0
 */
public abstract class RootEducation {
	
	protected String schoolName;

	protected Calendar startDate;

	protected Calendar endDate;

	protected String qualification;

	protected String description;
	
}
