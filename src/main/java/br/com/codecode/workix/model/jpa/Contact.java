package br.com.codecode.workix.model.jpa;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import br.com.codecode.workix.model.interfaces.Buildable;
import br.com.codecode.workix.model.root.RootContact;

/**
 * Contact JPA {@link Embeddable}
 * @author felipe
 * @since 1.0
 * @version 1.0
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@Embeddable
public class Contact extends RootContact implements Serializable {

	private static final long serialVersionUID = -2482737185460142872L;

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

	@Column
	public long getMobilePhone() {
		return mobilePhone;
	}

	public void setMobilePhone(long mobilePhone) {
		this.mobilePhone = mobilePhone;
	}

	@Override
	public String toString() {
		return "Contact [mobilePhone=" + mobilePhone + "]";
	}
	
	/**
	 * Builder NestedClass for {@link Contact} 
	 * @author felipe
	 * @since 1.0
	 * @version 1.0
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
			this.mobilePhone = mobilePhone;
		}		
		
		/**
		 * @return the mobilePhone
		 */
		public final long getMobilePhone() {
			return mobilePhone;
		}
	
		/**
		 * @param mobilePhone the mobilePhone to set
		 */
		public Builder setMobilePhone(long mobilePhone) {
			this.mobilePhone = mobilePhone;
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
