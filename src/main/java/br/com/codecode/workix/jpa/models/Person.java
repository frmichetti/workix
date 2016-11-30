package br.com.codecode.workix.jpa.models;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/**
 * Person JPA with Inherited Fields and Methods <br>
 * Abstract Class for share common Fields with {@link Company} and
 * {@link Candidate}
 * 
 * @author felipe
 * @see MyEntity
 * @see Person
 * @since 1.0
 * @version 1.1 <a href=
 *          "http://wiki.fasterxml.com/JacksonFAQ#Deserializing_Abstract_types">Deserializing
 *          Abstract Types</a>
 */
@MappedSuperclass
abstract class Person extends MyEntity {

    private static final long serialVersionUID = 703693002246144451L;

    @Column(nullable = false)
    private String name;

    @JsonDeserialize(as = User.class)
    @OneToOne(optional = false)
    private User user;

    @JsonDeserialize(as = Contact.class)
    @Embedded
    private Contact contact;

    @JsonDeserialize(as = Locale.class)
    @Embedded
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
