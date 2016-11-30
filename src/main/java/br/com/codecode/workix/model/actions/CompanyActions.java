package br.com.codecode.workix.model.actions;

/**
 * Markup Interface for Company Implementation
 * 
 * @author felipe
 * @since 1.0
 * @version 1.0
 */
public interface CompanyActions extends PersonActions {

    long getCnpj();

    void setCnpj(long cnpj);

    String getSegment();

    void setSegment(String companySegment);
}
