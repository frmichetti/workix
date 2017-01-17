package br.com.codecode.workix.jpa;

import java.util.Calendar;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2016-11-28T19:39:43.190-0200")
@StaticMetamodel(Experience.class)
public class Experience_ {
	public static volatile SingularAttribute<Experience, String> employerName;
	public static volatile SingularAttribute<Experience, String> jobTitle;
	public static volatile SingularAttribute<Experience, Calendar> startDate;
	public static volatile SingularAttribute<Experience, Calendar> endDate;
	public static volatile SingularAttribute<Experience, String> description;
}
