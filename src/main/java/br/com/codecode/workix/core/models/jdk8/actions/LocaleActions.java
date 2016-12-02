package br.com.codecode.workix.core.models.jdk8.actions;

import br.com.codecode.workix.core.models.enums.Estate;

/**
 * Markup Interface for Locale Implementation
 * 
 * @author felipe
 * @since 1.0
 * @version 1.0
 */
public interface LocaleActions {

    /**
     * @return the City
     */
    String getCity();
    
    /**
     * @return the Estate
     */
    Estate getEstate();

    /**
     * @return the Neighborhood
     */
    String getNeighborhood();

    /**
     * @return the Number of House
     */
    String getNumber();

    /**
     * @return the Street
     */
    String getStreet();

    /**
     * @return the Zip Code
     */
    long getZipCode();

    /**
     * @param city define the City
     */
    void setCity(String city);

    /**
     * @param estate define the Estate
     */
    void setEstate(Estate estate);

    /**
     * @param neighborhood define the Neighborhood
     */
    void setNeighborhood(String neighborhood);

    /**
     * @param number define the Number of House
     */
    void setNumber(String number);

    /**
     * @param street define the Street
     */
    void setStreet(String street);

    /**
     * @param zipCode define the Zip Code
     */
    void setZipCode(long zipCode);

}
