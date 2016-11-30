package br.com.codecode.workix.model.actions;

import java.util.Calendar;

/**
 * Markup Interface for Candidate Implementation
 * 
 * @author felipe
 * @since 1.0
 * @version 1.0
 */
public interface CandidateActions extends PersonActions {

    long getCpf();

    void setCpf(long cpf);

    Calendar getBirthDate();

    void setBirthDate(Calendar birthDate);

}
