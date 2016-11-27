package br.com.codecode.workix.model.jpa;

import javax.persistence.Column;

import br.com.codecode.workix.model.base.BaseCompany;

/**
 * Company JPA with Inherited Fields and Methods
 * @see Person
 * @author felipe 
 * @see BaseCompany
 * @since 1.0
 * @version 1.1
 */
public class Company extends Person implements BaseCompany {

	private static final long serialVersionUID = 47663377480544994L;
	
	@Column(nullable = false, unique = true)
	private long cnpj;

	@Column(nullable = false)
	private String segment;	

	/**
	 * Public Default Constructor for JPA Compatibility Only
	 */
	public Company(){}

	@Override
	public long getCnpj() {
		return cnpj;
	}

	@Override
	public void setCnpj(long cnpj) {
		this.cnpj = cnpj;
	}

	@Override
	public String getSegment() {
		return segment;
	}

	@Override
	public void setSegment(String companySegment) {
		this.segment = companySegment;
	}
	

}