package br.com.codecode.workix.jpa.models.jdk8;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2017-02-23T11:00:58.063-0300")
@StaticMetamodel(Testimonial.class)
public class Testimonial_ extends MyEntity_ {
	public static volatile SingularAttribute<Testimonial, Author> author;
	public static volatile SingularAttribute<Testimonial, Long> id;
	public static volatile SingularAttribute<Testimonial, String> picture;
	public static volatile SingularAttribute<Testimonial, String> signature;
	public static volatile SingularAttribute<Testimonial, String> text;
}
