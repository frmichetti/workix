package br.com.codecode.workix.jpa.models;

import java.time.LocalDate;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2017-02-17T00:42:06.035-0200")
@StaticMetamodel(Blog.class)
public class Blog_ extends MyEntity_ {
	public static volatile SingularAttribute<Blog, Long> id;
	public static volatile SingularAttribute<Blog, LocalDate> date;
	public static volatile SingularAttribute<Blog, BlogCategory> blogCategory;
	public static volatile SingularAttribute<Blog, String> title;
}
