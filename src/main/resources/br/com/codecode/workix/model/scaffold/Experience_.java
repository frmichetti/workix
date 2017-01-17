package br.com.codecode.workix.model.scaffold;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2016-11-02T01:20:13.928-0200")
@StaticMetamodel(Experience.class)
public class Experience_ {
	public static volatile SingularAttribute<Experience, String> employerName;
	public static volatile SingularAttribute<Experience, String> jobTitle;
	public static volatile SingularAttribute<Experience, Date> startDate;
	public static volatile SingularAttribute<Experience, Date> endDate;
	public static volatile SingularAttribute<Experience, String> description;
}
