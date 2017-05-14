package br.com.codecode.workix.jpa.models.jdk8;

import br.com.codecode.workix.jpa.models.jdk7.Contact;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2017-02-23T11:00:58.061-0300")
@StaticMetamodel(Person.class)
public class Person_ extends MyEntity_ {
	public static volatile SingularAttribute<Person, Contact> contact;
	public static volatile SingularAttribute<Person, Locale> locale;
	public static volatile SingularAttribute<Person, String> name;
	public static volatile SingularAttribute<Person, User> user;
}
