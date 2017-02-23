package br.com.codecode.workix.jpa.models.jdk8;

import br.com.codecode.workix.core.enums.BlogCategory;
import java.time.LocalDate;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2017-02-23T11:00:58.058-0300")
@StaticMetamodel(Blog.class)
public class Blog_ extends MyEntity_ {
	public static volatile SingularAttribute<Blog, Author> author;
	public static volatile SingularAttribute<Blog, BlogCategory> category;
	public static volatile SingularAttribute<Blog, String> citation;
	public static volatile SingularAttribute<Blog, String> content;
	public static volatile SingularAttribute<Blog, LocalDate> date;
	public static volatile SingularAttribute<Blog, Long> id;
	public static volatile ListAttribute<Blog, String> pictures;
	public static volatile SingularAttribute<Blog, String> resume;
	public static volatile ListAttribute<Blog, Tag> tags;
	public static volatile SingularAttribute<Blog, String> title;
}
