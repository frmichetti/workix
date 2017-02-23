package br.com.codecode.workix.jpa.models.jdk8;

import br.com.codecode.workix.core.enums.Estate;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2017-02-23T11:00:58.060-0300")
@StaticMetamodel(Locale.class)
public class Locale_ {
	public static volatile SingularAttribute<Locale, String> city;
	public static volatile SingularAttribute<Locale, Estate> estate;
	public static volatile SingularAttribute<Locale, String> neighborhood;
	public static volatile SingularAttribute<Locale, String> number;
	public static volatile SingularAttribute<Locale, String> street;
	public static volatile SingularAttribute<Locale, Long> zipCode;
}
