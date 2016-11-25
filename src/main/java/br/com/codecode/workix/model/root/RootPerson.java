package br.com.codecode.workix.model.root;

import br.com.codecode.workix.model.base.BaseContact;
import br.com.codecode.workix.model.base.BaseLocale;
import br.com.codecode.workix.model.base.BaseUser;

/**
 * Root Abstract Class Person<br>
 * Use for Field Mapping/Share Only
 * <ul>
 * <li>{@link #name}</li>
 * <li>{@link #user}</li>
 * <li>{@link #contact}</li>
 * <li>{@link #locale}</li> 
 * </ul>
 * @author felipe
 * @since 1.0
 * @version 1.0
 * @see RootEntity
 */
public abstract class RootPerson extends RootEntity {

	private String name;

	private BaseUser user;	

	private BaseContact contact;

	private BaseLocale locale;
	
	/**
	 * Defaul Empty Constructor
	 */
	public RootPerson(){}

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
	public final BaseUser getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public final void setUser(BaseUser user) {
		this.user = user;
	}

	/**
	 * @return the contact
	 */
	public final BaseContact getContact() {
		return contact;
	}

	/**
	 * @param contact the contact to set
	 */
	public final void setContact(BaseContact contact) {
		this.contact = contact;
	}

	/**
	 * @return the locale
	 */
	public final BaseLocale getLocale() {
		return locale;
	}

	/**
	 * @param locale the locale to set
	 */
	public final void setLocale(BaseLocale locale) {
		this.locale = locale;
	}
	
	
}
