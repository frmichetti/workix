package br.com.codecode.workix.core.models.compat;

import javax.annotation.Generated;

// TODO: Auto-generated Javadoc
/**
 * User Class for Compatibility
 * <br>Without Annotations .
 *
 * @author felipe
 * @version 1.1
 * @see MyEntity
 * @since 1.1
 */
public class User extends MyEntity {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /** The active. */
    private boolean active;

    /** The firebase message token. */
    private String email, firebaseUUID, firebaseMessageToken;

    /** The id. */
    private long id;

    @Generated("SparkTools")
    private User(Builder builder) {
	this.active = builder.active;
	this.email = builder.email;
	this.firebaseUUID = builder.firebaseUUID;
	this.firebaseMessageToken = builder.firebaseMessageToken;
	this.id = builder.id;
    }

    /**
     * Public Default Constructor.
     */
    public User(){}   

    /**
     * Gets the email.
     *
     * @return the email
     */
    public String getEmail() {
	return email;
    }

    /**
     * Gets the firebase message token.
     *
     * @return the firebase message token
     */
    public String getFirebaseMessageToken() {
	return firebaseMessageToken;
    }

    /**
     * Gets the firebase UUID.
     *
     * @return the firebase UUID
     */
    public String getFirebaseUUID() {
	return firebaseUUID;
    }

    /**
     * Gets the id.
     *
     * @return the id
     */
    public long getId() {
	return this.id;
    }

    /**
     * Checks if is active.
     *
     * @return true, if is active
     */
    public boolean isActive() {
	return active;
    }

    /**
     * Sets the active.
     *
     * @param active the new active
     */
    public void setActive(boolean active) {
	this.active = active;
    }

    /**
     * Sets the email.
     *
     * @param email the new email
     */
    public void setEmail(String email) {
	this.email = email;
    }

    /**
     * Sets the firebase message token.
     *
     * @param firebaseMessageToken the new firebase message token
     */
    public void setFirebaseMessageToken(String firebaseMessageToken) {
	this.firebaseMessageToken = firebaseMessageToken;
    }

    /**
     * Sets the firebase UUID.
     *
     * @param firebaseUUID the new firebase UUID
     */
    public void setFirebaseUUID(String firebaseUUID) {
	this.firebaseUUID = firebaseUUID;
    }

    /**
     * Sets the id.
     *
     * @param id the new id
     */
    public void setId(long id) {
	this.id = id;
    }

    /**
     * Creates builder to build {@link User}.
     * @return created builder
     */
    @Generated("SparkTools")
    public static Builder builder() {

	return new Builder();
    }

    /**
     * Builder to build {@link User}.
     */
    @Generated("SparkTools")
    public static final class Builder {

	private boolean active;

	private String email;

	private String firebaseUUID;

	private String firebaseMessageToken;

	private long id;

	private Builder() {
	}

	public Builder withActive(boolean active) {

	    this.active = active;
	    return this;
	}

	public Builder withEmail(String email) {

	    this.email = email;
	    return this;
	}

	public Builder withFirebaseUUID(String firebaseUUID) {

	    this.firebaseUUID = firebaseUUID;
	    return this;
	}

	public Builder withFirebaseMessageToken(String firebaseMessageToken) {

	    this.firebaseMessageToken = firebaseMessageToken;
	    return this;
	}

	public Builder withId(long id) {

	    this.id = id;
	    return this;
	}

	public User build() {

	    return new User(this);
	}
    }    
}