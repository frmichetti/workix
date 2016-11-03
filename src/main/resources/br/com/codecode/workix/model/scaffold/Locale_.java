package br.com.codecode.workix.model.scaffold;

import br.com.codecode.workix.model.enums.Estate;
import java.math.BigInteger;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2016-11-02T01:20:13.931-0200")
@StaticMetamodel(Locale.class)
public class Locale_ {
	public static volatile SingularAttribute<Locale, BigInteger> zipCode;
	public static volatile SingularAttribute<Locale, String> city;
	public static volatile SingularAttribute<Locale, String> neighborhood;
	public static volatile SingularAttribute<Locale, String> street;
	public static volatile SingularAttribute<Locale, String> number;
	public static volatile SingularAttribute<Locale, Estate> estate;
}
