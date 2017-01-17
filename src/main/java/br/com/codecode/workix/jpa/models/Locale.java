package br.com.codecode.workix.jpa.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import br.com.codecode.workix.cdi.qualifiers.Persist;
import br.com.codecode.workix.core.enums.Estate;

import br.com.codecode.workix.interfaces.Buildable;

/**
 * Locale JPA with Inherited Fields and Methods
 * 
 * @author felipe
 * @see LocaleActions
 * @see Serializable
 * @since 1.0
 * @version 1.1
 */
@Embeddable
@XmlRootElement
@XmlAccessorType(XmlAccessType.PUBLIC_MEMBER)
@Persist
public class Locale implements Serializable {

    /**
     * Builder NestedClass for {@link Locale}
     * 
     * @author felipe
     * @see Buildable
     * @see BaseLocale
     */
    public static class Builder extends Locale implements Buildable<Locale> {

	private static final long serialVersionUID = -9170730109070112523L;

	/**
	 * Disabled Empty Constructor
	 */
	private Builder() {
	}

	/**
	 * Constructor with All Fields
	 * 
	 * @param zipCode
	 *            Zip Code
	 * @param estate
	 *            estate
	 * @param city
	 *            City
	 * @param neighborhood
	 *            Neighborhood
	 * @param street
	 *            Street
	 * @param number
	 *            Number of House
	 */
	public Builder(long zipCode, Estate estate, String city, String neighborhood, String street, String number) {
	    this(zipCode, number);
	    super.setEstate(estate);
	    super.setStreet(street);
	    super.setNeighborhood(neighborhood);
	    super.setCity(city);
	}

	/**
	 * Constructor with Required Fields
	 * 
	 * @param zipCode
	 *            Zip Code
	 * @param number
	 *            Number of House
	 */
	public Builder(long zipCode, String number) {
	    this();
	    this.setZipCode(zipCode);
	    this.setNumber(number);
	}

	/**
	 * @return Return a New Locale
	 */
	@Override
	public Locale build() {
	    return new Locale(this);
	}

	public Builder withCity(String city) {
	    this.setCity(city);
	    return this;
	}

	public Builder withEstate(Estate estate) {
	    this.setEstate(estate);
	    return this;
	}

	public Builder withNeighborhood(String neighborhood) {
	    this.setNeighborhood(neighborhood);
	    return this;
	}

	public Builder withNumber(String number) {
	    this.setNumber(number);
	    return this;
	}

	public Builder withStreet(String street) {
	    this.setStreet(street);
	    return this;
	}

	public Builder withZipCode(long zipCode) {
	    this.setZipCode(zipCode);
	    return this;
	}

    }

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
     * Public Default Constructor for JPA Compatibility Only
     */
    public Locale() {
    }

    /**
     * Public Constructor for {@link Builder} Compatibility
     * 
     * @see Buildable
     * @param builder
     *            Builder for Generate a New Locale
     */
    public Locale(Builder builder) {

	this.zipCode = builder.getZipCode();

	this.city = builder.getCity();

	this.neighborhood = builder.getNeighborhood();

	this.street = builder.getStreet();

	this.number = builder.getNumber();

	this.estate = builder.getEstate();
    }

    public String getCity() {
	return city;
    }

    public Estate getEstate() {
	return estate;
    }

    public String getNeighborhood() {
	return neighborhood;
    }

    public String getNumber() {
	return number;
    }

    public String getStreet() {
	return street;
    }

    public long getZipCode() {
	return zipCode;
    }

    public void setCity(String city) {
	this.city = city;
    }

    public void setEstate(Estate estate) {
	this.estate = estate;
    }

    public void setNeighborhood(String neighborhood) {
	this.neighborhood = neighborhood;
    }

    public void setNumber(String number) {
	this.number = number;
    }

    public void setStreet(String street) {
	this.street = street;
    }

    public void setZipCode(long zipCode) {
	this.zipCode = zipCode;
    }

}
