package br.com.codecode.workix.model.jpa;

import java.io.Serializable;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;

import br.com.codecode.workix.interfaces.Buildable;
import br.com.codecode.workix.model.base.BaseContact;
import br.com.codecode.workix.model.root.RootContact;

/**
 * Contact JPA with Inherited Fields and Methods
 * @author felipe
 * @since 1.0
 * @version 1.1
 * @see BaseContact
 * @see Serializable
 */
public class Contact implements BaseContact, Serializable {

	private static final long serialVersionUID = -2482737185460142872L;
	
	@Column
	private long mobilePhone;

	/**
	 * Public Default Constructor for JPA Compatibility Only
	 */
	public Contact(){}
	
	/**
	 * Public Constructor for {@link Builder} Compatibility
	 * @see Buildable
	 * @param builder Builder for Generate a New Contact
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
	 * @param mobilePhone the Mobile Phone to set
	 */
	public final void setMobilePhone(long mobilePhone) {
		this.mobilePhone = mobilePhone;
	}

	/**
	 * Builder NestedClass for {@link Contact} 
	 * @author felipe
	 * @since 1.0
	 * @version 1.0
	 * @see Buildable
	 * @see RootContact
	 */
	public final static class Builder extends RootContact implements Buildable<Contact> {		

		/**
		 * Disabled Empty Constructor
		 */
		private Builder(){}		

		/**
		 * Constructor with Required Fields
		 * @param mobilePhone Mobile Phone 
		 */
		public Builder(long mobilePhone) {
			this();			
			this.setMobilePhone(mobilePhone);			
		}		
	
		/**
		 * @param mobilePhone the Mobile Phone to set
		 * @return Builder
		 */
		public Builder withMobilePhone(long mobilePhone) {
			this.setMobilePhone(mobilePhone);
			return this;
		}		

		/**
		 * @return A new Contact
		 */
		@Override
		public Contact build()
		{
			return new Contact(this);
		}

	}	


}
