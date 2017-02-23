package br.com.codecode.workix.jpa.models.compat;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2017-02-23T10:19:18.363-0300")
@StaticMetamodel(Author.class)
public class Author_ extends MyEntity_ {
	public static volatile SingularAttribute<Author, String> aboutText;
	public static volatile SingularAttribute<Author, Long> id;
	public static volatile ListAttribute<Author, SocialMedia> medias;
	public static volatile SingularAttribute<Author, String> name;
	public static volatile SingularAttribute<Author, String> picture;
}
