package br.com.codecode.workix.model.scaffold;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Contact JPA {@link Embeddable}
 * @author felipe
 * @since 1.1
 * @version 1.1
 * @see Serializable
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@Embeddable
abstract class Contact implements Serializable {

	private static final long serialVersionUID = -2482737185460142872L;
	
	@Column
	private long mobilePhone;

	/**
	 * @return the mobilePhone
	 */
	public final long getMobilePhone() {
		return mobilePhone;
	}

	/**
	 * @param mobilePhone the mobilePhone to set
	 */
	public final void setMobilePhone(long mobilePhone) {
		this.mobilePhone = mobilePhone;
	}	
	
	

}
