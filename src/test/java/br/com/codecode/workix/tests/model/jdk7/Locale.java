package br.com.codecode.workix.tests.model.jdk7;

import br.com.codecode.workix.core.enums.Estate;
import br.com.codecode.workix.core.models.jdk7.root.BaseLocale;


public final class Locale extends BaseLocale {

    @Override
    public String getCity() {	
	return super.city;
    }

    @Override
    public Estate getEstate() {	
	return super.estate;
    }

    @Override
    public String getNeighborhood() {	
	return super.neighborhood;
    }

    @Override
    public String getNumber() {	
	return super.number;
    }

    @Override
    public String getStreet() {	
	return super.street;
    }

    @Override
    public long getZipCode() {	
	return super.zipCode;
    }

    @Override
    public void setCity(String city) {
	super.city = city;
    }

    @Override
    public void setEstate(Estate estate) {
	super.estate = estate;
    }

    @Override
    public void setNeighborhood(String neighborhood) {
	super.neighborhood = neighborhood;
    }

    @Override
    public void setNumber(String number) {
	super.number = number;
    }

    @Override
    public void setStreet(String street) {
	super.street = street;
    }

    @Override
    public void setZipCode(long zipCode) {
	super.zipCode = zipCode;
    }

}
