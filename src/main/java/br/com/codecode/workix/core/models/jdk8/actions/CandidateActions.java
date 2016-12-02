package br.com.codecode.workix.core.models.jdk8.actions;

import java.time.LocalDate;

/**
 * Markup Interface for Candidate Implementation
 * 
 * @author felipe
 * @since 1.0
 * @version 1.1
 */
public interface CandidateActions extends PersonActions {

    LocalDate getBirthDate();

    long getCpf();

    void setBirthDate(LocalDate birthDate);

    void setCpf(long cpf);

}
