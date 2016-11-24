package br.com.codecode.workix.model.jpa;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import br.com.codecode.workix.model.base.BaseContact;
import br.com.codecode.workix.model.base.BaseLocale;
import br.com.codecode.workix.model.base.BasePerson;
import br.com.codecode.workix.model.base.BaseUser;

/**
 * Person JPA {@link MappedSuperclass} 
 * <br>Abstract Class for share common Fields with {@link Company} and {@link Candidate}
 * @author felipe
 * @see MyEntity
 * @see BasePerson
 * <a href= "http://wiki.fasterxml.com/JacksonFAQ#Deserializing_Abstract_types">Deserializing Abstract Types</a>
 */
@MappedSuperclass
public abstract class Person extends MyEntity implements BasePerson {

	private static final long serialVersionUID = 703693002246144451L;

	@NotEmpty	
	@Column(nullable = false)
	private String name;

	@JsonDeserialize(as=User.class)
	@NotNull	
	@OneToOne(optional = false)
	private User user;	

	@JsonDeserialize(as=Contact.class)
	@Embedded
	private Contact contact;
 
	@JsonDeserialize(as=Locale.class)
	@Embedded	
	private Locale locale;

	/**
	 * Public Default Constructor for JPA Compatibility Only
	 */
	public Person(){}
	
	@Override
	public String getName() {
		return name;
	}
	
	@Override
	public void setName(String name) {
		this.name = name;
	}	
  
	@Override
	public Contact getContact() {
		return contact;
	}	

  
	@Override
	public User getUser() {
		return user;
	}	

	
	@Override
	public Locale getLocale() {
		return locale;
	}	
	
	@Override
	public void setContact(BaseContact contact) {
		this.contact = (Contact) contact;
		
	}

	@Override
	public void setUser(BaseUser user) {
		this.user = (User) user;
		
	}

	@Override
	public void setLocale(BaseLocale locale) {
		this.locale = (Locale) locale;
		
	}

	@Override
	public String toString() {
		return "Person [name=" + name + "]";
	}

}
