package br.com.codecode.workix.model.base;

/**
 * Markup Interface for Company Implementation
 * @author felipe
 * @since 1.0
 * @version 1.0
 */
public interface BaseCompany extends BasePerson {

	long getCnpj();

	void setCnpj(long cnpj);

	String getSegment();

	void setSegment(String companySegment);
}
