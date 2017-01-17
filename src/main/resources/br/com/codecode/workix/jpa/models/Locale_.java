package br.com.codecode.workix.jpa.models;

import br.com.codecode.workix.model.enums.Estate;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2016-11-29T22:47:21.052-0200")
@StaticMetamodel(Locale.class)
public class Locale_ {
	public static volatile SingularAttribute<Locale, Long> zipCode;
	public static volatile SingularAttribute<Locale, String> city;
	public static volatile SingularAttribute<Locale, String> neighborhood;
	public static volatile SingularAttribute<Locale, String> street;
	public static volatile SingularAttribute<Locale, String> number;
	public static volatile SingularAttribute<Locale, Estate> estate;
}
