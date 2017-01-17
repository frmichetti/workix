package br.com.codecode.workix.jpa.models;

import java.time.LocalDate;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2016-11-29T22:47:21.050-0200")
@StaticMetamodel(Education.class)
public class Education_ {
	public static volatile SingularAttribute<Education, String> schoolName;
	public static volatile SingularAttribute<Education, LocalDate> startDate;
	public static volatile SingularAttribute<Education, LocalDate> endDate;
	public static volatile SingularAttribute<Education, String> qualification;
	public static volatile SingularAttribute<Education, String> description;
}
