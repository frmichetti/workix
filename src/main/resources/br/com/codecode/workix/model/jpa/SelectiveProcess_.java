package br.com.codecode.workix.model.jpa;

import java.sql.Timestamp;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2016-11-23T14:41:08.454-0200")
@StaticMetamodel(SelectiveProcess.class)
public class SelectiveProcess_ {
	public static volatile SingularAttribute<SelectiveProcess, Long> id;
	public static volatile SingularAttribute<SelectiveProcess, Integer> version;
	public static volatile SingularAttribute<SelectiveProcess, String> uuid;
	public static volatile SingularAttribute<SelectiveProcess, Timestamp> createdAt;
	public static volatile SingularAttribute<SelectiveProcess, Timestamp> updatedAt;
	public static volatile SingularAttribute<SelectiveProcess, Job> job;
	public static volatile SetAttribute<SelectiveProcess, Candidate> candidates;
	public static volatile SingularAttribute<SelectiveProcess, Boolean> active;
	public static volatile SingularAttribute<SelectiveProcess, Timestamp> disabledAt;
	public static volatile SingularAttribute<SelectiveProcess, Integer> maxCandidates;
}
