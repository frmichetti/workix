package br.com.codecode.workix.model.scaffold;

import java.io.Serializable;

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
 * @see Serializable
 * @since 1.1
 * @version 1.1
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@Embeddable
abstract class Locale implements Serializable {

	private static final long serialVersionUID = -607806075186010186L;

	@Column
	private long zipCode;

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

	/**
	 * @return the zipCode
	 */
	public final long getZipCode() {
		return zipCode;
	}

	/**
	 * @param zipCode the zipCode to set
	 */
	public final void setZipCode(long zipCode) {
		this.zipCode = zipCode;
	}

	/**
	 * @return the city
	 */
	public final String getCity() {
		return city;
	}

	/**
	 * @param city the city to set
	 */
	public final void setCity(String city) {
		this.city = city;
	}

	/**
	 * @return the neighborhood
	 */
	public final String getNeighborhood() {
		return neighborhood;
	}

	/**
	 * @param neighborhood the neighborhood to set
	 */
	public final void setNeighborhood(String neighborhood) {
		this.neighborhood = neighborhood;
	}

	/**
	 * @return the street
	 */
	public final String getStreet() {
		return street;
	}

	/**
	 * @param street the street to set
	 */
	public final void setStreet(String street) {
		this.street = street;
	}

	/**
	 * @return the number
	 */
	public final String getNumber() {
		return number;
	}

	/**
	 * @param number the number to set
	 */
	public final void setNumber(String number) {
		this.number = number;
	}

	/**
	 * @return the estate
	 */
	public final Estate getEstate() {
		return estate;
	}

	/**
	 * @param estate the estate to set
	 */
	public final void setEstate(Estate estate) {
		this.estate = estate;
	}
	
	
	
}
