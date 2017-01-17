package br.com.codecode.workix.jpa;

import java.util.Calendar;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2016-11-28T19:39:43.187-0200")
@StaticMetamodel(Candidate.class)
public class Candidate_ {
	public static volatile SingularAttribute<Candidate, Long> id;
	public static volatile SingularAttribute<Candidate, Long> cpf;
	public static volatile SingularAttribute<Candidate, Calendar> birthDate;
	public static volatile SingularAttribute<Candidate, String> name;
	public static volatile SingularAttribute<Candidate, User> user;
	public static volatile SingularAttribute<Candidate, Contact> contact;
	public static volatile SingularAttribute<Candidate, Locale> locale;
}
