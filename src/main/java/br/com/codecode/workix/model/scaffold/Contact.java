package br.com.codecode.workix.model.scaffold;

import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import com.google.gson.annotations.Expose;

@Embeddable
public class Contact {
	
	@Expose
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