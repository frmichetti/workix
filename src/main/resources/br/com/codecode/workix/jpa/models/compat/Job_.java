package br.com.codecode.workix.jpa.models.compat;

import br.com.codecode.workix.core.enums.JobCategory;
import br.com.codecode.workix.core.enums.JobType;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2017-02-23T10:19:18.372-0300")
@StaticMetamodel(Job.class)
public class Job_ extends MyEntity_ {
	public static volatile SingularAttribute<Job, String> benefits;
	public static volatile SingularAttribute<Job, Company> company;
	public static volatile SingularAttribute<Job, String> description;
	public static volatile SingularAttribute<Job, Long> id;
	public static volatile SingularAttribute<Job, JobCategory> jobCategory;
	public static volatile SingularAttribute<Job, JobType> jobType;
	public static volatile SingularAttribute<Job, BigDecimal> maxPayment;
	public static volatile SingularAttribute<Job, BigDecimal> minPayment;
	public static volatile SingularAttribute<Job, String> requirement;
	public static volatile SingularAttribute<Job, String> title;
	public static volatile SingularAttribute<Job, Boolean> active;
}
