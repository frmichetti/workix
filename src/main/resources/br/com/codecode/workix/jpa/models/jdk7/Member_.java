package br.com.codecode.workix.jpa.models.jdk7;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2017-02-23T10:19:18.373-0300")
@StaticMetamodel(Member.class)
public class Member_ extends MyEntity_ {
	public static volatile SingularAttribute<Member, Long> id;
	public static volatile ListAttribute<Member, SocialMedia> medias;
	public static volatile SingularAttribute<Member, String> name;
	public static volatile SingularAttribute<Member, String> occupation;
	public static volatile SingularAttribute<Member, String> picture;
	public static volatile SingularAttribute<Member, String> shortText;
}
