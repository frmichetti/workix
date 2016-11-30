package br.com.codecode.workix.model.base;

import br.com.codecode.workix.jpa.enums.Estate;

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
 * 
 * @author felipe
 * @since 1.0
 * @version 1.0
 */
public abstract class BaseLocale {

    private long zipCode;

    private String city;

    private String neighborhood;

    private String street;

    private String number;

    private Estate estate;

    /**
     * Public Default Constructor
     */
    public BaseLocale() {
    }

    /**
     * @return the zipCode
     */
    public long getZipCode() {
	return zipCode;
    }

    /**
     * @param zipCode
     *            the zipCode to set
     */
    public void setZipCode(long zipCode) {
	this.zipCode = zipCode;
    }

    /**
     * @return the city
     */
    public String getCity() {
	return city;
    }

    /**
     * @param city
     *            the city to set
     */
    public void setCity(String city) {
	this.city = city;
    }

    /**
     * @return the neighborhood
     */
    public String getNeighborhood() {
	return neighborhood;
    }

    /**
     * @param neighborhood
     *            the neighborhood to set
     */
    public void setNeighborhood(String neighborhood) {
	this.neighborhood = neighborhood;
    }

    /**
     * @return the street
     */
    public String getStreet() {
	return street;
    }

    /**
     * @param street
     *            the street to set
     */
    public void setStreet(String street) {
	this.street = street;
    }

    /**
     * @return the number
     */
    public String getNumber() {
	return number;
    }

    /**
     * @param number
     *            the number to set
     */
    public void setNumber(String number) {
	this.number = number;
    }

    /**
     * @return the estate
     */
    public Estate getEstate() {
	return estate;
    }

    /**
     * @param estate
     *            the estate to set
     */
    public void setEstate(Estate estate) {
	this.estate = estate;
    }

}
