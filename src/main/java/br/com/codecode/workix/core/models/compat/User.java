package br.com.codecode.workix.core.models.compat;

import br.com.codecode.workix.interfaces.Buildable;

/**
 * User JPA with Inherited Fields and Methods
 * <br>Without Annotations
 * @author felipe
 * @since 1.1
 * @version 1.1
 * @see MyEntity
 */
public class User extends MyEntity {

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

    
    public String getEmail() {
	return email;
    }

    
    public String getFirebaseMessageToken() {
	return firebaseMessageToken;
    }
    
    public String getFirebaseUUID() {
	return firebaseUUID;
    }

    public long getId() {
	return this.id;
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