package br.com.codecode.workix.core.models.compat;

import java.io.Serializable;

import br.com.codecode.workix.core.enums.Estate;
import javax.annotation.Generated;

// TODO: Auto-generated Javadoc
/**
 * Locale Class for Compatibility<br>
 * Without Annotations.
 *
 * @author felipe
 * @version 1.1
 * @see Serializable
 * @since 1.1
 */
public class Locale implements Serializable {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /** The city. */
    private String city;

    /** The estate. */
    private Estate estate;

    /** The neighborhood. */
    private String neighborhood;

    /** The number. */
    private String number;

    /** The street. */
    private String street;

    /** The zip code. */
    private long zipCode;

    @Generated("SparkTools")
    private Locale(Builder builder) {
	this.city = builder.city;
	this.estate = builder.estate;
	this.neighborhood = builder.neighborhood;
	this.number = builder.number;
	this.street = builder.street;
	this.zipCode = builder.zipCode;
    }

    /**
     * Public Default Constructor.
     */
    public Locale(){}    

    /**
     * Gets the city.
     *
     * @return the city
     */
    public String getCity() {
	return city;
    }

    /**
     * Gets the estate.
     *
     * @return the estate
     */
    public Estate getEstate() {
	return estate;
    }

    /**
     * Gets the neighborhood.
     *
     * @return the neighborhood
     */
    public String getNeighborhood() {
	return neighborhood;
    }

    /**
     * Gets the number.
     *
     * @return the number
     */
    public String getNumber() {
	return number;
    }

    /**
     * Gets the street.
     *
     * @return the street
     */
    public String getStreet() {
	return street;
    }

    /**
     * Gets the zip code.
     *
     * @return the zip code
     */
    public long getZipCode() {
	return zipCode;
    }

    /**
     * Sets the city.
     *
     * @param city the new city
     */
    public void setCity(String city) {
	this.city = city;
    }

    /**
     * Sets the estate.
     *
     * @param estate the new estate
     */
    public void setEstate(Estate estate) {
	this.estate = estate;
    }

    /**
     * Sets the neighborhood.
     *
     * @param neighborhood the new neighborhood
     */
    public void setNeighborhood(String neighborhood) {
	this.neighborhood = neighborhood;
    }

    /**
     * Sets the number.
     *
     * @param number the new number
     */
    public void setNumber(String number) {
	this.number = number;
    }

    /**
     * Sets the street.
     *
     * @param street the new street
     */
    public void setStreet(String street) {
	this.street = street;
    }

    /**
     * Sets the zip code.
     *
     * @param zipCode the new zip code
     */
    public void setZipCode(long zipCode) {
	this.zipCode = zipCode;
    }

    /**
     * Creates builder to build {@link Locale}.
     * @return created builder
     */
    @Generated("SparkTools")
    public static Builder builder() {

	return new Builder();
    }

    /**
     * Builder to build {@link Locale}.
     */
    @Generated("SparkTools")
    public static final class Builder {

	private String city;

	private Estate estate;

	private String neighborhood;

	private String number;

	private String street;

	private long zipCode;

	private Builder() {
	}

	public Builder withCity(String city) {

	    this.city = city;
	    return this;
	}

	public Builder withEstate(Estate estate) {

	    this.estate = estate;
	    return this;
	}

	public Builder withNeighborhood(String neighborhood) {

	    this.neighborhood = neighborhood;
	    return this;
	}

	public Builder withNumber(String number) {

	    this.number = number;
	    return this;
	}

	public Builder withStreet(String street) {

	    this.street = street;
	    return this;
	}

	public Builder withZipCode(long zipCode) {

	    this.zipCode = zipCode;
	    return this;
	}

	public Locale build() {

	    return new Locale(this);
	}
    }    

}
