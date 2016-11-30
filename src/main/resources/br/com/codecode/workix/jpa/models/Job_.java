package br.com.codecode.workix.jpa.models;

import br.com.codecode.workix.model.enums.JobCategory;
import br.com.codecode.workix.model.enums.JobType;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2016-11-29T22:47:21.051-0200")
@StaticMetamodel(Job.class)
public class Job_ extends MyEntity_ {
	public static volatile SingularAttribute<Job, Long> id;
	public static volatile SingularAttribute<Job, String> title;
	public static volatile SingularAttribute<Job, BigDecimal> minPayment;
	public static volatile SingularAttribute<Job, BigDecimal> maxPayment;
	public static volatile SingularAttribute<Job, String> description;
	public static volatile SingularAttribute<Job, String> requirement;
	public static volatile SingularAttribute<Job, String> benefits;
	public static volatile SingularAttribute<Job, JobType> type;
	public static volatile SingularAttribute<Job, JobCategory> category;
	public static volatile SingularAttribute<Job, Boolean> active;
	public static volatile SingularAttribute<Job, Company> employeer;
}
