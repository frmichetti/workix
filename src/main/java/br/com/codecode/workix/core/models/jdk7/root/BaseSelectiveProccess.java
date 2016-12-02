package br.com.codecode.workix.core.models.jdk7.root;

import java.util.Calendar;
import java.util.Observable;
import java.util.Observer;
import java.util.Set;

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
 * @since 1.1
 * @version 1.0
 * @see Observable
 * @see Observer
 */
public abstract class BaseSelectiveProccess extends Observable implements Observer{

    /**
     * Id Field
     */
    protected long id;

    /**
     * Version Field
     */
    protected int version;

    /**
     * UUID Field
     */
    protected String uuid;

    /**
     * Created at Field
     */
    protected Calendar createdAt;

    /**
     * Updated at Field
     */
    protected Calendar updatedAt;

    /**
     * Job Field
     */
    protected BaseJob job;

    /**
     * Candidates of Selective Processes Field
     */
    protected Set<BaseCandidate> candidates;
    /**
     * Active Field
     */
    protected boolean active;

    /**
     * Disabled at Field
     */
    protected Calendar disabledAt;

    /**
     * Max number of Candidates Field
     */
    protected int maxCandidates;

}
