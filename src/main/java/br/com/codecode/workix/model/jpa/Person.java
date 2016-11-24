package br.com.codecode.workix.model.jpa;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * Person JPA {@link MappedSuperclass} 
 * <br>Abstract Class for share common Fields with {@link Company} and {@link Candidate}
 * @author felipe
 */
@MappedSuperclass
public abstract class Person extends MyEntity {

	private static final long serialVersionUID = 703693002246144451L;

	@NotEmpty	
	@Column(nullable = false)
	private String name;

	@NotNull	
	@OneToOne(optional = false)
	private User user;	

	@Embedded
	private Contact contact;

	@Embedded	
	private Locale locale;

	/**
	 * Public Default Constructor for JPA Compatibility Only
	 */
	public Person(){}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}	

	public Contact getContact() {
		return contact;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Locale getLocale() {
		return locale;
	}

	public void setLocale(Locale locale) {
		this.locale = locale;
	}

}
