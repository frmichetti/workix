package br.com.codecode.workix.model.jpa;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2016-11-23T14:41:08.455-0200")
@StaticMetamodel(User.class)
public class User_ extends MyEntity_ {
	public static volatile SingularAttribute<User, Boolean> active;
	public static volatile SingularAttribute<User, String> email;
	public static volatile SingularAttribute<User, String> firebaseUUID;
	public static volatile SingularAttribute<User, String> firebaseMessageToken;
}
