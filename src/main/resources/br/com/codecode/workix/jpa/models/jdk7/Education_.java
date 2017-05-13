package br.com.codecode.workix.jpa.models.jdk7;

import java.time.LocalDate;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2017-02-23T10:19:18.370-0300")
@StaticMetamodel(Education.class)
public class Education_ {
	public static volatile SingularAttribute<Education, String> description;
	public static volatile SingularAttribute<Education, LocalDate> endDate;
	public static volatile SingularAttribute<Education, String> qualification;
	public static volatile SingularAttribute<Education, String> schoolName;
	public static volatile SingularAttribute<Education, LocalDate> startDate;
}
