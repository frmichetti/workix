package br.com.codecode.workix.model.scaffold;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import br.com.codecode.workix.model.interfaces.BaseEntity;

@Entity
public class NewsLetterSubscriber implements BaseEntity, Serializable{

	private static final long serialVersionUID = 6675137603968146834L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(updatable = false, nullable = false)
	private long id;

	@NotEmpty
	@Email	
	@Column(nullable = false,unique=true)
	private String email;
	
	public NewsLetterSubscriber(){}	

	public NewsLetterSubscriber(String email) {
		super();
		this.email = email;
	}

	@Override
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
