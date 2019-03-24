package br.com.codecode.workix.jpa.models;

import br.com.codecode.workix.jpa.models.jdk7.MyEntity;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;

/**
 * Person JPA with Inherited Fields and Methods <br>
 * Abstract Class for share common Fields with {@link Company} and
 * {@link Candidate}
 * No Anotation for Compatibility Only with Older Versions
 *
 * @author felipe
 * @version 1.1
 * @see MyEntity
 * @see <a href="http://wiki.fasterxml.com/JacksonFAQ#Deserializing_Abstract_types">
 * DeSerializing Abstract Types</a>
 * @since 1.0
 */
@MappedSuperclass
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

    @JsonDeserialize(as = br.com.codecode.workix.jpa.models.Contact.class)
    @Embedded
    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    @JsonDeserialize(as = br.com.codecode.workix.jpa.models.Locale.class)
    @Embedded
    public Locale getLocale() {
        return locale;
    }

    public void setLocale(Locale locale) {
        this.locale = locale;
    }

    @NotEmpty
    @Column(nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @JsonDeserialize(as = br.com.codecode.workix.jpa.models.User.class)
    @OneToOne(optional = false)
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
