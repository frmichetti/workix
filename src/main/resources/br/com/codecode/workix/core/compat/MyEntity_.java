package br.com.codecode.workix.core.compat;

import java.time.LocalDateTime;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2016-12-03T21:34:01.977-0200")
@StaticMetamodel(MyEntity.class)
public class MyEntity_ {
	public static volatile SingularAttribute<MyEntity, Integer> version;
	public static volatile SingularAttribute<MyEntity, LocalDateTime> createdAt;
	public static volatile SingularAttribute<MyEntity, LocalDateTime> updatedAt;
	public static volatile SingularAttribute<MyEntity, String> uuid;
}
