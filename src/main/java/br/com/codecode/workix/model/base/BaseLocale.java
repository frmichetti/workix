package br.com.codecode.workix.model.base;

import java.math.BigInteger;

import br.com.codecode.workix.model.enums.Estate;

/**
 * Markup Interface for Locale Implementation
 * @author felipe
 *
 */
public interface BaseLocale {

	BigInteger getZipCode();

	void setZipCode(BigInteger zipCode);

	String getCity();

	void setCity(String city);

	String getNeighborhood();

	void setNeighborhood(String neighborhood);

	String getStreet();

	void setStreet(String street);

	String getNumber();

	void setNumber(String number);

	Estate getEstate();

	void setEstate(Estate estate);


}
