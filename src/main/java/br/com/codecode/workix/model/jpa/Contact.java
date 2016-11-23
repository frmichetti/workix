package br.com.codecode.workix.model.jpa;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import br.com.codecode.workix.model.interfaces.Buildable;

/**
 * Contact JPA {@link Embeddable}
 * @author felipe
 * @category JPA
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@Embeddable
public class Contact implements Serializable {

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
	 * @param builder
	 * @category Builder
	 */
	public Contact(Builder builder) {
		this.mobilePhone = builder.mobilePhone;
	}

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
	 * @category Builder
	 * @author felipe
	 *
	 */
	public static class Builder implements Buildable<Contact> {	

		private long mobilePhone;

		private Builder(){}		

		public Builder(long mobilePhone) {
			this();			
			this.mobilePhone = mobilePhone;
		}
		
		public Builder(int mobilePhone) {
			this();			
			this.mobilePhone = mobilePhone;
		}
	
		public Builder setMobilePhone(long mobilePhone) {
			this.mobilePhone = mobilePhone;
			return this;
		}
		
		public Builder setMobilePhone(int mobilePhone) {
			this.mobilePhone = mobilePhone;
			return this;
		}

		@Override
		public Contact build()
		{
			return new Contact(this);
		}

	}	


}
