package br.com.codecode.workix.model.jpa;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2016-11-23T14:41:08.454-0200")
@StaticMetamodel(Person.class)
public class Person_ extends MyEntity_ {
	public static volatile SingularAttribute<Person, String> name;
	public static volatile SingularAttribute<Person, User> user;
	public static volatile SingularAttribute<Person, Contact> contact;
	public static volatile SingularAttribute<Person, Locale> locale;
}
