package br.com.codecode.workix.jpa.models;

import java.time.LocalDate;

import javax.annotation.PostConstruct;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import br.com.codecode.workix.cdi.qualifiers.Persist;
import br.com.codecode.workix.model.actions.CandidateActions;

/**
 * Candidate JPA with Inherited Fields and Methods
 * 
 * @see Person
 * @author felipe
 * @see Person
 * @see CandidateActions
 * @since 1.0
 * @version 1.1
 */
@Entity
@XmlRootElement
@XmlAccessorType(XmlAccessType.PUBLIC_MEMBER)
@Persist
public class Candidate extends Person {

    private static final long serialVersionUID = 531807027259604477L;

    private long id, cpf;

    private LocalDate birthDate;

    /**
     * Public Default Constructor for JPA Compatibility Only
     */
    public Candidate(){}

    @Column(nullable = false)
    public LocalDate getBirthDate() {
	return birthDate;
    }

    @Column(nullable = false, unique = true)
    public long getCpf() {
	return cpf;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false)
    @Override
    public long getId() {
	return this.id;
    }

    /**
     * Initialize Fields for CDI Injection
     */
    @PostConstruct
    private void init() {
	birthDate = LocalDate.now();
    }

    public void setBirthDate(LocalDate birthDate) {
	this.birthDate = birthDate;
    }

    public void setCpf(long cpf) {
	this.cpf = cpf;
    }

    @Override
    public void setId(long id) {
	this.id = id;
    }

}