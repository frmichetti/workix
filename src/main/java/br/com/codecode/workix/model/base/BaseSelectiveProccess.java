package br.com.codecode.workix.model.base;

import java.time.LocalDateTime;
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
 * @version 1.1
 * @see Observable
 */
public abstract class BaseSelectiveProccess extends Observable {

    protected long id;

    protected int version;

    protected String uuid;

    protected LocalDateTime createdAt;

    protected LocalDateTime updatedAt;

    protected JobActions job;

    protected Set<CandidateActions> candidates;

    protected boolean active;

    protected LocalDateTime disabledAt;

    protected int maxCandidates;

}
