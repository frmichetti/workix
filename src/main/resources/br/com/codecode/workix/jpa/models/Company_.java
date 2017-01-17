package br.com.codecode.workix.jpa.models;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2016-11-29T22:47:21.050-0200")
@StaticMetamodel(Company.class)
public class Company_ extends Person_ {
	public static volatile SingularAttribute<Company, Long> id;
	public static volatile SingularAttribute<Company, Long> cnpj;
	public static volatile SingularAttribute<Company, String> segment;
}
