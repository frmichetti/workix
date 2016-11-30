package br.com.codecode.workix.model.actions;

import br.com.codecode.workix.jpa.enums.Estate;

/**
 * Markup Interface for Locale Implementation
 * 
 * @author felipe
 * @since 1.0
 * @version 1.0
 */
public interface LocaleActions {

    long getZipCode();

    void setZipCode(long zipCode);

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
