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

    String getCity();

    Estate getEstate();

    String getNeighborhood();

    String getNumber();

    String getStreet();

    long getZipCode();

    void setCity(String city);

    void setEstate(Estate estate);

    void setNeighborhood(String neighborhood);

    void setNumber(String number);

    void setStreet(String street);

    void setZipCode(long zipCode);

}
