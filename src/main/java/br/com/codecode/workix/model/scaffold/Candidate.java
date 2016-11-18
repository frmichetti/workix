package br.com.codecode.workix.model.scaffold;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.validator.constraints.NotEmpty;

import com.google.gson.annotations.Expose;

import br.com.codecode.workix.model.scaffold.interfaces.BasicEntity;

@Entity
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Candidate extends Person implements BasicEntity{

	private static final long serialVersionUID = 531807027259604477L;	
	
	@Expose
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(updatable = false, nullable = false)
	private Long id;

	//@CPF
	@NotEmpty
	@Expose
	@Column(nullable = false,unique=true)
	private String cpf;
	
	//@Past
	@Expose
	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable=false)
	private Date birthDate;	
	
	public Candidate(){
		configure();		
	}	
	
	private void configure() {
		birthDate = new Date();		
	}

	public Long getId() {
		return this.id;
	}

	public void setId(final Long id) {
		this.id = id;
	}	

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}	
	

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Candidate [name=" + super.name + ", cpf=" + cpf + "]";
	}	
	
	
	
	

	

	
}