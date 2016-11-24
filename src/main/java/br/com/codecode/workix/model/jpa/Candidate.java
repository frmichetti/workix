package br.com.codecode.workix.model.jpa;

import java.util.Calendar;

import javax.annotation.PostConstruct;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Past;

/**
 * Candidate JPA {@link Entity}
 * @see Person
 * @author felipe
 */
@Entity
public class Candidate extends Person {

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

	public long getCpf() {
		return cpf;
	}

	public void setCpf(long cpf) {
		this.cpf = cpf;
	}

	public Calendar getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Calendar birthDate) {
		this.birthDate = birthDate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (getId() ^ (getId() >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Candidate other = (Candidate) obj;
		if (getId() != other.getId())
			return false;
		return true;
	}

	

}