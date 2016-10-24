package br.com.codecode.openjobs.model.scaffold;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.validator.constraints.NotEmpty;

import com.google.gson.annotations.Expose;

import br.com.codecode.openjobs.model.scaffold.interfaces.BasicEntity;

@Entity
@Table(name="openjobs_Candidates")
@XmlRootElement
public class Candidate extends Loggable implements BasicEntity{

	private static final long serialVersionUID = 531807027259604477L;

	@Expose
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(updatable = false, nullable = false)
	private Long id;

	@NotEmpty
	@Expose
	@Column(nullable = false)
	private String name;

	@NotEmpty
	@Expose
	@Column(nullable = false,unique=true)
	private String cpf;

	@NotNull
	@Expose
	@OneToOne(optional=false)
	private User user;
	
	public Candidate(){}
		
	public Long getId() {
		return this.id;
	}

	public void setId(final Long id) {
		this.id = id;
	}	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
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
		return "Candidate [name=" + name + ", cpf=" + cpf + "]";
	}	
	
	
	
	

	

	
}