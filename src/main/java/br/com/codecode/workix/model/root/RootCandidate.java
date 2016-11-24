package br.com.codecode.workix.model.root;

import java.util.Calendar;

/**
 * Root Abstract Class Candidate<br>
 * Use for Field Mapping/Share Only
 * <ul>
 * <li>{@link #cpf}</li>
 * <li>{@link #birthDate}</li>
 * </ul>
 * @author felipe
 * @since 1.0
 * @version 1.0
 * @see RootPerson
 */
public abstract class RootCandidate extends RootPerson {
	
	protected long cpf;
	
	protected Calendar birthDate;

}
