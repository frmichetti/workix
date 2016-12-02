package br.com.codecode.workix.core.models.jdk7.root;

import java.util.Calendar;

import br.com.codecode.workix.core.models.jdk7.actions.CandidateActions;

/**
 * Root Abstract Class Candidate<br>
 * Use for Field Mapping/Share Only
 * <ul>
 * <li>{@link #cpf}</li>
 * <li>{@link #birthDate}</li>
 * </ul>
 * 
 * @author felipe
 * @since 1.1
 * @version 1.0
 * @see BasePerson
 * @see CandidateActions
 */
public abstract class BaseCandidate extends BasePerson implements CandidateActions {

    /**
     * CPF Field
     */
    protected long cpf;

    /**
     * Birth Date Field
     */
    protected Calendar birthDate;

}
