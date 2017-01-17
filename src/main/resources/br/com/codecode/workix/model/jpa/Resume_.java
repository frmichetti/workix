package br.com.codecode.workix.model.jpa;

import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2016-11-23T14:41:08.454-0200")
@StaticMetamodel(Resume.class)
public class Resume_ extends MyEntity_ {
	public static volatile SingularAttribute<Resume, Candidate> candidate;
	public static volatile SingularAttribute<Resume, String> objective;
	public static volatile SingularAttribute<Resume, String> content;
	public static volatile SetAttribute<Resume, Experience> experiences;
	public static volatile SetAttribute<Resume, Education> educations;
	public static volatile SetAttribute<Resume, Skill> skills;
}
