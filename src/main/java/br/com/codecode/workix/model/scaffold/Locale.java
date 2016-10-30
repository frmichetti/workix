package br.com.codecode.workix.model.scaffold;

import java.io.Serializable;
import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import com.google.gson.annotations.Expose;

@Embeddable
public class Locale implements Serializable {

	private static final long serialVersionUID = -607806075186010186L;

	@Expose	
	@Column
	private BigInteger zipCode;
	
	@Expose	
	@Column
	private String city;
	
	@Expose	
	@Column
	private String neighborhood;
	
	@Expose
	@Column
	private String street;
	
	@Expose
	@Column
	private String number;
	
	public Locale(){}

	public BigInteger getZipCode() {
		return zipCode;
	}

	public void setZipCode(BigInteger zipCode) {
		this.zipCode = zipCode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getNeighborhood() {
		return neighborhood;
	}

	public void setNeighborhood(String neighborhood) {
		this.neighborhood = neighborhood;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}
	
	
	
	

}
