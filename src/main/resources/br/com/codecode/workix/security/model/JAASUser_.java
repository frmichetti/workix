package br.com.codecode.workix.security.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2016-11-29T18:34:11.261-0200")
@StaticMetamodel(JAASUser.class)
public class JAASUser_ extends JAASBase_ {
	public static volatile SingularAttribute<JAASUser, String> login;
	public static volatile SingularAttribute<JAASUser, String> password;
	public static volatile SetAttribute<JAASUser, JAASRole> roles;
}
