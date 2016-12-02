package br.com.codecode.workix.core.models.jdk7.actions;

import java.util.Calendar;

/**
 * Markup Interface for Candidate Implementation
 * 
 * @author felipe
 * @since 1.1
 * @version 1.0
 * @see PersonActions
 */
public interface CandidateActions extends PersonActions {

    Calendar getBirthDate();

    long getCpf();

    void setBirthDate(Calendar birthDate);

    void setCpf(long cpf);

}
