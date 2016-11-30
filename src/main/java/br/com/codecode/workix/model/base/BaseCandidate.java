package br.com.codecode.workix.model.base;

import java.time.LocalDate;

/**
 * Root Abstract Class Candidate<br>
 * Use for Field Mapping/Share Only
 * <ul>
 * <li>{@link #cpf}</li>
 * <li>{@link #birthDate}</li>
 * </ul>
 * 
 * @author felipe
 * @since 1.0
 * @version 1.1
 * @see BasePerson
 */
public abstract class BaseCandidate extends BasePerson {

    protected long cpf;

    protected LocalDate birthDate;

}
