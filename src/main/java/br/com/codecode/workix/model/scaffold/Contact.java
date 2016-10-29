package br.com.codecode.workix.model.scaffold;

import java.math.BigInteger;

import javax.persistence.Embeddable;

@Embeddable
public class Contact {
	
	private BigInteger mobilePhone;
	
	public Contact(){}

	public BigInteger getMobilePhone() {
		return mobilePhone;
	}

	public void setMobilePhone(BigInteger mobilePhone) {
		this.mobilePhone = mobilePhone;
	}
	
	

}
