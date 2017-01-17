package br.com.codecode.workix.model.scaffold;

import java.sql.Timestamp;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2016-11-23T00:10:15.154-0200")
@StaticMetamodel(MyEntity.class)
public class MyEntity_ {
	public static volatile SingularAttribute<MyEntity, Long> id;
	public static volatile SingularAttribute<MyEntity, Integer> version;
	public static volatile SingularAttribute<MyEntity, Timestamp> createdAt;
	public static volatile SingularAttribute<MyEntity, Timestamp> updatedAt;
	public static volatile SingularAttribute<MyEntity, String> uuid;
}
