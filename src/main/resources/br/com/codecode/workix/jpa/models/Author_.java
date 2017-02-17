package br.com.codecode.workix.jpa.models;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2017-02-16T21:26:18.747-0200")
@StaticMetamodel(Author.class)
public class Author_ extends MyEntity_ {
	public static volatile SingularAttribute<Author, String> name;
	public static volatile SingularAttribute<Author, String> aboutText;
	public static volatile SingularAttribute<Author, Object> medias;
	public static volatile SingularAttribute<Author, String> picture;
	public static volatile SingularAttribute<Author, Long> id;
}
