package br.com.codecode.workix.model.jpa;

import java.util.Calendar;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2016-11-23T14:41:08.450-0200")
@StaticMetamodel(Education.class)
public class Education_ {
	public static volatile SingularAttribute<Education, String> schoolName;
	public static volatile SingularAttribute<Education, Calendar> startDate;
	public static volatile SingularAttribute<Education, Calendar> endDate;
	public static volatile SingularAttribute<Education, String> qualification;
	public static volatile SingularAttribute<Education, String> description;
}
