package br.com.codecode.workix.model.scaffold;

import java.io.Serializable;
import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@Embeddable
public class Contact implements Serializable {

	private static final long serialVersionUID = -2482737185460142872L;
		
	@Column
	private BigInteger mobilePhone;
	
	public Contact(){}
	
	public BigInteger getMobilePhone() {
		return mobilePhone;
	}

	public void setMobilePhone(BigInteger mobilePhone) {
		this.mobilePhone = mobilePhone;
	}
	
	

}
