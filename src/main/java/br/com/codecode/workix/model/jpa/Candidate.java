package br.com.codecode.workix.model.jpa;

import java.util.Calendar;

import javax.annotation.PostConstruct;
import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Past;

import br.com.codecode.workix.model.base.BaseCandidate;

/**
 * Candidate JPA with Inherited Fields and Methods
 * @see Person
 * @author felipe
 * @see Person
 * @see BaseCandidate
 * @since 1.0
 * @version 1.1
 */
public class Candidate extends Person implements BaseCandidate {

	private static final long serialVersionUID = 531807027259604477L;	
		
	@Column(nullable = false,unique = true)
	private long cpf;

	@Past
	@Temporal(TemporalType.DATE)
	@Column(nullable = false)	
	private Calendar birthDate;	

	/**
	 * Public Default Constructor for JPA Compatibility Only
	 */
	public Candidate(){}	

	/**
	 * Initialize Fields for CDI Injection
	 */
	@PostConstruct
	private void init() {
		birthDate = Calendar.getInstance();		
	}

	@Override
	public long getCpf() {
		return cpf;
	}

	@Override
	public void setCpf(long cpf) {
		this.cpf = cpf;
	}

	@Override
	public Calendar getBirthDate() {
		return birthDate;
	}

	@Override
	public void setBirthDate(Calendar birthDate) {
		this.birthDate = birthDate;
	}	

}