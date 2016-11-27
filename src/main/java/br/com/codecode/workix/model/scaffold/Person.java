package br.com.codecode.workix.model.scaffold;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/**
 * Person JPA {@link MappedSuperclass} 
 * <br>Abstract Class for share common Fields with {@link Company} and {@link Candidate}
 * @author felipe
 * @see MyEntity
 * @since 1.1
 * @version 1.1
 * <a href= "http://wiki.fasterxml.com/JacksonFAQ#Deserializing_Abstract_types">Deserializing Abstract Types</a>
 */
@MappedSuperclass
abstract class Person extends MyEntity {
	
	private static final long serialVersionUID = 703693002246144451L;	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(updatable = false, nullable = false)
	private long id;

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
	 * @return the name
	 */
	public final String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public final void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the user
	 */
	public final User getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public final void setUser(User user) {
		this.user = user;
	}

	/**
	 * @return the contact
	 */
	public final Contact getContact() {
		return contact;
	}

	/**
	 * @param contact the contact to set
	 */
	public final void setContact(Contact contact) {
		this.contact = contact;
	}

	/**
	 * @return the locale
	 */
	public final Locale getLocale() {
		return locale;
	}

	/**
	 * @param locale the locale to set
	 */
	public final void setLocale(Locale locale) {
		this.locale = locale;
	}		

}
