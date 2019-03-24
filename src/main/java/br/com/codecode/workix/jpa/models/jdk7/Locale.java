package br.com.codecode.workix.jpa.models.jdk7;

import br.com.codecode.workix.core.enums.Estate;
import br.com.codecode.workix.interfaces.Buildable;

import java.io.Serializable;

/**
 * Locale JPA Embeddable
 * No Anotation for Compatibility Only with Older Versions
 *
 * @author felipe
 * @version 1.1
 * @see Serializable
 * @since 1.0
 */
public class Locale implements Serializable {

    private static final long serialVersionUID = -607806075186010186L;

    private String city;

    private Estate estate;

    private String neighborhood;

    private String number;

    private String street;

    private long zipCode;

    /**
     * Public Default Constructor for JPA Compatibility Only
     */
    public Locale() {
    }

    /**
     * Public Constructor for {@link Builder} Compatibility
     *
     * @param builder Builder for Generate a New Locale
     * @see Buildable
     */
    public Locale(Builder builder) {
        this.zipCode = builder.getZipCode();
        this.city = builder.getCity();
        this.neighborhood = builder.getNeighborhood();
        this.street = builder.getStreet();
        this.number = builder.getNumber();
        this.estate = builder.getEstate();
    }

    /**
     * Creates builder to build {@link Locale}.
     *
     * @return created builder
     */
    public static Builder builder() {
        return new Builder();
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Estate getEstate() {
        return estate;
    }

    public void setEstate(Estate estate) {
        this.estate = estate;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public long getZipCode() {
        return zipCode;
    }

    public void setZipCode(long zipCode) {
        this.zipCode = zipCode;
    }

    @Override
    public String toString() {
        return new StringBuilder()
                .append(city)
                .append(", ")
                .append(estate)
                .toString();
    }

    /**
     * Builder NestedClass for {@link Locale}
     *
     * @author felipe
     * @see Buildable
     * @see Locale
     */
    public static class Builder extends Locale implements Buildable<Locale> {

        private static final long serialVersionUID = -9170730109070112523L;

        /**
         * Disabled Empty Constructor
         */
        private Builder() {
        }

        /**
         * @return Return a new Locale
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


}
