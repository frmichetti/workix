package br.com.codecode.workix.jpa;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2016-11-28T19:39:43.189-0200")
@StaticMetamodel(Company.class)
public class Company_ {
	public static volatile SingularAttribute<Company, Long> id;
	public static volatile SingularAttribute<Company, Long> cnpj;
	public static volatile SingularAttribute<Company, String> segment;
	public static volatile SingularAttribute<Company, String> name;
	public static volatile SingularAttribute<Company, User> user;
	public static volatile SingularAttribute<Company, Contact> contact;
	public static volatile SingularAttribute<Company, Locale> locale;
}
