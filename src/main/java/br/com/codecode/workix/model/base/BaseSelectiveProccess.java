package br.com.codecode.workix.model.base;

import java.sql.Timestamp;
import java.util.Observable;
import java.util.Set;

import br.com.codecode.workix.model.actions.CandidateActions;
import br.com.codecode.workix.model.actions.JobActions;

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
 * 
 * @author felipe
 * @since 1.0
 * @version 1.0
 * @see Observable
 */
public abstract class BaseSelectiveProccess extends Observable {

    protected long id;

    protected int version;

    protected String uuid;

    protected Timestamp createdAt;

    protected Timestamp updatedAt;

    protected JobActions job;

    protected Set<CandidateActions> candidates;

    protected boolean active;

    protected Timestamp disabledAt;

    protected int maxCandidates;

}
