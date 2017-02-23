package br.com.codecode.workix.jpa.models.jdk8;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2017-02-23T11:00:58.058-0300")
@StaticMetamodel(Comment.class)
public class Comment_ extends MyEntity_ {
	public static volatile SingularAttribute<Comment, Blog> blog;
	public static volatile SingularAttribute<Comment, String> email;
	public static volatile SingularAttribute<Comment, Long> id;
	public static volatile SingularAttribute<Comment, String> name;
	public static volatile SingularAttribute<Comment, String> text;
}
