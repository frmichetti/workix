package br.com.codecode.workix.model.root;

import java.sql.Timestamp;
import java.util.Observable;
import java.util.Set;

import br.com.codecode.workix.model.base.BaseCandidate;
import br.com.codecode.workix.model.jpa.Job;

/**
 * Root Abstract Class Selective Proccess<br>
 * Use for Field Mapping/Share Only
 * <ul>
 * <li>{@link #id}</li>
 * <li>{@link #version}</li>
 * <li>{@link #uuid}</li>
 * <li>{@link #createdAt}</li> 
 * <li>{@link #updatedAt}</li>
 * <li>{@link #job}</li>
 * <li>{@link #candidates}</li>
 * <li>{@link #active}</li>
 * <li>{@link #disabledAt}</li>
 * <li>{@link #maxCandidates}</li>  
 * </ul>
 * @author felipe
 * @since 1.0
 * @version 1.0
 */
public abstract class RootSelectiveProccess extends Observable {
	
	protected long id;

	protected int version;

	protected String uuid;

	protected Timestamp createdAt;

	protected Timestamp updatedAt;

	protected Job job;	

	protected Set<BaseCandidate> candidates;

	protected boolean active;	

	protected Timestamp disabledAt;

	protected int maxCandidates;


}
