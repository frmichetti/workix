package br.com.codecode.workix.model.jpa;

import java.io.Serializable;
import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import br.com.codecode.workix.model.enums.Estate;

/**
 * Locale JPA {@link Embeddable}  
 * @author felipe
 * @category JPA
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@Embeddable
public class Locale implements Serializable {

	private static final long serialVersionUID = -607806075186010186L;

	@Column
	private BigInteger zipCode;

	@Column
	private String city;

	@Column
	private String neighborhood;

	@Column
	private String street;

	@Column
	private String number;

	@Enumerated(EnumType.STRING)
	@Column
	private Estate estate;

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

	public Estate getEstate() {
		return estate;
	}

	public void setEstate(Estate estate) {
		this.estate = estate;
	}		

}
