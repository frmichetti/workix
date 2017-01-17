package br.com.codecode.workix.jpa.models;

import java.time.LocalDate;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2016-11-29T22:47:21.051-0200")
@StaticMetamodel(Experience.class)
public class Experience_ {
	public static volatile SingularAttribute<Experience, String> employerName;
	public static volatile SingularAttribute<Experience, String> jobTitle;
	public static volatile SingularAttribute<Experience, LocalDate> startDate;
	public static volatile SingularAttribute<Experience, LocalDate> endDate;
	public static volatile SingularAttribute<Experience, String> description;
}
