package br.com.codecode.workix.core.models.compat;

/**
 * Person JPA with Inherited Fields and Methods <br>
 * Abstract Class for share common Fields with {@link Company} and
 * {@link Candidate}
 * <br>Without Annotations
 * @author felipe
 * @see MyEntity
 * @see Person
 * @since 1.1
 * @version 1.1 
 * @see <a href="http://wiki.fasterxml.com/JacksonFAQ#Deserializing_Abstract_types">
 * DeSerializing Abstract Types</a>
 */
abstract class Person extends MyEntity {

    private static final long serialVersionUID = 703693002246144451L;
    
    private String name;

    private User user;

    private Contact contact;

    private Locale locale;

    /**
     * Public Default Constructor for JPA Compatibility Only
     */
    public Person() {
    }

    public Contact getContact() {
	return contact;
    }

    public Locale getLocale() {
	return locale;
    }

    public String getName() {
	return name;
    }

    public User getUser() {
	return user;
    }

    public void setContact(Contact contact) {
	this.contact = contact;
    }

    public void setLocale(Locale locale) {
	this.locale = locale;
    }

    public void setName(String name) {
	this.name = name;
    }

    public void setUser(User user) {
	this.user = user;
    }

}
