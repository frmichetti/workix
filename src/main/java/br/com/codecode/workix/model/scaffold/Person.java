package br.com.codecode.workix.model.scaffold;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import com.google.gson.annotations.Expose;

import br.com.codecode.workix.model.scaffold.interfaces.BasicEntity;

@MappedSuperclass
public abstract class Person extends Loggable implements BasicEntity {

	private static final long serialVersionUID = 703693002246144451L;

	@NotEmpty
	@Expose
	@Column(nullable = false)
	protected String name;
	
	@NotNull
	@Expose
	@OneToOne(optional=false)
	protected User user;
	
	@Expose
	@Embedded
	private Locale locale;
	
	@Expose
	@Embedded
	private Contact contact;
	
	public Person(){}	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public Locale getLocale() {
		return locale;
	}

	public void setLocale(Locale locale) {
		this.locale = locale;
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


	
	

}
