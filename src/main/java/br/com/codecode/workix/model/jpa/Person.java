package br.com.codecode.workix.model.jpa;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import br.com.codecode.workix.model.interfaces.Persistable;

@MappedSuperclass
public abstract class Person extends MyEntity implements Persistable {

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
