package br.com.codecode.workix.core.models.compat;

/**
 * Company JPA with Inherited Fields and Methods
 * <br>Without Annotations
 * @see Person
 * @author felipe
 * @since 1.1
 * @version 1.1
 */
public class Company extends Person {

    private static final long serialVersionUID = 47663377480544994L;
    
    private long id, cnpj;

    private String segment;

    /**
     * Public Default Constructor for JPA Compatibility Only
     */
    public Company(){}

    public long getCnpj() {
	return cnpj;
    }

    public long getId() {
	return this.id;
    }

    public String getSegment() {
	return segment;
    }

    public void setCnpj(long cnpj) {
	this.cnpj = cnpj;
    }

    public void setId(long id) {
	this.id = id;
    }

    public void setSegment(String companySegment) {
	this.segment = companySegment;
    }

}