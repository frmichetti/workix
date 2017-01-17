package br.com.codecode.workix.jpa;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2016-11-29T21:08:12.364-0200")
@StaticMetamodel(SelectiveProcess.class)
public class SelectiveProcess_ {
	public static volatile SingularAttribute<SelectiveProcess, Long> id;
	public static volatile SingularAttribute<SelectiveProcess, Integer> version;
	public static volatile SingularAttribute<SelectiveProcess, String> uuid;
	public static volatile SingularAttribute<SelectiveProcess, LocalDateTime> createdAt;
	public static volatile SingularAttribute<SelectiveProcess, LocalDateTime> updatedAt;
	public static volatile SingularAttribute<SelectiveProcess, Job> job;
	public static volatile SetAttribute<SelectiveProcess, Candidate> candidates;
	public static volatile SingularAttribute<SelectiveProcess, Boolean> active;
	public static volatile SingularAttribute<SelectiveProcess, Timestamp> disabledAt;
	public static volatile SingularAttribute<SelectiveProcess, Integer> maxCandidates;
}
