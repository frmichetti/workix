package br.com.codecode.workix.model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2016-11-19T17:35:50.010-0200")
@StaticMetamodel(Loggable.class)
public class Loggable_ {
	public static volatile SingularAttribute<Loggable, Integer> version;
	public static volatile SingularAttribute<Loggable, Date> createdAt;
	public static volatile SingularAttribute<Loggable, Date> updatedAt;
	public static volatile SingularAttribute<Loggable, String> uuid;
}
