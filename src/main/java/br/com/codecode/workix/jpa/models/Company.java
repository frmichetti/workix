package br.com.codecode.workix.jpa.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import br.com.codecode.workix.cdi.qualifiers.Persist;
import br.com.codecode.workix.core.models.jdk8.actions.CompanyActions;

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
@Persist
public class Company extends Person {

    private static final long serialVersionUID = 47663377480544994L;
    
    private long id, cnpj;

    private String segment;

    /**
     * Public Default Constructor for JPA Compatibility Only
     */
    public Company(){}

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

}