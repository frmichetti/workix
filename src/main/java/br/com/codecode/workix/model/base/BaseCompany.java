package br.com.codecode.workix.model.base;

/**
 * Markup Interface for Company Implementation
 * @author felipe
 *
 */
public interface BaseCompany extends BasePerson {

	long getCnpj();

	void setCnpj(long cnpj);

	String getSegment();

	void setSegment(String companySegment);
}
