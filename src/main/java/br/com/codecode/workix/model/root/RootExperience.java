package br.com.codecode.workix.model.root;

import java.util.Calendar;

/**
 * Root Abstract Class Skill<br>
 * Use for Field Mapping/Share Only
 * <ul>
 * <li>{@link #employerName}</li>
 * <li>{@link #jobTitle}</li>
 * <li>{@link #startDate}</li>
 * <li>{@link #endDate}</li>
 * <li>{@link #description}</li>
 * </ul>
 * @author felipe
 * @since 1.0
 * @version 1.0
 */
public abstract class RootExperience {
	
	protected String employerName;

	protected String jobTitle;
	
	protected Calendar startDate;

	protected Calendar endDate;

	protected String description;
	
}
