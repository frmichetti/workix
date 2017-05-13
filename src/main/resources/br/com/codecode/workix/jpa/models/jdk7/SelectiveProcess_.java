package br.com.codecode.workix.jpa.models.jdk7;

import java.time.LocalDateTime;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2017-02-23T10:19:18.375-0300")
@StaticMetamodel(SelectiveProcess.class)
public class SelectiveProcess_ {
	public static volatile SingularAttribute<SelectiveProcess, Boolean> active;
	public static volatile SetAttribute<SelectiveProcess, Candidate> candidates;
	public static volatile SingularAttribute<SelectiveProcess, LocalDateTime> createdAt;
	public static volatile SingularAttribute<SelectiveProcess, LocalDateTime> disabledAt;
	public static volatile SingularAttribute<SelectiveProcess, LocalDateTime> expire;
	public static volatile SingularAttribute<SelectiveProcess, Long> id;
	public static volatile SingularAttribute<SelectiveProcess, Job> job;
	public static volatile SingularAttribute<SelectiveProcess, Integer> maxCandidates;
	public static volatile SingularAttribute<SelectiveProcess, LocalDateTime> start;
	public static volatile SingularAttribute<SelectiveProcess, LocalDateTime> updatedAt;
	public static volatile SingularAttribute<SelectiveProcess, String> uuid;
	public static volatile SingularAttribute<SelectiveProcess, Integer> version;
}
