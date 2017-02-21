package br.com.codecode.workix.jaas.models;

import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2017-02-21T13:25:12.978-0300")
@StaticMetamodel(JAASUser.class)
public class JAASUser_ extends JAASBase_ {
	public static volatile SingularAttribute<JAASUser, Long> id;
	public static volatile SingularAttribute<JAASUser, String> login;
	public static volatile SingularAttribute<JAASUser, String> password;
	public static volatile SetAttribute<JAASUser, JAASRole> roles;
}
