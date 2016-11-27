package br.com.codecode.workix.model.scaffold;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * Subscriber JPA {@link Entity}
 * @author felipe
 * @since 1.1
 * @version 1.1  
 * @see Serializable
 */
@Entity
abstract class Subscriber implements Serializable {

	private static final long serialVersionUID = 6675137603968146834L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(updatable = false, nullable = false)
	private long id;	

	@NotEmpty
	@Email	
	@Column(nullable = false,unique = true)
	private String email;

	/**
	 * @return the id
	 */
	public final long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public final void setId(long id) {
		this.id = id;
	}

	/**
	 * @return the email
	 */
	public final String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public final void setEmail(String email) {
		this.email = email;
	}	

	
}
