package br.com.codecode.workix.jpa.models.jdk8;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2017-02-23T11:00:58.063-0300")
@StaticMetamodel(User.class)
public class User_ extends MyEntity_ {
	public static volatile SingularAttribute<User, String> email;
	public static volatile SingularAttribute<User, String> firebaseMessageToken;
	public static volatile SingularAttribute<User, String> firebaseUUID;
	public static volatile SingularAttribute<User, Long> id;
	public static volatile SingularAttribute<User, Boolean> active;
}