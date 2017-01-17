package br.com.codecode.workix.core.models.compat;

import javax.annotation.Generated;

// TODO: Auto-generated Javadoc
/**
 * Subscriber Class for Compatibility
 * <br>Without Annotations.
 *
 * @author felipe
 * @version 1.1
 * @see MyEntity
 * @since 1.1
 */
public class Subscriber extends MyEntity {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /** The email. */
    private String email;

    /** The id. */
    private long id;

    @Generated("SparkTools")
    private Subscriber(Builder builder) {
	this.email = builder.email;
	this.id = builder.id;
    }

    /**
     * Public Default Constructor.
     */
    public Subscriber(){}    

    /**
     * Gets the email.
     *
     * @return the email
     */
    public String getEmail() {
	return email;
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
     * Sets the email.
     *
     * @param email            the email to set
     */
    public void setEmail(String email) {
	this.email = email;
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
     * Creates builder to build {@link Subscriber}.
     * @return created builder
     */
    @Generated("SparkTools")
    public static Builder builder() {

	return new Builder();
    }

    /**
     * Builder to build {@link Subscriber}.
     */
    @Generated("SparkTools")
    public static final class Builder {

	private String email;

	private long id;

	private Builder() {
	}

	public Builder withEmail(String email) {

	    this.email = email;
	    return this;
	}

	public Builder withId(long id) {

	    this.id = id;
	    return this;
	}

	public Subscriber build() {

	    return new Subscriber(this);
	}
    }    

}
