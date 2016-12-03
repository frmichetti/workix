package br.com.codecode.workix.core.models.jdk8.root;

import java.time.LocalDate;

import br.com.codecode.workix.core.models.jdk8.actions.CandidateActions;

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
 * @see CandidateActions
 */
public abstract class BaseCandidate extends BasePerson implements CandidateActions{

    /**
     * CPF Field
     */
    protected long cpf;

    /**
     * Birth Date Field
     */
    protected LocalDate birthDate;

}