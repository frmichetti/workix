package br.com.codecode.workix.jpa.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import br.com.codecode.workix.cdi.qualifiers.Persist;
import br.com.codecode.workix.interfaces.Buildable;

/**
 * Company JPA with Inherited Fields and Methods 
 * @see Person
 * @author felipe
 * @since 1.0
 * @version 1.1
 */
@Entity
@XmlRootElement
@XmlAccessorType(XmlAccessType.PUBLIC_MEMBER)
@Persist
public class Company extends Person {

    private static final long serialVersionUID = 47663377480544994L;
    
    private long id, cnpj;

    private String segment;
    
    /**
     * Public Default Constructor for JPA Compatibility Only
     */
    public Company(){}

    private Company(Builder builder) {
	this.id = builder.getId();
	this.cnpj = builder.getCnpj();
	this.segment = builder.getSegment();
    }

    /**
     * Creates builder to build {@link Company}.
     * @return created builder
     */
    @XmlTransient
    public static Builder builder() {
	return new Builder();
    }

    @Column(nullable = false, unique = true)
    public long getCnpj() {
	return cnpj;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false)
    @Override
    public long getId() {
	return this.id;
    }

    @Column(nullable = false)
    public String getSegment() {
	return segment;
    }

    public void setCnpj(long cnpj) {
	this.cnpj = cnpj;
    }

    @Override
    public void setId(long id) {
	this.id = id;
    }

    public void setSegment(String companySegment) {
	this.segment = companySegment;
    }

    /**
     * Builder to build {@link Company}.
     */    
    public static final class Builder extends Company implements Buildable<Company> {
	
	/**
	 * @serialField
	 */
	private static final long serialVersionUID = -2850736800336558944L;

	private Builder() {}

	@Override
	public Company build() {
	    return new Company(this);
	}
	
	public Builder withCnpj(long cnpj) {
	    super.cnpj = cnpj;
	    return this;
	}
	
	public Builder withContact(Contact contact) {
	    this.setContact(contact);
	    return this;
	}
	
	public Builder withId(long id) {
	    super.id = id;
	    return this;
	}
	
	public Builder withLocale(Locale locale) {
	    this.setLocale(locale);
	    return this;
	}

	public Builder withName(String name) {
	    this.setName(name);
	    return this;
	}

	public Builder withSegment(String segment) {
	    super.segment = segment;
	    return this;
	}

	public Builder withUser(User user) {
	    this.setUser(user);
	    return this;
	}
    }

}