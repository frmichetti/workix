package br.com.codecode.workix.jpa.models.jdk7;

import java.time.LocalDateTime;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2017-02-23T10:19:18.373-0300")
@StaticMetamodel(MyEntity.class)
public class MyEntity_ {
	public static volatile SingularAttribute<MyEntity, LocalDateTime> createdAt;
	public static volatile SingularAttribute<MyEntity, LocalDateTime> updatedAt;
	public static volatile SingularAttribute<MyEntity, String> uuid;
	public static volatile SingularAttribute<MyEntity, Integer> version;
}
