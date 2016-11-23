package br.com.codecode.workix.model.base;

/**
 * Markup Interface for Company Implementation
 * @author felipe
 *
 */
public interface BaseCompany extends BasePerson {

	Number getCnpj();

	void setCnpj(Number cnpj);

	String getSegment();

	void setSegment(String companySegment);
}
