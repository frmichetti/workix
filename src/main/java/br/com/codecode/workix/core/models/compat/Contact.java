package br.com.codecode.workix.core.models.compat;

import java.io.Serializable;
import javax.annotation.Generated;

// TODO: Auto-generated Javadoc
/**
 * Contact Class for Compatibility
 * <br>Without Annotations .
 *
 * @author felipe
 * @version 1.1
 * @see Serializable
 * @since 1.1
 */
public class Contact implements Serializable {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /** The mobile phone. */
    private long mobilePhone;

    @Generated("SparkTools")
    private Contact(Builder builder) {
	this.mobilePhone = builder.mobilePhone;
    }

    /**
     * Public Default Constructor.
     */
    public Contact(){}    

    /**
     * Gets the mobile phone.
     *
     * @return the Mobile Phone
     */
    public long getMobilePhone() {
	return mobilePhone;
    }

    /**
     * Sets the mobile phone.
     *
     * @param mobilePhone            the Mobile Phone to set
     */
    public final void setMobilePhone(long mobilePhone) {
	this.mobilePhone = mobilePhone;
    }

    /**
     * Creates builder to build {@link Contact}.
     * @return created builder
     */
    @Generated("SparkTools")
    public static Builder builder() {

	return new Builder();
    }

    /**
     * Builder to build {@link Contact}.
     */
    @Generated("SparkTools")
    public static final class Builder {

	private long mobilePhone;

	private Builder() {
	}

	public Builder withMobilePhone(long mobilePhone) {

	    this.mobilePhone = mobilePhone;
	    return this;
	}

	public Contact build() {

	    return new Contact(this);
	}
    }    
}
