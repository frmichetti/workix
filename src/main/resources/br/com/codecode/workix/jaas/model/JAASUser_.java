package br.com.codecode.workix.jaas.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2017-02-20T11:42:31.767-0300")
@StaticMetamodel(JAASUser.class)
public class JAASUser_ {
	public static volatile SingularAttribute<JAASUser, String> login;
	public static volatile SingularAttribute<JAASUser, String> password;
	public static volatile SetAttribute<JAASUser, JAASRole> roles;
}
