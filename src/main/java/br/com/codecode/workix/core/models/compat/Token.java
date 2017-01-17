/**
 *
 * @author Felipe Rodrigues Michetti
 * @see http://portfolio-frmichetti.rhcloud.com
 * @see http://www.codecode.com.br
 * @see mailto:frmichetti@gmail.com
 * */
package br.com.codecode.workix.core.models.compat;

import java.util.Calendar;

import javax.annotation.Generated;

// TODO: Auto-generated Javadoc
/**
 * Token Model.
 *
 * @author felipe
 * @version 1.1
 * @since 1.0
 */
public final class Token {

    /** The created at. */
    private Calendar createdAt;

    /** The key. */
    private String key;

    /**
     * Public Default Constructor.
     */
    private Token(){}

    /**
     * Instantiates a new token.
     *
     * @param builder the builder
     */
    @Generated("SparkTools")
    private Token(Builder builder) {
	this.createdAt = builder.createdAt;
	this.key = builder.key;
    }

    /**
     * Creates builder to build {@link Token}.
     * 
     * @return created builder
     */
    @Generated("SparkTools")
    public static Builder builder() {
	return new Builder();
    }

    /**
     * Gets the created at.
     *
     * @return the created at
     */
    public Calendar getCreatedAt() {
	return createdAt;
    }

    /**
     * Gets the key.
     *
     * @return the key
     */
    public String getKey() {
	return key;
    }

    /**
     * Sets the created at.
     *
     * @param createdAt the new created at
     */
    protected void setCreatedAt(Calendar createdAt) {
	this.createdAt = createdAt;
    }

    /**
     * Sets the key.
     *
     * @param key the new key
     */
    public void setKey(String key) {
	this.key = key;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
	return new StringBuilder()
		.append("Token [createdAt=")
		.append(createdAt)
		.append(", key=")
		.append(key)
		.append("]").toString();
    }

    /**
     * Builder to build {@link Token}.
     */
    @Generated("SparkTools")
    public static final class Builder {

	/** The created at. */
	private Calendar createdAt;

	/** The key. */
	private String key;

	/**
	 * Instantiates a new builder.
	 */
	private Builder(){}

	/**
	 * Builds the.
	 *
	 * @return the token
	 */
	public Token build() {
	    return new Token(this);
	}

	/**
	 * With key.
	 *
	 * @param key the key
	 * @return the builder
	 */
	public Builder withKey(String key) {
	    this.createdAt = Calendar.getInstance();
	    this.key = key;	    
	    return this;
	}
    }

}
