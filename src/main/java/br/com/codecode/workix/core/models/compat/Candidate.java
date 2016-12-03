package br.com.codecode.workix.core.models.compat;

import java.time.LocalDate;

import br.com.codecode.workix.core.models.jdk8.actions.CandidateActions;

/**
 * Candidate JPA with Inherited Fields and Methods
 * <br>Without Annotations
 * @see Person
 * @author felipe
 * @see Person
 * @see CandidateActions
 * @since 1.1
 * @version 1.1
 */
public class Candidate extends Person {

    private static final long serialVersionUID = 531807027259604477L;

    private long id, cpf;

    private LocalDate birthDate;

    /**
     * Public Default Constructor for JPA Compatibility Only
     */
    public Candidate(){}

    public LocalDate getBirthDate() {
	return birthDate;
    }

    public long getCpf() {
	return cpf;
    }

    public long getId() {
	return this.id;
    }

    /**
     * Initialize Fields for CDI Injection
     */
    private void init() {
	birthDate = LocalDate.now();
    }

    public void setBirthDate(LocalDate birthDate) {
	this.birthDate = birthDate;
    }

    public void setCpf(long cpf) {
	this.cpf = cpf;
    }

    public void setId(long id) {
	this.id = id;
    }

}