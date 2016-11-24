package br.com.codecode.workix.model.root;

import java.math.BigDecimal;
import java.util.Calendar;

import br.com.codecode.workix.model.enums.JobCategory;
import br.com.codecode.workix.model.enums.JobType;
import br.com.codecode.workix.model.jpa.Company;

/**
 * Root Abstract Class Skill<br>
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
 * <li>{@link #employeer}</li>
 * </ul>
 * @author felipe
 * @since 1.0
 * @version 1.0
 */
public abstract class RootJob extends RootEntity {
	
	protected String title;
		
	protected BigDecimal minPayment;

	protected BigDecimal maxPayment;

	protected String description;

	protected String requirement;

	protected String benefits;

	protected Calendar start;

	protected Calendar expire;

	protected JobType type;

	protected JobCategory category;	

	protected boolean active;

	protected Company employeer;

}
