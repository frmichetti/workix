package br.com.codecode.workix.core.models.compat;

// TODO: Auto-generated Javadoc
/**
 * Person Class for Compatibility <br>
 * Abstract Class for share common Fields with {@link Company} and
 * {@link Candidate} <br>
 * Without Annotations.
 *
 * @author felipe
 * @version 1.1
 * @see MyEntity
 * @see Person
 * @see <a href=
 *      "http://wiki.fasterxml.com/JacksonFAQ#Deserializing_Abstract_types">
 *      DeSerializing Abstract Types</a>
 * @since 1.1
 */
abstract class Person extends MyEntity {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /** The contact. */
    private Contact contact;

    /** The locale. */
    private Locale locale;

    /** The name. */
    private String name;

    /** The user. */
    private User user;

    /**
     * Public Default Constructor.
     */
    public Person(){}

    /**
     * Gets the contact.
     *
     * @return the contact
     */
    public Contact getContact() {
	return contact;
    }

    /**
     * Gets the locale.
     *
     * @return the locale
     */
    public Locale getLocale() {
	return locale;
    }

    /**
     * Gets the name.
     *
     * @return the name
     */
    public String getName() {
	return name;
    }

    /**
     * Gets the user.
     *
     * @return the user
     */
    public User getUser() {
	return user;
    }

    /**
     * Sets the contact.
     *
     * @param contact the new contact
     */
    public void setContact(Contact contact) {
	this.contact = contact;
    }

    /**
     * Sets the locale.
     *
     * @param locale the new locale
     */
    public void setLocale(Locale locale) {
	this.locale = locale;
    }

    /**
     * Sets the name.
     *
     * @param name the new name
     */
    public void setName(String name) {
	this.name = name;
    }

    /**
     * Sets the user.
     *
     * @param user the new user
     */
    public void setUser(User user) {
	this.user = user;
    }

}
