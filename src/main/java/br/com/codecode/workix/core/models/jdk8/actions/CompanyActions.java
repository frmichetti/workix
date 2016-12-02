package br.com.codecode.workix.core.models.jdk8.actions;

/**
 * Markup Interface for Company Implementation
 * 
 * @author felipe
 * @since 1.0
 * @version 1.0
 * @see PersonActions
 */
public interface CompanyActions extends PersonActions {

    long getCnpj();

    String getSegment();

    void setCnpj(long cnpj);

    void setSegment(String companySegment);
}
