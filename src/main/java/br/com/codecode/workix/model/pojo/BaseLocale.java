package br.com.codecode.workix.model.pojo;

import java.math.BigInteger;

import br.com.codecode.workix.model.enums.Estate;

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
