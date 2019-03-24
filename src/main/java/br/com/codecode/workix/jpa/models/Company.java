package br.com.codecode.workix.jpa.models;

import br.com.codecode.workix.cdi.qualifiers.Persist;
import br.com.codecode.workix.interfaces.Buildable;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * Company JPA with Inherited Fields and Methods
 * No Anotation for Compatibility Only with Older Versions
 *
 * @author felipe
 * @version 1.1
 * @see Person
 * @since 1.0
 */
@Entity
@Table(name = "companies")
@XmlRootElement
@XmlAccessorType()
@Persist
public class Company extends Person {

    private static final long serialVersionUID = 47663377480544994L;

    private String description;

    private long id, cnpj;

    private String segment;

    /**
     * Public Default Constructor for JPA Compatibility Only
     */
    public Company() {
    }

    /**
     * Public Constructor for {@link Builder} Compatibility
     *
     * @param builder Builder for Generate a New Company
     * @see Buildable
     */
    private Company(Builder builder) {
        this.cnpj = builder.getCnpj();
        this.segment = builder.getSegment();
        this.setName(builder.getName());
        this.setContact(builder.getContact());
        this.setLocale(builder.getLocale());
        this.setUser(builder.getUser());
    }

    /**
     * Creates builder to build {@link Company}.
     *
     * @return created builder
     */
    @XmlTransient
    public static Builder builder() {
        return new Builder();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (!(obj instanceof Company))
            return false;
        Company other = (Company) obj;
        return id == other.id;
    }

    @Column(nullable = false, unique = true)
    public long getCnpj() {
        return cnpj;
    }

    public void setCnpj(long cnpj) {
        this.cnpj = cnpj;
    }

    /**
     * @return the description
     */
    @Column
    @Lob
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(updatable = false, nullable = false)
    @Override
    public long getId() {
        return this.id;
    }

    @Override
    public void setId(long id) {
        this.id = id;
    }

    @Column(nullable = false)
    public String getSegment() {
        return segment;
    }

    public void setSegment(String companySegment) {
        this.segment = companySegment;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (id ^ (id >>> 32));
        return result;
    }

    /**
     * Builder to build {@link Company}.
     */
    public static final class Builder extends Company implements Buildable<Company> {

        private static final long serialVersionUID = -2850736800336558944L;

        /**
         * Disabled Empty Constructor
         */
        private Builder() {
        }

        /**
         * @return a new Company
         */
        @Override
        public Company build() {
            return new Company(this);
        }

        public Builder withCnpj(long cnpj) {
            super.cnpj = cnpj;
            return this;
        }

        public Builder withContact(Contact contact) {
            super.setContact(contact);
            return this;
        }

        public Builder withDescription(String description) {
            super.description = description;
            return this;
        }

        public Builder withLocale(Locale locale) {
            super.setLocale(locale);
            return this;
        }

        public Builder withName(String name) {
            super.setName(name);
            return this;
        }

        public Builder withSegment(String segment) {
            super.segment = segment;
            return this;
        }

        public Builder withUser(User user) {
            super.setUser(user);
            return this;
        }
    }

}