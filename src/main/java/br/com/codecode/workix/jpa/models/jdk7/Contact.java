package br.com.codecode.workix.jpa.models.jdk7;

import br.com.codecode.workix.interfaces.Buildable;

import java.io.Serializable;

/**
 * Contact JPA Embeddable
 * No Anotation for Compatibility Only with Older Versions
 * @author felipe
 * @since 1.0
 * @version 1.1
 * @see Serializable
 */
public class Contact implements Serializable {

    private static final long serialVersionUID = -2482737185460142872L;

    private long mobilePhone;

    /**
     * Public Default Constructor for JPA Compatibility Only
     */
    public Contact(){}

    /**
     * Public Constructor for {@link Builder} Compatibility
     * 
     * @see Buildable
     * @param builder
     *            Builder for Generate a New Contact
     */
    public Contact(Builder builder) {
	this.mobilePhone = builder.getMobilePhone();
    }

    /**
     * Creates builder to build {@link Contact}.
     * @return created builder
     */    
    public static Builder builder() {
	return new Builder();
    }

    /**
     * @return the Mobile Phone
     */    
    public long getMobilePhone() {
	return mobilePhone;
    }

    /**
     * @param mobilePhone
     *            the Mobile Phone to set
     */
    public void setMobilePhone(long mobilePhone) {
	this.mobilePhone = mobilePhone;
    }

    /**
     * Builder NestedClass for {@link Contact}
     * 
     * @author felipe
     * @since 1.0
     * @version 1.0
     * @see Contact
     * @see Buildable 
     */
    public final static class Builder extends Contact implements Buildable<Contact> {

	private static final long serialVersionUID = -6671372786495157443L;

	/**
	 * Disabled Empty Constructor
	 */
	private Builder(){}	

	/**
	 * @return a new Contact
	 */
	@Override
	public Contact build() {
	    return new Contact(this);
	}

	/**
	 * @param mobilePhone
	 *            the Mobile Phone to set
	 * @return Builder
	 */
	public Builder withMobilePhone(long mobilePhone) {
	    this.setMobilePhone(mobilePhone);
	    return this;
	}

    }

}
