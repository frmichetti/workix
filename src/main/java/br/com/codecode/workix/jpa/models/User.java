package br.com.codecode.workix.jpa.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import br.com.codecode.workix.interfaces.Buildable;
import br.com.codecode.workix.interfaces.Notificable;
import br.com.codecode.workix.model.actions.UserActions;
import br.com.codecode.workix.model.base.BaseUser;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

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
public class User extends MyEntity implements Notificable {

    /**
     * Builder NestedClass for {@link User}
     * 
     * @author felipe
     * @since 1.0
     * @version 1.0
     * @see Buildable
     * @see BaseUser
     */
    public final static class Builder extends BaseUser implements Buildable<User> {

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

    private static final long serialVersionUID = -610648880358327958L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false)
    private long id;

    @Column
    private boolean active;

    @NotEmpty
    @Email
    @Column(nullable = false, unique = true)
    private String email;

    @Column
    private String firebaseUUID;

    @Column
    private String firebaseMessageToken;

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

    @Override
    public String getEmail() {
	return email;
    }

    @Override
    public String getFirebaseMessageToken() {
	return firebaseMessageToken;
    }

    public String getFirebaseUUID() {
	return firebaseUUID;
    }

    @Override
    public long getId() {
	return this.id;
    }

    public String getUniqueID() {
	return super.getUuid();
    }

    public boolean isActive() {
	return active;
    }

    public void setActive(boolean active) {
	this.active = active;
    }

    public void setEmail(String email) {
	this.email = email;
    }

    public void setFirebaseMessageToken(String firebaseMessageToken) {
	this.firebaseMessageToken = firebaseMessageToken;
    }

    public void setFirebaseUUID(String firebaseUUID) {
	this.firebaseUUID = firebaseUUID;
    }

    @Override
    public void setId(long id) {
	this.id = id;
    }

}