package br.com.codecode.workix.jpa.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import br.com.codecode.workix.cdi.qualifiers.Persist;
import br.com.codecode.workix.interfaces.Buildable;
import br.com.codecode.workix.interfaces.Notificable;
import br.com.codecode.workix.model.actions.UserActions;
import br.com.codecode.workix.model.base.BaseUser;

/**
 * User JPA with Inherited Fields and Methods
 * 
 * @author felipe
 * @since 1.0
 * @version 1.1
 * @see MyEntity
 * @see UserActions
 * @see Notificable
 */
@Entity
@XmlRootElement
@XmlAccessorType(XmlAccessType.PUBLIC_MEMBER)
@Persist
public class User extends MyEntity implements Notificable {

    private static final long serialVersionUID = -610648880358327958L;

    private long id;

    private boolean active;

    private String email, firebaseUUID, firebaseMessageToken;

    /**
     * Public Default Constructor for JPA Compatibility Only
     */
    public User() {
    }

    /**
     * Public Constructor for {@link Builder} Compatibility
     * 
     * @see Buildable
     * @param builder
     *            Builder for Generate a New User
     */
    public User(Builder builder) {

	this.active = builder.isActive();

	this.email = builder.getEmail();

	this.firebaseUUID = builder.getFirebaseUUID();

	this.firebaseMessageToken = builder.getFirebaseMessageToken();
    }

    @NotEmpty
    @Email
    @Column(nullable = false, unique = true)
    @Override
    public String getEmail() {
	return email;
    }

    @NotEmpty
    @Column
    @Override
    public String getFirebaseMessageToken() {
	return firebaseMessageToken;
    }

    @NotEmpty
    @Column
    @Override
    public String getFirebaseUUID() {
	return firebaseUUID;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false)
    @Override
    public long getId() {
	return this.id;
    }

    @Column
    public boolean isActive() {
	return active;
    }

    public void setActive(boolean active) {
	this.active = active;
    }

    @Override
    public void setEmail(String email) {
	this.email = email;
    }

    @Override
    public void setFirebaseMessageToken(String firebaseMessageToken) {
	this.firebaseMessageToken = firebaseMessageToken;
    }

    @Override
    public void setFirebaseUUID(String firebaseUUID) {
	this.firebaseUUID = firebaseUUID;
    }

    @Override
    public void setId(long id) {
	this.id = id;
    }

    /**
     * Builder NestedClass for {@link User}
     * 
     * @author felipe
     * @since 1.0
     * @version 1.0
     * @see Buildable
     * @see BaseUser
     */
    public final static class Builder extends User implements Buildable<User> {

	private static final long serialVersionUID = -7766145008890656904L;

	/**
	 * Disabled Empty Constructor
	 */
	private Builder() {
	}

	/**
	 * Constructor with Required Fields
	 * 
	 * @param email
	 *            Email
	 */
	public Builder(String email) {
	    this();
	    this.setEmail(email);
	}

	/**
	 * Constructor with All Fields
	 * 
	 * @param active
	 *            Active
	 * @param email
	 *            Email
	 * @param firebaseUUID
	 *            Firebase UUID
	 * @param firebaseMessageToken
	 *            Firebase Message Token
	 */
	public Builder(String email, boolean active, String firebaseUUID, String firebaseMessageToken) {
	    this(email);
	    this.setActive(active);
	    this.setFirebaseUUID(firebaseUUID);
	    this.setFirebaseMessageToken(firebaseMessageToken);
	}

	/**
	 * Return a New User
	 */
	@Override
	public User build() {
	    return new User(this);
	}

	/**
	 * @param active
	 *            the active to set
	 * @return Builder
	 */
	public Builder withActive(boolean active) {
	    this.setActive(active);
	    return this;
	}

	/**
	 * @param email
	 *            the email to set
	 * @return Builder
	 */
	public Builder withEmail(String email) {
	    this.setEmail(email);
	    return this;
	}

	/**
	 * @param firebaseMessageToken
	 *            the firebaseMessageToken to set
	 * @return Builder
	 */
	public Builder withFirebaseMessageToken(String firebaseMessageToken) {
	    this.setFirebaseMessageToken(firebaseMessageToken);
	    return this;
	}

	/**
	 * @param firebaseUUID
	 *            the firebaseUUID to set
	 * @return Builder
	 */
	public Builder withFirebaseUUID(String firebaseUUID) {
	    this.setFirebaseUUID(firebaseUUID);
	    return this;
	}

    }

}