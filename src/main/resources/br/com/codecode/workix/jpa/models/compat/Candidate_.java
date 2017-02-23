package br.com.codecode.workix.jpa.models.compat;

import java.time.LocalDate;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2017-02-23T10:19:18.366-0300")
@StaticMetamodel(Candidate.class)
public class Candidate_ extends Person_ {
	public static volatile SingularAttribute<Candidate, LocalDate> birthDate;
	public static volatile SingularAttribute<Candidate, Long> cpf;
	public static volatile SingularAttribute<Candidate, Long> id;
}
