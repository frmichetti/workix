package br.com.codecode.workix.model.base;

import br.com.codecode.workix.model.actions.ContactActions;
import br.com.codecode.workix.model.actions.LocaleActions;
import br.com.codecode.workix.model.actions.UserActions;

/**
 * Root Abstract Class Person<br>
 * Use for Field Mapping/Share Only
 * <ul>
 * <li>{@link #name}</li>
 * <li>{@link #user}</li>
 * <li>{@link #contact}</li>
 * <li>{@link #locale}</li>
 * </ul>
 * 
 * @author felipe
 * @since 1.0
 * @version 1.0
 * @see BaseEntity
 */
public abstract class BasePerson extends BaseEntity {

    private String name;

    private UserActions user;

    private ContactActions contact;

    private LocaleActions locale;

    /**
     * Defaul Empty Constructor
     */
    public BasePerson() {
    }

    /**
     * @return the name
     */
    public String getName() {
	return name;
    }

    /**
     * @param name
     *            the name to set
     */
    public void setName(String name) {
	this.name = name;
    }

    /**
     * @return the user
     */
    public UserActions getUser() {
	return user;
    }

    /**
     * @param user
     *            the user to set
     */
    public void setUser(UserActions user) {
	this.user = user;
    }

    /**
     * @return the contact
     */
    public ContactActions getContact() {
	return contact;
    }

    /**
     * @param contact
     *            the contact to set
     */
    public void setContact(ContactActions contact) {
	this.contact = contact;
    }

    /**
     * @return the locale
     */
    public LocaleActions getLocale() {
	return locale;
    }

    /**
     * @param locale
     *            the locale to set
     */
    public void setLocale(LocaleActions locale) {
	this.locale = locale;
    }

}
