package br.com.codecode.workix.model.pojo;

public interface BaseCompany extends BasePerson {

	String getCnpj();

	void setCnpj(String cnpj);

	String getSegment();

	void setSegment(String companySegment);
}
