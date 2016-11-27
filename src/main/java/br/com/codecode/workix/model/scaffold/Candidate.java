package br.com.codecode.workix.model.scaffold;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Past;

/**
 * Candidate JPA {@link Entity}
 * @see Person
 * @author felipe
 * @see Person
 * @since 1.1
 * @version 1.1
 */
@Entity
abstract class Candidate extends Person {

	private static final long serialVersionUID = 531807027259604477L;	
		
	@Column(nullable = false, unique = true)
	private long cpf;

	@Past
	@Temporal(TemporalType.DATE)
	@Column(nullable = false)	
	private Calendar birthDate;

	/**
	 * @return the cpf
	 */
	public final long getCpf() {
		return cpf;
	}

	/**
	 * @param cpf the cpf to set
	 */
	public final void setCpf(long cpf) {
		this.cpf = cpf;
	}

	/**
	 * @return the birthDate
	 */
	public final Calendar getBirthDate() {
		return birthDate;
	}

	/**
	 * @param birthDate the birthDate to set
	 */
	public final void setBirthDate(Calendar birthDate) {
		this.birthDate = birthDate;
	}			

}