package br.com.codecode.workix.jpa.models;

import java.time.LocalDate;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2016-11-29T22:47:21.048-0200")
@StaticMetamodel(Candidate.class)
public class Candidate_ extends Person_ {
	public static volatile SingularAttribute<Candidate, Long> id;
	public static volatile SingularAttribute<Candidate, Long> cpf;
	public static volatile SingularAttribute<Candidate, LocalDate> birthDate;
}
