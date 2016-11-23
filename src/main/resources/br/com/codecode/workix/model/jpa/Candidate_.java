package br.com.codecode.workix.model.jpa;

import java.util.Calendar;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2016-11-23T14:41:08.447-0200")
@StaticMetamodel(Candidate.class)
public class Candidate_ extends Person_ {
	public static volatile SingularAttribute<Candidate, String> cpf;
	public static volatile SingularAttribute<Candidate, Calendar> birthDate;
}
