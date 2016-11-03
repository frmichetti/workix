package br.com.codecode.workix.model.scaffold;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2016-11-02T01:20:13.866-0200")
@StaticMetamodel(Candidate.class)
public class Candidate_ extends Person_ {
	public static volatile SingularAttribute<Candidate, Long> id;
	public static volatile SingularAttribute<Candidate, String> cpf;
	public static volatile SingularAttribute<Candidate, Date> birthDate;
}
