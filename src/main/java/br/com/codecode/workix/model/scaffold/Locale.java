package br.com.codecode.workix.model.scaffold;

import java.math.BigInteger;

import javax.persistence.Embeddable;

import com.google.gson.annotations.Expose;

@Embeddable
public class Locale {
	
	@Expose
	private BigInteger zipCode;
	
	@Expose
	private String city;
	
	@Expose
	private String neighborhood;
	
	@Expose
	private String street;
	
	@Expose
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
