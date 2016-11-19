package br.com.codecode.workix.model.scaffold;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

import org.hibernate.validator.constraints.NotEmpty;

import com.google.gson.annotations.Expose;

import br.com.codecode.workix.model.Loggable;
import br.com.codecode.workix.model.interfaces.BasicEntity;

@MappedSuperclass
@XmlAccessorType(XmlAccessType.FIELD)
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
