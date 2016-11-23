package br.com.codecode.workix.model.jpa;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2016-11-23T14:41:08.449-0200")
@StaticMetamodel(Company.class)
public class Company_ extends Person_ {
	public static volatile SingularAttribute<Company, String> cnpj;
	public static volatile SingularAttribute<Company, String> segment;
}
