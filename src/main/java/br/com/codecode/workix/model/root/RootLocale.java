package br.com.codecode.workix.model.root;

import br.com.codecode.workix.model.enums.Estate;

/**
 * Root Abstract Class Locale<br>
 * Use for Field Mapping/Share Only
 * <ul>
 * <li>{@link #zipCode}</li>
 * <li>{@link #city}</li>
 * <li>{@link #neighborhood}</li>
 * <li>{@link #street}</li>
 * <li>{@link #number}</li>
 * <li>{@link #estate}</li>
 * </ul>
 * @author felipe
 * @since 1.0
 * @version 1.0
 */
public abstract class RootLocale {

	private long zipCode;

	private String city;

	private String neighborhood;

	private String street;

	private String number;

	private Estate estate;	
	
	/**
	 * Public Default Constructor
	 */
	public RootLocale(){}

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
