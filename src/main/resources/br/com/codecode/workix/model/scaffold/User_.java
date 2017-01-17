package br.com.codecode.workix.model.scaffold;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2016-11-02T01:20:13.943-0200")
@StaticMetamodel(User.class)
public class User_ extends Loggable_ {
	public static volatile SingularAttribute<User, Long> id;
	public static volatile SingularAttribute<User, Boolean> active;
	public static volatile SingularAttribute<User, String> email;
	public static volatile SingularAttribute<User, String> firebaseUUID;
	public static volatile SingularAttribute<User, String> firebaseMessageToken;
}
