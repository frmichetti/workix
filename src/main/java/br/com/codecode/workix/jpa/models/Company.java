package br.com.codecode.workix.jpa.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import br.com.codecode.workix.model.actions.CompanyActions;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Company JPA with Inherited Fields and Methods
 * 
 * @see Person
 * @author felipe
 * @see CompanyActions
 * @since 1.0
 * @version 1.1
 */
@Entity
@XmlRootElement
@XmlAccessorType(XmlAccessType.PUBLIC_MEMBER)
public class Company extends Person {

    private static final long serialVersionUID = 47663377480544994L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false)
    private long id;

    @Column(nullable = false, unique = true)
    private long cnpj;

    @Column(nullable = false)
    private String segment;

    /**
     * Public Default Constructor for JPA Compatibility Only
     */
    public Company() {
    }

    public long getCnpj() {
	return cnpj;
    }

    @Override
    public long getId() {
	return this.id;
    }

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

}