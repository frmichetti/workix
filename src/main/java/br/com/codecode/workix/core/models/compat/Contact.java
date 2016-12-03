package br.com.codecode.workix.core.models.compat;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import br.com.codecode.workix.core.models.jdk8.root.BaseContact;
import br.com.codecode.workix.interfaces.Buildable;

/**
 * Contact JPA with Inherited Fields and Methods
 * <br>Without Annotations
 * @author felipe
 * @since 1.1
 * @version 1.1
 * @see Serializable
 */
public class Contact implements Serializable {

    /**
     * Builder NestedClass for {@link Contact}
     * 
     * @author felipe
     * @since 1.0
     * @version 1.0
     * @see Buildable
     * @see BaseContact
     */
    public final static class Builder extends Contact implements Buildable<Contact> {

	private static final long serialVersionUID = -6671372786495157443L;

	/**
	 * Disabled Empty Constructor
	 */
	private Builder() {
	}

	/**
	 * Constructor with Required Fields
	 * 
	 * @param mobilePhone
	 *            Mobile Phone
	 */
	public Builder(long mobilePhone) {
	    this();
	    this.setMobilePhone(mobilePhone);
	}

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

    private static final long serialVersionUID = -2482737185460142872L;

    private long mobilePhone;

    /**
     * Public Default Constructor for JPA Compatibility Only
     */
    public Contact() {
    }

    /**
     * Public Constructor for {@link Builder} Compatibility
     * 
     * @see Buildable
     * @param builder
     *            Builder for Generate a New Contact
     */
    public Contact(@NotNull Builder builder) {
	this.mobilePhone = builder.getMobilePhone();
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
    public final void setMobilePhone(long mobilePhone) {
	this.mobilePhone = mobilePhone;
    }

}
