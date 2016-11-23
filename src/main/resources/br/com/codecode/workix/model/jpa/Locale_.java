package br.com.codecode.workix.model.jpa;

import br.com.codecode.workix.model.enums.Estate;
import java.math.BigInteger;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2016-11-23T14:41:08.453-0200")
@StaticMetamodel(Locale.class)
public class Locale_ {
	public static volatile SingularAttribute<Locale, BigInteger> zipCode;
	public static volatile SingularAttribute<Locale, String> city;
	public static volatile SingularAttribute<Locale, String> neighborhood;
	public static volatile SingularAttribute<Locale, String> street;
	public static volatile SingularAttribute<Locale, String> number;
	public static volatile SingularAttribute<Locale, Estate> estate;
}
