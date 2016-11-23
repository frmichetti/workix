package br.com.codecode.workix.model.scaffold;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Candidate extends Person {

	private static final long serialVersionUID = 531807027259604477L;	

	@NotEmpty	
	@Column(nullable = false,unique = true)
	private String cpf;

	@Temporal(TemporalType.DATE)
	@Column(nullable = false)	
	private Calendar birthDate;	

	public Candidate(){
		configure();		
	}	

	private void configure() {
		birthDate = Calendar.getInstance();		
	}	


	public String getCpf() {
		return cpf;
	}


	public void setCpf(String cpf) {
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

	@Override
	public String toString() {
		return "Candidate [name=" + getName() + ", cpf=" + cpf + "]";
	}

}